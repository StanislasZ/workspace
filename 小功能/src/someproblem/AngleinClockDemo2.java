package someproblem;

import java.util.Scanner;

public class AngleinClockDemo2 {

	public static void main(String[] args) {
		//long startTime1=System.nanoTime();//获取纳秒（当前时间）
		
		Scanner in =new Scanner(System.in);
		double angle;
		double second_v=6;
		double minute_v=second_v/60;
		double hour_v=minute_v/12;
		int total_time=60*60*12;
		
		double temp;
		//System.out.println("输入int型数据：");
		while((temp=in.nextDouble())!=-1){
			angle=temp;
			
			double sm_v=second_v-minute_v;
			double sh_v=second_v-hour_v;
			double mh_v=minute_v-hour_v;
			
				
			
			
			double[][] sm_happyspan=new double[708][2];
			double[][] sh_happyspan=new double[719][2];
			double[][] mh_happyspan=new double[11][2];
			
			sm_happyspan[0][0]=angle/sm_v;
			sh_happyspan[0][0]=angle/sh_v;
			mh_happyspan[0][0]=angle/mh_v;
			
			sm_happyspan[0][1]=(360-angle)/sm_v;
			sh_happyspan[0][1]=(360-angle)/sh_v;
			mh_happyspan[0][1]=(360-angle)/mh_v;
			
			for (int i=1;i<sm_happyspan.length;i++){
				sm_happyspan[i][0] = sm_happyspan[i-1][0] + 360 / sm_v;
				sm_happyspan[i][1] = sm_happyspan[i-1][1] + 360 / sm_v;
			}
			for (int i=1;i<sh_happyspan.length;i++){
				sh_happyspan[i][0] = sh_happyspan[i-1][0] + 360 / sh_v;
				sh_happyspan[i][1] = sh_happyspan[i-1][1] + 360 / sh_v;
			}
			for (int i=1;i<mh_happyspan.length;i++){
				mh_happyspan[i][0] = mh_happyspan[i-1][0] + 360 / mh_v;
				mh_happyspan[i][1] = mh_happyspan[i-1][1] + 360 / mh_v;
			}
			
			double happy_time = 0;
			double low;
			double high;
			
			for(int i=0;i<mh_happyspan.length;i++){
				for(int j=0;j<sm_happyspan.length;j++){
					if(sm_happyspan[j][0]<mh_happyspan[i][1]&&sm_happyspan[j][1]>mh_happyspan[i][0]){
						for(int k=0;k<sh_happyspan.length;k++){
							if(sh_happyspan[k][0]<sm_happyspan[j][1]&&sh_happyspan[k][1]>sm_happyspan[j][0]){
								if(sh_happyspan[k][0]<mh_happyspan[i][1]&&sh_happyspan[k][1]>mh_happyspan[i][0]){
									low=getMax(mh_happyspan[i][0],sm_happyspan[j][0],sh_happyspan[k][0]);
									high=-getMax(-mh_happyspan[i][1],-sm_happyspan[j][1],-sh_happyspan[k][1]);
									happy_time+=(high-low);
								}
							}
						}
					}
				}
			}
			
			System.out.println(String.format("%.3f",100.0*happy_time/(double)total_time));
				
			//long endTime1=System.nanoTime();
			//System.out.printf("程序运行时间：%.0fμs，约为%.1fms",(endTime1-startTime1)/1000.0,(endTime1-startTime1)/1000000.0);
			
		}
		
		
		

	}
	public static double getMax(double i,double j,double k){
		return (i > j ? i:j) > k ? (i > j ? i:j) :k;
	}

}
