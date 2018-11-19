import org.springframework.beans.factory.InitializingBean;

/**
 * Created by siyunfei on 2018/10/24.
 */
public class Student implements InitializingBean {
    private String name;

    public Student() {
        System.out.println("init=============");
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public void func(){
        System.out.println("this is a function");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("========================");
    }
}
