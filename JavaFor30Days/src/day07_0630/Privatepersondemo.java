package day07_0630;
//day07-07-构造函数私有化，间调用
class Person1{
	private String name;
	private int age;
	
	Person1(){ 
		name="baby";
	}
	private Person1(String n){
		name=n;
	}
	/*
	 构造函数私有，只在本类中有效。该如何访问呢？
	 注意1：构造函数只能被构造函数调用，不能直接被一般方法调用
	 构造函数之间该如何访问呢？通过this来解决
	 
	 this:代表的是对象。代表哪个对象呢
	 哪个对象调用this所在的函数，this就代表哪个对象
	 
	 this带上参数列表的方式可以访问本类中的其他构造函数。
	 比如:this("lisi"):访问的就是本类中，带一个字符串参数的构造函数。
	 
	 记住：用于调用构造函数的this语句必须定义在构造函数的第一行。因为初始化动作要先执行。
	 
	 总结：只要直接被对象调用的方法都持有this引用。凡是访问了对象中的数据的方法都持有this引用
	 
	 */
	Person1(String n,int a){     
		this(n);    //只能写一个this
		//name=n;
		age=a;
	}
	Person1(int a){
		age=a;
	}
	
	
	
	
	//用于显示名字和年龄的方法。
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
}

/*
 如何访问一个构造函数？
 */
public class Privatepersondemo {
	public static void main(String[] args) {
		Person1 p=new Person1("旺财",5);    //创建对象，直接初始化
		
		

		p.show();
		
		Person1 p1=new Person1("图哥",20);
		p1.show();
		
		Person1 p2=new Person1();   //如果Person中定义的构造函数中没有空参数的构造函数的话，这句话会出错！！！！
		p2.show();

	}

}
