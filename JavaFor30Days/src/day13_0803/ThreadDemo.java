package day13_0803;   //04-���̵߳�����,05-�����̷߳�ʽ���̳�Thread�ࣩ��06-����

/*
 ��ο���һ��ִ��·���أ�
 
 ͨ������API�ĵ� java.lang.Thread�ࡣ
 ������������д������̵����ַ�ʽ��
 	1.�̳�Thread��
 		1.�̳�Thread��
 		2.����run����
 		3.�������������Ǵ����̶߳���
 		4.����Thread���е�start�����Ϳ���ִ���̡߳��������run����
 	
 	start()��ʼ�̺߳󣬶���ִ��run������˵��run�����д洢�����߳�Ҫ���еĴ��롣
 	���ԣ���ס���Զ����̵߳�������붼�洢��run�����С�
 	
 	����start�͵���run����������
 		����start�Ὺ���̣߳��ÿ������߳�ȥִ��run�����е��߳�����
 		
 		ֱ�ӵ���run�������̲߳�Ϊ������ȥִ��run������ֻ�����߳�
 */


class Demo extends Thread{
	private String name;
	Demo(String name){
		this.name=name;
	}
	public void run(){  //����
		show();
	}
	void show(){
		for(int i=1;i<=10;i++){
			//System.out.println(this.getName()+name+"..."+i);
			System.out.println(Thread.currentThread().getName()+name+"..."+i);
		}
	}
	
}


public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1=new Demo("����");
		Demo d2=new Demo("����");
		
		d1.start();    //�����̣߳�����run����
		d2.start();    //�����̣߳�����run����
		
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+"..."+i);
		}
		System.out.println("���߳̽���");
	}

}
