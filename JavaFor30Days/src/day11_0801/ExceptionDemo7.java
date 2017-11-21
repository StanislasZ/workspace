package day11_0801;//�������쳣��ʹ��

/*
 Exception
 	|--AException
 		|--AAException
 	|--BException
 
 ����ʱ��
 ���෽�����Ǹ��෽��ֻ���׳����෽���쳣���߸��쳣�����ࡣ
 ������෽���׳�����쳣������ֻ���׳������쳣���Ӽ���
 
 ԭ��������쳣����Ҫ�ڸ�����쳣��������С�
 
 ע�⣺��һ�������ֻ��try����throws
 	�����ǵķ���û���׳��쳣����ô�����ڸ���ʱ�����෽���з������쳣����ֻ��try���޷�throws����
 
 interface Inter{
	void show();

 }
 class Demo implements Inter{
 	public void show(){
 		try{
 			throw new Exception();
 		}
 		catch(Exception e){
 			throw new RuntimeException("");//������ʱ����쳣��ת��������ʱ�쳣�������Ͳ���������
 		}
 	}
 }
 
 
 *
 */



class AException extends Exception{
	
}
class BException extends Exception{
	
}
class AAException extends AException{
	
}
class Fu{
	void show() throws AException{
		System.out.println("fu show");
	}
}
class Zi extends Fu{
	void show() throws AAException{
		System.out.println("zi show");
	}
}

class Tool{
	void method(Fu f){
		try{
			f.show();
		}
		catch(AException e){
			
		}
	}
}





public class ExceptionDemo7 {
	public static void main(String[] args) {
		Tool t=new Tool();
		t.method(new Zi());  //�ʼ�07.12��̬����Ա���������п��ұ�

	}

}
