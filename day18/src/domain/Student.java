package domain;



public class Student implements Comparable{
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
	
	/**
	 * 需要定义对象自身判断内容相同的依据。覆盖equals方法。
	 */
//	@Override
//	public boolean equals(Object obj) {
//		if(this==obj)return true;
//		if(!(obj instanceof Student))
//			throw new ClassCastException(obj.getClass().getName()+"类型错误");
//		Student s=(Student)obj;
//		
//		return this.name.equals(s.name)&&this.age==s.age;
//	}
	/**
	 * 覆盖hashCode方法。根据对象自身的特点定义哈希值。
	 */
//	@Override
//	public int hashCode() {
//		
//		return this.name.hashCode()+this.age*31;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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


	/**
	 * 学生就具备了比较功能。
	 * 自然排序就以年龄的升序排序为主。
	 */

	@Override
	public int compareTo(Object o) {
		Student stu=(Student)o;
		/*
		if(this.age>stu.age)
			return 1;
		if(this.age<stu.age)
			return -1;
		return 0;
		*/
		
		/*
		 * 既然是同姓名同年龄才是同一个人，视为重复元素。要判断的要素有两个
		 * 先判断年龄，再判断姓名
		 * 		
		 */
		
		int temp=this.age-stu.age;
		
		return temp==0?this.name.compareTo(stu.name):temp;
		
		
	}
	
	
	
}