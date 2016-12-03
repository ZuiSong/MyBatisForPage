package cn.mmooo;

/**
 * @author Administrator user表所对应的实体类
 */
public class User {
	// 实体类的属性和表的字段名称一一对应
	private int id;
	private String name;
	private String email;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
