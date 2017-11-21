package calendar;

import java.util.Calendar;

import exception.NotWeekException;

public class CalendarDemo {

	public static void main(String[] args) {
		
		/*
		 * ��ʾ����
		 * Calendar
		 */
		
		Calendar c=Calendar.getInstance();   //��ȡ����ʵ��
		
		//��������������������ڵĶ���    set(field,value)
		
		//c.set(Calendar.YEAR, 2014);
		//c.set(2012, 4, 1);
		
		//���ڵ�ƫ��     add
		//c.add(Calendar.MONTH, -4);
		
		//����һ��Ķ����ж����졣    ����һ�յ�ǰһ�����
		int year=2012;
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		
		//��ȡ���е�����
		//int year=c.get(Calendar.YEAR);   //�����ֶλ�ȡֵ
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		String week=getWeek(c.get(Calendar.DAY_OF_WEEK));
		
		
		System.out.println(year+"��"+month+"��"+day+"��"+week);
		//System.out.println(getWeek(8));

	}

	private static String getWeek(int i) {
		if(i>7||i<=0)
			throw new NotWeekException("û�ж�Ӧ������");
		String[] weeks={"","������","����һ","���ڶ�","������","������","������","������",};
		return weeks[i];
	}

}
