package math;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		
		
		/*
		 * Math:��ѧ��
		 */
	
			
		double d1=Math.ceil(12.34);  //����12.34���������
		double d2=Math.floor(12.34);  //С��12.34���������
		double d3=Math.round(12.34);  //��������
	
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d3);
//	
//		System.out.println(Math.pow(2.0, 3 ));
	
		for (int i = 0; i < 10; i++) {
			int d=(int)Math.ceil(Math.random()*6);
			System.out.println(d);
		}
	
		Random r=new Random(); //����һ�������������
		
		for (int i = 0; i < 10; i++) {
			int d=r.nextInt(6)+1;
			System.out.println("random:"+d);
		}
		
	
	}

}
