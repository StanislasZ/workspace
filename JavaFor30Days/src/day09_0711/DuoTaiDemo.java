package day09_0711;//49-多态，50-代码体现

/*
多态：多种形态

	对象的多态性。

class 动物{

}
class 狗 extends 动物{
	
}
//狗 x=new 狗();

动物 x=new 狗();   //狗实例既是狗类型，又是动物类型。多态性。

多态在程序中的体现：父类的引用或者接口的引用指向了子类的对象。

多态的好处：提高了代码的扩展性。

多态的弊端：不能使用子类的特有方法。

多态的前提：
	1.必须有关系，继承，实现。
	2.通常有覆盖。
*/

abstract class Animal{
	abstract void eat();
}

class Dog extends Animal{
	void eat(){
		System.out.println("骨头");
	}
	void lookHome(){
		System.out.println("看家");
	}
}

class Cat extends Animal{
	void eat(){
		System.out.println("鱼");
	}
	void CatchMouse(){
		System.out.println("抓老鼠");
	}
}

public class DuoTaiDemo {

	public static void main(String[] args) {
		/*
		//Dog d=new Dog();
		Animal a=new Dog();  //多态形式
		a.eat();
		Animal b=new Cat();
		b.eat();
		*/
		
		Dog d1=new Dog();
		Dog d2=new Dog();
		Dog d3=new Dog();
		method(d1);
	}
	public static void method(Dog d){
		d.eat();
	}
	
	public static void method(Cat c){
		c.eat();
	}
	//以上两个面对狗， 猫。 既然调用的都是eat,是共性。 为什么不面对动物呢
	//直接定义共性类型的参数更合适
	public static void method(Animal a){  //接收  狗类，猫类
		a.eat(); 
		//a.lookHome();    //
	}
}
