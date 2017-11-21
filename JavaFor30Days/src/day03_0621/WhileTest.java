package day03_0621;
//day03-33-while练习
public class WhileTest {

	public static void main(String[] args) {
		/*
		 while语句练习：
		 
		需求1：显示1-10
 	 
		 */
        int x=1;
        while(x<=10){
        	System.out.print(x+" ");
        	x++;
        }
		
		//需求2：运算1-10的和
        int sum=0;
        int i=1;
        while(i<=10){
        	sum+=i;
        	i++;
        }
        System.out.println("");
        System.out.print("1加到10="+sum);
		
		
		
		
	}

}
