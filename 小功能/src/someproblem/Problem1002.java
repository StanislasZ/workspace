package someproblem;

import java.util.Scanner;

public class Problem1002 {

	public static void main(String[] args) {
		
		Scanner in0 =new Scanner(System.in);
		
		int T;
		T=in0.nextInt();
		//System.out.println(T);
		
		
		
		int flag=0;
		while(flag<T){
			String s1=in0.next();
			String s2=in0.next();
			
			String s3=s1;
			String s4=s2;
			
			
			int lengthspan=s1.length()-s2.length();
			if(lengthspan>0){
				for(int i=0;i<lengthspan;i++)
					s2="0"+s2;
			}else if(s1.length()<s2.length()){
				for(int i=0;i<-lengthspan;i++)
					s1="0"+s1;
			}
			
			StringBuilder sb=new StringBuilder();
			int symbol=0;
			for(int i=s1.length()-1;i>=0;i--){
				char c1=s1.charAt(i);
				char c2=s2.charAt(i);
				int num1=c1-'0'+0;
				int num2=c2-'0'+0;
				
				int temp=num1+num2+symbol;
				if(temp<=9){
					sb.append(temp);
					symbol=0;
				}else if(temp>=10){
					sb.append(temp-10);
					symbol=1;
				}
				
				
			}
			if(symbol==1)
				sb.append(1);
			sb.reverse();
			String result=sb.toString();
			
			//System.out.println(String.format("Case %d:",flag+1));
			//System.out.println(String.format("%s + %s = %s", s3,s4,result));
			
			
			
			
//			if(flag<T-1)
//				System.out.print(String.format("\n"));
			
			System.out.println("Case "+(flag+1)+":");
			System.out.println(s3+" + "+s4+" = "+result);
			if(flag!=T-1)
				System.out.println();
			
			
			
			
			
			flag++;
				
		}
		
		

	}

}
