package someproblem;

import java.util.Scanner;


public class Problem1018 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int n;
		n=in.nextInt();
		
		int flag=1;
		while(flag<=n){
			
			int num=in.nextInt();
			int result;
			//System.out.println(num);
			if(num<=3)
				result=1;
			else if(num==4)
				result=2;
			else if(num==5||num==6)
				result=3;
			else{
				
				double num_double=(double)num;
				double temp=0;
				temp=(0.5+num_double)*Math.log10(num_double)+0.5*Math.log10(2.0*Math.PI)-num_double*Math.log10(Math.E);
				
				result=((int)temp)+1;
				
				
			}
			
			System.out.println(result);
			flag++;
			
		}

	}

}
