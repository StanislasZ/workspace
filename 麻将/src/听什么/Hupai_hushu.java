package ��ʲô;

import java.util.Arrays;

class Hupai_hushu extends Pai_base{
	int final_tai;          //tai_final=out_tai+tai_bonus+̨�ڲ�(in_tai)
	double final_si;
	int bonus_tai;   //�л�һɫ��ok������һɫ��ok�����ԶԺ���******** ������Ƿ�����ź����������տ�
	double bonus_si;    //�����а���
	int out_tai;
	double out_si;
	int in_tai;
	double in_si;
	int[] out_paidistribution=new int[4];							//����������ֵ
	int[] in_paidistribution=new int[4];						    //����������ֵ
	int[] hu;                									    //����������ֵ
	int num_hu; //�ܺ�������
	int hushu;
	int[] c_inner=new int[44];                                       //����������ֵ
	
	int out_chi_flag;                                              //����������ֵ
	int out_peng_exactnum;                                         //����������ֵ
	int in_exactnum;												//����������ֵ
	int in_fourflag;
	int quan;
	int jia;
	int[] test=new int[4];
	
	int[] c_forsishu=Arrays.copyOf(c_inner,c_inner.length); //ר�Ÿ�������һ�����飬Ҫȥ���齫��˳��
	//������
	Hupai_hushu(Pai_outer out,Pai_inner in){   //��ʼ�������棬������Ʒֲ�ֱ�Ӵ���
		//�ⲿ���Ƶ����ݶ�������
		this.out_si=out.get_out_si();
		this.out_tai=out.get_out_tai();
		this.out_paidistribution=Arrays.copyOf(out.get_out_paidistribution(),out.get_out_paidistribution().length);
		this.out_chi_flag=out.getout_chi_species();
		this.out_peng_exactnum=out.getout_peng_exactnum();
		//������Ƹ�����йأ�������������
		this.in_paidistribution=Arrays.copyOf(in.get_in_paidistribution(), in.get_in_paidistribution().length);
		this.c_inner=Arrays.copyOf(in.getc_inner(),in.getc_inner().length);
		this.in_exactnum=in.getin_exactnum();
		this.hu=in.gethu();
		this.quan=in.getquan();
		this.jia=in.getjia();
		this.in_fourflag=in.get_fourflag();
		this.num_hu=in.get_num_painenghu();
	}
	
	//������֮�󣬶���һ���ڲ��࣬��ÿ���ܺ����ƶ�����һ���µ��ڲ���Ķ���
//=================================================================================================
	class Hupai_every_detail{
		int[] c_innerbackup=Arrays.copyOf(c_inner,c_inner.length);
		int pai;  //�ĸ��ƺ�������ţ���2�����2,2������12
		double si_duiduihu;		double si_paihu;		double si_dandiao;		double si_qiandang;		double si_duidao;		double si_liangtoubushipaihu;
		int tai_dandiao;
		double hushu_dandiao;
		
		int dandiao_flag;	int qiandang_flag;	int bianzhang_flag; int pureduiduihu_flag;	int duidiao_flag;	int paihu_flag;//���������ź��ͼ�ð�ź�
		int liangtou_flag;
		
		int[] three=new int[4];	int[] mj=new int[7];
		
		int[] forsishu=new int[44];
		int[] forsishu_backup=new int[44];
		
		int finish_flag;
		
		
		
		//�����ڲ���Ĺ�����
		Hupai_every_detail(int pai){
			this.pai=pai;
		}
		
		
		
		//���ԶԺ���û�е�����
		void pureduiduihu(){
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;
			if(in_exactnum+out_peng_exactnum==5&&out_chi_flag==0&&in_fourflag==0){  //5�֣�û�ԣ�û4�� ��ǰ��
				
				c_inner[pai]++;
				if(c_inner[pai]==3){
					System.out.print("�ǶԶԺ�(û�е���)");
					pureduiduihu_flag=1;
					in_tai+=2;
					forsishu=Arrays.copyOf(c_inner, c_inner.length);
					
					cal_in_TaiandSi(); //�����ڲ�������̨��
					duidao_amend();//����ʱȥ�����
					hushu=cal_hu_hushu();
					System.out.println("��	����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			finish_flag=1; 
				}
				
			}
			
		}
		
		
		//����
		void dandiao(){
			c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;
			//PrintArray(c_inner);
			c_inner[pai]--;//��������ƣ�ȥ�齫������һ��
			int num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
			PutThree(c_inner,three);    //ɾ���齫�ҿ��� ������������գ������ˣ�                                                                        //�̳е��� ����ǣ�
			
			boolean result=recforhushu(c_inner,three,num_three);                                          //�̳е��� ����ǣ�
			if(result==true){
				dandiao_flag=1;  //���һ��
				in_tai++; //����1̨
				in_si+=0.5;  //��������
				
				if(in_exactnum+out_peng_exactnum==5&&out_chi_flag==0&&in_fourflag==0){   //˵���ǶԶԺ��ӵ���
					System.out.print("�ǶԶԺ�������");
					in_tai+=2;//�ӶԶԺ�2̨
					
					c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
					c_inner[pai]++;
					//forsishu=Arrays.copyOf(c_inner, c_inner.length);
					//System.out.print("������������������Ϊ��");
					//PrintArray(forsishu);
					cal_in_TaiandSi(); //�����ڲ�������̨��
					hushu=cal_hu_hushu();
					System.out.println("����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			finish_flag=1; 
				}
				else  { //���ǶԶԺ��ĵ������
					//��ʱc_inner��ȥ���齫��
					//PrintArray(c_inner);
					System.out.print("�ǶԶԺ�");
					
					forsishu=Arrays.copyOf(c_inner,c_inner.length);
					//System.out.println("\n֮ǰ��");
					//PrintArray(forsishu);
					
					
					forsishu_backup=Arrays.copyOf(forsishu, forsishu.length);
					
					boolean cccc=recforhushu(c_inner,three,num_three,forsishu_backup);  //����void��������  
					//System.out.println("cccc="+cccc);
					//PrintArray(forsishu);
					forsishu[pai]+=2;
					//PrintArray(forsishu);
					cal_in_TaiandSi(); //�����ڲ�������̨��	
					hushu=cal_hu_hushu();
					System.out.println("������   ����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			finish_flag=1; 
									
				}

			}
			
		}
		//����
		void qiandang(){
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;
			if(pai<30&&pai%10>1&&pai%10<9&&c_inner[pai-1]>=1&&c_inner[pai+1]>=1){    //2-8,12-18,22-28,��ǰһ���У���һ���У��ŷ�������
				c_inner[pai-1]-=1;	c_inner[pai+1]-=1;
				//ȥ���������ߵ��ƺ󱣴���
				int[] c_innerdelete_qian=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //����i�󣬲鿴�����齫����        
				num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ�
				ting0716.SetArrayZero(mj);  //�����
				Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
				int num_three=0;      //3����4������
				
				for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
					//�ָ�ȥ�������Ƶ�c
					c_inner=Arrays.copyOf(c_innerdelete_qian,c_innerdelete_qian.length);
					//��three����
					ting0716.SetArrayZero(three);                                             //�������� ����ǣ� 	                                       
					c_inner[mj[j]]-=2;        //ɾ�齫
									
					num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
					PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
					
					//ɾ�����ߣ�ɾ���齫����������rec�����ˣ����ﱸ��һ��
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //�̳е��� ����ǣ�
					if(result==true){
						in_si+=0.5;
						in_tai+=1;
						qiandang_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //�ٰ��齫�ӻ���
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //�����ڲ�������̨��	
						hushu=cal_hu_hushu();
						System.out.println("���ţ�����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			    finish_flag=1; 
						break;
					}
				}	
			}
		}
		//����
		void bianzhang(){   
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;	
	
			if (pai<30&&((pai%10==3&&c_inner[pai-2]>=1&&c_inner[pai-1]>=1)||(pai%10==7&&c_inner[pai+1]>=1&&c_inner[pai+2]>=1)) ){
				if(pai%10==3){
					c_inner[pai-2]-=1;	c_inner[pai-1]-=1;
				}
				else if(pai%10==7){
					c_inner[pai+1]-=1;	c_inner[pai+2]-=1;
				}
				//ȥ�������Ա����ߵ��ƺ󱣴���
				int[] c_innerdelete_bian=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //����i�󣬲鿴�����齫����        
				num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ�
				ting0716.SetArrayZero(mj);  //�����
				Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
				int num_three=0;      //3����4������
				
				for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
					//�ָ�ȥ�������Ƶ�c
					c_inner=Arrays.copyOf(c_innerdelete_bian,c_innerdelete_bian.length);
					//��three����
					                                             //�������� ����ǣ� 	                                       
					c_inner[mj[j]]-=2;        //ɾ�齫
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
					PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
					
					//ɾ��12��89��ɾ���齫����������rec�����ˣ����ﱸ��һ��
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //�̳е��� ����ǣ�
					if(result==true){
						in_si+=0.5;
						in_tai+=1;
						bianzhang_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //�ٰ��齫�ӻ���
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //�����ڲ�������̨��	
						hushu=cal_hu_hushu();
						System.out.println("���ţ�                 ����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			    finish_flag=1;
						break;
					}
				}	
			}
		}
		//�ź�
		void paihu(){     //�Ѷ��齫���жϷ�����
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;			
			
			if(pai<30){
				c_inner[pai]++;
				//�����ƺ󱣴���
				int[] c_innerplus_paihu=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //����i�󣬲鿴�����齫����        
				num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ�
				ting0716.SetArrayZero(mj);  //�����
				Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
				int num_three=0;      //3����4������
				
				for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
					//�ָ�ȥ�������Ƶ�c
					c_inner=Arrays.copyOf(c_innerplus_paihu,c_innerplus_paihu.length);
					//��three����
					                                             //�������� ����ǣ� 	                                       
					c_inner[mj[j]]-=2;        //ɾ�齫
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
					PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
					
					//���������ƣ�ɾ���齫����������rec�����ˣ����ﱸ��һ��
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					int[] temp=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
					ting0716.recStraight(temp); 
					if(ting0716.FindFirstNotZero(temp)==-1){  //ɾ����
						paihu_flag=1;
						if(mj[j]>=39||Pai_base.dnxb2indexMap.get(quan)==mj[j]||Pai_base.dnxb2indexMap.get(jia)==mj[j]){
							System.out.print("��ð�ź���");
							in_si+=0.5;
						}
						else{
							System.out.print("�����ź���");
							in_tai++;
						}
						hushu=cal_hu_hushu();
						System.out.println("����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		//�Ե�  ��������������̨�����򵹣�
		void duidiao(){
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;	
			
			if(pai<30){
				c_inner[pai]-=2;  
				//ȥ��2������ƺ󱣴���
				int[] c_innerdelete_duidao=Arrays.copyOf(c_inner, c_inner.length);
				int num_mj;                                //�鿴�����齫����        
				num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ�
				ting0716.SetArrayZero(mj);  //�����
				Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
				int num_three=0;      //3����4������
				
				for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
					//�ָ�ȥ����������Ƶ�c
					c_inner=Arrays.copyOf(c_innerdelete_duidao,c_innerdelete_duidao.length);
					//��three����
					                                             //�������� ����ǣ� 	                                       
					c_inner[mj[j]]-=2;        //ɾ�齫
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
					PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
					
					//ɾ��2������ƣ�ɾ���齫����������rec�����ˣ����ﱸ��һ��
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //�̳е��� ����ǣ�
					if(result==true){
						paihu_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //�ٰ��齫�ӻ���
						forsishu[pai]+=3;     //�����Ƽӻ���
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //�����ڲ�������̨��
						
						duidao_amend();    //����ʱ���ⲽȥ��
						
						hushu=cal_hu_hushu();
						System.out.println("�Ե���                 ����Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		//�Ե�,���ԶԺ�ʱʱ��Ҫ��
		void duidao_amend(){
			if(pai%10==1||pai%10==9||pai>30){
				in_si-=1.0;
			}
			else{
				in_si-=0.5;
			}
		}
		//��ͷ���п��ӣ�
		void liangtou(){
/*����*/		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
/*����*/		in_si=0;in_tai=0;	
			
			if(pai<30){
				c_inner[pai]++;
				//��������ƺ󱣴���
				int[] c_innerplus_liangtou=Arrays.copyOf(c_inner, c_inner.length);
				
				int num_mj;                                //�鿴�����齫����        
				num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ�
				ting0716.SetArrayZero(mj);  //�����
				Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
				int num_three=0;      //3����4������
				
				for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
					//�ָ���������Ƶ�c
					c_inner=Arrays.copyOf(c_innerplus_liangtou,c_innerplus_liangtou.length);
					//��three����
					                                             //�������� ����ǣ� 	                                       
					c_inner[mj[j]]-=2;        //ɾ�齫
					ting0716.SetArrayZero(three);				
					num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
					PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
					
					//ɾ��2������ƣ�ɾ���齫����������rec�����ˣ����ﱸ��һ��
					forsishu_backup=Arrays.copyOf(c_inner, c_inner.length);
					
					boolean result=recforhushu(c_inner,three,num_three,forsishu_backup);                                          //�̳е��� ����ǣ�
					if(result==true){
						paihu_flag=1;
						//PrintArray(forsishu);
						forsishu[mj[j]]+=2;        //�ٰ��齫�ӻ���
						
						//PrintArray(forsishu);
						cal_in_TaiandSi(); //�����ڲ�������̨��
						
						hushu=cal_hu_hushu();
						System.out.println("�����ź�����ͷ������Ϊ��"+hushu+"��"+"\n");
/*��ʶһ��*/			    finish_flag=1;
						break;
					}
				}
			}
		}
		
		
		
		
		
		//��rec������������һЩ��ǣ�����Ū������,���ֱ�Ӹ����������ʹ�ã���Ϊ����ȥ���齫���������Ǹ���
		public Boolean recforhushu(int[] c,int[] three,int num){     //numΪ���ӵĸ���
			int[] temp=new int[44];
			temp=Arrays.copyOf(c, c.length);
			
			if (num==1){
				Pai_base.recStraight(temp);//ֱ�Ӹ�
				if(ting0716.FindFirstNotZero(temp)==-1)   //-1�Ļ����������                                                                �������ã���ǣ�
					return true;
				//���ֱ�Ӹ�ʧ����
				else{
					//���¸�temp��ֵ
					temp=Arrays.copyOf(c, c.length);
					deleteThree(temp,three,1);     //ȥ����һ��  
					Pai_base.recStraight(temp);              //ȥ˳��
					if(ting0716.FindFirstNotZero(temp)==-1)                                                      //�������ã���ǣ�
						return true;
					else
						return false;
				}
			}
			else {  //num>=2ʱ
				Pai_base.recStraight(temp);//ֱ�Ӹ�
			    if(ting0716.FindFirstNotZero(temp)==-1)   //�����                                                                                �������ã����
			    	return true;
			    //���ֱ�Ӹ�ʧ����
			    else{
			    	temp=Arrays.copyOf(c, c.length);   //���¸�temp��ֵ  
			    	for(int i=1;i<num;i++){
			    		temp=Arrays.copyOf(c, c.length); 
			    		deleteThree(temp,three,i+1);

			    		if(recforhushu(temp,three,num-1))     //����num=2��  ������ⲽ�� ��ֱ�ӷ��ĵؽ���  һ�̵ĵݹ�  ����ɹ�����true��������
			    			
			    			return true;
			    	}
				}
			}
			return false;
		}
		
		
		//overload rec
		public Boolean recforhushu(int[] c,int[] three,int num,int[] forsishu_backup){     //numΪ���ӵĸ���
			
			int[] temp=new int[44];
			temp=Arrays.copyOf(c, c.length);
			int[] temp1=new int[44];
			temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
			
			
			if (num==1){
				
				deleteThree(temp,three,1);     //ȥ����һ��  
				//System.out.println("ȥ��һ�̺�tempΪ");
				//PrintArray(temp);
				recStraight(temp,temp1);              //ȥ˳��
				
				//System.out.println("ȥ��˳�Ӻ�temp1Ϊ");
				//PrintArray(temp1);
				
				if(ting0716.FindFirstNotZero(temp)==-1){   //-1�Ļ����������                                                                �������ã���ǣ�
					forsishu=Arrays.copyOf(temp1, temp1.length);
					//System.out.println("xxxxxxxx1xx");
					//PrintArray(forsishu);
					
					return true;
				}
				//���ֱ�Ӹ�ʧ����
				else{
					//System.out.println("����else");
					//���¸�temp��ֵ
					temp=Arrays.copyOf(c, c.length);
					//���¸�c_forsishu��ֵ
					temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);
					
					//System.out.print("tempΪ");
					//PrintArray(temp);
					//System.out.print("temp1Ϊ");
					//PrintArray(temp1);
					
					recStraight(temp,temp1);//ֱ�Ӹ�
					
					//System.out.print("ȥ˳֮��tempΪ");
					//PrintArray(temp);
					//System.out.print("ȥ˳֮��temp1Ϊ");
					//PrintArray(temp1);
					
					
					if(ting0716.FindFirstNotZero(temp)==-1){                                                      //�������ã���ǣ�
						forsishu=Arrays.copyOf(temp1, temp1.length);
						//System.out.println("xxxxxx");
						//PrintArray(forsishu);
						return true;
					}
					else
						return false;
				}
			}
			else {  //num>=2ʱ
				for(int i=0;i<num;i++){
					//System.out.println("��"+(i+1)+"�Σ�");
					//�����һ�ο϶�Ҫ�Ȼָ�����
					temp=Arrays.copyOf(c, c.length);   //���¸�temp��ֵ  
			    	temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);  //���¸�temp1��ֵ
			    	//System.out.println("temp1Ϊ");
			    	//PrintArray(temp1);
					deleteThree(temp,three,i+1);
					
					//System.out.println("ɾ�˵�"+(i+1)+"�̺�");
					//PrintArray(temp);
					
		    		if(recforhushu(temp,three,num-1,temp1)) {    //����num=2��  ������ⲽ�� ��ֱ�ӷ��ĵؽ���  һ�̵ĵݹ�  ����ɹ�����true��������
		    			
		    			//forsishu=Arrays.copyOf(temp1, temp1.length);   //���û�ã����Ҵ�����Ϊ�ݹ鵽num=1���Ѿ���temp1��forsishu��
		    			//System.out.println("xxx");
		    			//PrintArray(temp1);
		    			return true;
					}
				}
				
				temp=Arrays.copyOf(c, c.length);   //���¸�temp��ֵ  
		    	temp1=Arrays.copyOf(forsishu_backup, forsishu_backup.length);  //���¸�temp1��ֵ
		    	
				recStraight(temp,temp1);//ֱ�Ӹ�
			    if(ting0716.FindFirstNotZero(temp)==-1){   //�����                                                                                �������ã����
			    	forsishu=Arrays.copyOf(temp1, temp1.length);
			    	//System.out.println("xxxxxx");
			    	return true;
			    }
			   
			    
			}
			return false;
		}
		
		//ɾ˳��(Ϊ��������ʱȥ��˳�ӣ�����д�������)
				public void recStraight(int[] c,int[] c_forsishu){
					   
					 int min = ting0716.FindFirstNotZero(c);                                                 //�������ã���ǣ�
						    
					 if((min!=-1)&&(min<=27)){                    //���±���±�С�ڵ���27
						 if ((c[min+1]>=1)&(c[min+2]>=1)){
							 c[min]-=1;    c[min+1]-=1;    c[min+2]-=1;
						     c_forsishu[min]-=1;	c_forsishu[min+1]-=1;	c_forsishu[min+2]-=1;  //���������ӵ�
						     
						     recStraight(c,c_forsishu);
						 }
					 }
				}
		
				public void cal_in_TaiandSi(){       //������ԭʼ����c_innerbackup����
					//�Ȱ������Ƶ��������� ,�����з��׵�̨�� 
					//System.out.println("��֮ǰ��insiΪ"+in_si);
					for(int i=1;i<=43;i++){
						if((i%10==0)||(i>30&&i%2==0))continue;
							if(forsishu[i]>=3){
								if(i%10==1||i%10==9||i>30){
									in_si=in_si+Pai_inner.in19num2siMap.get(forsishu[i]);       											//��������
									//double abc=Pai_inner.in19num2siMap.get(forsishu[i]);
									//System.out.println(abc);
								}
								else
									in_si=in_si+Pai_inner.innot19num2siMap.get(forsishu[i]);									    //��������
								if(i>=39)in_tai++;
							}
							
					}
					//����Ǵ��ڵ���3�����Ѷ���������̨�����ϣ����Ȧ��quan���ŷ�jia�������ֻ��2�����Ӱ���
					for(int i=31;i<=37;i++){
						if(forsishu[i]>=3){
							if(i==dnxb2indexMap.get(quan))                                         //�̳е���
								in_tai++;
							if(i==dnxb2indexMap.get(jia))                                       //�̳е���
								in_tai++;
						}
						else if(forsishu[i]==2){
							if(i==dnxb2indexMap.get(quan)||i==dnxb2indexMap.get(jia))
								//in_si+=Pai_inner.in19num2siMap.get(c_forsishu[i]);          //��Ȧ������ŷ綼�Ӱ���                 ��������
								in_si+=0.5;
//							double abc=Pai_inner.in19num2siMap.get(forsishu[i]);
//							System.out.println(abc);
							
						}
					}
					//�췢�������2�������ϰ���
					for(int i=39;i<=43;i=i+2){
						if(forsishu[i]==2)
							in_si+=0.5;
					}
					
					//System.out.println("��֮��insiΪ"+in_si);
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
	
	public void Cal_hunqingduiduibonus(){    //�����һɫ,��һɫ�ĸ���̨��,����tai_bonus���������������tai_bonus�Զ���������һɫ�ͻ�һɫ�ļӳ�
		int normal_flag;
		int feng_flag;
		int[] both=new int[4];
		for(int i=0;i<4;i++){
			if(out_paidistribution[i]>0||in_paidistribution[i]>0)
			both[i]=1;   //�������ˡ����
		}
		//PrintArray(both);
		normal_flag=both[0]+both[1]+both[2];    //����֮�����ֻ���򣬵���1������Ͳ������2����������
		feng_flag=both[3];
		//System.out.println("normal_flag="+normal_flag+",feng_flag="+feng_flag);
		
		if(normal_flag==0&&feng_flag==1)      //��һɫ
			this.bonus_tai+=4;
		else if(normal_flag==1&&feng_flag==0)    //��һɫ,��һɫ��Ͳһɫ
			this.bonus_tai+=4;
		else if(normal_flag==1&&feng_flag==1)    //��һɫ
			this.bonus_tai+=2;
	
	}
	
	public void xxx(){          //������
		System.out.println("tai_bonus="+bonus_tai);
		if(out_chi_flag>0)
			System.out.println("����Թ�");
		else
			System.out.println("����û�Թ�");
		if(out_peng_exactnum>0)
			System.out.println("��������"+out_peng_exactnum+"��");
		else
			System.out.println("����û����");
	}
	
	public void amazing(){
		Hupai_every_detail[] analysis=new Hupai_every_detail[num_hu];//����һ�����飬ÿ��Ԫ�ض���Hupai_every_detail����
		int t=0;
		//PrintArray(hu);
		for(int i=1;i<44;i++){
			if(hu[i]>0){
				analysis[t++]=new Hupai_every_detail(i);   //��������  analysis[0]���Ǹ��ݱ����С���ܺ������������Ķ��󣬷��������Ƶĺ���
			}
		}
		for(int i=0;i<num_hu;i++){
			System.out.print("������   "+paiMap.get(analysis[i].pai)+"��");
//			analysis[i].dandiao();   //��һ�µ���
//			if(analysis[i].dandiao_flag!=1) //���ǵ�������һ�´��ԶԺ�
//				analysis[i].pureduiduihu();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1)   //���ǵ��������Ǵ��ԶԺ�����һ�¿���
//				analysis[i].qiandang();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1)
//				analysis[i].bianzhang();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1&&analysis[i].bianzhang_flag!=1)
//				analysis[i].paihu();
//			if (analysis[i].dandiao_flag!=1&&analysis[i].pureduiduihu_flag!=1&&analysis[i].qiandang_flag!=1&&analysis[i].bianzhang_flag!=1&&analysis[i].paihu_flag!=1)
//				analysis[i].duidiao();
			
			analysis[i].dandiao();   //��һ�µ���
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//�ָ�c_forsishu
	
}
