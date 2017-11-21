package math;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		
		
		/*
		 * Math:数学类
		 */
	
			
		double d1=Math.ceil(12.34);  //大于12.34的最大整数
		double d2=Math.floor(12.34);  //小于12.34的最大整数
		double d3=Math.round(12.34);  //四舍五入
	
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d3);
//	
//		System.out.println(Math.pow(2.0, 3 ));
	
		for (int i = 0; i < 10; i++) {
			int d=(int)Math.ceil(Math.random()*6);
			System.out.println(d);
		}
	
		Random r=new Random(); //定义一个随机数生成器
		
		for (int i = 0; i < 10; i++) {
			int d=r.nextInt(6)+1;
			System.out.println("random:"+d);
		}
		
	
	}

}
