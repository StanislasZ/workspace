package file.demo;

import java.io.File;

public class FileMethodTest2 {

	public static void main(String[] args) {
		
		//��ȡָ���ļ����е��ļ����ļ��е����ơ��ܲ���ֻ��ȡ.java�ļ���
		File dir=new File("c:\\");
		
		File[] files=dir.listFiles();
		for(File f:files){
			System.out.println(f);
		}
		/*
		String[] names=dir.list();
		System.out.println(names.length);
		
		if(names!=null)
			for(String name:names){
				System.out.println(name);
			}
		*/
	}

}
