package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import comparator.ComparatorByLength;

public class CollectionsDemo {

	public static void main(String[] args) {
		//methodDemo1();

		Collection<String> coll=new ArrayList<String>();
		coll.add("ade");
		coll.add("eee");
		coll.add("zzzz");
		coll.add("tzzzz");

		
		String max=getMax(coll);
		System.out.println(max);
		System.out.println(Collections.max(coll));
		
		
		String max1=Collections.max(coll,new ComparatorByLength());
		System.out.println(max1);
		
		/*
		 * Collections����һ�����Խ���ͬ������ת��ͬ�����ϵķ���
		 * ͬ������   synchronized����(��ͬ�����)
		 */
		
	}
	
	/**
	 * ģ��һ����ȡ�������ֵ�Ĺ��ܡ�
	 * 
	 */
	public static <T extends Object&Comparable<? super T>> T getMax(Collection<? extends T> coll){
		
		Iterator<? extends T> it=coll.iterator();     //���Ϸ�����ʲô�����ĵ������ķ��;���ʲô
		
		//1.���������¼����������һ��
		T max=it.next();
		
		//2.������������Ԫ��
		while(it.hasNext()){
			 T temp=it.next();
			 if(temp.compareTo(max)>0){
				 max=temp;
			 }
		}
		//3.�ڱ��������н��бȽϡ�ֻҪ�ȱ����е�ֵ���ñ�����¼����
		return max;
	}

	public static void methodDemo1() {
		List<String> list=new ArrayList<String>();
		
		list.add("abce");
		list.add("z");
		list.add("hehe");
		list.add("nba");
		
		System.out.println(list);
		
		//��list������Ȼ����ʹ�õ���Ԫ�ص�compareTo����
		Collections.sort(list);
		System.out.println(list);
		
		//�밴��������
		Collections.sort(list,new ComparatorByLength());
		System.out.println(list);
		
		Collections.sort(list,Collections.reverseOrder(new ComparatorByLength()));   //��תָ���Ƚ���
		System.out.println(list);
		
		
	}

}
