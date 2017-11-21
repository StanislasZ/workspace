package test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import filter.FileFilterBySuffix;



public class Test {

	public static void main(String[] args) {
		
		//2.��ȡһ����Ҫ��ָ���ļ��ļ��ϡ���ȡworkspace�£�������Ŀ¼�������е�.java���ļ�����·�������洢�������С�
		/*
		 * ˼·��
		 * 	1.��Ȼ����Ŀ¼������Ҫ�ݹ�
		 * 	2.�ݹ��������Ҫ������
		 * 	3.��������������ӵ�������
		 * 
		 */
		File dir=new File("D:\\eclipse\\workspace");
		
		List<File> list=fileList(dir,".java");
		
		for(File file:list){
			System.out.println(file);
		}
	}
	
	/**
	 * ����һ����ȡָ���������������ļ��ļ���
	 */
	public static List fileList(File dir,String suffix){
		//1.���弯��
		List<File> list=new ArrayList<>();
		//2.���������
		FileFilter filter=new FileFilterBySuffix(suffix);
		
		getFileList(dir,list,filter);
		
		return list;
	}
	
	/**
	 * 
	 * @param dir ��Ҫ������Ŀ¼
	 * @param list ���ڴ洢����������File����
	 * @param filter ����ָ���Ĺ�����
	 */
	public static void getFileList(File dir,List<File> list,FileFilter filter){
		
		//1.ͨ��listFiles��������ȡdir��ǰ�µ����е��ļ����ļ��ж���
		File[] files=dir.listFiles();
		
		//2.����������
		for(File file:files){
			//3.�ж��Ƿ����ļ��С�����ǣ��ݹ顣������ǣ��Ǿ����ļ�������Ҫ���ļ����й���
			if(file.isDirectory()){
				getFileList(file,list,filter);
			}else{
				//4.ͨ�����������ļ����й���
				if(filter.accept(file)){
					list.add(file);
				}
			}
		}
		
		
	}

}
