//核心技术87页 二维数组
public class P87moneytable {

	public static void main(String[] args) {
		final double startrate=10;
		final int nrates=6;
		final int nyears=10;
		
		double[] interestrate=new double[nrates];    //利率是一维数组 6个元素
		for(int j=0;j<interestrate.length;j++)
			interestrate[j]=(startrate+j)/100.0;
		
		double[][] balances=new double[nyears][nrates];
		
		for(int j=0;j<balances[0].length;j++)
			balances[0][j]=10000;                     //第一行都是10000
		
		//计算每一个
		for(int i=1;i<balances.length;i++){
			for(int j=0;j<balances[i].length;j++)
				balances[i][j]=balances[i-1][j]+balances[i-1][j]*interestrate[j];//某一格=上一格+上一格*这列的利率
		}
		
		for(int j=0;j<interestrate.length;j++)
			System.out.printf("%9.0f%%", 100*interestrate[j]);        //两个%输出时为一个%
		System.out.println();
		
		for(double[] row:balances){
			for(double element:row)
				System.out.printf("%10.2f", element);                       // 上面9加上一个%=10
			System.out.println();
	
			
			
		}
	
	
		

	}

}
