package bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * �������ļ������ݶ�ȡ����
		 * ��Ȼ�Ƕ���ʹ��InputStream
		 * ������Ҫ�����ļ���FileInputStream
		 * 
		 */
		
		//Ϊ��ȷ��δ��һ���ڶ�֮ǰ���ڡ����ַ���·����װ��File
		File file=new File("tempfile\\fos.txt");
		if(!file.exists()){
			throw new RuntimeException("Ҫ��ȡ���ļ�������");
		}
			
		//�����ļ��ֽڶ�ȡ������ʱ��������ȷ��֮����������Դ��
		FileInputStream fis=new FileInputStream(file);

		//���ö�ȡ�������ȡ���� read()
		
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
		
		//�ر���Դ
		fis.close();
		
		
	}

}
