package day16_0817;

public class StringDemo {

	public static void main(String[] args) {
		String str="abc";
		String str1=new String("abc");
		
		
		System.out.println(str==str1);
		System.out.println(str.equals(str1));  //�ַ�����equals������Object�࣬�Ƚϵ�������
	
		//�ʣ�str��str1������
		/*
		 str���ڴ���ֻ��һ������
		 str1���ڴ�������������
		 */
		
		String s1="abc";    //�ڳ�����û�ҵ�������һ��abc,����abc�ĵ�ַ��s1
		String s2="abc";     //�ڳ��������ҵ���abc�� ���ŵ�ַ��s2
		
		//Ҳ����s1 s2ָ�����һ����������������ַ�������
		
		System.out.println(s1==s2);

	}

}
