package StackandQueue;

import java.util.Stack;

/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ��getMin����
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
	
	//�Ӹ�isEmpty   ��ը
	public boolean isEmpty(){
		return stackData.isEmpty();
	}
	
	/**
	 * ��ջ��Ԫ�ط��ز��Ƴ�
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
