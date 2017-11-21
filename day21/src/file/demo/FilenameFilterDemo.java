package file.demo;   //文件名过滤器

import java.io.File;
import java.io.FilenameFilter;

import filter.FilterByContain;
import filter.FilterBySuffix;

public class FilenameFilterDemo {

	public static void main(String[] args) {
		
		//能不能只获取指定目录下的.java文件呢   //list(FilenameFilter filter)
		
		File dir=new File("D:\\eclipse\\workspace\\day20\\src\\test\\");
		
		FilenameFilter filter=new FilterBySuffix(".java"); 
		filter=new FilterByContain("date");
		String[] names=dir.list(filter);
		for(String name:names){
			//if(name.endsWith(".java"))
				System.out.println(name);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
