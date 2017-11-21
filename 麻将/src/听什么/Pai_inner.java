package 听什么;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Pai_inner extends Pai_base {
	static Map<Integer,Double> in19num2siMap;{  //19大妖和东南西北中发白的个数对应胡数
		in19num2siMap=new HashMap<Integer,Double>();
		in19num2siMap.put(2,0.5);in19num2siMap.put(3,2.0);in19num2siMap.put(4,2.0);
	}
	static Map<Integer,Double> innot19num2siMap;{  //19大妖和东南西北中发白的个数对应胡数
		innot19num2siMap=new HashMap<Integer,Double>();
		innot19num2siMap.put(3,1.0);innot19num2siMap.put(4,1.0);
	}
	
	int[] c_inner=new int[44];   //里面的牌用个数表示
	int[] c_innerbackup=new int[44];    //备份，循环时用于恢复数据
	
	int[] c_innerplusi=new int[44];   //加上这张牌的c
	int[] mj=new int[7];
	int[] three=new int[4];
	private int[] hu=new int[44];          //胡牌时，计数
	int hu_flag=0;
	
	private double insi=0;
	private int intai=0;
	
	int quan;       //东南西北圈
	int jia;          //东南西北家
	double in_si;
	int in_tai;
	
	private int num_inwan=0;
	private int num_intiao=0;
	private int num_intong=0;
	private int num_infeng=0;     //为混一色、清一色提供依据
	
	//构造器
	Pai_inner(int[] pai_inner,int quan,int jia){
		for(int i=0;i<pai_inner.length;i++)
			c_inner[pai_inner[i]]++;
		c_innerbackup=Arrays.copyOf(c_inner,c_inner.length);   //备份，便于外循环进入时恢复数据
		this.quan=quan;
		this.jia=jia;
	}
	
	//找到胡的牌，存入hu数组
	public void findpainenghu(){
		c_innerbackup=Arrays.copyOf(c_inner,c_inner.length); 
		for(int i=1;i<=43;i++){                                                                     //第一层循环：遍历每个数，看看是否能胡
			if(i%10==0||(i>30&&i%2==0))continue;   //10,20,30,32,34,36,38,40,42时直接跳过，因为不听
					
			
			//每次进入时，拷过来，恢复c
			c_inner=Arrays.copyOf(c_innerbackup,c_innerbackup.length);
			//ting0716.PrintArray(c_inner);
			ting0716.SetArrayZero(mj);//每次进入时把mj元素都置0                                           //类名调用 （标记）
			
			c_inner[i]++;                              //加上这张牌
			c_innerplusi=Arrays.copyOf(c_inner,c_inner.length);   //备份加上这个牌后的c
			
			if((i<43&&c_inner[i]<=1)){
				if(c_inner[i-1]==0&&c_inner[i+1]==0)    //根c有关，所以这句必须放在c恢复之后
					continue;          //加快遍历
			}
			//如果c[i]==5,continue 进入到一下个i（不可能听第五张牌）
			if(c_inner[i]>4)continue;
			
			
			int num_mj;                                //加上i后，查看能做麻将的牌        
			num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记） 	
			Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
						 
			int num_three=0;      //3个或4个的牌
					
			//进入第二层循环
			for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
				//恢复加过i的c
				c_inner=Arrays.copyOf(c_innerplusi,c_innerplusi.length);
				//把three清零
				ting0716.SetArrayZero(three);                                             //类名调用 （标记） 	                                       
				c_inner[mj[j]]-=2;        //删麻将
							
				
				num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
				PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
				
				boolean result=rec(c_inner,three,num_three);                                          //继承调用 （标记）
				if(result==true){
					hu[i]++;
					hu_flag++;
				}
				
												
			}	
			
		}
		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
	}
	//打印内部一开始的牌
	public void printpai_inner(){
		System.out.print("里面的牌为：");
		for(int i=0;i<c_innerbackup.length;i++){
			while(c_innerbackup[i]>0){
				System.out.print(paiMap.get(i)+" ");
				c_innerbackup[i]--;
			}
		}
		System.out.println();
	}
	//打印胡的牌
	public void printHu(){
			if(hu_flag==0)System.out.println("抱歉，无牌可胡");
			else{
				System.out.print("可以胡：");
				for(int i=0;i<hu.length;i++){
					if(hu[i]>0){
						System.out.print(paiMap.get(i)+" ");
					}
				}
				System.out.println();
		
			}
	}
	//给外部提供获取hu_flag的方法，调用这个方法时必须在findpainenghu()后
	public int gethu_flag(){
		return hu_flag;
	}
	
	public void cal_in_sao_TaiandSi(){       //必须拿原始数据c_innerbackup来算
		//先把所有牌的四数加上 ,加上中发白的台数 
		for(int i=1;i<=43;i++){
			if((i%10==0)||(i>30&&i%2==0))continue;
				if(c_innerbackup[i]>=3){
					if(i%10==1||i%10==9||i>30)
						in_si=in_si+in19num2siMap.get(c_innerbackup[i]);
					else
						in_si=in_si+innot19num2siMap.get(c_innerbackup[i]);
					if(i>=39)in_tai++;
				}
		}
		//如果是大于等于3个，把东南西北的台数加上（结合圈风quan，门风jia），如果只有2个，加半四
		for(int i=31;i<=37;i++){
			if(c_innerbackup[i]>=3){
				if(i==dnxb2indexMap.get(quan))                                         //继承调用
					in_tai++;
				if(i==dnxb2indexMap.get(jia))                                       //继承调用
					in_tai++;
			}
			else if(c_innerbackup[i]==2){
				if(i==dnxb2indexMap.get(quan)||i==dnxb2indexMap.get(jia))
					in_si=in_si+in19num2siMap.get(c_innerbackup[i]);          //是圈风或者门风都加半四
				
			}
		}
		//中发白如果是2个，加半四
		for(int i=39;i<=43;i=i+2){
			if(c_innerbackup[i]==2)
				in_si+=0.5;
		}
	}
	
	public void print_in_sao_TaiandSi(){ //调用这个方法前，一定要先调用cal_out_sao_TaiandSi()
		
		System.out.println("里面台数="+in_tai+",里面四数="+in_si);
	}
	
	
	public int cal_sao_hushu(Pai_outer out,Pai_inner in){
		double si=in.get_in_sao_si()+out.get_out_si();
		int tai=in.get_in_sao_tai()+out.get_out_tai();
		int hushu=(int)(4*si*Math.pow(2.0,(double)(tai)));
		
		return hushu;
		//return hushu%10==0?hushu:(hushu+10)/10*10;
	}
	
	
	//获取里面的牌万，条，筒，风的情况，没有为0，有为1
	public void Calinwantiaotongfeng(){
		for(int i=1;i<=9;i++){
			if(c_innerbackup[i]>0){     //用备份过的数据来算，确保无误
				num_inwan++;
				break;
			}
		}
		for(int i=11;i<=19;i++){
			if(c_innerbackup[i]>0){
				num_intiao++;
				break;
			}
		}
		for(int i=21;i<=29;i++){
			if(c_innerbackup[i]>0){
				num_intong++;
				break;
			}
		}
		for(int i=31;i<=43;i=i+2){
			if(c_innerbackup[i]>0){
				num_infeng++;
				break;
			}
		}
	}
	
	
	//获取里面的牌万条筒风的情况
	public int[] get_in_paidistribution(){
		Calinwantiaotongfeng();   //先算一下万条筒风
		int[] temp=new int[4];
		if(num_inwan>0)temp[0]=1;
		if(num_intiao>0)temp[1]=1;
		if(num_intong>0)temp[2]=1;
		if(num_infeng>0)temp[3]=1;
		return temp;
	}
	
	
	public int[] getc_inner(){
		return c_innerbackup;
	}
	//得到内部牌种类的确切数目,(用innerbackup算)
	public int getin_exactnum(){
		int num=0;
		for(int i=1;i<c_innerbackup.length;i++){
			if(c_innerbackup[i]>0)
				num++;
		}
		return num;
	}
	
	
	
	
	public double get_in_sao_si(){
		return in_si;
	}
	public int get_in_sao_tai(){
		return in_tai;
	}
	public int[] gethu(){
		return hu;
	}
	public int getquan(){
		return quan;
	}
	public int getjia(){
		return jia;
	}
	
	//看一下内部牌的4个一样的情况
	public int get_fourflag(){
		for(int i=1;i<44;i++){
			if(c_innerbackup[i]==4)
				return 1; 
		}
		return 0;
	}
	
	//比如胡牌要算胡数了，会改变c_inner，弄个函数用来恢复最初的c_inner
	public void recover_c_inner(){
		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
	}
	
	public int get_num_painenghu(){
		int num=0;
		for(int i=1;i<44;i++){
			if(hu[i]>0)
				num++;
				
		}
		return num;
	}
	
}
