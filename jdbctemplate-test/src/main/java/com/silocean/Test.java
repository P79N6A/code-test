package com.silocean;

import com.silocean.dao.StudentDao;
import com.silocean.entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        JdbcTemplate template = (JdbcTemplate) ctx.getBean("template");
        StudentDao dao = new StudentDao(template);

        dao.save(new Student("23123", "tracy"));

        for (Student student : dao.findAll()) {
            System.out.println(student);
        }
    }
}
