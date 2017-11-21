package day13_练习;

class A{
	void fun1(){
		System.out.println(fun2());   //fun2 是this.fun2     A a=new B();
	}
	int fun2(){
		return 123;
	}
}

class B extends A{
	int fun2(){
		return 456;
	}
}

public class Test7 {
	public static void main(String[] args) {
		A a;
		B b=new B();
		b.fun1();    //调用父类的fun1, this代表本类对象A类，指向子类对象
		a=b;
		a.fun1();
		
	}

}
