import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by siyunfei on 2018/10/9.
 */
public class Test {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {

    }

    class Producer extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.offer(2);
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            
        }
    }
}
