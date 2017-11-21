package demo;

public class Demo_P5 {

	public static void main(String[] args) {
		
		System.out.println(f(30));
		System.out.println(g(14));

	}

	public static int f(int x){
		if(x==0)return 0;
		else return 2*f(x-1)+x*x;
	}
	
	public static int g(int x){
		if(x==1)return 1;
		else if(x==2)return 2;
		else return g(x-1)+g(x-2);
		
	}
}
