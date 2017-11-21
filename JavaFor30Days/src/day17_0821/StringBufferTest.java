package day17_0821;

public class StringBufferTest {

	public static void main(String[] args) {
		/*
		 * 1.ͨ������������Ҫ��ӡ�ľ������Ԫ��*���д洢��һ���Է��ء������
		 * 
		 * 2.��int�����Ԫ��ת���ַ�������ʽΪ��[34,12,67]
		 * 
		 * ʲôʱ�����ַ�����������
		 * ���ݺܶ࣬��������νȷ������������νȷ����ֻҪ���ת���ַ�����
		 * ��ʹ��StringBuffer���������
		 * 
		 * ʹ�õľ����ԣ�1.��������ת���ַ�����
		 * 				2.�޷��Դ洢������Ԫ�ؽ��е�����������Ϊ�洢������Ԫ�ض�����ַ�����
		 * 
		 */
		String rec=draw(8,5);
		//System.out.println(rec);
		
		int[] arr={34,55,44,77};
		String s=toString(arr);
		String s2=toString2(arr);
		System.out.println(s);
		System.out.println(s2);
		
		StringBuffer buf1=new StringBuffer("hello");
		StringBuffer buf2=new StringBuffer("java");
		test(buf1,buf2);
		System.out.println(buf1+"...."+buf2);
		
		
	}
	
	public static void test(StringBuffer buf1,StringBuffer buf2){
		buf1.append(buf2);
		buf1=buf2;
	}
	
	
	/*
	 * �����εĹ���
	 * ����Ҫ��ɾ��ε�Ԫ�ؽ�����ʱ�洢��
	 */
	public static String draw(int row,int col){
		//����һ����ʱ������
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	/**
	 * int����ת���ַ�����ͨ��StringBuffer
	 */
	public static String toString2(int[] arr){
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				sb.append(arr[i]+",");
			}
			else{
				sb.append(arr[i]+"]");
			}
		}
		return sb.toString();
	}
	
	
	
	
	/**
	 * int����ת���ַ���
	 */
	public static String toString(int[] arr){
		String str="[";
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				str+=arr[i]+",";
			}
			else{
				str+=arr[i]+"]";
			}
		}
		return str;
	}
	
	
	
	
	
	
	
	
	

}
