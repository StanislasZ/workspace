package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionToArray {

	public static void main(String[] args) {
		
		//����ת������  Collection toArray
		
		List<String> list=new ArrayList<String>();
		
		list.add("abc");
		list.add("haha");
		/*
		 * ��������鳤�ȣ����С�ڼ��ϳ��ȣ������лᴴ��һ���µĳ��Ⱥͼ��ϳ���һ�µ�����
		 * ������ڵ��ڣ���ʹ�ô�������顣���Խ��鵥������Ϊ���ϵ�size();
		 * 
		 * ΪʲôҪ�Ѽ���ת������
		 * ����Ϊ���޶���Ԫ�صĲ�����������ɾ��
		 */
		
		String[] arr=list.toArray(new String[0]);

		System.out.println(Arrays.toString(arr));
	}

}
