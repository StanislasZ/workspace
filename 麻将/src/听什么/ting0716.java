package ��ʲô;   //�������ӵݹ鷨
import java.math.*;

import java.util.*;

public class ting0716 extends Pai_base{

	public static void main(String[] args) {
		long startTime1=System.nanoTime();//��ȡ���루��ǰʱ�䣩
					    
		int[] hua={0,0,0,0,0,0,0,0};  //ų̂
		int quan=1;   //����Ȧ
		int jia=3;		//�����
		
		int[] pai_outerchi={};	
		int[] pai_outerpeng={};    //����������4����������5����ʾ0
		int[] pai_inner={11,11,11,12,13,14,15,16,17,18,19,19,19};        
	    //int[] c=new int[44];                     //     c[1]-c[9]������c[11]-c[19]��������c[21]-c[29]����Ͳ
	                                                //          31�� 33�� 35�� 37��  39�� 41�� 43��
	      
		int hu_flag;
	    
	  //�����������������̨��(ΪɧƤͷ�ṩ���ݣ�
	    Pai_outer out=new Pai_outer(pai_outerpeng,pai_outerchi,quan,jia,hua);   //��ʼ������֤��ȷ���������ⲿ�ƵĶ���out
	    out.calandshowGang();    //���ö���out�еķ���calGang,�������Щ�������ܣ���Щ���ǰ���
	    out.cal_out_TaiandSi();
	    out.print_out_TaiandSi();
	    
	    out.Caloutwantiaotongfeng(); //��һ����û�����ӣ���û�����ӣ���û��Ͳ�ӣ���û�з�ǹ
	    
	    
	    //�����ڲ��ƵĶ���(����Ҫ���ڲ���
	    Pai_inner in=new Pai_inner(pai_inner,quan,jia);
	    
	    in.printpai_inner();   //��ӡ�ڲ���
	    
	    in.findpainenghu();    //Ѱ���ڲ��ƿ��Ժ�����
	    in.printHu();          //��ӡ�ܺ�����
	    
	    //�����Ƿ��ܺ��Ƶ�ָ��hu_flag
	    hu_flag=in.gethu_flag();
	    
	    
	    //���hu_flag=0�������ܺ��ƣ���һ��ɧƤͷ
	    if(hu_flag==0){
	    	//���ü���ɧƤͷ�ĺ���������ʾɧƤͷΪ����
	    	in.cal_in_sao_TaiandSi();
	    	in.print_in_sao_TaiandSi();
	    	System.out.println("ɧƤͷΪ"+in.cal_sao_hushu(out,in)+"��");
	    }
	    
	    //PrintArray(out.get_out_paidistribution());
	    if(hu_flag>0){                                       //�ܺ��Ļ�����һ���¶��󣨰�in��out���й����ݶ���������������һ��ÿ������µĺ���
	    	Hupai_hushu win=new  Hupai_hushu(out,in);
	    	win.Cal_hunqingduiduibonus();
	    	//win.xxx();
	    	win.amazing();
	    }
	    
		
		long endTime1=System.nanoTime();
		System.out.printf("��������ʱ�䣺%.0f��s��ԼΪ%.1fms",(endTime1-startTime1)/1000.0,(endTime1-startTime1)/1000000.0);
	
	}
		
	
	
	
	
	
	
	
	
		//�ҳ���һ����0Ԫ�ص��±�
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //ȫ��Ϊ0ʱ������-1
		}
		//�ҳ����һ����0Ԫ�ص��±�
		public static int FindLastNotZero(int[] arr){
			for(int i=arr.length-1;i>=0;i--){
				if(arr[i]!=0)
					return i;
			}
			return -1;
		}
			
		
		
		
		
		
		
	
	
	//��ӡ�����еķ�0Ԫ��
	public static void PrintArrayNotZero(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0)
				System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//��ӡ��ά����
	public static void PrintTwoDimArray(int[][] arr){
		for(int[] row:arr){
			for(int element:row){
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}
	
	//����Ԫ����0
	public static void SetArrayZero(int[] arr){
		for(int i=0;i<arr.length;i++)
			arr[i]=0;
	}
	public static void SetArrayZero(int[][] arr){
		for(int[] row:arr){
			for(int element:row){
				element=0;
			}
		}
	}
	
	
	
}
