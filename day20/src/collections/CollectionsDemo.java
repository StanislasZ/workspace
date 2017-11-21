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
		 * Collections中有一个可以将非同步集合转成同步集合的方法
		 * 同步集合   synchronized集合(非同步结合)
		 */
		
	}
	
	/**
	 * 模拟一个获取集合最大值的功能。
	 * 
	 */
	public static <T extends Object&Comparable<? super T>> T getMax(Collection<? extends T> coll){
		
		Iterator<? extends T> it=coll.iterator();     //集合泛型是什么，它的迭代器的泛型就是什么
		
		//1.定义变量记录容器中其中一个
		T max=it.next();
		
		//2.遍历容器所有元素
		while(it.hasNext()){
			 T temp=it.next();
			 if(temp.compareTo(max)>0){
				 max=temp;
			 }
		}
		//3.在遍历过程中进行比较。只要比变量中的值大，用变量记录下来
		return max;
	}

	public static void methodDemo1() {
		List<String> list=new ArrayList<String>();
		
		list.add("abce");
		list.add("z");
		list.add("hehe");
		list.add("nba");
		
		System.out.println(list);
		
		//对list排序。自然排序。使用的是元素的compareTo方法
		Collections.sort(list);
		System.out.println(list);
		
		//想按长度排序
		Collections.sort(list,new ComparatorByLength());
		System.out.println(list);
		
		Collections.sort(list,Collections.reverseOrder(new ComparatorByLength()));   //逆转指定比较器
		System.out.println(list);
		
		
	}

}
