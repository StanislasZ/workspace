package day17_0829;

public class WrapperDemo2 {

	public static void main(String[] args) {
		/*
		 * JDK1.5后，新的技术
		 * 自动装箱自动拆箱。像操作int一样操作Integer
		 */
		
		//Integer i=new Integer(4);
		//1.5以后
		Integer i=4;   //自动装箱。Integer.valueOf(4);
		
		i=i+6;  //右边的i从对象转成整数   （自动拆箱），加完6的结果又一次装箱，给i
	
		sop(5);
		
		Integer x=new Integer(100);
		Integer y=new Integer(100);
		System.out.println(x==y);
		System.out.println(x.equals(y));
		System.out.println("-----------------------------");
		//jdk1.5有，自动装箱的值如果在byte范围之内，相同的值不会单独开辟空间，而是重复使用
		Integer x2=100;
		Integer y2=100;
		
		System.out.println(x2==y2);
		System.out.println(x2.equals(y2));
	
		x2++;
		//System.out.println(y2);
		System.out.println(x2==y2);
	
	}
	public static void sop(Object s){
		System.out.println(s);
	}

}
