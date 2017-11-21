package day13_0803;//10-创建线程方式2：实现Runnable接口

/*
 创建线程的第二种方式：实现Runnable接口
 	1.定义一个类实现Runnable
 	2.覆盖Runnable接口中的run方法，线程要运行的任务代码存储到该方法中。
 	3.通过Thread类创建线程对象，并将实现了Runnable接口的对象作为Thread类的构造函数的参数进行传递。
 	4.调用Thread类的start方法，开启线程。
 	
 	
 实现Runnable接口的好处：
 	1.避免了继承Thread类的单继承的局限性。
 	2.Runnable接口出现更符合面向对象，将线程单独进行对象的封装。
 	3.Runnable接口出现，降低了线程对象和线程任务的耦合性。
 	
 	所以，以后创建线程都使用第二种方式。
 */

class SaleTicket implements Runnable{
	private int tickets=100;
	public void run(){
		while(true){
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+"..."+tickets--);
			}
		}
	}
}



public class TicketDemo2 {
	public static void main(String[] args) {
		//线程任务对象
		SaleTicket t=new SaleTicket();
		//创建四个线程
		Thread t1=new Thread(t);   //new一个线程对象，去绑定任务
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
