package someproblem;

public class ���쳣��String���� {

	public static void main(String[] args) {
		String a="abcdaa";
		//System.out.println(a.charAt(4));
		System.out.println("����Ϊ��"+getStringlength(a));

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
