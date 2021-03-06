package demo;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaDemo_P233 {

	public static void main(String[] args) {
		
		String[] planets=new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dictionary order:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length");
		
		Arrays.sort(planets,(first,second)->first.length()-second.length());   //lambda表达式
		System.out.println(Arrays.toString(planets));

		Timer t=new Timer(1000,(event)->
			System.out.println("The time is "+new Date()));    //用lambda简洁了很多。
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
		
	}

}
