package system;

import java.util.Properties;
import java.util.Set;

public class SystemDemo {

	private static final String FILE_SEPARATOR=System.getProperty("file.separator");  //��ȡϵͳ���ļ��ָ���
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");  //��ȡϵͳ�Ļ��зָ���
	public static void main(String[] args) {
		
		
		
		/*
		 * System:ȫ�Ǿ�̬�����Ժ���Ϊ��
		 * ���ԣ�
		 * out:��׼�������Ĭ�϶�Ӧ�豸����ʾ��
		 * in:��׼��������Ĭ�϶�Ӧ�豸������
		 */
		
		
//		long time=System.currentTimeMillis();
//		System.out.println(time);
		
		Properties prop=System.getProperties();  //��ȡ����ϵͳ��Ϣ���洢��Properties ��ֵ��������
		
		//���ȡ�����Լ�
		Set<String> keyset=prop.stringPropertyNames();
		
		for(String key:keyset){
			String value=prop.getProperty(key);
			System.out.println(key+"::"+value);
		}
		
		
		System.out.println("\n"+prop.getProperty("os.name"));
		System.out.println("\n"+prop.getProperty("path.separator"));
		//System.out.println(System.getProperties());
		System.out.println("c"+FILE_SEPARATOR+"abc"+FILE_SEPARATOR+"1.txt");
		
		System.out.println("hello"+LINE_SEPARATOR+"world");
		
		
		
		
		
	}

}
