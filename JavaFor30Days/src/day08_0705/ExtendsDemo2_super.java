package day08_0705;
//day08-27-�̳��г�Ա�������ص㣬28-super

/*
 �Ӹ�����ֺ󣬴����ϵ�һЩ�ص㣺
 	
 	1.��Ա����
 	
 	2.��Ա����
 	
 	3.���캯��
 */
//��Ա������ע�����ԭ��
/*
 ���Ӹ����г�����ͬ���ĳ�Ա�������ùؼ���super�����֣�
 
 super��this���÷�������
 	this:������Ķ�������
 	super:���������Ƭ�ռ�
 */

class Fu{
	int num=4;
}
class Zi extends Fu{
	int num=5;
	void show(){
		int num=6;
		System.out.println("num="+num);             //�ֲ�����	
		System.out.println("num="+this.num);        //�����Ա����
		System.out.println("num="+super.num);     //�����Ա����
		System.out.println("this="+this);
		
		//System.out.println(super);  //����ʧ��
	}
}



public class ExtendsDemo2_super {
	public static void main(String[] args) {
		Zi z=new Zi();
		System.out.println("z="+z);
		z.show();
	}

}
