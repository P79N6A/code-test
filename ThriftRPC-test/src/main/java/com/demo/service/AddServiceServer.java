package com.demo.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

public class AddServiceServer {
    public static void main(String[] args) {
        try {
            System.out.println("server is started...");
            TProcessor tProcessor = new AddService.Processor<AddService.Iface>(new AddServiceImpl());
            TServerSocket serverSocket = new TServerSocket(9898);
            TServer.Args tArts = new TServer.Args(serverSocket);
            tArts.processor(tProcessor);
            tArts.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArts);
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
