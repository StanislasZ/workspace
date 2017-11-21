package filter;

import java.io.File;
import java.io.FileFilter;

public class FileFilterBySuffix implements FileFilter {

	private String suffix;
	
	
	public FileFilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}


	@Override
	public boolean accept(File pathname) {
		// TODO 自动生成的方法存根
		return pathname.getName().endsWith(suffix);
	}

}
