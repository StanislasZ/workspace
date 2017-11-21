package day05_0628;
//day06-07，08-对象的内存体现，09-类类型的参数传递，10-匿名对象，11-成员变量和局部变量

//先用类构造对象，通过 对象.成员 来操作
class Car{
	int num;
	String color;
	void run(){              //定义类Car中的功能run
		System.out.println(num+":"+color);
	}
	
	
}

/*
 成员变量和局部变量的区别？
 	1.源代码中定义的位置不同
 		成员变量定义在类中。
 		局部变量定义在方法中（只要是类的下一级大括号都是局部的），也可以定义在语句里（for语句）
 	
 	2.内存中的存储位置不同
 		成员变量存储在堆内存的对象中
 		局部变量存储在栈内存的方法中。
 	
 	3.生命周期不同
 		成员变量随着对象的出现而出现
 		局部变量随着所属区间的运行出现，随着所属区间的结束而释放。（一旦用完就释放）
 
 */


public class CarDemo {

	public static void main(String[] args) {
		
		/*Car c1=new Car();   //建立的对象是根据Car.class搞出来的
     
		//指挥对象做事情。对象.对象成员，成员可以是属性变量或方法
		Car c2=c1;
		
		c1.num=6;
		c2.color="black";
		c1.run();  //调用方法
		*/
		
//		Car c1=new Car();
//		Car c2=new Car();
//		
//		show(c1);   //写成 show(new Car()); 也可以！！
//		show(c2);
		
		
		//匿名对象。没有名字的对象   new Car();  是简化定义
		// 它可以作为实际参数进行传递
		//如果 对象 对 方法 只进行一次调用，可以简化为匿名对象的形式
		
		/*
		 Car c=new Car();
		 c.run();
		 可以简化为  new Car().run();
		 */
		
		//提问,下面代码的结果是？    0:null
		new Car().num=4;
		new Car().color="black";
		new Car().run();
		
		
		
		
	}
	//怎么提高复用性
	public static void show(Car c){    //将传递进来的汽车添加4个轮胎，刷上红色，让其运行起来
		c.num=4;
		c.color="red";
		c.run();
	}
	
	

}
