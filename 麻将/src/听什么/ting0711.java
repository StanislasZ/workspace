package 听什么;      //碰到刻子穷举法
import java.math.*;

import java.util.*;

public class ting0711 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();//获取当前时间
		long startTime1=System.nanoTime();//获取纳秒
		int[] pai={5,5,5,5,6,6,6};
	    int[] c=new int[10];                     //用1-9     c[1]代表1筒有几个，c[9]代表9筒有几个
	    int[] c_initial=new int[10];        //备份最初的c
	    int[] c_plusi=new int[10];       //备份每次i,进入内循环前的c（已经变14张牌）
	    int[] mj=new int[7];                     //可做麻将的牌放入 mj
	    int[] three=new int[4];                  //放一刻的牌
	    int[][] cc=new int[16][10];    //碰到一刻时，穷举法
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
				for(int t=0;t<num_row;t++)
 					cc[t]=Arrays.copyOf(c, c.length);  //每一行都是加上听的牌，去掉麻将后的c
				//PrintTwoDimArray(cc);
				//以上都正确
				
				OperationOfKe(cc,three,num_three);     //对刻子进行操作，每个刻子有两种选择，共2^num_three个选择
				
				for(int k=0;k<num_row;k++){
					for(int t=0;t<4;t++){
						int index=FindFirstNotZero(cc[k]);   //index为这一行中第一个非0的下标,找不到时返回-1
						if(index==8||index==9)break;     //，最小是8或9，肯定组不成顺子，直接进入下个k
						if(cc[k][index+1]!=0&&cc[k][index+2]!=0){
							cc[k][index]--;
							cc[k][index+1]--;
							cc[k][index+2]--;
						}
						if(index==-1){
							hu[i]++;
							break;   //这个能胡，直接跳出 进入下个k
						}
						
					}
				}
												
				System.out.println("     ******");
				//PrintTwoDimArray(cc);
								
			}			
		}		
		
		
			
		System.out.print("胡的牌为：");
		PrintArrayNotZero(hu);
		
		
		long endTime = System.currentTimeMillis();
		long endTime1=System.nanoTime();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
		System.out.println("程序运行时间："+(endTime1-startTime1)/1000.0+"μs");
	}
			
			
			
			
			
		//找出cc[i]这一行第一个非0元素的下标
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //全部为0时，返回-1
		}
			
			
		
		
		//有一刻的牌要么作为3个删掉，要么不删。由此对cc进行操作
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
			else if(num_three==4){                 //最多4刻
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

	
	
	//把能做麻将的放入一个数组mj
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
