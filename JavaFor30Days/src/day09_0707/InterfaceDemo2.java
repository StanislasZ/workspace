package day09_0707;
//day09-44-接口多实现

/*
接口解决了什么问题呢？ 
*/

//多继承。好处：可以让子类具备更多的功能。弊端：调用的不确定性
/*
class Fu1{
	void show(){
		sop("fu1 show");
	}
}
class Fu2{
	void show(){
		sop("fu2 show");
	}
}
class Zi extends Fu1,Fu2{

}

Zi z= new Zi();
z.show();  //产生了调用的不确定性。原因在于方法主题内容不同。

Java中不直接支持多继承，而是对该机制进行改良。	
	通过接口来解决！！！！将多继承转换成了多实现

 
 
*/
/*
interface InterA{   //接口定义功能，具体咋整让子类去搞
	void show1();
}
interface InterB{
	void show2();
}
class SubInter implements InterA,InterB{    //多实现
	public void show1(){
		System.out.println("inter show1");
	}
	public void show2(){
		System.out.println("inter show2");
	}
}
*/
interface InterA{   //接口定义功能，具体咋整让子类去搞
	void show();
}
interface InterB{
	void show();
}
class SubInter implements InterA,InterB{    //多实现
	public void show(){
		System.out.println("inter show");
	}
	
}



public class InterfaceDemo2 {
	public static void main(String[] args) {
		SubInter in=new SubInter();
//		in.show1();
//		in.show2();
		in.show();   //运行的是覆盖的方法，避免了调用的不确定性
		

	}

}
