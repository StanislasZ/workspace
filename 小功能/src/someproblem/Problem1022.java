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
			carnum=in.nextInt();  //��ȡ�𳵵�����
			o1=in.next();    //��ȡ˳��o1 �ַ�����ʽ
			o2=in.next();	 //��ȡ˳��o2 �ַ�����ʽ
			

			
			int[] order_in=str2intarray(o1);     //��o1�ַ�����ʽ��� int����
			int[] order_out=str2intarray(o2);    //ͬ��
			
			
			
			Stack<Integer> car=new Stack<>();  //����һ��ջ�� ģ������ ��ͬһ��վ�����

			//һ��������ջ������Ҳ���ǻ𳵽����ˣ���add(1);  ������ջ�����������ˣ���add(0)
			ArrayList<Integer> yesorno=new ArrayList<>();  //in��add1  out��add0
			
			//�ڷ���ǰ���Ȱ�o1�ĵ�һ��ѹ��ջ�С�  yesorno�о�add(1)
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
	 * @param car  ��ģ��վ̨
	 * @param order_in ����վ̨��˳��
	 * @param order_out ����վ̨��˳��
	 * @param yesorno  ���������in,out
	 * @param carnum   ��������
	 * @param in_flag  ����վ̨��ָ�� 
	 * @param out_flag  ����վ̨��ָ��
	 * 
	 * ˼·��
	 * 	1.�����������ǰ��order_in�ĵ�һ��Ԫ���Ѿ���ջ������in_flagȡ1��  out_flagȡ0
	 * 	2.���ж�order_out[out_flag]�ǲ���ջ��Ԫ�ء�������ǣ���order_in�ĵڶ���Ԫ��ѹ�룬������ָ���1��  yesorno��add��1��
	 * 										����ǣ�ջpop�� ��ȥ��ָ���1��yesorno��add(0)
	 * 	3.�����жϡ���������������
	 * 
	 * 	4.ֱ��in_flag=carnumʱ��˵��order_in������Ԫ�ض���ѹ��ջ���ˡ�ֻҪ��ͣ��pop�������ֵ�ǲ��ǵ���order_out[out_flag],ֱ��ջΪ��
	 * 
	 * 	
	 * @return
	 */
	public static boolean isOut(Stack<Integer> car,int[] order_in,int[] order_out,ArrayList<Integer> yesorno,int carnum,int in_flag,int out_flag){
				
		boolean aaa=true;
		
		if(in_flag<=carnum-1){
			if((!car.isEmpty())&&order_out[out_flag]==car.peek()){   //������е�ָ��λ�õ�ֵ ���� ջ����ֵ,�͵���
				car.pop();
				//System.out.println("OUT"+out_flag);
				yesorno.add(0);
				out_flag++; // in_flag����
				
			}else if(car.isEmpty()||car.peek()!=order_out[out_flag]){
				car.push(order_in[in_flag]);
				yesorno.add(1);
				in_flag++;   //out_flag����
				
			}
			aaa=isOut(car,order_in,order_out,yesorno,carnum,in_flag,out_flag);
		}else if(in_flag==carnum){  //���е����˵��order_in����Ԫ�ض���ѹ���
						
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
	 * ���ַ�����ֳɵ������֣�װ������
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
