package day13_��ϰ;

/*
 ����һ��ͼ�νӿڣ�����һ�����������Բ�κ;��ζ�ʵ������ӿڣ����ó�����ͼ�ε������
 ע������������󣬶���ֵ�����жϡ����쳣�������Ϸ�����ֵҪ���֡������ֵ�ǷǷ��ġ���ʾ�����ٽ������㡣
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
	public Rec(int length,int width){ //������
		if(length<=0||width<=0)
			throw new NotValueException("�����ֵ�Ƿ�");
		this.length=length;
		this.width=width;
	}
	public double getArea(){
		return length*width;
	}
}
class Circle implements Areable{
	private double radius;
	private static final double PI=3.14;  //����������
	Circle(double radius){
		if(radius<=0)
			throw new NotValueException("�����ֵ�ǷǷ���");
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
