package generic.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
		
		//Ϊ������ʱ�����������쳣���ڶ�������ʱ������ȷ������Ԫ�ص����͡�
		List<String> list=new ArrayList<String>();
		
		list.add("abc");
	//	list.add(4);    //class�ļ��б����list.add(Integer.valueOf(4));     �Զ�װ��
		
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			
			String str=it.next();
			
			System.out.println(str.length());
			
			//System.out.println(it.next().toString());
		}
		
		
	}

}
