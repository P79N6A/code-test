package com.demo.service;

import org.apache.thrift.TException;

public class AddServiceImpl implements AddService.Iface {

    @Override
    public int addNumbers(int para1, int para2) throws TException {
        return para1 + para2;
    }
}
