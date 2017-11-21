package generic.demo;

public class GenericDemo6 {

	public static void main(String[] args) {
		
		SubDemo d=new SubDemo();
		d.show("abc");
	}

}

interface Inter<T>{
	public void show(T t);
}

class InterImpl<W> implements Inter<W>{

	@Override
	public void show(W t) {
		System.out.println("show:"+t);
		
	}
	
}

class SubDemo extends InterImpl<String>{
	
}








