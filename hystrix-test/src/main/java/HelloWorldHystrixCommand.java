import com.netflix.hystrix.*;

/**
 * @author: siyunfei
 * @date: 2018/8/11 11:24
 */
public class HelloWorldHystrixCommand extends HystrixCommand<Student> {

    protected HelloWorldHystrixCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ttbrain_groups"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("ttbrain_3423_command"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ttbrain_c3423_threadpoolKey"))

                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withMaximumSize(50)
                        .withKeepAliveTimeMinutes(1)
                        .withMaxQueueSize(500))

                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        .withExecutionTimeoutInMilliseconds(10)
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(2000)));
    }

    @Override
    protected Student run() throws Exception {
        long start = System.currentTimeMillis();
        Student student = new Student("dfadf", "23");
        System.out.println(System.currentTimeMillis() - start);
        return student;
    }

    @Override
    protected Student getFallback() {
        return new Student("error", "-1");
    }

    public static void main(String[] args) {
        Student student = new HelloWorldHystrixCommand().execute();
        //System.out.println(Thread.currentThread().getName());
        /*for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    Student student = new HelloWorldHystrixCommand().execute();
                    System.out.println(student);
                }
            }).start();
        }*/
    }
}

class Student {

    private String name;
    private String no;

    public Student(String name, String no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}