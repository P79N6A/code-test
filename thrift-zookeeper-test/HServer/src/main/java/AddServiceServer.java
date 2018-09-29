import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import com.demo.service.AddService;
import org.apache.thrift.transport.TTransportException;
import org.apache.zookeeper.*;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.concurrent.CountDownLatch;

public class AddServiceServer {
    private static final int THRIFT_PORT = 9898;
    private static final int ZOOKEEPER_PORT = 2181;

    private static final String ZOOKEEPER_SERVER_IPS =
            "192.168.88.128:" + ZOOKEEPER_PORT + ",192.168.88.129:" + ZOOKEEPER_PORT + ",192.168.88.130:" + ZOOKEEPER_PORT;

    public static void main(String[] args) {
        try {
            AddServiceServer server = new AddServiceServer();
            server.registerToZookeeper();
            server.startAddServiceServer();
            System.out.println("waiting for client...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InetAddress getInetAddress() {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            return jdkSuppliedAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void registerToZookeeper() throws Exception {
        String ip = getInetAddress().getHostAddress();
        // System.out.println(ip);
        final CountDownLatch latch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_SERVER_IPS, 3000, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    latch.countDown();
                    System.out.println("zookeeper connected from AddServiceServer!");
                }
            }
        });
        latch.await();
        if (zooKeeper.exists("/addService", null) == null) {
            zooKeeper.create("/addService", "service data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        if (zooKeeper.exists("/addService/" + ip, null) == null) { // 注册临时节点，存储本机ip地址
            zooKeeper.create("/addService/" + ip, (ip + ":" + THRIFT_PORT).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } else {
            zooKeeper.setData("/addService/" + ip, (ip + ":" + THRIFT_PORT).getBytes(), -1);
        }
        System.out.println("已将本机ip注册为addService的子节点，存储的数据为：" +
                new String(zooKeeper.getData("/addService/" + ip, false, null)));
    }

    private void startAddServiceServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("addServiceServer is started...");
                TProcessor tProcessor = new AddService.Processor<AddService.Iface>(new AddServiceImpl());
                TServerSocket serverSocket = null;
                try {
                    serverSocket = new TServerSocket(THRIFT_PORT);
                } catch (TTransportException e) {
                    e.printStackTrace();
                }
                TServer.Args tArts = new TServer.Args(serverSocket);
                tArts.processor(tProcessor);
                tArts.protocolFactory(new TBinaryProtocol.Factory());
                TServer server = new TSimpleServer(tArts);
                server.serve();
            }
        }).start();
    }
}
