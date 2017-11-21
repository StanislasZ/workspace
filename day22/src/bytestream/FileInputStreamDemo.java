package bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 将已有文件的数据读取出来
		 * 既然是读，使用InputStream
		 * 而且是要操作文件。FileInputStream
		 * 
		 */
		
		//为了确保未见一定在读之前存在。将字符串路径封装成File
		File file=new File("tempfile\\fos.txt");
		if(!file.exists()){
			throw new RuntimeException("要读取的文件不存在");
		}
			
		//创建文件字节读取流对象时，必须明确与之关联的数据源。
		FileInputStream fis=new FileInputStream(file);

		//调用读取流对象读取方法 read()
		
		int by=0;
		while((by=fis.read())!=-1){
			System.out.println(by);
		}
		
		
		
//		int by1=fis.read();
//		System.out.println("by1="+by1);
//		int by2=fis.read();
//		System.out.println("by2="+by2);
//		int by3=fis.read();
//		System.out.println("by3="+by3);
		
		//关闭资源
		fis.close();
		
		
	}

}
