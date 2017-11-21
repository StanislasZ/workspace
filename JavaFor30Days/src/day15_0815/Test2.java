package day15_0815;
import java.util.concurrent.locks.*;
/*
 1.�㶨��������
 	������
 		1.��������  2.�߳��������ж����������ݵĴ��롣
 	
 	����ͬ�����������ɡ���ͬ��ǰ�ᣡ
 	����������������ͬ������ͬ�������㶨��
 
 2.name��sex��˽�еġ���Ҫ��Res���ж����ṩ����name��sex�ķ�����  �ѽ��
  
 3.ʵ�ּ�������ʹ�õȴ����ѻ��ơ�
 	һ�������Ҫ�ж�������   ����ʹ��1.4֮ǰ��wait  notify 
 */



class Res2{
	private String name;
	private String sex;
	//������
	private boolean flag=false;
	
	//������
	private final Lock lock=new ReentrantLock();
	//��ȡ����������
	private Condition con=lock.newCondition();
	
	public void set(String name,String sex){
		lock.lock(); //��ȡ��
		try{
			while(flag)
				try{con.await();}catch(InterruptedException e){}
			this.name=name;
			this.sex=sex;
			flag=true;
			con.signal();
		}finally{
			lock.unlock();
		}
	}
	public void out(){
		lock.lock();
		try{
			while(!flag)
				try{con.await();}catch(InterruptedException e){}
			System.out.println(name+"....."+sex);
			flag=false;
			con.signal();
		}finally{
			lock.unlock();
		}
	}
}
class Input2 implements Runnable{
	private Res2 r;
	Input2(Res2 r){
		this.r=r;
	}
	public void run(){
		int x=0;
		
		while(true){
			if(x==0){
				r.set("����","��");
			}
			else{
				r.set("rose","female");
			}
			x=(x+1)%2; 
		}
	}
}

class Output2 implements Runnable{
	private Res2 r;
	Output2(Res2 r){
		this.r=r;
	}
	public void run(){
		while(true){
			r.out();
		}
	}
}


public class Test2 {
	public static void main(String[] args) {
		Res2 r=new Res2();
		
		Input2 in=new Input2(r);
		Output2 out=new Output2(r);
		
		new Thread(in).start();
		new Thread(out).start();

	}

}
