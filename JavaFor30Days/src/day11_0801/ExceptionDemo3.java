package day11_0801;

/*
 �쳣��ԭ��
 	1.�����ڲ����쳣throw�׳���������һ��Ҫthrows������
 	  �ڲ���ʲô�������Ͼ�����ʲô��������Ϊ���õ����ߴ��������������������ʧ�ܡ�
 	
 	2.���������
 		��������ͨ��throw�׳���RuntimeException����������쳣����ʱ�������Ͽ��Բ���throws����
 		��������Ŀ�ľ��ǲ��õ����ߴ������õ����ߵĳ���ֹͣ��Ҫ�Դ�������޸ġ�
 		
 	Exception�����֣�
 		1.����ʱ�ᱻ�����쳣
 		2.����ʱ�쳣������ʱ����⣩RuntimeException
 */

class Demo2{
	int div(int a,int b) /*throws Exception*/{
		if(b==0)
			throw new ArithmeticException("��0��������");
		return a/b;
	}
}


public class ExceptionDemo3 {
	public static void main(String[] args) /*throws Exception*/{
		Demo2 d=new Demo2();
		try{
			int num=d.div(4,0);
			System.out.println("num="+num);
		}
		catch(Exception e){  
			//����������󣬿���ʹ�øö���ķ�����
			//System.out.println("�쳣��");  //����2�������쳣
			//System.out.println(e.getMessage()); //�쳣��Ϣ
			System.out.println(e.toString());   //�쳣����+�쳣��Ϣ
			//e.printStackTrace();                //����+��Ϣ+λ�� jvmĬ�������������ʽ
		}
						
		System.out.println("over");
		
		int[] arr=new int[3];
		//arr=null;
		System.out.println("element:"+getElement(arr,-2));
		
	}

	public static int getElement(int[] arr,int index){
		if(arr==null){
			throw new NullPointerException("����ʵ�岻����");
		}
		if(index<0||index>arr.length-1){
			throw new ArrayIndexOutOfBoundsException(index+",�Ǳ겻����");
		}
		int element=arr[index];
		return element;
	}
	
	
}