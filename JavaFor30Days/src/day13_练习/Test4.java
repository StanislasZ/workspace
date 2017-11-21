package day13_��ϰ;

/*
 ����Person
 	���ԣ�����������
 	��Ϊ��1.˵�����������䡣
 		  2.�ж��Ƿ���ͬһ���ˣ�ͬ������ͬ������Ϊͬһ���ˣ�
 	��ʾ���ж�������ͬ�ķ�����API�ĵ�String���в��ҡ�
 */

class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void speak(){
		System.out.println("������"+name+",���䣺"+age);
	}
	/**
	 ��ȻҪ�ж϶����Ƿ���ͬ��ֱ��ʹ��Object���еķ�����
	 ���ǻ�Ҫ����������������жϣ�ֱ�Ӹ���Object���еķ���equals
	 */
	public boolean equals(Object obj){
		//�ж������������Ƿ���ͬ����Щ����Person�����ԣ����Ա�������ת��
		if(!(obj instanceof Person))
			throw new ClassCastException("���ʹ���");
		Person p=(Person)obj;
		return this.age==p.age&&this.name.equals(p.name);  //�ַ����������һ������String��Ҳ��equals����
	}
}








public class Test4 {

	public static void main(String[] args) {
		
	}

}
