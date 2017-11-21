package day16_0817;

public class StringDemo {

	public static void main(String[] args) {
		String str="abc";
		String str1=new String("abc");
		
		
		System.out.println(str==str1);
		System.out.println(str.equals(str1));  //字符串的equals覆盖了Object类，比较的是内容
	
		//问，str和str1的区别
		/*
		 str在内存中只有一个对象
		 str1在内存中有两个对象
		 */
		
		String s1="abc";    //在常量池没找到，创建一个abc,拿着abc的地址给s1
		String s2="abc";     //在常量池里找到了abc， 拿着地址给s2
		
		//也就是s1 s2指向的是一个对象，这个对象是字符串对象。
		
		System.out.println(s1==s2);

	}

}
