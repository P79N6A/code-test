package com.test.task;

import java.util.Date;

/**
 * 业务逻辑处理类
 */
public class Task {

    public void doTask() {
        Date date = new Date();
        System.out.println("execute task..." + date + ",,," + this.toString());
        try {
            Thread.sleep(10000);
            System.out.println("sleep well===" + date);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
