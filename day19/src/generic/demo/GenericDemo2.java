package generic.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericDemo2 {

	public static void main(String[] args) {
		
		//����һ��List���ϡ��洢���� 
		List<Integer> list=new ArrayList<Integer>();

		list.add(5);   //5�Զ�װ��
		list.add(6);  
		list.add(7); 
		
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());  //����ǿת��
			
		}
		
	}

}
