package day15_0815;







public class ThreadTest {
	public static void main(String[] args) {
		
		new Thread(){           //�����ڲ���
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
//----------���´���Ľ����ʲô----------------------------------
		new Thread(new Runnable(){
			public void run(){
				System.out.println("runnable run...");
			}
		})
		{
			public void run(){  //���Ǹ��࣬������Ϊ��
				System.out.println("subThread...run....");
			}
		}.start();
		
	}

}
