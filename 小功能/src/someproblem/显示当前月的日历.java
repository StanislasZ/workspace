package someproblem;             
import java.time.*;
import java.util.*;   //java.util.Date 是 java.sql.Date 的父类。
public class 显示当前月的日历 {

	public static void main(String[] args) {
		
		PrintCalendar();

	}
	
	//ctrl按住单击类名，进入源代码
	
	
	
	public static void PrintCalendar(){
		LocalDate date=LocalDate.now();    //date是今天
		int month=date.getMonthValue();     //获取现在是几月
		int today=date.getDayOfMonth();    //获取今天是几号
		
		date=date.minusDays(today-1);    //date改为这个月的第一天
		DayOfWeek weekday=date.getDayOfWeek();   //weekday表示星期几
		int value=weekday.getValue();  //1表示周一，2表示周二………………
		
		System.out.println("Mon Tue Wen Thu Fri Sat Sun");
		//比如是周三，前面要先空掉2格
		for(int i=1;i<=value-1;i++)
			System.out.print("    ");
		
		while(date.getMonthValue()==month){
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth()==today)
				System.out.print("*");
			else
				System.out.print(" ");
			date=date.plusDays(1);
			if(date.getDayOfWeek().getValue()==1)
				System.out.println();
		}
		
		//date.getDayOfMonth() 获取几号
		//data.getDayOfWeek() 获取周几,类型为DayOfWeek
		//data.getDayofWeek().getValue()   获取周几的这个几（数字）， 类型为int
	}

}
