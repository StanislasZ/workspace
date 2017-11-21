package day03_0621;
//day03-46-倒三角数字,九九乘法表
public class TriangleTest {

	public static void main(String[] args) {
//		for(int i=1;i<=5;i++){
//			for(int j=5;j>=i;j--){
//				System.out.print(j);
//			}
//			System.out.println();
//		}
			
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+"\t");    //\t可以制表，自动对齐   \n可以换行
				//System.out.printf("%d*%d=%-2d   ",j,i,j*i);     //加个负号就变成左对齐！！！！
				}
			System.out.println();
		}
		System.out.println("\"hello\"");
		
		//String array=""ddddd"";
		
		

	}

}
