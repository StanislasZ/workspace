package day08_0705;
//day08-32-�̳�-�����ʵ�������̣�33-ע������

/*
 �Ӹ����й��캯�����ص㡣
 �ͻᷢ�֣������������ʱ��Fu�еĿղ������캯��Ҳ�����ˣ�
 
 ��Ϊ���������еĹ��캯���ĵ�һ��Ĭ�϶���һ����ʽ��super();���
 
 ���ñ����еĹ��캯����this(ʵ���б�����䡣���ø����еĹ��캯����super(ʵ���б���
 
 Ϊʲô��������ʼ����Ҫ���ʸ����еĹ��캯���أ�
	��Ϊ����̳��˸����е����ݣ����Դ�������ʱ����Ҫ�ȿ���������ζ����ݽ��г�ʼ����
	
	����������ʵ��������     object
	
ע�⣺
	��������û�пղ������캯��ʱ��������Ҫͨ����ʽ����super���ָ��Ҫ���ʵĸ����еĹ��캯����
 	
 	�������ø��๹�캯����super��������๹�캯���б��붨���ڵ�һ�У���Ϊ����ĳ�ʼ��Ҫ����ɡ�
 	
���⣺
	1.this��super���ڵ��ù��캯��������ͬʱ������
		�����ԣ���Ϊ����ֻ�ܶ����ڵ�һ��
	
	2.Ϊʲô��Ҫ�����ڵ�һ�У�
		��Ϊ��ʼ������Ҫ��ִ�С�
 */

class Fu2{
	int num;
	Fu2(){
		num=4;
		System.out.println("fu2 run");
	}
	Fu2(int x){
		System.out.println("fu2 run.."+x);
	}
}
class Zi2 extends Fu2{  //���̳У��̳�Fu2,������Object��Ķ��������̳У�
	Zi2(){
		                                                             //super(4);   //��ʽ��ը����������ʽsuperָ��
		this(5);     
		System.out.println("zi22 run");
	}
	Zi2(int x){
		super(); //��ʽ
		System.out.println("zi2 run.."+x);
	}
}


public class ExtendsDemo4_Cons {

	public static void main(String[] args) {
		Zi2 z=new Zi2();
		

	}

}