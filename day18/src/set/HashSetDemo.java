package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
	
	public static void main(String[] args){
		
		//1.����һ��Set��������
		Set set=new HashSet();
		
		//2.���Ԫ��
		set.add("haha");
		set.add("abc");
		set.add("nba");
		set.add("heihei");
		set.add("heihei");
		
		//3.ֻ���õ�����ȡ��
		for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
