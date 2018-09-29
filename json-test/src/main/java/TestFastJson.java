import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siyunfei
 * 2018/9/8 下午11:31
 */
public class TestFastJson {
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
        String json = JSON.toJSONString(school);
        System.out.println(json);
    }

    private static void parseToObject() {
        String json = "{\"name\":\"bjut\",\"students\":[{\"name\":\"ming\",\"number\":\"01\"},{\"name\":\"bai\",\"number\":\"02\"}]}";
        School school = JSON.parseObject(json, School.class);
        System.out.println(school);
    }
}
