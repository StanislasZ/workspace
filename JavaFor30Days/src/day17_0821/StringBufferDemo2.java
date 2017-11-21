package day17_0821;

public class StringBufferDemo2 {

	public static void main(String[] args) {
		/*
		 * StringBuffer
		 * 缓冲区可以对数据进行临时存储。
		 * 
		 * 了解缓冲区的常见方法。
		 * 添加元素：
		 * StringBuffer append(各种类型的数据);  追加
		 * StringBuffer insert(index,各种类型的数据);  指定位置添加
		 * 
		 */
		
		//1.创建一个缓冲区对象
		StringBuffer sb=new StringBuffer();
		
		//2.追加一个字符串
		sb.append("abc");
		
		//3.插入一个boolean值true
		sb.insert(1, true);
		
		//4.删除字符
		//sb.delete(1, 4);
		
		//5.修改字符
		sb.replace(1, 5, "false");
		
		//sb.setLength(20);
		sb.reverse();
		
		System.out.println(sb); //println方法将所有要打印的数据先转成字符串，再输出。对于对象，会自动调用toString方法

		/*
		 * 字符串缓冲区维护了一个"可变长度的数组"
		 * 解释：其实就是超出内部数组长度后，新建数组，长度为原来的1.x倍
		 * 并将原数组的数据复制到新数组中，并将新的元素也添加到新数组中。
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
