package day08_0705;
//day08-35-final�ؼ���
/*
 final�ؼ��֡�����
 	1.final���η������������࣬���η��������α���
 	
 	2.final���ε��಻���Ա��̳С�
 	
 	3.final���εķ��������Ա�����
 	
 	4.final���εı�������Ϊ��һ��������ֻ�ܸ�ֵһ�Ρ�
 	   ��ʹ�õ����ݲ���ʱ����Ҫ�����Ķ���ǿ����������ʾ�����ݣ���������final��
 	   ��final���εı��� ���ƹ淶�ǣ�������ĸ����д������ɶ��������ɣ���Ҫͨ���»��߽��зָ�
 */
class Fu3{  //����ķ������뱻��д���Ͳ�����̳С�final������������
	/*final*/ void show(){    //show���ܱ�����
		//���ʵ���ϵͳ������
	}
}
class Zi3 extends Fu3{
	static final int num=4;    //ͨ������.������������
	
	void show(){
		//
		final double PI=3.14;  //����		
		System.out.println(PI);
	}
}





public class FinalDemo {

	public static void main(String[] args) {
		new Zi3().show();
		System.out.println(Zi3.num);
	}

}

class Single{
	private static final Single SINGLE_INSTANCE=new Single();
	private Single(){}
	public static Single getInstance(){
		return SINGLE_INSTANCE;
	}
}
/*
class Single1{
	private static final Single1 s=null;    //���final �� ����
	private Single1(){}
	public static Single1 getInstance(){
		if(s==null)
			s=new Single1();
		return s;
	}
}
*/
