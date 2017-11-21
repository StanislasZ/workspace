package someproblem;

import java.util.Scanner;

public class Problem1008 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int num=-1;
		while(num!=0){
			String s1=in.next();
			num=Integer.parseInt(s1);
			if(num!=0){
				String[] floorstr=new String[num];
				for(int i=0;i<num;i++){
					floorstr[i]=in.next();
				}
				int[] floorint=new int[num];
				for(int i=0;i<num;i++){
					floorint[i]=Integer.parseInt(floorstr[i]);
					//System.out.println(floorint[i]);
				}
				
				int time=getTime(floorint);
				System.out.println(String.format("%d", time));
			}
		}

	}
	
	public static int getTime(int[] floorint){
		int time=0;
		time=time+6*floorint[0]+5;
		
		//System.out.println(time);
		
		for(int i=1;i<floorint.length;i++){
			//System.out.println("floorint["+i+"]="+floorint[i]);
			
			if(floorint[i]>floorint[i-1]){
				time=time+6*(floorint[i]-floorint[i-1])+5;
			}else if(floorint[i]<floorint[i-1]){
				time=time+4*(floorint[i-1]-floorint[i])+5;
			}else if(floorint[i]==floorint[i-1]){
				time=time+5;
			}
		}
		return time;
	}
	
	

}
