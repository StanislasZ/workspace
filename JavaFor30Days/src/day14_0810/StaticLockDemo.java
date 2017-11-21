package day14_0810;  //验证static同步函数锁是类名.class

/*
 如果同步函数是静态的呢？？
 
 static方法随着类加载，这时不一定有该类的对象。但是一定有一个该类的字节码文件对象
 这个对象简单的表示方式就是  
 							类名.class   
 							Class是描述类的类 
 */

class SaleTicket4 implements Runnable{
	private static int tickets=100;
	//定义一个boolean标记
	boolean flag=true;
	Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(SaleTicket4.class){   //字节码文件对象     
					if(tickets>0){
				
						try{Thread.sleep(10);}
						catch(InterruptedException e){
						//让线程到这里稍微停一下
						}
						System.out.println(Thread.currentThread().getName()+"..true.."+tickets--);
					}
				}
			}
		}
		else
			while(true)
				Sale();
	}
	public static synchronized void Sale(){   //静态是无关对象的，所以肯定不是this锁。    这个锁是类名.class，在这里是SaleTicket.class
		if(tickets>0){
			
			try{Thread.sleep(10);}
			catch(InterruptedException e){
			//让线程到这里稍微停一下
			}
			System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
		}
	}
}


public class StaticLockDemo {
	public static void main(String[] args) throws Exception{
		//线程任务对象
		SaleTicket4 t=new SaleTicket4();
		//创建线程
		Thread t1=new Thread(t);   //new一个线程对象，去绑定任务
		Thread t2=new Thread(t);
		
		t1.start();
		Thread.sleep(10);     //让主线程休眠10ms，t1run()时，flag就是true
		t.flag=false;
		t2.start();          //没有sleep的话，主线程瞬间把这三句给运行了，所以t1，t2都是按照false来运行Sale()
		
	}

}
