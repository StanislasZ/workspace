package ��ʲô;
import java.math.*;

import java.util.*;

public class ting0712all {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
		
		//int[] table_num={11,12,13,14,15,16,17,18,19,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,41,43,45,47,49,51,53};
		//String[] table_name={"һ��","����","����","����","����","��","��","��","��","��","��","��","��","��","��","��","��"
				//,"Ͳ","Ͳ","Ͳ","Ͳ","Ͳ","Ͳ","Ͳ","Ͳ","Ͳ",};
				
		Map<Integer, String> paiMap;  //����
			paiMap = new HashMap<Integer, String>();  
			
			paiMap.put(1,"һ��");paiMap.put(2,"����");paiMap.put(3,"����");paiMap.put(4,"����");paiMap.put(5,"����");
			paiMap.put(6,"����");paiMap.put(7,"����");paiMap.put(8,"����");paiMap.put(9,"����");
			
			paiMap.put(11,"һ��");paiMap.put(12,"����");paiMap.put(13,"����");paiMap.put(14,"����");paiMap.put(15,"����");
			paiMap.put(16,"����");paiMap.put(17,"����");paiMap.put(18,"����");paiMap.put(19,"����");
			
			paiMap.put(21,"һͲ");paiMap.put(22,"��Ͳ");paiMap.put(23,"��Ͳ");paiMap.put(24,"��Ͳ");paiMap.put(25,"��Ͳ");
			paiMap.put(26,"��Ͳ");paiMap.put(27,"��Ͳ");paiMap.put(28,"��Ͳ");paiMap.put(29,"��Ͳ");
			
			paiMap.put(31,"����");paiMap.put(33,"�Ϸ�");paiMap.put(35,"����");paiMap.put(37,"����");paiMap.put(39,"����");
			paiMap.put(41,"����");paiMap.put(43,"�װ�");
	    //System.out.println(paiMap.get(12));   //ex
	    
		 
		int[] pai={2,2,2,3,3,3,4,4,4,5,5,6,6};        //1 1 1 1 1 1 1 1 3
	    int[] c=new int[44];                     //     c[1]-c[9]����Ͳ�м�����c[11]-c[19]�������м�����c[21]-c[29]����Ͳ���м���
	                                                //          31�� 33�� 35�� 37��  39�� 41�� 43��
	    int[] c_initial=new int[44];        //���������c
	    int[] c_plusi=new int[44];       //����ÿ��i,������ѭ��ǰ��c���Ѿ���14���ƣ�
	    int[] mj=new int[7];                     //�����齫���Ʒ��� mj
	    int[] three=new int[4];                  //��һ�̵���
	    
	    int[] hu=new int[44];          //����ʱ������
	    
	    for(int i=0;i<pai.length;i++){     //�����ø�����ʽ����
	    	c[pai[i]]++;  
	    }
	    c_initial=Arrays.copyOf(c,c.length);  //c��ֵ�����󣬱���
	   
	    System.out.print("��Ϊ��");
	    PrintArray(pai);
	    System.out.print("�ø�����ʾΪ��");
	    PrintArray(c);
		
		
		
		for(int i=1;i<=43;i++){                                                                     //��һ��ѭ��������ÿ�����������Ƿ��ܺ�
			if(i%10==0||(i>30&&i%2==0))continue;   //10,20,30,32,34,36,38,40,42ʱֱ����������Ϊ����
			
			
			System.out.println("******");
			//ÿ�ν���ʱ�����������ָ�c
			c=Arrays.copyOf(c_initial,c_initial.length);
			
			
			
			SetArrayZero(mj);//ÿ�ν���ʱ��mjԪ�ض���0
			
			c[i]++;                              //����������
			c_plusi=Arrays.copyOf(c,c.length);   //���ݼ�������ƺ��c
			
			if(i<43&&c[i]<=1){
				if(c[i-1]==0&&c[i+1]==0)    //��c�йأ��������������c�ָ�֮��
					continue;          //
			}
			
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
			
			
			
			
			//����ڶ���ѭ��
			for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
				//�ָ��ӹ�i��c
				c=Arrays.copyOf(c_plusi,c_plusi.length);
				//��three����
				SetArrayZero(three);
				
				
				c[mj[j]]-=2;        //ɾ�齫
				System.out.println("     "+"ɾ��һ��"+mj[j]+"��cΪ��");
				PrintArray(c);
				//�齫ɾ�꣬������Щ����3����4���ġ�	
				
				num_three=FindNumOfThree(c);   //��ȷ
				System.out.println("     "+"һ�̵��Ƶĸ���Ϊ"+num_three);
				//int[] three=new int[num_three];
				PutThree(c,three);
				System.out.print("     "+"��һ�̵����ǣ�");
				PrintArray(three);
			
				
				
				//ÿ�θ��ǣ�����Ϊnum_row
				
				boolean result=rec(c,three,num_three);
				
				if(result==true){
					hu[i]++;
				}
				
												
			}	
			
		}		
		
		
			
		System.out.print("������Ϊ��");
		//PrintArrayNotZero(hu);
		printHu(hu,paiMap);
		
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺"+(endTime-startTime)+"ms");
	}
			
	//�ݹ麯��
		public static Boolean rec(int[] c,int[] three,int num){     //numΪ���ӵĸ���
		    int[] temp=new int[44];
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
		//�ҳ����һ����0Ԫ�ص��±�
		public static int FindLastNotZero(int[] arr){
			for(int i=arr.length-1;i>=0;i--){
				if(arr[i]!=0)
					return i;
			}
			return -1;
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
		    
		    if((min!=-1)&&(min<=27)){                    //���±���±�С�ڵ���27
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
	
	//printHu
	public static void printHu(int[] hu,Map paiMap){
		for(int i=0;i<hu.length;i++){
			if(hu[i]>0){
				
				System.out.print(paiMap.get(i)+",");
			}
			
				
		}
		System.out.println();
	}
}
