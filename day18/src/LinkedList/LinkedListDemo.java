package LinkedList;

import java.util.LinkedList;


public class LinkedListDemo {

	public static void main(String[] args) {
		
		//1.����һ���������
		LinkedList link=new LinkedList();
		
		//2.���
		link.addFirst("abc1");
		link.addFirst("abc2");
		link.addFirst("abc3");
		
		//3.��ȡ
		//System.out.println(link.getFirst());
		//System.out.println(link.getFirst());
		
		//4.ȡ��link������Ԫ��
		while(!link.isEmpty()){
			System.out.println(link.removeFirst());
		}
	}

}
