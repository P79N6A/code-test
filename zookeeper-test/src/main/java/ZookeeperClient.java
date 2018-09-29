import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZookeeperClient implements Watcher {

    private CountDownLatch latch = new CountDownLatch(1);

    private ZooKeeper zookeeper;

    public static void main(String[] args) {
        try {
            /*ZookeeperClient client = new ZookeeperClient();
            client.connect();
            client.testAPI();
            client.close();*/
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
            final CuratorFramework cf = CuratorFrameworkFactory.builder()
                    .connectString("192.168.88.128:2181")
                    .sessionTimeoutMs(3000)
                    .retryPolicy(retryPolicy)
                    .build();
            // CuratorFramework cf = CuratorFrameworkFactory.newClient("192.168.88.128:2181", retryPolicy);
            cf.start();
            // cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/app/100/23", "hello".getBytes());
            /*ExecutorService pool = Executors.newCachedThreadPool();
            cf.getData().inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                    System.out.println("触发事件" + curatorEvent.getType());
                    System.out.println(new String(curatorEvent.getData()));
                }
            }, pool).forPath("/app/100/23");
            cf.setData().forPath("/app/100/23", "修改后的数据".getBytes());
            cf.setData().forPath("/app/100/23", "elollldff".getBytes());*/

            final NodeCache cache = new NodeCache(cf, "/app/100/23");
            cache.start();

            cache.getListenable().addListener(new NodeCacheListener() {
                public void nodeChanged() throws Exception {
                    System.out.println("data changed:" + new String(cache.getCurrentData().getData()));
                }
            });


            // cf.setData().forPath("/app/100/23","hello".getBytes());


            cf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testAPI() throws Exception {
        /*if (zookeeper.exists("/app", false) == null) {
            zookeeper.create("/app", "app data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(new String(zookeeper.getData("/app", false, null)));
        } else {
            zookeeper.setData("/app", "hello app data".getBytes(), -1);
            System.out.println(new String(zookeeper.getData("/app", false, null)));
            zookeeper.create("/app/child1", "child1Data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zookeeper.create("/app/child2", "child2Data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            List<String> children = zookeeper.getChildren("/app", null);
            if (children.size() != 0) {
                for (String child : children) {
                    System.out.println(child);
                }
            }
            zookeeper.delete("/app/child1", -1);
            zookeeper.delete("/app/child2", -1);
        }*/
        zookeeper.create("/app", "data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zookeeper.exists("/app", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Event.EventType.NodeCreated) {
                    System.out.println("/app node created!");
                }
            }
        });
    }

    private void connect() throws Exception {
        zookeeper = new ZooKeeper("192.168.88.128:2181", 3000, this);
        latch.await();
    }

    private void close() throws Exception {
        zookeeper.close();
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            latch.countDown();
            System.out.println("zookeeper connected!");
        }
    }
}
