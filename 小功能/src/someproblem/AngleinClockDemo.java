package someproblem;

import java.util.Scanner;

public class AngleinClockDemo {
	public static void main(String[] args){
		long startTime1=System.nanoTime();//获取纳秒（当前时间）
		
		Scanner in =new Scanner(System.in);
		int[] angle=new int[3];
		int k=0,temp;
		System.out.println("输入int型数据：");
		while((temp=in.nextInt())!=-1){
			angle[k++]=temp;
		}
	
		
		
		int frequency=100;
		
		AngleinClock ac=new AngleinClock(frequency);   //创建一个时钟实例
		
		int[] sum=new int[3];
		for(int i=1;i<=12*3600*frequency;i++){
			for(int j=0;j<3;j++){
				if(ac.getAngleBetweenTwoStitches(i, angle[j]))
					sum[j]++;
			}
		}
		for(int i=0;i<3;i++)
			System.out.printf("%.3f\n",100*sum[i]/frequency/3600.0/12.0);
				
		long endTime1=System.nanoTime();
		System.out.printf("程序运行时间：%.0fμs，约为%.1fms",(endTime1-startTime1)/1000.0,(endTime1-startTime1)/1000000.0);
	}
}

class AngleinClock{
	double frequency;
	double second_angle;    //秒针角度
	double minute_angle;    //分针角度
	double hour_angle;      //时针角度
		
	public AngleinClock(int frequency) {
		this.frequency = (double)frequency;
	}

	public AngleinClock() {
		super();
		second_angle=0;
		minute_angle=0;
		hour_angle=0;
	}

	private void setSecond_angle(int millsecond) {
		double temp=(double)millsecond;
		this.second_angle = temp*360/60.0/frequency;
		second_angle=second_angle-360*((int)second_angle/360);  //秒针角度要不断地减360直到在0-360之间
	}
	private void setMinute_angle(int millsecond) {
		double temp=(double)millsecond;
		this.minute_angle = temp*360/60.0/60.0/frequency;
		minute_angle=minute_angle-360*((int)minute_angle/360);  //分针同上
	}
	private void setHour_angle(int millsecond) {
		double temp=(double)millsecond;
		this.hour_angle = temp*360/60.0/60.0/12.0/frequency;    //时针一共就转了一圈，不用减
	}

	/**
	 * 根据给定的毫秒时间，设置三针的角度
	 * @param millsecond
	 */
	public void setThreeAngle(int millsecond){
		setSecond_angle(millsecond);
		setMinute_angle(millsecond);
		setHour_angle(millsecond);
	}
	
	public boolean getAngleBetweenTwoStitches(int millsecond,double d){    
		setThreeAngle(millsecond);
		double angle1=Math.abs(second_angle-minute_angle);
		double angle2=Math.abs(second_angle-hour_angle);
		double angle3=Math.abs(minute_angle-hour_angle);
		angle1=angle1>180?360-angle1:angle1;
		angle2=angle2>180?360-angle2:angle2;
		angle3=angle3>180?360-angle3:angle3;
		return angle1>d&&angle2>d&&angle3>d;
	}
	
	
	
}









