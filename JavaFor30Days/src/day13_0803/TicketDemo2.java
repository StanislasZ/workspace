package day13_0803;//10-�����̷߳�ʽ2��ʵ��Runnable�ӿ�

/*
 �����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿ�
 	1.����һ����ʵ��Runnable
 	2.����Runnable�ӿ��е�run�������߳�Ҫ���е��������洢���÷����С�
 	3.ͨ��Thread�ഴ���̶߳��󣬲���ʵ����Runnable�ӿڵĶ�����ΪThread��Ĺ��캯���Ĳ������д��ݡ�
 	4.����Thread���start�����������̡߳�
 	
 	
 ʵ��Runnable�ӿڵĺô���
 	1.�����˼̳�Thread��ĵ��̳еľ����ԡ�
 	2.Runnable�ӿڳ��ָ�����������󣬽��̵߳������ж���ķ�װ��
 	3.Runnable�ӿڳ��֣��������̶߳�����߳����������ԡ�
 	
 	���ԣ��Ժ󴴽��̶߳�ʹ�õڶ��ַ�ʽ��
 */

class SaleTicket implements Runnable{
	private int tickets=100;
	public void run(){
		while(true){
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+"..."+tickets--);
			}
		}
	}
}



public class TicketDemo2 {
	public static void main(String[] args) {
		//�߳��������
		SaleTicket t=new SaleTicket();
		//�����ĸ��߳�
		Thread t1=new Thread(t);   //newһ���̶߳���ȥ������
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);
		Thread t4=new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
