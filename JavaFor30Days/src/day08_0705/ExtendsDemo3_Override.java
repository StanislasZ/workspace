package day08_0705;
//day08-�̳��г�Ա�������ص㣺   30-���ǵ�Ӧ�ã�31-���ǵ�ע������

/*
 �Ӹ����еķ������ص㣺
 
 ���������
 	���Ӹ����г�����һģһ���ķ���ʱ��
 	����������е�������ķ�����
 	���������������֮Ϊ���ǡ�override  ��д  ��д
 	
 	���ǣ�����ֵ���ͣ��������������б�һ��
 	
 ����ʹ�õ�ע�����
 	1.���෽�����Ǹ��෽��������Ҫ��֤Ȩ��>=����Ȩ��
 	2.��ֻ̬�ܸ��Ǿ�̬�����߱���̬����
 */

class Fu1{
	 /*static*/ void show(){
		System.out.println("fu1 show run");
	}
}
class Zi1 extends Fu1{
	/*static*/void show(){
		System.out.println("zi1 show run");
	}
}


public class ExtendsDemo3_Override {

	public static void main(String[] args) {
		Zi1 z=new Zi1();
		z.show();
		//z.show1();
		Phone p1=new Phone();
		NewPhone p2=new NewPhone();
		p1.show();
		p2.show();
	}

}

//�����ֻ���������ʾ����绰��������
class Phone{
	public void call(){
		
	}
	public void sendMsg(){
		
	}
	public void show(){
		System.out.println("number");
		//System.out.println("name");
		//System.out.println("pic");
	}
}
//�ֻ������ˣ������������
class NewPhone extends Phone{
	//������������ʾ���ܡ�ע�⣺�����Ѿ�������������ʾ����
	//����ֱ���ù����þͿ����ˡ���������Թ��ܵ�����Ҫ���Լ��Ķ��塣
	//�������๦�ܵ��������������๦�����е����ݣ����ǵ�Ӧ�á�
	public void show(){        //���ֲ��䣬���ݱ�
		super.show();  //�����ֱ���ù�����
		System.out.println("name");
		System.out.println("pic");
	}
}






