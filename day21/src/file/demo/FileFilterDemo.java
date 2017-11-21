package file.demo;

import java.io.File;

import filter.FilterByFile;

public class FileFilterDemo {

	public static void main(String[] args) {
		
		/*
		 * �ļ��������� FileFilter
		 */
		
		File dir=new File("c:\\");
		File[] files=dir.listFiles(new FilterByFile());
		
		for(File file:files){
			System.out.println(file);
		}
		

	}

}
