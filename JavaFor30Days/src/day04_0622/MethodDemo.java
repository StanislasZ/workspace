package day04_0622;
//day04-01-����������ʽ���壩
public class MethodDemo {

	public static void main(String[] args) {
		
		//�����Զ���ķ�����
		draw(1,5);
		
	}
	
	/*
	 ���⣺Ҫ�����Σ���Ҫ����ʹ�ø�forǶ�״��룬��ɴ��븴���Ժܲ�
	 ���������һ���������ڻ����Σ�ÿ��ֻҪʹ�øù��ܼ��ɡ�
	 
	 ��ζ���һ��������
	 1.��Ӧ����һ����յ����䡣���Ǵ����š���main��ͬ����ģ�
	 2.����Ҫ������
	 3.��Ҫ�в������������
	 4.��Ҫ����ù��ܵĽ������
	 	 
	 */
	
	public static void draw(int row,int column){    //�����static���������ʱ����ʾ�����ܶ����еķǾ�̬�������о�̬����
		if(row<0||column<0)return;
		for(int x=0;x<row;x++){
			for(int y=0;y<column;y++){
				System.out.print("*");
			}
			System.out.println();
		} 
	}
	
	
	
	
	
	

}
