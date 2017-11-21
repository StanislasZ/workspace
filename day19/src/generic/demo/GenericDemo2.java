package generic.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo2 {

	public static void main(String[] args) {
		
		//创建一个List集合。存储整数 
		List<Integer> list=new ArrayList<Integer>();

		list.add(5);   //5自动装箱
		list.add(6);  
		list.add(7); 
		
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());  //不用强转了
			
		}
		
	}

}
