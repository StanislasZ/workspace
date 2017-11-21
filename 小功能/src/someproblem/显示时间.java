package someproblem;
//显示当前时间
//由一个日期 + x天  得到新的日期

import java.time.LocalDate;
import java.util.Date;   //java.util.Date 是 java.sql.Date 的父类。

public class 显示时间 {

	public static void main(String[] args) {
//		Date d = new Date();
//		System.out.println(d);
		
		
//		Date date = new Date();            //获取时间戳
//	    long times = date.getTime();
//	    System.out.println(times);

		
		
//		long times = 1412654676572L;
//	    Date date = new Date(times);
//	    System.out.println(date);                 //时间戳转化成日期
		
		//System.out.println(new Date());
		
//		String s=new Date().toString();
//		System.out.println(s);
		
	   LocalDate newyearseve=LocalDate.of(1999, 12, 31);
	  //要知道这个日期过了几天后是几年几月几号，用plusDays方法
	   LocalDate athousanddayslater=newyearseve.plusDays(1000);
	   System.out.println(athousanddayslater);          //过1000天是02年9月26日
	   
	   LocalDate date=LocalDate.now();
	   System.out.println(date);
	
	
	}
}
