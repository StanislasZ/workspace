package day03_0621;
//day03-31-switch练习
import java.util.*;
public class SwitchTest {

	public static void main(String[] args) {
		/*需求：根据用户给定的数值，显示该数值对应的星期。
		 如2，星期二*/
		Scanner in=new Scanner(System.in);
		System.out.println("几？");
		int a=in.nextInt();
		switch (a){
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期七");
			break;
		default:
			System.out.println("输入有误");
			break;
		}
		
		/*
		 switch和if的区别：
		 
		 if可以用于判断数值，也可以判断区间，只要运算结果是boolean类型，
		 都可以进行判断
		 
		 switch用于对固定的几个值进行判断。判断的值的类型有限
		 */
		
		

	}

}
