package day05_0623;
//ʮ����תʮ�������ռ���
import java.util.*;

public class dec2hexfinal {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������һ��ʮ��������");
		int num=in.nextInt();
		System.out.println(num+"��Ӧ��ʮ����������"+dec2hex(num));
		
		double a=16.0;
		int b=(int)(Math.log(a)/Math.log(2));
		System.out.println("b="+b);
	}

		
	public static String dec2hex(int x){      
		char[] hextable={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] temparr=new char[8];         //������ʱ����
		int index=temparr.length;
		if(x==0)return "0x0";
		while(x!=0){
			int temp=x&15;                 //ȡ���4λ�����ƶ�Ӧ��ʮ������
			temparr[--index]=hextable[temp];   //��������ݵ���ʱ����
			x=x>>>4;			
		}
		return "0x"+toString(temparr,index);     //�ٶ����������˼·����
	}
	
	public static String toString(char[] arr,int index){    //����char�������ָ��������ƴ�ӵõ�ָ�����ַ���
		String result="";
		for(int i=index;i<arr.length;i++)        //Ϊ������պ���index���Ͱ������index����ɳ��ȣ���--index
			result=result+arr[i];
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
