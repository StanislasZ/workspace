package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		
		/*
		 * ��ʾDate����
		 */
		
		Date date=new Date();
		System.out.println(date);
		

		/*
		 * ��Ҫ�����ڰ������ǵ�ϰ�߸�ʽ��һ��
		 * �ҵ���DateFormat
		 */
		
		//ͨ��DateFormat���еľ�̬����������ȡʵ��
		DateFormat dateformat=DateFormat.getDateInstance();
		//������
		dateformat=DateFormat.getDateInstance(DateFormat.FULL);
		
		dateformat=DateFormat.getDateTimeInstance(dateformat.FULL, dateformat.FULL);
		
		
		//�ɲ�����ת���Զ����ʽ     
		dateformat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		
		
		//ʹ��DateFormat��format���������ڶ�����и�ʽ��  �����ڶ���ת�����ڸ�ʽ���ַ�����
		String str=dateformat.format(date);
		
		System.out.println(str);
		
		
	}

}
