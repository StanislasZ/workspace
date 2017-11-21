package someproblem;

import java.util.Scanner;

public class CoinProblem_random {
	
	public static void main(String[] args) {
		
//		Scanner in=new Scanner(System.in);
//		int target;
//		int radix1,radix2,radix3;
//		while(in.hasNext()){
//			target=in.nextInt();
//			radix1=in.nextInt();
//			radix2=in.nextInt();
//			radix3=in.nextInt();
//			
//			//System.out.println(target+"  "+radix1+"  "+radix2+"  "+radix3);
//		}
		
		
		int[] a={1,3,5};
		int[] dp=new int[12];
		int sum=11,cent=0;
		dp[0]=0;
		for(int i = 1; i <= sum; i++) dp[i] = i;//我们假设存在1元的硬币那么i元最多只需要i枚1元硬币，当然最好设置dp[i]等于无穷大  
		   
	    for(int i = 1; i <= sum; i++){  
	        for(int j = 0; j < 3; j++){  
	            if(i >= a[j] && dp[i - a[j]] + 1 < dp[i]){  
	                System.out.println("j="+j);
	            	dp[i] = dp[i- a[j] ] + 1;
	            	System.out.println("dp["+i+"]="+dp[i]);
	                
	            }  
	        }  
	    }  
		
		
		System.out.println(dp[sum]);
		
		
		
		
		
		
		
		
		
	}
}
