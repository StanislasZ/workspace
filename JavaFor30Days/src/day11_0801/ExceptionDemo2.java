package day11_0801;   //03-异常处理方式,04-try&catch  06-throw和throws的区别

/*
 异常的处理。
 	两种：
 		1.遇到问题不进行具体的处理，而是继续抛给调用者。
 			通过throws关键字声明异常，告诉调用者处理。
 			
 		2.针对性的处理方式：捕获！
 		try{
 			
 			//有可能发生异常的代码
 			 
 		}
 		catch(异常类 变量){
 			
 			//这时真正的捕获，处理异常的代码
 			 
 		}
 		finally{
 		
 		}
  
  throw和throws有什么区别呢？
  
  	1.位置不同。
  		throws用在函数上，后面跟着的是异常类，可以跟多个
  		throw用在函数内，后面跟的是异常对象。
  		
  	2.功能不同。
  		throws用来声明异常，让调用者知道该功能有可能出现的问题，并由调用者可以给出预先的处理的方式
  		throw抛出具体的问题对象。执行到throw功能就已经结束了，跳转到调用者。并将具体的问题对象也抛给调用者。
  
  异常体系最大的特点就是体系中的类以及类产生的对象，都具备可抛性，意思是可以被throws和throw操作
 */

class Demo{
	/*
	 在编写功能时，编写者知道该功能有可能发生问题。而这个问题很容易来自于调用者传递的参数。
	 而导致功能无法运行。这时发生的问题就应该让调用者知道，并最好让调用者有预先的处理方式。
	 所以在定义功能时，需要在功能上对有可能发生的问题进行声明！！
	 */
	int div(int a,int b) throws Exception{ //声明异常
		if(b==0)
			throw new ArithmeticException("除0废了"); //抛出异常
		return a/b;
	}
}



public class ExceptionDemo2 {

	public static void main(String[] args) /*throws Exception方法1*/{
		Demo d=new Demo();
		
/*法2*/	try{
			int num=d.div(4,0);
			System.out.println("num="+num);
		}
/*法2*/	catch(Exception e){   
			//处理这个对象，可以使用该对象的方法。
			System.out.println("异常了");  //方法2：捕获异常
			System.out.println(e.getMessage()); //异常信息
			System.out.println(e.toString());   //异常名称+异常信息
			//e.printStackTrace();                //名字+信息+位置 jvm默认用这个处理方式
		}
		
		
		
		
		
		System.out.println("over");
	}

}
