package day10_0711;   //USB接口练习

/*
 阶段一：笔记本电脑运行。笔记本中有一个运行功能。
 
 阶段二：想使用一个鼠标。又有一个功能使用鼠标。并多了一个鼠标对象。
 
 阶段三：还想使用一个键盘功能。又要多个一个功能。
 
 问题：每多一个功能就需要在笔记本对象中定义一个函数。扩展性差！  怎么解决？？
 
 减低鼠标，键盘等外围设备和笔记本电脑的耦合性。
 */
/*
//阶段一：描述笔记本电脑
class NoteBook{
	public void run(){
		System.out.println("管理");
	}
}
*/
/*
//阶段二：需要一个鼠标，说明笔记本中多了一个使用鼠标的功能。

//多了一个对象：鼠标
class Mouse{
	public void open(){  //开启功能
		System.out.println("mouse open");
	}
	public void close(){   //关闭功能
		System.out.println("mouse close");
	}
	
}
class NoteBook{
	public void run(){
		System.out.println("book run");
	}
	
	 //定义使用鼠标功能，鼠标不确定，定义成参数
	 
	public void useMouse(Mouse m){
		//判断m必须指向鼠标对象
		if(m!=null){
		m.open();
		m.close();
		}
	}
}
*/
//到这里程序已OK
//阶段三：如果还想使用其他设备呢？比如键盘，外置硬盘
//可以通过笔记本对象中继续定义useKey()等方法来完成
//但是出现问题：每增加一个设备都需要不断的改动笔记本类中的内容。扩展性差，维护性也不好。

//后期的设备是不确定的，每多一个设备就加一个功能，说明设备和笔记本的耦合性太强
//不要每次都面的具体的类型，只要定义一个规则，让后期的设备都符合这个规则，这样只要面对规则就可以了

//java中可以通过接口的形式来完成规则的定义，进行解耦。

//重新设计，先定义规则
interface USB{
	/**
	 设备开启
	 */
	public void open();
	/**
	 设备关闭
	 */
	public void close();
	
}
class NoteBook{
	/**
	 运行
	 */
	public void run(){
		System.out.println("book run");
	}
	/**
	 使用符合规则的外围设备
	 */
	public void useUSB(USB usb){     //定义了一个接口类型的引用   //USB usb=new MouseByUB(); 多态
		if(usb!=null){
			usb.open();
			usb.close();
		}
	}
}
//一年后，想换个鼠标。只要买一个符合规则的鼠标，笔记本电脑就可以用
class MouseByUSB implements USB{
	public void open(){
		System.out.println("mouse open");
	}
	public void close(){
		System.out.println("mouse close");
	}
}
//想要键盘
class KeyByUSB implements USB{
	public void open(){
		System.out.println("key open");
	}
	public void close(){
		System.out.println("key close");
	}
}


public class USBTest {
	public static void main(String[] args) {
		NoteBook book=new NoteBook();
		book.run();
		//book.useMouse(new Mouse());
		book.useUSB(new MouseByUSB());
		book.useUSB(new KeyByUSB());
	}

}
