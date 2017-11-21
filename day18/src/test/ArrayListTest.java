package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Person;





public class ArrayListTest {

	public static void main(String[] args) {
		/*
		 * 1.��ArrayList�д洢�Զ������Person(name,age)
		 */
		
		//1.����ArrayList���϶���
		List list=new ArrayList();   //��̬
		
		//2.���Person���͵Ķ���
		Person p1=new Person("lisi1",21);
		Person p2=new Person("lisi2",22);
		
		list.add(p1);  //add(Object obj)
		list.add(p2);
		list.add(new Person("lisi3",23));
		list.add(new Person("lisi3",23));
		list.add(new Person("lisi2",22));
		
		/*
		//3.ȡ��Ԫ��
		for (Iterator it = list.iterator(); it.hasNext();) {
			//System.out.println(it.next());   //ȡ���ı�����Ϊ��Object����
			
			Person p=(Person)it.next(); //����ת��
			System.out.println(p.getAge() );
		
		}
		*/
		
		System.out.println(list);
		singleElement2(list);
		System.out.println(list);
		
	}

	
	public static void singleElement2(List list){
		//1.����һ����ʱ����
		List temp=new ArrayList();
		
		//2.����ԭ����
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = (Object) it.next();
			
			//3.����ʱ�������жϱ�������Ԫ���Ƿ����
			if(!temp.contains(obj)){
				//4.��������ڣ��ʹ洢����ʱ������
				temp.add(obj);
			}
			
		}
		//5.��ԭ�������
		list.clear();
		//6.���ȥ
		list.addAll(temp);
	}
	
}
