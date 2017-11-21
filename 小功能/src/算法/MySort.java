package �㷨;

public class MySort {
	/**
	 * ��������
	 * @param a
	 */
	public static void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int key=a[i];
			int j=i-1;
			while(j>=0&&a[j]>key){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
		
	}
	/**
	 * �鲢����
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void mergeSort(int[] a,int p,int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(a,p,q);
			mergeSort(a,q+1,r);
			merge(a,p,q,r);
		}
	}
	private static void merge(int[] a,int p,int q,int r){
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		
		for(int i=0;i<L.length-1;i++)
			L[i]=a[p+i];
		for(int i=0;i<R.length-1;i++)
			R[i]=a[q+1+i];
		L[L.length-1]=Integer.MAX_VALUE;
		R[R.length-1]=Integer.MAX_VALUE;
		for(int i=0,j=0,k=p;k<=r;k++){
			if(L[i]<=R[j]){
				a[k]=L[i];
				i++;
			}else{
				a[k]=R[j];
				j++;
			}
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
