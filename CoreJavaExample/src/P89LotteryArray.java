//P89程序:三角二维数组
public class P89LotteryArray {

	public static void main(String[] args) {
		final int nmax=10;
		
		int[][] odds=new int[nmax][];
		for(int n=0;n<odds.length;n++)
			odds[n]=new int[n+1];
		
		for(int i=0;i<odds.length;i++){
			for(int j=0;j<odds[i].length;j++){
				odds[i][j]=(jiecheng(i))/(jiecheng(j)*jiecheng(i-j));  
			}
		}
			
		for(int[] row:odds){
			for(int element:row)
				System.out.printf("%4d", element);	
			System.out.println();
			
		}
		
	
		
	}
	
	//定义一个阶乘函数 ， 0！=1 ，1！=1,2！=2,3！=6………………
	public static int jiecheng(int x){
		if(x==0)return 1;
		int result=1;
		for(int i=1;i<=x;i++)
			result=result*i;
		return result;
		
	}

}
