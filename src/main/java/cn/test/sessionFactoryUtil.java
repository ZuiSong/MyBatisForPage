package cn.test;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sessionFactoryUtil {
	private static SqlSessionFactory sessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sessionFactory == null) {
			InputStream ins;
			try {
				ins = Resources.getResourceAsStream("MyBatis-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(ins);
			} catch (IOException e) {
				System.out.println("classPath下没找到MyBatis-config.xml");
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}

	public static SqlSessionFactory getSqlSessionFactory(String environmentID) {
		if (sessionFactory == null) {
			InputStream ins;
			try {
				ins = Resources.getResourceAsStream("MyBatis-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(ins,
						environmentID);
			} catch (IOException e) {
				System.out.println("classPath下没找到MyBatis-config.xml");
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
}
