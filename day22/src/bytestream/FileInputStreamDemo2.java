package bytestream;
//��ȡ�ֽ�һ�������ַ���

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {

	private static final int DEFAULT_SIZE = 1024;

	public static void main(String[] args) {
		
		//��ʾ�ڶ��ֶ�ȡ��ʽ��read(byte[]);
		FileInputStream fis=null;
		try{
			fis=new FileInputStream("tempfile\\fos.txt");
			
			//����һ���ֽ�����
			byte[] buf=new byte[DEFAULT_SIZE];
			
			int len=0;
			while((len=fis.read(buf))!=-1){
				System.out.println(new String(buf,0,len));
			}
			
			
			
			
			//����read(byte[])����
//			int len=fis.read(buf);  //len��¼�������ֽ�������洢���ֽڸ���
//			System.out.println(len+"...."+new String(buf));
//			
//			int len1=fis.read(buf);  //len1��¼�������ֽ�������洢���ֽڸ���
//			System.out.println(len1+"...."+new String(buf,0,len1));
		
		}catch(IOException e){
			
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					//һ�����throw RuntimeException�쳣�����߰��쳣��Ϣд����־�ļ�
				}
		}
		
		
		
	}

}
