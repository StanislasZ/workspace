package file.test;

import java.io.File;


public class GetAllFilesTest {

	public static void main(String[] args) {
		
		/*
		 * ����ָ��Ŀ¼�µ����ݣ�������Ŀ¼�е����ݣ�
		 * 
		 * �ݹ飺�����������������������ڲ���ʹ�õ��˸ú������ܡ�
		 * ʲôʱ��ʹ�ã�
		 * ���ܱ��ظ�ʹ�ã�����ÿ�θù���ʹ�ò�����������ݲ�ͬʱ�����Կ��ǵݹ鷽ʽ���
		 */
		
		File dir=new File("D:\\eclipse\\workspace");
		
		getAllFiles(dir);
		
		
		

	}
	public static void getAllFiles(File dir){
		System.out.println("dir: "+dir);
		//1.��ȡ��Ŀ¼���ļ���������
		File[] files=dir.listFiles();
		
		//2.��������б���
		for(File file:files){
			
			if(file.isDirectory()){
				getAllFiles(file);  //�ݹ�
			}else{
				System.out.println("	file: "+file);
			}
			
			
			
			
		}
		
		
	}

}