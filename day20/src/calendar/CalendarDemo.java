package calendar;

import java.util.Calendar;

import exception.NotWeekException;

public class CalendarDemo {

	public static void main(String[] args) {
		
		/*
		 * 演示日历
		 * Calendar
		 */
		
		Calendar c=Calendar.getInstance();   //获取日历实例
		
		//对日历对象进行其中日期的定义    set(field,value)
		
		//c.set(Calendar.YEAR, 2014);
		//c.set(2012, 4, 1);
		
		//日期的偏移     add
		//c.add(Calendar.MONTH, -4);
		
		//任意一年的二月有多少天。    三月一日的前一天就是
		int year=2012;
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		
		//获取其中的日期
		//int year=c.get(Calendar.YEAR);   //根据字段获取值
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		String week=getWeek(c.get(Calendar.DAY_OF_WEEK));
		
		
		System.out.println(year+"年"+month+"月"+day+"日"+week);
		//System.out.println(getWeek(8));

	}

	private static String getWeek(int i) {
		if(i>7||i<=0)
			throw new NotWeekException("没有对应的星期");
		String[] weeks={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六",};
		return weeks[i];
	}

}
