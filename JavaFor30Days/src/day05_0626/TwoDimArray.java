package day05_0626;
//day05-27-��ά���鶨����ڴ�ͼ��
public class TwoDimArray {

	public static void main(String[] args) {
		//��ά����
		int[][] arr=new int[3][2];
		
		System.out.println(arr);  //[[I@15db9742    @�Ƿָ������ұ���ʮ������ֵ����ϣֵ��ʵ�����ڴ��е�λ�ã�
		                                 //�����[[����ά���飬I��
		                         //��ά����ʵ��
		
		System.out.println(arr[0]); //[I@6d06d69c   һά����ʵ��  һάI@ �ڴ���λ��
		
		System.out.println(arr[0][0]);   //0     Ԫ��

		//
		int[][] array=new int[3][];   //��ȷ�˶�ά����,û����ȷ�����һά����
		System.out.println(array);             //[[I@7852e922
		System.out.println(array[0]);       //null 
		//System.out.println(array[0][0]);   //java.lang.NullPointerException��ָ�룬 ָ��nowhere
		
		
	}

}
