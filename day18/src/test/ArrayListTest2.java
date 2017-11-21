package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest2 {

	public static void main(String[] args) {
		/*
		 * 练习2：功能：请去除ArrayList集合中的重复元素
		 */

		List list=new ArrayList();
		
		list.add("abc1");
		list.add("abc4");
		list.add("abc2");
		list.add("abc1");
		list.add("abc4");
		list.add("abc4");
		list.add("abc2");
		list.add("abc1");
		list.add("abc2");
		list.add("abc1");
		list.add("abc3");
		list.add("abc4");
		
		System.out.println(list);
		
		singleElement2(list);
		System.out.println(list);
		
	}
	
	/**
	 * 定义功能：去除重复元素
	 */
	public static void singleElement(List list){
		
		for(int i=0;i<list.size()-1;i++){     //size会自动变的
			Object obj_i=list.get(i);
			for(int j=i+1;j<list.size();j++){
				if(obj_i.equals(list.get(j))){
					list.remove(j);
					j--;            //删了一个，后面的都向前移动了一位，所以索引也要减1
				}
			}
		}
	}
	
	
	//思考：以上方法是两层循环。  容器本身有contains方法，可以搞一搞？
	
	/**
	 * 方法二
	 * 思路：定义一个容器，用于存储唯一性的元素。
	 * 用contains功能,不存在才存储
	 */
	
	public static void singleElement2(List list){
		//1.定义一个临时容器
		List temp=new ArrayList();
		
		//2.遍历原容器
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = (Object) it.next();
			
			//3.在临时容器中判断遍历到的元素是否存在
			if(!temp.contains(obj)){
				//4.如果不存在，就存储到临时容器中
				temp.add(obj);
			}
			
		}
		//5.将原容器清空
		list.clear();
		//6.搬过去
		list.addAll(temp);
	}
	
	

}
