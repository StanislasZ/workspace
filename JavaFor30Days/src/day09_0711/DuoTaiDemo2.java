package day09_0711;   //52-��������ת��

abstract class Animal1{
	abstract void eat();
}

class Dog1 extends Animal1{
	void eat(){
		System.out.println("��ͷ");
	}
	void lookHome(){
		System.out.println("����");
	}
}

public class DuoTaiDemo2 {
	public static void main(String[] args){
		Animal1 a=new Dog1();   //����ת�ͣ���������Ϊ�˶��ֻ�ܵ�����ʹ��
		/*
		 ����ת�ͺô��������������ͣ�����˴������չ�� 
		 		�׶ˣ�ֻ��ʹ�ø����еĹ��ܣ�����ʹ���������й��ܡ����ܱ��޶��ˡ�//a.lookHome();//��
		 	
		 �������Ҫ��������ͣ�ͨ�������չ�ԣ�����ʹ�ø���Ĺ��ܼ�����ɲ�������ʹ������ת��
		 */
		
		//�����Ҫʹ����������й����أ����繷�Ŀ��ҹ���
		
		if(!(a instanceof Dog1)){
			System.out.println("���Ͳ�ƥ��");
			return;
		}
		Dog1 d=(Dog1)a;    //����ת��,ǿ������ת��
		d.eat();
		d.lookHome();
		/*
		 ����ת�͵ĺô�������ʹ�������͵����й���
		 		    �׶ˣ���Ծ���������ͣ�����ת���з��ա����׷���ClassCastException
		 		    	���Ͳ�ƥ��ͻᷢ����
		 		    	��Ҫ��ȫ������Ҫ�����жϡ��ж�һ�������Ƿ�ƥ��ĳһ���ͣ�
		 		    	��Ҫʹ��һ���ؼ��� instanceof
		 		    	�÷��� ����  instanceof ����
		 		    	
		 ʲôʱ��������ת�ͣ���Ҫ�����͵����з���ʱ����һ��Ҫ�ж�
		 */
		
	}
}
