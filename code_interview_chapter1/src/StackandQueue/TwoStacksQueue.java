package StackandQueue;

import java.util.Stack;
/**
 * P7由两个栈组成的队列
 * @author guguguagua
 *
 */
public class TwoStacksQueue {

	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStacksQueue() {
		stackPush=new Stack<Integer>();
		stackPop=new Stack<Integer>();
	}
	
	public void add(int num){
		stackPush.push(num);
	}
	
	public int poll(){
		
		if(stackPush.empty()&&stackPop.empty()){
			throw new RuntimeException("Queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		
		return stackPop.pop();
	}
	
	public int peek(){
		if(stackPush.empty()&&stackPop.empty()){
			throw new RuntimeException("Queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		
		return stackPop.peek();
	}
	
	
	
	
	
	
	
}
