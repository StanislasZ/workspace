package day14_0810;  //��֤staticͬ��������������.class

/*
 ������
 	����1��ͬ��Ƕ��
 
 */

class SaleTicket5 implements Runnable{
	private static int tickets=100;
	//����һ��boolean���
	boolean flag=true;
	static Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(obj){   //obj lock     
					Sale();
				}
			}
		}
		else
			while(true)
				Sale();
	}
	public static synchronized void Sale(){   //this lock
		synchronized(obj){
			if(tickets>0){
				try{Thread.sleep(10);}
				catch(InterruptedException e){//���̵߳�������΢ͣһ��
				}
				System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
			}
		}
	}
}


public class DeadLockDemo {
	public static void main(String[] args) throws Exception{
		//�߳��������
		SaleTicket5 t=new SaleTicket5();
		//�����߳�
		Thread t1=new Thread(t);   //newһ���̶߳���ȥ������
		Thread t2=new Thread(t);
		
		t1.start();
		Thread.sleep(10);     //�����߳�����10ms��t1run()ʱ��flag����true
		t.flag=false;
		t2.start();          //û��sleep�Ļ������߳�˲���������������ˣ�����t1��t2���ǰ���false������Sale()
		
	}

}
