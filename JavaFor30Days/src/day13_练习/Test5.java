package day13_��ϰ;

//�������

class Circle2{
	private double radius;
	public Circle2(double r){
		radius=r;
	}
	//�붨�幦�ܣ��Ƚ�����Բ�Ƿ�һ����
	public boolean equals(Object obj){    //�Զ�����ͬ�����ݣ����ǰ뾶��ͬ
		if(!(obj instanceof Circle2))
			throw new ClassCastException(obj.getClass().getName()+"���ʹ���");
		//����ת��
		Circle2 c=(Circle2)obj;
		return c.radius==this.radius;
	}
}


public class Test5 {
	public static void main(String[] args) {
		Circle2 cir1=new Circle2(2.0);
		Circle2 cir2=new Circle2(2.0);
		String c="a";
		boolean b=cir1.equals(cir2);
		//boolean b=cir1.equals(c);
		System.out.println("����Բ�Ƿ�һ����:"+b);

	}

}
