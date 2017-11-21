package domain;



public class Student implements Comparable{
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
	
	/**
	 * ��Ҫ������������ж�������ͬ�����ݡ�����equals������
	 */
//	@Override
//	public boolean equals(Object obj) {
//		if(this==obj)return true;
//		if(!(obj instanceof Student))
//			throw new ClassCastException(obj.getClass().getName()+"���ʹ���");
//		Student s=(Student)obj;
//		
//		return this.name.equals(s.name)&&this.age==s.age;
//	}
	/**
	 * ����hashCode���������ݶ���������ص㶨���ϣֵ��
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
	 * ѧ���;߱��˱ȽϹ��ܡ�
	 * ��Ȼ��������������������Ϊ����
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
		 * ��Ȼ��ͬ����ͬ�������ͬһ���ˣ���Ϊ�ظ�Ԫ�ء�Ҫ�жϵ�Ҫ��������
		 * ���ж����䣬���ж�����
		 * 		
		 */
		
		int temp=this.age-stu.age;
		
		return temp==0?this.name.compareTo(stu.name):temp;
		
		
	}
	
	
	
}