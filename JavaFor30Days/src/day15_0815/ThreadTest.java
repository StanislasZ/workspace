package day15_0815;







public class ThreadTest {
	public static void main(String[] args) {
		
		new Thread(){           //匿名内部类
			public void run(){
				for(int i=0;i<50;i++){
					System.out.println("i="+i);
				}
			}
		}.start();   
		
		Runnable r=new Runnable(){
			public void run(){
				for(int x=0;x<50;x++){
					System.out.println("x="+x);
				}
			}
		};
		new Thread(r).start();
		
		
		
		for(int y=0;y<50;y++){
			System.out.println("y="+y);
		}
//----------以下代码的结果是什么----------------------------------
		new Thread(new Runnable(){
			public void run(){
				System.out.println("runnable run...");
			}
		})
		{
			public void run(){  //覆盖父类，以子类为主
				System.out.println("subThread...run....");
			}
		}.start();
		
	}

}
