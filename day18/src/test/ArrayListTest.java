package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Person;





public class ArrayListTest {

	public static void main(String[] args) {
		/*
		 * 1.往ArrayList中存储自定义对象。Person(name,age)
		 */
		
		//1.创建ArrayList集合对象
		List list=new ArrayList();   //多态
		
		//2.添加Person类型的对象。
		Person p1=new Person("lisi1",21);
		Person p2=new Person("lisi2",22);
		
		list.add(p1);  //add(Object obj)
		list.add(p2);
		list.add(new Person("lisi3",23));
		list.add(new Person("lisi3",23));
		list.add(new Person("lisi2",22));
		
		/*
		//3.取出元素
		for (Iterator it = list.iterator(); it.hasNext();) {
			//System.out.println(it.next());   //取出的被提升为了Object类型
			
			Person p=(Person)it.next(); //向下转型
			System.out.println(p.getAge() );
		
		}
		*/
		
		System.out.println(list);
		singleElement2(list);
		System.out.println(list);
		
	}

	
	public static void singleElement2(List list){
		//1.定义一个临时容器
		List temp=new ArrayList();
		
		//2.遍历原容器
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = (Object) it.next();
			
			//3.在临时容器中判断遍历到的元素是否存在
			if(!temp.contains(obj)){
				//4.如果不存在，就存储到临时容器中
				temp.add(obj);
			}
			
		}
		//5.将原容器清空
		list.clear();
		//6.搬过去
		list.addAll(temp);
	}
	
}
