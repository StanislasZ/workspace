package someproblem;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1042 {

	public static void main(String[] args){
		
		Scanner in=new Scanner(System.in);
		
		int n;
		while(in.hasNextInt()){
			n=in.nextInt();
			
			BigInteger bb=new BigInteger(""+1);
			
			BigInteger temp;
			for(int i=2;i<=n;i++){
				temp=new BigInteger(""+i);
				bb=bb.multiply(temp);
			}
			
			System.out.println(bb);
			
		}
		
	}
}
