package recursion;

public class RecursionDemo {

	public static void main(String[] args) {
		/*
		 * �ݹ飺��������������������ڲ���ʹ�õ��˸ú������ܡ�
		 * ʲôʱ��ʹ�ã�
		 * ���ܱ��ظ�ʹ�ã�����ÿ�θù���ʹ�ò�����������ݲ�ͬʱ�����Կ��ǵݹ鷽ʽ���
		 * 
		 * ʹ��ʱ��һ��Ҫ��������
		 * 
		 * 
		 */
		int num=getSum(3);
		System.out.println("sum="+num);  //3+2+1
	}

	public static int getSum(int num){
		if(num==1)
			return 1;
		return num+getSum(num-1);
	}
	
	
}
