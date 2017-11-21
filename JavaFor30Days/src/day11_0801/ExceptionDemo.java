package day11_0801;

/*
 异常：Java程序在 运行 时期发生的不正常情况（问题）。
 
 	java就按照面向对象的思想对不正常情况进行描述和对象的封装。
 	
 	
 问题分两种：
 Throwable:定义了对于问题的共性的功能。
 	|--Error:由系统底层发生的。告诉jvm，jvm告诉使用者。修改代码。不做针对性处理
 	|--Exception:jvm发生。并告诉使用者。可以进行针对性的处理。
 	
 总结：
 	1.运行时发生。
 	2.符合面向对象，将问题描述并封装成对象。
 	3.error和exception的区别
 */


public class ExceptionDemo {

	public static void main(String[] args) {
		int[] arr=new int[1];
		System.out.println(arr[1]);  //编译能通过，运行通不过ArrayIndexOutOfBoundsException:1
		//发生问题时，jvm就将这个问题封装成了对象。
		//new ArrayIndexOutOfBoundsException(1);
		//抛出
		//throw new ArrayIndexOutOfBoundsException(1);
		//抛给main,main没有针对性的处理方式。继续往外抛给jvm
		//jvm就使用了默认的处理方式。将问题的名称+信息+位置在控制台上显示出来。告诉调用者
		
		
		
		
		
		//int[] arr=new int[1024*1024*100];  //OutOfMemoryError
	}

}
