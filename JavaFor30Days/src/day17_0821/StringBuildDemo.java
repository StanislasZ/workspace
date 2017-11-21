package day17_0821;

public class StringBuildDemo {

	public static void main(String[] args) {
		/*
		 * JDK1.5以后，出现了StringBuilder，用法和StringBuffer一样。
		 * StringBuffer是线程同步的。
		 * StringBuilder是线程不同步的。
		 * 建议选择StringBuilder。因为速度快。
		 * 
		 * synchronized append();
		 * 
		 * synchronized insert();
		 * 
		 * synchronized delete();
		 */

	}

}

//class MyStringBuffer{
//	StringBuilder sb=new StringBuilder();
//	public synchronized void append(obj){
//		sb.append(obj);
//	}
//}