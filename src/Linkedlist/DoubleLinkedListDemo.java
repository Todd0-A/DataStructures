package Linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList Dlist=new DoubleLinkedList();
		Node hero1 =new Node(1,"AAA","A");
		Node hero2=new Node(2,"BBB","B");
		Node hero3 =new Node(6,"CCC","C");
		Node hero4=new Node(7,"DDD","D");
		Dlist.insert(hero4);
		Dlist.insert(hero3);
		Dlist.insert(hero2);
		Dlist.insert(hero1);
		Dlist.show();
	}

}


class DoubleLinkedList{
		private Node head=new Node(0,"","");
		
		public Node getHead() {
			return head;
		}
		
		public void show() {
			if(head.next==null){
				System.out.println("Empty LinkedList");
				return;	
			}
			Node temp=head.next;
			while(true) {
				if(temp==null) {
					break;
				}
				System.out.println(temp.toString());
				temp=temp.next;
			}
		}
		
		public void insert(Node node) {
			Node temp=head;
			boolean flag=false;
			while(true){
				if(temp.next==null) {
					break;
				}
				if(temp.no>node.no) {
					break;
				}else if(temp.no==node.no) {
					flag=true;
					break;
				}
				temp=temp.next;
			}
			if(flag)
				System.out.printf("Insert node %d already exists\n",node.no);
			else {
				if(temp.pre!=null) {
					temp.pre.next=node;
					node.pre=temp.pre;
					temp.pre=node;
					node.next=temp;
					
				}else {
					temp.next=node;
					node.pre=temp;
				}
			}
		}
		
		
		public void delete(int no) {
			if(head.next==null) {
				System.out.println("Empty DoubleLinkedList,can not delete");
				return;
			}
			Node temp=head.next;
			boolean flag=false;
			while(true) {
				if(temp==null) {
					break;
				}
				if(temp.no==no) {
					flag=true;
					break;
				}
				temp=temp.next;
			}
			if(flag) {
				temp.pre.next=temp.next;
				if(temp.next!=null) {
					temp.next.pre=temp.pre;
				}
				
			}
			
		}
		public void update(Node node) {
			if(head.next==null) {
				System.out.println("Empty LinkedList");
				return;
			}
			boolean flag=false;
			Node temp=head;
			while(true) {
				if(temp==null)
					break;
				if(temp.no==node.no) {
					flag=true;
					break;
				}
				temp=temp.next;
			}
			if(flag) {
				temp.name=node.name;
				temp.nickname=node.nickname;
			}else {
				System.out.printf("Node %d not found\n", node.no);
			}
		}
}


class Node{
	public int no;
	public String name;
	public String nickname;
	public Node next;
	public Node pre;
	public Node(int hNo,String name,String nickname){
		this.no=hNo;
		this.name=name;
		this.nickname=nickname;
		
	}
	@Override
	public String toString() {
		return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
	}
	
	
}