package ��ʲô;      //����������ٷ�
import java.math.*;

import java.util.*;

public class ting0711 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
		long startTime1=System.nanoTime();//��ȡ����
		int[] pai={5,5,5,5,6,6,6};
	    int[] c=new int[10];                     //��1-9     c[1]����1Ͳ�м�����c[9]����9Ͳ�м���
	    int[] c_initial=new int[10];        //���������c
	    int[] c_plusi=new int[10];       //����ÿ��i,������ѭ��ǰ��c���Ѿ���14���ƣ�
	    int[] mj=new int[7];                     //�����齫���Ʒ��� mj
	    int[] three=new int[4];                  //��һ�̵���
	    int[][] cc=new int[16][10];    //����һ��ʱ����ٷ�
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
				for(int t=0;t<num_row;t++)
 					cc[t]=Arrays.copyOf(c, c.length);  //ÿһ�ж��Ǽ��������ƣ�ȥ���齫���c
				//PrintTwoDimArray(cc);
				//���϶���ȷ
				
				OperationOfKe(cc,three,num_three);     //�Կ��ӽ��в�����ÿ������������ѡ�񣬹�2^num_three��ѡ��
				
				for(int k=0;k<num_row;k++){
					for(int t=0;t<4;t++){
						int index=FindFirstNotZero(cc[k]);   //indexΪ��һ���е�һ����0���±�,�Ҳ���ʱ����-1
						if(index==8||index==9)break;     //����С��8��9���϶��鲻��˳�ӣ�ֱ�ӽ����¸�k
						if(cc[k][index+1]!=0&&cc[k][index+2]!=0){
							cc[k][index]--;
							cc[k][index+1]--;
							cc[k][index+2]--;
						}
						if(index==-1){
							hu[i]++;
							break;   //����ܺ���ֱ������ �����¸�k
						}
						
					}
				}
												
				System.out.println("     ******");
				//PrintTwoDimArray(cc);
								
			}			
		}		
		
		
			
		System.out.print("������Ϊ��");
		PrintArrayNotZero(hu);
		
		
		long endTime = System.currentTimeMillis();
		long endTime1=System.nanoTime();
		System.out.println("��������ʱ�䣺"+(endTime-startTime)+"ms");
		System.out.println("��������ʱ�䣺"+(endTime1-startTime1)/1000.0+"��s");
	}
			
			
			
			
			
		//�ҳ�cc[i]��һ�е�һ����0Ԫ�ص��±�
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //ȫ��Ϊ0ʱ������-1
		}
			
			
		
		
		//��һ�̵���Ҫô��Ϊ3��ɾ����Ҫô��ɾ���ɴ˶�cc���в���
		public static void OperationOfKe(int[][] cc,int[] three,int num_three){
			if(num_three==1){
				int t=0;
				for(int a1=0;a1<2;a1++){
					if(a1==0)
						cc[t][three[0]]-=3;
					t++;
				}
			}
			else if(num_three==2){
				int t=0;
				for(int a1=0;a1<2;a1++){
					for(int a2=0;a2<2;a2++){
						if(a2==0)
							cc[t][three[0]]-=3;
						if(a1==0)
							cc[t][three[1]]-=3;
						t++;
					}
				}
			}
			else if(num_three==3){
				int t=0;
				for(int a1=0;a1<2;a1++){
					for(int a2=0;a2<2;a2++){
						for(int a3=0;a3<2;a3++){
							if(a3==0)
								cc[t][three[0]]-=3;
							if(a2==0)
								cc[t][three[1]]-=3;
							if(a1==0)
								cc[t][three[2]]-=3;
							t++;
						}
					}
				}
			}
			else if(num_three==4){                 //���4��
				int t=0;
				for(int a1=0;a1<2;a1++){
					for(int a2=0;a2<2;a2++){
						for(int a3=0;a3<2;a3++){
							for(int a4=0;a4<2;a4++){
								if(a3==0)
									cc[t][three[0]]-=3;
								if(a2==0)
									cc[t][three[1]]-=3;
								if(a1==0)
									cc[t][three[2]]-=3;
								t++;
							}
						}
					}
				}
			}
		}

	
	
	//�������齫�ķ���һ������mj
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
