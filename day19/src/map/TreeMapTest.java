package map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import domain.Employee;

public class TreeMapTest {

	public static void main(String[] args) {
		//2.按照学生的年龄进行升序排序并取出.		按照学生的姓名进行升序排序并取出

		//定义比较器
		Comparator<Employee> comp=new Comparator<Employee>(){
			@Override
			public int compare(Employee o1, Employee o2) {
				int temp=o1.getName().compareTo(o2.getName());
				return temp==0?o1.getAge()-o2.getAge():temp;
			}
		
		};
		
		Map<Employee,String> map=new TreeMap<Employee,String>(comp);    //不输入comp按年龄，  输入comp按名字排序
		map.put(new Employee("xiaozhang",24), "北京 ");
		map.put(new Employee("laoli",34), "上海 ");
		map.put(new Employee("mingming",26), "南京 ");
		map.put(new Employee("xili",30), "广州 ");
		map.put(new Employee("laoli",34), "铁岭 ");
		
		//entrySet
		Set<Map.Entry<Employee,String>> entryset=map.entrySet();
		
		for(Map.Entry<Employee, String> me:entryset){
			Employee key=me.getKey();
			String value=me.getValue();
			System.out.println(key.getName()+"::"+key.getAge()+"...."+value);
		}
	}

}
