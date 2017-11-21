package file.test;

import java.io.File;


public class GetAllFilesTest {

	public static void main(String[] args) {
		
		/*
		 * 遍历指定目录下的内容（包含子目录中的内容）
		 * 
		 * 递归：函数自身调用自身。函数内部又使用到了该函数功能。
		 * 什么时候使用？
		 * 功能被重复使用，但是每次该功能使用参与运算的数据不同时，可以考虑递归方式解决
		 */
		
		File dir=new File("D:\\eclipse\\workspace");
		
		getAllFiles(dir);
		
		
		

	}
	public static void getAllFiles(File dir){
		System.out.println("dir: "+dir);
		//1.获取该目录的文件对象数组
		File[] files=dir.listFiles();
		
		//2.对数组进行遍历
		for(File file:files){
			
			if(file.isDirectory()){
				getAllFiles(file);  //递归
			}else{
				System.out.println("	file: "+file);
			}
			
			
			
			
		}
		
		
	}

}
