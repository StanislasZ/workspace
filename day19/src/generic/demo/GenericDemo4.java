package generic.demo;

import domain.Student;
import domain.Worker;

public class GenericDemo4 {

	public static void main(String[] args) {
		
//		Tool tool=new Tool();
//		
//		tool.setObj(new Student());   //��̬��
//		Student stu=(Student)tool.getObj();  //ȡҪ����ת��
//		
//		System.out.println(stu);
		
		Util<Student> util=new Util<Student>();
		util.setObj(new Student());              //���дWorkerֱ�ӱ��뱨�� 
		Student stu=util.getObj();  //����������ת��
		System.out.println(stu);
		
		
		
	}

}
/*
 * ����һ�����ڲ���Student����Ĺ����࣬�� ���� �������úͻ�ȡ��
 * ̫�о������ˣ��ɲ����Զ���һ�����Բ������ж���Ĺ����أ�
 * �������ϳ�ȡ����Ҫ�����Ķ������Ͳ�ȷ����ʱ��Ϊ����չ
 * ����ʹ��Object���������
 * �������ַ����б׶ˣ������ת�ͣ�����ת������������ʱ�ڷ���ClassCastException
 * 
 * jdk1.5�Ժ��µĽ������
 * ���Ͳ�ȷ��ʱ�����Զ����ṩ��������ʹ����ͨ�����ݲ�������ʽ������͵�ȷ��
 */


//���ඨ��ʱ����ȷ��������ʹ�ø���ĵ����ߣ������ݾ�������͡�
class Util<W>{  //������
	private W obj;

	public W getObj() {
		return obj;
	}

	public void setObj(W obj) {
		this.obj = obj;
	}
	
}




//jdk1.4

class Tool{
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
