package day17_0829;

public class WrapperDemo {

	public static void main(String[] args) {
		/*
		 * �����������Ͱ�װ�ࡣ
		 * ����������ֵ��װ���˶���
		 * �ô��������ڶ����ж����������Ժ���Ϊ�Ի�����ֵ���в���
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
		 * �����������Ͷ����װ�����Ҫ���ܣ��ڻ������ͺ�String����֮���໥ת��
		 */

		//int�ķ�Χ��ֵ��ֻ��int�������������int��Ӧ�Ķ��������
		//System.out.println(Integer.MAX_VALUE);
		String a="a";
		//System.out.println(Integer.toBinaryString(6));
		
		/*
		 * �ַ���ת�ɻ�����������
		 * ʹ�õ���parse��������(�ַ���); parseInt parseByte parseDouble  parseBoolean
		 * 
		 */
		System.out.println("23"+4);
		//System.out.println(Integer.parseInt("kk")+4);
		
		System.out.println(Integer.parseInt("110",10));
		System.out.println(Integer.parseInt("110",2));
		System.out.println(Integer.parseInt("110",16));
		
		/*
		 * ������������Ҳ��ת���ַ���
		 */
		System.out.println(Integer.toString(3)+8);
		
		/*
		 * Ϊ�˶��������и���Ĳ���
		 * ���Խ�������װ�ɶ���
		 * ����ͨ��Integer�ķ�����ɡ�
		 * int-->Integer
		 * 
		 */
		
		Integer i1=new Integer(4);	//���췽��
		
		Integer i2=Integer.valueOf(4); //��̬����
		
		/*
		 * Integer--->int 
		 */
		
		Integer x1=new Integer(5);
		int n1=x1.intValue();
		
		
		
		
		
		
		
		
		
		
		
	}

}
