package generic.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
		
		//为了运行时不出现类型异常，在定义容器时，就明确容器中元素的类型。
		List<String> list=new ArrayList<String>();
		
		list.add("abc");
	//	list.add(4);    //class文件中变成了list.add(Integer.valueOf(4));     自动装箱
		
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			
			String str=it.next();
			
			System.out.println(str.length());
			
			//System.out.println(it.next().toString());
		}
		
		
	}

}
