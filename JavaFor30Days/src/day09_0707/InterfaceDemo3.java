package day09_0707;
//day09-45-�ӿ�-�����˵��̳еľ�����

class Fu{
	void show(){
		System.out.println("fu show");
	}
}
interface Inter2{
	void show1();
}

/*��Ϊ�̳�Zi�߱���������ϵ�����˸���ϵ�Ļ�������
	������չһЩ���ܣ��߱�show1����
	һ����̳�һ�����ͬ�£�������ʵ�ֶ���ӿڡ�
	�����˵��̳еľ����ԡ�
	
	�̳���Ϊ����ϵ�Ļ������ܡ���Ҫ��չ���ܿ���ͨ��ʵ�ֽӿ�����ɡ�
*/
class Zi extends Fu implements Inter2{ 
	public void method(){
		System.out.println("zi method");
	}
	public void show1(){
		System.out.println("zi show1");
	}
}



public class InterfaceDemo3 {
	public static void main(String[] args) {
		Zi z=new Zi();
		z.show();
		z.method();

	}

}
