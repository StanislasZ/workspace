package day11_0801;  //09-�Զ����쳣

/*
 ���Զ���ĳ����У�����������⣬Ҳ������java�е��쳣һ�������������������
 
 ������
 	����һ�����ܿ���ʵ�ֳ������㣬���ǳ���������Ϊ������
 */
//������Ϊ��������������
class FushuException extends RuntimeException{
	FushuException(){
		super();
	}
	
	FushuException(String message){
		super(message);   //���ϴ���
	}
}

class Demo3{
	int div(int a,int b){
		if(b<0)
			throw new FushuException("����������������");
		if(b==0)
			throw new ArithmeticException("��0����");
		
		
		return a/b;
	}
}


public class ExceptionDemo4 {
	public static void main(String[] args) {
		Demo3 d=new Demo3();
		try{
			int num=d.div(4, -1);
			System.out.println("num="+num);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("over");
	}

}