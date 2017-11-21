import java.time.LocalDate;

//P121
class Employee1{
	private String name;
	private double salary;
		
	public Employee1(String name,double salary){
		this.name=name;
		this.salary=salary;
	}
	public String getName(){                //name私有，必须搞个getName函数来获取name 
		return name;
	}
	public double getSalary(){   
		return salary;
	}
	public void raiseSalary(double byPercent){
		double raise=salary*byPercent/100;
		salary+=raise;
	}
}
public class P121ParaTest {
	public static void main(String[] args) {
		System.out.println("Testing tripleValue:");
		double percent=10;
		System.out.println("Before:percent="+percent);
		tripleValue(percent);
		System.out.println("After:percent="+percent);
		
		//以上结果是percent没变， 爆炸
		System.out.println("\nTesting tripleSalary:");
		Employee1 harry=new Employee1("Harry",50000);
		System.out.println("Before:salary="+harry.getSalary());
		tripleSalary(harry);
		System.out.println("After:salary="+harry.getSalary());
		//以上方法成功
		
		System.out.println("\nTesting swap:");
		Employee1 a=new Employee1("Alice",70000);
		Employee1 b=new Employee1("Bob",60000);
		System.out.println("Before:a="+a.getName());
		System.out.println("Before:b="+b.getName());
//		swap(a,b);

		Employee1 temp=a;
		a=b;
		b=temp;
		
		System.out.println("After:a="+a.getName());
		System.out.println("After:b="+b.getName());       //没有换成功
		

	}
	public static void tripleValue(double x){    //爆炸
		x=3*x;
		System.out.println("End of method:x="+x);
	}
	public static void tripleSalary(Employee1 x){   //拿下
		x.raiseSalary(200);
		System.out.println("End of method:salary="+x.getSalary());
	}
	public static void swap(Employee1 x,Employee1 y){    //换成员  
		Employee1 temp=x;
		x=y;
		y=temp;
		System.out.println("End of method:x="+x.getName());
		System.out.println("End of method:y="+y.getName());
		
		
	}
}
