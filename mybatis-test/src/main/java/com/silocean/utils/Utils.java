package com.silocean.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Utils {
    public static SqlSession getSession() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(reader);
        SqlSession session = factory.openSession();
        return session;
    }
}
