package day13_0803;

/*
 û������⡣������400��Ʊ�������ʣ�������Ʊ��ɾ�̬�ģ���ι���100��Ʊ�أ�����
 */
class SaleTicket9 extends Thread{
	private int tickets=100;
	
	//��Ʊ�Ĵ�����Ҫ������߳�ִ�У�����Ҫ����Щ���붨�����߳������С�run ����
	public void run(){
		while(true){
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+"...."+tickets--);
				
			}
		}
	}
//	public synchronized int sellTicket() {
//		  
//		 return tickets--;
//	}

}

public class TickerDemo {
	public static void main(String[] args) {
		//�����ĸ��߳�
		SaleTicket9 t1=new SaleTicket9();
		SaleTicket9 t2=new SaleTicket9();
		SaleTicket9 t3=new SaleTicket9();
		SaleTicket9 t4=new SaleTicket9();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
