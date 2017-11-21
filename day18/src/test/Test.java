package test;

/*
 * �Զ���Ƚ�ʱ����Ҫ�Զ���һ����ʵ��Comparator�ӿڣ�����compare����
 */



import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import comparator.ComparatorByLength;

public class Test {

	public static void main(String[] args) {
		/*
		TreeSet t=new TreeSet(new ComparatorByLength());
		
		t.add("ab");
		t.add("rvvvv");
		t.add("rvvvv");
		t.add("b");
		t.add("vvvv");
		t.add("abc");
		
		for(Object obj:t){
			System.out.println(obj);
		}
		*/
		
		
		sortStringByLength2();

	}

	/*
	 * ��ϰ4���Զ���ַ��������ظ������ճ��������ɶ̵�����
	 * ˼·��
	 * 1.����ַ�������Ҫ�����洢
	 * 2.ѡ���ĸ��������ַ����Ƕ��󣬿���ѡ�񼯺ϣ����Ҳ��ظ���ѡ��Set����
	 * 3.����Ҫ���򣬿���ѡ��TreeSet����
	 */
	public static void sortStringByLength(){
		
		Set set=new TreeSet(new ComparatorByLength());  //��Ȼ����
		
		set.add("haha");
		set.add("abc");
		set.add("zz");
		set.add("nba");
		set.add("xixixi");
		
		for(Object obj:set){
			System.out.println(obj);
		}
	}
	
	/*
	 * ��ϰ5���Զ���ַ������ظ��������ճ�������
	 * ˼·��
	 * 1.��ʹ��TreeSet�𣿲��ܡ�
	 * 2.���Դ洢�����飬list��������ѡ�����顣
	 * 
	 */
	public static void sortStringByLength2(){
		
		String[] strs={"haha","abccc","xixi","nba","abccc","zero","xixi"};
		
		//��Ȼ�������ʹ��String���е�compareTo����
		//��ʱ����Ҫ���ǳ������������Ҫ�Ƚ�����
		Comparator comp=new ComparatorByLength();
		
		
		
		
		//�������ҪǶ��ѭ����λ���û�
		for(int i=0;i<strs.length-1;i++){
			for(int j=i+1;j<strs.length;j++){
//				if(strs[i].compareTo(strs[j])>0){
				if(comp.compare(strs[i], strs[j])>0){
					swap(strs,i,j);
				}
			}
		}
		
		for(String s:strs){
			System.out.println(s);
		}
	}

	private static void swap(String[] strs, int i, int j) {
		String temp=strs[i];
		strs[i]=strs[j];
		strs[j]=temp;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
