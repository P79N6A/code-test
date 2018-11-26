import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by siyunfei on 2018/11/22.
 */
public class ExecutorPools {
    private static ExecutorPools instance = new ExecutorPools();

    public static ExecutorPools getInstance() {
        return instance;
    }

    public static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 50, 30, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100),
            new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    return new Thread(r, "thread_pool" + r.hashCode());
                }
            }, new ThreadPoolExecutor.AbortPolicy());

    static {
        poolExecutor.prestartAllCoreThreads();
    }
}
