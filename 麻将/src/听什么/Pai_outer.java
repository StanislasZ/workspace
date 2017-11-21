package ��ʲô;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Pai_outer extends Pai_base {
	static Map<Integer,Double> out19num2siMap;{  //19�����Ͷ��������з��׵ĸ�����Ӧ����
		out19num2siMap=new HashMap<Integer,Double>();
		out19num2siMap.put(3,1.0);out19num2siMap.put(4,4.0);out19num2siMap.put(5,8.0);
	}
	static Map<Integer,Double> outnot19num2siMap;{     //��19����������
		outnot19num2siMap=new HashMap<Integer,Double>();
		outnot19num2siMap.put(3,0.5);outnot19num2siMap.put(4,2.0);outnot19num2siMap.put(5,4.0);
	}
	int[] c_outerchi=new int[44];
	int[] c_outerpeng=new int[44];
	int[] c_outerpengbackup;
	private double out_si=0;
	private int out_tai=0;
	int[] hua=new int[8];  //�����ﶬ   ÷�����
	int quan;       //��������Ȧ
	int jia;          //����������
	int[] minggang=new int[4];
	int[] angang=new int[4];
	private int num_outwan=0;
	private int num_outtiao=0;
	private int num_outtong=0;
	private int num_outfeng=0;
	//���캯��
	Pai_outer(int[] pai_outerpeng,int[] pai_outerchi,int quan,int jia,int[] hua){
		for(int i=0;i<pai_outerpeng.length;i++)
			c_outerpeng[pai_outerpeng[i]]++;      //����������
		for(int i=0;i<pai_outerchi.length;i++)
			c_outerchi[pai_outerchi[i]]++;        //����Ե���
		c_outerpengbackup=Arrays.copyOf(c_outerpeng, c_outerpeng.length);  //����c_outer��
		this.hua=Arrays.copyOf(hua, hua.length);
		this.quan=quan;
		this.jia=jia;
	}
	
	//��ȡ�������������Ͳ����������û��Ϊ0����Ϊ1
	public void Caloutwantiaotongfeng(){
		for(int i=1;i<=9;i++){
			if(c_outerpeng[i]>0||c_outerchi[i]>0){
				num_outwan++;
				break;
			}
		}
		for(int i=11;i<=19;i++){
			if(c_outerpeng[i]>0||c_outerchi[i]>0){
				num_outtiao++;
				break;
			}
		}
		for(int i=21;i<=29;i++){
			if(c_outerpeng[i]>0||c_outerchi[i]>0){
				num_outtong++;
				break;
			}
		}
		for(int i=31;i<=43;i=i+2){
			if(c_outerpeng[i]>0||c_outerchi[i]>0){
				num_outfeng++;
				break;
			}
		}
	}
	
	//����л�һɫ����һɫ�Ŀ���
	public int[] get_out_paidistribution(){
		Caloutwantiaotongfeng();   //����һ������Ͳ��
		int[] temp=new int[4];
		if(num_outwan>0)temp[0]=1;
		if(num_outtiao>0)temp[1]=1;
		if(num_outtong>0)temp[2]=1;
		if(num_outfeng>0)temp[3]=1;
		return temp;
	}
	
	public void calandshowGang(){    //calculate��
		for(int i=0;i<44;i++){
	    	int index_ming=0;
	    	int index_an=0;
	    	if(c_outerpeng[i]==4){
	    		minggang[index_ming++]=i;
	    		//c_outerpeng[i]-=1;   //�ȱ�-1��֮���4������3��
	    	}
	    	else if(c_outerpeng[i]==5){
	    		angang[index_an++]=i;
	    		//c_outerpeng[i]-=2;    //�ȱ�-2��֮���5������3��
	    	}
	    }
		
		if(ting0716.FindFirstNotZero(minggang)!=-1){
			System.out.print("�����ǣ�");
			for(int i=0;i<minggang.length;i++){
				if(minggang[i]!=0)
					System.out.print(paiMap.get(minggang[i])+" ");                               //��������
			}
			System.out.println();
		}
		if(ting0716.FindFirstNotZero(angang)!=-1){
			System.out.print("�����ǣ�");
			for(int i=0;i<angang.length;i++){
				if(angang[i]!=0)
					System.out.print(paiMap.get(angang[i])+" ");                              //��������
			}
			System.out.println();
		}
	}
	
	
	public void cal_out_TaiandSi(){   //ʹ��c_outerbackup�������ԭʼ����
		//�Ȱ������Ƶ��������� ,�����з��׵�̨�� 
		for(int i=1;i<=43;i++){
			if((i%10==0)||(i>30&&i%2==0))continue;
			if(c_outerpengbackup[i]>=3){
				if(i%10==1||i%10==9||i>30)
					out_si=out_si+out19num2siMap.get(c_outerpengbackup[i]);
				else
					out_si=out_si+outnot19num2siMap.get(c_outerpengbackup[i]);
				if(i>=39)out_tai++;
			}
		}
		//�Ѷ���������̨�����ϣ����Ȧ��quan���ŷ�jia��
		for(int i=31;i<=37;i++){
			if(c_outerpengbackup[i]>=3){
				if(dnxb2indexMap.get(quan)==i)                                         //��������
					out_tai++;
				if(dnxb2indexMap.get(jia)==i)                                       //��������
					out_tai++;
			}
		}
		//�ѻ���������̨������
		for(int i=0;i<hua.length;i++){
			if(hua[i]>0){
				out_si++;
				if(jia==huaindexMap.get(i))                                                  //��������
					out_tai++;
			}
		}
		//����д����ﶬ���ټ�1̨�������÷����գ��ټ�1̨��
		if(hua[0]==1&&hua[1]==1&&hua[2]==1&&hua[3]==1)
			out_tai++;
		if(hua[4]==1&&hua[5]==1&&hua[6]==1&&hua[7]==1)
			out_tai++;
	}
	
	public void print_out_TaiandSi(){ //�����������ǰ��һ��Ҫ�ȵ���cal_out_TaiandSi()
		
		System.out.println("����̨��="+out_tai+",��������="+out_si);
	}
	public int get_out_tai(){
		return out_tai;
	}
	public double get_out_si(){
		return out_si;
	}
	
	

	
	//�����ȡgang����������
	public int[] getMinggang(){
		return minggang;
	}
	public int[] getAngang(){
		return angang;
	}
	
	//�����ȡ�Գ��������Ƶļ����͡�
	public int[] getc_outerchi(){
		return c_outerchi;
	}
	public int[] getc_outerpeng(){
		return c_outerpeng;
	}
	public int getout_chi_species(){   //out��ʼ����Ϳ�ʹ�øú���
		for(int i=1;i<c_outerchi.length;i++){
			if(c_outerchi[i]!=0)
				return 1;
		}
		return 0;          //�Թ�����1��û�Թ�����0
	}
	public int getout_peng_exactnum(){    //��������������ȷ�и���
		int num=0;
		for(int i=1;i<c_outerpeng.length;i++){
			if(c_outerpeng[i]>=3)
				num++;
		}
		return num;
	}
	
}