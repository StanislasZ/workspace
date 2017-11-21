package demo;

public class Demo_staticinnerclass_P257 {

	public static void main(String[] args) {
		double[] d=new double[20];
		for (int i = 0; i < d.length; i++) {
			d[i]=100*Math.random();
		}
		ArrayAlg1.Pair p=ArrayAlg1.minmax(d);
		
		System.out.println("min="+p.getFirst());
		System.out.println("max="+p.getSecond());

	}

}
class ArrayAlg1{
	public static class Pair{
		private double first;
		private double second;
		public Pair(double first, double second) {
			super();
			this.first = first;
			this.second = second;
		}
		public double getFirst() {
			return first;
		}
		public double getSecond() {
			return second;
		}
		
	}
	public static Pair minmax(double[] values){
		double min=Double.POSITIVE_INFINITY;
		double max=Double.NEGATIVE_INFINITY;
		for(double element:values){
			if(min>element)min=element;
			if(max<element)max=element;
		}
		return new Pair(min,max);
		
		
		
	}
}