package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionToArray {

	public static void main(String[] args) {
		
		//集合转成数组  Collection toArray
		
		List<String> list=new ArrayList<String>();
		
		list.add("abc");
		list.add("haha");
		/*
		 * 传入的数组长度，如果小于集合长度，方法中会创建一个新的长度和集合长度一致的数组
		 * 如果大于等于，会使用传入的数组。所以建议单独定义为集合的size();
		 * 
		 * 为什么要把集合转成数组
		 * 就是为了限定对元素的操作，比如增删。
		 */
		
		String[] arr=list.toArray(new String[0]);

		System.out.println(Arrays.toString(arr));
	}

}
