package day09_0707;
//day09-45-接口-避免了单继承的局限性

class Fu{
	void show(){
		System.out.println("fu show");
	}
}
interface Inter2{
	void show1();
}

/*因为继承Zi具备所属的体系具体了该体系的基本功能
	还想扩展一些功能，具备show1功能
	一个类继承一个类的同事，还可以实现多个接口。
	避免了单继承的局限性。
	
	继承是为了体系的基本功能。想要扩展功能可以通过实现接口来完成。
*/
class Zi extends Fu implements Inter2{ 
	public void method(){
		System.out.println("zi method");
	}
	public void show1(){
		System.out.println("zi show1");
	}
}



public class InterfaceDemo3 {
	public static void main(String[] args) {
		Zi z=new Zi();
		z.show();
		z.method();

	}

}
