package day14_0810;

//����ʽ������ڶ��̲߳�������ȫ����
class Single{
	private static final Single SINGLE_INSTANCE=new Single();
	private Single(){}
	public static Single getInstance(){
		return SINGLE_INSTANCE;
	}
}
//����ʽ���ӳټ��ط�ʽ
/*
 �ڶ��̲߳�������ʱ��������̰߳�ȫ���⡣��ͬ���Ϳɽ�����⡣
 ������ͬ����������ͬ������鶼�С�
 
 ���ǣ�Ч�ʵ��ˡ���ô���Ч�ʵ͵�����
 ����ͨ��if�Ե��������˫���жϵ���ʽ��
 */
class Single1{
	private static Single1 s=null;
	private Single1(){}
	public static /*synchronized*/ Single1 getInstance(){  //����ͬ��
		if(s==null){
			//�����߳��������
			synchronized(Single1.class){
				if(s==null)
					s=new Single1();
			}
		}
		return s;
	}
}

class Demo implements Runnable{
	public void run(){
		Single.getInstance();
	}
}




public class ThreadSingleTest {
	public static void main(String[] args) {
		

	}

}
