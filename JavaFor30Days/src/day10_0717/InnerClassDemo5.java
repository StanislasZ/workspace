package day10_0717;   //65-�����ڲ�����ϰ

class Outer5{
	
//	class Inner extends Object{
//		
//	}
	public void method(){
		//����һ
		new Object(){      
			public void show(){
				System.out.println("show run");
			}
		}.show();            //ֱ��new��һ��������������������Ͳ���Object
		
		//������
		Object obj=new Object(){    //Object objָ�����Լ���������󡣵�ͬʱ�������ǿ��������Ϊ��Object   ����̬���Ͳ��ܵ�����������з���
			public void show(){
				System.out.println("show run");
			}
		};
		//obj.show();    //���󡣷������Ƕ�̬�Ͳ��ܵ�����������з���
	}
}



public class InnerClassDemo5 {
	public static void main(String[] args) {
		

	}

}
