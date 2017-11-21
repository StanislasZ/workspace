package 类中的静态变量;


 class tiaoshi {

	static int a = 3;
	static int b;
	static void meth(int x){
		System.out.println("x = "+x);
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
	}
	 
	static{
		System.out.println("static block initialized");
		b = a*4;
	}
	
	public static void main(String[] args) {
		
		meth(42);
	}

}
//先执行static块，再main,再meth