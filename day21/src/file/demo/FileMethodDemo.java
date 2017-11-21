package file.demo;

import java.io.File;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) {
		
		/*
		 * File类，常见方法
		 * 1.名字。获取名称   String getName()
		 * 
		 * 2.大小。获取大小    int length()
		 * 
		 * 3.获取类型 没有
		 * 
		 * 4.获取所在目录。
		 */
		

		File file=new File("d:\\java\\1.txt");
		String file_name=file.getName();
		System.out.println(file_name);
		
		
		
		long t=file.lastModified();
		System.out.println(t); 
		
		Date d=new Date(t);
		System.out.println(d);
		
		long len=file.length();
		System.out.println(len);
		
		String parent=file.getParent();
		System.out.println(parent);
	}

}
