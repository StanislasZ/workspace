package day16_0817;

public class StringTest4 {

	public static void main(String[] args) {
		/*
		 需求：两个字符串的最大相同子串。
		 "testify"
		 "testimony"
		 思路：以短的字符串为主，到长的字符串中去判断是否存在，如果存在，已找到
		 		如果没有找到。将长度递减，获取子串……………………只要找到就结束
		 		还没找到，说明没有相同的。
		 		
		 */
	
		String s1="testify";
		String s2="testimony";
		String MaxSub=getMaxSubString(s1,s2);
		
		System.out.println("maxsub="+MaxSub);
		
			

	}

	public static String getMaxSubString(String s1, String s2) {
		String longstr,shortstr;
		longstr=s1.length()>s2.length()?s1:s2;
		shortstr=s1.equals(longstr)?s2:s1;
		//对短串操作，从短的里取子串，到长的里判断
		for(int i=0;i<shortstr.length();i++){
			//for(int j=0,k=shortstr.length()-i;k<=shortstr.length();j++,k++){
			for(int j=0,k=shortstr.length()-i;j<=i;j++,k++)	{
			//根据j,k获取子串
				
				String temp=shortstr.substring(j, k);
				//System.out.println(temp);
				if(longstr.contains(temp))
					return temp;
				
			}
		}
		
		
		
		
		return null;
	}

	
	
		
		
		
		
		
		
	}


