package day11_0801;

/*
 �쳣��Java������ ���� ʱ�ڷ����Ĳ�������������⣩��
 
 	java�Ͱ�����������˼��Բ�����������������Ͷ���ķ�װ��
 	
 	
 ��������֣�
 Throwable:�����˶�������Ĺ��ԵĹ��ܡ�
 	|--Error:��ϵͳ�ײ㷢���ġ�����jvm��jvm����ʹ���ߡ��޸Ĵ��롣��������Դ���
 	|--Exception:jvm������������ʹ���ߡ����Խ�������ԵĴ���
 	
 �ܽ᣺
 	1.����ʱ������
 	2.����������󣬽�������������װ�ɶ���
 	3.error��exception������
 */


public class ExceptionDemo {

	public static void main(String[] args) {
		int[] arr=new int[1];
		System.out.println(arr[1]);  //������ͨ��������ͨ����ArrayIndexOutOfBoundsException:1
		//��������ʱ��jvm�ͽ���������װ���˶���
		//new ArrayIndexOutOfBoundsException(1);
		//�׳�
		//throw new ArrayIndexOutOfBoundsException(1);
		//�׸�main,mainû������ԵĴ���ʽ�����������׸�jvm
		//jvm��ʹ����Ĭ�ϵĴ���ʽ�������������+��Ϣ+λ���ڿ���̨����ʾ���������ߵ�����
		
		
		
		
		
		//int[] arr=new int[1024*1024*100];  //OutOfMemoryError
	}

}
