package day10_0711;     //54-��̬�г�Ա�����ĵ��ã�55-��Ա����

/*
 ��̬�жԳ�Ա�ĵ��á�
 	1.��Ա����
 		���Ӹ������ͬ����Ա����ʱ��
 			�ڶ�̬����ʱ��ֻ�����øó�Ա�������������������еĳ�Ա������
 			��˵�����۱���������У������Ⱥŵ���ߣ�������
 	
 	2.��Ա����
 		����һģһ������ʱ
 			��̬���ã�����ʱ���������ñ������������еķ�����
 					  ����ʱ�����Ƕ������������еķ�����
 			��˵�����뿴��ߣ������ұߡ�
 			
 			��Ա������̬�󶨵���ǰ�����ϡ�
 			
 	3.��̬����
 		����һģһ������ʱ��
 			��̬���ã�����͵���ʱ�����ñ������������еķ���
 			��˵���������п���ߡ�
 			
 			�������þ�̬�����ǲ���Ҫ����ġ�ֱ���������á�
 			
 			�������������������������
 
 */
class Fu{
	int num=4;
	void show(){
		System.out.println("fu show");
	}
	static void staticMethod(){
		System.out.println("fu static method");
	}
}
class Zi extends Fu{
	int num=6;
	void show(){
		System.out.println("zi show");
	}
	static void staticMethod(){
		System.out.println("zi static method");
	}
}


public class DuoTaiDemo3 {
	public static void main(String[] args) {
//   	==========��Ա����=====================
//		Fu f=new Fu();
//		f.num=8;
//		
//		Zi z=new Zi();
//		System.out.println(z.num);
		

//		Fu f=new Zi();
//		System.out.println(f.num);  //f������Ϊ��Fu�����õ���Fu���num
	
//		==========��Ա����====================
//		Fu f=new Zi();
//		f.show();       //���Ϊzi show(���ǣ�
		
//===============��̬����========================
		Fu f=new Zi();
		f.staticMethod();       
	
		Zi z=(Zi)f;
		z.staticMethod();
	}

}
