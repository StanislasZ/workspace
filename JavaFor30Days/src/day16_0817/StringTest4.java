package day16_0817;

public class StringTest4 {

	public static void main(String[] args) {
		/*
		 ���������ַ����������ͬ�Ӵ���
		 "testify"
		 "testimony"
		 ˼·���Զ̵��ַ���Ϊ�����������ַ�����ȥ�ж��Ƿ���ڣ�������ڣ����ҵ�
		 		���û���ҵ��������ȵݼ�����ȡ�Ӵ�����������������ֻҪ�ҵ��ͽ���
		 		��û�ҵ���˵��û����ͬ�ġ�
		 		
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
		//�Զ̴��������Ӷ̵���ȡ�Ӵ������������ж�
		for(int i=0;i<shortstr.length();i++){
			//for(int j=0,k=shortstr.length()-i;k<=shortstr.length();j++,k++){
			for(int j=0,k=shortstr.length()-i;j<=i;j++,k++)	{
			//����j,k��ȡ�Ӵ�
				
				String temp=shortstr.substring(j, k);
				//System.out.println(temp);
				if(longstr.contains(temp))
					return temp;
				
			}
		}
		
		
		
		
		return null;
	}

	
	
		
		
		
		
		
		
	}


