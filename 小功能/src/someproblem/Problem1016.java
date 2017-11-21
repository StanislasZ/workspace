package someproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Problem1016 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);

		int n;
		int flag=1;
		while(in.hasNextInt()){
			n=in.nextInt();
			
			
			int[] initial=new int[n];   //标志位   角标0到n-1表示数字1到n
			for(int i=1;i<initial.length;i++){   //第一个圈是1
				initial[i]=1;
			}
			

			int[] store=new int[n];
			store[0]=1;

			//求得n个数时，两个数相加是素数的数组
			Integer[] prime2n=getallprimesum(n);
			int[] prime2nint=integer2int(prime2n);

			
			int[] initial_bu=Arrays.copyOf(initial, initial.length);
			int[] store_bu=Arrays.copyOf(store, store.length);
			
			System.out.println("Case "+flag+":");
			deepsearch(initial_bu,store_bu,prime2nint,n-1,n);
			System.out.println();//case之间空一行	

			flag++;
			
		}
	}
	/**
	 * 
	 * @param initial
	 * @param store
	 * @param prime2nint
	 * @param n 还有n个位置要填充  比如ninitial=6;第一次调用时n=5,第二次n=4……第五次调用n=1，进入if，弄完就结束
	 */
	public static void deepsearch(int[] initial,int[] store,int[] prime2nint,int n,int ninitial){
		//数据备份
		int[] initial_backup=Arrays.copyOf(initial, initial.length);
		int[] store_backup=Arrays.copyOf(store, store.length);
		
		if(n==1){
			for(int i=0;i<prime2nint.length;i++){
				int temp1=prime2nint[i]-store[ninitial-n-1];
				if(temp1<=ninitial&&temp1>=1&&initial[temp1-1]==1&&isPrime(temp1+1)){
					store[ninitial-n]=temp1;
					initial[temp1-1]=0;
					
					//System.out.println("****");
					
					for(int ii=0;ii<store.length;ii++){
						if(ii!=store.length-1)
							System.out.print(store[ii]+" ");
						else
							System.out.println(store[ii]);
					}
					
					
					
					
					return;
				}
			}
		}
		else if(n>=2){
			for(int i=0;i<prime2nint.length;i++){
				int temp=prime2nint[i]-store[ninitial-n-1];   //这个数只能从prime2nint里挑一个-前一个角标上的值
				
				
				
//				if(n==2){
//					System.out.println("i="+i+":"+"temp为"+temp);
//				}
				
				
				
				
				
				if(temp<=ninitial&&temp>=1&&initial[temp-1]==1){       //相减得到的值 如果小于等于n，并且未被使用，
					store[ninitial-n]=temp;
					initial[temp-1]=0;  //标志位置0
					
//					System.out.println("n="+n+":");
//					
//					for(int ii=0;ii<initial.length;ii++){
//						System.out.println("initial  "+ii+":"+initial[ii]);
//					}
//					for(int ii=0;ii<store.length;ii++){
//						System.out.println("store  "+ii+":"+store[ii]);
//					}
						
					
					deepsearch(initial,store,prime2nint,n-1,ninitial);
				}
				
				//运行到这里，说明前面没试成功，应把有关数据恢复
				initial=Arrays.copyOf(initial_backup, initial_backup.length);
				store=Arrays.copyOf(store_backup, store_backup.length);
			}
			//运行到这里，说明跪了
			//System.out.println("n="+n+"跪了");
			
		}
		
		
		
		
	}
	
	
	public static int[] integer2int(Integer[] prime2n) {
		int[] temp=new int[prime2n.length];
		for(int i=0;i<prime2n.length;i++){
			temp[i]=prime2n[i];
		}
		return temp;
	}


	/**
	 * 找出n个数时， 两个数相加为素数，找到这些素数,变成Integer数组
	 */
	public static Integer[] getallprimesum(int n){
		
		if(n==1){
			Integer[] temp={1};
			return temp;
		}
		Collection<Integer> c=new ArrayList<>();
		int primenum=0;
		for(int i=3;i<=2*n-1;i++){
			if(isPrime(i)){
				c.add(i);
				primenum++;
			}
		}
		Integer[] prime2n=new Integer[primenum];
		prime2n=c.toArray(prime2n);
		
		return prime2n;
		
	}
		
	/**
	 * 判断一个数是否是素数
	 * @param num
	 * @return
	 */
	public static boolean isPrime(int num){
		if(num==1)return false;
		
		for(int i=2;i<=num/2;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

}
