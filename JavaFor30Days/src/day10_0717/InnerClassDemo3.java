package day10_0717;   //63-�����ڲ��ࣨ�̳У�

/*
 �����ڲ��ࣺ����д���ڲ��ࡣ
 
 	ǰ�᣺
 		�ڲ�����Ҫ�̳л���ʵ���ⲿ�����ӿڡ�
 */

abstract class Demo2{
	abstract void show();
}

class Outer2{
	private int num=4;
	/*
	class Inner2 extends Demo2{
		//��д
		public void show(){
			System.out.println("show.."+num);
		}
	}
	*/
	
	public void method(){
		//new Inner2().show();
		
		new Demo2(){     //�����ڲ��࣬����һ���������
			//����Demo2�еĳ��󷽷�
			public void show(){
				System.out.println("show..."+num);
			}
		}.show();     //�����������е���
	}
	
}



public class InnerClassDemo3 {
	public static void main(String[] args) {
		
		new Outer2().method();

	}

}
