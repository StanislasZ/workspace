package day09_0707;
//day09-42-�ӿڸ�����43-�ӿ��ص�

/*
 �����������еķ������ǳ���ġ�
 ��ʱ�����԰ѳ���������һ����ʽ����ʾ���ӿ�
 
 ���ڿ������Ϊ�ӿ�������ĳ����ࡣ
 */
/*
abstract class AbsDemo{
	abstract void show1();
	abstract void show2();
}
*/

//����ӿ�
interface Inter{
	public static final int NUM=4;  //ȫ�ֳ�������������
	public abstract void show1();
	public abstract void show2();
}
//�ӿ��еĳ�Ա��class���岻֮ͬ����
//�ӿ��г����ĳ�Ա�����֣� 1.ȫ�ֳ�����public final��  2.���󷽷�
//���Ҷ��й̶������η������ԣ���Ա����public���εġ�

/*	
�ӿڵ��ص㣺
	1.�ӿڲ�����ʵ����
	2.��Ҫ�����˽ӿ��е����еĳ��󷽷������࣬�ſ���ʵ������
		���򣬸����໹��һ�������ࡣ
	3.�ӿ���������ʵ�ֵġ�
*/

class Demo implements Inter{
	public void show1(){   //�з������壬û����
		
	}
	public void show2(){
		
	}
}






public class InterfaceDemo {
	public static void main(String[] args) {
		Demo d=new Demo();   //�����귽������new
		

	}

}
