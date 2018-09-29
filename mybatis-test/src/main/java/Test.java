import com.silocean.entity.Student;
import com.silocean.mapper.StudentMapper;
import com.silocean.utils.Utils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        SqlSession session = Utils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.insertStudent(new Student("3123", "kobe"));

        List<Student> students = mapper.findAll();
        //List<Student> students = session.selectList("findAll");
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}
