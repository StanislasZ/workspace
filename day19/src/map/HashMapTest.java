package map;

import java.util.HashMap;
import java.util.Map;

import domain.Employee;

public class HashMapTest {

	public static void main(String[] args) {
		
		//1.��Ա���͹����洢��HashMap�����в�ȡ����ͬ����ͬ������Ϊͬһ��Ա��
		
		Map<Employee,String> map=new HashMap<Employee,String>();//����ĳ�LinkedHashMap������ʵ������
		
		map.put(new Employee("xiaozhang",24), "���� ");
		map.put(new Employee("laoli",34), "�Ϻ� ");
		map.put(new Employee("mingming",26), "�Ͼ� ");
		map.put(new Employee("xili",30), "���� ");
		map.put(new Employee("laoli",34), "���� ");
		
		
		for(Employee employee:map.keySet()){
			String value=map.get(employee);
			System.out.println(employee.getName()+":"+employee.getAge()+"...."+value);
		}
		

	}

}
