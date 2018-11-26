import java.util.Timer;
import java.util.TimerTask;


public class Test {
    private Timer timer = new Timer();

    public static void main(String[] args) {
        new Test().f();
    }

    public void f() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task==========");
                timer.cancel();
            }
        }, 3000);
    }
}
