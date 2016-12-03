package cn.mmooo;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 
 * @author Chen 基于注解的mapper类，不需要maper.xml文件
 */
public interface UserMapper2 {
	@Select("SELECT * FROM users WHERE id = #{id}")
	User getUserById(int i);

	@Select("SELECT * FROM users")
	List<User> getUsersList();

	@Insert("INSERT INTO users (name, age) VALUES (#{name}, #{age})")
	int insertUser(User u);

	@Update("UPDATE  users SET name = #{name}, age = #{age} WHERE id = #{id}")
	int updateUser(User u);

	@Delete("DELETE FROM users WHERE id = #{id}")
	int deleteUser(int id);

	@Select("SELECT * FROM users")
	User[] getUsersArray();
}
