import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.TimeUnit;

/**
 * Created by siyunfei on 2018/11/6.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(new Test().monitorMemory());
            byte[] bytes = new byte[1024*1024*1024];
        }
    }

    private String monitorMemory() {

        StringBuilder sb = new StringBuilder("Memory:");

        MemoryMXBean mmbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage hmu = mmbean.getHeapMemoryUsage();
        sb.append("[HeapMemoryUsage:");
        sb.append(" Used=" + hmu.getUsed());
        sb.append(" Committed=" + hmu.getCommitted());
        sb.append("]");

        MemoryUsage nhmu = mmbean.getNonHeapMemoryUsage();
        sb.append("[NonHeapMemoryUsage:");
        sb.append(" Used=" + nhmu.getUsed());
        sb.append(" Committed=" + nhmu.getCommitted());
        sb.append("]");

        return sb.toString();
    }
}
