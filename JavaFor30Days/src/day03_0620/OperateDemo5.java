package day03_0620;
//day03-视频25-三元
import java.util.*; //要使用输入
public class OperateDemo5 
{

	public static void main(String[] args)
	{
		/*
		//三元运算符 （条件表达式）？表达式1：表达式2
		int x=2,y;
		y=x>1?100:200;
		System.out.println("y="+y);
		*/
		
		//需求：三个数，想知道最大的是哪个
		int a,b,c,max;
		
		Scanner in=new Scanner(System.in);//构造一个Scanner对象，并与标准输入流System in关联
		//定义完后就可以使用Scanner类的各种方法实现输入操作了
		
		
		
		System.out.print("a=?");
		a=in.nextInt();
		System.out.print("b=?");
		b=in.nextInt();
		System.out.print("c=?");
		c=in.nextInt();
		
		max=a>b?(a>c?a:c):(b>c?b:c);
		System.out.println("max="+max);
		
		
		
		
	}

}
