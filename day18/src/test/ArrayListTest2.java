package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest2 {

	public static void main(String[] args) {
		/*
		 * ��ϰ2�����ܣ���ȥ��ArrayList�����е��ظ�Ԫ��
		 */

		List list=new ArrayList();
		
		list.add("abc1");
		list.add("abc4");
		list.add("abc2");
		list.add("abc1");
		list.add("abc4");
		list.add("abc4");
		list.add("abc2");
		list.add("abc1");
		list.add("abc2");
		list.add("abc1");
		list.add("abc3");
		list.add("abc4");
		
		System.out.println(list);
		
		singleElement2(list);
		System.out.println(list);
		
	}
	
	/**
	 * ���幦�ܣ�ȥ���ظ�Ԫ��
	 */
	public static void singleElement(List list){
		
		for(int i=0;i<list.size()-1;i++){     //size���Զ����
			Object obj_i=list.get(i);
			for(int j=i+1;j<list.size();j++){
				if(obj_i.equals(list.get(j))){
					list.remove(j);
					j--;            //ɾ��һ��������Ķ���ǰ�ƶ���һλ����������ҲҪ��1
				}
			}
		}
	}
	
	
	//˼�������Ϸ���������ѭ����  ����������contains���������Ը�һ�㣿
	
	/**
	 * ������
	 * ˼·������һ�����������ڴ洢Ψһ�Ե�Ԫ�ء�
	 * ��contains����,�����ڲŴ洢
	 */
	
	public static void singleElement2(List list){
		//1.����һ����ʱ����
		List temp=new ArrayList();
		
		//2.����ԭ����
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = (Object) it.next();
			
			//3.����ʱ�������жϱ�������Ԫ���Ƿ����
			if(!temp.contains(obj)){
				//4.��������ڣ��ʹ洢����ʱ������
				temp.add(obj);
			}
			
		}
		//5.��ԭ�������
		list.clear();
		//6.���ȥ
		list.addAll(temp);
	}
	
	

}
