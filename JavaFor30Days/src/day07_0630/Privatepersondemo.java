package day07_0630;
//day07-07-���캯��˽�л��������
class Person1{
	private String name;
	private int age;
	
	Person1(){ 
		name="baby";
	}
	private Person1(String n){
		name=n;
	}
	/*
	 ���캯��˽�У�ֻ�ڱ�������Ч������η����أ�
	 ע��1�����캯��ֻ�ܱ����캯�����ã�����ֱ�ӱ�һ�㷽������
	 ���캯��֮�����η����أ�ͨ��this�����
	 
	 this:������Ƕ��󡣴����ĸ�������
	 �ĸ��������this���ڵĺ�����this�ʹ����ĸ�����
	 
	 this���ϲ����б�ķ�ʽ���Է��ʱ����е��������캯����
	 ����:this("lisi"):���ʵľ��Ǳ����У���һ���ַ��������Ĺ��캯����
	 
	 ��ס�����ڵ��ù��캯����this�����붨���ڹ��캯���ĵ�һ�С���Ϊ��ʼ������Ҫ��ִ�С�
	 
	 �ܽ᣺ֻҪֱ�ӱ�������õķ���������this���á����Ƿ����˶����е����ݵķ���������this����
	 
	 */
	Person1(String n,int a){     
		this(n);    //ֻ��дһ��this
		//name=n;
		age=a;
	}
	Person1(int a){
		age=a;
	}
	
	
	
	
	//������ʾ���ֺ�����ķ�����
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
}

/*
 ��η���һ�����캯����
 */
public class Privatepersondemo {
	public static void main(String[] args) {
		Person1 p=new Person1("����",5);    //��������ֱ�ӳ�ʼ��
		
		

		p.show();
		
		Person1 p1=new Person1("ͼ��",20);
		p1.show();
		
		Person1 p2=new Person1();   //���Person�ж���Ĺ��캯����û�пղ����Ĺ��캯���Ļ�����仰�����������
		p2.show();

	}

}
