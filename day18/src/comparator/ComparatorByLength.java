package comparator;

import java.util.Comparator;

public class ComparatorByLength implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1=(String)o1;
		String s2=(String)o2;
		//比较长度
		int temp=s1.length()-s2.length();
		
		//长度相同，再按字典顺序。
		return temp==0?s1.compareTo(s2):temp;
	}

}
