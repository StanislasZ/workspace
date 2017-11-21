package StackandQueue;

import java.util.Stack;

/**
 * 实现一个特殊的栈：在实现栈的基本功能的基础上，再实现getMin功能
 * @author Stan
 *
 */
public class MyStack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1() {
		stackData=new Stack<Integer>();
		stackMin=new Stack<Integer>();
	}
	
	public void push(int num){
		if(stackMin.isEmpty()){
			stackMin.push(num);
		}else if(num<=this.getMin()){
			stackMin.push(num);
		}else{
			stackMin.push(stackMin.peek());
		}
		stackData.push(num);
		
	
	}
	
	public int pop(){
		if(stackData.isEmpty())
			throw new RuntimeException("Your stack is empty");
		stackMin.pop();
		return stackData.pop();
		
	}
	
	public int getMin(){
		if(stackMin.isEmpty())
			throw new RuntimeException("Your stack is empty");
		
		return stackMin.peek();
	}
	
	//加个isEmpty   爆炸
	public boolean isEmpty(){
		return stackData.isEmpty();
	}
	
	/**
	 * 把栈底元素返回并移除
	 * @author stan
	 */
	public int getAndRemoveLastElement(){
		int result=stackData.pop();
		if(stackData.isEmpty()){
			return result;
		}else{
			int last=getAndRemoveLastElement();
			stackData.push(result);
			return last;
		}
	}
	
	public void reverse(){
		if(stackData.isEmpty()){
			return;
		}
		int i=getAndRemoveLastElement();
		reverse();
		stackData.push(i);
	}
	
	
	
	

	@Override
	public String toString() {
		return stackData.toString();
	}
	
	
	
	
	
}
