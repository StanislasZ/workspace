package date;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo3 {

	public static void main(String[] args) {
		
		long time=System.currentTimeMillis();
		
		System.out.println(time);
		
		//����ֵ-->���ڶ���   ���캯��
		Date d=new Date(time);
		
		
		DateFormat df=DateFormat.getDateInstance(DateFormat.LONG);
		String str_date=df.format(d);
		
		System.out.println(str_date);

		
		//���ڶ���ת�ɺ���ֵ��  Date�Ķ��� getTime
		long time2=d.getTime();
		System.out.println(time2);
		
	}

}
