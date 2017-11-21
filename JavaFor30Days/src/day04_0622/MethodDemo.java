package day04_0622;
//day04-01-函数（启发式定义）
public class MethodDemo {

	public static void main(String[] args) {
		
		//调用自定义的方法。
		draw(1,5);
		
	}
	
	/*
	 问题：要画矩形，需要不断使用该for嵌套代码，造成代码复用性很差
	 解决：定义一个功能用于画矩形，每次只要使用该功能即可。
	 
	 如何定义一个功能呢
	 1.它应该是一个封闭的区间。就是大括号。与main是同级别的！
	 2.她需要有名称
	 3.需要有参与运算的数据
	 4.需要定义该功能的结果类型
	 	 
	 */
	
	public static void draw(int row,int column){    //必须加static，否则调用时会提示：不能对类中的非静态方法进行静态引用
		if(row<0||column<0)return;
		for(int x=0;x<row;x++){
			for(int y=0;y<column;y++){
				System.out.print("*");
			}
			System.out.println();
		} 
	}
	
	
	
	
	
	

}
