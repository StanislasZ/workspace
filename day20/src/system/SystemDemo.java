package system;

import java.util.Properties;
import java.util.Set;

public class SystemDemo {

	private static final String FILE_SEPARATOR=System.getProperty("file.separator");  //获取系统的文件分隔符
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");  //获取系统的换行分隔符
	public static void main(String[] args) {
		
		
		
		/*
		 * System:全是静态的属性和行为。
		 * 属性：
		 * out:标准输出流，默认对应设备：显示器
		 * in:标准输入流，默认对应设备：键盘
		 */
		
		
//		long time=System.currentTimeMillis();
//		System.out.println(time);
		
		Properties prop=System.getProperties();  //获取到的系统信息都存储到Properties 键值集合中了
		
		//如何取出属性集
		Set<String> keyset=prop.stringPropertyNames();
		
		for(String key:keyset){
			String value=prop.getProperty(key);
			System.out.println(key+"::"+value);
		}
		
		
		System.out.println("\n"+prop.getProperty("os.name"));
		System.out.println("\n"+prop.getProperty("path.separator"));
		//System.out.println(System.getProperties());
		System.out.println("c"+FILE_SEPARATOR+"abc"+FILE_SEPARATOR+"1.txt");
		
		System.out.println("hello"+LINE_SEPARATOR+"world");
		
		
		
		
		
	}

}
