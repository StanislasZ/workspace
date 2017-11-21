package demo;

import java.util.Arrays;
import java.util.Comparator;

import comparator.ComparatorByLength;

public class Demo_P225 {

	public static void main(String[] args) {
		
		String[] str={"stan","mike","cherry"};
		
		Comparator<String> comp=new ComparatorByLength(); //newһ���Ƚ�������
		
		Arrays.sort(str, comp);
		
		for(String element:str){
			System.out.println(element);
		}

	}

}
