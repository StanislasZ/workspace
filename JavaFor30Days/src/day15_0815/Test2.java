package day15_0815;
import java.util.concurrent.locks.*;
/*
 1.搞定妖的问题
 	分析：
 		1.共享数据  2.线程任务中有多条共享数据的代码。
 	
 	加了同步，问题依旧。看同步前提！
 	将输入和输出都加入同步，用同个锁，搞定。
 
 2.name和sex是私有的。需要在Res类中对外提供访问name和sex的方法。  已解决
  
 3.实现间隔输出，使用等待唤醒机制。
 	一般情况下要判断条件。   这里使用1.4之前的wait  notify 
 */



class Res2{
	private String name;
	private String sex;
	//定义标记
	private boolean flag=false;
	
	//定义锁
	private final Lock lock=new ReentrantLock();
	//获取监视器对象
	private Condition con=lock.newCondition();
	
	public void set(String name,String sex){
		lock.lock(); //获取锁
		try{
			while(flag)
				try{con.await();}catch(InterruptedException e){}
			this.name=name;
			this.sex=sex;
			flag=true;
			con.signal();
		}finally{
			lock.unlock();
		}
	}
	public void out(){
		lock.lock();
		try{
			while(!flag)
				try{con.await();}catch(InterruptedException e){}
			System.out.println(name+"....."+sex);
			flag=false;
			con.signal();
		}finally{
			lock.unlock();
		}
	}
}
class Input2 implements Runnable{
	private Res2 r;
	Input2(Res2 r){
		this.r=r;
	}
	public void run(){
		int x=0;
		
		while(true){
			if(x==0){
				r.set("张三","男");
			}
			else{
				r.set("rose","female");
			}
			x=(x+1)%2; 
		}
	}
}

class Output2 implements Runnable{
	private Res2 r;
	Output2(Res2 r){
		this.r=r;
	}
	public void run(){
		while(true){
			r.out();
		}
	}
}


public class Test2 {
	public static void main(String[] args) {
		Res2 r=new Res2();
		
		Input2 in=new Input2(r);
		Output2 out=new Output2(r);
		
		new Thread(in).start();
		new Thread(out).start();

	}

}
