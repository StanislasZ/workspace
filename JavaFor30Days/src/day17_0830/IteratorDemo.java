package day17_0830;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		//1.创建集合
		Collection c=new ArrayList();
		
		c.add("abc1");
		c.add("abc2");
		c.add("abc3");
		c.add("abc4");

		//获取该容器的迭代器
		//Iterator it=c.iterator();
		
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		
		for(Iterator it=c.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
	}

}
