import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: siyunfei
 * @date: 2018/8/16 20:20
 */
public class MetricsTest {
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        Timer timer = registry.timer(MetricRegistry.name(MetricsTest.class, "timer"));

        while (true) {
            Timer.Context ctx = timer.time();
            Thread.sleep(random.nextInt(1000));
            ctx.stop();
        }

    }


}
