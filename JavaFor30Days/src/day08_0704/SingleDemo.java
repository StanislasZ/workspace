package day08_0704;
//day08-17-���ģʽ,18��19��20��21,22-����     getInstance()
/*
 ���ģʽ�����ĳһ�������һ��˼�롣��һ����֮��Ч�Ľ����ʽ��
 
 23��ģʽ��
 
 ֮һ�� �������ģʽ��
 ��������⣺��֤һ����Ķ������ڴ��е�Ψһ�ԡ�
 Ӧ�ó�������������ڲ���ͬһ�������ļ�ʱ����Ҫ����A������Ľ����
 			����BҪ֪��������������A������Ľ�����в�����
 			ǰ�ᣬ���ݶ��洢�������ļ������У�Ҫ�����A�ͳ���B�����������ļ�������ͬһ����
 
 ��ôʵ���أ�  ��ô���Ա�֤�����ֻ�ܲ���һ�������أ�
 
 ˼·��
 	1.�������������򶼿���ͨ��new��������Ķ����޷�����������
 	   ���ԣ�������������new�����£�
 	   
	2.�ǵ�һ��������Ҳ�����ˣ����������򲻾�û�ж�������
	   �ɴ࣬�ڱ������Լ�newһ��������������ĺô��ǣ����ñ�ĳ���new���Լ�new,����ʵ�������Ŀ���
	  	
	3.�����ṩ�����������ȡ�ö���ķ�ʽ���������ˣ�
	
���裺
	1.������������new�������զ�죿
		���Խ����еĹ��캯��˽�л�
	
	2.�ڱ�����newһ������
	
	3.����һ���������أ���ã��ö���
	
�������֣�
 
 */

class Single{    //����ʽ
	//����һ���������
	private static Single s=new Single();  //˽��֮��getIns�Ǳ����
		
	private Single(){		//���캯��˽�л�
	
	}
		
	//����һ���������ظö������������Ի�ȡ����	
	static Single getInstance(int num){     //���뾲̬�����ܱ����ʵ�;�����������Ϊ�˿ɿ�
		if(num<0)return null;
		return s;
	}
		
}
/*
 //����һ����ʽ��  Ҳ��Ϊ �ӳټ��ط�ʽ��
  
class Single{      //����ʽ 
	private static Single s=null;
	private Single(){
	}
	public static Single getInstance(){
		if(s==null)
			s=new Single();
		return s;
	}
}
			
			
			
			
			
 */

public class SingleDemo {
	public static void main(String[] args) {
		
		Single s1=Single.getInstance(1);
		Single s2=Single.getInstance(1);  //s2=s1
		
		//����ֻ��һ��
		
		
		
		
		Superman s3=Superman.getInstance();
		
		
		Superman s4=Superman.getInstance();
		s4.setName("hero");                          //s3,s4ָ��ͬһ������
		
		System.out.println(s3.getName());
		System.out.println(s4.getName());
	}
}
class Superman{
	private String name;
	
	private static Superman man=new Superman("GREEN ARROW");
	
	private Superman(String name){ //���캯��˽��
		this.name=name;
	}
	public static Superman getInstance(){
		return man;
	}
		
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}













