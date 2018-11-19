package com.iqiyi.ttengine.gc.entity;

/**
 * Created by siyunfei on 2018/11/6.
 */
public class GCMetricResults {
    public static MetricResultNumber gcHeapUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcHeapSize = new MetricResultNumber(0);

    public static MetricResultNumber gcNonHeapUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcNonHeapSize = new MetricResultNumber(0);

    public static MetricResultNumber gcYgcCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcYgcTime = new MetricResultNumber(0);
    public static MetricResultNumber gcYgcCountsWithinOneMin = new MetricResultNumber(0);
    public static MetricResultNumber gcYgcAvgTimeWithinOneMin = new MetricResultNumber(0);

    public static MetricResultNumber gcCmsCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcCmsTime = new MetricResultNumber(0);
    public static MetricResultNumber gcCmsCountsWithinOneMin = new MetricResultNumber(0);
    public static MetricResultNumber gcCmsAvgTimeWithinOneMin = new MetricResultNumber(0);

    public static MetricResultNumber gcCodeCacheUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcCodeCacheSize = new MetricResultNumber(0);

    public static MetricResultNumber gcMetaspaceUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcMetaspaceSize = new MetricResultNumber(0);

    public static MetricResultNumber gcEdenUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcEdenSize = new MetricResultNumber(0);

    public static MetricResultNumber gcSurvivorUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcSurvivorSize = new MetricResultNumber(0);

    public static MetricResultNumber gcCmsOldGenUsed = new MetricResultNumber(0);
    public static MetricResultNumber gcCmsOldGenSize = new MetricResultNumber(0);

    public static MetricResultNumber gcLiveThreadCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcPeakThreadCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcDaemonThreadCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcTotalThreadCounts = new MetricResultNumber(0);

    public static MetricResultNumber gcLoadedClassCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcUnloadedClassCounts = new MetricResultNumber(0);
    public static MetricResultNumber gcTotalLoadedClassCounts = new MetricResultNumber(0);

}

