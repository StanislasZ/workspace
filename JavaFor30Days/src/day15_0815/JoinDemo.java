package day15_0815;  //join����

class Demo1 implements Runnable{
	public void run(){
		for(int i=1;i<=40;i++){
			System.out.println(Thread.currentThread()+"....."+i);
			Thread.yield(); 
		}
	}
}



public class JoinDemo {
	public static void main(String[] args) throws InterruptedException{
		Demo1 d=new Demo1();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		//t1.join();  //�ȴ����߳���ֹ��  ���߳���ʱ���ᣬ��t1��������
		t2.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		for(int i=1;i<=40;i++){
			System.out.println(Thread.currentThread().toString()+i);
		}
	}

}
