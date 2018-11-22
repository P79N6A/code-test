import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by siyunfei on 2018/10/24.
 */
public class Main {
    private StudentService service;
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("application.xml");
        //Student student = (Student) context.getBean("student");
        //System.out.println(student);
        //new Main().f();
        Student student = (Student)SpringContextUtil.getBean("student");
        student.setName("siyunfei");
        Student student1 = (Student)SpringContextUtil.getBean("student");
        System.out.println(student + "," + student1);

        Student car = (Student)SpringContextUtil.getBean("car");
        System.out.println(car);
    }

    public void f() {
        service.printStudent();
    }
}
