package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo_online {

	public static void main(String[] args) {
//		List<String> l = new ArrayList<>();  
//	    l.add("alpha");  
//	    l.add("beta");  
//	    l = l.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());  
//	    System.out.println(l);  
	
		List<String> collected = new ArrayList<>();  
	    collected.add("alpha");  
	    collected.add("beta");  
	    collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化  
	    System.out.println(collected);
	   
	    
	
	}

}
