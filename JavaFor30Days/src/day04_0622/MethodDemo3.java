package day04_0622;
//day04-05-�������أ�overload��
public class MethodDemo3 {

	public static void main(String[] args) {
		
		int sum=add(1,2,3);
		System.out.println("sum="+sum);
        int sum2=add(1,2);
        System.out.println("sum2="+sum2);

        printCFB();
        printCFB(5);
	}
	
	//�������������Ϊ�������ù��ܡ�
	
	
	//����������͵Ĺ��ܡ�
	public static int add(int a,int b){
		return a+b;
	}
	
	//����������͵Ĺ��ܣ�Ҳ����ȡ��add����Ϊ����������ͬ��ϵͳ�Կ�������(���Ͳ�ͬҲ���ԣ�
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	
    //����С���ĺ�
	public static double add(double a,double b){
		return a+b;
	}
	
	//�žų˷���
	public static void printCFB(){
		printCFB(9); 
	}
	
	public static void printCFB(int num){
		for(int i=1;i<=num;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
	}

	
	
	
	
	
	
}
