package day11_0801;   //finally

/*
 try
 catch
 finally
 	finally的作用：无论是否有异常发生，都要对资源进行释放。
 					资源释放动作就定义在finally代码块中。
 */


public class ExceptionDemo5 {
	public static void main(String[] args) {
		try{
			int num=4/0;
			System.out.println("num="+num);
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			//return; //异常发生，退出
			System.exit(0);  //退出jvm。只有这种情况，finally也不执行。
		}
		finally{
			System.out.println("finally");
		}
		System.out.println("over");
	}

}
