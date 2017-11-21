package staticimport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;
import static java.util.Collections.*;

public class StaticImportDemo {

	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();

		list.add("b");
		list.add("a");
		
		
		
		sort(list);
		out.println(list);
		
		
	}

}
