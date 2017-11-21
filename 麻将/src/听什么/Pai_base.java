package 听什么;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//构造一个父类：外部牌需要，内部牌也需要
public class Pai_base{
	static Map<Integer, String> paiMap; { //声明
		paiMap = new HashMap<Integer, String>();  
	
		paiMap.put(1,"一万");paiMap.put(2,"二万");paiMap.put(3,"三万");paiMap.put(4,"四万");paiMap.put(5,"五万");
		paiMap.put(6,"六万");paiMap.put(7,"七万");paiMap.put(8,"八万");paiMap.put(9,"九万");
	
		paiMap.put(11,"一条");paiMap.put(12,"二条");paiMap.put(13,"三条");paiMap.put(14,"四条");paiMap.put(15,"五条");
		paiMap.put(16,"六条");paiMap.put(17,"七条");paiMap.put(18,"八条");paiMap.put(19,"九条");
	
		paiMap.put(21,"一筒");paiMap.put(22,"二筒");paiMap.put(23,"三筒");paiMap.put(24,"四筒");paiMap.put(25,"五筒");
		paiMap.put(26,"六筒");paiMap.put(27,"七筒");paiMap.put(28,"八筒");paiMap.put(29,"九筒");
	
		paiMap.put(31,"东风");paiMap.put(33,"南风");paiMap.put(35,"西风");paiMap.put(37,"北风");paiMap.put(39,"红中");
		paiMap.put(41,"发财");paiMap.put(43,"白板");
	}
	static Map<Integer, Integer> dnxb2indexMap; {  //东南西北to下标 
		dnxb2indexMap = new HashMap<Integer, Integer>();
			dnxb2indexMap.put(1,31);dnxb2indexMap.put(2,33);dnxb2indexMap.put(3,35);dnxb2indexMap.put(4,37);
	}
	static Map<Integer, Integer> huaindexMap; {  //花的下标对应东南西北
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
	
	//把能做麻将的放入一个数组mj   mj[0]开始
	static void Putmj(int[] arr,int[] mj){    //对c操作 c下标从1开始
		int j=0;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i+1]>=2){
				mj[j]=i+1;
				j++;
			}
		}
	}	

	//找出有3个的个数
	public static int FindNumOfThree(int[] arr){
		int num_three=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=3)
				num_three++;
		}
		return num_three;
	}
	//把一刻的筒子放入一个数组three
	public static void PutThree(int[] c,int[] three){    //对c操作 c下标从1开始
		int j=0;
		for(int i=0;i<c.length-1;i++){
			if(c[i+1]>=3){
				three[j]=i+1;
				j++;
			}
		}
	}

	//去一次刻子，正确。（要选择哪一个）
	public static void deleteThree(int[] c,int[] three,int index){           //第二个参数代表删第几刻     删第一刻就删three[0]
			PutThree(c,three);
			
			if(FindNumOfThree(c)>0)
				c[three[index-1]]-=3;
			
			
	}
			
	//删顺子	,已验证为正确
	public static void recStraight(int[] c){
			    		   
		 int min = ting0716.FindFirstNotZero(c);                                                 //类名调用（标记）
			    
		 if((min!=-1)&&(min<=27)){                    //有下标而下标小于等于27
			 if ((c[min+1]>=1)&(c[min+2]>=1)){
				 c[min]-=1;
				 c[min+1]-=1;
			     c[min+2]-=1;
			     recStraight(c);
			 }
		 }
	}
	
	
	//递归函数
	public static Boolean rec(int[] c,int[] three,int num){     //num为刻子的个数
		int[] temp=new int[44];
		temp=Arrays.copyOf(c, c.length);
		
		if (num==1){
			recStraight(temp);//直接搞
			if(ting0716.FindFirstNotZero(temp)==-1)   //-1的话就是清光了                                                                类名调用（标记）
				return true;
			//如果直接搞失败了
			else{
				//重新给temp赋值
				temp=Arrays.copyOf(c, c.length);
				deleteThree(temp,three,1);     //去掉第一刻  
				recStraight(temp);              //去顺子
				if(ting0716.FindFirstNotZero(temp)==-1)                                                      //类名调用（标记）
					return true;
				else
					return false;
			}
		}
		else {  //num>=2时
			recStraight(temp);//直接搞
		    if(ting0716.FindFirstNotZero(temp)==-1)   //清光了                                                                                类名调用，标记
		    	return true;
		    //如果直接搞失败了
		    else{
		    	temp=Arrays.copyOf(c, c.length);   //重新给temp赋值  
		    	for(int i=0;i<num;i++){
		    		temp=Arrays.copyOf(c, c.length); 
		    		deleteThree(temp,three,i+1);
		    		if(rec(temp,three,num-1))     //比如num=2，  如果到这步后 ，直接放心地交给  一刻的递归  如果成功返回true继续运行
		    			return true;
		    	}
			}
		}
		return false;
	}	
	
	//打印数组
	public static void PrintArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//返回数组中有几个非零元素
}
