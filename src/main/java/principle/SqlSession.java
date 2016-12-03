package principle;

import java.lang.reflect.Proxy;

public class SqlSession {
	
	public SqlSession() {
		System.out.println("读取配置文件");
	}
	
	public <T> T getMapper(Class<T> clazz) {
		T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, new invokHandler(clazz, this));
		return t;
	}
}
