package day11_0801;

/*
 С�ڣ�
 	�쳣���������װ�ɶ��󣬲��׸������ߡ�
 		  ��������ˣ�����Ҫ�����ߴ�����������or����
 		  ʲôʱ��������ʲôʱ�򲶻�
 		  �����ڲ����Խ�����Ͳ���   ����˻�������ߵ�����������ʱ��Ӧ������
 
 ������
 	����ʦ�õ����ϿΡ� 
 	
 	�Ͽι����лᷢ�����⣬���磺��������������ð���ˡ�
 	��Ҫ�������������
 
 */

class LanpingException extends Exception{   //����
	LanpingException(){
		super();
	}
	LanpingException(String message){
		super(message);
	}
}
class MaoyanException extends Exception{    //ð��
	MaoyanException(){
		super();
	}
	MaoyanException(String message){
		super(message);
	}
}
class NoplanException extends Exception{
	NoplanException(){
		super();
	}
	NoplanException(String message){
		super(message);
	}
}


class Computer{
	private int state=2;  
	public void run() throws LanpingException,MaoyanException{
		if(state==1)
			throw new LanpingException("����������");
		if(state==2)
			throw new MaoyanException("����ð����");
		System.out.println("��������");
	}
	public void reset(){
		state=0;
		System.out.println("��������");
	}
}
class Teacher{
	private String name;
	private Computer comp;
	Teacher(String name){
		this.name=name;
		comp=new Computer();
	}
	//����
	public void prelect() throws NoplanException{
		try{
			comp.run();
			System.out.println("����");
		}
		catch(LanpingException e){
			System.out.println(e.toString());
			comp.reset();   //�����
			//��������
			prelect();
		}
		catch(MaoyanException e){   //MaoyanException e=MaoyanException();
			System.out.println(e.toString());
			test();//�൱��û����
			//throw e;   //������ˣ�������
			throw new NoplanException("��ʱ����ֹͣ");//������ת���쳣����������
		}
		
	}
	public void test(){
		System.out.println("����ϰ");
	}
}

public class ExceptionTest {
	public static void main(String[] args) {
		Teacher t=new Teacher("����ʦ");
		try{
			t.prelect();
		}
		catch(NoplanException e){
			System.out.println(e.toString());
			System.out.println("����ʦ");
		}
	}

}



/*
 class APP{
 	public void show()	{
 		try{
 			new DBTool().operate();
 		}
 		catch(SQLException e){
 			
 		}
 	
 	
 	}
 
 
 
 }
 class DBTool{
 	public void operate() throws NovalueException{
 		//�������ݿ�
 		 try{
 		 
 		 }
 		 //���ݲ��� throw new SQLException()
 		 catch(SQLException e){
 		 	//��������ݿ��쳣
 		 	 throw new NovalueException();
 		 }
 		 
 		 fianlly{
 			//�ر����ݿ�
 		 }
 	
 	}
 
 
 
 
 }
 
 
 
 
 
 
 
 */













