package generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import domain.Student;

public class GenericDemo7 {

	public static void main(String[] args) {

		List<Student> list=new ArrayList<Student>();
		
		list.add(new Student("abc1",21));
		list.add(new Student("abc2",22));
		list.add(new Student("abc3",23));
		
		
		printCollection(list);
		
		Set<String> set=new HashSet<String>();
		set.add("haha");
		set.add("xixi");
		set.add("heihei");
		
		printCollection(set);

	}

	private static void printCollection(Collection<?> coll) {  //在不明确具体类型的情况下，可以使用通配符来表示
		for (Iterator<?> it = coll.iterator(); it.hasNext();) {
			Object obj = it.next();
			System.out.println(obj);
		}
	}

}
