package day17_0821;

public class StringBufferDemo {
	public static void main(String[] args) {
		/*
		 StringBuffer:�ַ���������
		 ��Ϊһ���ַ�����
		 �ص㣺
		 	1.���ȿ��Ա仯
		 	2.ͨ��ָ���������Զ����ݽ����޸�
		 	3.��������һ�㶼��߱��������е�Ԫ�ؽ��в����Ĺ��ܡ���ɾ�Ĳ�
		 	4.���������Դ洢��ͬ���͵�����
		 */
		String str;
		//���ڴ��еĹ��̡�1.����һ���ַ���������������2.��Ҫ����ַ�����Ԫ���ȴ洢����
		str=new StringBuffer().append("a").append(4).append('c').toString();
		System.out.println(str);
				
		
	}

}
