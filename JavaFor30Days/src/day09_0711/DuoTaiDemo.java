package day09_0711;//49-��̬��50-��������

/*
��̬��������̬

	����Ķ�̬�ԡ�

class ����{

}
class �� extends ����{
	
}
//�� x=new ��();

���� x=new ��();   //��ʵ�����ǹ����ͣ����Ƕ������͡���̬�ԡ�

��̬�ڳ����е����֣���������û��߽ӿڵ�����ָ��������Ķ���

��̬�ĺô�������˴������չ�ԡ�

��̬�ı׶ˣ�����ʹ����������з�����

��̬��ǰ�᣺
	1.�����й�ϵ���̳У�ʵ�֡�
	2.ͨ���и��ǡ�
*/

abstract class Animal{
	abstract void eat();
}

class Dog extends Animal{
	void eat(){
		System.out.println("��ͷ");
	}
	void lookHome(){
		System.out.println("����");
	}
}

class Cat extends Animal{
	void eat(){
		System.out.println("��");
	}
	void CatchMouse(){
		System.out.println("ץ����");
	}
}

public class DuoTaiDemo {

	public static void main(String[] args) {
		/*
		//Dog d=new Dog();
		Animal a=new Dog();  //��̬��ʽ
		a.eat();
		Animal b=new Cat();
		b.eat();
		*/
		
		Dog d1=new Dog();
		Dog d2=new Dog();
		Dog d3=new Dog();
		method(d1);
	}
	public static void method(Dog d){
		d.eat();
	}
	
	public static void method(Cat c){
		c.eat();
	}
	//����������Թ��� è�� ��Ȼ���õĶ���eat,�ǹ��ԡ� Ϊʲô����Զ�����
	//ֱ�Ӷ��干�����͵Ĳ���������
	public static void method(Animal a){  //����  ���࣬è��
		a.eat(); 
		//a.lookHome();    //
	}
}
