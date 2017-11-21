package day05_0623;
//day05-18-������ת16����    �Զ��巽��1234   3�õ���4         ����1TBD
import java.util.*;
public class ArrayTest5_dec2hex {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������һ��ʮ��������");
		int decnum=in.nextInt();
		
		//String hexstring1=dec2hex1(decnum);
		//System.out.println(decnum+"�ó�16���������õ���Ӧ��ʮ���������ǣ�"+hexstring1);
		
		String hexstring2=dec2hex2(decnum);
		System.out.println(decnum+"����λ��������һλʮ�����Ƶõ���Ӧ��ʮ���������ǣ�"+hexstring2);
		
		String hexstring3=dec2hex3(decnum);
		System.out.println(decnum+"����Ƶ�ķ����õ������"+hexstring3);
		
		//����1���븺����ը��
		
	}

	
	public static String dec2hex1(int x){    //����һ��ʮ���Ƴ�16����
		String[] hexarray={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] array=new String[9];
		String result="";
		int reminder;
		int flag=0;
		for(int i=0;i<8;i++){           //ѭ��8�����
			reminder=x%16;
			array[i]=hexarray[reminder];   //���
		    x=x/16;
		    if(x==0)break;  //һ����С��16�ٳ�һ�ξͱ�0������forѭ��
		    flag++;    //����
		}
		for(int j=flag;j>=0;j--){
			result=result+array[j];
		}                                //��������
		return "0x"+result;
	}
	
	public static String dec2hex2(int x){       //����������4λ�����Ʊ�1λʮ������
		String[] hexarray={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String[] array=new String[8];
		String result="";
		int flag=0;
		for(int i=0;i<8;i++){              //int������Ϊ32λ���������8��ѭ������ 
			array[i]=hexarray[x&15];       //���
			x=x>>>4;                    //����4��
			if(x==0)break;            //�޷�������4�κ�Ϊ0�Ļ���������
			flag++;                       //����4λ������1���ٽ�����һ��
			                    
			
		}
		for(int j=flag;j>=0;j--)      //�������Ifȥ�������е�flag�ĳ�7�������8λʮ��������
			result=result+array[j];   //��������ַ��� 
		return "0x"+result;
	}

	//��Ƶ�ڵķ���:��������֮ǰ�ķ����ѽ��Ū��char����ȥ
	public static String dec2hex3(int x){
		//�����������洢�����ַ�������Ϊ8
		char[] chs=new char[8];
		//����һ�����ڲ��������������
		int index=chs.length;  //��ʼ��index-1ָ��chs�����һ��Ԫ�أ�������Ը��򵥣������������Ķ�
				                                    
		while(x!=0){
			int temp=x&15;
			if(temp>9)
				chs[--index]=(char)(temp-10+'A');
			else
				chs[--index]=(char)(temp-0+'0');   //�Ѽ�0д�������������
			        //����Ҫ��ѭ���������index��1λʮ������indexΪ6��2λΪ5
			x=x>>>4;       
		}
		return toString(chs,index);
	}
	
	//����һ�����ܣ����ַ�����ת���ַ���
	public static String toString(char[] chs,int index){   //chs��8��Ԫ�أ�ǰ�涼��0����flag�������һ������0��λ��
		String result="";
		for(int i=index;i<chs.length;i++)  //flag=0��1λ��=1��2λ
			result=result+chs[i];
		return "0x"+result;              //0x��������ȽϺ�
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
