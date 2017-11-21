package day15_0815;

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



class Res{
	private String name;
	private String sex;
	//定义标记
	private boolean flag=false;
	public synchronized void set(String name,String sex){
		if(flag)
			try{this.wait();}catch(InterruptedException e){}
		this.name=name;
		this.sex=sex;
		flag=true;
		this.notify();
	}
	public synchronized void out(){
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(name+"....."+sex);
		flag=false;
		this.notify();
	}
}
class Input implements Runnable{
	private Res r;
	Input(Res r){
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

class Output implements Runnable{
	private Res r;
	Output(Res r){
		this.r=r;
	}
	public void run(){
		while(true){
			r.out();
		}
	}
}


public class Test {
	public static void main(String[] args) {
		Res r=new Res();
		
		Input in=new Input(r);
		Output out=new Output(r);
		
		new Thread(in).start();
		new Thread(out).start();

	}

}
