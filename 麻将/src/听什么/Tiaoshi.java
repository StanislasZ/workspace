package ��ʲô;

import java.util.*;
import java.time.LocalDate;
import java.util.Date;   //java.util.Date �� java.sql.Date �ĸ��ࡣ

public class Tiaoshi {

	public static void main(String[] args) {
		
		
//		LocalDate today=LocalDate.now();   //����:LocalDate�� ������ today
//		
//		System.out.println(today);
//		
//		int jintianjihao=today.getDayOfMonth();
//		System.out.println("������"+jintianjihao+"��");
		
		
		int[] pai={41,41,43,43};        //1 1 1 1 1 1 1 1 3
	    int[] c=new int[44]; 
		
	    for(int i=0;i<pai.length;i++){     //�����ø�����ʽ����
	    	c[pai[i]]++;  
	    }
	    
	   System.out.println("min="+FindFirstNotZero(c)+",max="+FindFirstNotZero(c));
		
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
}
	
	
	
