package day09_0707;
//day09-46-�ӿڶ�̳�&û�г��󷽷��ĳ�����
/*
 ������֮��   �̳й�ϵ   is a
 
 ����ӿ�֮��   ʵ�ֹ�ϵ   like a
 
 �ӿ���ӿ�֮����ʲô��ϵ�أ�     �̳�
 */
/*
interface Inter1{
	void show1();
}
interface InterA{
	void showA();
}
interface Inter2 extends Inter1,InterA{
	void show2();
}

class Demo implements Inter2{
	public void show1(){}
	public void show2(){}
	public void showA(){}
}
*/

interface Inter1{
	void show1();
	void show2();
	void show3();
	void show4();
	
}
//DemoA��Ҫʹ�ýӿ��еĲ��ַ���������ʹ��show1()
class DemoA implements Inter1{
	public void show1(){
		System.out.println("Demoa show1");
	}
	public void show2(){}
	public void show3(){}
	public void show4(){}
}
//���⣺ֻ��Ҫ���ֹ��ܣ�����Ϊ��ʵ����������Ҫȫ�����ǡ����븴���Ժܲ

//Ϊ�˷��㴴��Inter�ӿڵ�������󡣿�����һ�����Ȱѽӿ��е����з�����ʵ�֡�

abstract class Demo1 implements Inter1{   //û�г��󷽷��ĳ����࣬���㴴���ӿڵĶ���
	public void show1(){}
	public void show2(){}
	public void show3(){}
	public void show4(){}             //��ʵ��
}
class DemoB extends Demo1{       //�������DemoA�����˺ܶ�
	public void show3(){
		System.out.println("demoB show3");
	}
}



public class InterfaceDemo4 {
	public static void main(String[] args) {
		DemoA a=new DemoA();
		a.show1();
	}

}
