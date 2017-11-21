package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		
		/*
		 * 演示Date对象
		 */
		
		Date date=new Date();
		System.out.println(date);
		

		/*
		 * 想要把日期按照我们的习惯格式化一下
		 * 找到了DateFormat
		 */
		
		//通过DateFormat类中的静态工厂方法获取实例
		DateFormat dateformat=DateFormat.getDateInstance();
		//加入风格
		dateformat=DateFormat.getDateInstance(DateFormat.FULL);
		
		dateformat=DateFormat.getDateTimeInstance(dateformat.FULL, dateformat.FULL);
		
		
		//可不可以转成自定义格式     
		dateformat=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		
		
		//使用DateFormat的format方法对日期对象进行格式化  将日期对象转成日期格式的字符串。
		String str=dateformat.format(date);
		
		System.out.println(str);
		
		
	}

}
