package day03_0621;
//day03-41-流程控制test：if季节
import java.util.*;
public class TextIfSwitch {

	public static void main(String[] args) {
		/*
		 需求2：根据用户给定的月份数据，显示该月份在哪个季节
		 3,4,5 春季
		 6,7,8夏季
		 9,10,11秋季
		 12,1,2冬季
		 */
		Scanner in=new Scanner(System.in);
		System.out.println("几？");
		int month=in.nextInt();
//		if(month==3||month==4||month==5){        //month是int，可以搞区间
//			System.out.println("春季");
//		}
//		else if(month==6||month==7||month==8){
//			System.out.println("夏季");
//		}
//		else if(month==9||month==10||month==11){
//			System.out.println("秋季");
//		}
//		else if(month==12||month==1||month==2){
//			System.out.println("冬季");
//		}
//		else{
//			System.out.println("输入有误");
//		}
		
		
		
///////////////////////////////////////////////////////////////////

		
		//		if(month>=1&&month<=12){
//			if(month>=3&&month<=5){        
//				System.out.println("春季");
//			}
//			else if(month>=6&&month<=8){
//				System.out.println("夏季");
//			}
//			else if(month>=9&&month<=11){
//				System.out.println("秋季");
//			}
//			else{
//				System.out.println("冬季");
//			}
//		}
//		else 
//		System.out.println("输入有误");
		
		//或者先if范围外
		//再elseif
		
		//用switch完成
		switch(month){
		case 3:
		case 4:
		case 5:
			System.out.println("春季");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("夏季");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("秋季");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("冬季");
			break;
		default:
			System.out.println("error");
			
			
		}
		
		

	}

}
