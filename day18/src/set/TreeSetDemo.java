package set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import domain.Student;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		Set set=new TreeSet();
		/*
		set.add("abc");
		set.add("nba");
		set.add("haha");
		set.add("heihei");
		set.add("heihei");
		set.add("00");
		*/
		
		set.add(new Student("xiaoqiang",20));  //学生要排序，就需要比较。而没有定义比较方法，所以无法完成排序
		
		/*
		 * 比较add方法中使用的是Comparable接口的比较方法
		 */
		
		set.add(new Student("wangcai",27));
		set.add(new Student("xiaoming",22));
		set.add(new Student("zzz",22));
		
		
		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu=(Student)it.next();
			System.out.println(stu.getName()+"::"+stu.getAge());
			
		}

	}

}
