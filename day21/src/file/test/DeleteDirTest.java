package file.test;

import java.io.File;

public class DeleteDirTest {

	public static void main(String[] args) {
		
		/*
		 * ɾ��һ�������ݵ��ļ��С������������ɾ 
		 * 
		 */
		
		File dir=new File("D:\\test");
		
		
		deleteDir(dir);
		
		
		

	}
	public static void deleteDir(File dir){
		//1.�г���ǰĿ¼�µ��ļ��Լ��ļ���		
		File[] files=dir.listFiles();
		
		//2.�Ը�������б���
		for(File file:files){
			//3.�ж��Ƿ���Ŀ¼������У�����ʹ�øù��ܱ������ݹ飡��������ļ��У�ɾ��
			if(file.isDirectory()){
				deleteDir(file);
			}else{
				System.out.println(file+":"+file.delete());
			}
		}
		System.out.println(dir+":"+dir.delete());//ѭ�������󣬰��ļ���ɾ��
		
	}

}
