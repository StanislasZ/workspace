package demo;

import StackandQueue.MyStack1;

public class Demo1 {

	public static void main(String[] args) {
		
		MyStack1 ms=new MyStack1();
		
		ms.push(3);
		ms.push(6);
		ms.push(4);
		ms.push(1);
		
		
		
//		while(!(ms.isEmpty())){
//			System.out.println(ms.pop());
//		}
		
		System.out.println(ms);
		
		ms.reverse();
		System.out.println(ms);
	}

}
