package day13_��ϰ;

/*
 ����compare�����ڵĴ��룬�����������������
 */
class Circle1{
	private double radius;
	public Circle1(double r){
		radius=r;
	}
	public static double compare(Circle1[] cir){
		//�������
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
		System.out.println("���İ뾶ֵ�ǣ�"+Circle1.compare(cir));
		
		//System.out.println(cir[0]);
	}

}
