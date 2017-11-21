package date;

import java.text.DateFormat;
import java.util.Date;

public class DateDemo3 {

	public static void main(String[] args) {
		
		long time=System.currentTimeMillis();
		
		System.out.println(time);
		
		//毫秒值-->日期对象   构造函数
		Date d=new Date(time);
		
		
		DateFormat df=DateFormat.getDateInstance(DateFormat.LONG);
		String str_date=df.format(d);
		
		System.out.println(str_date);

		
		//日期对象转成毫秒值。  Date的对象 getTime
		long time2=d.getTime();
		System.out.println(time2);
		
	}

}
