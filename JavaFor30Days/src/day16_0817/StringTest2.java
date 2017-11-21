package day16_0817;

public class StringTest2 {
	public static void main(String[] args) {
		String s1="hello";
		String s2="java";
		
		test(s1,s2);
		
		System.out.println(s1+"...."+s2);
		
		s2=s2.replace('a', 'o');
		s1=s2;
		System.out.println(s1+"...."+s2);
	}

	private static void test(String s1, String s2) {
		s2.replace('a', 'o');  //返回一个新的对象，s2本身没变
		//s2=s2.replace('a', 'o');
		s1=s2;
		
	}

}
