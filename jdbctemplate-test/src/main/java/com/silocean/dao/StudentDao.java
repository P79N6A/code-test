package com.silocean.dao;

import com.silocean.entity.Student;
import com.silocean.mapper.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    private JdbcTemplate template;

    public StudentDao(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Student student) {
        String sql = "insert into student (id, name) values (?, ?)";
        Object[] params = {student.getId(), student.getName()};
        template.update(sql, params);
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        StudentRowMapper mapper = new StudentRowMapper();
        List<Student> students = template.query(sql, mapper);
        return students;
    }
}
