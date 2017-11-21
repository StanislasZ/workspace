package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDemo2 {
	
	public static void main(String[] args) throws ParseException{
	
		/*
		 * 给一个日期格式的字符串    "2013-07-17"
		 * 需要将日期格式的字符串转成日期对象。  解析
		 * 
		 */
		
		String str_date="2013-07-17";
		
		DateFormat df=DateFormat.getDateInstance();
		
		Date d=df.parse(str_date);
		
		System.out.println(d);
	}
}
