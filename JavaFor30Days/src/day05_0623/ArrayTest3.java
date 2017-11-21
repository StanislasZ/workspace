package day05_0623;
//day05-16-将数组转成字符串
public class ArrayTest3 {

	public static void main(String[] args) {
		/*
		 需求1：定义功能，将{34,12,122,444,67}中的元素转成字符串"[34,12,122,444,67]"
		 明确1：结果？字符串
		 明确2：参数？数组
		 
		 思路：
		 简单的方式就是利用了字符串和任何数据相加都是相连接！！！
		 */
		
//		String a="a";
//		String b="b";
//		System.out.println(a+b);
        int[] arr={34,12,122,444,67};
        String result=toString(arr);
        System.out.println(result);
	}

	
	public static String toString(int[] arr){
		String a="[";
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1)
				a=a+arr[i]+",";
			else
				a=a+arr[i]+"]";      //如果是最后一个元素，就不加逗号,加右中括号。
		}
		
		return a;
		
	}
	
	
	
	
	
	
	
	
	
	
}
