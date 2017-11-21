package demo;

public class DoublyLinkedList {

	private Node header;  //header node  
	private Node trailer; //trailer node 
	
	private int size; 	  //size of doubly linked list 
	
	//constructor with no parameter
	public DoublyLinkedList() {   
		size=0;
		header=new Node("header"); 		//initialize header node
		trailer=new Node("trailer"); 	//initialize trailer node
		header.setNext(trailer);        
		trailer.setPrev(header);
		
	}
	
	//Appends the specified element to the end of this list.
	public void add(Object data){
		Node newnode=new Node(data);
	
		Node temp=trailer.getPrev();
		temp.setNext(newnode);
		newnode.setPrev(temp);
		trailer.setPrev(newnode);
		newnode.setNext(trailer);
		
		size++;
	}
	//Inserts the specified element at the specified position in this list.
	public void add(int index,Object data){
		if(index<0||index>=this.getSize())
			throw new RuntimeException("The index is out of range of list");
		
		Node newnode=new Node(data);
		Node temp1=this.getNode(index);
		Node temp2=temp1.getNext();
		
		temp1.setNext(newnode);
		newnode.setPrev(temp1);
		temp2.setPrev(newnode);
		newnode.setNext(temp2);

		size++;
	}
	
	//Removes the element at the specified position in this list.
	//Everytime i remove, i remove 2 nodes.
	public void remove(int index){
		if(index<0||index>=this.getSize())
			throw new RuntimeException("The index is out of range of list");
		
		if(index<=1){ 
			header.setNext(this.getNode(2));
			this.getNode(2).setPrev(header);
		}else if(index>=this.getSize()-2){
			trailer.setPrev(this.getNode(getSize()-3));
			this.getNode(getSize()-3).setNext(trailer);
		}else{
			Node temp1,temp2;
			if(index%2==0){
				temp1=this.getNode(index).getPrev();
				temp2=this.getNode(index).getNext().getNext();
				
				temp1.setNext(temp2);
				temp2.setPrev(temp1);
			}else{
				temp1=this.getNode(index).getPrev().getPrev();
				temp2=this.getNode(index).getNext();
				temp1.setNext(temp2);
				temp2.setPrev(temp1);
			}
		}
		size=size-2;
	}
	//Removes and returns the first element from this list.
	public Object removeFirst(){
		Object o=this.getValue(0);
		this.remove(0);
		return o;
	}
	//Removes and returns the last element from this list.
	public Object removeLast(){
		Object o=this.getValue(getSize()-1);
		this.remove(getSize()-1);
		return o;
	}
	
	
	//Get node in specific position.       
	private Node getNode(int index){  
		if (index < 0 || index >= size)  
			throw new IndexOutOfBoundsException();  
	    		
		Node node=null;
		if(index<this.getSize()/2){
			node = header.getNext();
		    for (int i = 0; i < index; i++)  
		    	node = node.getNext();  
		}else {
			node=trailer.getPrev();
			for(int i=this.getSize()-1;i>index;i--)
				node=node.getPrev();
		}
	    return node; 
	}  
	
	//Get value from node in specific position
	public Object getValue(int index){
		Node temp=getNode(index);
		return temp.getData();
	}
	
	//Returns true if this list contains no elements.
	public boolean isEmpty(){
		if(this.getSize()==0)
			return true;
		else
			return false;
	}
	
	

	@Override
	public String toString() {
		String str="";
		for(int i=0;i<this.getSize();i++){
			if(i%2==0){
				str=str+(String)this.getValue(i)+" ";
			}else{
				str+=(int)this.getValue(i)+" ";
			}
		}
		return str;
	}
	
	//Insertion sort based on the number of occurrence.
	public void sort(){
		int step=2;
		for(int i=3;i<this.getSize();i=i+2){
			int time=(int)this.getValue(i);
			String word=(String)this.getValue(i-1);
			
			
			int j=i-step;
			while(j>=1&&(int)this.getValue(j)>time){
				//1.第j个结点的data(int)赋给第j+2个结点
				this.getNode(j+2).setData(this.getNode(j).getData());
				//2.第j-1个结点的data(String)赋给第j+1个结点
				this.getNode(j+1).setData(this.getNode(j-1).getData());
				
				j=j-step;
			}
			//3.key赋给第j+2个结点
			this.getNode(j+2).setData(time);
			//4.word赋给第j+1个结点
			this.getNode(j+1).setData(word);
			
		}
		
	}
	//Print the data of doubly linked list.	
	public void print(){
		System.out.println(this.toString());
	}
	//get the size of the list
	public int getSize() {
		return size;
	}
}
class Node{  		
	Object data;  	//数据域
	private Node prev;  //前结点
	private Node next;  //后结点
	
	Node(Object v) {
      data = v;
      prev=null;
      next=null;
    }
    public String toString() {
      return data.toString();
    }
    
	public Node getPrev() {   			//获取前一个结点
		
		return prev;
	}
	public void setPrev(Node prev) {	//设置前一个结点
		this.prev = prev;
	}
	public Node getNext() {				//获取后一个结点
		return next;
	}
	public void setNext(Node next) {	//设置有一个结点
		this.next = next;
	}
	public Object getData() { 				//获取此结点的数据，类型为T
		return this.data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
    
    
}