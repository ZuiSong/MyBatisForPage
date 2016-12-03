package principle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class invokHandler implements InvocationHandler {
	Class clazz;
	SqlSession session;

	public invokHandler(Class clazz, SqlSession session) {
		super();
		this.clazz = clazz;
		this.session = session;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodname = method.getName();
		String classname = clazz.getName();
		System.out.println("namespace是："+classname);
		System.out.println("id是："+methodname);
		System.out.println("参数个数是："+args.length);
		System.out.println("根据namespaceh和id和对配置文件对应，去读取配置信息，运行sql语句");
		
		
		return "你好啊";
	}

}
