package someproblem;
//��ʾ��ǰʱ��
//��һ������ + x��  �õ��µ�����

import java.time.LocalDate;
import java.util.Date;   //java.util.Date �� java.sql.Date �ĸ��ࡣ

public class ��ʾʱ�� {

	public static void main(String[] args) {
//		Date d = new Date();
//		System.out.println(d);
		
		
//		Date date = new Date();            //��ȡʱ���
//	    long times = date.getTime();
//	    System.out.println(times);

		
		
//		long times = 1412654676572L;
//	    Date date = new Date(times);
//	    System.out.println(date);                 //ʱ���ת��������
		
		//System.out.println(new Date());
		
//		String s=new Date().toString();
//		System.out.println(s);
		
	   LocalDate newyearseve=LocalDate.of(1999, 12, 31);
	  //Ҫ֪��������ڹ��˼�����Ǽ��꼸�¼��ţ���plusDays����
	   LocalDate athousanddayslater=newyearseve.plusDays(1000);
	   System.out.println(athousanddayslater);          //��1000����02��9��26��
	   
	   LocalDate date=LocalDate.now();
	   System.out.println(date);
	
	
	}
}
