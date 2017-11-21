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
		
		set.add(new Student("xiaoqiang",20));  //ѧ��Ҫ���򣬾���Ҫ�Ƚϡ���û�ж���ȽϷ����������޷��������
		
		/*
		 * �Ƚ�add������ʹ�õ���Comparable�ӿڵıȽϷ���
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
