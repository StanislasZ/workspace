
public class OutsideHedge {
	static final double KEY=3.96;
	public static void main(String[] args) {
		double money=4330.93;
		double lastprofit=559.8;
		double baseodd=1.9;   //外部odd基数    
		int odd_num=1;      //几个odd
		int num_expect=4;       //几个期望利润
		double profit_base=356.67;
		double profit_span=5;
		
		
		
		HedgePlan(money,lastprofit,baseodd,odd_num,num_expect,profit_base,profit_span);
		
		
		
		

	}
	public static void HedgePlan(double money,double lastprofit,double baseodd,int odd_num,int num_expect,double profit_base,double profit_span){
		double[] odd=new double[odd_num];  //14个odd
		for(int i=0;i<odd.length;i++)   
			odd[i]=baseodd+(i+0.0)/100.0;
		
		double[] profit_expect=new double[num_expect];  //20个期望收益
		for(int i=0;i<profit_expect.length;i++)
			profit_expect[i]=profit_base+(i+0.0)*profit_span;  
		double[][] table=new double[odd.length][profit_expect.length*3+1];
		
		for(int i=0;i<odd.length;i++){   //odd装入table的第一列
			table[i][0]=odd[i];
		}
		
		
		
		
		System.out.print("外部odd"+" ");
		for(int i=0;i<num_expect;i++)
			System.out.print("*"+"期望利润"+"  "+"需要的钱"+"  "+"继续利润"+"  ");
		System.out.println();	
		
		for(int i=0;i<odd.length;i++){  //对
			int k=0;
			for(int j=1;j<table[i].length;j=j+3){
				
				table[i][j]=profit_expect[k];
				k++;
				
			}
		}
		for(int i=0;i<odd.length;i++){
			for(int j=2;j<table[i].length;j=j+3){
				
				//根据k,odd[k]是赔率,table[i][j-1]是期望利润，来算出table[i][j]需要的钱
				table[i][j]=(money-lastprofit+table[i][j-1])/(odd[i]-1.0);  //需要的钱，对
				
				table[i][j+1]=money*(KEY-odd[i]-1)-table[i][j]+lastprofit;
				
			}
		}
		
		for(double[] row:table){
			for(double element:row){
				System.out.printf("%-8.2f ",element);
			}
			System.out.println();
			System.out.println();
		}
		
		//PrintArray(table[4]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//打印数组，调试
	public static void PrintArray(double[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.printf("%-8.2f ",arr[i]);
		}
		System.out.println();		
	}
	
	
	
	
	

}
