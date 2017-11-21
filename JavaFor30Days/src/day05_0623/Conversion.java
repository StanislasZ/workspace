package day05_0623;
//day05-21-����ת���������棩     
//�������⣺�˽�����λ���������ȱ��1λ������ʱ������ѽ������Ƶ�ڵķ���û��ע�⵽������⣩
//�������toBinary(),toOctal(),toHex()��������,����Ϊint��
import java.util.Scanner;
public class Conversion {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������һ��ʮ��������");
		int num=in.nextInt();
//		System.out.println("Ҫת���ɼ����ƣ�");
//		double jinzhi=in.nextDouble();
//		
//		System.out.println(num+"��Ӧ��"+(int)(jinzhi)+"��������"+trans(num,jinzhi));
		
		System.out.println(num+"��Ӧ�Ķ���������"+toBinary(num));
		System.out.println(num+"��Ӧ�İ˽�������"+toOctal(num));
		System.out.println(num+"��Ӧ��ʮ����������"+toHex(num));
		
		//java�Ѿ��ṩ�Ĺ��ܣ��Ժ󿪷�ֱ���á�Integer��һ���ࡣ��.������ֱ�ӵ����ˡ�
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toOctalString(num));
		System.out.println(Integer.toHexString(num));
	}

	public static String toBinary(int num){	           //ʮת������
		int jinzhi=2;
		return trans(num,jinzhi)+"B";
	}
	
	public static String toOctal(int num){	            //ʮת�˺���
		int jinzhi=8;
		return "0"+trans(num,jinzhi);
	}
	
	public static String toHex(int num){	         //ʮתʮ������
		int jinzhi=16;
		return "0x"+trans(num,jinzhi);
	}

	
	
	
	
	
	public static String trans(int x,double jinzhi){      
		char[] hextable={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  //ʮ����������ȫ�����������������Ҫɾ��Ԫ�أ�
		int yuanshu=x;
		
		int a;                                                    
		a=(int)(32.000000*Math.log(2)/Math.log(jinzhi));      //a����ʱ�����ĳ���  
		if (32.000000%(Math.log(jinzhi)/Math.log(2))!=0)  
			a++;
		int offset=(int)(Math.log(jinzhi)/Math.log(2));           //offset(ƫ����)Ϊ�Ƽ�λ����Ϊ��log������ֻ�ܶ����ƣ��˽��ƣ�ʮ������
		
		//System.out.println("��ʱ��������="+a+",��λλ��="+offset);
		
		char[] temparr=new char[32];         //������ʱ����������Ϊa
		int index=temparr.length;
		if(x==0)return "0";
		while(x!=0){
			int temp=x&((int)(jinzhi-1));                 //ȡ���4λ�����ƶ�Ӧ��ʮ������
			temparr[--index]=hextable[temp];   //��������ݵ���ʱ����
			x=x>>>offset;
			
			
		if(((int)(jinzhi))==8&&(yuanshu<0)&&(index==temparr.length-(a-1)))
			x=x|4;                                        //���ת�˽��ƣ�����������£���3λ��0����������������λ��1
		
		
		}
		return toString(temparr,index);     //�ٶ����������˼·����
	}
	
	public static String toString(char[] arr,int index){    //����char�������ָ��������ƴ�ӵõ�ָ�����ַ���
		String result="";
		for(int i=index;i<arr.length;i++)        //Ϊ������պ���index���Ͱ������index����ɳ��ȣ���--index
			result=result+arr[i];
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}