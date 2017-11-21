package day15_0815;   //Lock�ӿ�
import java.util.concurrent.locks.*;  //�������Lock�ӿ����ֳɵ�����


/*
 ��������������ѵ�Ч�����⡣
 ʹ����JDK1.5 java.util.concurrent.locks���еĶ���
 Lock�ӿ�:���ĳ��ֱ�synchronized�и������
 		  lock() :��ȡ��
 		  unlock()  :�ͷ���
 		  
 ͬ����������ͬ������������������ʽ�ġ�������������ʹ������
 JDK1.5 Lock�ӿڣ�����������װ����һ������
 				 ���ṩ�˶�������ʽ������
 
 Lock�ӿھ���ͬ���������
 	1.���߳��е�ͬ������ΪLock�ӿڵ���ʽ�� 
 	
 �滻������ʧ�ܡ���Ϊwaitû����ͬ������û��������ͬ������
 ͬ�������ˡ��������Ѿ�����������󣬶���Lock���͵Ķ���
 ��ô���������󶨵ļ������������ǲ���Ҳ�����ˣ�����ר�ź�Lock�������İ󶨵ļ�����������
 
 ����api�󣬷���Condition�ӿ������Object�еļ�����������
 
 ��ǰ������������װ��ÿһ�������У����ڽ�������������װ����Condition�����С�
 ������Ϊ��await   signal  signalAll
 
 ����������Condition��κ�Lock���أ�
 ����ͨ��Lock�ӿڵ�newCondition�������
 
 ���ǣ��������ɣ�һ�������˱�����Ч���Ծɵͣ���
 */



//������Դ
class Resource{
	private String name;
	int count=1;
	
	Lock lock=new ReentrantLock(); //��̬��������
	private Condition producer_con=lock.newCondition();  //���������߼���������
	private Condition consumer_con=lock.newCondition();  //���������߼���������
	
	//������
	private boolean flag=false;   //Ĭ��false
	//�ṩ�˸���Ʒ��ֵ�ķ������������ߵ���
	public void set(String name) {
		//��ȡ��
		lock.lock();
		try{
			while(flag)//�жϱ��Ϊtrue��ִ��wait Ϊfalse��������
				try{producer_con.await();}catch(InterruptedException e){}
				
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
			//������ϣ���flag��Ϊtrue
			flag=true;
			//������ϣ�Ӧ�û���һ���������߳�
			consumer_con.signal();   
		}finally{	
			//�ͷ���
			lock.unlock();
		}
	}
	//ͬ���������������ͷš����������������������ˣ��ֽ����������� 
	
	
	//�ṩһ����ȡ��Ʒ�ķ������������ߵ���
	public void get(){   //t2,t3
		lock.lock();
		try{
			while(!flag)
				try{consumer_con.await();}catch(InterruptedException e){}
			
			System.out.println(Thread.currentThread().getName()+".....������..."+this.name);
			//����Ǹ�Ϊfalse
			flag=false;
			//������ϣ�����һ���������߳�
			producer_con.signal();
		}finally{
			lock.unlock(); 
		}
	}
}

//������
class Producer implements Runnable{
	private Resource r;
	Producer(Resource r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.set("���");
	
	}
}

//������
class Consumer implements Runnable{
	private Resource r;
	Consumer(Resource r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.get();
	}
}


public class NewProducerConsumerDemo {

	public static void main(String[] args) {
		//������Դ
		Resource r=new Resource();
		//������������
		Producer pro=new Producer(r);
		Consumer con=new Consumer(r);
		//�����߳�
		Thread t0=new Thread(pro);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		Thread t3=new Thread(con);
		
		t0.start(); t1.start(); t2.start(); t3.start();

	}

}
