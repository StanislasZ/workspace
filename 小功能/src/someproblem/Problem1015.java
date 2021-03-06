package someproblem;   

import java.util.Arrays;
import java.util.Scanner;

public class Problem1015 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int target;
		String str=null;
		while(!((target=in.nextInt())==0&(str=in.next()).equals("END"))){
					
			
			int[] code=new int[str.length()];
			//根据A=1…………得到降序排列的数组
			downsort(str, code);

			int flag=0;
			String result="";

			
			for(int i=0;i<code.length;i++){
				for(int j=0;j<code.length;j++){
					if(j!=i){
						for(int k=0;k<code.length;k++){
							if(k!=i&&k!=j){
								for(int l=0;l<code.length;l++){
									if(l!=i&&l!=j&&l!=k){
										for(int m=0;m<code.length;m++){
											if(m!=i&&m!=j&&m!=k&&m!=l){
												int testsum=gettestsum(i,j,k,l,m,code);
												if(testsum==target){
													//System.out.println(i+","+j+","+k+","+l+","+m);
													result=result+(char)(code[i]+'A'-1);
													result=result+(char)(code[j]+'A'-1);
													result=result+(char)(code[k]+'A'-1);
													result=result+(char)(code[l]+'A'-1);
													result=result+(char)(code[m]+'A'-1);
													flag=1;
													break;
												}
											}
										}
										if(flag==1)break;
									}
								}
								if(flag==1)break;
							}
						}
						if(flag==1)break;
					}
				}
				if(flag==1)break;
			}
			//结束循环后
			if(flag==0){
				result="no solution";
			}
			System.out.println(result);
			

			
			
			
			
			
			
			
		}
		
		

	}
	/**
	 * 根据公式算出值，用来和target比较
	 * @param i,j,k,l,m
	 * @param code
	 * @return
	 */
	public static int gettestsum(int i, int j, int k, int l, int m, int[] code) {
		int temp;
		temp=code[i]-code[j]*code[j]+code[k]*code[k]*code[k]-code[l]*code[l]*code[l]*code[l]+code[m]*code[m]*code[m]*code[m]*code[m];
		return temp;
	}

	/**
	 * 把"BDHKCDEW"变成从大到小排列的数组     2 4………………               （A=1,B=2…………………………）
）	 * @param str
	 * @param code
	 */
	public static void downsort(String str, int[] code) {
		for(int i=0;i<code.length;i++){
			char temp=str.charAt(i);
			code[i]=-(temp-'A'+1);
		}
		Arrays.sort(code);
		for(int i=0;i<code.length;i++){
			code[i]=-code[i];
		}
	}

}
