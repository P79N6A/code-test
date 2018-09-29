import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: siyunfei
 * @date: 2018/8/11 11:24
 */
public class HelloWorldHystrixCommand extends HystrixCommand<Student> {

    protected HelloWorldHystrixCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    protected Student run() throws Exception {
        try {
            int a = 5 / 0;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("exception");
        }
        System.out.println(Thread.currentThread().getName());
        return new Student("xiaobai", "1212");
    }

    @Override
    protected Student getFallback() {
        return new Student("error", "-1");
    }

    public static void main(String[] args) {
        Student student = new HelloWorldHystrixCommand().execute();
        System.out.println(student);
        System.out.println(Thread.currentThread().getName());
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