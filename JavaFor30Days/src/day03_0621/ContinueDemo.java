package day03_0621;
//day03
public class ContinueDemo {

	public static void main(String[] args) {
		/*
		 continue：只作用于循环结构！！！（继续循环）
		                  结束本次循环，继续下次循环
		 */

//		for(int x=0;x<10;x++){
//			if(x%2==0)continue;
//			System.out.println("x="+x);
//			
//		}
		
		out:for(int x=0;x<3;x++){
			in:for(int y=0;y<4;y++){
				System.out.println("x="+x);
				continue out;//跳出外循环，不写out默认跳出内循环
				
			}
		}
		
		
		
		
	}

}
