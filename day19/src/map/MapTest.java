package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		/*
		 * ʲôʱ����map������
		 * �������г���ӳ���ϵʱ��Ӧ�������뵽map����
		 * 
		 */

	
		System.out.println(getEngWeek("���ڶ�"));
		
	}
	
	//�������ĵ����ڣ���ȡ��Ӧ��Ӣ������
	public static String getEngWeek(String cnWeek){
		
		//����һ����
		Map<String,String> map=new HashMap<String,String>();
		map.put("����һ", "mon");
		map.put("���ڶ�", "tues");
		map.put("������", "wed");
		map.put("������", "thr");
		map.put("������", "fri");
		map.put("������", "sat");
		map.put("������", "sun");
		
		return map.get(cnWeek);
	}

}
