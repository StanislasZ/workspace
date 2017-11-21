package day13_0803;  //安全问题，同步  ,13-同步的好处和弊端

/*
 多线程的安全问题。
 	
 	产生的原因：
 		1.线程任务中有共享的数据
 		2.线程任务有多条对共享数据的操作。一个线程在操作共享数据的过程中，其他线程参与了运算，造成了数据的错误。
 
 	解决的思想：
 		只要保证多条操作共享数据的代码在某一时间段被一条线程所执行，在执行期间不允许其他线程参与运算。
 	
 	咋保证呢？？？
 	用到了同步代码块。
 	synchronized(对象){
 		//需要被同步的代码。
 	}
 	
 	同步在目前情况下保证了一次只能有一个线程在执行。其他线程进不来。
 	这就是同步的锁机制
 	
 	好处：解决了多线程的安全问题
 	
 	弊端：降低效率。 
 	
 	有可能出现这样一种情况：多线程安全问题出现后，加入了同步机制，没有解决安全问题。咋办！！
 	
 	这时肯定是同步出了问题。只要遵守同步的前提，就可以解决。
 	
 	同步的前提：
 		多个线程在同步中必须使用同一个锁。这才是对多个线程同步。
 */

/*
 验证同步函数使用的是锁是this
 
 验证需求：
 	启动两个线程。
 	一个线程负责执行同步代码块（使用明锁）
 	另一个线程使用同步函数（使用this锁）
 	
 	两个执行的任务是一样的都是卖票。如果它们没有使用相同的锁，说明他们没有同步，会出现数据错误
 
 	怎么能让一个线程一直在同步代码块中，另一个线程在同步函数呢？
 	可通过切换的方式。
 	
 */



class SaleTicket3 implements Runnable{
	private int tickets=100;
	//定义一个boolean标记
	boolean flag=true;
	Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(this){
					if(tickets>0){
				
						try{Thread.sleep(10);}
						catch(InterruptedException e){
						//让线程到这里稍微停一下
						}
						System.out.println(Thread.currentThread().getName()+"..true.."+tickets--);
					}
				}
			}
		}
		else
			while(true)
				Sale();
	}
	public synchronized void Sale(){
		if(tickets>0){
			
			try{Thread.sleep(10);}
			catch(InterruptedException e){
			//让线程到这里稍微停一下
			}
			System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
		}
	}
}


public class TicketDemo3 {
	public static void main(String[] args) throws Exception{
		//线程任务对象
		SaleTicket3 t=new SaleTicket3();
		//创建四个线程
		Thread t1=new Thread(t);   //new一个线程对象，去绑定任务
		Thread t2=new Thread(t);
		//Thread t3=new Thread(t);
		//Thread t4=new Thread(t);
		t1.start();
		Thread.sleep(10);     //让主线程休眠10ms，t1run()时，flag就是true
		t.flag=false;
		t2.start();          //没有sleep的话，主线程瞬间把这三句给运行了，所以t1，t2都是按照false来运行Sale()
		//t3.start();
		//t4.start();

	}

}
