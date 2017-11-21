package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import domain.Student;

public class HashSetTest {

	public static void main(String[] args) {
		
		/*
		 * ��ϰ����HashSet�д洢ѧ���������������䣩��ͬ������ͬ������Ϊͬһ���ˡ�
		 * 
		 * ����ͬ����ͬ�����ѧ���ǿ��Ե�
		 * ԭ����ÿһ�δ洢ѧ�����󣬶��ȵ���hashCode������ȡ��ϣֵ
		 * �����õ���Object���е�hashCode�����Բ�ͬ�Ķ��󣬹�ϣֵҲ��ͬ
		 * �����ͬ����ͬ��������ԭ��
		 * 
		 * 
		 * �������Ҫ����ѧ������������ص��������ϣֵ
		 * ����hashCode����
		 * 
		 */
		
		//1.������������
		HashSet set=new HashSet();
		
		Set set1=new LinkedHashSet();
		
		//2.�洢ѧ������
		set.add(new Student("xiaoqiang",20));
		set.add(new Student("wangcai",27));
		set.add(new Student("wangcai",27));
		set.add(new Student("xiaoming",22));
		set.add(new Student("xiaoming",22));
		
		//3.��ȡ����ѧ��
		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu=(Student)it.next();
			
			System.out.println(stu.getName()+"::"+stu.getAge());
		}

	}

}


