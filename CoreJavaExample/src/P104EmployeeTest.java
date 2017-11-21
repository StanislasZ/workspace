//����P104н�����ϵͳ
import java.time.*;
class Employee{
	private String name;
	private double salary;
	private LocalDate hireday;
	
	public Employee(String name,double salary,int year,int month,int day){
		this.name=name;
		this.salary=salary;
		this.hireday=LocalDate.of(year, month, day);
	}
	
	public String getName(){                //name˽�У�������getName��������ȡname 
		return name;
	}
	public double getSalary(){   
		return salary;
	}
	public LocalDate getHireday(){
		return hireday;
	}
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
}

public class P104EmployeeTest {
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Carl Cracker",75000,1987,12,15);
		staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
		staff[2]=new Employee("Tony Tester",40000,1990,3,15);
		
		//ÿ����н5%  ��for each
		for(Employee person:staff)
			person.raiseSalary(5);
		
		//���ÿ���˵�����  ��for each
		for(Employee person:staff){
			System.out.println("name="+person.getName()+",salary="+person.getSalary()+",hireday="+person.getHireday());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
