package filter;

import java.io.File;
import java.io.FileFilter;

public class FilterByFile implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		
		return pathname.isFile();
		
		//���ļ�������Ҳ��ʵ���ļ����������Ĺ���  ����
		//return pathname.getName().endsWith(".java");
	}

}
