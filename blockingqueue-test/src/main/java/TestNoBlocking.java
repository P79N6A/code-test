import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by siyunfei on 2018/10/10.
 */
public class TestNoBlocking {
    static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        queue.add(2);
        queue.add(3);
        queue.add(4);
        new Consumer().start();
    }

    /**
     * 没有东西可消费的时候输出null
     */
    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(queue.poll());
            }
        }
    }
}
