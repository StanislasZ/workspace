package someproblem;

import java.util.Scanner;

public class NumberSequenceDemo {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int[] para=new int[3];
		
		//String str=in.nextLine();
		int result;
		do{
			String str=in.nextLine();
			result=str2f(para, str);
			if(result!=-1)
				System.out.println(result);
			
		}while(result!=-1);
		
			
	}


	/**
	 * 功能：将输入的一行字符串，变成3个int型数据，A,B,n，再调用f函数算出 f(n)
	 * @param para
	 * @param str
	 * @return
	 */
	private static int str2f(int[] para, String str) {
		String[] str_para=str.split(" ");
		
		for(int i=0;i<3;i++){
			para[i]=Integer.parseInt(str_para[i]);
		}
		
		if(!(para[0]==0&&para[1]==0&&para[2]==0)){
			int A=para[0];
			int B=para[1];
			int n=para[2];
			
			int result=f(A,B,n);
			//System.out.println(result);
			return result;
		}
		return -1;
	}
	
	
	public static int f(int A,int B,int n){
				
		if(n==1||n==2)
			return 1;
		
		int[] store=new int[50];
		int[] initial={1,1};
		
		for(int i=0;i<50;i++){
			int temp=(A*initial[1]+B*initial[0])%7;
			initial[0]=initial[1];
			initial[1]=temp;
			store[i]=temp;	   //store[0]是f(3)		
			
			//System.out.println(temp);
		}
		int period=0;
		
		
		
		for(int i=2;i<50;i++){
			if(store[i]==store[0]&&store[i+1]==store[1]){
				//System.out.println("i="+i);
				if(i<=10){
					if(store[2*i]==store[0]&&store[2*i+1]==store[1]){
						period=i;
						break;
					}
				}else if(i>10){
					period=i;
					break;
				}
				
			}
		}
		return store[(n-3)%period];
		
		

	}

}
