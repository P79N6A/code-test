package com.iqiyi.ttengine.gc.monitor;

import com.iqiyi.ttengine.gc.entity.GCMetricEnum;
import com.iqiyi.ttengine.gc.entity.GCMetricResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by siyunfei on 2018/11/6.
 */
public class GCMonitor extends Thread {

    private static Logger logger = LoggerFactory.getLogger(GCMonitor.class);

    private static double ygcCountIndex = 0d;
    private static double ygcTimeIndex = 0d;
    private static double cmsCountIndex = 0d;
    private static double cmsTimeIndex = 0d;

    private GCMonitor() {
    }

    private static GCMonitor instance = new GCMonitor();

    public static GCMonitor getInstance() {
        return instance;
    }

    @Override
    public void run() {
        for (GCMetricEnum value : GCMetricEnum.values()) {
            GCGraphiteMetricFactory.buildGaugeMetrics(value.getGaugeName());
        }
        while (true) {
            monitorMemory();
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startMonitoring() {
        getInstance().start();
    }

    private static void monitorMemory() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        GCMetricResults.gcHeapUsed.setValue(parseByteToMib(usage.getUsed()));
        GCMetricResults.gcHeapSize.setValue(parseByteToMib(usage.getCommitted()));

        usage = memoryMXBean.getNonHeapMemoryUsage();
        GCMetricResults.gcNonHeapUsed.setValue(parseByteToMib(usage.getUsed()));
        GCMetricResults.gcNonHeapSize.setValue(parseByteToMib(usage.getCommitted()));

        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean p : memoryPoolMXBeans) {
            MemoryUsage u;
            switch (p.getName()) {
                case "Code Cache":
                    u = p.getUsage();
                    GCMetricResults.gcCodeCacheUsed.setValue(parseByteToMib(u.getUsed()));
                    GCMetricResults.gcCodeCacheSize.setValue(parseByteToMib(u.getCommitted()));
                    break;
                case "Metaspace":
                    u = p.getUsage();
                    GCMetricResults.gcMetaspaceUsed.setValue(parseByteToMib(u.getUsed()));
                    GCMetricResults.gcMetaspaceSize.setValue(parseByteToMib(u.getCommitted()));
                    break;
                case "Par Eden Space":
                    u = p.getUsage();
                    GCMetricResults.gcEdenUsed.setValue(parseByteToMib(u.getUsed()));
                    GCMetricResults.gcEdenSize.setValue(parseByteToMib(u.getCommitted()));
                    break;
                case "Par Survivor Space":
                    u = p.getUsage();
                    GCMetricResults.gcSurvivorUsed.setValue(parseByteToMib(u.getUsed()));
                    GCMetricResults.gcSurvivorSize.setValue(parseByteToMib(u.getCommitted()));
                    break;
                case "CMS Old Gen":
                    u = p.getUsage();
                    GCMetricResults.gcCmsOldGenUsed.setValue(parseByteToMib(u.getUsed()));
                    GCMetricResults.gcCmsOldGenSize.setValue(parseByteToMib(u.getCommitted()));
                    break;
            }
        }

        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc : garbageCollectorMXBeans) {
            switch (gc.getName()) {
                case "ParNew":
                    long ygcCounts = gc.getCollectionCount();
                    long ygcTime = gc.getCollectionTime();
                    GCMetricResults.gcYgcCounts.setValue(ygcCounts);
                    GCMetricResults.gcYgcTime.setValue(ygcTime);
                    GCMetricResults.gcYgcCountsWithinOneMin.setValue(ygcCounts - ygcCountIndex);
                    GCMetricResults.gcYgcAvgTimeWithinOneMin.setValue((ygcTime - ygcTimeIndex) / (ygcCounts - ygcCountIndex));
                    ygcCountIndex = ygcCounts;
                    ygcTimeIndex = ygcTime;
                    break;
                case "ConcurrentMarkSweep":
                    long cmsCounts = gc.getCollectionCount();
                    long cmsTime = gc.getCollectionTime();
                    GCMetricResults.gcCmsCounts.setValue(cmsCounts);
                    GCMetricResults.gcCmsTime.setValue(cmsTime);
                    GCMetricResults.gcCmsCountsWithinOneMin.setValue(cmsCounts - cmsCountIndex);
                    if (cmsCounts == cmsCountIndex) {
                        GCMetricResults.gcCmsAvgTimeWithinOneMin.setValue(0);
                    } else {
                        GCMetricResults.gcCmsAvgTimeWithinOneMin.setValue((cmsTime - cmsTimeIndex) / (cmsCounts - cmsCountIndex));
                    }
                    cmsCountIndex = cmsCounts;
                    cmsTimeIndex = cmsTime;
                    break;
            }
        }

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        GCMetricResults.gcLiveThreadCounts.setValue(threadMXBean.getThreadCount());
        GCMetricResults.gcPeakThreadCounts.setValue(threadMXBean.getPeakThreadCount());
        GCMetricResults.gcDaemonThreadCounts.setValue(threadMXBean.getDaemonThreadCount());
        GCMetricResults.gcTotalThreadCounts.setValue(threadMXBean.getTotalStartedThreadCount());

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        GCMetricResults.gcLoadedClassCounts.setValue(classLoadingMXBean.getLoadedClassCount());
        GCMetricResults.gcUnloadedClassCounts.setValue(classLoadingMXBean.getUnloadedClassCount());
        GCMetricResults.gcTotalLoadedClassCounts.setValue(classLoadingMXBean.getTotalLoadedClassCount());
    }

    private static double parseByteToMib(long data) {
        return (double) data / 1024 / 1024;
    }
}
