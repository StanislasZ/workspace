package day03_0621;
//day03-39-break
public class BreakDemo {

	public static void main(String[] args) {
		/*
		 break���÷�Χ��switchѭ�����
		 */

//		for(int x=0;x<3;x++){
//			if(x==2)break;
//			System.out.println("x="+x);
//		}
		
		out:for(int x=0;x<3;x++){
			in:for(int y=0;y<4;y++){
				System.out.println("x="+x);
				break out;//������ѭ������дoutĬ��������ѭ��
				
			}
		}
		
		
		
	}

}
