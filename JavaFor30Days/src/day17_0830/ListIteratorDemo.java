package day17_0830;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {
		
		List list =new ArrayList();
		
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");

//		//�ڱ����Ĺ����У����������abc2�����һ��Ԫ�ع���
//		for(Iterator it=list.iterator();it.hasNext();){
//			Object obj=it.next();
//			if(obj.equals("abc2")){
//				list.add("haha");   //�����һ����ȥ������������֪������ը��
//			}
//		}
		
		
		//ʹ��List���ϵ����еĵ����� ListIterator
		//������ʵ���ڵ��������е���ɾ�Ĳ�
		for(ListIterator it=list.listIterator();it.hasNext();){
			Object obj=it.next();
			if(obj.equals("abc2")){
				it.add("haha"); 
			}
		}
		
		
		System.out.println(list);
	}

}
