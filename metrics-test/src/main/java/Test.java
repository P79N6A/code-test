import java.util.concurrent.TimeUnit;

/**
 * Created by siyunfei on 2018/11/6.
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    print();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("main");
    }

    private static void print() {
        System.out.println("========");
        Count.gcHeapUsed.set(0, 34.9);
    }
}
