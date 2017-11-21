package day10_0717;   //64-匿名内部类（实现）

interface Inter4{
	void show1();
	void show2();
}

class Outer4{
	private int num=2;
	/*
	class Inner4 implements Inter4{
		public void show1(){}
		public void show2(){}
	}
	*/
	
	public void method(){
//		Inner4 in=new Inner4();
//		in.show1();
//		in.show2();
		
		Inter4 in=new Inter4(){       //弄了个接口的子类对象，名字为in
			public void show1(){}
			public void show2(){}
		};
		in.show1();
		in.show2();
	}
}



public class InnerClassDemo4 {

	public static void main(String[] args) {
		
		new Outer4().method();
		
		new InnerClassDemo4().new Inner44();
	}

	class Inner44{
		
	}
}
