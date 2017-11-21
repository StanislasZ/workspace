package day14_0810;  //16-同步练习

/*
 两个储户，到同一个银行存钱，每个人存了3次，一次100。
 	1.描述银行
 	2.描述储户任务
 	
 分析多线程是否存在安全隐患。
 	1.线程任务中是否有共享的数据。
 	2.是否有多条操作共享数据的代码。
 	
 同步函数，其实就是加上了关键字synchronized进行修饰
 同步表现形式：1.同步代码块 2.同步函数
 	
 同步函数使用的锁是什么？？ 函数需要被对象调用，哪个对象不确定，但是都用this来表示
 这个锁就是this  见Demo3
 
 */

class Bank{
	private int sum;
	//private Object obj=new Object();
	public synchronized void add(int n){
		
		sum=sum+n;  //第一句
		try{Thread.sleep(5);}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+".."+"sum="+sum); //第二句
		
	}
}

class Customer implements Runnable{
	private Bank b=new Bank();  
	public void run(){
		for(int i=0;i<3;i++){
			b.add(100);
		}
	}
}




public class ThreadTest {
	public static void main(String[] args) {
		//创建任务对象
		Customer c=new Customer();
		Thread t1=new Thread(c);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
	}

}
