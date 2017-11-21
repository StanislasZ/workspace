package file.demo;

import java.io.File;

public class FileDemo {

	//private static final String FILE_SEPARATOR=System.getProperty("file.separator");   //获取当前系统的文件分隔符
	
	public static void main(String[] args) {
		//将一个具体的路径封装成了File对象。可以封装存在的文件或目录，也可以 封装不存在的文件或目录
		File file=new File("abc\\1.txt");

		//File(String parent,String child)
		File file1=new File("c:\\","1.txt");
		
		File dir=new File("c:\\");
		
		File file2=new File(dir,"1.txt");
		
		//File f=new File("c:"+FILE_SEPARATOR+"1.txt");
		File f=new File("c:"+File.separator+"1.txt");  //提供了字段
		System.out.println(f);
		
	}

}
