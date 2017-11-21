package someproblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Problem1022 {

	public static void main(String[] args) {
	
		Scanner in=new Scanner(System.in);
		
		int carnum;
		String o1,o2;
		while(in.hasNext()){
			carnum=in.nextInt();  //获取火车的数量
			o1=in.next();    //获取顺序o1 字符串形式
			o2=in.next();	 //获取顺序o2 字符串形式
			

			
			int[] order_in=str2intarray(o1);     //把o1字符串形式变成 int数组
			int[] order_out=str2intarray(o2);    //同上
			
			
			
			Stack<Integer> car=new Stack<>();  //建立一个栈， 模拟多个火车 到同一个站的情况

			//一旦发生入栈动作（也就是火车进来了），add(1);  发生出栈动作（火车走了），add(0)
			ArrayList<Integer> yesorno=new ArrayList<>();  //in就add1  out就add0
			
			//在方法前，先把o1的第一个压入栈中。  yesorno中就add(1)
			car.push(order_in[0]);
			yesorno.add(1);  
			
		
			boolean result=isOut(car,order_in,order_out,yesorno,carnum,1,0);
			
			
			
			if(result){
				System.out.println("Yes.");
				for (Iterator<Integer> it = yesorno.iterator(); it.hasNext();) {
					Integer integer =  it.next();
					if(integer==1)
						System.out.println("in");
					else if(integer==0)
						System.out.println("out");
					
				}
				System.out.println("FINISH");
			}else{
				System.out.println("No.");
				System.out.println("FINISH");
			}
			
		}
		
		
	}
	/**
	 * @param car  ：模拟站台
	 * @param order_in ：进站台的顺序
	 * @param order_out ：出站台的顺序
	 * @param yesorno  ：用来标记in,out
	 * @param carnum   ：火车数量
	 * @param in_flag  ：进站台的指针 
	 * @param out_flag  ：出站台的指针
	 * 
	 * 思路：
	 * 	1.运行这个方法前，order_in的第一个元素已经入栈。所以in_flag取1，  out_flag取0
	 * 	2.先判断order_out[out_flag]是不是栈顶元素。如果不是，把order_in的第二个元素压入，进来的指针加1。  yesorno就add（1）
	 * 										如果是，栈pop， 出去的指针加1。yesorno就add(0)
	 * 	3.重新判断……………………
	 * 
	 * 	4.直到in_flag=carnum时，说明order_in的所有元素都被压入栈过了。只要不停得pop，看这个值是不是等于order_out[out_flag],直到栈为空
	 * 
	 * 	
	 * @return
	 */
	public static boolean isOut(Stack<Integer> car,int[] order_in,int[] order_out,ArrayList<Integer> yesorno,int carnum,int in_flag,int out_flag){
				
		boolean aaa=true;
		
		if(in_flag<=carnum-1){
			if((!car.isEmpty())&&order_out[out_flag]==car.peek()){   //输出序列的指定位置的值 等于 栈顶的值,就弹出
				car.pop();
				//System.out.println("OUT"+out_flag);
				yesorno.add(0);
				out_flag++; // in_flag不变
				
			}else if(car.isEmpty()||car.peek()!=order_out[out_flag]){
				car.push(order_in[in_flag]);
				yesorno.add(1);
				in_flag++;   //out_flag不变
				
			}
			aaa=isOut(car,order_in,order_out,yesorno,carnum,in_flag,out_flag);
		}else if(in_flag==carnum){  //运行到这里，说明order_in所有元素都被压入过
						
			for(int i=out_flag;i<order_out.length;i++){
				if(car.pop()!=order_out[i]){
					aaa=false;
					break;
				}else{
					yesorno.add(0);
				}
			}
			return aaa;
		}
		return aaa;
	}
	
	
	
	/**
	 * 把字符串拆分成单个数字，装入数组
	 * @param o1
	 * @return
	 */
	public static int[] str2intarray(String o1) {
		int[] temp=new int[o1.length()];
		
		for(int i=0;i<o1.length();i++){
			char c=o1.charAt(i);
			int tempint=c-'0'+0;
			temp[i]=tempint;
		}
		
		return temp;
	}

}
