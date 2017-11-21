package day15_0815;  //�߳�ֹͣ

/*
 ���ֹͣ�߳��أ�
 
 ԭ����run����������
 	�߳�����ͨ������ѭ������Ϊ�����߳̾���Ϊ��ִ��һ�δ��롣
 	
 	ֻҪ����סѭ�����Ϳ��Խ���run�������Ϳ���ֹͣ�̡߳�
 	
 	����ѭ��Ū����Ǽ��ɡ�
 	
 */


class StopThread implements Runnable{
	private boolean flag=true;
	public synchronized void run(){
		while(flag){
			try{
				wait();   //�����interrupt��ǿ�ƻ���
			}catch(InterruptedException e){
				System.out.println(Thread.currentThread().getName()+"...."+e.toString());
				flag=false;
			}
			
			
			System.out.println(Thread.currentThread().getName()+"....hello");
		}
	}
	public void changeFlag(){
		flag=false;
	}
}




public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread st=new StopThread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		t1.start();
		t2.setDaemon(true);//��t2���Ϊ��̨�̡߳�
		t2.start();
		for(int i=1;i<=50;i++){
			if(i==40){
				t1.interrupt();//��t1�ж�
				
				//t2.interrupt();//��t2�ж�
				//st.changeFlag();
			}
			System.out.println("main...."+i);
		}
		System.out.println("over");
		 

	}

}
