package demo;   //::������ 

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Demo_P236 {

	public static void main(String[] args) {
		
		TimedGreeter tg=new TimedGreeter();
		tg.greet();
	}

}

class Greeter{
	public void greet(){
		System.out.println("hello world");
	}
}
class TimedGreeter extends Greeter{
	public void greet(){
		Timer t=new Timer(1000,(event)->super.greet());
	//	Timer t=new Timer(1000,super::greet);
		
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");  //û�����к���һ�У��Ͳ����ӡhello world Ϊʲô��������
		System.exit(0);
	}

}