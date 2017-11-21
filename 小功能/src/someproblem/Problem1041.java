package someproblem;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1041 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		while(in.hasNextInt()){
			int n=in.nextInt();
			
			//int[] dp00=new int[n];
			//int[] dp01=new int[n];
			
			//dp00[0]=0;
			//dp01[0]=1;
			
			BigInteger dp00,dp01,dp1,zhongjie,zhongjie2;
			
			dp00=new BigInteger(""+0);
			dp01=new BigInteger(""+1);
			dp1=new BigInteger(""+1);
			zhongjie=new BigInteger(""+0);
			zhongjie2=new BigInteger(""+0);
			
			for(int i=1;i<n;i++){
				zhongjie=new BigInteger(""+0);
				zhongjie2=new BigInteger(""+0);
				
				
				zhongjie2=zhongjie2.add(dp1); //上次的dp1备份
				zhongjie=zhongjie.add(dp01);//上次的dp01 备份
				//System.out.println("上一次的dp1,dp01,dp01,dp00："+zhongjie2+"   "+zhongjie+" "+dp00);
				
				dp01=zhongjie2.add(dp00); //求这次的dp01
				//System.out.println("这次dp01="+dp01);
				
				dp00=new BigInteger(""+0);
				dp00=dp00.add(zhongjie); //求这次的dp00
				
				dp1=dp1.add(dp1);  //1的个数翻倍
				
				
				
				
				
				//dp00[i]=dp01[i-1];
				//dp01[i]=(int)(Math.pow(2.0, (double)(i-1)))+dp00[i-1];
				
				
			}
			
			//System.out.println(dp00[n-1]);
			
			System.out.println(dp00);
			
			
			
			
			
		}

	}

}
