package day07_0630;
//day07-10-��̬����,11-��̬������12��13-��̬�ص�
/*
 ��̬�ؼ���static:
 ��ʲô��  ��Ա���η�
 ��ʲô�ص㣺
 	1.����̬���εĳ�Ա���Ա����������á�
 	2.��̬��Ա�����ڶ�����ڡ�
 	3.��̬��Ա������ļ��ض����أ����������ʧ����ʧ����̬��Ա�������ںܳ���
 	
 ע�����
 1.��̬����ֻ�ܷ��ʾ�̬��Ա�����ܷ��ʷǾ�̬��Ա������Ǿ�̬�����ķ��ʾ����ԡ�
 2.��̬�ķ����в��ܳ���this����super�ؼ���
 3.�������Ǿ�̬�ġ�
 
 ��Ա�����;�̬����������
 1.��Ա����Ҳ��ʵ������      ��   ��̬����Ҳ�������
 2.
 */
class Person3{
	private String name;
	private int age;
	
	static String country="CN";  //����static���Խ�ʡ�ڴ�ռ䣬��������ڶѵ�ÿ����������
	
	Person3(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
	public static void sleep(){   
		System.out.println("����"+country);
	}
	/*��Ȼsleepû�з��ʵ������е��������ݣ��ǾͲ���Ҫ��������
     
	 ʲôʱ������Ҫ��̬�����أ�
	 �ú���û�з��ʹ������е�����ʱ������Ҫ�þ�̬���Ρ�
	 
	 */
}

public class StaticDemo0701 {

	public static void main(String[] args) {
		/*
		 ��������������sleep����
		 ���֣�sleep��û��ʹ�ö����е�����
		 �ö���Ľ�����û������ġ�
		 
		 �÷�������Person��
		 ����ͨ�������ķ�ʽ�����ʡ�
		 ע�⣺������ֱ�ӵ��õķ�������ͨ���ƶ����η������Σ��� 
		   
		   ���� static������
		 
		 */
		Person3 p=new Person3("lisi",21);
		p.show();
		Person3.sleep();
		//System.out.println(Person3.country);
		
		
	}

}
