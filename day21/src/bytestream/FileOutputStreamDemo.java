package bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * ������д���ļ��С�
		 * ʹ���ֽ��������д��
		 * FileOutputStream
		 */
		
		File dir=new File("tempfile");
		if(!dir.exists())
			dir.mkdir();
		//1.�����ֽ�������������ڲ����ļ����ڶ����ʼ��ʱ��������ȷ���ݴ洢��Ŀ�ĵ�
		//�������������Ŀ�ĵأ���������ڣ����Զ�������������ڣ��򸲸�
		FileOutputStream fos=new FileOutputStream("tempfile\\fos.txt");
		
		//2.����������Ĺ��ܡ�
		String str="abcde";
		byte[] buf=str.getBytes();  //��ת���ֽ�����
		fos.write(buf);
		
		//3.�ͷ���Դ
		fos.close();
		
	}

}
