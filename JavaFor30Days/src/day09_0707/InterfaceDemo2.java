package day09_0707;
//day09-44-�ӿڶ�ʵ��

/*
�ӿڽ����ʲô�����أ� 
*/

//��̳С��ô�������������߱�����Ĺ��ܡ��׶ˣ����õĲ�ȷ����
/*
class Fu1{
	void show(){
		sop("fu1 show");
	}
}
class Fu2{
	void show(){
		sop("fu2 show");
	}
}
class Zi extends Fu1,Fu2{

}

Zi z= new Zi();
z.show();  //�����˵��õĲ�ȷ���ԡ�ԭ�����ڷ����������ݲ�ͬ��

Java�в�ֱ��֧�ֶ�̳У����ǶԸû��ƽ��и�����	
	ͨ���ӿ������������������̳�ת�����˶�ʵ��

 
 
*/
/*
interface InterA{   //�ӿڶ��幦�ܣ�����զ��������ȥ��
	void show1();
}
interface InterB{
	void show2();
}
class SubInter implements InterA,InterB{    //��ʵ��
	public void show1(){
		System.out.println("inter show1");
	}
	public void show2(){
		System.out.println("inter show2");
	}
}
*/
interface InterA{   //�ӿڶ��幦�ܣ�����զ��������ȥ��
	void show();
}
interface InterB{
	void show();
}
class SubInter implements InterA,InterB{    //��ʵ��
	public void show(){
		System.out.println("inter show");
	}
	
}



public class InterfaceDemo2 {
	public static void main(String[] args) {
		SubInter in=new SubInter();
//		in.show1();
//		in.show2();
		in.show();   //���е��Ǹ��ǵķ����������˵��õĲ�ȷ����
		

	}

}
