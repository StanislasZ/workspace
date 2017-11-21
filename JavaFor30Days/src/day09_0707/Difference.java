package day09_0707;
//day09-48-抽象类和接口的区别

/*
 例子：描述犬，里面有吃，叫。都是抽象的。具体由子类完成。
 问题：定义成抽象类还是接口呢？
 */

abstract class 犬{
	abstract void 吃();
	abstract void 叫();
}

//添加一个功能。  缉毒     单独描述一个缉毒功能犬
class 缉毒犬2 extends 犬{
	void 吃(){}
	void 叫(){}
	void 缉毒(){}
}

/*缉毒犬是犬中一种， is a关系
犬用于描述所有功能犬的基本功能。用class定义。父类
所以 犬 不适合定义成接口
*/

class 缉毒猪{
	void 缉毒(){}
}
//具备缉毒功能的有很多。缉毒功能需要抽取。抽取到类中，还是抽取到接口中？

abstract class 缉毒1{				//不行，缉毒犬继承了犬类，就不能继承其他类
	abstract void 缉毒();			//定义成接口试试
}

interface 缉毒{
	abstract void 缉毒1();
}
class 缉毒犬 extends 犬 implements 缉毒{
	void 吃(){}
	void 叫(){}
	public void 缉毒1(){
		
	}
}
//这是可行的。  类描述事物的共性，基本功能
//            接口定义的都是事物的额外功能。

/*
 抽象类和接口的区别？
 	1.抽象类中可以定义抽象和非抽象方法，子类可以直接使用，或者覆盖使用
 	   接口中定义的都是没有具体内容的方法，必须实现才能用
 */

public class Difference {
	public static void main(String[] args) {
		

	}

}
