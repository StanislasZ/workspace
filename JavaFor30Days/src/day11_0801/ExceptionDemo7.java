package day11_0801;//覆盖中异常的使用

/*
 Exception
 	|--AException
 		|--AAException
 	|--BException
 
 覆盖时：
 子类方法覆盖父类方法只能抛出父类方法异常或者该异常的子类。
 如果父类方法抛出多个异常，子类只能抛出父类异常的子集。
 
 原则：子类的异常必须要在父类的异常处理控制中。
 
 注意：有一种情况，只能try不能throws
 	被覆盖的方法没有抛出异常，那么子类在覆盖时，子类方法中发生了异常，就只能try，无法throws声明
 
 interface Inter{
	void show();

 }
 class Demo implements Inter{
 	public void show(){
 		try{
 			throw new Exception();
 		}
 		catch(Exception e){
 			throw new RuntimeException("");//将编译时检测异常，转换成运行时异常。这样就不用声明。
 		}
 	}
 }
 
 
 *
 */



class AException extends Exception{
	
}
class BException extends Exception{
	
}
class AAException extends AException{
	
}
class Fu{
	void show() throws AException{
		System.out.println("fu show");
	}
}
class Zi extends Fu{
	void show() throws AAException{
		System.out.println("zi show");
	}
}

class Tool{
	void method(Fu f){
		try{
			f.show();
		}
		catch(AException e){
			
		}
	}
}





public class ExceptionDemo7 {
	public static void main(String[] args) {
		Tool t=new Tool();
		t.method(new Zi());  //笔记07.12多态，成员函数，运行看右边

	}

}
