package ��ʲô;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Pai_inner extends Pai_base {
	static Map<Integer,Double> in19num2siMap;{  //19�����Ͷ��������з��׵ĸ�����Ӧ����
		in19num2siMap=new HashMap<Integer,Double>();
		in19num2siMap.put(2,0.5);in19num2siMap.put(3,2.0);in19num2siMap.put(4,2.0);
	}
	static Map<Integer,Double> innot19num2siMap;{  //19�����Ͷ��������з��׵ĸ�����Ӧ����
		innot19num2siMap=new HashMap<Integer,Double>();
		innot19num2siMap.put(3,1.0);innot19num2siMap.put(4,1.0);
	}
	
	int[] c_inner=new int[44];   //��������ø�����ʾ
	int[] c_innerbackup=new int[44];    //���ݣ�ѭ��ʱ���ڻָ�����
	
	int[] c_innerplusi=new int[44];   //���������Ƶ�c
	int[] mj=new int[7];
	int[] three=new int[4];
	private int[] hu=new int[44];          //����ʱ������
	int hu_flag=0;
	
	private double insi=0;
	private int intai=0;
	
	int quan;       //��������Ȧ
	int jia;          //����������
	double in_si;
	int in_tai;
	
	private int num_inwan=0;
	private int num_intiao=0;
	private int num_intong=0;
	private int num_infeng=0;     //Ϊ��һɫ����һɫ�ṩ����
	
	//������
	Pai_inner(int[] pai_inner,int quan,int jia){
		for(int i=0;i<pai_inner.length;i++)
			c_inner[pai_inner[i]]++;
		c_innerbackup=Arrays.copyOf(c_inner,c_inner.length);   //���ݣ�������ѭ������ʱ�ָ�����
		this.quan=quan;
		this.jia=jia;
	}
	
	//�ҵ������ƣ�����hu����
	public void findpainenghu(){
		c_innerbackup=Arrays.copyOf(c_inner,c_inner.length); 
		for(int i=1;i<=43;i++){                                                                     //��һ��ѭ��������ÿ�����������Ƿ��ܺ�
			if(i%10==0||(i>30&&i%2==0))continue;   //10,20,30,32,34,36,38,40,42ʱֱ����������Ϊ����
					
			
			//ÿ�ν���ʱ�����������ָ�c
			c_inner=Arrays.copyOf(c_innerbackup,c_innerbackup.length);
			//ting0716.PrintArray(c_inner);
			ting0716.SetArrayZero(mj);//ÿ�ν���ʱ��mjԪ�ض���0                                           //�������� ����ǣ�
			
			c_inner[i]++;                              //����������
			c_innerplusi=Arrays.copyOf(c_inner,c_inner.length);   //���ݼ�������ƺ��c
			
			if((i<43&&c_inner[i]<=1)){
				if(c_inner[i-1]==0&&c_inner[i+1]==0)    //��c�йأ��������������c�ָ�֮��
					continue;          //�ӿ����
			}
			//���c[i]==5,continue ���뵽һ�¸�i�����������������ƣ�
			if(c_inner[i]>4)continue;
			
			
			int num_mj;                                //����i�󣬲鿴�����齫����        
			num_mj=FindNumOfTwo(c_inner);		                                                 //�̳е��� ����ǣ� 	
			Putmj(c_inner,mj);//���齫������mj����                                                                                     //�̳е��� ����ǣ�
						 
			int num_three=0;      //3����4������
					
			//����ڶ���ѭ��
			for(int j=0;j<num_mj;j++){                                                   //�ڶ���ѭ������С����ɾ�齫             j��0��num_mj-1                    
				//�ָ��ӹ�i��c
				c_inner=Arrays.copyOf(c_innerplusi,c_innerplusi.length);
				//��three����
				ting0716.SetArrayZero(three);                                             //�������� ����ǣ� 	                                       
				c_inner[mj[j]]-=2;        //ɾ�齫
							
				
				num_three=FindNumOfThree(c_inner);                                              //�̳е��� ����ǣ�
				PutThree(c_inner,three);    //ɾ���齫�ҿ���                                                                         //�̳е��� ����ǣ�
				
				boolean result=rec(c_inner,three,num_three);                                          //�̳е��� ����ǣ�
				if(result==true){
					hu[i]++;
					hu_flag++;
				}
				
												
			}	
			
		}
		c_inner=Arrays.copyOf(c_innerbackup, c_innerbackup.length);
	}
	//��ӡ�ڲ�һ��ʼ����
	public void printpai_inner(){
		System.out.print("�������Ϊ��");
		for(int i=0;i<c_innerbackup.length;i++){
			while(c_innerbackup[i]>0){
				System.out.print(paiMap.get(i)+" ");
				c_innerbackup[i]--;
			}
		}
		System.out.println();
	}
	//��ӡ������
	public void printHu(){
			if(hu_flag==0)System.out.println("��Ǹ�����ƿɺ�");
			else{
				System.out.print("���Ժ���");
				for(int i=0;i<hu.length;i++){
					if(hu[i]>0){
						System.out.print(paiMap.get(i)+" ");
					}
				}
				System.out.println();
		
			}
	}
	//���ⲿ�ṩ��ȡhu_flag�ķ����������������ʱ������findpainenghu()��
	public int gethu_flag(){
		return hu_flag;
	}
	
	public void cal_in_sao_TaiandSi(){       //������ԭʼ����c_innerbackup����
		//�Ȱ������Ƶ��������� ,�����з��׵�̨�� 
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
		//����Ǵ��ڵ���3�����Ѷ���������̨�����ϣ����Ȧ��quan���ŷ�jia�������ֻ��2�����Ӱ���
		for(int i=31;i<=37;i++){
			if(c_innerbackup[i]>=3){
				if(i==dnxb2indexMap.get(quan))                                         //�̳е���
					in_tai++;
				if(i==dnxb2indexMap.get(jia))                                       //�̳е���
					in_tai++;
			}
			else if(c_innerbackup[i]==2){
				if(i==dnxb2indexMap.get(quan)||i==dnxb2indexMap.get(jia))
					in_si=in_si+in19num2siMap.get(c_innerbackup[i]);          //��Ȧ������ŷ綼�Ӱ���
				
			}
		}
		//�з��������2�����Ӱ���
		for(int i=39;i<=43;i=i+2){
			if(c_innerbackup[i]==2)
				in_si+=0.5;
		}
	}
	
	public void print_in_sao_TaiandSi(){ //�����������ǰ��һ��Ҫ�ȵ���cal_out_sao_TaiandSi()
		
		System.out.println("����̨��="+in_tai+",��������="+in_si);
	}
	
	
	public int cal_sao_hushu(Pai_outer out,Pai_inner in){
		double si=in.get_in_sao_si()+out.get_out_si();
		int tai=in.get_in_sao_tai()+out.get_out_tai();
		int hushu=(int)(4*si*Math.pow(2.0,(double)(tai)));
		
		return hushu;
		//return hushu%10==0?hushu:(hushu+10)/10*10;
	}
	
	
	//��ȡ�������������Ͳ����������û��Ϊ0����Ϊ1
	public void Calinwantiaotongfeng(){
		for(int i=1;i<=9;i++){
			if(c_innerbackup[i]>0){     //�ñ��ݹ����������㣬ȷ������
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
	
	
	//��ȡ�����������Ͳ������
	public int[] get_in_paidistribution(){
		Calinwantiaotongfeng();   //����һ������Ͳ��
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
	//�õ��ڲ��������ȷ����Ŀ,(��innerbackup��)
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
	
	//��һ���ڲ��Ƶ�4��һ�������
	public int get_fourflag(){
		for(int i=1;i<44;i++){
			if(c_innerbackup[i]==4)
				return 1; 
		}
		return 0;
	}
	
	//�������Ҫ������ˣ���ı�c_inner��Ū�����������ָ������c_inner
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
