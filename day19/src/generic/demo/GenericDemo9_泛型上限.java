package generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import domain.Person;
import domain.Student;

public class GenericDemo9_�������� {

	public static void main(String[] args) {
		
		/*
		 * ��ʾ�����޶���api�е�����
		 * TreeSet�Ĺ��캯��
		 * TreeSet(Collection<? extends E> coll)
		 * 
		 * ʲôʱ���õ������أ�
		 * һ�������ϴ洢Ԫ��ʱ��������϶�����E����ͨ�������Ӧ�ô洢E���͵Ķ���
		 * ��E������Ķ���Ҳ���Խ��ܡ�������ʱ���Խ����ʹ�E��Ϊ? extends E
		 */
		Collection<Student> coll=new ArrayList<Student>();
		coll.add(new Student("abc1",21));
		coll.add(new Student("abc2",22));
		coll.add(new Student("abc3",23));
		
		
		TreeSet<Person> ts=new TreeSet<Person>(coll);
		ts.add(new Person("abbb",222));
		
		for (Iterator<Person> it = ts.iterator(); it.hasNext();) {
			Person person = it.next();
			System.out.println(person.getName());
		}
		

	}

}

class MyTreeSet<E>{
	MyTreeSet(){
		
	}
	MyTreeSet(Collection<? extends E> c){
		
	}
	
	
	
}




