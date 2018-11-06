import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("quartz.xml");
        try {
            Thread.sleep(5000);
            System.out.println("main thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
