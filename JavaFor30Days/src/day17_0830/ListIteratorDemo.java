package day17_0830;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {
		
		List list =new ArrayList();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

//		//在遍历的过程中，如果遍历到abc2，添加一个元素哈哈
//		for(Iterator it=list.iterator();it.hasNext();){
//			Object obj=it.next();
//			if(obj.equals("abc2")){
//				list.add("haha");   //你加了一个进去，但迭代器不知道啊，炸了
//			}
//		}
		
		
		//使用List集合的特有的迭代器 ListIterator
		//它可以实现在迭代过程中的增删改查
		for(ListIterator it=list.listIterator();it.hasNext();){
			Object obj=it.next();
			if(obj.equals("abc2")){
				it.add("haha"); 
			}
		}
		
		
		System.out.println(list);
	}

}
