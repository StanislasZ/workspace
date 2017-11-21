package day14_0810;
/*
 多生产多消费。
 重复生产，重复消费
 	原因：经过分析，发现被唤醒的线程没有判断标记就开始工作，导致了重复的生产和消费的发生。
 	
 	解决：被唤醒的线程必须判断标记。
 		  使用while循环，对标记进行多次判断
 		  
 问题2：死锁了，所有的线程都处于冻结状态。
 		原因：本方线程在唤醒时，又一次唤醒了本方线程。而本方线程循环判断标记，又继续等待，而导致所有的线程都等待了（冻结）
 		
 		解决：希望本方如果唤醒了对方线程，就可以解决。
 			  可以唤醒notifyAll()方法。
 			  那不就全唤醒了吗？是的，既有本方，又有对方。但是本方醒后，一判断标记又去睡觉了(这一步降低了效率)。对方就有线程可以执行了。
 	
 已经实现了多生产多消费。但是有些小问题，效率有点低，因为notifyAll也唤醒了本方。做了不必要的判断。
 */


//描述资源
class Resource3{
	private String name;
	int count=1;
	//定义标记
	private boolean flag=false;   //默认false
	//提供了给商品赋值的方法，让生产者调用
	public synchronized/*持有this锁*/ void set(String name) {
		
		while(flag)//判断标记为true，执行wait 为false，就生产
			try{this.wait();}catch(InterruptedException e){}
			
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			//生产完毕，将flag改为true
			flag=true;
			//唤醒所有等待的线程（包括本方线程）
			this.notifyAll();   
		
	}
	//同步方法结束后，锁释放。但可能生产者又抢到锁了，又进来，又生产 
	
	
	//提供一个获取商品的方法，让消费者调用
	public synchronized/*持有this锁*/ void get(){   //t2,t3
		
		while(!flag)
			try{this.wait();}catch(InterruptedException e){}
		
		System.out.println(Thread.currentThread().getName()+".....消费者..."+this.name);
		//将标记改为false
		flag=false;
		//唤醒生产者
		this.notifyAll();
		
	}
}

//生产者
class Producer3 implements Runnable{
	private Resource3 r;
	Producer3(Resource3 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.set("面包");
	
	}
}

//消费者
class Consumer3 implements Runnable{
	private Resource3 r;
	Consumer3(Resource3 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.get();
	}
}


public class ProducerConsumerDemo3_multi {

	public static void main(String[] args) {
		//创建资源
		Resource3 r=new Resource3();
		//创建两个任务
		Producer3 pro=new Producer3(r);
		Consumer3 con=new Consumer3(r);
		//创建线程
		Thread t0=new Thread(pro);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		Thread t3=new Thread(con);
		
		t0.start(); t1.start(); t2.start(); t3.start();

	}

}
