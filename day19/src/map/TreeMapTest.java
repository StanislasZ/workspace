package map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import domain.Employee;

public class TreeMapTest {

	public static void main(String[] args) {
		//2.����ѧ�������������������ȡ��.		����ѧ��������������������ȡ��

		//����Ƚ���
		Comparator<Employee> comp=new Comparator<Employee>(){
			@Override
			public int compare(Employee o1, Employee o2) {
				int temp=o1.getName().compareTo(o2.getName());
				return temp==0?o1.getAge()-o2.getAge():temp;
			}
		
		};
		
		Map<Employee,String> map=new TreeMap<Employee,String>(comp);    //������comp�����䣬  ����comp����������
		map.put(new Employee("xiaozhang",24), "���� ");
		map.put(new Employee("laoli",34), "�Ϻ� ");
		map.put(new Employee("mingming",26), "�Ͼ� ");
		map.put(new Employee("xili",30), "���� ");
		map.put(new Employee("laoli",34), "���� ");
		
		//entrySet
		Set<Map.Entry<Employee,String>> entryset=map.entrySet();
		
		for(Map.Entry<Employee, String> me:entryset){
			Employee key=me.getKey();
			String value=me.getValue();
			System.out.println(key.getName()+"::"+key.getAge()+"...."+value);
		}
	}

}
