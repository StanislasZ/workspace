package day03_0620;
//day03-��Ƶ25-��Ԫ
import java.util.*; //Ҫʹ������
public class OperateDemo5 
{

	public static void main(String[] args)
	{
		/*
		//��Ԫ����� ���������ʽ�������ʽ1�����ʽ2
		int x=2,y;
		y=x>1?100:200;
		System.out.println("y="+y);
		*/
		
		//��������������֪���������ĸ�
		int a,b,c,max;
		
		Scanner in=new Scanner(System.in);//����һ��Scanner���󣬲����׼������System in����
		//�������Ϳ���ʹ��Scanner��ĸ��ַ���ʵ�����������
		
		
		
		System.out.print("a=?");
		a=in.nextInt();
		System.out.print("b=?");
		b=in.nextInt();
		System.out.print("c=?");
		c=in.nextInt();
		
		max=a>b?(a>c?a:c):(b>c?b:c);
		System.out.println("max="+max);
		
		
		
		
	}

}
