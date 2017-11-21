package LinkedList;

import java.util.LinkedList;


public class LinkedListDemo {

	public static void main(String[] args) {
		
		//1.创建一个链表对象
		LinkedList link=new LinkedList();
		
		//2.添加
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		
		//3.获取
		//System.out.println(link.getFirst());
		//System.out.println(link.getFirst());
		
		//4.取出link中所有元素
		while(!link.isEmpty()){
			System.out.println(link.removeFirst());
		}
	}

}
