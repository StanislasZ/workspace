package filter;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 根据文件名的后缀名的过滤器
 * @author guguguagua
 *
 */
public class FilterBySuffix implements FilenameFilter {
	
	private String suffix;
	public FilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}
	/**
	 * @param name 被遍历目录中的文件夹或者文件的名称
	 */
	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
	}

}
