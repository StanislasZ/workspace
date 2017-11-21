package file.demo;

import java.io.File;

public class FileMethodTest2 {

	public static void main(String[] args) {
		
		//获取指定文件夹中的文件和文件夹的名称。能不能只获取.java文件呢
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
