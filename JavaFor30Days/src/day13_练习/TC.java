package day13_练习;

/*
 补足compare函数内的代码，不许添加其他函数。
 */
class Circle1{
	private double radius;
	public Circle1(double r){
		radius=r;
	}
	public static double compare(Circle1[] cir){
		//程序代码
		int max_index=0;
		for(int i=0;i<cir.length;i++){
			if(cir[i].radius>cir[max_index].radius)
				max_index=i;
		}
		return cir[max_index].radius;
	}
}

public class TC {
	public static void main(String[] args) {
		Circle1[] cir=new Circle1[3];
		//System.out.println(cir[0]);
		cir[0]=new Circle1(1.0);
		cir[1]=new Circle1(2.0);
		cir[2]=new Circle1(4.0);
		System.out.println("最大的半径值是："+Circle1.compare(cir));
		
		//System.out.println(cir[0]);
	}

}
