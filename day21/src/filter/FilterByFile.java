package filter;

import java.io.File;
import java.io.FileFilter;

public class FilterByFile implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		
		return pathname.isFile();
		
		//用文件过滤器也能实现文件名过滤器的功能  如下
		//return pathname.getName().endsWith(".java");
	}

}
