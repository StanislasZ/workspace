package day17_0830;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List list=new ArrayList();
		methodDemo(list);
		System.out.println(list);
	}
	
	/*
	 * ��ʾList���еķ���
	 */
	
	public static void methodDemo(List list){
		//1.�������Ԫ��
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		
		//2.����Ԫ�ء�
		list.add(1,"hehe");
		
		//3.ɾ��
		list.remove(1);
		
		//4.��ȡ
		System.out.println(list.get(1));
		System.out.println(list.indexOf("abc3"));
		
		//5.�޸�
		list.set(1, "kk");
		
		//6.ȡ������������Ԫ��
//		for (Iterator it = list.iterator(); it.hasNext();) {
//			System.out.println(it.next());
//		}
		
		//7.list�������е�ȡ����ʽ
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
