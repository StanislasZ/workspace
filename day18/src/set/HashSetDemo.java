package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
	
	public static void main(String[] args){
		
		//1.创建一个Set容器对象
		Set set=new HashSet();
		
		//2.添加元素
		set.add("haha");
		set.add("abc");
		set.add("nba");
		set.add("heihei");
		set.add("heihei");
		
		//3.只能用迭代器取出
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
