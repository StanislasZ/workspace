package day16_0817;

public class StringTest3 {

	public static void main(String[] args) {
		/*
		 �����Ӵ��������г��ֵĴ�����"nbadfnbaefwwnba"
		 
		 ˼·��
		 	1.��Ҫ����
		 	2.�ҵ�һ��ָ�����Ӵ�"nba"�ͼ�����
		 	3.��String��
		 	
		 ���裺
		 	1.�������������
		 	2.��Ҫѭ����ѭ�������ǣ��ҵ��˾ͼ���ѭ����û�ҵ���ͣ��
		 	3.����ֵint   ����String  ѭ���ڼ�����������
		 */
		
		String str="nbadfnbaefwwqqqnba";
		String key="nba";
		
		int count=getKeyCount(str,key);
		System.out.println("count="+count);

	}

	public static int getKeyCount(String str, String key) {
		int count=0;
		int fromIndex=0;  //ÿ�β��ҵ���ʼλ
		//ѭ����������indexOf���ҵķ������صĽ������-1��Ҫ��ȷ�´β��ҵ�λ��
		while(str.indexOf(key,fromIndex)!=-1){
			count++;
			//fromIndex=str.indexOf(key,fromIndex)+key.length();
			fromIndex+=key.length();
		}
		return count;
	}

}
