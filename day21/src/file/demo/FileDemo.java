package file.demo;

import java.io.File;

public class FileDemo {

	//private static final String FILE_SEPARATOR=System.getProperty("file.separator");   //��ȡ��ǰϵͳ���ļ��ָ���
	
	public static void main(String[] args) {
		//��һ�������·����װ����File���󡣿��Է�װ���ڵ��ļ���Ŀ¼��Ҳ���� ��װ�����ڵ��ļ���Ŀ¼
		File file=new File("abc\\1.txt");

		//File(String parent,String child)
		File file1=new File("c:\\","1.txt");
		
		File dir=new File("c:\\");
		
		File file2=new File(dir,"1.txt");
		
		//File f=new File("c:"+FILE_SEPARATOR+"1.txt");
		File f=new File("c:"+File.separator+"1.txt");  //�ṩ���ֶ�
		System.out.println(f);
		
	}

}
