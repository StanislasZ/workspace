package day04_0622;
//day04-12-����ĳ�������
public class ArrayDemo2 {

	public static void main(String[] args) {
		int[] arr=new int[3];
		//System.out.println(arr[3]); //���ʵ������鲻���ڵ�����ʱ���ᷢ�����쳣��ArrayIndexOutofBoundsException��
		
		arr=null;
		System.out.println(arr[0]);//NullPointerException����ʹ��û���κ�ʵ��ָ��������ͱ�������ʵ��ʱ�����лᷢ�����쳣

	}

}
