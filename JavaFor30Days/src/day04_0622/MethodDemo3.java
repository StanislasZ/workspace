package day04_0622;
//day04-05-函数重载（overload）
public class MethodDemo3 {

	public static void main(String[] args) {
		
		int sum=add(1,2,3);
		System.out.println("sum="+sum);
        int sum2=add(1,2);
        System.out.println("sum2="+sum2);

        printCFB();
        printCFB(5);
	}
	
	//函数名定义就是为了描述该功能。
	
	
	//两个整数求和的功能。
	public static int add(int a,int b){
		return a+b;
	}
	
	//三个整数求和的功能，也可以取名add，因为参数个数不同，系统仍可以区分(类型不同也可以）
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	
    //两个小数的和
	public static double add(double a,double b){
		return a+b;
	}
	
	//九九乘法表
	public static void printCFB(){
		printCFB(9); 
	}
	
	public static void printCFB(int num){
		for(int i=1;i<=num;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
	}

	
	
	
	
	
	
}
