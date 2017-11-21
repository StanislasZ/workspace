package day14_0810;
/*
  使用了等待唤醒机制。
 wait():让线程处于冻结状态，并将线程临时存储到线程池中。
 notify():唤醒线程池中指定的一个线程。
 notifyAll():唤醒线程池中所有线程。
 
 这些方法必须使用在同步中，因为它们是用来操作同步锁上的线程的状态的。
 
 在使用这些方法时，必须标识它们所属于的锁。标识方式就是锁对象.wait(); 锁对象.notify();   锁对象.notifyAll();
 
 相同锁的notify,可以获取相同锁的wait(); 
 */


//描述资源
class Resource2{
	private String name;
	int count=1;
	//定义标记
	private boolean flag=false;   //默认false
	//提供了给商品赋值的方法，让生产者调用
	public synchronized void set(String name) {
		
		if(flag)//判断标记为true，执行wait 为false，就生产
			try{this.wait();}catch(InterruptedException e){}
		this.name=name+"--"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		//生产完毕，将flag改为true
		flag=true;
		//唤醒消费者
		this.notify();   
		
	}
	//同步方法结束后，锁释放。但可能生产者又抢到锁了，又进来，又生产 
	
	
	//提供一个获取商品的方法，让消费者调用
	public synchronized void get(){
		
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(Thread.currentThread().getName()+".....消费者..."+this.name);
		//将标记改为false
		flag=false;
		//唤醒生产者
		this.notify();
		
	}
}

//生产者
class Producer2 implements Runnable{
	private Resource2 r;
	Producer2(Resource2 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.set("面包");
	
	}
}

//消费者
class Consumer2 implements Runnable{
	private Resource2 r;
	Consumer2(Resource2 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.get();
	}
}


public class ProducerConsumerDemo2_wait_notify {

	public static void main(String[] args) {
		//创建资源
		Resource2 r=new Resource2();
		//创建两个任务
		Producer2 pro=new Producer2(r);
		Consumer2 con=new Consumer2(r);
		//创建线程
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		
		t1.start();
		t2.start();

	}

}
