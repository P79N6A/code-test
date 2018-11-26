import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by siyunfei on 2018/11/22.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        List<Future> futureList = new ArrayList<Future>();
        futureList.add(ExecutorPools.poolExecutor.submit(new Callable<Integer>(){
            public Integer call() throws Exception {
                Thread.sleep(1000);
                System.out.println("future task run");
                return 4;
            }
        }));
        for (Future future : futureList) {
            //future.get(200L, TimeUnit.MILLISECONDS);
            System.out.println(future.get());
        }
        //ExecutorPools.poolExecutor.shutdown();
    }
}
