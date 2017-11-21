package day11_0801;  //09-自定义异常

/*
 在自定义的程序中，如果有了问题，也可以像java中的异常一样。对问题进行描述。
 
 举例：
 	定义一个功能可以实现除法运算，但是除数不可以为负数。
 */
//将负数为除数的问题描述
class FushuException extends RuntimeException{
	FushuException(){
		super();
	}
	
	FushuException(String message){
		super(message);   //向上传递
	}
}

class Demo3{
	int div(int a,int b){
		if(b<0)
			throw new FushuException("负数不可以做除数");
		if(b==0)
			throw new ArithmeticException("被0除了");
		
		
		return a/b;
	}
}


public class ExceptionDemo4 {
	public static void main(String[] args) {
		Demo3 d=new Demo3();
		try{
			int num=d.div(4, -1);
			System.out.println("num="+num);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("over");
	}

}
