package day17_0830;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		//methodDemo(c);
		methodAllDemo();
	}
	
	/*
	 * ��ʾ��All�ķ���
	 */
	public static void methodAllDemo(){
		//1.������������
		Collection c1=new ArrayList();
		Collection c2=new ArrayList();
		
		//2.���Ԫ��
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");
		
		c2.add("abc2");
		c2.add("abc3");
		c2.add("abc5");
		
		//c1�����c2
		//c1.addAll(c2);
		
		//�ж�c1���Ƿ����c2�е�**����**Ԫ�ء�
		//boolean b=c1.containsAll(c2);
		//System.out.println(b);
		
		//��c1��ɾ��c2
		//c1.removeAll(c2);   //��c1��ɾ������
		
		c1.retainAll(c2); //���½��� 
		
		
		System.out.println(c1);
		
		
		
		
		
	}
	
	
	

	/*
	 * ��ʾCollection�еĻ������� 
	 */
	public static void methodDemo(Collection c){
		//1.���Ԫ��
		c.add("abc1");
		c.add("abc2");
		c.add("abc3");
		
		//2.ɾ��
		//c.remove("abc2");  //��ı伯�ϵĳ���
		
		//3.���
		//c.clear();
		
		//4.����
		System.out.println(c.contains("abc1"));
		
		
		System.out.println(c.size());
		System.out.println(c.toString());
		
	}
	
}
