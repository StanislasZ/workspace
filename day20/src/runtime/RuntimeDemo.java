package runtime;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * ����ģʽ�Ķ���Runtime
		 */
		Runtime r=Runtime.getRuntime();
		
		//r.exec("matlab.exe");  //��matlab
		
		r.exec("notepad D:\\eclipse\\workspace\\day20\\���Ͽ��_3.txt");   
		//���������ĸо���   ���Ե���windows����������
		
		//������һ��ͼ�λ����棬Ūһ����ť����һ�¾͵���qq

		r.exec("matlab ");
	}

}
