package 听什么;   //碰到刻子递归法
import java.math.*;

import java.util.*;

public class ting0716 extends Pai_base{

	public static void main(String[] args) {
		long startTime1=System.nanoTime();//获取纳秒（当前时间）
					    
		int[] hua={0,0,0,0,0,0,0,0};  //没台
		int quan=1;   //东风圈
		int jia=3;		//西风家
		
		int[] pai_outerchi={};	
		int[] pai_outerpeng={};    //外面明杠用4个，暗杠用5个表示0
		int[] pai_inner={11,11,11,12,13,14,15,16,17,18,19,19,19};        
	    //int[] c=new int[44];                     //     c[1]-c[9]代表万，c[11]-c[19]代表条，c[21]-c[29]代表筒
	                                                //          31东 33南 35西 37北  39中 41发 43白
	      
		int hu_flag;
	    
	  //先算下外面的四数和台数(为骚皮头提供依据）
	    Pai_outer out=new Pai_outer(pai_outerpeng,pai_outerchi,quan,jia,hua);   //初始化已验证正确。创建了外部牌的对象out
	    out.calandshowGang();    //调用对象out中的方法calGang,计算出哪些牌是明杠，哪些牌是暗杠
	    out.cal_out_TaiandSi();
	    out.print_out_TaiandSi();
	    
	    out.Caloutwantiaotongfeng(); //算一下有没有万子，有没有条子，有没有筒子，有没有风枪
	    
	    
	    //构造内部牌的对象(胡牌要看内部）
	    Pai_inner in=new Pai_inner(pai_inner,quan,jia);
	    
	    in.printpai_inner();   //打印内部牌
	    
	    in.findpainenghu();    //寻找内部牌可以胡的牌
	    in.printHu();          //打印能胡的牌
	    
	    //看下是否能胡牌的指标hu_flag
	    hu_flag=in.gethu_flag();
	    
	    
	    //如果hu_flag=0，即不能胡牌，算一下骚皮头
	    if(hu_flag==0){
	    	//调用计算骚皮头的函数，并显示骚皮头为多少
	    	in.cal_in_sao_TaiandSi();
	    	in.print_in_sao_TaiandSi();
	    	System.out.println("骚皮头为"+in.cal_sao_hushu(out,in)+"胡");
	    }
	    
	    //PrintArray(out.get_out_paidistribution());
	    if(hu_flag>0){                                       //能胡的话创建一个新对象（把in和out的有关数据都传进来），计算一下每种情况下的胡数
	    	Hupai_hushu win=new  Hupai_hushu(out,in);
	    	win.Cal_hunqingduiduibonus();
	    	//win.xxx();
	    	win.amazing();
	    }
	    
		
		long endTime1=System.nanoTime();
		System.out.printf("程序运行时间：%.0fμs，约为%.1fms",(endTime1-startTime1)/1000.0,(endTime1-startTime1)/1000000.0);
	
	}
		
	
	
	
	
	
	
	
	
		//找出第一个非0元素的下标
		public static int FindFirstNotZero(int[] arr){
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0)
					return i;
			}
			return -1;      //全部为0时，返回-1
		}
		//找出最后一个非0元素的下标
		public static int FindLastNotZero(int[] arr){
			for(int i=arr.length-1;i>=0;i--){
				if(arr[i]!=0)
					return i;
			}
			return -1;
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
