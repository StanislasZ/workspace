package day17_0821;

public class StringBufferDemo2 {

	public static void main(String[] args) {
		/*
		 * StringBuffer
		 * ���������Զ����ݽ�����ʱ�洢��
		 * 
		 * �˽⻺�����ĳ���������
		 * ���Ԫ�أ�
		 * StringBuffer append(�������͵�����);  ׷��
		 * StringBuffer insert(index,�������͵�����);  ָ��λ�����
		 * 
		 */
		
		//1.����һ������������
		StringBuffer sb=new StringBuffer();
		
		//2.׷��һ���ַ���
		sb.append("abc");
		
		//3.����һ��booleanֵtrue
		sb.insert(1, true);
		
		//4.ɾ���ַ�
		//sb.delete(1, 4);
		
		//5.�޸��ַ�
		sb.replace(1, 5, "false");
		
		//sb.setLength(20);
		sb.reverse();
		
		System.out.println(sb); //println����������Ҫ��ӡ��������ת���ַ���������������ڶ��󣬻��Զ�����toString����

		/*
		 * �ַ���������ά����һ��"�ɱ䳤�ȵ�����"
		 * ���ͣ���ʵ���ǳ����ڲ����鳤�Ⱥ��½����飬����Ϊԭ����1.x��
		 * ����ԭ��������ݸ��Ƶ��������У������µ�Ԫ��Ҳ��ӵ��������С�
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
