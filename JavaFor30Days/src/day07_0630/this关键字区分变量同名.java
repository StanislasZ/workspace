package day07_0630;
//day07-08��09-Ӧ��
class Person2{
	private String name;
	private int age;
	
	Person2(){ 
		name="baby";
	}
	private Person2(String aName){
		name=aName;
	}
	
	Person2(String name,int age){     
		this.name=name;    //���String name ��һ�� name=name���Ǿֲ���ֵ���ֲ��������Ǿֲ���ֵ����Ա
		this.age=age;
	}
	Person2(int a){
		age=a;
	}
		//������ʾ���ֺ�����ķ�����
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
	public void method(){
		this.show(); //this��ʡ��
	}
	/*
	 �������ܣ��ж��Ƿ���ͬ����
	 �����boolean
	 ����������һ��Person����
	 */
	public boolean equalAge(Person2 pp){
		/*
		 if(pp.age==this.age)
		
			return true;
		return false; */
		
		//return pp==this; //�Ƿ�ָ��ͬ����
		
		return pp.age==this.age;
	}
	
	
}









/*
 ����Ա�����;ֲ�����ͬ��ʱ������ͨ��this�ؼ�������
 */
public class this�ؼ������ֱ���ͬ�� {

	public static void main(String[] args) {
		Person2 p1=new Person2("����",20);    //��������ֱ�ӳ�ʼ��
		
		

		
		
		Person2 p2=new Person2("ͼ��",20);
		p1.show();
		
		System.out.println(p2.equalAge(p1));

	}

}
