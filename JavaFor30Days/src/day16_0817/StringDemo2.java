package day16_0817;

public class StringDemo2 {
	public static void main(String[] args) {
		
		String a="abcd";
		System.out.println(a.length());
		
		char ch=a.charAt(1);
		int index=a.indexOf("bc");
		System.out.println(index);
		
		char[] array=a.toCharArray();
		/*
		 查阅api发现，String类的构造函数可以将字节数组，或者字符数组构造成字符串对象
		 
		 1.长度
		 	length()
		 
		 2.获取指定位置字符
		 	charAt(index)
		 			 	 
		 3.获取字符所处的位置
		 *
		 *
		 *
		 *
		 *
		 11.字符串可以比较大小吗？如果有，将字符串数组排序。
		 记住：基本类型数值可以通过比较运算符比较大小和相等。 > < ==
		 对象也可以比较是否相等，谁大谁小。都是通过方法完成
		 
		 对象比较相同：Object类中 boolean equals(Object obj):子类一般会复写，建立自己判断相同的依据
		 对象比大小用到也是方法 该功能有三种情况。所以使用int类型。正  负   0
		 
		 前者大于后者返回正数，前者小于后者返回负数，前者等于后者返回零。
		 */
		int num=a.compareTo("abcz");
		System.out.println(num);
		
	}
	

}
