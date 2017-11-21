package day15_0815;  //异常在多线程的体现

/*
 异常会提示发生在哪个线程上。
 异常会结束线程任务，也就是可以结束所在的线程。
 */

class Demo implements Runnable{
	public void run(){
		System.out.println(4/0);
	}
}

public class ThreadExceptionDemo {
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Demo()).start();
		Thread.sleep(10);
		int[] arr=new int[3];
		System.out.println(arr[3]);

	}

}
