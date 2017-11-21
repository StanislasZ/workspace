package day13_练习;

/*
 描述Person
 	属性：姓名，年龄
 	行为：1.说出姓名，年龄。
 		  2.判断是否是同一个人（同姓名，同年龄视为同一个人）
 	提示：判断姓名相同的方法到API文档String类中查找。
 */

class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void speak(){
		System.out.println("姓名："+name+",年龄："+age);
	}
	/**
	 既然要判断对象是否相同，直接使用Object类中的方法。
	 但是还要依据子类的特征来判断，直接覆盖Object类中的方法equals
	 */
	public boolean equals(Object obj){
		//判断姓名和年龄是否相同，这些都是Person的属性，所以必须向下转型
		if(!(obj instanceof Person))
			throw new ClassCastException("类型错误");
		Person p=(Person)obj;
		return this.age==p.age&&this.name.equals(p.name);  //字符串本身就是一个对象，String类也有equals方法
	}
}








public class Test4 {

	public static void main(String[] args) {
		
	}

}
