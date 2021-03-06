package day14_0810;

/*
 多线程间的通信。多个线程都在处理同一个资源，但是处理的任务却不一样。
 生产者，消费者
 
 通过同步，解决了没生产就消费的问题。
 
 但是出现了连续的生产没有消费的情况，和需求生产一个就消费一个的情况不符。
 
 使用了等待唤醒机制。
 wait():让线程处于冻结状态，并将线程临时存储到线程池中。
 notify():唤醒线程池中指定的一个线程。
 notifyAll():唤醒线程池中所有线程。
 */


// 描述资源
class Resource{
	private String name;
	private int count=1;
	//提供了给商品赋值的方法，让生产者调用
	public synchronized void set(String name){
		this.name=name+"--"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
	}
	//同步方法结束后，锁释放。但可能生产者又抢到锁了，又进来，又生产 
	
	
	//提供一个获取商品的方法，让消费者调用
	public synchronized void get(){
		System.out.println(Thread.currentThread().getName()+".....消费者..."+this.name);
	}
}

//生产者
class Producer implements Runnable{
	private Resource r;
	Producer(Resource r){
		this.r=r;
	}
	public void run(){
		r.set("面包");
	}
}

//消费者
class Consumer implements Runnable{
	private Resource r;
	Consumer(Resource r){
		this.r=r;
	}
	public void run(){
		r.get();
	}
}


public class ProducerConsumerDemo多线程间的通信 {
	public static void main(String[] args) {
		//创建资源
		Resource r=new Resource();
		//创建两个任务
		Producer pro=new Producer(r);
		Consumer con=new Consumer(r);
		//创建线程
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		
		t1.start();
		t2.start();
		
		

	}

}
