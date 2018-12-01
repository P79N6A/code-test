package com.iqiyi.ttengine.gc.monitor;

import com.codahale.metrics.Gauge;
import com.iqiyi.ttbrain.log.metric.GraphiteMetricFactory;
import com.iqiyi.ttengine.gc.entity.MetricResultNumber;
import com.iqiyi.ttengine.gc.entity.GCMetricEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by siyunfei on 2018/11/6.
 */
public class GCGraphiteMetricFactory extends GraphiteMetricFactory {

    private static Logger logger = LoggerFactory.getLogger(GCGraphiteMetricFactory.class);

    private static Map<String, MetricResultNumber> metricResultNumberMap = new HashMap<>();

    static {
        for (GCMetricEnum value : GCMetricEnum.values()) {
            metricResultNumberMap.put(value.getGaugeName(), value.getMetricResultNumber());
        }
    }

    public static void buildGaugeMetrics(final String gaugeName) {
        getMetrics().register(gaugeName, new Gauge<Double>() {
            @Override
            public Double getValue() {
                MetricResultNumber number = metricResultNumberMap.get(gaugeName);
                return number.getValue();
            }
        });
    }

}
