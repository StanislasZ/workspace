package test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import filter.FileFilterBySuffix;



public class Test {

	public static void main(String[] args) {
		
		//2.获取一个想要的指定文件的集合。获取workspace下（包含子目录）的所有的.java的文件对象路径。并存储到集合中。
		/*
		 * 思路：
		 * 	1.既然有子目录，就需要递归
		 * 	2.递归过程中需要过滤器
		 * 	3.满足条件，都添加到集合中
		 * 
		 */
		File dir=new File("D:\\eclipse\\workspace");
		
		List<File> list=fileList(dir,".java");
		
		for(File file:list){
			System.out.println(file);
		}
	}
	
	/**
	 * 定义一个获取指定过滤器条件的文件的集合
	 */
	public static List fileList(File dir,String suffix){
		//1.定义集合
		List<File> list=new ArrayList<>();
		//2.定义过滤器
		FileFilter filter=new FileFilterBySuffix(suffix);
		
		getFileList(dir,list,filter);
		
		return list;
	}
	
	/**
	 * 
	 * @param dir 需要遍历的目录
	 * @param list 用于存储符合条件的File对象
	 * @param filter 接收指定的过滤器
	 */
	public static void getFileList(File dir,List<File> list,FileFilter filter){
		
		//1.通过listFiles方法，获取dir当前下的所有的文件和文件夹对象
		File[] files=dir.listFiles();
		
		//2.遍历该数组
		for(File file:files){
			//3.判断是否是文件夹。如果是，递归。如果不是，那就是文件，就需要对文件进行过滤
			if(file.isDirectory()){
				getFileList(file,list,filter);
			}else{
				//4.通过过滤器对文件进行过滤
				if(filter.accept(file)){
					list.add(file);
				}
			}
		}
		
		
	}

}
