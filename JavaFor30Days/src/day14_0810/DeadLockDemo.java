package day14_0810;  //验证static同步函数锁是类名.class

/*
 死锁：
 	场景1：同步嵌套
 
 */

class SaleTicket5 implements Runnable{
	private static int tickets=100;
	//定义一个boolean标记
	boolean flag=true;
	static Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(obj){   //obj lock     
					Sale();
				}
			}
		}
		else
			while(true)
				Sale();
	}
	public static synchronized void Sale(){   //this lock
		synchronized(obj){
			if(tickets>0){
				try{Thread.sleep(10);}
				catch(InterruptedException e){//让线程到这里稍微停一下
				}
				System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
			}
		}
	}
}


public class DeadLockDemo {
	public static void main(String[] args) throws Exception{
		//线程任务对象
		SaleTicket5 t=new SaleTicket5();
		//创建线程
		Thread t1=new Thread(t);   //new一个线程对象，去绑定任务
		Thread t2=new Thread(t);
		
		t1.start();
		Thread.sleep(10);     //让主线程休眠10ms，t1run()时，flag就是true
		t.flag=false;
		t2.start();          //没有sleep的话，主线程瞬间把这三句给运行了，所以t1，t2都是按照false来运行Sale()
		
	}

}
