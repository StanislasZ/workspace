package day13_练习;

//补足代码

class Circle2{
	private double radius;
	public Circle2(double r){
		radius=r;
	}
	//请定义功能，比较两个圆是否一样大。
	public boolean equals(Object obj){    //自定义相同的依据，这是半径相同
		if(!(obj instanceof Circle2))
			throw new ClassCastException(obj.getClass().getName()+"类型错误");
		//向下转型
		Circle2 c=(Circle2)obj;
		return c.radius==this.radius;
	}
}


public class Test5 {
	public static void main(String[] args) {
		Circle2 cir1=new Circle2(2.0);
		Circle2 cir2=new Circle2(2.0);
		String c="a";
		boolean b=cir1.equals(cir2);
		//boolean b=cir1.equals(c);
		System.out.println("两个圆是否一样大:"+b);

	}

}
