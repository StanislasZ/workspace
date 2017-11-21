package bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 将数据写入文件中。
		 * 使用字节输出流（写）
		 * FileOutputStream
		 */
		
		File dir=new File("tempfile");
		if(!dir.exists())
			dir.mkdir();
		//1.创建字节输出流对象，用于操作文件，在对象初始化时，必须明确数据存储的目的地
		//输出流所关联的目的地，如果不存在，会自动创建。如果存在，则覆盖
		FileOutputStream fos=new FileOutputStream("tempfile\\fos.txt");
		
		//2.调用输出流的功能。
		String str="abcde";
		byte[] buf=str.getBytes();  //先转成字节数组
		fos.write(buf);
		
		//3.释放资源
		fos.close();
		
	}

}
