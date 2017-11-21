package 听什么;

import java.util.Arrays;

class Hupai_hushu extends Pai_base{
	int final_tai;          //tai_final=out_tai+tai_bonus+台内部(in_tai)
	double final_si;
	int bonus_tai;   //有混一色（ok），清一色（ok），对对胡，******** 单吊，欠党，排胡，自摸，刚开
	double bonus_si;    //自摸有半四
	int out_tai;
	double out_si;
	int in_tai;
	double in_si;
	int[] out_paidistribution=new int[4];							//对象建立就有值
	int[] in_paidistribution=new int[4];						    //对象建立就有值
	int[] hu;                									    //对象建立就有值
	int num_hu; //能胡几个牌
	int hushu;
	int[] c_inner=new int[44];                                       //对象建立就有值
	
	int out_chi_flag;                                              //对象建立就有值
	int out_peng_exactnum;                                         //对象建立就有值
	int in_exactnum;												//对象建立就有值
	int in_fourflag;
	int quan;
	int jia;
	int[] test=new int[4];
	
	int[] c_forsishu=Arrays.copyOf(c_inner,c_inner.length); //专门给算四数一个数组，要去掉麻将，顺子
	//构造器
	Hupai_hushu(Pai_outer out,Pai_inner in){   //初始化后，里面，外面的牌分布直接传进
		//外部的牌的数据都传进来
		this.out_si=out.get_out_si();
		this.out_tai=out.get_out_tai();
		this.out_paidistribution=Arrays.copyOf(out.get_out_paidistribution(),out.get_out_paidistribution().length);
		this.out_chi_flag=out.getout_chi_species();
		this.out_peng_exactnum=out.getout_peng_exactnum();
		//里面的牌跟组合有关，胡数不能乱算
		this.in_paidistribution=Arrays.copyOf(in.get_in_paidistribution(), in.get_in_paidistribution().length);
		this.c_inner=Arrays.copyOf(in.getc_inner(),in.getc_inner().length);
		this.in_exactnum=in.getin_exactnum();
		this.hu=in.gethu();
		this.quan=in.getquan();
		this.jia=in.getjia();
		this.in_fourflag=in.get_fourflag();
		this.num_hu=in.get_num_painenghu();
	}
	
	//构造器之后，定义一个内部类，让每个能胡的牌都创建一个新的内部类的对象
//=================================================================================================
	class Hupai_every_detail{
		int[] c_innerbackup=Arrays.copyOf(c_inner,c_inner.length);
		int pai;  //哪个牌胡，（编号），2万就是2,2条就是12
		double si_duiduihu;		double si_paihu;		double si_dandiao;		double si_qiandang;		double si_duidao;		double si_liangtoubushipaihu;
		int tai_dandiao;
		double hushu_dandiao;
		
		int dandiao_flag;	int qiandang_flag;	int bianzhang_flag; int pureduiduihu_flag;	int duidiao_flag;	int paihu_flag;//包括正宗排胡和假冒排胡
		int liangtou_flag;
		
		int[] three=new int[4];	int[] mj=new int[7];
		
		int[] forsishu=new int[44];
		int[] forsishu_backup=new int[44];
		
		int finish_flag;
		
		
		
		//定义内部类的构造器
		Hupai_every_detail(int pai){
			this.pai=pai;
		}
		
		
		
		//纯对对胡（没有单吊）
		void pureduiduihu(){
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;
			if(in_exactnum+out_peng_exactnum==5&&out_chi_flag==0&&in_fourflag==0){  //5种，没吃，没4个 是前提
				
				c_inner[pai]++;
				if(c_inner[pai]==3){
					System.out.print("是对对胡(没有单吊)");
					pureduiduihu_flag=1;
					in_tai+=2;
					forsishu=Arrays.copyOf(c_inner, c_inner.length);
					
					cal_in_TaiandSi(); //计算内部四数和台数
					duidao_amend();//自摸时去掉这句
					hushu=cal_hu_hushu();
					System.out.println("，	胡数为："+hushu+"胡"+"\n");
/*标识一下*/			finish_flag=1; 
				}
				
			}
			
		}
		
		
		//单吊
		void dandiao(){
			c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;
			//PrintArray(c_inner);
			c_inner[pai]--;//加上这个牌，去麻将，即减一个
			int num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
			PutThree(c_inner,three);    //删完麻将找刻子 ，（结束后清空，别忘了）                                                                        //继承调用 （标记）
			
			boolean result=recforhushu(c_inner,three,num_three);                                          //继承调用 （标记）
			if(result==true){
				dandiao_flag=1;  //标记一下
				in_tai++; //单吊1台
				in_si+=0.5;  //单吊半四
				
				if(in_exactnum+out_peng_exactnum==5&&out_chi_flag==0&&in_fourflag==0){   //说明是对对胡加单吊
					System.out.print("是对对胡单吊，");
					in_tai+=2;//加对对胡2台
					
					c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
					c_inner[pai]++;
					//forsishu=Arrays.copyOf(c_inner, c_inner.length);
					//System.out.print("用来计算四数的数组为：");
					//PrintArray(forsishu);
					cal_in_TaiandSi(); //计算内部四数和台数
					hushu=cal_hu_hushu();
					System.out.println("胡数为："+hushu+"胡"+"\n");
/*标识一下*/			finish_flag=1; 
				}
				else  { //不是对对胡的单吊情况
					//此时c_inner是去了麻将的
					//PrintArray(c_inner);
					System.out.print("非对对胡");
					
					forsishu=Arrays.copyOf(c_inner,c_inner.length);
					//System.out.println("\n之前：");
					//PrintArray(forsishu);
					
					
					forsishu_backup=Arrays.copyOf(forsishu, forsishu.length);
					
					boolean cccc=recforhushu(c_inner,three,num_three,forsishu_backup);  //当做void函数来用  
					//System.out.println("cccc="+cccc);
					//PrintArray(forsishu);
					forsishu[pai]+=2;
					//PrintArray(forsishu);
					cal_in_TaiandSi(); //计算内部四数和台数	
					hushu=cal_hu_hushu();
					System.out.println("单吊，   胡数为："+hushu+"胡"+"\n");
/*标识一下*/			finish_flag=1; 
									
				}

			}
			
		}
		//砍张
		void qiandang(){
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;
			if(pai<30&&pai%10>1&&pai%10<9&&c_inner[pai-1]>=1&&c_inner[pai+1]>=1){    //2-8,12-18,22-28,且前一张有，后一张有，才符合条件
				c_inner[pai-1]-=1;	c_inner[pai+1]-=1;
				//去掉砍张两边的牌后保存下
				int[] c_innerdelete_qian=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //加上i后，查看能做麻将的牌        
				num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记）
				ting0716.SetArrayZero(mj);  //先清空
				Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
				int num_three=0;      //3个或4个的牌
				
				for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
					//恢复去掉两边牌的c
					c_inner=Arrays.copyOf(c_innerdelete_qian,c_innerdelete_qian.length);
					//把three清零
					ting0716.SetArrayZero(three);                                             //类名调用 （标记） 	                                       
					c_inner[mj[j]]-=2;        //删麻将
									
					num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
					PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
					
					//删完两边，删完麻将，就是用来rec的牌了，这里备份一下
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //继承调用 （标记）
					if(result==true){
						in_si+=0.5;
						in_tai+=1;
						qiandang_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //再把麻将加回来
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //计算内部四数和台数	
						hushu=cal_hu_hushu();
						System.out.println("坎张，胡数为："+hushu+"胡"+"\n");
/*标识一下*/			    finish_flag=1; 
						break;
					}
				}	
			}
		}
		//边张
		void bianzhang(){   
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;	
	
			if (pai<30&&((pai%10==3&&c_inner[pai-2]>=1&&c_inner[pai-1]>=1)||(pai%10==7&&c_inner[pai+1]>=1&&c_inner[pai+2]>=1)) ){
				if(pai%10==3){
					c_inner[pai-2]-=1;	c_inner[pai-1]-=1;
				}
				else if(pai%10==7){
					c_inner[pai+1]-=1;	c_inner[pai+2]-=1;
				}
				//去掉边张旁边两边的牌后保存下
				int[] c_innerdelete_bian=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //加上i后，查看能做麻将的牌        
				num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记）
				ting0716.SetArrayZero(mj);  //先清空
				Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
				int num_three=0;      //3个或4个的牌
				
				for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
					//恢复去掉两边牌的c
					c_inner=Arrays.copyOf(c_innerdelete_bian,c_innerdelete_bian.length);
					//把three清零
					                                             //类名调用 （标记） 	                                       
					c_inner[mj[j]]-=2;        //删麻将
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
					PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
					
					//删完12或89，删完麻将，就是用来rec的牌了，这里备份一下
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //继承调用 （标记）
					if(result==true){
						in_si+=0.5;
						in_tai+=1;
						bianzhang_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //再把麻将加回来
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //计算内部四数和台数	
						hushu=cal_hu_hushu();
						System.out.println("边张，                 胡数为："+hushu+"胡"+"\n");
/*标识一下*/			    finish_flag=1;
						break;
					}
				}	
			}
		}
		//排胡
		void paihu(){     //把对麻将的判断放里面
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;			
			
			if(pai<30){
				c_inner[pai]++;
				//加上牌后保存下
				int[] c_innerplus_paihu=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //加上i后，查看能做麻将的牌        
				num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记）
				ting0716.SetArrayZero(mj);  //先清空
				Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
				int num_three=0;      //3个或4个的牌
				
				for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
					//恢复去掉两边牌的c
					c_inner=Arrays.copyOf(c_innerplus_paihu,c_innerplus_paihu.length);
					//把three清零
					                                             //类名调用 （标记） 	                                       
					c_inner[mj[j]]-=2;        //删麻将
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
					PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
					
					//加上这张牌，删完麻将，就是用来rec的牌了，这里备份一下
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					int[] temp=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
					ting0716.recStraight(temp); 
					if(ting0716.FindFirstNotZero(temp)==-1){  //删光了
						paihu_flag=1;
						if(mj[j]>=39||Pai_base.dnxb2indexMap.get(quan)==mj[j]||Pai_base.dnxb2indexMap.get(jia)==mj[j]){
							System.out.print("假冒排胡，");
							in_si+=0.5;
						}
						else{
							System.out.print("正宗排胡，");
							in_tai++;
						}
						hushu=cal_hu_hushu();
						System.out.println("胡数为："+hushu+"胡"+"\n");
/*标识一下*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		//对倒  （四数当自摸，台数当打倒）
		void duidiao(){
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;	
			
			if(pai<30){
				c_inner[pai]-=2;  
				//去掉2张这个牌后保存下
				int[] c_innerdelete_duidao=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //查看能做麻将的牌        
				num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记）
				ting0716.SetArrayZero(mj);  //先清空
				Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
				int num_three=0;      //3个或4个的牌
				
				for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
					//恢复去掉两张这个牌的c
					c_inner=Arrays.copyOf(c_innerdelete_duidao,c_innerdelete_duidao.length);
					//把three清零
					                                             //类名调用 （标记） 	                                       
					c_inner[mj[j]]-=2;        //删麻将
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
					PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
					
					//删完2个这个牌，删完麻将，就是用来rec的牌了，这里备份一下
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //继承调用 （标记）
					if(result==true){
						paihu_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //再把麻将加回来
						forsishu[pai]+=3;     //听的牌加回来
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //计算内部四数和台数
						
						duidao_amend();    //自摸时把这步去掉
						
						hushu=cal_hu_hushu();
						System.out.println("对倒，                 胡数为："+hushu+"胡"+"\n");
/*标识一下*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		//对倒,纯对对胡时时需要减
		void duidao_amend(){
			if(pai%10==1||pai%10==9||pai>30){
				in_si-=1.0;
			}
			else{
				in_si-=0.5;
			}
		}
		//两头（有刻子）
		void liangtou(){
/*必须*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*必须*/		in_si=0;in_tai=0;	
			
			if(pai<30){
				c_inner[pai]++;
				//加上这个牌后保存下
				int[] c_innerplus_liangtou=Arrays.copyOf(c_inner, c_inner.length);
				
				int num_mj;                                //查看能做麻将的牌        
				num_mj=FindNumOfTwo(c_inner);		                                                 //继承调用 （标记）
				ting0716.SetArrayZero(mj);  //先清空
				Putmj(c_inner,mj);//找麻将，存入mj数组                                                                                     //继承调用 （标记）
				int num_three=0;      //3个或4个的牌
				
				for(int j=0;j<num_mj;j++){                                                   //第二层循环：从小到大删麻将             j从0到num_mj-1                    
					//恢复加上这个牌的c
					c_inner=Arrays.copyOf(c_innerplus_liangtou,c_innerplus_liangtou.length);
					//把three清零
					                                             //类名调用 （标记） 	                                       
					c_inner[mj[j]]-=2;        //删麻将
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //继承调用 （标记）
					PutThree(c_inner,three);    //删完麻将找刻子                                                                         //继承调用 （标记）
					
					//删完2个这个牌，删完麻将，就是用来rec的牌了，这里备份一下
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //继承调用 （标记）
					if(result==true){
						paihu_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //再把麻将加回来
						
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //计算内部四数和台数
						
						hushu=cal_hu_hushu();
						System.out.println("不是排胡的两头，胡数为："+hushu+"胡"+"\n");
/*标识一下*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		
		
		
		
		
		//把rec拷过来，加入一些标记，重新弄个函数,这个直接给单吊的情况使用，因为单吊去的麻将就是听的那个牌
		public Boolean recforhushu(int[] c,int[] three,int num){     //num为刻子的个数
			int[] temp=new int[44];
			temp=Arrays.copyOf(c, c.length);
			
			if (num==1){
				Pai_base.recStraight(temp);//直接搞
				if(ting0716.FindFirstNotZero(temp)==-1)   //-1的话就是清光了                                                                类名调用（标记）
					return true;
				//如果直接搞失败了
				else{
					//重新给temp赋值
					temp=Arrays.copyOf(c, c.length);
					deleteThree(temp,three,1);     //去掉第一刻  
					Pai_base.recStraight(temp);              //去顺子
					if(ting0716.FindFirstNotZero(temp)==-1)                                                      //类名调用（标记）
						return true;
					else
						return false;
				}
			}
			else {  //num>=2时
				Pai_base.recStraight(temp);//直接搞
			    if(ting0716.FindFirstNotZero(temp)==-1)   //清光了                                                                                类名调用，标记
			    	return true;
			    //如果直接搞失败了
			    else{
			    	temp=Arrays.copyOf(c, c.length);   //重新给temp赋值  
			    	for(int i=1;i<num;i++){
			    		temp=Arrays.copyOf(c, c.length); 
			    		deleteThree(temp,three,i+1);

			    		if(recforhushu(temp,three,num-1))     //比如num=2，  如果到这步后 ，直接放心地交给  一刻的递归  如果成功返回true继续运行
			    			
			    			return true;
			    	}
				}
			}
			return false;
		}
		
		
		//overload rec
		public Boolean recforhushu(int[] c,int[] three,int num,int[] forsishu_backup){     //num为刻子的个数
			
			int[] temp=new int[44];
			temp=Arrays.copyOf(c, c.length);
			int[] temp1=new int[44];
			temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
			
			
			if (num==1){
				
				deleteThree(temp,three,1);     //去掉第一刻  
				//System.out.println("去掉一刻后temp为");
				//PrintArray(temp);
				recStraight(temp,temp1);              //去顺子
				
				//System.out.println("去掉顺子后temp1为");
				//PrintArray(temp1);
				
				if(ting0716.FindFirstNotZero(temp)==-1){   //-1的话就是清光了                                                                类名调用（标记）
					forsishu=Arrays.copyOf(temp1, temp1.length);
					//System.out.println("xxxxxxxx1xx");
					//PrintArray(forsishu);
					
					return true;
				}
				//如果直接搞失败了
				else{
					//System.out.println("进入else");
					//重新给temp赋值
					temp=Arrays.copyOf(c, c.length);
					//重新给c_forsishu赋值
					temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
					
					//System.out.print("temp为");
					//PrintArray(temp);
					//System.out.print("temp1为");
					//PrintArray(temp1);
					
					recStraight(temp,temp1);//直接搞
					
					//System.out.print("去顺之后，temp为");
					//PrintArray(temp);
					//System.out.print("去顺之后，temp1为");
					//PrintArray(temp1);
					
					
					if(ting0716.FindFirstNotZero(temp)==-1){                                                      //类名调用（标记）
						forsishu=Arrays.copyOf(temp1, temp1.length);
						//System.out.println("xxxxxx");
						//PrintArray(forsishu);
						return true;
					}
					else
						return false;
				}
			}
			else {  //num>=2时
				for(int i=0;i<num;i++){
					//System.out.println("第"+(i+1)+"次：");
					//最初的一次肯定要先恢复数据
					temp=Arrays.copyOf(c, c.length);   //重新给temp赋值  
			    	temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);  //重新给temp1赋值
			    	//System.out.println("temp1为");
			    	//PrintArray(temp1);
					deleteThree(temp,three,i+1);
					
					//System.out.println("删了第"+(i+1)+"刻后");
					//PrintArray(temp);
					
		    		if(recforhushu(temp,three,num-1,temp1)) {    //比如num=2，  如果到这步后 ，直接放心地交给  一刻的递归  如果成功返回true继续运行
		    			
		    			//forsishu=Arrays.copyOf(temp1, temp1.length);   //这句没用，而且错误，因为递归到num=1，已经把temp1给forsishu了
		    			//System.out.println("xxx");
		    			//PrintArray(temp1);
		    			return true;
					}
				}
				
				temp=Arrays.copyOf(c, c.length);   //重新给temp赋值  
		    	temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);  //重新给temp1赋值
		    	
				recStraight(temp,temp1);//直接搞
			    if(ting0716.FindFirstNotZero(temp)==-1){   //清光了                                                                                类名调用，标记
			    	forsishu=Arrays.copyOf(temp1, temp1.length);
			    	//System.out.println("xxxxxx");
			    	return true;
			    }
			   
			    
			}
			return false;
		}
		
		//删顺子(为了算四数时去掉顺子，特意写这个函数)
				public void recStraight(int[] c,int[] c_forsishu){
					   
					 int min = ting0716.FindFirstNotZero(c);                                                 //类名调用（标记）
						    
					 if((min!=-1)&&(min<=27)){                    //有下标而下标小于等于27
						 if ((c[min+1]>=1)&(c[min+2]>=1)){
							 c[min]-=1;    c[min+1]-=1;    c[min+2]-=1;
						     c_forsishu[min]-=1;	c_forsishu[min+1]-=1;	c_forsishu[min+2]-=1;  //这行是增加的
						     
						     recStraight(c,c_forsishu);
						 }
					 }
				}
		
				public void cal_in_TaiandSi(){       //必须拿原始数据c_innerbackup来算
					//先把所有牌的四数加上 ,加上中发白的台数 
					//System.out.println("算之前，insi为"+in_si);
					for(int i=1;i<=43;i++){
						if((i%10==0)||(i>30&&i%2==0))continue;
							if(forsishu[i]>=3){
								if(i%10==1||i%10==9||i>30){
									in_si=in_si+Pai_inner.in19num2siMap.get(forsishu[i]);       											//类名调用
									//double abc=Pai_inner.in19num2siMap.get(forsishu[i]);
									//System.out.println(abc);
								}
								else
									in_si=in_si+Pai_inner.innot19num2siMap.get(forsishu[i]);									    //类名调用
								if(i>=39)in_tai++;
							}
							
					}
					//如果是大于等于3个，把东南西北的台数加上（结合圈风quan，门风jia），如果只有2个，加半四
					for(int i=31;i<=37;i++){
						if(forsishu[i]>=3){
							if(i==dnxb2indexMap.get(quan))                                         //继承调用
								in_tai++;
							if(i==dnxb2indexMap.get(jia))                                       //继承调用
								in_tai++;
						}
						else if(forsishu[i]==2){
							if(i==dnxb2indexMap.get(quan)||i==dnxb2indexMap.get(jia))
								//in_si+=Pai_inner.in19num2siMap.get(c_forsishu[i]);          //是圈风或者门风都加半四                 类名调用
								in_si+=0.5;
//							double abc=Pai_inner.in19num2siMap.get(forsishu[i]);
//							System.out.println(abc);
							
						}
					}
					//红发白如果是2个，加上半四
					for(int i=39;i<=43;i=i+2){
						if(forsishu[i]==2)
							in_si+=0.5;
					}
					
					//System.out.println("算之后，insi为"+in_si);
				}
				
				
				public int cal_hu_hushu(){
					final_si=in_si+out_si+bonus_si;
					final_tai=out_tai+in_tai+bonus_tai;
					int hushu=(int)((4*final_si+30.0)*Math.pow(2.0,(double)(final_tai)));
					
					return hushu;
					//return hushu>=500?500:(hushu%50==0?hushu:(hushu+50)/50*50);
				}
				
	
	}
//=================================================================================================	
	
	public void Cal_hunqingduiduibonus(){    //计算混一色,清一色的附加台数,归入tai_bonus，调用这个方法后，tai_bonus自动算完了清一色和混一色的加成
		int normal_flag;
		int feng_flag;
		int[] both=new int[4];
		for(int i=0;i<4;i++){
			if(out_paidistribution[i]>0||in_paidistribution[i]>0)
			both[i]=1;   //加起来了。清楚
		}
		//PrintArray(both);
		normal_flag=both[0]+both[1]+both[2];    //加了之后，如果只有万，等于1，有万筒，等于2，…………
		feng_flag=both[3];
		//System.out.println("normal_flag="+normal_flag+",feng_flag="+feng_flag);
		
		if(normal_flag==0&&feng_flag==1)      //风一色
			this.bonus_tai+=4;
		else if(normal_flag==1&&feng_flag==0)    //万一色,条一色，筒一色
			this.bonus_tai+=4;
		else if(normal_flag==1&&feng_flag==1)    //混一色
			this.bonus_tai+=2;
	
	}
	
	public void xxx(){          //调试用
		System.out.println("tai_bonus="+bonus_tai);
		if(out_chi_flag>0)
			System.out.println("外面吃过");
		else
			System.out.println("外面没吃过");
		if(out_peng_exactnum>0)
			System.out.println("外面碰了"+out_peng_exactnum+"种");
		else
			System.out.println("外面没碰过");
	}
	
	public void amazing(){
		Hupai_every_detail[] analysis=new Hupai_every_detail[num_hu];//建立一个数组，每个元素都是Hupai_every_detail类型
		int t=0;
		//PrintArray(hu);
		for(int i=1;i<44;i++){
			if(hu[i]>0){
				analysis[t++]=new Hupai_every_detail(i);   //建立对象，  analysis[0]就是根据编号最小的能胡的牌所建立的对象，分析它胡牌的胡数
			}
		}
		for(int i=0;i<num_hu;i++){
			System.out.print("对于牌   "+paiMap.get(analysis[i].pai)+"：");
//			analysis[i].dandiao();   //试一下单吊
//			if(analysis[i].dandiao_flag!=1) //不是单吊，试一下纯对对胡
//				analysis[i].pureduiduihu();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1)   //不是单吊，不是纯对对胡，试一下砍张
//				analysis[i].qiandang();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1)
//				analysis[i].bianzhang();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1&&analysis[i].bianzhang_flag!=1)
//				analysis[i].paihu();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1&&analysis[i].bianzhang_flag!=1&&analysis[i].paihu_flag!=1)
//				analysis[i].duidiao();
			
			analysis[i].dandiao();   //试一下单吊
			if(analysis[i].finish_flag==0){
				analysis[i].pureduiduihu();
				if(analysis[i].finish_flag==0){
					analysis[i].qiandang();
					if(analysis[i].finish_flag==0){
						analysis[i].bianzhang();
						if(analysis[i].finish_flag==0){
							analysis[i].paihu();
							if(analysis[i].finish_flag==0){
								analysis[i].duidiao();
								if(analysis[i].finish_flag==0){
									analysis[i].liangtou();
								}
							}
						}
					}
					
				}
			}
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//恢复c_forsishu
	
}
