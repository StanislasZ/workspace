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

	//重写equals方法，相等的条件：名字和年龄都相同
	@Override
	public boolean equals(Object obj) {
		//为了提高效率，如果比较对象是同一个，直接返回true
		if(this==obj)
			return true;
		if(!(obj instanceof Person))
			throw new ClassCastException("类型错误");
		Person p=(Person)obj;
		return this.name.equals(p.name)&&this.age==p.age;
	}

}
