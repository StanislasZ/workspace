package day11_0801;   //03-�쳣������ʽ,04-try&catch  06-throw��throws������

/*
 �쳣�Ĵ�����
 	���֣�
 		1.�������ⲻ���о���Ĵ��������Ǽ����׸������ߡ�
 			ͨ��throws�ؼ��������쳣�����ߵ����ߴ�����
 			
 		2.����ԵĴ�����ʽ������
 		try{
 			
 			//�п��ܷ����쳣�Ĵ���
 			 
 		}
 		catch(�쳣�� ����){
 			
 			//��ʱ�����Ĳ��񣬴����쳣�Ĵ���
 			 
 		}
 		finally{
 		
 		}
  
  throw��throws��ʲô�����أ�
  
  	1.λ�ò�ͬ��
  		throws���ں����ϣ�������ŵ����쳣�࣬���Ը����
  		throw���ں����ڣ�����������쳣����
  		
  	2.���ܲ�ͬ��
  		throws���������쳣���õ�����֪���ù����п��ܳ��ֵ����⣬���ɵ����߿��Ը���Ԥ�ȵĴ����ķ�ʽ
  		throw�׳�������������ִ�е�throw���ܾ��Ѿ������ˣ���ת�������ߡ�����������������Ҳ�׸������ߡ�
  
  �쳣��ϵ�����ص������ϵ�е����Լ�������Ķ��󣬶��߱������ԣ���˼�ǿ��Ա�throws��throw����
 */

class Demo{
	/*
	 �ڱ�д����ʱ����д��֪���ù����п��ܷ������⡣�������������������ڵ����ߴ��ݵĲ�����
	 �����¹����޷����С���ʱ�����������Ӧ���õ�����֪����������õ�������Ԥ�ȵĴ�����ʽ��
	 �����ڶ��幦��ʱ����Ҫ�ڹ����϶��п��ܷ��������������������
	 */
	int div(int a,int b) throws Exception{ //�����쳣
		if(b==0)
			throw new ArithmeticException("��0����"); //�׳��쳣
		return a/b;
	}
}



public class ExceptionDemo2 {

	public static void main(String[] args) /*throws Exception����1*/{
		Demo d=new Demo();
		
/*��2*/	try{
			int num=d.div(4,0);
			System.out.println("num="+num);
		}
/*��2*/	catch(Exception e){   
			//����������󣬿���ʹ�øö���ķ�����
			System.out.println("�쳣��");  //����2�������쳣
			System.out.println(e.getMessage()); //�쳣��Ϣ
			System.out.println(e.toString());   //�쳣����+�쳣��Ϣ
			//e.printStackTrace();                //����+��Ϣ+λ�� jvmĬ�������������ʽ
		}
		
		
		
		
		
		System.out.println("over");
	}

}