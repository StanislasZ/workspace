package day03_0621;
//day03-41-���̿���test��if����
import java.util.*;
public class TextIfSwitch {

	public static void main(String[] args) {
		/*
		 ����2�������û��������·����ݣ���ʾ���·����ĸ�����
		 3,4,5 ����
		 6,7,8�ļ�
		 9,10,11�＾
		 12,1,2����
		 */
		Scanner in=new Scanner(System.in);
		System.out.println("����");
		int month=in.nextInt();
//		if(month==3||month==4||month==5){        //month��int�����Ը�����
//			System.out.println("����");
//		}
//		else if(month==6||month==7||month==8){
//			System.out.println("�ļ�");
//		}
//		else if(month==9||month==10||month==11){
//			System.out.println("�＾");
//		}
//		else if(month==12||month==1||month==2){
//			System.out.println("����");
//		}
//		else{
//			System.out.println("��������");
//		}
		
		
		
///////////////////////////////////////////////////////////////////

		
		//		if(month>=1&&month<=12){
//			if(month>=3&&month<=5){        
//				System.out.println("����");
//			}
//			else if(month>=6&&month<=8){
//				System.out.println("�ļ�");
//			}
//			else if(month>=9&&month<=11){
//				System.out.println("�＾");
//			}
//			else{
//				System.out.println("����");
//			}
//		}
//		else 
//		System.out.println("��������");
		
		//������if��Χ��
		//��elseif
		
		//��switch���
		switch(month){
		case 3:
		case 4:
		case 5:
			System.out.println("����");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("�ļ�");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("�＾");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("����");
			break;
		default:
			System.out.println("error");
			
			
		}
		
		

	}

}
