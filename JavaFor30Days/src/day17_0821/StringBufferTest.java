package day17_0821;

public class StringBufferTest {

	public static void main(String[] args) {
		/*
		 * 1.通过缓冲区，将要打印的矩形组成元素*进行存储后，一次性返回。并输出
		 * 
		 * 2.将int数组的元素转成字符串。格式为：[34,12,67]
		 * 
		 * 什么时候用字符串缓冲区。
		 * 数据很多，个数无所谓确定，类型无所谓确定，只要最后都转成字符串。
		 * 就使用StringBuffer这个容器。
		 * 
		 * 使用的局限性：1.必须最终转成字符串。
		 * 				2.无法对存储进来的元素进行单独操作。因为存储进来的元素都变成字符串。
		 * 
		 */
		String rec=draw(8,5);
		//System.out.println(rec);
		
		int[] arr={34,55,44,77};
		String s=toString(arr);
		String s2=toString2(arr);
		System.out.println(s);
		System.out.println(s2);
		
		StringBuffer buf1=new StringBuffer("hello");
		StringBuffer buf2=new StringBuffer("java");
		test(buf1,buf2);
		System.out.println(buf1+"...."+buf2);
		
		
	}
	
	public static void test(StringBuffer buf1,StringBuffer buf2){
		buf1.append(buf2);
		buf1=buf2;
	}
	
	
	/*
	 * 画矩形的功能
	 * 将需要组成矩形的元素进行临时存储。
	 */
	public static String draw(int row,int col){
		//定义一个临时容器。
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				sb.append("*");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	/**
	 * int数组转成字符串，通过StringBuffer
	 */
	public static String toString2(int[] arr){
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				sb.append(arr[i]+",");
			}
			else{
				sb.append(arr[i]+"]");
			}
		}
		return sb.toString();
	}
	
	
	
	
	/**
	 * int数组转成字符串
	 */
	public static String toString(int[] arr){
		String str="[";
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				str+=arr[i]+",";
			}
			else{
				str+=arr[i]+"]";
			}
		}
		return str;
	}
	
	
	
	
	
	
	
	
	

}
