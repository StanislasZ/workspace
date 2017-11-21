package day08_0705;
//day08-35-final关键字
/*
 final关键字。最终
 	1.final修饰符，可以修饰类，修饰方法，修饰变量
 	
 	2.final修饰的类不可以被继承。
 	
 	3.final修饰的方法不可以被覆盖
 	
 	4.final修饰的变量，成为了一个常量。只能赋值一次。
 	   当使用的数据不变时，需要定义阅读性强的名称来表示该数据，并将数据final化
 	   被final修饰的变量 名称规范是：所以字母都大写。如果由多个单词组成，需要通过下划线进行分隔
 */
class Fu3{  //里面的方法不想被复写，就不让你继承。final后不能再有子类
	/*final*/ void show(){    //show不能被覆盖
		//访问到的系统的内容
	}
}
class Zi3 extends Fu3{
	static final int num=4;    //通过类名.变量名来调用
	
	void show(){
		//
		final double PI=3.14;  //常量		
		System.out.println(PI);
	}
}





public class FinalDemo {

	public static void main(String[] args) {
		new Zi3().show();
		System.out.println(Zi3.num);
	}

}

class Single{
	private static final Single SINGLE_INSTANCE=new Single();
	private Single(){}
	public static Single getInstance(){
		return SINGLE_INSTANCE;
	}
}
/*
class Single1{
	private static final Single1 s=null;    //别加final 。 死！
	private Single1(){}
	public static Single1 getInstance(){
		if(s==null)
			s=new Single1();
		return s;
	}
}
*/
