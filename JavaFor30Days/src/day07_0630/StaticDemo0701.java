package day07_0630;
//day07-10-静态方法,11-静态变量，12，13-静态特点
/*
 静态关键字static:
 是什么？  成员修饰符
 有什么特点：
 	1.被静态修饰的成员可以被类名所调用。
 	2.静态成员优先于对象存在。
 	3.静态成员随着类的加载而加载，随着类的消失而消失。静态成员生命周期很长。
 	
 注意事项：
 1.静态方法只能访问静态成员，不能访问非静态成员。这就是静态方法的访问局限性。
 2.静态的方法中不能出现this或者super关键字
 3.主函数是静态的。
 
 成员变量和静态变量的区别？
 1.成员变量也叫实例变量      ；   静态变量也叫类变量
 2.
 */
class Person3{
	private String name;
	private int age;
	
	static String country="CN";  //加上static可以节省内存空间，不会存在于堆的每个对象中了
	
	Person3(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
	public static void sleep(){   
		System.out.println("呼呼"+country);
	}
	/*既然sleep没有访问到对象中的特有数据，那就不需要建立对象。
     
	 什么时候函数需要静态修饰呢？
	 该函数没有访问过对象中的属性时。就需要用静态修饰。
	 
	 */
}

public class StaticDemo0701 {

	public static void main(String[] args) {
		/*
		 如果创建对象调用sleep方法
		 发现，sleep并没有使用对象中的数据
		 该对象的建立是没有意义的。
		 
		 该方法属于Person类
		 可以通过类名的方式来访问。
		 注意：用类名直接调用的方法必须通过制定修饰符来修饰！！ 
		   
		   就是 static！！！
		 
		 */
		Person3 p=new Person3("lisi",21);
		p.show();
		Person3.sleep();
		//System.out.println(Person3.country);
		
		
	}

}
