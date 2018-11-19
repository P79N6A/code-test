import java.util.Timer;
import java.util.TimerTask;

/**
<<<<<<< HEAD
 * Created by siyunfei on 2018/11/5.
=======
 * @author siyunfei
 * 2018/11/3 12:58 PM
>>>>>>> 688633a0734ce3863f93709f3148a4bb60257803
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
<<<<<<< HEAD
        timer.schedule(new TimerTask() {
=======
        TimerTask task = new TimerTask() {
>>>>>>> 688633a0734ce3863f93709f3148a4bb60257803
            @Override
            public void run() {
                System.out.println("hello world");
            }
<<<<<<< HEAD
        }, 5000);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
=======
        };
        timer.schedule(task, 3000);
        System.out.println("main");
>>>>>>> 688633a0734ce3863f93709f3148a4bb60257803
    }
}
