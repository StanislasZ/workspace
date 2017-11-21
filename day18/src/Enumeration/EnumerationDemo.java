package Enumeration;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		
		/*
		 * Enumeration��ö��
		 * �߱�ö��ȡ����ʽ������ֻ��Vector
		 */

		Vector v=new Vector();
		
		v.add("abc1");
		v.add("abc2");
		v.add("abc3");
		v.add("abc4");
		
//		Enumeration en=v.elements();
		
//		while(en.hasMoreElements()){
//			System.out.println(en.nextElement());
//		}
		
		//��ȡö�٣����ڲ����ˣ�
		for(Enumeration en=v.elements();en.hasMoreElements();)
			System.out.println("Enumeration"+en.nextElement());
		
		//��ȡ�������ã�
		for (Iterator it = v.iterator(); it.hasNext();) {
			System.out.println("iterator:"+it.next());
		}
		
		//�߼�for
		for(Object obj:v){
			System.out.println("foreach"+obj);
		}
		
	}

}
