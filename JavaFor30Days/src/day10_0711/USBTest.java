package day10_0711;   //USB�ӿ���ϰ

/*
 �׶�һ���ʼǱ��������С��ʼǱ�����һ�����й��ܡ�
 
 �׶ζ�����ʹ��һ����ꡣ����һ������ʹ����ꡣ������һ��������
 
 �׶���������ʹ��һ�����̹��ܡ���Ҫ���һ�����ܡ�
 
 ���⣺ÿ��һ�����ܾ���Ҫ�ڱʼǱ������ж���һ����������չ�Բ  ��ô�������
 
 ������꣬���̵���Χ�豸�ͱʼǱ����Ե�����ԡ�
 */
/*
//�׶�һ�������ʼǱ�����
class NoteBook{
	public void run(){
		System.out.println("����");
	}
}
*/
/*
//�׶ζ�����Ҫһ����꣬˵���ʼǱ��ж���һ��ʹ�����Ĺ��ܡ�

//����һ���������
class Mouse{
	public void open(){  //��������
		System.out.println("mouse open");
	}
	public void close(){   //�رչ���
		System.out.println("mouse close");
	}
	
}
class NoteBook{
	public void run(){
		System.out.println("book run");
	}
	
	 //����ʹ����깦�ܣ���겻ȷ��������ɲ���
	 
	public void useMouse(Mouse m){
		//�ж�m����ָ��������
		if(m!=null){
		m.open();
		m.close();
		}
	}
}
*/
//�����������OK
//�׶������������ʹ�������豸�أ�������̣�����Ӳ��
//����ͨ���ʼǱ������м�������useKey()�ȷ��������
//���ǳ������⣺ÿ����һ���豸����Ҫ���ϵĸĶ��ʼǱ����е����ݡ���չ�Բά����Ҳ���á�

//���ڵ��豸�ǲ�ȷ���ģ�ÿ��һ���豸�ͼ�һ�����ܣ�˵���豸�ͱʼǱ��������̫ǿ
//��Ҫÿ�ζ���ľ�������ͣ�ֻҪ����һ�������ú��ڵ��豸�����������������ֻҪ��Թ���Ϳ�����

//java�п���ͨ���ӿڵ���ʽ����ɹ���Ķ��壬���н��

//������ƣ��ȶ������
interface USB{
	/**
	 �豸����
	 */
	public void open();
	/**
	 �豸�ر�
	 */
	public void close();
	
}
class NoteBook{
	/**
	 ����
	 */
	public void run(){
		System.out.println("book run");
	}
	/**
	 ʹ�÷��Ϲ������Χ�豸
	 */
	public void useUSB(USB usb){     //������һ���ӿ����͵�����   //USB usb=new MouseByUB(); ��̬
		if(usb!=null){
			usb.open();
			usb.close();
		}
	}
}
//һ����뻻����ꡣֻҪ��һ�����Ϲ������꣬�ʼǱ����ԾͿ�����
class MouseByUSB implements USB{
	public void open(){
		System.out.println("mouse open");
	}
	public void close(){
		System.out.println("mouse close");
	}
}
//��Ҫ����
class KeyByUSB implements USB{
	public void open(){
		System.out.println("key open");
	}
	public void close(){
		System.out.println("key close");
	}
}


public class USBTest {
	public static void main(String[] args) {
		NoteBook book=new NoteBook();
		book.run();
		//book.useMouse(new Mouse());
		book.useUSB(new MouseByUSB());
		book.useUSB(new KeyByUSB());
	}

}
