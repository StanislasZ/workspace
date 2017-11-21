package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		//Ä£ÄâÒ»¸öCollections  min(Collection coll,Comparator comp)
		
		Collection<Integer> coll=new ArrayList<Integer>();
		coll.add(10);
		coll.add(2);
		coll.add(5);
		
		Integer min=getMin(coll);
		System.out.println(min);
		
	}


	
	public static <T extends Object&Comparable<? super T>> T getMin(Collection<? extends T> coll){
		
		Iterator<? extends T> it=coll.iterator();
		
		T min=it.next();
		
		while(it.hasNext()){
			T temp=it.next();
			if(temp.compareTo(min)<0){
				min=temp;
			}
		}
		return min;
		
	}
}
