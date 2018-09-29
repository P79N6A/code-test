package com.demo.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class AddServiceClient {
    public static void main(String[] args) {
        try {
            System.out.println("client is started...");
            TTransport transport = new TSocket("localhost", 9898, 30000);
            TProtocol protocol = new TBinaryProtocol(transport);
            AddService.Client client = new AddService.Client(protocol);
            transport.open();
            int result = client.addNumbers(1, 2);
            //AddService.Iface ser = new AddServiceImpl();
            //int he = ser.addNumbers(33, 4);
            //System.out.println(he);
            System.out.println("服务器端计算结果为: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
