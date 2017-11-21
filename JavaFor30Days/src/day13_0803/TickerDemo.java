package day13_0803;

/*
 没解决问题。产生了400张票。不合适，不建议票变成静态的，如何共享100张票呢？？？
 */
class SaleTicket9 extends Thread{
	private int tickets=100;
	
	//卖票的代码需要被多个线程执行，所以要将这些代码定义在线程任务中。run 方法
	public void run(){
		while(true){
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+"...."+tickets--);
				
			}
		}
	}
//	public synchronized int sellTicket() {
//		  
//		 return tickets--;
//	}

}

public class TickerDemo {
	public static void main(String[] args) {
		//创建四个线程
		SaleTicket9 t1=new SaleTicket9();
		SaleTicket9 t2=new SaleTicket9();
		SaleTicket9 t3=new SaleTicket9();
		SaleTicket9 t4=new SaleTicket9();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
