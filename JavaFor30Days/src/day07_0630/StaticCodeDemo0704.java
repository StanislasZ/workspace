package day07_0630;
//day07-15-��̬�����

/*
 ��̬����飺������ļ��ض�ִ�С�����ִֻ��һ��
 
 ���ã�������г�ʼ���ġ�
 
 Ӧ�ó������಻��Ҫ�������󡣵�����Ҫ��ʼ�������ǽ����ִ���洢����̬������С�
 */
class StaticCode{
	static int num;
	static{
		num=1;
		System.out.println("A");
	}
	static void show(){
		System.out.println("show run");
	}
}





public class StaticCodeDemo0704 {
	static{
		System.out.println("B");
	}
	public static void main(String[] args) {
		StaticCode.show();
		StaticCode.show();
	}
	static{
		System.out.println("C");
	}
}


