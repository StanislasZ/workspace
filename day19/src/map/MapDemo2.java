package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {

	public static void main(String[] args) {
		
		/*
		 * ȡ��map�����е�Ԫ��
		 * map�洢����--������
		 */
		
		Map<String,String> map=new HashMap<String,String>();
		
		map.put("xiaoqiang", "beijing");
		map.put("wangcai", "funiushan");
		map.put("daniu", "heifengshan");
		map.put("erhu", "wohudong");
		
		Set<String> keyset=map.keySet();
		
		/*
		for (Iterator<String> it = keyset.iterator(); it.hasNext();) {
			String key =it.next();   //����
			String value=map.get(key);
			
			System.out.println(key+"..."+value);
			
		}
		*/
		
		//��ʾentrySet();
		
		Set<Map.Entry<String, String>> entryset=map.entrySet();
		
//		for (Iterator<Map.Entry<String, String>> it = entryset.iterator(); it.hasNext();) {
//			Map.Entry<String, String> me=it.next();
//			String key=me.getKey();
//			String value=me.getValue();
//			System.out.println(key+"..."+value);
//			
//		}
		
		//��ʾvalues()	  ���е�ֵ
		Collection<String> values=map.values();
		for (Iterator<String> it = values.iterator(); it.hasNext();) {
			String value=it.next();
			System.out.println(value);
			
		}
		
		
		
	}

}

interface MyMap{
	
	//entry����map�ӿ��е��ڲ��ӿ�
	public static interface MyEntry{
		
	}
}

class MyDemo implements MyMap.MyEntry{
	
}













