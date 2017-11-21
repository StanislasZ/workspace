package day03_0621;
//day03-38-for嵌套练习
public class ForForTest {

	public static void main(String[] args) {
		/*
		 需求：在屏幕上显示以下图形
		 *****
		 ****
		 ***
		 **
		 *
		 思路：
		 */
		
		/*
		 for(int i=0;i<5;i++){
		 
			for(int j=1;j<=5-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		for(int i=1;i<=5;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
	}

}
