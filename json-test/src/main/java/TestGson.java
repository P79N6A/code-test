import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siyunfei
 * 2018/9/8 下午11:09
 */
public class TestGson {
    public static void main(String[] args) {
        parseToJson();
        parseToObject();
    }

    private static void parseToJson() {
        School school = new School();
        Student s1 = new Student("01", "ming");
        Student s2 = new Student("02", "bai");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        school.setName("bjut");
        school.setStudents(students);
        String json = new Gson().toJson(school);
        System.out.println(json);
    }

    private static void parseToObject() {
        String json = "{\"name\":\"bjut\",\"students\":[{\"number\":\"01\",\"name\":\"ming\"},{\"number\":\"02\",\"name\":\"bai\"}]}";
        School school = new Gson().fromJson(json, School.class);
        System.out.println(school);
    }
}
