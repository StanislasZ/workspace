package day05_0626;
//day05-28-��ά����ڶ��ֶ���
public class TwoDimArray2 {

	public static void main(String[] args) {
		/*
		 ��ά�������һ�ֶ��巽ʽ
		 */
		int[][] arr={{23,17,11},{88,11,33,90},{11,78,34}};
		//���
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++)
				sum=sum+arr[i][j];
		}
		System.out.println("sum="+sum);

	}

}
