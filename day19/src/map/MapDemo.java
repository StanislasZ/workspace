package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		
		/*
		 * ����Map�����д洢ѧ�ţ�����
		 */
		
		Map<Integer,String> map=new HashMap<Integer,String>();
		methodDemo(map);
	}
	
	public static void methodDemo(Map<Integer,String> map){
		//1.�洢��ֵ��
		System.out.println(map.put(3, "xiaoqiang"));
		System.out.println(map.put(3, "erhu"));    //�������ͬ�������ֵ����
		map.put(7, "wangcai");
		map.put(2, "daniu");
		
		//System.out.println(map.remove(7));
		System.out.println(map);
		
	}

}
