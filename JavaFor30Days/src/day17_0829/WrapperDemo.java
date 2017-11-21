package day17_0829;

public class WrapperDemo {

	public static void main(String[] args) {
		/*
		 * 基本数据类型包装类。
		 * 将基本数据值封装成了对象。
		 * 好处：可以在对象中定义更多的属性和行为对基本数值进行操作
		 * 
		 * byte    Byte
		 * short   Short
		 * int     Integer
		 * long	   Long
		 * boolean Boolean
		 * float   Float
		 * double  Double
		 * char    Character
		 * 
		 * 基本数据类型对象包装类的重要功能：在基本类型和String类型之间相互转换
		 */

		//int的范围最值，只有int最清楚。所以找int对应的对象最合适
		//System.out.println(Integer.MAX_VALUE);
		String a="a";
		//System.out.println(Integer.toBinaryString(6));
		
		/*
		 * 字符串转成基本数据类型
		 * 使用的是parse基本类型(字符串); parseInt parseByte parseDouble  parseBoolean
		 * 
		 */
		System.out.println("23"+4);
		//System.out.println(Integer.parseInt("kk")+4);
		
		System.out.println(Integer.parseInt("110",10));
		System.out.println(Integer.parseInt("110",2));
		System.out.println(Integer.parseInt("110",16));
		
		/*
		 * 基本数据类型也能转成字符串
		 */
		System.out.println(Integer.toString(3)+8);
		
		/*
		 * 为了对整数进行更多的操作
		 * 可以将整数封装成对象
		 * 可以通过Integer的方法完成。
		 * int-->Integer
		 * 
		 */
		
		Integer i1=new Integer(4);	//构造方法
		
		Integer i2=Integer.valueOf(4); //静态方法
		
		/*
		 * Integer--->int 
		 */
		
		Integer x1=new Integer(5);
		int n1=x1.intValue();
		
		
		
		
		
		
		
		
		
		
		
	}

}
