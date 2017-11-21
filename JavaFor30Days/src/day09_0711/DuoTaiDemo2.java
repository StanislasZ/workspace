package day09_0711;   //52-向上向下转型

abstract class Animal1{
	abstract void eat();
}

class Dog1 extends Animal1{
	void eat(){
		System.out.println("骨头");
	}
	void lookHome(){
		System.out.println("看家");
	}
}

public class DuoTaiDemo2 {
	public static void main(String[] args){
		Animal1 a=new Dog1();   //向上转型，狗被提升为了动物。只能当动物使用
		/*
		 向上转型好处：隐藏了子类型，提高了代码的扩展性 
		 		弊端：只能使用父类中的功能，不能使用子类特有功能。功能被限定了。//a.lookHome();//错
		 	
		 如果不需要面对子类型，通过提高扩展性，或者使用父类的功能即可完成操作，就使用向上转型
		 */
		
		//如果想要使用子类的特有功能呢？比如狗的看家功能
		
		if(!(a instanceof Dog1)){
			System.out.println("类型不匹配");
			return;
		}
		Dog1 d=(Dog1)a;    //向下转型,强制类型转换
		d.eat();
		d.lookHome();
		/*
		 向下转型的好处：可以使用子类型的特有功能
		 		    弊端：面对具体的子类型，向下转型有风险。容易发生ClassCastException
		 		    	类型不匹配就会发生。
		 		    	想要安全，必须要进行判断。判断一个对象是否匹配某一类型，
		 		    	需要使用一个关键字 instanceof
		 		    	用法： 对象  instanceof 类型
		 		    	
		 什么时候用向下转型：需要子类型的特有方法时，但一定要判断
		 */
		
	}
}
