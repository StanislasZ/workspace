package demo;

import java.io.FileInputStream;
import java.io.IOException;


public class Demo1 {
	private static final int DEFAULT_SIZE = 1024*2;
	public static void main(String[] args) {
		
		
		//Read the information from the file   读入txt的内容，变成一个字符串
		FileInputStream fis=null;
		String sentence=null;
		sentence = getString(fis, sentence);
			
		//Modify format   把标点符号去掉，去空行，把多余的空格变成一个空格
		sentence=removePunctuation(sentence);
		String[] word=sentence.split(" "); 
				
		//Delete the repeating element in String array and get the times the word occur字符串数组去重（认为大小写是相同的），同时计数
		String[] word_lower=new String[word.length];
		int[] symbol=new int[word.length];    //word_lower的每一个元素对应的标志位。 置1表示与前面的相同。最后这个数组为0的就是去重的了
		int[] num=new int[word.length];
		
		//先得到全小写的字符串数组
		for(int i=0;i<word.length;i++){
			word_lower[i]=word[i].toLowerCase();
		}
		//为了确定之后无重复单词的数组的长度，这里求得重复的总次数。
		int num_repeat= calculateRepeat(word_lower, symbol, num);
				
		//4.求得无重复的单词数组(String[])，并求得对应的一个int数组， 对应单词出现的次数
		String[] word_final=new String[word.length-num_repeat];
		int[] word_num=new int[word.length-num_repeat];
		
		getWordAndNum(word, symbol, num, word_final, word_num);

		
/*---------------------至此，提供给链表的word和 number of occurrence of the word已准备好---------------*/
		
		DoublyLinkedList dll=new DoublyLinkedList();
		//按一个单词，一个数字的顺序装入链表。
		for(int i=0;i<word_final.length;i++){
			dll.add(word_final[i]);
			dll.add(word_num[i]);
		}
		
/*----------------------------------------至此，第一小题做完----------------------------------------*/		
		//2.a Print Doubly linked list 输出链表内容
		System.out.println("put data into list:");
		dll.print();
		
		//2.b Sort ascending and Print the linked list based on the number of occurrence 按照单词出现的次数从小到大进行排序
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
		//现在链表中已经排好序了
		
		while((int)dll.getValue(1)<7){
			dll.remove(0);
		}
		System.out.println("After delete words with the occurrence less than 7 times, the remained linked list is:");
		dll.print();
		
/*------------------------------------------end-----------------------------------------*/
		
	
	}
	/**
	 * 根据之前得到的标记，获取标记为0的角标，根据这个角标找到word和num对应的元素，分别装入word_final和word_num
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
	 * 用遍历的方法，如果一个单词第二次开始出现，symbol置1，第一次出现的位置的num加1（也就是重复一次就加1）
	 * 经过这个方法后，symbol值为0的角标在word_lower的元素一定是不重复的，同时num[i]就是word_lower[i]这个单词的个数。
	 * @param word_lower
	 * @param symbol
	 * @param num
	 * @return 返回的是重复的总次数
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
						num_repeat++;   //最后word_lower的长度减去num_repeat就是去重后的字符串个数   
					}
				}
			}
		}
		return num_repeat;
	}
	/**
	 * 用输入流从txt文件中读入信息，变成byte[],再转化成String
	 * @param fis
	 * @param sentence
	 * @return
	 */
	public static String getString(FileInputStream fis, String sentence) {
		try{
			fis=new FileInputStream("D:\\eclipse\\workspace\\linkedlist_england\\tempfile\\LinkedList-Wiki.txt");
			
			//创建一个字节数组
			byte[] buf=new byte[DEFAULT_SIZE];
			
			int len=0;
			while((len=fis.read(buf))!=-1){
				sentence=new String(buf,0,len);
				//System.out.println("获取到的字符串如下：\n"+sentence);
				}
		}catch(IOException e){
			
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					//一般可以throw RuntimeException异常。或者把异常信息写入日志文件
				}
		}
		return sentence;
	}
	/**
	 * 把标点符号去掉，去空行，把多余的空格变成一个空格
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
