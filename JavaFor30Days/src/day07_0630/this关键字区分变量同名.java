package day07_0630;
//day07-08，09-应用
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
		this.name=name;    //如果String name 下一行 name=name，是局部赋值给局部，并不是局部赋值给成员
		this.age=age;
	}
	Person2(int a){
		age=a;
	}
		//用于显示名字和年龄的方法。
	public void show(){
		System.out.println("name="+name+",age="+age);
	}
	public void method(){
		this.show(); //this可省略
	}
	/*
	 建立功能，判断是否是同龄人
	 结果：boolean
	 参数：传递一个Person对象
	 */
	public boolean equalAge(Person2 pp){
		/*
		 if(pp.age==this.age)
		
			return true;
		return false; */
		
		//return pp==this; //是否指向同个人
		
		return pp.age==this.age;
	}
	
	
}









/*
 当成员变量和局部变量同名时，可以通过this关键字区分
 */
public class this关键字区分变量同名 {

	public static void main(String[] args) {
		Person2 p1=new Person2("旺财",20);    //创建对象，直接初始化
		
		

		
		
		Person2 p2=new Person2("图哥",20);
		p1.show();
		
		System.out.println(p2.equalAge(p1));

	}

}
