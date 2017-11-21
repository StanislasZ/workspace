//书里P83 49个数随机抽取6个
import java.util.*;
public class P83LotteryDrawing {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw? ");       //要抽K个数
		int k=in.nextInt();
		
		System.out.println("What is the highest number you can draw? ");       //从1到n抽取k个数
		int n=in.nextInt();
		
		int[] numbers=new int[n];                           //把1到n放入数组
		for(int i=0;i<numbers.length;i++)
			numbers[i]=i+1;
		
		int[] result=new int[k];
		for(int i=0;i<result.length;i++){
			int r=(int)(Math.random()*n);     //用0-1的随机数乘n就得到0到n-1的整数,对于数组numbers，元素1到n对应坐标0到n-1
			
			result[i]=numbers[r];    
			
			numbers[r]=numbers[n-1];          //就是用最大的数换掉刚那个数，避免重复抽取
			n--;
			
		}
		
		Arrays.sort(result);
		for(int element:result)
			System.out.println(element);
		
		
		
		

	}

}
