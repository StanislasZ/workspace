package day05_0623;
//day05-17-数组的应用-查表法
import java.util.*;
public class ArrayTest4 {

	public static void main(String[] args) {
		/*
		 数组使用的核心思想：
		 容器特点：1.固定长度 2.元素都有索引。
		 什么时候使用容器呢？ 数据多了，必须先进行存储，然后进行操作
		 
		 对于数组容器什么时候用呢？ 数据多，个数确定，而且有**对应关系** 
		 在分析需求时，
		 1.需求中的数据是否有对应的有序编号？
		 2.需求中的数据是否需要有序的编号？
		 如果有，就用数组存储
		 ***********************************************
		 没有一方是有序编号的话，就使用map！！（新的一个容器）
		 *************************************************
		 例1：一组数：34 89 12 78 45 要对他们进行操作。需要编号，操作更容易
		 
		 例2：根据用户输入的数据，显示对应的星期。
		 思路：
		 1.星期有多个，个数固定
		 2.星期对应的有序编号
		 所以可以使用数组这种结构存储
		 */

		Scanner in=new Scanner(System.in);
				
		System.out.println("几？");
		int num=in.nextInt();       //获取用户数字
		
		String day=getweek(num);        //调用函数，变成字符串的星期几
		System.out.println(day);    //打印这个字符串
		
	}

	
	/*
	public static String getweek(int x){
		String[] week={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"};
		String day="";
		int i;
		for(i=1;i<=7;i++){
			if(x==i){
				day=week[i-1];
				break;        //一旦匹配，先赋值，再退出循环
			}
		}
		if(i==8){             //除了1-7，上面的循环会运行到结束，此时i=8
			day="输入有误";
		}
		return day;
	}
	*/
	
	/*
	public static String getweek(int x){
		String[] week={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"};
		if(x>=1&&x<=7)
			return week[x-1];
		else
			return "输入有误";
	}
	*/
	
	
	public static String getweek(int x){
		String[] week={"星期一","星期二","星期三","星期四","星期五","星期六","星期七"}; 
		//一个表
		
		
		if(x<1||x>7)
			//return "输入有误";
			throw new RuntimeException(x+"输入有误"); //这个高级，抛出异常
		
			return week[x-1];//查表
	}
		
	
	
	
	
	
	
}
