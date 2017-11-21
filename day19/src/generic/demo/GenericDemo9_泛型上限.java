package generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import domain.Person;
import domain.Student;

public class GenericDemo9_泛型上限 {

	public static void main(String[] args) {
		
		/*
		 * 演示泛型限定在api中的体现
		 * TreeSet的构造函数
		 * TreeSet(Collection<? extends E> coll)
		 * 
		 * 什么时候用到上限呢？
		 * 一般往集合存储元素时。如果集合定义了E类型通常情况下应该存储E类型的对象。
		 * 对E的子类的对象也可以接受。所以这时可以将泛型从E改为? extends E
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




