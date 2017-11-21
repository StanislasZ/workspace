package map;

import java.util.HashMap;
import java.util.Map;

import domain.Employee;

public class HashMapTest {

	public static void main(String[] args) {
		
		//1.将员工和归属存储到HashMap集合中并取出。同姓名同年龄视为同一个员工
		
		Map<Employee,String> map=new HashMap<Employee,String>();//如果改成LinkedHashMap，可以实现有序。
		
		map.put(new Employee("xiaozhang",24), "北京 ");
		map.put(new Employee("laoli",34), "上海 ");
		map.put(new Employee("mingming",26), "南京 ");
		map.put(new Employee("xili",30), "广州 ");
		map.put(new Employee("laoli",34), "铁岭 ");
		
		
		for(Employee employee:map.keySet()){
			String value=map.get(employee);
			System.out.println(employee.getName()+":"+employee.getAge()+"...."+value);
		}
		

	}

}
