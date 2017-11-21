package day10_0717;   //57,58-equals��59-toString(������д)

//Object:java�������ϵۡ�������ĸ��ࡣ���ж��������ж��󶼾߱��Ĺ��ܡ�
//�� Object �����νṹ�ĸ��ࡣÿ���඼ʹ�� Object ��Ϊ���ࡣ���ж��󣨰������飩��ʵ�������ķ�����

class Person extends Object{
	private int age;
	private String name;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	//����һ���������ж�����Person�����Ƿ���ͬһ����
	//�жϵ������Ǹ������䡣���������ͬ����Ϊͬһ���ˡ�
	
	
	//public boolean compare(Person p){}
	/*�������Զ��巽�����ж϶����Ƿ���ͬ����ΪObject�����У��Ѿ������������ķ�����	
	ֱ��ʹ�þͿ����ˡ������жϵ������Ǹ���Person���ص㶨��ġ�
	��Ҫ��������Ĺ����������������๦�ܵ��������ݡ�
	
	ʹ�ø��ǣ���������
	*/
	
	public boolean equals(Object obj){ //Object obj=new Person(); �������Ķ���ǿ������Ϊ��Object��
		
		//��ߵ�Ч�ʡ������������ָ�����ͬ�����󣬲�����ת�����Ƚ�����
		if(this==obj)
			return true;
		
		
		//return (this.age==obj.age);   //obj������ΪObject�࣬������û��age������ʧ��
		
		//Ҫ��ʹ�����������������Ի�����Ϊ����������������ת�͡�  ��Ҫ���������жϣ�����
		if(!(obj instanceof Person))
			return false;
			//throw new ClassCastException("���ʹ���");
		Person p=(Person)obj;
		//����ж�String�Ƿ���ͬ����Ҫ��==�� �ַ���������һ������
		return this.age==p.age&&this.name.equals(p.name);
	}
	//�ܽ�˼·����һ����Ϊ�˸��ǣ����ƣ��������Ͷ�Ҫһ�����ڶ�����Ϊ��ʹ����������ԣ�Ҫ����ת�ͣ���

	/**
	 ����Person�������е��ַ���������ʽ��ֻҪ����toString�������ɡ�
	 */
	public String toString(){
		return "Person[name="+this.name+",age="+this.age+"]";
	}


}

class Demo{}

public class ObjectDemo {

	public static void main(String[] args) {
		
//		Person p1=new Person();
//		Person p2=new Person();
//		Person p3=p1;
//		
//		System.out.println(p1.equals(p2));
//		System.out.println(p1.equals(p3));
		
		//System.out.println(p1.equals(new Demo())); //���� Demo��û��age
		
		Person p1=new Person("lisi",21);
		Person p2=new Person("zhangsan",22);
		
		System.out.println(p1.equals(p2));  //�жϵ��Ƕ�������ݡ���equals
		System.out.println(p1==p2);           //�жϵ��Ƕ���ĵ�ַ
		
		
		System.out.println(p1/*.toString()*/);  //
		System.out.println(p2/*.toString()*/);  //
	}

}
