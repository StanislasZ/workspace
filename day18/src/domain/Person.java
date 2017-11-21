package domain;



public class Person {
	private String name;
	private int age;
	
	public Person() {
		super();
	}
	

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	
	@Override
	public String toString() {  
		return "Person [name=" + name + ", age=" + age + "]";
	}

	//��дequals��������ȵ����������ֺ����䶼��ͬ
	@Override
	public boolean equals(Object obj) {
		//Ϊ�����Ч�ʣ�����Ƚ϶�����ͬһ����ֱ�ӷ���true
		if(this==obj)
			return true;
		if(!(obj instanceof Person))
			throw new ClassCastException("���ʹ���");
		Person p=(Person)obj;
		return this.name.equals(p.name)&&this.age==p.age;
	}

}
