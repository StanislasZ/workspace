package demo;

import domain.Pair;

public class Demo_P312 {

	public static void main(String[] args) {
		
		String[] words={"Mary","had","a","little","lamb"};
		Pair<String> mm=ArrayAlg.minmax(words);
		
		System.out.println("min="+mm.getFirst());
		System.out.println("max="+mm.getSecond());

		System.out.println("middle="+ArrayAlg.getMiddle(10,4,6,2,22));
	}

}

class ArrayAlg{
	/**
	 * 获取字符串数组的最大值和最小值
	 */
	public static Pair<String> minmax(String[] a){
		if(a==null||a.length==0)
			return null;
		String min=a[0];
		String max=a[0];
		
		for (int i = 1; i < a.length; i++) {
			if(min.compareTo(a[i])>0)
				min=a[i];
			if(max.compareTo(a[i])<0)
				max=a[i];
		}
		return new Pair<String>(min,max);
			
	}
	
	
	public static <T> T getMiddle(T... a){
		return a[a.length/2];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}