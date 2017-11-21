package day08_0705;
//day08-继承中成员函数的特点：   30-覆盖的应用，31-覆盖的注意事项

/*
 子父类中的方法的特点：
 
 特殊情况：
 	当子父类中出现了一模一样的方法时。
 	子类对象运行的是子类的方法。
 	这种特殊情况：称之为覆盖。override  复写  重写
 	
 	覆盖：返回值类型，函数名，参数列表都一致
 	
 覆盖使用的注意事项：
 	1.子类方法覆盖父类方法，必须要保证权限>=父类权限
 	2.静态只能覆盖静态，或者被静态覆盖
 */

class Fu1{
	 /*static*/ void show(){
		System.out.println("fu1 show run");
	}
}
class Zi1 extends Fu1{
	/*static*/void show(){
		System.out.println("zi1 show run");
	}
}


public class ExtendsDemo3_Override {

	public static void main(String[] args) {
		Zi1 z=new Zi1();
		z.show();
		//z.show1();
		Phone p1=new Phone();
		NewPhone p2=new NewPhone();
		p1.show();
		p2.show();
	}

}

//描述手机，来电显示，打电话，发短信
class Phone{
	public void call(){
		
	}
	public void sendMsg(){
		
	}
	public void show(){
		System.out.println("number");
		//System.out.println("name");
		//System.out.println("pic");
	}
}
//手机出新了，来电更给力了
class NewPhone extends Phone{
	//定义了来电显示功能。注意：父类已经定义了来电显示功能
	//子类直接拿过来用就可以了。但是子类对功能的内容要有自己的定义。
	//保留父类功能的声明，建立子类功能特有的内容：覆盖的应用。
	public void show(){        //名字不变，内容变
		super.show();  //不变的直接拿过来用
		System.out.println("name");
		System.out.println("pic");
	}
}






