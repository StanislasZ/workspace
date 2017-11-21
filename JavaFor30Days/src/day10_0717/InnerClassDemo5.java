package day10_0717;   //65-匿名内部类练习

class Outer5{
	
//	class Inner extends Object{
//		
//	}
	public void method(){
		//方法一
		new Object(){      
			public void show(){
				System.out.println("show run");
			}
		}.show();            //直接new出一个子类对象，这个对象的类型不是Object
		
		//方法二
		Object obj=new Object(){    //Object obj指向了自己的子类对象。但同时这个对象被强行提升了为了Object   （多态）就不能调用子类的特有方法
			public void show(){
				System.out.println("show run");
			}
		};
		//obj.show();    //错误。方法二是多态就不能调用子类的特有方法
	}
}



public class InnerClassDemo5 {
	public static void main(String[] args) {
		

	}

}
