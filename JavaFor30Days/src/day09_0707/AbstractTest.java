package day09_0707;
//day09-41-��������ϰ
/*
���󣺹�˾�г���Ա�����������ţ�нˮ���������ݡ�
��Ŀ������������������ţ�нˮ�����н��𣬹������ݡ�
�Ը�������������ݽ�ģ��

������
��������������У����ҳ��漰�Ķ���ͨ��������������
	����Ա��
		���ԣ����������ţ�нˮ��
		��Ϊ��������
	����
		���ԣ����������ţ�нˮ������
		��Ϊ��������

����Ա�;���������ֱ�Ӽ̳й�ϵ�����ǳ���Ա�;���ȴ���й������ݡ����Խ��г�ȡ����Ϊ���Ƕ��ǹ�˾�Ĺ�Ա 

���Խ�����Ա�;�����г�ȡ.������ϵ��
���ߵĹ���������ʲô��  ��Ա

	��Ա��
	���ԣ����������ţ�нˮ
	��Ϊ������������
*/

abstract class Employee{         //��Ա
	private String name;
	private String id;
	private double pay;
	
	Employee(String name,String id,double pay){
		this.name=name;
		this.id=id;
		this.pay=pay;
	}
	
	public abstract void work();	
}

class Programmer extends Employee{    //����Ա
	Programmer(String name,String id,double pay){
		super(name,id,pay);
	}
	public void work(){
		System.out.println("code");
	}
}

class Manager extends Employee{     //����
	private double bonus;
	Manager(String name,String id,double pay,double bonus){
		super(name,id,pay);    //super����ŵ�һ��
		this.bonus=bonus;
	}
	public void work(){
		System.out.println("manage");
	}
}





public class AbstractTest {
	public static void main(String[] args) {
		

	}

}
