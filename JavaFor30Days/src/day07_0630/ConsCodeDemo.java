package day07_0630;
//day07-16-�������飬����ĳ�ʼ������

class Person4{
	private int age=8;
	{  //���������еķǾ�̬�Ĵ���顣�����ж�����г�ʼ���ġ�
		
		//���캯��ֻ����Ӧ�Ķ����ʼ��������
		System.out.println("Constructor code run"+age);   //8�Ѿ�����
		cry();   //ÿ������Ҫ���ۣ��Ͱ�cryд������
	}
	
	Person4(){
		System.out.println("person run");	
		//cry();
	}
	Person4(int age){
		this.age=age;
		System.out.println("Person(age) run");
		//cry();
	}
	
	 void cry(){
		System.out.println("����");
	}
}
/*
 ����һ�����������:
	1.����ָ�����ֽ����ļ����ڴ档
	2.ͨ��new�ڶ��ڴ��п��ٿռ䡣�����׵�ֵַ
	3.�Զ����е����Խ���Ĭ�ϳ�ʼ����
	4.������֮��Ӧ�Ĺ��캯�������캯��ѹջ
	5.���캯����ִ����ʽ�����super()���ʸ����еĹ��캯��
	6.�����Խ��г�ʼ��
	7.�������еĹ�������
	8.ִ�й��캯�����Զ���ĳ�ʼ������
	9.��ʼ����ϣ�����ַ��ֵ��ָ�������á�
 */

public class ConsCodeDemo {

	public static void main(String[] args) {
		Person4 p1=new Person4();
		Person4 p2=new Person4(4);
		
		int x=3;
		{ //�ֲ������ �����Կ��ƾֲ���������������
			System.out.println("hehe");
		}
		System.out.println("x="+x);
		
	}

}
