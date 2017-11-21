package someproblem;

import java.util.Scanner;
import java.util.Stack;

public class Problem1010 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int N,M,T;
		while(!((N=in.nextInt())==0&(M=in.nextInt())==0&(T=in.nextInt())==0)){
			
			Stack<String> trace=new Stack<>();
			//读取哪个是门，哪个是起点，哪个是不能用，哪个是能用
			//先扫描，每个位置的Coordinate先确定
			Coordinate[][] myco=new Coordinate[N][M];
			Coordinate start = null,door=null;		
			
			/*---------------------坐标初始化开始--------------------*/
			for(int i=0;i<N;i++){
				String str=in.next();
				for(int j=0;j<M;j++){
					char c=str.charAt(j);
					myco[i][j]=new Coordinate(j,i,c);  //横纵坐标，类型，使用标志 都已确定
					if(c=='S'){
						start=myco[i][j];
						start.setState(1);//起点被用了
					}
					else if(c=='D'){
						door=myco[i][j];
					}
					else if(c=='X'){
						myco[i][j].setState(1); //障碍物就当成被用过的
					}
				}
			}
			/*---------------------坐标初始化结束-----------------------*/
			
			int sum=0;
			boolean result=ifFitT(trace,myco,start,door,sum,T);
		
			if(result==true)
				System.out.println("YES");
			else
				System.out.println("NO");
					
			System.out.println("trace:");
			while(!trace.isEmpty()){
				System.out.println(trace.pop());
			}
				
			
		}

	}
	
	public static boolean ifFitT(Stack<String> trace,Coordinate[][] myco, Coordinate start, Coordinate door,int sum,int T) {
		
		int x=start.getX();
		int y=start.getY();
	
		/*--------------------奇偶剪枝开始------------------*/
		if((start.x+start.y+door.x+door.y)%2==0){ //奇偶性相同
			if((T-sum)%2!=0)
				return false;
		}else{        //奇偶性不同
			if((T-sum)%2==0)
				return false;
			
		}
		/*--------------------奇偶剪枝结束------------------*/
		
			
		//start变成了本来的上下左右其中一个点，  本来的点state置1
		
		
		for(int i=0;i<4;i++){
			if(i==0){
				if(start.canUp(myco)){
					start.setState(1);  
					System.out.println("let's go up");
					trace.push("let's go up!");
					start=myco[y-1][x];//改变位置
					sum++;
					System.out.println("sum="+sum);
					if(start==door&&sum==T){

						return true;  //先不管T  碰到就算对
					}
					
					boolean result=ifFitT(trace,myco,start,door,sum,T);
					if(result==false){
						start.setState(0);  //尝试的这一格重新状态置0
						start=myco[y][x];   //指针指回来
						sum--;
						trace.pop();
					}else if(result==true){
						return true;
					}
					
				}
			}
			else if(i==1){
				//System.out.println("****");
				if(start.canDown(myco)){
					start.setState(1);
					System.out.println("let's go down");
					trace.push("let's go down!");
					start=myco[y+1][x];
					sum++;
					System.out.println("sum="+sum);
					if(start==door&&sum==T){

						return true;
					
					}
					boolean result=ifFitT(trace,myco,start,door,sum,T);
					//if(result==false)continue;
					if(result==false){
						start.setState(0);
						start=myco[y][x];  //一旦爆炸，指针重新指回来
						sum--;
						trace.pop();
					}else if(result==true){
						return true;
					}
				}
			}
			else if(i==2){
				if(start.canLeft(myco)){
					start.setState(1);
					System.out.println("let's go left");
					trace.push("let's go left!");
					start=myco[y][x-1];
					sum++;
					System.out.println("sum="+sum);
					if(start==door&&sum==T){

						return true;
					}
					boolean result=ifFitT(trace,myco,start,door,sum,T);
					//if(result==false)continue;
					if(result==false){
						start.setState(0);
						start=myco[y][x];
						sum--;
						trace.pop();
					}else if(result==true){
						return true;
					}
				}
			}
			else if(i==3){
				if(start.canRight(myco)){
					start.setState(1);
					System.out.println("let's go right");
					trace.push("let's go right!");
					start=myco[y][x+1];
					sum++;
					System.out.println("sum="+sum);
					if(start==door&&sum==T){

						return true;
					}
					boolean result=ifFitT(trace,myco,start,door,sum,T);
					//if(result==false)continue;
					if(result==false){
						start.setState(0);
						start=myco[y][x];
						sum--;
						trace.pop();
					}else if(result==true){
						return true;
					}
				}
			}
			
			
			
			
		}
		//运行到这里，说明无路可走
		return false;
		

			
		
	}
		
		
}

class Coordinate{
	int x;
	int y;
	int state; //这个坐标的状态，没用过是0，用了是1.
	int flag; //1代表起点  2代表门  3代表不能用的   0代表能用的
	
	
	public Coordinate(int x, int y,char symbol) {
		super();
		this.x = x;
		this.y = y;
		if(symbol=='S')
			flag=1;
		else if(symbol=='D')
			flag=2;
		else if(symbol=='X')
			flag=3;
		else if(symbol=='.')
			flag=0;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", state=" + state + ", flag=" + flag + "]";
	}
	
	
	//这个格子可以走吗
	public boolean isAvailable(){
		if(state==1)
			return false;
		return true;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}
	//可以向上走吗
	public boolean canUp(Coordinate[][] myco){
		if(y==0)
			return false;
		else if(y>0){
			if(myco[y-1][x].isAvailable())
				return true;
			else
				return false;
		}
		
		return false;
	}
	//可以向下走吗
	public boolean canDown(Coordinate[][] myco){
		if(y==myco.length-1)
			return false;
		else if(y<=myco.length-2){
			if(myco[y+1][x].isAvailable())
				return true;
			else
				return false;
		}
		return false;
	}
	//可以向左走吗
	public boolean canLeft(Coordinate[][] myco){
		if(x==0)
			return false;
		else if(x>=1){
			if(myco[y][x-1].isAvailable())
				return true;
			else 
				return false;
		}
		return false;
	}
	//可以向右走吗
	public boolean canRight(Coordinate[][] myco){
		if(x==myco[0].length-1)
			return false;
		else if(x<=myco[0].length-2){
			if(myco[y][x+1].isAvailable())
				return true;
			else 
				return false;
		}
		return false;
	}
}