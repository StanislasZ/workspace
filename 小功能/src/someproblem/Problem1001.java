package someproblem;

import java.util.Scanner;

public class Problem1001 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int n;
		
		while(in.hasNextInt()){
			n=in.nextInt();
			
			int sum=1;
			for(int i=2;i<=n;i++){
				sum+=i;
			}
			
			
			System.out.println(sum);
			System.out.println();
			
			
			
		}
	

	}

}
