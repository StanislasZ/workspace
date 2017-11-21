package someproblem;

public class 获取两个字符串的最大子串 {

	public static void main(String[] args) {
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
			for(int j=0,k=shortstr.length()-i;k<=shortstr.length();j++,k++){
				//根据j,k获取子串
				String temp=shortstr.substring(j, k);
				if(longstr.contains(temp))
					return temp;
			}
		}
		
		
		
		
		return null;
	}


}
