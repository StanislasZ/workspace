package day03_0621;
//day03
public class ContinueDemo {

	public static void main(String[] args) {
		/*
		 continue��ֻ������ѭ���ṹ������������ѭ����
		                  ��������ѭ���������´�ѭ��
		 */

//		for(int x=0;x<10;x++){
//			if(x%2==0)continue;
//			System.out.println("x="+x);
//			
//		}
		
		out:for(int x=0;x<3;x++){
			in:for(int y=0;y<4;y++){
				System.out.println("x="+x);
				continue out;//������ѭ������дoutĬ��������ѭ��
				
			}
		}
		
		
		
		
	}

}
