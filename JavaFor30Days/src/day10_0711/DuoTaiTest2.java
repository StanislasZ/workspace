package day10_0711;

class Fu1{
	int num=5;
	void show(){
		System.out.println("num="+this.num);
	}
}

class Zi1 extends Fu1{
	int num=6;
//	void show(){
//		System.out.println("num="+this.num);
//	}
}


public class DuoTaiTest2 {
	public static void main(String[] args) {
		
		Fu1 f=new Zi1();
		f.show();         //
	}

}
