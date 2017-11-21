package day15_0815;
import java.util.concurrent.locks.*;

/*
 ��������������
 */
class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition();    //����������
   final Condition notEmpty = lock.newCondition();    //�ǿռ�����

   final Object[] items = new Object[10];
   int putptr, takeptr, count=0,sum=0;

   public void put(Object x) {   //�������
     lock.lock();
     try {
       while (count == items.length) 
    	   try{notFull.await();}catch(InterruptedException e){}
       items[putptr] = x; 
       System.out.println(Thread.currentThread().getName()+"...������..."+x.toString()+putptr);
       if (++putptr == items.length) putptr = 0;  //���˾ʹ�0��ʼ����
       ++count;sum++;
       notEmpty.signal();   //������һ��
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
       System.out.println(Thread.currentThread().getName()+"......������..."+x.toString()+takeptr);
       if (++takeptr == items.length) takeptr = 0;  //���˾ʹ�0����ȡ
       --count;
       notFull.signal();  //������һ��
       return x;
     } finally {
       lock.unlock();
     }
   } 
 }

//������
class Producer1 implements Runnable{
	private BoundedBuffer buf;
	String a="���";
	Producer1(BoundedBuffer buf){
		this.buf=buf;
	}
	public void run() {
		while(buf.sum<105)
			buf.put(a);
		}
}
//������
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
		//������Դ
		BoundedBuffer buf=new BoundedBuffer();
		//������������
		Producer1 pro=new Producer1(buf);
		Consumer1 con=new Consumer1(buf);
		//�����߳�
		Thread t0=new Thread(pro);
		//Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		//Thread t3=new Thread(con);
		
		t0.start(); t2.start(); //t1.start(); t3.start();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
