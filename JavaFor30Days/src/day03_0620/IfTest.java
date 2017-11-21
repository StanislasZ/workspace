package day03_0620;
//day03-29-iftest
import java.util.*;
public class IfTest 
{

	public static void main(String[] args) 
	{
		/*需求：根据用户给定的数值，显示该数值对应的星期。
		 如2，星期二
		 思路：
		 	1.怎么获得这个数值？来源有很多，不确定，只要是不确定的数据，
		 	只要操作该变量即可。
		 	2.数值不确定，如何显示对应的星期呢？那就需要对该数值进行判断
		 	3.怎么显示？通过输出语句就可以显示在屏幕上。
		 	
		 步骤：
		 1.定义变量，记录数据
		 2.通过判断结构语句if对该变量进行判断
		 3.根据不同的条件，通过输出语句显示不同的结果。
		 */
		Scanner in=new Scanner(System.in);
		
		System.out.print("几？");
		int num=in.nextInt();
		if(num==1)
		{
			System.out.println(num+"是星期一");
		}
		else if(num==2)
		{
			System.out.println(num+"是星期二");
		}
		else if(num==3)
		{
			System.out.println(num+"是星期三");
		}
		else if(num==4)
		{
			System.out.println(num+"是星期四");
		}
		else if(num==5)
		{
			System.out.println(num+"是星期五");
		}
		else if(num==6)
		{
			System.out.println(num+"是星期六");
		}
		else if(num==7)
		{
			System.out.println(num+"是星期七");
		}
		else 
		{
			System.out.println(num+"是没有对应的星期");
		}
		//上面的的大括号可以不写，因为只有一句。
		//上面的else可以去掉，但是浪费时间！！！
		
		
		
	}

}
