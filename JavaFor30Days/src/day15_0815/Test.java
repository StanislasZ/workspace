package day15_0815;

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



class Res{
	private String name;
	private String sex;
	//������
	private boolean flag=false;
	public synchronized void set(String name,String sex){
		if(flag)
			try{this.wait();}catch(InterruptedException e){}
		this.name=name;
		this.sex=sex;
		flag=true;
		this.notify();
	}
	public synchronized void out(){
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(name+"....."+sex);
		flag=false;
		this.notify();
	}
}
class Input implements Runnable{
	private Res r;
	Input(Res r){
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

class Output implements Runnable{
	private Res r;
	Output(Res r){
		this.r=r;
	}
	public void run(){
		while(true){
			r.out();
		}
	}
}


public class Test {
	public static void main(String[] args) {
		Res r=new Res();
		
		Input in=new Input(r);
		Output out=new Output(r);
		
		new Thread(in).start();
		new Thread(out).start();

	}

}
