package day13_练习;

/*
 建立一个图形接口，声明一个面积函数。圆形和矩形都实现这个接口，并得出两个图形的面积。
 注：体现面向对象，对数值进行判断。用异常处理。不合法的数值要出现“这个数值是非法的”提示，不再进行运算。
 */


interface Areable{
	abstract double getArea();
}

class NotValueException extends RuntimeException{
	NotValueException(){
		super();
	}
	NotValueException(String message){
		super(message);
	}
}

class Rec implements Areable{
	private double length,width;
	public Rec(int length,int width){ //构造器
		if(length<=0||width<=0)
			throw new NotValueException("这个数值非法");
		this.length=length;
		this.width=width;
	}
	public double getArea(){
		return length*width;
	}
}
class Circle implements Areable{
	private double radius;
	private static final double PI=3.14;  //可类名调用
	Circle(double radius){
		if(radius<=0)
			throw new NotValueException("这个数值是非法的");
		this.radius=radius;
	}
	public double getArea(){
		return PI*radius*radius;
	}
}


public class Area {
	public static void main(String[] args) {
		Rec r=new Rec(3,4);
		System.out.println(r.getArea());
		Circle c=new Circle(2);
		System.out.println(c.getArea());

	}

}
