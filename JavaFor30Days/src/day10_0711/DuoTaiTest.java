package day10_0711;    //52(2)-��̬��ϰ

/*
 ����ү    ����  ����
 ����ʦ extends ����ү
 	����
 	����Ӱ
 Ҫ�����ֶ�̬��   Ҫ��������ת�ͣ�����ת��
 */

//��������ү
class ����ү{
	public void teach(){
		System.out.println("����");
	}
	public void fish(){
		System.out.println("����");
	}
}
class ����ʦ extends ����ү{
	public void teach(){
		System.out.println("����");  //����
	}
	public void movie(){
		System.out.println("����Ӱ");   
	}
}


public class DuoTaiTest {
	public static void main(String[] args) {
		����ү x=new ����ʦ();    //����ת��
		x.teach();
		x.fish();
		
		//Ҫ��ʹ�ñ���ʦ�����з���  ����Ӱ��
		����ʦ y=(����ʦ)x;      //����ת��
		y.movie();

		//ת�͹����У���ʼ���գ�ֻ������������������͵ı仯��
	}

}
