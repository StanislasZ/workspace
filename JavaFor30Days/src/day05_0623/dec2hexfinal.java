package day05_0623;
//十进制转十六进制终极版
import java.util.*;

public class dec2hexfinal {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个十进制数：");
		int num=in.nextInt();
		System.out.println(num+"对应的十六进制数是"+dec2hex(num));
		
		double a=16.0;
		int b=(int)(Math.log(a)/Math.log(2));
		System.out.println("b="+b);
	}

		
	public static String dec2hex(int x){      
		char[] hextable={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] temparr=new char[8];         //创建临时容器
		int index=temparr.length;
		if(x==0)return "0x0";
		while(x!=0){
			int temp=x&15;                 //取最后4位二进制对应的十进制数
			temparr[--index]=hextable[temp];   //查表，存数据到临时容器
			x=x>>>4;			
		}
		return "0x"+toString(temparr,index);     //再定义个函数，思路清晰
	}
	
	public static String toString(char[] arr,int index){    //给出char型数组和指定索引，拼接得到指定的字符串
		String result="";
		for(int i=index;i<arr.length;i++)        //为了这里刚好是index，就把上面的index定义成长度，和--index
			result=result+arr[i];
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
