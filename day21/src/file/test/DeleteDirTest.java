package file.test;

import java.io.File;

public class DeleteDirTest {

	public static void main(String[] args) {
		
		/*
		 * 删除一个带内容的文件夹。必须从里往外删 
		 * 
		 */
		
		File dir=new File("D:\\test");
		
		
		deleteDir(dir);
		
		
		

	}
	public static void deleteDir(File dir){
		//1.列出当前目录下的文件以及文件夹		
		File[] files=dir.listFiles();
		
		//2.对该数组进行遍历
		for(File file:files){
			//3.判断是否有目录。如果有，继续使用该功能遍历，递归！如果不是文件夹，删除
			if(file.isDirectory()){
				deleteDir(file);
			}else{
				System.out.println(file+":"+file.delete());
			}
		}
		System.out.println(dir+":"+dir.delete());//循环结束后，把文件夹删除
		
	}

}
