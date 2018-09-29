import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.OMGVMCID;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author siyunfei
 * 2018/9/9 上午10:52
 */
public class TestJackson {
    public static void main(String[] args) throws IOException {
        parseToJson();
        parseToObject();
    }

    private static void parseToJson() throws JsonProcessingException {
        School school = new School();
        Student s1 = new Student("01", "ming");
        Student s2 = new Student("02", "bai");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        school.setName("bjut");
        school.setStudents(students);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(school);
        System.out.println(json);
    }

    private static void parseToObject() throws IOException {
        String json = "{\"name\":\"bjut\",\"students\":[{\"number\":\"01\",\"name\":\"ming\"},{\"number\":\"02\",\"name\":\"bai\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        School school = mapper.readValue(json, School.class);
        System.out.println(school);
    }
}
