package foreach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ForeachDemo {

	public static void main(String[] args) {
		
		/*
		 * jdk1.5���ԣ�
		 * ��ǿforѭ�������ã����ڱ���Collection����or����
		 * ��ʽ��
		 * for(Ԫ������ ������Collection���������飩
		 * {
		 * }
		 */
		
		Collection c=new ArrayList();
		
		c.add("abc1");
		c.add("abc2");
		c.add("abc3");
		
		for(Object obj:c){
			System.out.println(obj);
		}

		/*
		for (Iterator it = c.iterator(); it.hasNext();) {
			Object obj = (Object) it.next();
			System.out.println(obj);
			
		}
		*/
		
		int[] arr={1,2,3,5};
		for(int element:arr){
			System.out.println(element);
		}
		
	}

}
