package comparator;

import java.util.Comparator;

import domain.Student;

/**
 * �Զ���һ���Ƚ�������������������
 * @author guguguagua
 *
 */
public class ComparatorByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1=(Student)o1;
		Student s2=(Student)o2;
		
		int temp=s1.getName().compareTo(s2.getName());
		
		return temp==0?s1.getAge()-s2.getAge():temp;
	}

}
