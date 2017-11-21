package LinkedList;

import java.util.LinkedList;

public class LinkdedListTest {

	public static void main(String[] args) {
		
		/*
		 * ��ϰ����ͨ��LinkedListʵ��һ����ջ�����߶������ݽṹ
		 * ��ջ������ȳ�
		 * ���У��Ƚ��ȳ�
		 */
		
		//1.�����Զ�����ж���
		MyQueue queue=new MyQueue();
		//2.���Ԫ��
		queue.myAdd("abc1");
		queue.myAdd("abc2");
		queue.myAdd("abc3");
		queue.myAdd("abc4");
		//3.��ȡ����Ԫ�ء��Ƚ��ȳ�
		while(!queue.isNull()){
			System.out.println(queue.myGet());
		}
		
	}

}

/*
* ����һ���������ݽṹ���ڲ�ʹ�õ���LinkedList
*/
class MyQueue{
	private LinkedList link;
	MyQueue(){
		link=new LinkedList();
	}
	
	/**
	 * ���Ԫ�صķ���
	 */
	public void myAdd(Object obj){
		link.addFirst(obj);
	}
	
	/**
	 * ��ȡ����Ԫ�صķ���
	 */
	public Object myGet(){
		return link.removeLast();
	}
	
	/**
	 * �������Ƿ���Ԫ�صķ���
	 */
	public boolean isNull(){
		return link.isEmpty();
	}
	
	
	
	
	
	
	
	
}