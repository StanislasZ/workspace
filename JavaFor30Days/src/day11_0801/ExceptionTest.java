package day11_0801;

/*
 小节：
 	异常：将问题封装成对象，并抛给调用者。
 		  如果声明了，就需要调用者处理（继续声明or捕获）
 		  什么时候声明，什么时候捕获？
 		  功能内部可以解决，就捕获。   解决了还必须告诉调用者问题这时就应该声明
 
 举例：
 	毕老师用电脑上课。 
 	
 	上课过程中会发生问题，比如：电脑蓝屏，电脑冒烟了。
 	需要对问题进行描述
 
 */

class LanpingException extends Exception{   //蓝屏
	LanpingException(){
		super();
	}
	LanpingException(String message){
		super(message);
	}
}
class MaoyanException extends Exception{    //冒烟
	MaoyanException(){
		super();
	}
	MaoyanException(String message){
		super(message);
	}
}
class NoplanException extends Exception{
	NoplanException(){
		super();
	}
	NoplanException(String message){
		super(message);
	}
}


class Computer{
	private int state=2;  
	public void run() throws LanpingException,MaoyanException{
		if(state==1)
			throw new LanpingException("电脑蓝屏了");
		if(state==2)
			throw new MaoyanException("电脑冒烟了");
		System.out.println("电脑运行");
	}
	public void reset(){
		state=0;
		System.out.println("电脑重启");
	}
}
class Teacher{
	private String name;
	private Computer comp;
	Teacher(String name){
		this.name=name;
		comp=new Computer();
	}
	//讲课
	public void prelect() throws NoplanException{
		try{
			comp.run();
			System.out.println("讲课");
		}
		catch(LanpingException e){
			System.out.println(e.toString());
			comp.reset();   //解决了
			//继续讲课
			prelect();
		}
		catch(MaoyanException e){   //MaoyanException e=MaoyanException();
			System.out.println(e.toString());
			test();//相当于没处理
			//throw e;   //解决不了，往外抛
			throw new NoplanException("课时进度停止");//进行了转换异常，再往外抛
		}
		
	}
	public void test(){
		System.out.println("做练习");
	}
}

public class ExceptionTest {
	public static void main(String[] args) {
		Teacher t=new Teacher("毕老师");
		try{
			t.prelect();
		}
		catch(NoplanException e){
			System.out.println(e.toString());
			System.out.println("换老师");
		}
	}

}



/*
 class APP{
 	public void show()	{
 		try{
 			new DBTool().operate();
 		}
 		catch(SQLException e){
 			
 		}
 	
 	
 	}
 
 
 
 }
 class DBTool{
 	public void operate() throws NovalueException{
 		//连接数据库
 		 try{
 		 
 		 }
 		 //数据操作 throw new SQLException()
 		 catch(SQLException e){
 		 	//解决了数据库异常
 		 	 throw new NovalueException();
 		 }
 		 
 		 fianlly{
 			//关闭数据库
 		 }
 	
 	}
 
 
 
 
 }
 
 
 
 
 
 
 
 */













