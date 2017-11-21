package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		/*
		 * ��ҵ��"fewgvwojewslfeeewwxw"
		 * ��ȡ�ַ�����ÿһ����ĸ���ֵĴ�����Ҫ������ʽ��  a(2)b(1)d(3)...........
		 * 
		 * ˼·��
		 * 1.��ȡ����ĸ
		 * 2.��λ�ȡ��ĸ�Ĵ����� 
		 * 	       ������ĸ�ʹ����ж�Ӧ��ϵ�����Ҷ�Ӧ��ϵ��һ���߱�Ψһ��
		 * 		���뵽��Map���ϡ�����һ�ű�
 		 * 3. ʹ�ò���Ϳ�����
 		 * 		�Ȳ��һ����ĸ�ڱ��г��ֵĴ�����������������ڣ�˵���ǵ�һ�γ��֣�������ĸ��1�洢������
		 * 		�Դ����ơ���Ҫ��Ĵ������ڣ�������ȡ�������������ٺͶ�Ӧ����ĸput��ȥ��map����ͬ���Ḳ��
		 * 
		 * 
		 * 
		 */

		String str="jfwoejgsldewfweocqpsjs";
		
		String char_count=getCharCount(str);
		
		System.out.println(char_count);
		
		
		
		
	}

	public static String getCharCount(String str) {
		
		//1.���ַ���ת���ַ�����
		char[] chs=str.toCharArray();
		
		//2.����map���ϱ�
		Map<Character,Integer> map=new TreeMap<Character,Integer>();  //�ö������ṹ��֤����
		
		//3.�����ַ����飬��ȡÿһ����ĸ
		for (int i = 0; i < chs.length; i++) {
			//ֻ����ĸ����
			if(!(chs[i]>='a'&&chs[i]<='z'||chs[i]>='A'&&chs[i]<='Z'))
				continue;
			
			
			
			//������������ĸ��Ϊ��ȥ�����ȡֵ
			Integer value=map.get(chs[i]);
			int count=0;//���ڼ�¼����
			//����������ڣ�����count��¼�ô�����������������ڣ��Ͳ���¼ֻ��count����
			if(value!=null){
				count=value;
			}
			count++;
			map.put(chs[i], count);
			
			
			
			/*
			if(value==null){
				map.put(chs[i], 1);
			}else{
				map.put(chs[i], ++value);
			}
			*/	
		}
		//System.out.println(map);
		return toString(map);
	}

	/*
	 * ��map�����е�Ԫ��ת��ָ����ʽ���ַ���
	 */
	private static String toString(Map<Character, Integer> map) {
		//1.���ݶ࣬����������ʲô�����ն�Ҫ����ַ���
		StringBuilder sb=new StringBuilder();
		
		//2.��������map
		Set<Character> keyset=map.keySet();
		
		for (Iterator<Character> it = keyset.iterator(); it.hasNext();) {
			Character key =it.next();
			Integer value=map.get(key);
			
			//����ֵ�洢��sb�С�
			sb.append(key+"("+value+")");
		}
		return sb.toString();
	}
	
	
	

}
