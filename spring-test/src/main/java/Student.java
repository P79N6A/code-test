/**
 * Created by siyunfei on 2018/10/24.
 */
public class Student {
    private String name;

    public Student() {
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
}
