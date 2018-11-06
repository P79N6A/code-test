import java.util.Timer;
import java.util.TimerTask;

/**
 * @author siyunfei
 * 2018/11/3 12:58 PM
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        timer.schedule(task, 3000);
        System.out.println("main");
    }
}
