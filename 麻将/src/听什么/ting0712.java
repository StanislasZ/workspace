package ��ʲô;
import java.math.*;

import java.util.*;

public class ting0712 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
		
		int[] pai={1,1,1,1,2,2,2,2,3,3,3,3,4};        //1 1 1 1 1 1 1 1 3
	    int[] c=new int[10];                     //��1-9     c[1]����1Ͳ�м�����c[9]����9Ͳ�м���
	    int[] c_initial=new int[10];        //���������c
	    int[] c_plusi=new int[10];       //����ÿ��i,������ѭ��ǰ��c���Ѿ���14���ƣ�
	    int[] mj=new int[7];                     //�����齫���Ʒ��� mj
	    int[] three=new int[4];                  //��һ�̵���
	    
	    int[] hu=new int[10];          //����ʱ������
	    
	    for(int i=0;i<pai.length;i++){     //�����ø�����ʽ����
	    	c[pai[i]]++;  
	    }
	    c_initial=Arrays.copyOf(c,c.length);  //c��ֵ�����󣬱���
	   
	    System.out.print("��Ϊ��");
	    PrintArray(pai);
	    System.out.print("�ø�����ʾΪ��");
	    PrintArray(c);
		
		
		
		for(int i=1;i<=9;i++){                                                                     //��һ��ѭ��������ÿ�����������Ƿ��ܺ�
			System.out.println("******");
			//ÿ�ν���ʱ�����������ָ�c
			c=Arrays.copyOf(c_initial,c_initial.length);
			//���mj
			SetArrayZero(mj);
			
			c[i]++;                              //����������
			c_plusi=Arrays.copyOf(c,c.length);   //���ݼ�������ƺ��c
			
			System.out.println("����������"+i+"��");
			
			//���c[i]==5,continue ���뵽һ�¸�i�����������������ƣ�
			if(c[i]>4)continue;
			
			
			int num_mj;                                //����i�󣬲鿴�����齫����        
			num_mj=FindNumOfTwo(c);
			System.out.println("�����齫�ĸ���Ϊ"+num_mj);
			Putmj(c,mj);//���齫������mj����
			System.out.print("�����齫���ƾ���Ϊ��");
			PrintArray(mj);
			 
			int num_three=0;      //3����4������
			int num_row=1;       //2�Ŀ������η�����Ϊÿ�β���ccʱʵ���õ���������ǰ������ȶ���������ȶ�㡣
			
			
			
			//����ڶ���ѭ��
			for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
				//�ָ��ӹ�i��c
				c=Arrays.copyOf(c_plusi,c_plusi.length);
				
				
				c[mj[j]]-=2;        //ɾ�齫
				System.out.println("     "+"ɾ��һ��"+mj[j]+"��");
				//�齫ɾ�꣬������Щ����3����4���ġ�	
				
				num_three=FindNumOfThree(c);   //��ȷ
				System.out.println("     "+"һ�̵��Ƶĸ���Ϊ"+num_three);
				//int[] three=new int[num_three];
				PutThree(c,three);
				System.out.print("     "+"��һ�̵����ǣ�");
				PrintArray(three);
			
				num_row=(int)Math.pow(2,num_three);  //֮���ά���������
				
				//ÿ�θ��ǣ�����Ϊnum_row
				
				boolean result=rec(c,three,num_three);
				
				if(result==true){
					hu[i]++;
				}
				
												
			}	
			
		}		
		
		
			
		System.out.print("������Ϊ��");
		PrintArrayNotZero(hu);
		
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺"+(endTime-startTime)+"ms");
	}
			
	//�ݹ麯��
		public static Boolean rec(int[] c,int[] three,int num){     //numΪ���ӵĸ���
		    int[] temp=new int[10];
		    temp=Arrays.copyOf(c, c.length);
		    if (num==1){
		        
		        recStraight(temp);//ֱ�Ӹ�
		        if(FindFirstNotZero(temp)==-1)   //-1�Ļ����������
		            return true;
		        //���ֱ�Ӹ�ʧ����
		        else{
		        	//���¸�temp��ֵ
		            temp=Arrays.copyOf(c, c.length);
		            deleteThree(temp,three,1);     //ȥ����һ��  
		            recStraight(temp);              //ȥ˳��
		            if(FindFirstNotZero(temp)==-1)
		                return true;
		            else
		                return false;
		         	            
		        }
		    }
		  else  {
		        
		        recStraight(temp);//ֱ�Ӹ�
		        if(FindFirstNotZero(temp)==-1)   //�����
		            return true;
		        //���ֱ�Ӹ�ʧ����
		        else{
		        	temp=Arrays.copyOf(c, c.length);   //���¸�temp��ֵ  
		            for(int i=0;i<num;i++){
		            	temp=Arrays.copyOf(c, c.length); 
		                deleteThree(temp,three,i+1);
		                if(rec(temp,three,num-1))     //����num=2��  ������ⲽ�� ��ֱ�ӷ��ĵؽ���  һ�̵ĵݹ�  ����ɹ�����true��������
		                    return true;
		            }
		            
		        }
		  }
		    return false;
		}	
			
			
			
		//�ҳ���һ����0Ԫ�ص��±�
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //ȫ��Ϊ0ʱ������-1
		}
			
			
		
		
		//ȥһ�ο��ӣ���ȷ����Ҫѡ����һ����
		public static void deleteThree(int[] c,int[] three,int index){           //�ڶ�����������ɾ�ڼ���     ɾ��һ�̾�ɾthree[0]
				PutThree(c,three);
				if(FindNumOfThree(c)>0)
		    		c[three[index-1]]-=3;
		    
		}
		
	   //ɾ˳��	,����֤Ϊ��ȷ
		public static void recStraight(int[] c){
		    		   
		    int min = FindFirstNotZero(c);
		    
		    if((min!=-1)&&(min+2<=9)){                    //���±���±�С�ڵ���7
		        if ((c[min+1]>=1)&(c[min+2]>=1)){
		            c[min]-=1;
		            c[min+1]-=1;
		            c[min+2]-=1;
		            recStraight(c);
		        }
		    }
		}
 
	
	
	//�������齫�ķ���һ������mj   mj[0]��ʼ
		public static void Putmj(int[] arr,int[] mj){    //��c���� c�±��1��ʼ
			int j=0;
			for(int i=0;i<arr.length-1;i++){
				if(arr[i+1]>=2){
					mj[j]=i+1;
					j++;
				}
			}
		}
	
	
	//���齫���Ҵ��ڵ����������ƣ�  ���Ҹ���
	public static int FindNumOfTwo(int[] arr){
		int num_two=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=2)
				num_two++;
		}
		return num_two;
	}
	
	
	
	
	//��һ�̵�Ͳ�ӷ���һ������three
	public static void PutThree(int[] c,int[] three){    //��c���� c�±��1��ʼ
		int j=0;
		for(int i=0;i<c.length-1;i++){
			if(c[i+1]>=3){
				three[j]=i+1;
				j++;
			}
		}
	}
		
	//�ҳ���3���ĸ���
	public static int FindNumOfThree(int[] arr){
		int num_three=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=3)
				num_three++;
		}
		return num_three;
	}
		
	//��ӡ����
	public static void PrintArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//��ӡ�����еķ�0Ԫ��
	public static void PrintArrayNotZero(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0)
				System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//��ӡ��ά����
	public static void PrintTwoDimArray(int[][] arr){
		for(int[] row:arr){
			for(int element:row){
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}
	
	//����Ԫ����0
	public static void SetArrayZero(int[] arr){
		for(int i=0;i<arr.length;i++)
			arr[i]=0;
	}
	public static void SetArrayZero(int[][] arr){
		for(int[] row:arr){
			for(int element:row){
				element=0;
			}
		}
	}
	
	
}
