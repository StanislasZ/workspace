package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test_date {

	public static void main(String[] args) throws ParseException {
		
		//"2012/3/17","2012-5-28"  ���������
		/*
		 * 1.ֻ�к���������
		 * 2.��ȡ����ֵ���ַ���-->���ڶ���-->����ֵ
		 */
		
		String str_date1="2012/3/17";   //���ָ�ʽ��û��
		String str_date2="2012-5-28";
		
		//1.�Զ���yyyy//MM/dd���
		DateFormat df1=new SimpleDateFormat("yyyy/MM/dd");
		
		//����һ��Ĭ�Ϸ��
		DateFormat df2=DateFormat.getDateInstance(); //��ȡ���ڸ�ʽ��
		
		Date d1=df1.parse(str_date1);  //����
		Date d2=df2.parse(str_date2);
		
		long time1=d1.getTime();
		long time2=d2.getTime();
		
		long time=Math.abs(time2-time1);
		int day=transDay(time);
		System.out.println(day);
		
		
		
		

	}

	private static int transDay(long time) {
		
		return (int)(time/1000/60/60/24);
	}

}
