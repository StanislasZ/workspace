package day13_0803;  //��ȫ���⣬ͬ��  ,13-ͬ���ĺô��ͱ׶�

/*
 ���̵߳İ�ȫ���⡣
 	
 	������ԭ��
 		1.�߳��������й��������
 		2.�߳������ж����Թ������ݵĲ�����һ���߳��ڲ����������ݵĹ����У������̲߳��������㣬��������ݵĴ���
 
 	�����˼�룺
 		ֻҪ��֤���������������ݵĴ�����ĳһʱ��α�һ���߳���ִ�У���ִ���ڼ䲻���������̲߳������㡣
 	
 	զ��֤�أ�����
 	�õ���ͬ������顣
 	synchronized(����){
 		//��Ҫ��ͬ���Ĵ��롣
 	}
 	
 	ͬ����Ŀǰ����±�֤��һ��ֻ����һ���߳���ִ�С������߳̽�������
 	�����ͬ����������
 	
 	�ô�������˶��̵߳İ�ȫ����
 	
 	�׶ˣ�����Ч�ʡ� 
 	
 	�п��ܳ�������һ����������̰߳�ȫ������ֺ󣬼�����ͬ�����ƣ�û�н����ȫ���⡣զ�죡��
 	
 	��ʱ�϶���ͬ���������⡣ֻҪ����ͬ����ǰ�ᣬ�Ϳ��Խ����
 	
 	ͬ����ǰ�᣺
 		����߳���ͬ���б���ʹ��ͬһ����������ǶԶ���߳�ͬ����
 */

/*
 ��֤ͬ������ʹ�õ�������this
 
 ��֤����
 	���������̡߳�
 	һ���̸߳���ִ��ͬ������飨ʹ��������
 	��һ���߳�ʹ��ͬ��������ʹ��this����
 	
 	����ִ�е�������һ���Ķ�����Ʊ���������û��ʹ����ͬ������˵������û��ͬ������������ݴ���
 
 	��ô����һ���߳�һֱ��ͬ��������У���һ���߳���ͬ�������أ�
 	��ͨ���л��ķ�ʽ��
 	
 */



class SaleTicket3 implements Runnable{
	private int tickets=100;
	//����һ��boolean���
	boolean flag=true;
	Object obj=new Object();
	public void run(){
		if(flag){
			while(true){
				synchronized(this){
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
	public synchronized void Sale(){
		if(tickets>0){
			
			try{Thread.sleep(10);}
			catch(InterruptedException e){
			//���̵߳�������΢ͣһ��
			}
			System.out.println(Thread.currentThread().getName()+"..func.."+tickets--);
		}
	}
}


public class TicketDemo3 {
	public static void main(String[] args) throws Exception{
		//�߳��������
		SaleTicket3 t=new SaleTicket3();
		//�����ĸ��߳�
		Thread t1=new Thread(t);   //newһ���̶߳���ȥ������
		Thread t2=new Thread(t);
		//Thread t3=new Thread(t);
		//Thread t4=new Thread(t);
		t1.start();
		Thread.sleep(10);     //�����߳�����10ms��t1run()ʱ��flag����true
		t.flag=false;
		t2.start();          //û��sleep�Ļ������߳�˲���������������ˣ�����t1��t2���ǰ���false������Sale()
		//t3.start();
		//t4.start();

	}

}
