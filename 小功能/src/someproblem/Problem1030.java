package someproblem;

import java.util.Scanner;

public class Problem1030 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		while(in.hasNext()){
			int M=in.nextInt();
			int N=in.nextInt();
			
			//1.把M,N转化为第几排的第几个
			DeltaWave d1=new DeltaWave(M);
			DeltaWave d2=new DeltaWave(N);
			int result=0;
			DeltaWave high,low;
			if(d1.hangshu==d2.hangshu){
				result=Math.abs(d1.sequence-d2.sequence);
			}else{
				if(d1.hangshu<d2.hangshu){
					high=d1;
					low=d2;
				}else{
					high=d2;
					low=d1;
				}
				if(high.sequence%2!=0){  //高处那个是上三角
					result=getResult(result, high, low);
								
				}else{  //高处那个是下三角
					int reference=high.sequence+(low.hangshu-high.hangshu);
					if(low.sequence>=reference){
						result+=1;
						high.sequence++;    //步数加1，转换成上三角
						result=getResult(result, high, low);
					}else{
						result+=1;
						high.sequence--;
						result=getResult(result, high, low);
					}
				}
			}
			System.out.println(result);
		}
	}
	public static int getResult(int result, DeltaWave high, DeltaWave low) {
		int left;
		int right;
		left=high.sequence;
		right=left+(low.hangshu-high.hangshu)*2;
		
		if(low.sequence>=left&&low.sequence<=right){
			if(low.sequence%2!=0)
				result=result+(low.hangshu-high.hangshu)*2;
			else
				result=result+(low.hangshu-high.hangshu)*2-1;
		}else if(low.sequence>right){
			result=result+(low.hangshu-high.hangshu)*2+(low.sequence-right);
		}else if(low.sequence<left){
			result=result+(low.hangshu-high.hangshu)*2+(left-low.sequence);
		}
		
		return result;
	}

}
class DeltaWave{
	int hangshu;
	int sequence;
	public DeltaWave(int num) {
		double temp=Math.sqrt((double)num);
		hangshu=(int)Math.ceil(temp);
		sequence=num-(hangshu-1)*(hangshu-1);
	}
	
	
	
	
}