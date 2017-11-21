package day14_0810;

//饿汉式。相对于多线程并发，安全！！
class Single{
	private static final Single SINGLE_INSTANCE=new Single();
	private Single(){}
	public static Single getInstance(){
		return SINGLE_INSTANCE;
	}
}
//懒汉式。延迟加载方式
/*
 在多线程并发访问时，会出现线程安全问题。加同步就可解决问题。
 无论是同步函数还是同步代码块都行。
 
 但是，效率低了。怎么解决效率低的问题
 可以通过if对单例对象的双重判断的形式。
 */
class Single1{
	private static Single1 s=null;
	private Single1(){}
	public static /*synchronized*/ Single1 getInstance(){  //加上同步
		if(s==null){
			//其他线程在这里等
			synchronized(Single1.class){
				if(s==null)
					s=new Single1();
			}
		}
		return s;
	}
}

class Demo implements Runnable{
	public void run(){
		Single.getInstance();
	}
}




public class ThreadSingleTest {
	public static void main(String[] args) {
		

	}

}
