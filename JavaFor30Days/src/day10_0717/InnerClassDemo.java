package day10_0717;   //60-�ڲ��࣬61-�Ǿ�̬�ڲ��࣬62-��̬�ڲ���
/*
 �ڲ��ࣺ
 	��ʵ�ǽ��ඨ�嵽����һ������ڲ�.
 	A��Ҫֱ�ӷ���B���еĳ�Աʱ�����Խ�A�ඨ�嵽B���У���Ϊ B����ڲ�����ڡ�
 	
 ���ʹ���
 	�ڲ������ֱ�ӷ����ⲿ���еĳ�Ա�����������ͺ�����
 	�ⲿ��Ҫ������ڲ��ֻ࣬�ܴ����ڲ���Ķ��������ʡ�
 */

class Outer{
	private static int num=4;
	class Inner{//�ڲ���  �൱���ⲿ���е�һ����Ա�����Ϳ��Ա���Ա���η������Ρ� public private static
		static final int count=5;
		void show(){
			System.out.println(num);  //�ⲿ���num��˽��Ҳ�ܷ���
		}
	}
	
	static class Inner2{      //��̬�ڲ��࣬�൱��һ���ⲿ��
		void show2(){ //�ڲ����еķǾ�̬��Ա
			System.out.println("show2..."+num);
		}
		static void show3(){  //�ڲ����еľ�̬��Ա
			System.out.println("show3..."+num);
		}
	}
	
	public void method(){   //���������ڲ������
		Inner in=new Inner();
		in.show();
	}
}




public class InnerClassDemo {

	public static void main(String[] args) {
//		Outer out=new Outer();
//		out.method();

		
//=============�Ǿ�̬����˽�е��ڲ�����ʷ�ʽ=====================================		
		//����ڲ���Ȩ���Ƿ�˽�еġ��Ϳ������ⲿ���������еı����ʵ���
		//ͨ�������ⲿ����������
//		Outer.Inner in=new Outer().new Inner();  //������Outer.Inner
//		in.show();
		
//=============��̬�ģ���˽�е��ڲ�����ʷ�ʽ1:���ʷǾ�̬��Ա====================================		
//		Outer.Inner2 in=new Outer.Inner2();
//		in.show2();
		
//=============��̬�ģ���˽�е��ڲ�����ʷ�ʽ2�����ʾ�̬��Ա====================================			
		Outer.Inner2.show3();
	
	
	
	
	
	}

}
