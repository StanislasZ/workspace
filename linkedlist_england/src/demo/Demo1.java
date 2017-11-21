package demo;

import java.io.FileInputStream;
import java.io.IOException;


public class Demo1 {
	private static final int DEFAULT_SIZE = 1024*2;
	public static void main(String[] args) {
		
		
		//Read the information from the file   ����txt�����ݣ����һ���ַ���
		FileInputStream fis=null;
		String sentence=null;
		sentence = getString(fis, sentence);
			
		//Modify format   �ѱ�����ȥ����ȥ���У��Ѷ���Ŀո���һ���ո�
		sentence=removePunctuation(sentence);
		String[] word=sentence.split(" "); 
				
		//Delete the repeating element in String array and get the times the word occur�ַ�������ȥ�أ���Ϊ��Сд����ͬ�ģ���ͬʱ����
		String[] word_lower=new String[word.length];
		int[] symbol=new int[word.length];    //word_lower��ÿһ��Ԫ�ض�Ӧ�ı�־λ�� ��1��ʾ��ǰ�����ͬ������������Ϊ0�ľ���ȥ�ص���
		int[] num=new int[word.length];
		
		//�ȵõ�ȫСд���ַ�������
		for(int i=0;i<word.length;i++){
			word_lower[i]=word[i].toLowerCase();
		}
		//Ϊ��ȷ��֮�����ظ����ʵ�����ĳ��ȣ���������ظ����ܴ�����
		int num_repeat= calculateRepeat(word_lower, symbol, num);
				
		//4.������ظ��ĵ�������(String[])������ö�Ӧ��һ��int���飬 ��Ӧ���ʳ��ֵĴ���
		String[] word_final=new String[word.length-num_repeat];
		int[] word_num=new int[word.length-num_repeat];
		
		getWordAndNum(word, symbol, num, word_final, word_num);

		
/*---------------------���ˣ��ṩ��������word�� number of occurrence of the word��׼����---------------*/
		
		DoublyLinkedList dll=new DoublyLinkedList();
		//��һ�����ʣ�һ�����ֵ�˳��װ��������
		for(int i=0;i<word_final.length;i++){
			dll.add(word_final[i]);
			dll.add(word_num[i]);
		}
		
/*----------------------------------------���ˣ���һС������----------------------------------------*/		
		//2.a Print Doubly linked list �����������
		System.out.println("put data into list:");
		dll.print();
		
		//2.b Sort ascending and Print the linked list based on the number of occurrence ���յ��ʳ��ֵĴ�����С�����������
		dll.sort();
		System.out.println("\nAfter insertion sort:");
		dll.print();
		
		//2.c Print the three largest and the three smallest occurrence values with associated words
		System.out.println("\nthe three smallest occurrence values with associated words:");
		for(int i=0;i<=4;i=i+2){
			if(i<4)
				System.out.print(dll.getValue(i)+" "+dll.getValue(i+1)+", ");
			else
				System.out.print(dll.getValue(i)+" "+dll.getValue(i+1)+"\n");
		}
			
		System.out.println("\nthe three largest occurrence values with associated words:");
		for(int i=dll.getSize()-2;i>=dll.getSize()-6;i=i-2){
			if(i>dll.getSize()-6)
				System.out.print(dll.getValue(i)+" "+dll.getValue(i+1)+", ");
			else
				System.out.print(dll.getValue(i)+" "+dll.getValue(i+1)+"\n");
				
		}
		System.out.println();
		
		//2.d Delete those words with the occurrence less than 7 times, and Print the remained linked list
		//�����������Ѿ��ź�����
		
		while((int)dll.getValue(1)<7){
			dll.remove(0);
		}
		System.out.println("After delete words with the occurrence less than 7 times, the remained linked list is:");
		dll.print();
		
/*------------------------------------------end-----------------------------------------*/
		
	
	}
	/**
	 * ����֮ǰ�õ��ı�ǣ���ȡ���Ϊ0�ĽǱ꣬��������Ǳ��ҵ�word��num��Ӧ��Ԫ�أ��ֱ�װ��word_final��word_num
	 * @param word
	 * @param symbol
	 * @param num
	 * @param word_final
	 * @param word_num
	 */
	public static void getWordAndNum(String[] word, int[] symbol, int[] num, String[] word_final, int[] word_num) {
		for(int i=0,j=0;i<word.length;i++){
			if(symbol[i]==0){
				word_final[j]=word[i];
				word_num[j]=num[i];
				j++;
			}
		}
	}
	/**
	 * �ñ����ķ��������һ�����ʵڶ��ο�ʼ���֣�symbol��1����һ�γ��ֵ�λ�õ�num��1��Ҳ�����ظ�һ�ξͼ�1��
	 * �������������symbolֵΪ0�ĽǱ���word_lower��Ԫ��һ���ǲ��ظ��ģ�ͬʱnum[i]����word_lower[i]������ʵĸ�����
	 * @param word_lower
	 * @param symbol
	 * @param num
	 * @return ���ص����ظ����ܴ���
	 */
	public static int calculateRepeat(String[] word_lower, int[] symbol, int[] num) {
		int num_repeat=0;
		for(int i=0;i<word_lower.length;i++){
			if(symbol[i]==0){ 
				num[i]++;
				for(int j=i+1;j<word_lower.length;j++){
					if(word_lower[j].equals(word_lower[i])){
						num[i]++;
						symbol[j]=1;
						num_repeat++;   //���word_lower�ĳ��ȼ�ȥnum_repeat����ȥ�غ���ַ�������   
					}
				}
			}
		}
		return num_repeat;
	}
	/**
	 * ����������txt�ļ��ж�����Ϣ�����byte[],��ת����String
	 * @param fis
	 * @param sentence
	 * @return
	 */
	public static String getString(FileInputStream fis, String sentence) {
		try{
			fis=new FileInputStream("D:\\eclipse\\workspace\\linkedlist_england\\tempfile\\LinkedList-Wiki.txt");
			
			//����һ���ֽ�����
			byte[] buf=new byte[DEFAULT_SIZE];
			
			int len=0;
			while((len=fis.read(buf))!=-1){
				sentence=new String(buf,0,len);
				//System.out.println("��ȡ�����ַ������£�\n"+sentence);
				}
		}catch(IOException e){
			
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					//һ�����throw RuntimeException�쳣�����߰��쳣��Ϣд����־�ļ�
				}
		}
		return sentence;
	}
	/**
	 * �ѱ�����ȥ����ȥ���У��Ѷ���Ŀո���һ���ո�
	 * @param sentence
	 * @return
	 */
	public static String removePunctuation(String sentence){
		sentence=sentence.replaceAll("[,().-]", " ");
		sentence=sentence.replaceAll("\\s{2,}", " ");  
		sentence=sentence.replaceAll("(?m)^\\s*$"+System.lineSeparator(), "");
		return sentence;
	}

}