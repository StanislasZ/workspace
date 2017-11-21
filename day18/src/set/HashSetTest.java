package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import domain.Student;

public class HashSetTest {

	public static void main(String[] args) {
		
		/*
		 * 练习：往HashSet中存储学生对象（姓名，年龄）。同姓名，同年龄视为同一个人。
		 * 
		 * 发现同姓名同年龄的学生是可以的
		 * 原因是每一次存储学生对象，都先调用hashCode方法获取哈希值
		 * 但调用的是Object类中的hashCode，所以不同的对象，哈希值也不同
		 * 这就是同姓名同年龄存入的原因
		 * 
		 * 
		 * 解决：需要根据学生对象自身的特点来定义哈希值
		 * 覆盖hashCode方法
		 * 
		 */
		
		//1.创建容器对象
		HashSet set=new HashSet();
		
		Set set1=new LinkedHashSet();
		
		//2.存储学生对象
		set.add(new Student("xiaoqiang",20));
		set.add(new Student("wangcai",27));
		set.add(new Student("wangcai",27));
		set.add(new Student("xiaoming",22));
		set.add(new Student("xiaoming",22));
		
		//3.获取所有学生
		for (Iterator it = set.iterator(); it.hasNext();) {
			Student stu=(Student)it.next();
			
			System.out.println(stu.getName()+"::"+stu.getAge());
		}

	}

}


