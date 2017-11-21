package day14_0810;  //��֤staticͬ��������������.class

/*
 ���ͬ�������Ǿ�̬���أ���
 
 static������������أ���ʱ��һ���и���Ķ��󡣵���һ����һ��������ֽ����ļ�����
 �������򵥵ı�ʾ��ʽ����  
 							����.class   
 							Class����������� 
 */

class SaleTicket4 implements Runnable{
	private static int tickets=100;
	//����һ��boolean���
	boolean flag=true;
	Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(SaleTicket4.class){   //�ֽ����ļ�����     
					if(tickets>0){
				
						try{Thread.sleep(10);}
						catch(InterruptedException e){
						//���̵߳�������΢ͣһ��
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
	public static synchronized void Sale(){   //��̬���޹ض���ģ����Կ϶�����this����    �����������.class����������SaleTicket.class
		if(tickets>0){
			
			try{Thread.sleep(10);}
			catch(InterruptedException e){
			//���̵߳�������΢ͣһ��
			}
			System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
		}
	}
}


public class StaticLockDemo {
	public static void main(String[] args) throws Exception{
		//�߳��������
		SaleTicket4 t=new SaleTicket4();
		//�����߳�
		Thread t1=new Thread(t);   //newһ���̶߳���ȥ������
		Thread t2=new Thread(t);
		
		t1.start();
		Thread.sleep(10);     //�����߳�����10ms��t1run()ʱ��flag����true
		t.flag=false;
		t2.start();          //û��sleep�Ļ������߳�˲���������������ˣ�����t1��t2���ǰ���false������Sale()
		
	}

}
