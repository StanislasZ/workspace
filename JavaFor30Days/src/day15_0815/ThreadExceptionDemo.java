package day15_0815;  //�쳣�ڶ��̵߳�����

/*
 �쳣����ʾ�������ĸ��߳��ϡ�
 �쳣������߳�����Ҳ���ǿ��Խ������ڵ��̡߳�
 */

class Demo implements Runnable{
	public void run(){
		System.out.println(4/0);
	}
}

public class ThreadExceptionDemo {
	public static void main(String[] args) throws InterruptedException{
		new Thread(new Demo()).start();
		Thread.sleep(10);
		int[] arr=new int[3];
		System.out.println(arr[3]);

	}

}
