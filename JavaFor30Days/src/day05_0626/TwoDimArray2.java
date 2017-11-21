package day05_0626;
//day05-28-二维数组第二种定义
public class TwoDimArray2 {

	public static void main(String[] args) {
		/*
		 二维数组的另一种定义方式
		 */
		int[][] arr={{23,17,11},{88,11,33,90},{11,78,34}};
		//求和
		int sum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++)
				sum=sum+arr[i][j];
		}
		System.out.println("sum="+sum);

	}

}
