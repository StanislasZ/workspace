package generic.demo;

import domain.Student;
import domain.Worker;

public class GenericDemo4 {

	public static void main(String[] args) {
		
//		Tool tool=new Tool();
//		
//		tool.setObj(new Student());   //多态存
//		Student stu=(Student)tool.getObj();  //取要向下转型
//		
//		System.out.println(stu);
		
		Util<Student> util=new Util<Student>();
		util.setObj(new Student());              //如果写Worker直接编译报错 
		Student stu=util.getObj();  //避免了向下转型
		System.out.println(stu);
		
		
		
	}

}
/*
 * 创建一个用于操作Student对象的工具类，对 对象 进行设置和获取。
 * 太有局限性了，可不可以定义一个可以操作所有对象的工具呢？
 * 类型向上抽取。当要操作的对象类型不确定的时候，为了扩展
 * 可以使用Object类型来完成
 * 但是这种凡是有弊端，会出现转型，向下转型容易在运行时期发生ClassCastException
 * 
 * jdk1.5以后，新的解决方案
 * 类型不确定时，可以对外提供参数，由使用者通过传递参数的形式完成类型的确定
 */


//在类定义时就明确参数。由使用该类的调用者，来传递具体的类型。
class Util<W>{  //泛型类
	private W obj;

	public W getObj() {
		return obj;
	}

	public void setObj(W obj) {
		this.obj = obj;
	}
	
}




//jdk1.4

class Tool{
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
