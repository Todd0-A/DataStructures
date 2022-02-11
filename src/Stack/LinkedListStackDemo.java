package Stack;


public class LinkedListStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack Lstack= new LinkedListStack(4);
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Lstack.push(node4);
		Lstack.push(node1);
		Lstack.push(node2);
		Lstack.push(node3);
		Lstack.push(node1);
		Lstack.show();
		Lstack.pop();
		Lstack.pop();
		Lstack.pop();
		Lstack.pop();
		Lstack.pop();
		Lstack.pop();
		Lstack.show();
		
	}

}


class LinkedListStack{
	private int max;
	LinkedList stack=new LinkedList();
	private Node top=stack.getHead();
	public LinkedListStack(int max) {
		this.max=max;
	}
	public boolean isFull() {
		boolean flag=false;
		int num=0;
		Node temp=stack.getHead();
		while(true) {
			if(temp.next==null)
				break;
			temp=temp.next;
			num++;
			if(num==max) {
				flag=true;
				break;
			}
			
		}
		
		return flag;
	}
	
	public boolean isEmpty() {
		return top==stack.getHead();
	}
	public void push(Node no) {
		if(isFull()) {
			System.out.println("full stack");
			return;
		}
		top.next=no;
		top=no;
	}
	public void pop() {
		if(isEmpty()) {
			System.out.println("Empty stack");
			return;
		}
		Node temp=stack.getHead();
		while(true) {
			if(temp.next==top) {
				break;
			}
			temp=temp.next;
		}
		top=temp;
		System.out.println("Top:"+temp.next.toString());
	}
	public void show() {
		Node temp=stack.getHead();
		Node temp2=top;
		while(true) {
			if(temp2==stack.getHead())
				break;
			System.out.println(temp2.toString());
			while(true) {
				if(temp.next==temp2)
					break;
				temp=temp.next;
			}
			temp2=temp;
			temp=stack.getHead();
		}
	}
	
}








class LinkedList{
	private Node head=new Node(0);
	
	public void delete(int no) {
		if(head.next==null) {
			System.out.println("Empty LinkedList");
			return;
		}
		Node temp=head;
		boolean flag=false;
		while(true) {
			if(temp.next==null) {
				break;
			}
			if(temp.next.no==no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.next=temp.next.next;
		}else {
			System.out.printf("Node %d not found\n",no);
		}
	}
	

	public Node getHead() {
		return head;
	}
}
class Node{
	public int no;
	public Node next;
	
	public Node(int hNo){
		this.no=hNo;
	}
	@Override
	public String toString() {
		return "[no="+no+"]";
	}
}
