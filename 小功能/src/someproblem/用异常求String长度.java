package someproblem;

public class 用异常求String长度 {

	public static void main(String[] args) {
		String a="abcdaa";
		//System.out.println(a.charAt(4));
		System.out.println("长度为："+getStringlength(a));

	}
	public static int getStringlength(String a){
		int i=0;
		while(true){
			try{
				a.charAt(i);
			}
			catch(StringIndexOutOfBoundsException e){
				return i;
			}
			finally{
				i++;
			}
		}
	}
}
