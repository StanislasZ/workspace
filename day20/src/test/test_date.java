package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test_date {

	public static void main(String[] args) throws ParseException {
		
		//"2012/3/17","2012-5-28"  相隔多少天
		/*
		 * 1.只有毫秒可以相减
		 * 2.获取毫秒值，字符串-->日期对象-->毫秒值
		 */
		
		String str_date1="2012/3/17";   //这种格式并没有
		String str_date2="2012-5-28";
		
		//1.自定义yyyy//MM/dd风格
		DateFormat df1=new SimpleDateFormat("yyyy/MM/dd");
		
		//定义一个默认风格
		DateFormat df2=DateFormat.getDateInstance(); //获取日期格式器
		
		Date d1=df1.parse(str_date1);  //解析
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
