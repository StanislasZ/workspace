package day05_0628;
//day06-12-封装，13-私有，成员变量私有，函数私有
/*
面向对象的三个特征：封装，继承，多态

封装：隐藏实现细节，对外提供公共的访问方式（接口）。   主机后面一堆口，插上就能用，但我们不知道里面的接线

封装的体现之一：将属性都私有化，对外提供对应的setXXX getXXX的方法来访问。

封装的好处：
	1.提高安全性。不允许直接访问细节。并通过公共的方式来访问
	2.提高了易用性。
	3.提高了复用性。
	4.隔离了变化。
*/

/*
描述人。
	属性：年龄
	行为：说话

*/
class Person{
	private int age;     //private是私有，权限修饰符，访问权限就降低了
	/*
	 对私有的数据，可以通过方法的方式对其进行访问。
	 */
	
	public void setAge(int a){    //设置年龄
		if(a<0||a>130){
			//System.out.println(a+"数值是错误的");
			//抛出异常
			throw new RuntimeException(a+"数值是错误的");
		}
		else{
			age=a;
		}
	}
	
	public int getAge(){ 
		return age;        //取出年龄这个数据
	}
	
	
	void speak(){
		System.out.println("age="+age);
	}
}
public class Encapsulation_PersonDemo {

	public static void main(String[] args) {
		//创建Person的对象。调用Person的属性和行为
		Person p=new Person();           //堆内存中创建一个对象
		//p.age=-20;                  //能改数据（能访问age)，怎么不让访问age
		p.setAge(20);
		
		int a=p.getAge();         //访问 对象.方法  取出数据
		System.out.println(a);
		
		p.speak();

	}

}
/*
 函数私有！！

class ArrayTool{
	public void selectSort(int[] arr){
		swap(arr,a,b);
	}
	
	public void bubbleSort(int[] arr){
		swap(arr,a,b);
	}
	
	private void swap(int[] arr,int a,int b){  
		//之前定义的都是public，但现在这个swap只要给上面两个用就行，不需要公开。 直接私有！
		
		
	}
	
}
*/


