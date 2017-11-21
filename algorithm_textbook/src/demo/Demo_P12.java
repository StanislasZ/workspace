package demo;

public class Demo_P12 {

	public static void main(String[] args) {
		
		GenericMemoryCell<Integer> m=new GenericMemoryCell<Integer>();
		m.write(37);
		int val=m.read();
		System.out.println("Contents are: "+val);
	}
	
	public static <T> boolean mycontains(T[] arr,T x){
		for(T value:arr){
			if(x.equals(value))
				return true;
		}
		return false;
	}

}

class GenericMemoryCell<T>{
	
	private T storedValue;
	public T read(){
		return storedValue;
	}
	public void write(T t){
		storedValue=t;
	}
}