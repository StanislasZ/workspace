package day16_0817;

public class StringTest3 {

	public static void main(String[] args) {
		/*
		 需求：子串在整串中出现的次数。"nbadfnbaefwwnba"
		 
		 思路：
		 	1.需要计数
		 	2.找到一个指定的子串"nba"就计数。
		 	3.找String类
		 	
		 步骤：
		 	1.定义变量，计数
		 	2.需要循环，循环条件是，找到了就继续循环，没找到就停。
		 	3.返回值int   参数String  循环内计数器自增。
		 */
		
		String str="nbadfnbaefwwqqqnba";
		String key="nba";
		
		int count=getKeyCount(str,key);
		System.out.println("count="+count);

	}

	public static int getKeyCount(String str, String key) {
		int count=0;
		int fromIndex=0;  //每次查找的起始位
		//循环，条件是indexOf查找的方法返回的结果不是-1且要明确下次查找的位置
		while(str.indexOf(key,fromIndex)!=-1){
			count++;
			//fromIndex=str.indexOf(key,fromIndex)+key.length();
			fromIndex+=key.length();
		}
		return count;
	}

}
