package demo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Demo_innerclass_P246 {

	public static void main(String[] args) {
		
		TalkingClock clock=new TalkingClock(1000,true);
		clock.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);

	}

}
class TalkingClock{
	private int interval;
	private boolean beep;
	public TalkingClock(int interval, boolean beep) {
		super();
		this.interval = interval;
		this.beep = beep;
	}
	public void start(){
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval,listener);
		t.start();
	}
	public class TimePrinter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("At the tone,the time is "+new Date());
//			if(beep) Toolkit.getDefaultToolkit().beep();
			if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
		}
		
	}
	
}