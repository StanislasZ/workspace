package day10_0717;   //57,58-equals，59-toString(建议重写)

//Object:java语言中上帝。所有类的父类。其中定义了所有对象都具备的功能。
//类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。

class Person extends Object{
	private int age;
	private String name;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	//定义一个方法，判断两个Person对象是否是同一个。
	//判断的依据是根据年龄。如果年龄相同，视为同一个人。
	
	
	//public boolean compare(Person p){}
	/*不用再自定义方法，判断对象是否相同，因为Object父类中，已经定义了这样的方法。	
	直接使用就可以了。但是判断的内容是根据Person的特点定义的。
	需要保留父类的功能声明，定义子类功能的特有内容。
	
	使用覆盖！！！！！
	*/
	
	public boolean equals(Object obj){ //Object obj=new Person(); 传进来的对象被强行提升为了Object类
		
		//提高点效率。如果两个引用指向的是同个对象，不用再转换并比较内容
		if(this==obj)
			return true;
		
		
		//return (this.age==obj.age);   //obj被提升为Object类，父类中没有age，编译失败
		
		//要想使用子类对象的特有属性或者行为，必须对其进行向下转型。  需要进行类型判断！！！
		if(!(obj instanceof Person))
			return false;
			//throw new ClassCastException("类型错误");
		Person p=(Person)obj;
		//如果判断String是否相同。不要用==， 字符串本身是一个对象
		return this.age==p.age&&this.name.equals(p.name);
	}
	//总结思路：第一步：为了覆盖，名称，参数类型都要一样。第二步：为了使用子类的属性，要向下转型！！

	/**
	 建立Person对象特有的字符串表现形式。只要覆盖toString方法即可。
	 */
	public String toString(){
		return "Person[name="+this.name+",age="+this.age+"]";
	}


}

class Demo{}

public class ObjectDemo {

	public static void main(String[] args) {
		
//		Person p1=new Person();
//		Person p2=new Person();
//		Person p3=p1;
//		
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.equals(p3));
		
		//System.out.println(p1.equals(new Demo())); //错误 Demo类没有age
		
		Person p1=new Person("lisi",21);
		Person p2=new Person("zhangsan",22);
		
		System.out.println(p1.equals(p2));  //判断的是对象的内容。用equals
		System.out.println(p1==p2);           //判断的是对象的地址
		
		
		System.out.println(p1/*.toString()*/);  //
		System.out.println(p2/*.toString()*/);  //
	}

}
