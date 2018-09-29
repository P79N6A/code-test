import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestJSON {
    public static void main(String[] args) {
        parseToJson();
        parseToObject();
    }

    private static void parseToJson() {
        JSONObject jo1 = new JSONObject();
        jo1.put("number", "01");
        jo1.put("name", "ming");
        JSONObject jo2 = new JSONObject();
        jo2.put("number", "02");
        jo2.put("name", "bai");
        JSONArray array = new JSONArray();
        array.put(jo1);
        array.put(jo2);
        JSONObject jo3 = new JSONObject();
        jo3.put("name", "bjut");
        jo3.put("students", array);
        String json = jo3.toString();
        System.out.println(json);
    }

    private static void parseToObject() {
        String json = "{\"students\":[{\"name\":\"ming\",\"number\":\"01\"},{\"name\":\"bai\",\"number\":\"02\"}],\"name\":\"bjut\"}";
        JSONObject object = new JSONObject(json);
        School school = new School();
        school.setName(object.get("name").toString());
        JSONArray jsonArray = object.getJSONArray("students");
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            Student student = new Student(o.getString("number"), o.getString("name"));
            students.add(student);
        }
        school.setStudents(students);
        System.out.println(school);
    }
}
