package day17_0829;

public class WrapperDemo2 {

	public static void main(String[] args) {
		/*
		 * JDK1.5���µļ���
		 * �Զ�װ���Զ����䡣�����intһ������Integer
		 */
		
		//Integer i=new Integer(4);
		//1.5�Ժ�
		Integer i=4;   //�Զ�װ�䡣Integer.valueOf(4);
		
		i=i+6;  //�ұߵ�i�Ӷ���ת������   ���Զ����䣩������6�Ľ����һ��װ�䣬��i
	
		sop(5);
		
		Integer x=new Integer(100);
		Integer y=new Integer(100);
		System.out.println(x==y);
		System.out.println(x.equals(y));
		System.out.println("-----------------------------");
		//jdk1.5�У��Զ�װ���ֵ�����byte��Χ֮�ڣ���ͬ��ֵ���ᵥ�����ٿռ䣬�����ظ�ʹ��
		Integer x2=100;
		Integer y2=100;
		
		System.out.println(x2==y2);
		System.out.println(x2.equals(y2));
	
		x2++;
		//System.out.println(y2);
		System.out.println(x2==y2);
	
	}
	public static void sop(Object s){
		System.out.println(s);
	}

}
