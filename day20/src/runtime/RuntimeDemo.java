package runtime;

import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 单例模式的对象Runtime
		 */
		Runtime r=Runtime.getRuntime();
		
		//r.exec("matlab.exe");  //打开matlab
		
		r.exec("notepad D:\\eclipse\\workspace\\day20\\集合框架_3.txt");   
		//有种桥梁的感觉？   可以调起windows中其他程序
		
		//可以做一个图形化界面，弄一个按钮，按一下就调出qq

		r.exec("matlab ");
	}

}
