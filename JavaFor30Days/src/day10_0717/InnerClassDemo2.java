package day10_0717;   //63-�ڲ���ϸ�� 

/*
 Ϊʲô�ڲ���Ϳ���ֱ�ӷ����ⲿ���еĳ�Ա��
 	��Ϊ�ڲ���������ⲿ�����á��ⲿ����.this
 */

/*
class Outer1{
	int num=2;
	
	class Inner1{
		int num=3;
		void show(){
			int num=4;
			System.out.println("show.."+num);
			System.out.println("show this num="+this.num);
			System.out.println("show Inner1 this num="+Inner1.this.num);   //����һ����ͬ
			System.out.println("show Outer1 this num="+Outer1.this.num);
		}
	}
	
	public void method(){
		new Inner1().show();
	}
}
*/

//���ڲ��ඨ�嵽�˾ֲ�λ���ϡ�
class Outer1{
	private int num=4;
	
	Object obj;
	
	public void method(){
		/*final*/ int x=5;
		class Inner1 extends Object{    //Inner����̳�Object
			//����Object���е�toString����
			public String toString(){
				System.out.println("show.."+num);
				System.out.println("show.."+x);
				return "Inner...abc";
			}
		}
		//�����ڲ������
		Inner1 in=new Inner1();
		//���ڲ������ĵ�ַ��ֵ��obj
		obj=in;
		
	}
	
	public void function(){
		//��ӡobjָ��Ķ�����ַ���������ʽ
		System.out.println(obj.toString());
	}
}




public class InnerClassDemo2 {
	public static void main(String[] args) {
		//new Outer1().method();

		Outer1 o=new Outer1();
		o.method();
		o.function();
		
	}

}
