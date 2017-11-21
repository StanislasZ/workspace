package generic.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import comparator.ComparatorByName;
import domain.Person;

public class GenericDemo3 {

	public static void main(String[] args) {
		
		Set<Person> set=new TreeSet<Person>();   //按年龄，若相同按姓名的字典顺序
				
		set.add(new Person("abcd",20));
		set.add(new Person("aa",26));
		set.add(new Person("nba",22));
		set.add(new Person("cba",24));
		
		for(Person p:set){
			//System.out.println(p);
		}
//*************************************************************************************************************************		
		Set<Person> set2=new TreeSet<Person>(new ComparatorByName());  //按姓名字典顺序，若相同按年龄
		set2.add(new Person("abcd",20));
		set2.add(new Person("aa",26));
		set2.add(new Person("nba",22));
		set2.add(new Person("cba",24));
			
		for(Person p:set2){
			//System.out.println(p);
		}
//****************************************************************************************************************
		Set<Person> set3=new HashSet<Person>();
		
		set3.add(new Person("abcd",20));
		set3.add(new Person("abcd",20));
		set3.add(new Person("aa",26));
		set3.add(new Person("nba",22));
		set3.add(new Person("nba",22));
		set3.add(new Person("cba",24));
		
		for(Person p:set3){
			System.out.println(p);
		}
		
		
		
		
		
		
		
		

	}

}
