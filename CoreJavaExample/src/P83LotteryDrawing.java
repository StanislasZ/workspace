//����P83 49���������ȡ6��
import java.util.*;
public class P83LotteryDrawing {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw? ");       //Ҫ��K����
		int k=in.nextInt();
		
		System.out.println("What is the highest number you can draw? ");       //��1��n��ȡk����
		int n=in.nextInt();
		
		int[] numbers=new int[n];                           //��1��n��������
		for(int i=0;i<numbers.length;i++)
			numbers[i]=i+1;
		
		int[] result=new int[k];
		for(int i=0;i<result.length;i++){
			int r=(int)(Math.random()*n);     //��0-1���������n�͵õ�0��n-1������,��������numbers��Ԫ��1��n��Ӧ����0��n-1
			
			result[i]=numbers[r];    
			
			numbers[r]=numbers[n-1];          //�������������������Ǹ����������ظ���ȡ
			n--;
			
		}
		
		Arrays.sort(result);
		for(int element:result)
			System.out.println(element);
		
		
		
		

	}

}
