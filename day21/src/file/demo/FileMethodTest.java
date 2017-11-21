package file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodTest {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 1.��ȡ�ļ��ľ���·��
		 * 	String getAbsolutePath
		 * 2.��ȡ�ļ���·��
		 * 	String getPath();
		 * 3.��ȡ�ļ����һ���޸ĵ�ʱ�䣬Ҫ����x��x��x�ա�ʱ��
		 * 	long lastModified();
		 * 4.�ļ��Ƿ������ص�
		 * 	boolean isHidden()
		 * 5.����File�����װ���ļ������ļ����ǿ��Դ��ڵ�Ҳ�����ǲ����ڵ�
		 * ��ô�����ڵ�����File�Ĺ��ܴ�����
		 * �������ܣ�
		 * 	createNewFile();
		 * ɾ������
		 * 	delete();
		 * 
		 * 6.һ��File�����װ���ļ������ļ��е����Ƿ�����أ�
		 * �жϴ��ڵĹ���
		 * 	exists()
		 * 
		 * 7.getFreeSpace()������ʲô��˼����Demo��֤��getTotalSpace    getUsableSpace()
		 * 
		 * 
		 * 8.��ȡָ���ļ����е��ļ����ļ��е����ơ��ܲ���ֻ��ȡ.java�ļ���
		 */
		
				
		
		//File file=new File("abc\\a\\b\\c");
		File file=new File("c:\\");
		
		//methodDemo1(file);
		//methodDemo2(file);
		
		System.out.println(file.getFreeSpace());
		System.out.println(file.getTotalSpace());
		System.out.println(file.getTotalSpace()-file.getFreeSpace()-file.getUsableSpace());
		
		
	}

	public static void methodDemo2(File file) throws IOException {
		//1.������
		//boolean b1=file.createNewFile();//����ļ����ڣ�������������false���������ڣ��ʹ������ɹ�����true
		//System.out.println(b1);
		
		//2.ɾ��
		//boolean b2=file.delete();   //ɾ���ļ���ʱ�����뱣֤���ļ���û�����ݡ������ݣ������Ȱ�����ɾ���󣬲ſ���ɾ����ǰ�ļ���
		//System.out.println(b2);
		
		//System.out.println("exist?"+file.exists());
		
		//3.�����ļ���
		//boolean b3=file.mkdir();  //��������Ŀ¼
		//boolean b3=file.mkdirs();    //�����༶Ŀ¼
		//System.out.println(b3);
		
		
		
	}

	private static void methodDemo1(File file) {
		String path=file.getAbsolutePath();   //��ȡ�ļ�����ľ���·������ʹ��װ������Եģ���ȡ����Ҳ�Ǿ��Ե�
		String path1=file.getPath();    //��ȡ����file�����Ƿ�װ��·������װ����ʲô����ȡ���ľ���ʲô
		
		System.out.println(path);
		System.out.println(path1);
		
		long time=file.lastModified();
		Date date=new Date(time);
		String str_date=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(date);
		//�ȴ�������л�ȡ��ʽ�����涨���˸�ʽ������format���������ַ���
		
		System.out.println(str_date);
	}

}
