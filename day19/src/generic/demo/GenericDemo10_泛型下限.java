package generic.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import domain.Person;
import domain.Student;
import domain.Worker;

public class GenericDemo10_�������� {

	public static void main(String[] args) {
		/*
		 * ��ʾ�����޶���api������
		 * TreeSet�Ĺ��캯��
		 * TreeSet(Comparator<? super E> comparator)
		 * ʲôʱ���õ������أ�
		 * 
		 * ����������ȡ��Ԫ��ʱ��������E��E�ĸ���ӿ�
		 */
		
		//����һ���Ƚ�����
		Comparator<Person> comp=new Comparator<Person>(){    //�����ڲ���,  Person

			@Override
			public int compare(Person o1, Person o2) {
				int temp=o1.getAge()-o2.getAge();
				return temp==0?o1.getName().compareTo(o2.getName()):temp;
			}
			
		};
		

		TreeSet<Student> ts=new TreeSet<Student>(comp);
		ts.add(new Student("abc1",21));
		ts.add(new Student("abc2",26));
		ts.add(new Student("abc3",23));
		ts.add(new Student("abc4",2));
		
		TreeSet<Worker> ts1=new TreeSet<Worker>(comp);
		ts1.add(new Worker("ddd",11));
		ts1.add(new Worker("ded",21));
		ts1.add(new Worker("dfd",31));
		ts1.add(new Worker("dgd",9));
		
		
		
		for (Iterator<Student> it = ts.iterator(); it.hasNext();) {
			Student student = it.next();
			System.out.println(student);
		}
		
		for (Iterator<Worker> it = ts1.iterator(); it.hasNext();) {
			Worker w = it.next();
			System.out.println(w);
		}
		
		
	}

}

class YouTreeSet<E>{
	
	YouTreeSet(Comparator<? super E> comparator){
		
	}
}











