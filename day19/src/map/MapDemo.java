package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		
		/*
		 * 需求：Map集合中存储学号，姓名
		 */
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		methodDemo(map);
	}
	
	public static void methodDemo(Map<Integer,String> map){
		//1.存储键值对
		System.out.println(map.put(3, "xiaoqiang"));
		System.out.println(map.put(3, "erhu"));    //如果键相同，会出现值覆盖
		map.put(7, "wangcai");
		map.put(2, "daniu");
		
		//System.out.println(map.remove(7));
		System.out.println(map);
		
	}

}
