package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		/*
		 * 作业："fewgvwojewslfeeewwxw"
		 * 获取字符串中每一个字母出现的次数。要求结果格式：  a(2)b(1)d(3)...........
		 * 
		 * 思路：
		 * 1.获取到字母
		 * 2.如何获取字母的次数？ 
		 * 	       发现字母和次数有对应关系。而且对应关系的一方具备唯一性
		 * 		就想到了Map集合。就是一张表
 		 * 3. 使用查表法就可以了
 		 * 		先查第一个字母在表中出现的次数。如果次数不存在，说明是第一次出现，将该字母和1存储到表中
		 * 		以此类推。当要查的次数存在，将次数取出，并自增后再和对应的字母put进去。map存相同键会覆盖
		 * 
		 * 
		 * 
		 */

		String str="jfwoejgsldewfweocqpsjs";
		
		String char_count=getCharCount(str);
		
		System.out.println(char_count);
		
		
		
		
	}

	public static String getCharCount(String str) {
		
		//1.将字符串转成字符数组
		char[] chs=str.toCharArray();
		
		//2.定义map集合表
		Map<Character,Integer> map=new TreeMap<Character,Integer>();  //用二叉树结构保证有序
		
		//3.遍历字符数组，获取每一个字母
		for (int i = 0; i < chs.length; i++) {
			//只对字母操作
			if(!(chs[i]>='a'&&chs[i]<='z'||chs[i]>='A'&&chs[i]<='Z'))
				continue;
			
			
			
			//将遍历到的字母作为键去查表，获取值
			Integer value=map.get(chs[i]);
			int count=0;//用于记录次数
			//如果次数存在，就用count记录该次数；如果次数不存在，就不记录只对count自增
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
	 * 将map集合中的元素转成指定格式的字符串
	 */
	private static String toString(Map<Character, Integer> map) {
		//1.数据多，无论类型是什么，最终都要变成字符串
		StringBuilder sb=new StringBuilder();
		
		//2.遍历集合map
		Set<Character> keyset=map.keySet();
		
		for (Iterator<Character> it = keyset.iterator(); it.hasNext();) {
			Character key =it.next();
			Integer value=map.get(key);
			
			//将键值存储到sb中。
			sb.append(key+"("+value+")");
		}
		return sb.toString();
	}
	
	
	

}
