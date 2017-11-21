package generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import domain.Person;
import domain.Student;
import domain.Worker;

public class GenericDemo8 {

	public static void main(String[] args) {
		
List<Student> list=new ArrayList<Student>();
		
		list.add(new Student("abc1",21));
		list.add(new Student("abc2",22));
		list.add(new Student("abc3",23));
		
		
		printCollection(list);
		
		Set<Worker> set=new HashSet<Worker>();
		set.add(new Worker("haha",23));
		set.add(new Worker("xixi",24));
		set.add(new Worker("hoho",25));

		
		printCollection(set);
		


	}
	/*
	 * ���͵��޶���
	 * ? extends E: ����E��E������
	 * ? super E:����E����E�ĸ���
	 */
	private static void printCollection(Collection<? extends Person> coll) {  //�ڲ���ȷ�������͵�����£�����ʹ��ͨ�������ʾ
		for (Iterator<? extends Person> it = coll.iterator(); it.hasNext();) {
			Person p = it.next();   //�����Object��������Person�����з���
			System.out.println(p);
		}
	}

}
