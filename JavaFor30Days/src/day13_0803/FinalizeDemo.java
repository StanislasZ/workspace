package day13_0803;  //03-jvm中的多线程&垃圾回收

/*
 多线程的运行根据cpu的切换完成的。怎么切换cpu说了算。所以多线程运行有一个随机性（cpu的快速切换造成的）。
 
 jvm中的多线程
 至少有两个线程：一个是负责自定义代码运行。这个从main方法开始执行的线程称之为主线程。
 				一个是负责垃圾回收
 				
 		通过实验：发现每次结果不一定相同，因为随机性造成的。而且每一个线程都有运行的代码内容。这个称之为线程的任务。
 		之所以创建一个线程就是为了去运行指定的任务代码。
 			
 		而线程的任务的任务都封装在特定的区域中。
 		比如:
 			主线程运行的任务都定义在main方法中。
 			垃圾回收线程在收垃圾都会运行finalize方法。
 */

class Demo9{
	//定义垃圾回收方法
	public void finalize(){   //覆盖Object方法
		System.out.println("demo ok");
	}
}


public class FinalizeDemo {
	public static void main(String[] args) {
		new Demo9();
		new Demo9();
		new Demo9();  //在这句结束后这个匿名对象就成了垃圾
		new Demo9();
		System.gc();    //启动垃圾回收器  
		
	}

}
