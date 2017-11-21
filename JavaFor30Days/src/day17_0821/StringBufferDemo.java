package day17_0821;

public class StringBufferDemo {
	public static void main(String[] args) {
		/*
		 StringBuffer:字符串缓冲区
		 作为一个字符容器
		 特点：
		 	1.长度可以变化
		 	2.通过指定方法可以对内容进行修改
		 	3.容器对象一般都会具备对容器中的元素进行操作的功能。增删改查
		 	4.缓冲区可以存储不同类型的数据
		 */
		String str;
		//在内存中的过程。1.创建一个字符串缓冲区容器。2.将要组成字符串的元素先存储起来
		str=new StringBuffer().append("a").append(4).append('c').toString();
		System.out.println(str);
				
		
	}

}
