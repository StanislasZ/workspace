package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import comparator.ComparatorByName;
import domain.Student;

public class TreeSetDemo2 {

	public static void main(String[] args) {
		
		//初始化TreeSet集合明确一个比较器 
		Set set=new TreeSet(new ComparatorByName());
		
		
		
		
		set.add(new Student("wangcai",27));
		set.add(new Student("xiaoming",22));
		set.add(new Student("zzz",22));
		
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu=(Student)it.next();
			System.out.println(stu.getName()+"::"+stu.getAge());
			
		}

	}

}
