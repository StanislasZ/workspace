package 听什么;

import java.util.*;
import java.time.LocalDate;
import java.util.Date;   //java.util.Date 是 java.sql.Date 的父类。

public class Tiaoshi {

	public static void main(String[] args) {
		
		
//		LocalDate today=LocalDate.now();   //类型:LocalDate， 变量名 today
//		
//		System.out.println(today);
//		
//		int jintianjihao=today.getDayOfMonth();
//		System.out.println("今天是"+jintianjihao+"号");
		
		
		int[] pai={41,41,43,43};        //1 1 1 1 1 1 1 1 3
	    int[] c=new int[44]; 
		
	    for(int i=0;i<pai.length;i++){     //把牌用个数形式保存
	    	c[pai[i]]++;  
	    }
	    
	   System.out.println("min="+FindFirstNotZero(c)+",max="+FindFirstNotZero(c));
		
	}
	
	
	
	//找出第一个非0元素的下标
			public static int FindFirstNotZero(int[] arr){
				for(int i=0;i<arr.length;i++){
					if(arr[i]!=0)
						return i;
				}
				return -1;      //全部为0时，返回-1
			}
	//找出最后一个非0元素的下标
	public static int FindLastNotZero(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]!=0)
				return i;
		}
		return -1;
	}
}
	
	
	
