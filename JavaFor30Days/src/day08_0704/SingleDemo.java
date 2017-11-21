package day08_0704;
//day08-17-设计模式,18，19，20，21,22-单例     getInstance()
/*
 设计模式：解决某一种问题的一种思想。是一种行之有效的解决方式。
 
 23种模式。
 
 之一： 单例设计模式。
 解决的问题：保证一个类的对象在内存中的唯一性。
 应用场景：多个程序都在操作同一个配置文件时，需要程序A操作后的结果。
 			程序B要知道，并继续基于A操作后的结果进行操作。
 			前提，数据都存储在配置文件对象中，要求程序A和程序B操作的配置文件对象是同一个。
 
 怎么实现呢？  怎么可以保证这个类只能产生一个对象呢？
 
 思路：
 	1.问题是其他程序都可以通过new创建该类的对象。无法控制数量。
 	   所以，不让其他程序new就拿下！
 	   
	2.那第一步的问题也产生了，那其他程序不就没有对象了吗？
	   干脆，在本类中自己new一个本类对象。这样的好处是，不让别的程序new，自己new,可以实现数量的控制
	  	
	3.对外提供让其他程序获取该对象的方式，就拿下了！
	
步骤：
	1.不让其他程序new该类对象，咋办？
		可以将类中的构造函数私有化
	
	2.在本类中new一个对象。
	
	3.定义一个方法返回（获得）该对象。
	
代码体现：
 
 */

class Single{    //饿汉式
	//创建一个本类对象
	private static Single s=new Single();  //私有之后，getIns是必须的
		
	private Single(){		//构造函数私有化
	
	}
		
	//定义一个方法返回该对象。让其程序可以获取到。	
	static Single getInstance(int num){     //必须静态，才能被访问到;定义这个就是为了可控
		if(num<0)return null;
		return s;
	}
		
}
/*
 //另外一种形式。  也称为 延迟加载方式。
  
class Single{      //懒汉式 
	private static Single s=null;
	private Single(){
	}
	public static Single getInstance(){
		if(s==null)
			s=new Single();
		return s;
	}
}
			
			
			
			
			
 */

public class SingleDemo {
	public static void main(String[] args) {
		
		Single s1=Single.getInstance(1);
		Single s2=Single.getInstance(1);  //s2=s1
		
		//超人只有一个
		
		
		
		
		Superman s3=Superman.getInstance();
		
		
		Superman s4=Superman.getInstance();
		s4.setName("hero");                          //s3,s4指向同一个东西
		
		System.out.println(s3.getName());
		System.out.println(s4.getName());
	}
}
class Superman{
	private String name;
	
	private static Superman man=new Superman("GREEN ARROW");
	
	private Superman(String name){ //构造函数私有
		this.name=name;
	}
	public static Superman getInstance(){
		return man;
	}
		
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}













