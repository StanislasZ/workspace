package day11_0801;

/*
 异常的原则：
 	1.功能内部有异常throw抛出，功能上一定要throws声明。
 	  内部抛什么，功能上就声明什么。声明是为了让调用者处理，如果不处理，编译失败。
 	
 	2.特殊情况：
 		当函数内通过throw抛出了RuntimeException及其子类的异常对象时，函数上可以不用throws声明
 		不声明的目的就是不让调用者处理。让调用者的程序停止。要对代码进行修改。
 		
 	Exception分两种：
 		1.编译时会被检测的异常
 		2.运行时异常（编译时不检测）RuntimeException
 */

class Demo2{
	int div(int a,int b) /*throws Exception*/{
		if(b==0)
			throw new ArithmeticException("被0除，错误");
		return a/b;
	}
}


public class ExceptionDemo3 {
	public static void main(String[] args) /*throws Exception*/{
		Demo2 d=new Demo2();
		try{
			int num=d.div(4,0);
			System.out.println("num="+num);
		}
		catch(Exception e){  
			//处理这个对象，可以使用该对象的方法。
			//System.out.println("异常了");  //方法2：捕获异常
			//System.out.println(e.getMessage()); //异常信息
			System.out.println(e.toString());   //异常名称+异常信息
			//e.printStackTrace();                //名字+信息+位置 jvm默认用这个处理方式
		}
						
		System.out.println("over");
		
		int[] arr=new int[3];
		//arr=null;
		System.out.println("element:"+getElement(arr,-2));
		
	}

	public static int getElement(int[] arr,int index){
		if(arr==null){
			throw new NullPointerException("数组实体不存在");
		}
		if(index<0||index>arr.length-1){
			throw new ArrayIndexOutOfBoundsException(index+",角标不存在");
		}
		int element=arr[index];
		return element;
	}
	
	
}
