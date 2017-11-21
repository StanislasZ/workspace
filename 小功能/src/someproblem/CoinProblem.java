package someproblem;

import java.util.Scanner;

public class CoinProblem {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		int target;
		
		while(in.hasNext()){
			target=in.nextInt();
			int num=getNumofCoin(target);
			System.out.println("You need at least "+num+" coins");
		}
		
	}
	
	public static int getNumofCoin(int target){
		
		if(target==1)return 1;
		else if(target==2)return 2;
		else if(target==3)return 1;
		else if(target==4)return 2;
		else if(target==5)return 1;
		
		else{
			return 1+getNumofCoin(target-5);  
		}
		
		
		
	}

}
