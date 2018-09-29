import com.demo.service.AddService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFileTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class AddServiceClient {
    private static final int ZOOKEEPER_PORT = 2181;
    private static final String ZOOKEEPER_SERVER_IPS =
            "192.168.88.128:" + ZOOKEEPER_PORT + ",192.168.88.129:" + ZOOKEEPER_PORT + ",192.168.88.130:" + ZOOKEEPER_PORT;

    public static void main(String[] args) {
        try {
            System.out.println("client started!");

            AddServiceClient client = new AddServiceClient();

            final CountDownLatch latch = new CountDownLatch(1);

            ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_SERVER_IPS, 3000, new Watcher() {
                public void process(WatchedEvent event) {
                    if(event.getState() == Event.KeeperState.SyncConnected){
                        latch.countDown();
                        System.out.println("zookeeper connected from AddServiceClient!");
                    }
                }
            });
            latch.await();

            List<String> children = zooKeeper.getChildren("/addService", null);
            if (children.size() != 0) {
                String child = children.get(new Random().nextInt(children.size())); // 选择任意一个子节点
                //for (String child : children) {
                String ip_port = new String(zooKeeper.getData("/addService/" + child, false, null));
                String ip = ip_port.split(":")[0];
                int port = Integer.parseInt(ip_port.split(":")[1]);
                client.sendRequest(ip, port);
                //}
            } else {
                System.out.println("no children of addService");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(String ip, int port) throws Exception {
        TTransport transport = new TSocket(ip, port, 30000);
        TProtocol protocol = new TBinaryProtocol(transport);
        AddService.Client client = new AddService.Client(protocol);
        transport.open();
        int result = client.addTwoNumbers(2, 3);
        System.out.println("计算结果为：" + result + ", 该数据从主机(" + ip + ")获取");
        transport.close();
    }

}
