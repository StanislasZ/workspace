package demo;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Demo_P223 {

	public static void main(String[] args){
		
		ActionListener listener=new TimePrinter();   //����һ����������ͬʱ���� ����ʱ�Ķ���
		
		Timer t=new Timer(5000,listener);   //���嶨ʱ��
		t.start();  //������ʱ��
		
		JOptionPane.showMessageDialog(null, "Quit program?");   //����һ�����ڣ����ǲ���Ҫ�رճ���
		System.exit(0);
		
	}
}
class TimePrinter implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("At the tone,the time is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}
}