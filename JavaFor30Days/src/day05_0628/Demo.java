package day05_0628;
//day06-15
/*
public class Demo {

	public static void main(String[] args) {
		int x=0;
		show(x);   
		System.out.println("x="+x);
	}
	
	public static void show(int x){
		x=5;                      //这里的x只属于show的大括号
	}

}
*/

public class Demo { //public不写的话就默认public
	int x=6;
	public static void main(String[] args) {
		Demo d=new Demo();
		d.x=8;
		//show(d);   //如果改成 show(new Demo());结果是？
		show(new Demo()); 
		System.out.println("x="+d.x);
	}
	
	public static void show(Demo d){
		d.x=5;                      
	}

}