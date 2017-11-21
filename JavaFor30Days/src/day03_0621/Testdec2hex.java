package day03_0621;
//day03-43，44 -dec2hex
import java.util.*;
public class Testdec2hex {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个十进制数");
		int a=in.nextInt();
		
		char[]array=new char[10];
		int reminder;
		int i;
		int b=a;   //备份a
		int flag=0;
		for( i=0;i<=10;i++){           //循环10次足够
			reminder=a%16;
		    if(reminder<=9){
		    	array[i]=(char)(reminder+48);
		    }
		    else{
		    	array[i]=(char)(reminder+55);
		    }
		    a=a/16;
		    if(a==0)break;             //一旦商小于16再除一次就变0，跳出for循环
		    flag++;                    //记录除了几次，便于判断数组长度
		}
		
		//System.out.println("flag="+flag);
		
		System.out.print(b+"转化为十六进制为：");
		for(int j=flag;j>=0;j--)
		System.out.print(array[j]);
//		 
//		//System.out.println(Integer.toHexString(1000));
//		System.out.println();
//		System.out.println(Integer.toBinaryString(26)); 

		
		/*
		 思路：
		 1.原理：将二进制中4位为一个十六进制位
		 2.怎么获得每4位？可以通过位运算的方式，如&
		 3.怎么获得下四位？可以对原数据进行无符号右移
		 
		 步骤：
		 1.定义变量记录该整数
		 2.对该变量进行&运算，既然是获取四位，就&四个1，二进制四个1就是十进制的15
		 3.对原数据进行无符号右移四位。
		 */
//		int num=26;
//		int n1=num&15;
//		
//		System.out.println("n1="+(char)(n1-10+'a'));
//		//对num进行右移
//		num=num>>>4;
//		int n2=num&15;
//		System.out.println("n2="+(char)(n2+'0'));
		
		//把结果经过运算变成ascii码就行。  
		/*以上的动作不合适，运算很重复，到底&15的结果是否需要做这个字母转换，无法确定
		1.通过循环，完成重复的运算。
		2.通过if完成是否需要转成字母的判断		
		*/
		
//		int num=26;
//		for(int x=0;x<8;x++){
//			int n=num&15;
//			if(num>9){
//				System.out.println((char)(n-10+'A'));
//			}
//			else
//				System.out.println(n);
//			num=num>>>4;
//		}
		//两个问题未解决：1.反了，2.多0，需要对多数据进行存储。
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
