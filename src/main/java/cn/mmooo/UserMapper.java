package cn.mmooo;

import java.util.List;

public interface UserMapper {
	User getUserById(int i);

	List<User> getUsersList();

	int insertUser(User u);

	int getUsersCount();

	int updateUser(User u);

	int deleteUser(int id);

	User[] getUsersArray();
}