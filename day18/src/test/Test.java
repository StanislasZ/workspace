package test;

/*
 * 自定义比较时，需要自定义一个类实现Comparator接口，覆盖compare方法
 */



import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import comparator.ComparatorByLength;

public class Test {

	public static void main(String[] args) {
		/*
		TreeSet t=new TreeSet(new ComparatorByLength());
		
		t.add("ab");
		t.add("rvvvv");
		t.add("rvvvv");
		t.add("b");
		t.add("vvvv");
		t.add("abc");
		
		for(Object obj:t){
			System.out.println(obj);
		}
		*/
		
		
		sortStringByLength2();

	}

	/*
	 * 练习4：对多个字符串（不重复）按照长度排序（由短到长）
	 * 思路：
	 * 1.多个字符串，需要容器存储
	 * 2.选择哪个容器。字符串是对象，可以选择集合，而且不重复，选择Set集合
	 * 3.还需要排序，可以选择TreeSet集合
	 */
	public static void sortStringByLength(){
		
		Set set=new TreeSet(new ComparatorByLength());  //自然排序
		
		set.add("haha");
		set.add("abc");
		set.add("zz");
		set.add("nba");
		set.add("xixixi");
		
		for(Object obj:set){
			System.out.println(obj);
		}
	}
	
	/*
	 * 练习5：对多个字符串（重复），按照长度排序。
	 * 思路：
	 * 1.能使用TreeSet吗？不能。
	 * 2.可以存储到数组，list。这里先选择数组。
	 * 
	 */
	public static void sortStringByLength2(){
		
		String[] strs={"haha","abccc","xixi","nba","abccc","zero","xixi"};
		
		//自然排序可以使用String类中的compareTo方法
		//当时现在要的是长度排序，这就需要比较器。
		Comparator comp=new ComparatorByLength();
		
		
		
		
		//排序就需要嵌套循环。位置置换
		for(int i=0;i<strs.length-1;i++){
			for(int j=i+1;j<strs.length;j++){
//				if(strs[i].compareTo(strs[j])>0){
				if(comp.compare(strs[i], strs[j])>0){
					swap(strs,i,j);
				}
			}
		}
		
		for(String s:strs){
			System.out.println(s);
		}
	}

	private static void swap(String[] strs, int i, int j) {
		String temp=strs[i];
		strs[i]=strs[j];
		strs[j]=temp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
