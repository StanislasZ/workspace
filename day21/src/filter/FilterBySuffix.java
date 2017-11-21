package filter;

import java.io.File;
import java.io.FilenameFilter;
/**
 * �����ļ����ĺ�׺���Ĺ�����
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
	 * @param name ������Ŀ¼�е��ļ��л����ļ�������
	 */
	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith(suffix);
	}

}
