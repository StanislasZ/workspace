package demo;

import java.awt.Shape;

public class Demo_P10 {

	public static void main(String[] args) {
		
		String[] st1={"Joe","Bob","Bill","zeke"};
		System.out.println(findMax(st1));
		System.out.println(findMax2(st1));
	}

	public static Comparable findMax(Comparable []arr){
		int maxindex=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i].compareTo(arr[maxindex])>0)
				maxindex=i;
		}
		return arr[maxindex];
	}
	
	public static <T extends Object&Comparable<? super T>> T findMax2(T[] arr){  //·ºÐÍ
		int maxindex=0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i].compareTo(arr[maxindex])>0)
				maxindex=i;
		}
		return arr[maxindex];
	}
	
}
