package day03_0621;
//day03-43��44 -dec2hex
import java.util.*;
public class Testdec2hex {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.println("������һ��ʮ������");
		int a=in.nextInt();
		
		char[]array=new char[10];
		int reminder;
		int i;
		int b=a;   //����a
		int flag=0;
		for( i=0;i<=10;i++){           //ѭ��10���㹻
			reminder=a%16;
		    if(reminder<=9){
		    	array[i]=(char)(reminder+48);
		    }
		    else{
		    	array[i]=(char)(reminder+55);
		    }
		    a=a/16;
		    if(a==0)break;             //һ����С��16�ٳ�һ�ξͱ�0������forѭ��
		    flag++;                    //��¼���˼��Σ������ж����鳤��
		}
		
		//System.out.println("flag="+flag);
		
		System.out.print(b+"ת��Ϊʮ������Ϊ��");
		for(int j=flag;j>=0;j--)
		System.out.print(array[j]);
//		 
//		//System.out.println(Integer.toHexString(1000));
//		System.out.println();
//		System.out.println(Integer.toBinaryString(26)); 

		
		/*
		 ˼·��
		 1.ԭ������������4λΪһ��ʮ������λ
		 2.��ô���ÿ4λ������ͨ��λ����ķ�ʽ����&
		 3.��ô�������λ�����Զ�ԭ���ݽ����޷�������
		 
		 ���裺
		 1.���������¼������
		 2.�Ըñ�������&���㣬��Ȼ�ǻ�ȡ��λ����&�ĸ�1���������ĸ�1����ʮ���Ƶ�15
		 3.��ԭ���ݽ����޷���������λ��
		 */
//		int num=26;
//		int n1=num&15;
//		
//		System.out.println("n1="+(char)(n1-10+'a'));
//		//��num��������
//		num=num>>>4;
//		int n2=num&15;
//		System.out.println("n2="+(char)(n2+'0'));
		
		//�ѽ������������ascii����С�  
		/*���ϵĶ��������ʣ�������ظ�������&15�Ľ���Ƿ���Ҫ�������ĸת�����޷�ȷ��
		1.ͨ��ѭ��������ظ������㡣
		2.ͨ��if����Ƿ���Ҫת����ĸ���ж�		
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
		//��������δ�����1.���ˣ�2.��0����Ҫ�Զ����ݽ��д洢��
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
