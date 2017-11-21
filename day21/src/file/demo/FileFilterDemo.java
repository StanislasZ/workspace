package file.demo;

import java.io.File;

import filter.FilterByFile;

public class FileFilterDemo {

	public static void main(String[] args) {
		
		/*
		 * ÎÄ¼þ¹ýÂËÆ÷¡£ FileFilter
		 */
		
		File dir=new File("c:\\");
		File[] files=dir.listFiles(new FilterByFile());
		
		for(File file:files){
			System.out.println(file);
		}
		

	}

}
