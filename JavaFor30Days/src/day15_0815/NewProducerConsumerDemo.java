package day15_0815;   //Lock接口
import java.util.concurrent.locks.*;  //导入包，Lock接口有现成的子类


/*
 解决多生产多消费的效率问题。
 使用了JDK1.5 java.util.concurrent.locks包中的对象
 Lock接口:它的出现比synchronized有更多操作
 		  lock() :获取锁
 		  unlock()  :释放锁
 		  
 同步代码块或者同步函数的锁操作是隐式的。（不利于理解和使用锁）
 JDK1.5 Lock接口，将锁单独封装成了一个对象。
 				 并提供了对锁的显式操作。
 
 Lock接口就是同步的替代。
 	1.将线程中的同步更换为Lock接口的形式。 
 	
 替换完运行失败。因为wait没有了同步区域，没有所属的同步锁。
 同步升级了。其中锁已经不是任意对象，而是Lock类型的对象。
 那么和任意对象绑定的监视器方法，是不是也升级了，有了专门和Lock类型锁的绑定的监视器方法呢
 
 查阅api后，发现Condition接口替代了Object中的监视器方法。
 
 以前监视器方法封装到每一个对象中，现在将监视器方法封装到了Condition对象中。
 方法名为：await   signal  signalAll
 
 监视器对象Condition如何和Lock绑定呢？
 可以通过Lock接口的newCondition方法完成
 
 但是，问题依旧，一样唤醒了本方。效率仍旧低！！
 */



//描述资源
class Resource{
	private String name;
	int count=1;
	
	Lock lock=new ReentrantLock(); //多态，创建锁
	private Condition producer_con=lock.newCondition();  //创建生产者监视器对象
	private Condition consumer_con=lock.newCondition();  //创建消费者监视器对象
	
	//定义标记
	private boolean flag=false;   //默认false
	//提供了给商品赋值的方法，让生产者调用
	public void set(String name) {
		//获取锁
		lock.lock();
		try{
			while(flag)//判断标记为true，执行wait 为false，就生产
				try{producer_con.await();}catch(InterruptedException e){}
				
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
			//生产完毕，将flag改为true
			flag=true;
			//生产完毕，应该唤醒一个消费者线程
			consumer_con.signal();   
		}finally{	
			//释放锁
			lock.unlock();
		}
	}
	//同步方法结束后，锁释放。但可能生产者又抢到锁了，又进来，又生产 
	
	
	//提供一个获取商品的方法，让消费者调用
	public void get(){   //t2,t3
		lock.lock();
		try{
			while(!flag)
				try{consumer_con.await();}catch(InterruptedException e){}
			
			System.out.println(Thread.currentThread().getName()+".....消费者..."+this.name);
			//将标记改为false
			flag=false;
			//消费完毕，唤醒一个生产者线程
			producer_con.signal();
		}finally{
			lock.unlock(); 
		}
	}
}

//生产者
class Producer implements Runnable{
	private Resource r;
	Producer(Resource r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
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
		while(r.count<100)
			r.get();
	}
}


public class NewProducerConsumerDemo {

	public static void main(String[] args) {
		//创建资源
		Resource r=new Resource();
		//创建两个任务
		Producer pro=new Producer(r);
		Consumer con=new Consumer(r);
		//创建线程
		Thread t0=new Thread(pro);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		Thread t3=new Thread(con);
		
		t0.start(); t1.start(); t2.start(); t3.start();

	}

}
