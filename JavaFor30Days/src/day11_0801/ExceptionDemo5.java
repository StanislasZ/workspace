package day11_0801;   //finally

/*
 try
 catch
 finally
 	finally�����ã������Ƿ����쳣��������Ҫ����Դ�����ͷš�
 					��Դ�ͷŶ����Ͷ�����finally������С�
 */


public class ExceptionDemo5 {
	public static void main(String[] args) {
		try{
			int num=4/0;
			System.out.println("num="+num);
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			//return; //�쳣�������˳�
			System.exit(0);  //�˳�jvm��ֻ�����������finallyҲ��ִ�С�
		}
		finally{
			System.out.println("finally");
		}
		System.out.println("over");
	}

}
