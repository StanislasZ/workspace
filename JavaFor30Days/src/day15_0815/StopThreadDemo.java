package day15_0815;  //线程停止

/*
 如何停止线程呢？
 
 原理：让run方法结束。
 	线程任务通常都有循环。因为开启线程就是为了执行一段代码。
 	
 	只要控制住循环，就可以结束run方法，就可以停止线程。
 	
 	控制循环弄个标记即可。
 	
 */


class StopThread implements Runnable{
	private boolean flag=true;
	public synchronized void run(){
		while(flag){
			try{
				wait();   //冻结后，interrupt可强制唤醒
			}catch(InterruptedException e){
				System.out.println(Thread.currentThread().getName()+"...."+e.toString());
				flag=false;
			}
			
			
			System.out.println(Thread.currentThread().getName()+"....hello");
		}
	}
	public void changeFlag(){
		flag=false;
	}
}




public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread st=new StopThread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		t1.start();
		t2.setDaemon(true);//将t2标记为后台线程。
		t2.start();
		for(int i=1;i<=50;i++){
			if(i==40){
				t1.interrupt();//将t1中断
				
				//t2.interrupt();//将t2中断
				//st.changeFlag();
			}
			System.out.println("main...."+i);
		}
		System.out.println("over");
		 

	}

}
