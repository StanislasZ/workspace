package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDemo2 {
	
	public static void main(String[] args) throws ParseException{
	
		/*
		 * ��һ�����ڸ�ʽ���ַ���    "2013-07-17"
		 * ��Ҫ�����ڸ�ʽ���ַ���ת�����ڶ���  ����
		 * 
		 */
		
		String str_date="2013-07-17";
		
		DateFormat df=DateFormat.getDateInstance();
		
		Date d=df.parse(str_date);
		
		System.out.println(d);
	}
}
