package day07_0630;
//day07-01，02-构造函数04，05-默认构造函数（书里124）
class Person{
	private String name;
	private int age;
	
	//定义一个构造函数，创建对象时直接初始化一部分。
	Person(String n,int a){     
		if(a<0)	return;
		name=n;
		age=a;
		//show();
	}
	
	//定义一个构造函数，创建对象时只初始化年龄
	Person(int a){
		age=a;
	}
	
	//定义一个构造函数，创建对象时只初始化姓名
	Person(String n){
		name=n;
		 
	}
	//以上三个是函数的重载
	Person(){   //这个也是重载！！！定义这个是为了初始化时没有填入参数时避免出错！！！
		name="baby";
	}
	
	public void setName(String n){  //设置名字，改名的时候调用这个方法
		name=n;
	}
	public String getName(){     //访问名字
		return name;
	}
	
	public void setAge(int a){   //设置年龄
		age=a;
	}
	public int getAge(){        //访问年龄
		return age;
	}
	//用于显示名字和年龄的方法。
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
}
/*
之前定义的函数都是一般函数。用于描述事物应该具备的功能。
 
构造函数：也是功能，只不过这个功能有点特殊，专门用于给对象进行初始化。
 
格式：
	1.函数名和类名相同
	2.没有返回值类型
	3.没有具体的返回值
 
一般函数和构造函数有什么区别？
运行上的区别？
	构造函数在对象创建对象时就执行了。而且只执行一次。
	一般函数是在对象创建后，需要时才被对象调用，可以调用多次。
	
之前new对象时，也没有构造函数，那这个对象是怎么初始化的呢？
注意1：定义的每一个类中，都有一个默认的空参数构造函数
注意2：一旦在类中自定义了构造函数后，默认的构造函数就没有了

class Car{

     //Car(){}   //类中默认的空参构造函数，用于创建对象初始化
}

class CarDemo{
	main(){
	Car c=new Car();  //有一个默认的空参数
	}
	
}

构造函数中有return语句吗？
yes，用于结束初始化

class Person{
	void Person(){     //一般函数。可以存在，不符合书写规范
	
	}
}

构造函数是可以私有化的，只在本类中使用。
而且构造一旦私有化，其他程序就无法创建该类对象。原因：无法初始化


*/

public class PersonDemo07_01 {
	public static void main(String[] args) {
		//创建一个Person对象。需求：Person对象一建立就有姓名和年龄，
		//相当于要对对象进行初始化。Java中的构造函数就可以解决该问题。
		
		Person p=new Person("旺财",5);    //创建对象，直接初始化
		
		
//		p.setName("Zhao");
//		p.setAge(23);
		p.show();
		
		Person p1=new Person("图哥");
		p1.show();
		
		Person p2=new Person();   //如果Person中定义的构造函数中没有空参数的构造函数的话，这句话会出错！！！！
		p2.show();
			

	}

}
