package someproblem;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem1009 {

	public static void main(String[] args) {
		 
		Scanner in=new Scanner(System.in);
		
		int M=0,N=0;
		while(!(M==-1&&N==-1)){
			M=in.nextInt();
			N=in.nextInt();
			//System.out.println("M="+M+","+"N="+N);
			
			if(!(M==-1&&N==-1)){
				int[] J=new int[N];
				int[] F=new int[N];
				double[] profitpercent=new double[N];
				
				double a;
				//求得J[i],F[i],每组的兑换比例
				for(int i=0;i<N;i++){
					J[i]=in.nextInt();
					F[i]=in.nextInt();
					profitpercent[i]=((double)J[i])/((double)F[i]);
					//System.out.println("J["+i+"]="+J[i]+",F["+i+"]="+F[i]+" "+profitpercent[i]);
				}
				//创建集合，
				TreeSet<mouse> t =new TreeSet<>(new Comparator<mouse>(){
					@Override
					public int compare(mouse o1, mouse o2) {
						double temp=o1.getDataprofitpercent()-o2.getDataprofitpercent();
						if(temp<0)
							return 1;
						else if(temp>0)
							return -1;
						else
							return 1;
					}				
				});
				/*
				 * 存入集合，并按照profitpercent已排好序
				 */
				for(int i=0;i<N;i++){
					t.add(new mouse(J[i],F[i],profitpercent[i]));
				}
				
				double beansum=0;
				//进行迭代，第一次是兑换比例最高，………………
				for (Iterator<mouse> it = t.iterator(); it.hasNext();) {
					mouse m = it.next();
					//System.out.println("进入时：M="+M+",F="+m.getDataF());
					
					if(M>0&&M>=m.getDataF()){
						beansum=beansum+(double)m.getDataJ();
						M=M-m.getDataF();
						//System.out.println("M="+M);
					}else if(M>0&&M<m.getDataF()){
						//System.out.println("**");
						beansum=beansum+((double)M)*m.getDataprofitpercent();
						break;
					}
				}
				//System.out.println("beansum="+beansum);
				System.out.println(String.format("%.3f", beansum));
								
			}
		}
	}
}
class mouse {
	int dataJ;
	int dataF;
	double dataprofitpercent;
	public mouse(int dataJ, int dataF, double dataprofitpercent) {
		super();
		this.dataJ = dataJ;
		this.dataF = dataF;
		this.dataprofitpercent = dataprofitpercent;
	}
	public int getDataJ() {
		return dataJ;
	}
	public int getDataF() {
		return dataF;
	}
	public double getDataprofitpercent() {
		return dataprofitpercent;
	}
	@Override
	public String toString() {
		return "mouse [dataJ=" + dataJ + ", dataF=" + dataF + ", dataprofitpercent=" + dataprofitpercent + "]";
	}
	
	
	
	
}
