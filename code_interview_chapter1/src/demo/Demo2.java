package demo;

import StackandQueue.TwoStacksQueue;

public class Demo2 {

	public static void main(String[] args) {
		
//		Queue<Integer> q=new ArrayDeque<>();
//
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.add(4);
//		
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		System.out.println(q.poll());

		TwoStacksQueue mq=new TwoStacksQueue();
		mq.add(2);
		mq.add(3);
		mq.add(4);
		
		System.out.println(mq.poll());
		System.out.println(mq.poll());
		System.out.println(mq.poll());
		
		mq.add(8);
		mq.add(10);
		
		System.out.println(mq.poll());
		System.out.println(mq.poll());
	}

}
