package day03_0620;
//day03-30-switch
public class SwitchDemo {

	public static void main(String[] args) {
		/*
		 switch(表达式)
		 {
		 	case 取值1：
		 		执行语句;
		 		break;
		 	case 取值2：
		 		执行语句;
		 		break;
		 	………………
		 	default：
		 		执行语句；
		 		break；
		 }
		 */
		
		int x=2;
		switch(x){
		case 2:
			System.out.println("a");
			break;
		case 3:
			System.out.println("b");
			break;
		default:
			System.out.println("c");
			break;
		}
		
		//谁匹配就从哪里开始执行，到break结束
		//都不匹配从default开始执行，到break结束
		//case的顺序可更换
		//支持的数据类型：char，int，byte，short 5.0string
		
		
		
		
		
		
	}

}
