package bytestream;
//读取字节一般用这种方法

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {

	private static final int DEFAULT_SIZE = 1024;

	public static void main(String[] args) {
		
		//演示第二种读取方式。read(byte[]);
		FileInputStream fis=null;
		try{
			fis=new FileInputStream("tempfile\\fos.txt");
			
			//创建一个字节数组
			byte[] buf=new byte[DEFAULT_SIZE];
			
			int len=0;
			while((len=fis.read(buf))!=-1){
				System.out.println(new String(buf,0,len));
			}
			
			
			
			
			//调用read(byte[])方法
//			int len=fis.read(buf);  //len记录的是往字节数组里存储的字节个数
//			System.out.println(len+"...."+new String(buf));
//			
//			int len1=fis.read(buf);  //len1记录的是往字节数组里存储的字节个数
//			System.out.println(len1+"...."+new String(buf,0,len1));
		
		}catch(IOException e){
			
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					//一般可以throw RuntimeException异常。或者把异常信息写入日志文件
				}
		}
		
		
		
	}

}
