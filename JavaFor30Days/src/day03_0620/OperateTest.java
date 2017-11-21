package day03_0620;
//day03，视频24-位运算练习
public class OperateTest 
{

	public static void main(String[] args)
	{
		//1.最有效率运算2乘以8，通过位移运算
		System.out.println(2<<3);
		
		//2.对两个整个变量的值进行互换（不需要第三方变量）
		int a=3,b=7;
		System.out.println("a="+a+",b="+b);
		
		/*
		 通过第三方变量
	 	int temp=a;
		a=b;
		b=temp;
		System.out.println("a="+a+",b="+b);
		*/
		
		/*
		//通过和的形式,有个弊端：两个数据较大可能会超出int范围
		a=a+b;  //a=10
		b=a-b;   //b=3;
		a=a-b;    //a=7
		System.out.println("a="+a+",b="+b);
		*/
		
		/*
		//技巧：异或
		a=a^b;   //a=3^7
		b=a^b;    //b=3^7^7 =3
		a=a^b;   //a=3^7^3=7
		System.out.println("a="+a+",b="+b);
 		*/
		
		
		
		
		
		

	}

}
