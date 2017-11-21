package day03_0620;
//2017.06.20 day03-视频20左移，21-右移，22-位与
//23-或异或取反
public class OperateDemo4 
{

	public static void main(String[] args) 
	{
		System.out.println(6<<2);   //按二进制左移2位即乘2两次
		                             //最高位被舍弃，补0
		
		//左移1次就是*2
		
		
		System.out.println(6>>2);
		//右移时，原最高位是什么就补什么
		
		//>>>无符号右移，无论原最高位是什么，都补0
		
		//2的次幂运算要想到<<,>>
		
		
		System.out.println("6与3="+(6&3));
		//为了获取一段二进制码中的有效位1
		
		System.out.println("6或3="+(6|3));
		
		System.out.println("6或3="+(6|3));
		//一个数异或另一个数两次，结果还是这个数
		
		System.out.println("6取反="+(~6));
		
		
		
		
		
	}

}
