package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		/*
		 * 什么时候用map集合呢
		 * 当需求中出现映射关系时，应该最先想到map集合
		 * 
		 */

	
		System.out.println(getEngWeek("星期二"));
		
	}
	
	//根据中文的星期，获取对应的英文星期
	public static String getEngWeek(String cnWeek){
		
		//创建一个表
		Map<String,String> map=new HashMap<String,String>();
		map.put("星期一", "mon");
		map.put("星期二", "tues");
		map.put("星期三", "wed");
		map.put("星期四", "thr");
		map.put("星期五", "fri");
		map.put("星期六", "sat");
		map.put("星期日", "sun");
		
		return map.get(cnWeek);
	}

}
