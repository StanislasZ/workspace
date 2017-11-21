package someproblem;

public class algorithm1_zry {

	public static void main(String[] args) {
		
		//array w=new array();
		//w.setTarget(10);
		//w.find();


	}
}

class MyArray{
	int[] a= {3,6,8,2,4,7};
	private int target;
	public void setTarget(int b) {
		target=b;
	}
	public int getTarget() {
		return target;
	}
	public void find() {
	for(int x=0;x<a.length-1;x++) {
		for(int y=x+1;y<a.length;y++) {
			int z=a[x]+a[y];
			if(z==target) {
				System.out.println("the numbers are"+x+","+y);
				
		
			}
			else {
				continue;
			}
			
		}
		
	}
  }
}

	
	
	


