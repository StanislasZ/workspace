package day03_0621;
//day03-33-while��ϰ
public class WhileTest {

	public static void main(String[] args) {
		/*
		 while�����ϰ��
		 
		����1����ʾ1-10
 	 
		 */
        int x=1;
        while(x<=10){
        	System.out.print(x+" ");
        	x++;
        }
		
		//����2������1-10�ĺ�
        int sum=0;
        int i=1;
        while(i<=10){
        	sum+=i;
        	i++;
        }
        System.out.println("");
        System.out.print("1�ӵ�10="+sum);
		
		
		
		
	}

}
