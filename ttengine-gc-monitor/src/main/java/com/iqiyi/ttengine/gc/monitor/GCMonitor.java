package com.iqiyi.ttengine.gc.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author siyunfei
 * 2018/12/1 下午9:12
 */
public class GCMonitor {

    private static final Logger logger = LoggerFactory.getLogger(GCMonitor.class);

    public static void startMonitoring() {
        if (checkIsCMS()) {
            GCMonitorThread.getInstance().start();
            logger.info("========your gc is under monitoring...========");
        }
    }

    private static boolean checkIsCMS() {
        Set<String> set = new HashSet<>();
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc : garbageCollectorMXBeans) {
            set.add(gc.getName());
        }
        if (!set.contains("ConcurrentMarkSweep")) {
            logger.info("========your gc is not CMS, cannot be monitored!========");
            return false;
        }
        return true;
    }

}
