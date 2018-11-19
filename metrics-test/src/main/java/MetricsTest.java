import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: siyunfei
 * @date: 2018/8/16 20:20
 */
public class MetricsTest {
    public static List<String> q = new LinkedList<String>();

    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);
        registry.register(MetricRegistry.name(MetricsTest.class, "queue", "size"),
                new Gauge<String>() {
                    public String getValue() {
                        return q.get(0);
                    }
                });
        while (true) {
            Thread.sleep(3000);
            q.add("Job-xxx");
        }

    }


}
