package day11_0801;  //代码块组合方式

/*
 异常的针对性处理方式： try,catch,finally的几种组合方式
 
 1.没有资源需要释放，仅仅是处理异常
 	try，catch 
 
 2. 一个try，多个catch，被调用的函数抛出多个异常的情况。分别处理
 	try{}
 	catch(){}
 	catch(){}
 	注意：在多catch语法上特殊的地方，如果catch中的异常类存在子父类。父类的catch一定要放子类的下面。否则编译失败。
 
 3.try,finally（要掌握）不一定要处理异常，但有资源要释放
 
 */



public class ExceptionDemo6 {
	public static void main(String[] args) {
		
		
		
		

	}

}
