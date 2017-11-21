package demo;

import domain.Employee;

public class Demo_P226 {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		try{
			Employee a1=new Employee("li",50000);
			a1.setHireday(2000, 1, 1);
			Employee a2=a1.clone();
			a2.raiseSalary(10);
			a2.setHireday(2002, 12, 12);
			System.out.println("a1="+a1);
			System.out.println("a2="+a2);
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		
		
	}

}

