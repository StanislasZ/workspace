package day05_0628;
//day06-15
/*
public class Demo {

	public static void main(String[] args) {
		int x=0;
		show(x);   
		System.out.println("x="+x);
	}
	
	public static void show(int x){
		x=5;                      //�����xֻ����show�Ĵ�����
	}

}
*/

public class Demo { //public��д�Ļ���Ĭ��public
	int x=6;
	public static void main(String[] args) {
		Demo d=new Demo();
		d.x=8;
		//show(d);   //����ĳ� show(new Demo());����ǣ�
		show(new Demo()); 
		System.out.println("x="+d.x);
	}
	
	public static void show(Demo d){
		d.x=5;                      
	}

}