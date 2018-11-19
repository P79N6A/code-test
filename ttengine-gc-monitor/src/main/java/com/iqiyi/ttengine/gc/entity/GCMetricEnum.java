package com.iqiyi.ttengine.gc.entity;

public enum GCMetricEnum {
    GC_HEAP_USED("gc_heap_used", GCMetricResults.gcHeapUsed),
    GC_HEAP_SIZE("gc_heap_size", GCMetricResults.gcHeapSize),
    GC_NON_HEAP_USED("gc_non_heap_used", GCMetricResults.gcNonHeapUsed),
    GC_NON_HEAP_SIZE("gc_non_heap_size", GCMetricResults.gcNonHeapSize),

    GC_YGC_COUNT("gc_ygc_counts", GCMetricResults.gcYgcCounts),
    GC_YGC_TIME("gc_ygc_time", GCMetricResults.gcYgcTime),
    GC_YGC_COUNTS_WITHIN_ONE_MINUTE("gc_ygc_counts_within_one_minute", GCMetricResults.gcYgcCountsWithinOneMin),
    GC_YGC_AVG_TIME_WITHIN_ONE_MINUTE("gc_ygc_avg_time_within_one_minute", GCMetricResults.gcYgcAvgTimeWithinOneMin),

    GC_CMS_COUNT("gc_cms_counts", GCMetricResults.gcCmsCounts),
    GC_CMS_TIME("gc_cms_time", GCMetricResults.gcCmsTime),
    GC_CMS_COUNTS_WITHIN_ONE_MINUTE("gc_cms_counts_within_one_minute", GCMetricResults.gcCmsCountsWithinOneMin),
    GC_CMS_AVG_TIME_WITHIN_ONE_MINUTE("gc_cms_avg_time_within_one_minute", GCMetricResults.gcCmsAvgTimeWithinOneMin),

    GC_CODE_CACHE_USED("gc_code_cache_used", GCMetricResults.gcCodeCacheUsed),
    GC_CODE_CACHE_SIZE("gc_code_cache_size", GCMetricResults.gcCodeCacheSize),

    GC_METASPACE_USED("gc_metaspace_used", GCMetricResults.gcMetaspaceUsed),
    GC_METASPACE_SIZE("gc_metaspace_size", GCMetricResults.gcMetaspaceSize),

    GC_EDEN_USED("gc_eden_used", GCMetricResults.gcEdenUsed),
    GC_EDEN_SIZE("gc_eden_size", GCMetricResults.gcEdenSize),

    GC_SURVIVOR_USED("gc_survivor_used", GCMetricResults.gcSurvivorUsed),
    GC_SURVIVOR_SIZE("gc_survivor_size", GCMetricResults.gcSurvivorSize),

    GC_CMS_OLD_GEN_USED("gc_cms_old_gen_used", GCMetricResults.gcCmsOldGenUsed),
    GC_CMS_OLD_GEN_SIZE("gc_cms_old_gen_size", GCMetricResults.gcCmsOldGenSize),

    GC_LIVE_THREAD_COUNTS("gc_live_thread_counts", GCMetricResults.gcLiveThreadCounts),
    GC_PEAK_THREAD_COUNTS("gc_peak_thread_counts", GCMetricResults.gcPeakThreadCounts),
    GC_DAEMON_THREAD_COUNTS("gc_daemon_thread_counts", GCMetricResults.gcDaemonThreadCounts),
    GC_TOTAL_THREAD_COUNTS("gc_total_thread_counts", GCMetricResults.gcTotalThreadCounts),

    GC_LOADED_CLASS_COUNTS("gc_loaded_class_counts", GCMetricResults.gcLoadedClassCounts),
    GC_UNLOADED_CLASS_COUNTS("gc_unloaded_class_counts", GCMetricResults.gcUnloadedClassCounts),
    GC_TOTAL_LOADED_CLASS_COUNTS("gc_total_loaded_class_counts", GCMetricResults.gcTotalLoadedClassCounts);

    private String gaugeName;
    private MetricResultNumber metricResultNumber;

    private GCMetricEnum(String gaugeName, MetricResultNumber metricResultNumber) {
        this.gaugeName = gaugeName;
        this.metricResultNumber = metricResultNumber;
    }

    public MetricResultNumber getMetricResultNumber() {
        return metricResultNumber;
    }

    public void setMetricResultNumber(MetricResultNumber metricResultNumber) {
        this.metricResultNumber = metricResultNumber;
    }

    public String getGaugeName() {
        return gaugeName;
    }

    public void setGaugeName(String gaugeName) {
        this.gaugeName = gaugeName;
    }
}
