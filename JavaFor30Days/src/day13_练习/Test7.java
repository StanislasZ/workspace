package day13_��ϰ;

class A{
	void fun1(){
		System.out.println(fun2());   //fun2 ��this.fun2     A a=new B();
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
		b.fun1();    //���ø����fun1, this���������A�ָ࣬���������
		a=b;
		a.fun1();
		
	}

}
