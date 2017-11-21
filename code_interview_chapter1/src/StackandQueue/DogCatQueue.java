package StackandQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {

	private Queue<PetplusCount> dogQ;
	private Queue<PetplusCount> catQ;
	private long count;
	
	public DogCatQueue(){
		dogQ=new LinkedList<PetplusCount>();
		catQ=new LinkedList<PetplusCount>();
		this.count=0;
	}
	
	public void add(Pet pet){
		if(pet.getPetType().equals("dog")){
			this.dogQ.add(new PetplusCount(pet, count++));
		}
	}
	
	
}

class PetplusCount{
	private Pet pet;
	private long count;   //加时间戳以区分先后
	
	public PetplusCount(Pet pet, long count) {
		super();
		this.pet = pet;
		this.count = count;
	}
	
	public Pet getPet(){
		return this.pet;
	}
	
	public long getCount(){
		return this.count;
	}
	
	public String getEnterPetType(){
		return this.pet.getPetType();
	}
	
	
}


class Pet{
	private String type;

	public Pet(String type) {
		super();
		this.type = type;
	}
	
	public String getPetType(){
		return this.type;
	}
}
class Dog extends Pet{
	public Dog(){
		super("dog");
	}
}
class Cat extends Pet{
	public Cat(){
		super("cat");
	}
}