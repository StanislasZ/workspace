package file.demo;

import java.io.File;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) {
		
		/*
		 * File�࣬��������
		 * 1.���֡���ȡ����   String getName()
		 * 
		 * 2.��С����ȡ��С    int length()
		 * 
		 * 3.��ȡ���� û��
		 * 
		 * 4.��ȡ����Ŀ¼��
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
