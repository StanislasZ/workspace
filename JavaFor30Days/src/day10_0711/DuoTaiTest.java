package day10_0711;    //52(2)-多态练习

/*
 毕姥爷    讲课  钓鱼
 毕老师 extends 毕姥爷
 	讲课
 	看电影
 要求体现多态。   要看到向上转型，向下转型
 */

//描述毕姥爷
class 毕姥爷{
	public void teach(){
		System.out.println("管理");
	}
	public void fish(){
		System.out.println("钓鱼");
	}
}
class 毕老师 extends 毕姥爷{
	public void teach(){
		System.out.println("技术");  //覆盖
	}
	public void movie(){
		System.out.println("看电影");   
	}
}


public class DuoTaiTest {
	public static void main(String[] args) {
		毕姥爷 x=new 毕老师();    //向上转型
		x.teach();
		x.fish();
		
		//要想使用毕老师的特有方法  看电影。
		毕老师 y=(毕老师)x;      //向下转型
		y.movie();

		//转型过程中，自始至终，只有子类对象在做着类型的变化。
	}

}
