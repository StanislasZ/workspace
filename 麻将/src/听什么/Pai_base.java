package ��ʲô;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//����һ�����ࣺ�ⲿ����Ҫ���ڲ���Ҳ��Ҫ
public class Pai_base{
	static Map<Integer, String> paiMap; { //����
		paiMap = new HashMap<Integer, String>();  
	
		paiMap.put(1,"һ��");paiMap.put(2,"����");paiMap.put(3,"����");paiMap.put(4,"����");paiMap.put(5,"����");
		paiMap.put(6,"����");paiMap.put(7,"����");paiMap.put(8,"����");paiMap.put(9,"����");
	
		paiMap.put(11,"һ��");paiMap.put(12,"����");paiMap.put(13,"����");paiMap.put(14,"����");paiMap.put(15,"����");
		paiMap.put(16,"����");paiMap.put(17,"����");paiMap.put(18,"����");paiMap.put(19,"����");
	
		paiMap.put(21,"һͲ");paiMap.put(22,"��Ͳ");paiMap.put(23,"��Ͳ");paiMap.put(24,"��Ͳ");paiMap.put(25,"��Ͳ");
		paiMap.put(26,"��Ͳ");paiMap.put(27,"��Ͳ");paiMap.put(28,"��Ͳ");paiMap.put(29,"��Ͳ");
	
		paiMap.put(31,"����");paiMap.put(33,"�Ϸ�");paiMap.put(35,"����");paiMap.put(37,"����");paiMap.put(39,"����");
		paiMap.put(41,"����");paiMap.put(43,"�װ�");
	}
	static Map<Integer, Integer> dnxb2indexMap; {  //��������to�±� 
		dnxb2indexMap = new HashMap<Integer, Integer>();
			dnxb2indexMap.put(1,31);dnxb2indexMap.put(2,33);dnxb2indexMap.put(3,35);dnxb2indexMap.put(4,37);
	}
	static Map<Integer, Integer> huaindexMap; {  //�����±��Ӧ��������
		huaindexMap = new HashMap<Integer, Integer>();
		huaindexMap.put(0,1);huaindexMap.put(1,2);huaindexMap.put(2,3);huaindexMap.put(3,4);
		huaindexMap.put(4,1);huaindexMap.put(5,2);huaindexMap.put(6,3);huaindexMap.put(7,4);
	}
	
	static int FindNumOfTwo(int[] arr){
		int num_two=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=2)
				num_two++;
		}
		return num_two;
	}
	
	//�������齫�ķ���һ������mj   mj[0]��ʼ
	static void Putmj(int[] arr,int[] mj){    //��c���� c�±��1��ʼ
		int j=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1]>=2){
				mj[j]=i+1;
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

	//ȥһ�ο��ӣ���ȷ����Ҫѡ����һ����
	public static void deleteThree(int[] c,int[] three,int index){           //�ڶ�����������ɾ�ڼ���     ɾ��һ�̾�ɾthree[0]
			PutThree(c,three);
			
			if(FindNumOfThree(c)>0)
				c[three[index-1]]-=3;
			
			
	}
			
	//ɾ˳��	,����֤Ϊ��ȷ
	public static void recStraight(int[] c){
			    		   
		 int min = ting0716.FindFirstNotZero(c);                                                 //�������ã���ǣ�
			    
		 if((min!=-1)&&(min<=27)){                    //���±���±�С�ڵ���27
			 if ((c[min+1]>=1)&(c[min+2]>=1)){
				 c[min]-=1;
				 c[min+1]-=1;
			     c[min+2]-=1;
			     recStraight(c);
			 }
		 }
	}
	
	
	//�ݹ麯��
	public static Boolean rec(int[] c,int[] three,int num){     //numΪ���ӵĸ���
		int[] temp=new int[44];
		temp=Arrays.copyOf(c, c.length);
		
		if (num==1){
			recStraight(temp);//ֱ�Ӹ�
			if(ting0716.FindFirstNotZero(temp)==-1)   //-1�Ļ����������                                                                �������ã���ǣ�
				return true;
			//���ֱ�Ӹ�ʧ����
			else{
				//���¸�temp��ֵ
				temp=Arrays.copyOf(c, c.length);
				deleteThree(temp,three,1);     //ȥ����һ��  
				recStraight(temp);              //ȥ˳��
				if(ting0716.FindFirstNotZero(temp)==-1)                                                      //�������ã���ǣ�
					return true;
				else
					return false;
			}
		}
		else {  //num>=2ʱ
			recStraight(temp);//ֱ�Ӹ�
		    if(ting0716.FindFirstNotZero(temp)==-1)   //�����                                                                                �������ã����
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
	
	//��ӡ����
	public static void PrintArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//�����������м�������Ԫ��
}
