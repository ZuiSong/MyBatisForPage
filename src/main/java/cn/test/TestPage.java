package cn.test;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.mmooo.User;
import cn.mmooo.UserMapper;

public class TestPage {
	
	/**
	 * 展示Mybatis的分页插件PageHelper用法，在mybatis-config文件中的配置解释很详细
	 * 
	 * 
	 * 官方的分页是传一个RowBounds到Dao方法中，
	 * MyBatis会自动进行分页，官方的分页是逻辑分页，
	 * 就是一次性从数据库获取全部数据到内存，然后再从
	 * 全部数据中截取分页所需的返回给用户，这样的缺点
	 * 很明显，所以就有了第三方写的分页插件
	 */
	@Test
	public void QeryForPage() {
		SqlSessionFactory sessionFactory = sessionFactoryUtil.getSqlSessionFactory();

		SqlSession session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		// System.out.println(mapper.deleteUser(4));

		Page<Object> offsetPage = PageHelper.offsetPage(2, 10);
		List<User> usersList = mapper.getUsersList();

		Page<User> users = (Page<User>) usersList;

		/*
		 * 返回的list其实是page对象，page实现了list接口，并且， page封装了一些属性，包括总条数，总页数，当前页码等,
		 * 详见Page对象各属性注释 所以，把返回的List强制转换为Page对象可以获取page独有的属性
		 * 
		 * offsetPage和userlist在执行查询方法以后，两个对象其实是同一个对象
		 */
		System.out.println(offsetPage.equals(usersList));// 输出true
		System.out.println(offsetPage.getClass().equals(usersList.getClass()));// 输出true

		for (Object user : usersList) {
			System.out.println(user);
		}

		System.out.println(offsetPage);
	}

	/**
	 * Mybatis的基础用法
	 */
	@Test
	public void HelloMybatis() {
		SqlSessionFactory sessionFactory = sessionFactoryUtil.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession(true);

		// 也可以使用mapper文件定义的namespace来执行Dao方法，但是，那样容易出现拼写错误，3.0以后官方建议这样写
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> usersList = mapper.getUsersList();
		for (User user : usersList) {
			System.out.println(user);
		}

		// JDK8的新特性，嘿嘿
		// usersList.stream().peek(System.out::println);
	}

	
	
	
	
	@Test
	public void addData() {
		SqlSessionFactory sessionFactory = sessionFactoryUtil.getSqlSessionFactory();

		SqlSession session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		for (int i = 0; i < 100; i++) {
			User user = new User("chenjian" + i, "chenjian" + i + "@mmooo.cn");
			mapper.insertUser(user);
		}

	}

}