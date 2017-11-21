package day08_0705;
//day08-27-继承中成员变量的特点，28-super

/*
 子父类出现后，代码上的一些特点：
 	
 	1.成员变量
 	
 	2.成员函数
 	
 	3.构造函数
 */
//成员变量。注意的是原理。
/*
 当子父类中出现了同名的成员变量，用关键字super来区分！
 
 super和this的用法很相似
 	this:代表本类的对象引用
 	super:代表父类的那片空间
 */

class Fu{
	int num=4;
}
class Zi extends Fu{
	int num=5;
	void show(){
		int num=6;
		System.out.println("num="+num);             //局部变量	
		System.out.println("num="+this.num);        //本类成员变量
		System.out.println("num="+super.num);     //父类成员变量
		System.out.println("this="+this);
		
		//System.out.println(super);  //编译失败
	}
}



public class ExtendsDemo2_super {
	public static void main(String[] args) {
		Zi z=new Zi();
		System.out.println("z="+z);
		z.show();
	}

}
