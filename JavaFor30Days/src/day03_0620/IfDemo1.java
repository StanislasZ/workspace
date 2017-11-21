package day03_0620;
//day03-26控制流程,27，28-if,
public class IfDemo1
{

	public static void main(String[] args) 
	{   
		
		//2.if格式2
		/*
		 if(条件表达式)
		 {
		 	执行语句;
		 }
		 else//否则
		 {
		 	执行语句;
		 }
		 */
		int b=1,c;
		if(b>1)
		{
			c=100;
						
		}
		else
		{
			c=200;
		}
		//和三元运算符很像，理解为三元运算符是if else的简写格式
		//不是所有的if else都能简化。因为三元运算符运算完必须有结果
		
		//格式3：if   else if  else
		int i=3;
		if(i>1)
		{
			System.out.println("a");
		}
		else if(i>2)
		{
			System.out.println("b");
		}
		else if(i>3)
		{
			System.out.println("c");
		}
		else
		{
			System.out.println("d");
		}
		
		
		
		
		
	}

}
