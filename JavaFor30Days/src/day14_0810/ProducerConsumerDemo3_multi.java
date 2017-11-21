package day14_0810;
/*
 �����������ѡ�
 �ظ��������ظ�����
 	ԭ�򣺾������������ֱ����ѵ��߳�û���жϱ�ǾͿ�ʼ�������������ظ������������ѵķ�����
 	
 	����������ѵ��̱߳����жϱ�ǡ�
 		  ʹ��whileѭ�����Ա�ǽ��ж���ж�
 		  
 ����2�������ˣ����е��̶߳����ڶ���״̬��
 		ԭ�򣺱����߳��ڻ���ʱ����һ�λ����˱����̡߳��������߳�ѭ���жϱ�ǣ��ּ����ȴ������������е��̶߳��ȴ��ˣ����ᣩ
 		
 		�����ϣ��������������˶Է��̣߳��Ϳ��Խ����
 			  ���Ի���notifyAll()������
 			  �ǲ���ȫ���������ǵģ����б��������жԷ������Ǳ����Ѻ�һ�жϱ����ȥ˯����(��һ��������Ч��)���Է������߳̿���ִ���ˡ�
 	
 �Ѿ�ʵ���˶����������ѡ�������ЩС���⣬Ч���е�ͣ���ΪnotifyAllҲ�����˱��������˲���Ҫ���жϡ�
 */


//������Դ
class Resource3{
	private String name;
	int count=1;
	//������
	private boolean flag=false;   //Ĭ��false
	//�ṩ�˸���Ʒ��ֵ�ķ������������ߵ���
	public synchronized/*����this��*/ void set(String name) {
		
		while(flag)//�жϱ��Ϊtrue��ִ��wait Ϊfalse��������
			try{this.wait();}catch(InterruptedException e){}
			
			this.name=name+"--"+count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
			//������ϣ���flag��Ϊtrue
			flag=true;
			//�������еȴ����̣߳����������̣߳�
			this.notifyAll();   
		
	}
	//ͬ���������������ͷš����������������������ˣ��ֽ����������� 
	
	
	//�ṩһ����ȡ��Ʒ�ķ������������ߵ���
	public synchronized/*����this��*/ void get(){   //t2,t3
		
		while(!flag)
			try{this.wait();}catch(InterruptedException e){}
		
		System.out.println(Thread.currentThread().getName()+".....������..."+this.name);
		//����Ǹ�Ϊfalse
		flag=false;
		//����������
		this.notifyAll();
		
	}
}

//������
class Producer3 implements Runnable{
	private Resource3 r;
	Producer3(Resource3 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.set("���");
	
	}
}

//������
class Consumer3 implements Runnable{
	private Resource3 r;
	Consumer3(Resource3 r){
		this.r=r;
	}
	public void run(){
		while(r.count<100)
			r.get();
	}
}


public class ProducerConsumerDemo3_multi {

	public static void main(String[] args) {
		//������Դ
		Resource3 r=new Resource3();
		//������������
		Producer3 pro=new Producer3(r);
		Consumer3 con=new Consumer3(r);
		//�����߳�
		Thread t0=new Thread(pro);
		Thread t1=new Thread(pro);
		Thread t2=new Thread(con);
		Thread t3=new Thread(con);
		
		t0.start(); t1.start(); t2.start(); t3.start();

	}

}
