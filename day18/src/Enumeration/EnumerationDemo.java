package Enumeration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		
		/*
		 * Enumeration：枚举
		 * 具备枚举取出方式的容器只有Vector
		 */

		Vector v=new Vector();
		
		v.add("abc1");
		v.add("abc2");
		v.add("abc3");
		v.add("abc4");
		
//		Enumeration en=v.elements();
		
//		while(en.hasMoreElements()){
//			System.out.println(en.nextElement());
//		}
		
		//获取枚举（现在不用了）
		for(Enumeration en=v.elements();en.hasMoreElements();)
			System.out.println("Enumeration"+en.nextElement());
		
		//获取迭代（好）
		for (Iterator it = v.iterator(); it.hasNext();) {
			System.out.println("iterator:"+it.next());
		}
		
		//高级for
		for(Object obj:v){
			System.out.println("foreach"+obj);
		}
		
	}

}
