package someproblem;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1023 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int N;
		while(in.hasNext()){
			N=in.nextInt();
			BigInteger bi=new BigInteger("1");
						
			for(int i=2;i<=N;i++){
				int temp=4*i-2;
				String str=""+temp;
				bi=bi.multiply(new BigInteger(str));
				temp=i+1;
				str=""+temp;
				bi=bi.divide(new BigInteger(str));
			}
			System.out.println(bi);
		}
	}
	
	
}
