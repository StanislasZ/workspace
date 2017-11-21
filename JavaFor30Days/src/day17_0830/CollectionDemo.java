package day17_0830;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		//methodDemo(c);
		methodAllDemo();
	}
	
	/*
	 * 演示带All的方法
	 */
	public static void methodAllDemo(){
		//1.创建两个容器
		Collection c1=new ArrayList();
		Collection c2=new ArrayList();
		
		//2.添加元素
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		c2.add("abc2");
		c2.add("abc3");
		c2.add("abc5");
		
		//c1中添加c2
		//c1.addAll(c2);
		
		//判断c1中是否包含c2中的**所有**元素。
		//boolean b=c1.containsAll(c2);
		//System.out.println(b);
		
		//从c1中删除c2
		//c1.removeAll(c2);   //在c1中删除交集
		
		c1.retainAll(c2); //留下交集 
		
		
		System.out.println(c1);
		
		
		
		
		
	}
	
	
	

	/*
	 * 演示Collection中的基本功能 
	 */
	public static void methodDemo(Collection c){
		//1.添加元素
		c.add("abc1");
		c.add("abc2");
		c.add("abc3");
		
		//2.删除
		//c.remove("abc2");  //会改变集合的长度
		
		//3.清除
		//c.clear();
		
		//4.包含
		System.out.println(c.contains("abc1"));
		
		
		System.out.println(c.size());
		System.out.println(c.toString());
		
	}
	
}
