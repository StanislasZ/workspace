//���ļ���87ҳ ��ά����
public class P87moneytable {

	public static void main(String[] args) {
		final double startrate=10;
		final int nrates=6;
		final int nyears=10;
		
		double[] interestrate=new double[nrates];    //������һά���� 6��Ԫ��
		for(int j=0;j<interestrate.length;j++)
			interestrate[j]=(startrate+j)/100.0;
		
		double[][] balances=new double[nyears][nrates];
		
		for(int j=0;j<balances[0].length;j++)
			balances[0][j]=10000;                     //��һ�ж���10000
		
		//����ÿһ��
		for(int i=1;i<balances.length;i++){
			for(int j=0;j<balances[i].length;j++)
				balances[i][j]=balances[i-1][j]+balances[i-1][j]*interestrate[j];//ĳһ��=��һ��+��һ��*���е�����
		}
		
		for(int j=0;j<interestrate.length;j++)
			System.out.printf("%9.0f%%", 100*interestrate[j]);        //����%���ʱΪһ��%
		System.out.println();
		
		for(double[] row:balances){
			for(double element:row)
				System.out.printf("%10.2f", element);                       // ����9����һ��%=10
			System.out.println();
	
			
			
		}
	
	
		

	}

}
