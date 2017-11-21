package day10_0711;     //54-多态中成员变量的调用，55-成员函数

/*
 多态中对成员的调用。
 	1.成员变量
 		当子父类出现同名成员变量时。
 			在多态调用时，只看调用该成员变量的引用所属的类中的成员变量。
 			简单说：无论编译或者运行，都看等号的左边！！！！
 	
 	2.成员函数
 		出现一模一样函数时
 			多态调用，编译时看的是引用变量所属的类中的方法。
 					  运行时看的是对象所属的类中的方法。
 			简单说：编译看左边，运行右边。
 			
 			成员方法动态绑定到当前对象上。
 			
 	3.静态函数
 		出现一模一样函数时，
 			多态调用，编译和调用时看引用变量所属的类中的方法
 			简单说：编译运行看左边。
 			
 			真正调用静态方法是不需要对象的。直接类名调用。
 			
 			所以上述情况，更多用于面试
 
 */
class Fu{
	int num=4;
	void show(){
		System.out.println("fu show");
	}
	static void staticMethod(){
		System.out.println("fu static method");
	}
}
class Zi extends Fu{
	int num=6;
	void show(){
		System.out.println("zi show");
	}
	static void staticMethod(){
		System.out.println("zi static method");
	}
}


public class DuoTaiDemo3 {
	public static void main(String[] args) {
//   	==========成员变量=====================
//		Fu f=new Fu();
//		f.num=8;
//		
//		Zi z=new Zi();
//		System.out.println(z.num);
		

//		Fu f=new Zi();
//		System.out.println(f.num);  //f被提升为了Fu，调用的是Fu类的num
	
//		==========成员函数====================
//		Fu f=new Zi();
//		f.show();       //结果为zi show(覆盖）
		
//===============静态函数========================
		Fu f=new Zi();
		f.staticMethod();       
	
		Zi z=(Zi)f;
		z.staticMethod();
	}

}
