package file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodTest {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 1.获取文件的绝对路径
		 * 	String getAbsolutePath
		 * 2.获取文件的路径
		 * 	String getPath();
		 * 3.获取文件最后一次修改的时间，要求是x年x月x日。时间
		 * 	long lastModified();
		 * 4.文件是否是隐藏的
		 * 	boolean isHidden()
		 * 5.发现File对象封装的文件或者文件夹是可以存在的也可以是不存在的
		 * 那么不存在的能用File的功能创建吗？
		 * 创建功能：
		 * 	createNewFile();
		 * 删除功能
		 * 	delete();
		 * 
		 * 6.一个File对象封装的文件或者文件夹到底是否存在呢？
		 * 判断存在的功能
		 * 	exists()
		 * 
		 * 7.getFreeSpace()方法是什么意思？用Demo验证。getTotalSpace    getUsableSpace()
		 * 
		 * 
		 * 8.获取指定文件夹中的文件和文件夹的名称。能不能只获取.java文件呢
		 */
		
				
		
		//File file=new File("abc\\a\\b\\c");
		File file=new File("c:\\");
		
		//methodDemo1(file);
		//methodDemo2(file);
		
		System.out.println(file.getFreeSpace());
		System.out.println(file.getTotalSpace());
		System.out.println(file.getTotalSpace()-file.getFreeSpace()-file.getUsableSpace());
		
		
	}

	public static void methodDemo2(File file) throws IOException {
		//1.创建。
		//boolean b1=file.createNewFile();//如果文件存在，不创建，返回false；若不存在，就创建，成功返回true
		//System.out.println(b1);
		
		//2.删除
		//boolean b2=file.delete();   //删除文件夹时，必须保证该文件夹没有内容。有内容，必须先把内容删除后，才可以删除当前文件夹
		//System.out.println(b2);
		
		//System.out.println("exist?"+file.exists());
		
		//3.创建文件夹
		//boolean b3=file.mkdir();  //创建单级目录
		//boolean b3=file.mkdirs();    //创建多级目录
		//System.out.println(b3);
		
		
		
	}

	private static void methodDemo1(File file) {
		String path=file.getAbsolutePath();   //获取文件对象的绝对路径，即使封装的是相对的，获取到的也是绝对的
		String path1=file.getPath();    //获取的是file对象是封装的路径。封装的是什么，获取到的就是什么
		
		System.out.println(path);
		System.out.println(path1);
		
		long time=file.lastModified();
		Date date=new Date(time);
		String str_date=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(date);
		//先从这个类中获取格式器，规定好了格式，在用format方法产生字符串
		
		System.out.println(str_date);
	}

}
