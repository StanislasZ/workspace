package day13_0803;   //04-单线程的问题,05-创建线程方式（继承Thread类），06-调用

/*
 如何开辟一个执行路径呢？
 
 通过查阅API文档 java.lang.Thread类。
 该类的描述中有创建进程的两种方式：
 	1.继承Thread类
 		1.继承Thread类
 		2.覆盖run方法
 		3.创建子类对象就是创建线程对象
 		4.调用Thread类中的start方法就可以执行线程。并会调用run方法
 	
 	start()开始线程后，都会执行run方法。说明run方法中存储的是线程要运行的代码。
 	所以，记住，自定义线程的任务代码都存储在run方法中。
 	
 	调用start和调用run方法的区别？
 		调用start会开启线程，让开启的线程去执行run方法中的线程任务
 		
 		直接调用run方法，线程并为开启，去执行run方法的只有主线程
 */


class Demo extends Thread{
	private String name;
	Demo(String name){
		this.name=name;
	}
	public void run(){  //核心
		show();
	}
	void show(){
		for(int i=1;i<=10;i++){
			//System.out.println(this.getName()+name+"..."+i);
			System.out.println(Thread.currentThread().getName()+name+"..."+i);
		}
	}
	
}


public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1=new Demo("张三");
		Demo d2=new Demo("麻子");
		
		d1.start();    //开启线程，调用run方法
		d2.start();    //开启线程，调用run方法
		
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
		System.out.println("主线程结束");
	}

}
