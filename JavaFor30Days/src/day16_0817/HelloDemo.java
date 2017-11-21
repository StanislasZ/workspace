package day16_0817;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HelloDemo {

	public static void main(String[] args) {
		System.out.println("hello world");
		
		/*
		 ¿ì½Ý¼ü£ºalt+/
		 		shift+enter
		 		
		 */
		
		Lock lock=new ReentrantLock();
		Condition con=lock.newCondition();
		System.out.println("hello world");
		System.out.println("hello world");
		System.out.println("hello world");
		System.out.println("hello world");
		System.out.println("hello world");
		
		final int number=4;
		
		
	}

}
