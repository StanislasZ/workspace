package day14_0810;
/*
  ʹ���˵ȴ����ѻ��ơ�
 wait():���̴߳��ڶ���״̬�������߳���ʱ�洢���̳߳��С�
 notify():�����̳߳���ָ����һ���̡߳�
 notifyAll():�����̳߳��������̡߳�
 
 ��Щ��������ʹ����ͬ���У���Ϊ��������������ͬ�����ϵ��̵߳�״̬�ġ�
 
 ��ʹ����Щ����ʱ�������ʶ���������ڵ�������ʶ��ʽ����������.wait(); ������.notify();   ������.notifyAll();
 
 ��ͬ����notify,���Ի�ȡ��ͬ����wait(); 
 */


//������Դ
class Resource2{
	private String name;
	int count=1;
	//������
	private boolean flag=false;   //Ĭ��false
	//�ṩ�˸���Ʒ��ֵ�ķ������������ߵ���
	public synchronized void set(String name) {
		
		if(flag)//�жϱ��Ϊtrue��ִ��wait Ϊfalse��������
			try{this.wait();}catch(InterruptedException e){}
		this.name=name+"--"+count;
		count++;
		System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
		//������ϣ���flag��Ϊtrue
		flag=true;
		//����������
		this.notify();   
		
	}
	//ͬ���������������ͷš����������������������ˣ��ֽ����������� 
	
	
	//�ṩһ����ȡ��Ʒ�ķ������������ߵ���
	public synchronized void get(){
		
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(Thread.currentThread().getName()+".....������..."+this.name);
		//����Ǹ�Ϊfalse
		flag=false;
		//����������
		this.notify();
		
	}
}

//������
class Producer2 implements Runnable{
	private Resource2 r;
	Producer2(Resource2 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.set("���");
	
	}
}

//������
class Consumer2 implements Runnable{
	private Resource2 r;
	Consumer2(Resource2 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.get();
	}
}


public class ProducerConsumerDemo2_wait_notify {

	public static void main(String[] args) {
		//������Դ
		Resource2 r=new Resource2();
		//������������
		Producer2 pro=new Producer2(r);
		Consumer2 con=new Consumer2(r);
		//�����߳�
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		
		t1.start();
		t2.start();

	}

}
