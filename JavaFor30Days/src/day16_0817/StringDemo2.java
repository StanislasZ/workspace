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
		 ����api���֣�String��Ĺ��캯�����Խ��ֽ����飬�����ַ����鹹����ַ�������
		 
		 1.����
		 	length()
		 
		 2.��ȡָ��λ���ַ�
		 	charAt(index)
		 			 	 
		 3.��ȡ�ַ�������λ��
		 *
		 *
		 *
		 *
		 *
		 11.�ַ������ԱȽϴ�С������У����ַ�����������
		 ��ס������������ֵ����ͨ���Ƚ�������Ƚϴ�С����ȡ� > < ==
		 ����Ҳ���ԱȽ��Ƿ���ȣ�˭��˭С������ͨ���������
		 
		 ����Ƚ���ͬ��Object���� boolean equals(Object obj):����һ��Ḵд�������Լ��ж���ͬ������
		 ����ȴ�С�õ�Ҳ�Ƿ��� �ù������������������ʹ��int���͡���  ��   0
		 
		 ǰ�ߴ��ں��߷���������ǰ��С�ں��߷��ظ�����ǰ�ߵ��ں��߷����㡣
		 */
		int num=a.compareTo("abcz");
		System.out.println(num);
		
	}
	

}
