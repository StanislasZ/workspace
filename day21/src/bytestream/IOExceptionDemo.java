package bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String line_separator = System.getProperty("line.separator");

	public static void main(String[] args)  {
		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("tempfile\\fos.txt",true); //����trueʵ����д
			
			fos.write((line_separator+"hello").getBytes());
			
		} catch (IOException e) {
			System.out.println(e.toString()+"----");
			//e.printStackTrace();
		} finally{
 			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					
					throw new RuntimeException(""+e);
				}
			}
		}

	}

}
