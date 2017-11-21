package day13_Á·Ï°;  //µÚ8Ìâ
import java.io.IOException;



public class ExceptionTest {
	public static void main(String[] args) {
		try{
			new ExceptionTest().method(5);
		}
		catch(IOException e){
			System.out.println("caught IOException");
		}
		catch(Exception e){
			System.out.println("caught Exception");
		}
		finally{
			System.out.println("no Exception");
		}

	}
	
	void method(int i) throws IOException{
		if(i%2!=0)
			throw new IOException("methodA IOException");
	}

}
