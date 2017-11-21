package day15_0815;
import java.util.concurrent.locks.*;

/*
 边生产，边消费
 */
class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition();    //非满监视器
   final Condition notEmpty = lock.newCondition();    //非空监视器

   final Object[] items = new Object[10];
   int putptr, takeptr, count=0,sum=0;

   public void put(Object x) {   //对象：面包
     lock.lock();
     try {
       while (count == items.length) 
    	   try{notFull.await();}catch(InterruptedException e){}
       items[putptr] = x; 
       System.out.println(Thread.currentThread().getName()+"...生产者..."+x.toString()+putptr);
       if (++putptr == items.length) putptr = 0;  //满了就从0开始计数
       ++count;sum++;
       notEmpty.signal();   //唤醒另一方
     } finally {
       lock.unlock();
     }
   }

   public Object take() {
     lock.lock();
     try {
       while (count == 0) 
    	   try{notEmpty.await();}catch(InterruptedException e){}
       Object x = items[takeptr]; 
       System.out.println(Thread.currentThread().getName()+"......消费者..."+x.toString()+takeptr);
       if (++takeptr == items.length) takeptr = 0;  //到了就从0继续取
       --count;
       notFull.signal();  //唤醒另一方
       return x;
     } finally {
       lock.unlock();
     }
   } 
 }

//生产者
class Producer1 implements Runnable{
	private BoundedBuffer buf;
	String a="面包";
	Producer1(BoundedBuffer buf){
		this.buf=buf;
	}
	public void run() {
		while(buf.sum<105)
			buf.put(a);
		}
}
//消费者
class Consumer1 implements Runnable{
	private BoundedBuffer buf;
	Consumer1(BoundedBuffer buf){
		this.buf=buf;
	}
	public void run(){
		while(buf.sum<105)
			buf.take();
	}
}






public class API_example {
	public static void main(String[] args) {
		//创建资源
		BoundedBuffer buf=new BoundedBuffer();
		//创建两个任务
		Producer1 pro=new Producer1(buf);
		Consumer1 con=new Consumer1(buf);
		//创建线程
		Thread t0=new Thread(pro);
		//Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		//Thread t3=new Thread(con);
		
		t0.start(); t2.start(); //t1.start(); t3.start();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
