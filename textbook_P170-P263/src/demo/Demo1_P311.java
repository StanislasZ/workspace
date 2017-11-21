package demo;

import domain.Pair;

public class Demo1_P311 {

	public static void main(String[] args) {
		
		Pair<Integer> p1=new Pair<Integer>(2,3);
		
		System.out.println(p1.getFirst());
		
		Pair<String> p2=new Pair<String>("a","c");
		System.out.println(p2.getSecond());
		

	}

}
