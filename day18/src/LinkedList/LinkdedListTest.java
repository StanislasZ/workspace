package LinkedList;

import java.util.LinkedList;

public class LinkdedListTest {

	public static void main(String[] args) {
		
		/*
		 * 练习：请通过LinkedList实现一个堆栈，或者队列数据结构
		 * 堆栈：后进先出
		 * 队列：先进先出
		 */
		
		//1.创建自定义队列对象
		MyQueue queue=new MyQueue();
		//2.添加元素
		queue.myAdd("abc1");
		queue.myAdd("abc2");
		queue.myAdd("abc3");
		queue.myAdd("abc4");
		//3.获取所有元素。先进先出
		while(!queue.isNull()){
			System.out.println(queue.myGet());
		}
		
	}

}

/*
* 描述一个队列数据结构。内部使用的是LinkedList
*/
class MyQueue{
	private LinkedList link;
	MyQueue(){
		link=new LinkedList();
	}
	
	/**
	 * 添加元素的方法
	 */
	public void myAdd(Object obj){
		link.addFirst(obj);
	}
	
	/**
	 * 获取队列元素的方法
	 */
	public Object myGet(){
		return link.removeLast();
	}
	
	/**
	 * 集合中是否有元素的方法
	 */
	public boolean isNull(){
		return link.isEmpty();
	}
	
	
	
	
	
	
	
	
}