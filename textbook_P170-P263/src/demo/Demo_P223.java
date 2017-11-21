package demo;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Demo_P223 {

	public static void main(String[] args){
		
		ActionListener listener=new TimePrinter();   //定义一个监听器，同时定义 发生时的动作
		
		Timer t=new Timer(5000,listener);   //定义定时器
		t.start();  //启动定时器
		
		JOptionPane.showMessageDialog(null, "Quit program?");   //出现一个窗口，问是不是要关闭程序
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