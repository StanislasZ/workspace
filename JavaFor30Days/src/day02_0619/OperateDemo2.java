package day02_0619;
//视频16-赋值运算符，17-比较运算符，18-逻辑运算符，19-短路
public class OperateDemo2 
{

	public static void main(String[] args)
	{   /*
//		int x,y,z;
//		x=y=z=3;        
		
		int a=3;
		a+=4;
		System.out.println("a="+a);
		
		short s=4;
		//s=s+5;//挂了，编译通不过
		s+=5;//编译通过，正确，+=有自动转换的功能
		
		*/
		
		
//		System.out.println(3<4);//结果要么true要么false
//		int x=2;
//		System.out.println((x<4)&&(x>-1));
		
		int x1=2;
		int x2=3;
		System.out.println(x1<x2?x1:x2);//三元，true计算：左，false就计算：右边的
		
		int a=3<<2;
		System.out.println(a);
	}

}
