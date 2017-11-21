package day05_0623;
//day05-18-用数组转16进制    自定义方法1234   3用到了4         方法1TBD
import java.util.*;
public class ArrayTest5_dec2hex {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个十进制数：");
		int decnum=in.nextInt();
		
		//String hexstring1=dec2hex1(decnum);
		//System.out.println(decnum+"用除16倒序余数得到对应的十六进制数是："+hexstring1);
		
		String hexstring2=dec2hex2(decnum);
		System.out.println(decnum+"用四位二进制是一位十六进制得到对应的十六进制数是："+hexstring2);
		
		String hexstring3=dec2hex3(decnum);
		System.out.println(decnum+"用视频的方法得到结果："+hexstring3);
		
		//方法1输入负数爆炸了
		
	}

	
	public static String dec2hex1(int x){    //方法一：十进制除16来做
		String[] hexarray={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] array=new String[9];
		String result="";
		int reminder;
		int flag=0;
		for(int i=0;i<8;i++){           //循环8次最多
			reminder=x%16;
			array[i]=hexarray[reminder];   //查表
		    x=x/16;
		    if(x==0)break;  //一旦商小于16再除一次就变0，跳出for循环
		    flag++;    //计数
		}
		for(int j=flag;j>=0;j--){
			result=result+array[j];
		}                                //逆序排列
		return "0x"+result;
	}
	
	public static String dec2hex2(int x){       //方法二：用4位二进制变1位十六进制
		String[] hexarray={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] array=new String[8];
		String result="";
		int flag=0;
		for(int i=0;i<8;i++){              //int型数据为32位，所以最多8次循环！！ 
			array[i]=hexarray[x&15];       //查表
			x=x>>>4;                    //右移4次
			if(x==0)break;            //无符号右移4次后为0的话，就跳出
			flag++;                       //大于4位计数加1，再进行下一次
			                    
			
		}
		for(int j=flag;j>=0;j--)      //把上面的If去掉，这行的flag改成7，就输出8位十六进制数
			result=result+array[j];   //倒序组成字符串 
		return "0x"+result;
	}

	//视频内的方法:不建表，按之前的方法把结果弄到char数组去
	public static String dec2hex3(int x){
		//定义容器。存储的是字符，长度为8
		char[] chs=new char[8];
		//定义一个用于操作数组的索引。
		int index=chs.length;  //初始化index-1指向chs的最后一个元素，代码可以更简单，但这样便于阅读
				                                    
		while(x!=0){
			int temp=x&15;
			if(temp>9)
				chs[--index]=(char)(temp-10+'A');
			else
				chs[--index]=(char)(temp-0+'0');   //把减0写出来，便于理解
			        //最重要是循环结束后的index，1位十六进制index为6，2位为5
			x=x>>>4;       
		}
		return toString(chs,index);
	}
	
	//定义一个功能，将字符数组转成字符串
	public static String toString(char[] chs,int index){   //chs是8个元素，前面都是0，用flag来求出第一个不是0的位置
		String result="";
		for(int i=index;i<chs.length;i++)  //flag=0是1位，=1是2位
			result=result+chs[i];
		return "0x"+result;              //0x加在这里比较好
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
