package day05_0623;
//day05-16-������ת���ַ���
public class ArrayTest3 {

	public static void main(String[] args) {
		/*
		 ����1�����幦�ܣ���{34,12,122,444,67}�е�Ԫ��ת���ַ���"[34,12,122,444,67]"
		 ��ȷ1��������ַ���
		 ��ȷ2������������
		 
		 ˼·��
		 �򵥵ķ�ʽ�����������ַ������κ�������Ӷ��������ӣ�����
		 */
		
//		String a="a";
//		String b="b";
//		System.out.println(a+b);
        int[] arr={34,12,122,444,67};
        String result=toString(arr);
        System.out.println(result);
	}

	
	public static String toString(int[] arr){
		String a="[";
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1)
				a=a+arr[i]+",";
			else
				a=a+arr[i]+"]";      //��������һ��Ԫ�أ��Ͳ��Ӷ���,���������š�
		}
		
		return a;
		
	}
	
	
	
	
	
	
	
	
	
	
}
