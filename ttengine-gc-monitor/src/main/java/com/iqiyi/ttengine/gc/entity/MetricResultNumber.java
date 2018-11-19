package com.iqiyi.ttengine.gc.entity;

/**
 * Created by siyunfei on 2018/11/9.
 */
public class MetricResultNumber {
    private double value;

    public MetricResultNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
