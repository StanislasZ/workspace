package day14_0810;  //16-ͬ����ϰ

/*
 ������������ͬһ�����д�Ǯ��ÿ���˴���3�Σ�һ��100��
 	1.��������
 	2.������������
 	
 �������߳��Ƿ���ڰ�ȫ������
 	1.�߳��������Ƿ��й�������ݡ�
 	2.�Ƿ��ж��������������ݵĴ��롣
 	
 ͬ����������ʵ���Ǽ����˹ؼ���synchronized��������
 ͬ��������ʽ��1.ͬ������� 2.ͬ������
 	
 ͬ������ʹ�õ�����ʲô���� ������Ҫ��������ã��ĸ�����ȷ�������Ƕ���this����ʾ
 ���������this  ��Demo3
 
 */

class Bank{
	private int sum;
	//private Object obj=new Object();
	public synchronized void add(int n){
		
		sum=sum+n;  //��һ��
		try{Thread.sleep(5);}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+".."+"sum="+sum); //�ڶ���
		
	}
}

class Customer implements Runnable{
	private Bank b=new Bank();  
	public void run(){
		for(int i=0;i<3;i++){
			b.add(100);
		}
	}
}




public class ThreadTest {
	public static void main(String[] args) {
		//�����������
		Customer c=new Customer();
		Thread t1=new Thread(c);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
	}

}
