package day05_0628;
//day06-12-��װ��13-˽�У���Ա����˽�У�����˽��
/*
��������������������װ���̳У���̬

��װ������ʵ��ϸ�ڣ������ṩ�����ķ��ʷ�ʽ���ӿڣ���   ��������һ�ѿڣ����Ͼ����ã������ǲ�֪������Ľ���

��װ������֮һ�������Զ�˽�л��������ṩ��Ӧ��setXXX getXXX�ķ��������ʡ�

��װ�ĺô���
	1.��߰�ȫ�ԡ�������ֱ�ӷ���ϸ�ڡ���ͨ�������ķ�ʽ������
	2.����������ԡ�
	3.����˸����ԡ�
	4.�����˱仯��
*/

/*
�����ˡ�
	���ԣ�����
	��Ϊ��˵��

*/
class Person{
	private int age;     //private��˽�У�Ȩ�����η�������Ȩ�޾ͽ�����
	/*
	 ��˽�е����ݣ�����ͨ�������ķ�ʽ������з��ʡ�
	 */
	
	public void setAge(int a){    //��������
		if(a<0||a>130){
			//System.out.println(a+"��ֵ�Ǵ����");
			//�׳��쳣
			throw new RuntimeException(a+"��ֵ�Ǵ����");
		}
		else{
			age=a;
		}
	}
	
	public int getAge(){ 
		return age;        //ȡ�������������
	}
	
	
	void speak(){
		System.out.println("age="+age);
	}
}
public class Encapsulation_PersonDemo {

	public static void main(String[] args) {
		//����Person�Ķ��󡣵���Person�����Ժ���Ϊ
		Person p=new Person();           //���ڴ��д���һ������
		//p.age=-20;                  //�ܸ����ݣ��ܷ���age)����ô���÷���age
		p.setAge(20);
		
		int a=p.getAge();         //���� ����.����  ȡ������
		System.out.println(a);
		
		p.speak();

	}

}
/*
 ����˽�У���

class ArrayTool{
	public void selectSort(int[] arr){
		swap(arr,a,b);
	}
	
	public void bubbleSort(int[] arr){
		swap(arr,a,b);
	}
	
	private void swap(int[] arr,int a,int b){  
		//֮ǰ����Ķ���public�����������swapֻҪ�����������þ��У�����Ҫ������ ֱ��˽�У�
		
		
	}
	
}
*/


