package day05_0623;
//day05-21-进制转换（豪华版）     
//出现问题：八进制移位会出现数据缺少1位，负数时会出错，已解决（视频内的方法没有注意到这个问题）
//定义出了toBinary(),toOctal(),toHex()三个函数,参数为int型
import java.util.Scanner;
public class Conversion {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个十进制数：");
		int num=in.nextInt();
//		System.out.println("要转换成几进制？");
//		double jinzhi=in.nextDouble();
//		
//		System.out.println(num+"对应的"+(int)(jinzhi)+"进制数是"+trans(num,jinzhi));
		
		System.out.println(num+"对应的二进制数是"+toBinary(num));
		System.out.println(num+"对应的八进制数是"+toOctal(num));
		System.out.println(num+"对应的十六进制数是"+toHex(num));
		
		//java已经提供的功能，以后开发直接用。Integer是一个类。类.方法就直接调用了。
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
	}

	public static String toBinary(int num){	           //十转二函数
		int jinzhi=2;
		return trans(num,jinzhi)+"B";
	}
	
	public static String toOctal(int num){	            //十转八函数
		int jinzhi=8;
		return "0"+trans(num,jinzhi);
	}
	
	public static String toHex(int num){	         //十转十六函数
		int jinzhi=16;
		return "0x"+trans(num,jinzhi);
	}

	
	
	
	
	
	public static String trans(int x,double jinzhi){      
		char[] hextable={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  //十六进制以下全部可以用这个表！不需要删除元素！
		int yuanshu=x;
		
		int a;                                                    
		a=(int)(32.000000*Math.log(2)/Math.log(jinzhi));      //a是临时容器的长度  
		if (32.000000%(Math.log(jinzhi)/Math.log(2))!=0)  
			a++;
		int offset=(int)(Math.log(jinzhi)/Math.log(2));           //offset(偏移量)为移几位，因为有log，所以只能二进制，八进制，十六进制
		
		//System.out.println("临时容器长度="+a+",移位位数="+offset);
		
		char[] temparr=new char[32];         //创建临时容器，长度为a
		int index=temparr.length;
		if(x==0)return "0";
		while(x!=0){
			int temp=x&((int)(jinzhi-1));                 //取最后4位二进制对应的十进制数
			temparr[--index]=hextable[temp];   //查表，存数据到临时容器
			x=x>>>offset;
			
			
		if(((int)(jinzhi))==8&&(yuanshu<0)&&(index==temparr.length-(a-1)))
			x=x|4;                                        //解决转八进制，负数的情况下，低3位是0的情况，解决：把这位变1
		
		
		}
		return toString(temparr,index);     //再定义个函数，思路清晰
	}
	
	public static String toString(char[] arr,int index){    //给出char型数组和指定索引，拼接得到指定的字符串
		String result="";
		for(int i=index;i<arr.length;i++)        //为了这里刚好是index，就把上面的index定义成长度，和--index
			result=result+arr[i];
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}