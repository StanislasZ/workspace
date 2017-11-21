package someproblem;

import java.util.Scanner;
import java.util.Stack;

public class Problem1010 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int N,M,T;
		while(!((N=in.nextInt())==0&(M=in.nextInt())==0&(T=in.nextInt())==0)){
			
			Stack<String> trace=new Stack<>();
			//��ȡ�ĸ����ţ��ĸ�����㣬�ĸ��ǲ����ã��ĸ�������
			//��ɨ�裬ÿ��λ�õ�Coordinate��ȷ��
			Coordinate[][] myco=new Coordinate[N][M];
			Coordinate start = null,door=null;		
			
			/*---------------------�����ʼ����ʼ--------------------*/
			for(int i=0;i<N;i++){
				String str=in.next();
				for(int j=0;j<M;j++){
					char c=str.charAt(j);
					myco[i][j]=new Coordinate(j,i,c);  //�������꣬���ͣ�ʹ�ñ�־ ����ȷ��
					if(c=='S'){
						start=myco[i][j];
						start.setState(1);//��㱻����
					}
					else if(c=='D'){
						door=myco[i][j];
					}
					else if(c=='X'){
						myco[i][j].setState(1); //�ϰ���͵��ɱ��ù���
					}
				}
			}
			/*---------------------�����ʼ������-----------------------*/
			
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
	
		/*--------------------��ż��֦��ʼ------------------*/
		if((start.x+start.y+door.x+door.y)%2==0){ //��ż����ͬ
			if((T-sum)%2!=0)
				return false;
		}else{        //��ż�Բ�ͬ
			if((T-sum)%2==0)
				return false;
			
		}
		/*--------------------��ż��֦����------------------*/
		
			
		//start����˱�����������������һ���㣬  �����ĵ�state��1
		
		
		for(int i=0;i<4;i++){
			if(i==0){
				if(start.canUp(myco)){
					start.setState(1);  
					System.out.println("let's go up");
					trace.push("let's go up!");
					start=myco[y-1][x];//�ı�λ��
					sum++;
					System.out.println("sum="+sum);
					if(start==door&&sum==T){

						return true;  //�Ȳ���T  ���������
					}
					
					boolean result=ifFitT(trace,myco,start,door,sum,T);
					if(result==false){
						start.setState(0);  //���Ե���һ������״̬��0
						start=myco[y][x];   //ָ��ָ����
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
						start=myco[y][x];  //һ����ը��ָ������ָ����
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
		//���е����˵����·����
		return false;
		

			
		
	}
		
		
}

class Coordinate{
	int x;
	int y;
	int state; //��������״̬��û�ù���0��������1.
	int flag; //1�������  2������  3�������õ�   0�������õ�
	
	
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
	
	
	//������ӿ�������
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
	//������������
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
	//������������
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
	//������������
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
	//������������
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