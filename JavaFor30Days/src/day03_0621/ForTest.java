package day03_0621;
//day03-36-fortest
public class ForTest {

	public static void main(String[] args) {
		/*
		 需求：获取1-100之间6的倍数的个数
		 */
		int i=1;
		int sum=0;
		for(;i<=100;i++){
			if(i%6==0){
				sum++;
				System.out.println(i);
			}
		}
		System.out.println("sum="+sum);
		
		
		
		
		
		
		
		
	}

}
