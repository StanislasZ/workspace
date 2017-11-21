package filter;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByContain implements FilenameFilter {
	private String contain;
	public FilterByContain(String contain) {
		super();
		this.contain = contain;
	}
	@Override
	public boolean accept(File dir, String name) {
		
		return name.contains(contain);
	}

}
