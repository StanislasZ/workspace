package generic.demo;

public class GenericDemo5 {

	public static void main(String[] args) {
		Demo<String> d=new Demo<String>();
		d.show("abc");
		d.print(6);
		d.print('c');
		

	}

}


class Demo<W>{
	public void show(W w){
		System.out.println("show:"+w);
	}
	public <Q> void print(Q q){    //·ºÐÍ·½·¨
		System.out.println("print:"+q);
		
	}
	
	public static <A> void staticShow(A a){
		 
	}
	
	
}