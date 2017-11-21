package 听什么;
import java.math.*;

import java.util.*;

public class ting0712 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//获取当前时间
		
		int[] pai={1,1,1,1,2,2,2,2,3,3,3,3,4};        //1 1 1 1 1 1 1 1 3
	    int[] c=new int[10];                     //用1-9     c[1]代表1筒有几个，c[9]代表9筒有几个
	    int[] c_initial=new int[10];        //备份最初的c
	    int[] c_plusi=new int[10];       //备份每次i,进入内循环前的c（已经变14张牌）
	    int[] mj=new int[7];                     //可做麻将的牌放入 mj
	    int[] three=new int[4];                  //放一刻的牌
	    
	    int[] hu=new int[10];          //胡牌时，计数
	    
	    for(int i=0;i<pai.length;i++){     //把牌用个数形式保存
	    	c[pai[i]]++;  
	    }
	    c_initial=Arrays.copyOf(c,c.length);  //c赋值结束后，备份
	   
	    System.out.print("牌为：");
	    PrintArray(pai);
	    System.out.print("用个数表示为：");
	    PrintArray(c);
		
		
		
		for(int i=1;i<=9;i++){                                                                     //第一层循环：遍历每个数，看看是否能胡
			System.out.println("******");
			//每次进入时，拷过来，恢复c
			c=Arrays.copyOf(c_initial,c_initial.length);
			//清空mj
			SetArrayZero(mj);
			
			c[i]++;                              //加上这张牌
			c_plusi=Arrays.copyOf(c,c.length);   //备份加上这个牌后的c
			
			System.out.println("加上这张牌"+i+"后：");
			
			//如果c[i]==5,continue 进入到一下个i（不可能听第五张牌）
			if(c[i]>4)continue;
			
			
			int num_mj;                                //加上i后，查看能做麻将的牌        
			num_mj=FindNumOfTwo(c);
			System.out.println("可做麻将的个数为"+num_mj);
			Putmj(c,mj);//找麻将，存入mj数组
			System.out.print("可做麻将的牌具体为：");
			PrintArray(mj);
			 
			int num_three=0;      //3个或4个的牌
			int num_row=1;       //2的刻子数次方，作为每次操作cc时实际用到的行数。前面故意先定义的行数先多点。
			
			
			
			//进入第二层循环
			for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
				//恢复加过i的c
				c=Arrays.copyOf(c_plusi,c_plusi.length);
				
				
				c[mj[j]]-=2;        //删麻将
				System.out.println("     "+"删了一对"+mj[j]+"后：");
				//麻将删完，看看哪些牌是3个或4个的。	
				
				num_three=FindNumOfThree(c);   //正确
				System.out.println("     "+"一刻的牌的个数为"+num_three);
				//int[] three=new int[num_three];
				PutThree(c,three);
				System.out.print("     "+"有一刻的牌是：");
				PrintArray(three);
			
				num_row=(int)Math.pow(2,num_three);  //之后二维数组的行数
				
				//每次覆盖，长度为num_row
				
				boolean result=rec(c,three,num_three);
				
				if(result==true){
					hu[i]++;
				}
				
												
			}	
			
		}		
		
		
			
		System.out.print("胡的牌为：");
		PrintArrayNotZero(hu);
		
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
	}
			
	//递归函数
		public static Boolean rec(int[] c,int[] three,int num){     //num为刻子的个数
		    int[] temp=new int[10];
		    temp=Arrays.copyOf(c, c.length);
		    if (num==1){
		        
		        recStraight(temp);//直接搞
		        if(FindFirstNotZero(temp)==-1)   //-1的话就是清光了
		            return true;
		        //如果直接搞失败了
		        else{
		        	//重新给temp赋值
		            temp=Arrays.copyOf(c, c.length);
		            deleteThree(temp,three,1);     //去掉第一刻  
		            recStraight(temp);              //去顺子
		            if(FindFirstNotZero(temp)==-1)
		                return true;
		            else
		                return false;
		         	            
		        }
		    }
		  else  {
		        
		        recStraight(temp);//直接搞
		        if(FindFirstNotZero(temp)==-1)   //清光了
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
			
			
			
		//找出第一个非0元素的下标
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //全部为0时，返回-1
		}
			
			
		
		
		//去一次刻子，正确。（要选择哪一个）
		public static void deleteThree(int[] c,int[] three,int index){           //第二个参数代表删第几刻     删第一刻就删three[0]
				PutThree(c,three);
				if(FindNumOfThree(c)>0)
		    		c[three[index-1]]-=3;
		    
		}
		
	   //删顺子	,已验证为正确
		public static void recStraight(int[] c){
		    		   
		    int min = FindFirstNotZero(c);
		    
		    if((min!=-1)&&(min+2<=9)){                    //有下标而下标小于等于7
		        if ((c[min+1]>=1)&(c[min+2]>=1)){
		            c[min]-=1;
		            c[min+1]-=1;
		            c[min+2]-=1;
		            recStraight(c);
		        }
		    }
		}
 
	
	
	//把能做麻将的放入一个数组mj   mj[0]开始
		public static void Putmj(int[] arr,int[] mj){    //对c操作 c下标从1开始
			int j=0;
			for(int i=0;i<arr.length-1;i++){
				if(arr[i+1]>=2){
					mj[j]=i+1;
					j++;
				}
			}
		}
	
	
	//找麻将（找大于等于两个的牌）  先找个数
	public static int FindNumOfTwo(int[] arr){
		int num_two=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=2)
				num_two++;
		}
		return num_two;
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
		
	//找出有3个的个数
	public static int FindNumOfThree(int[] arr){
		int num_three=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=3)
				num_three++;
		}
		return num_three;
	}
		
	//打印数组
	public static void PrintArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//打印数组中的非0元素
	public static void PrintArrayNotZero(int[] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0)
				System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//打印二维数组
	public static void PrintTwoDimArray(int[][] arr){
		for(int[] row:arr){
			for(int element:row){
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}
	
	//数组元素置0
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
