package Linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 =new HeroNode(1,"AAA","A");
		HeroNode hero2=new HeroNode(2,"BBB","B");
		HeroNode hero3 =new HeroNode(6,"CCC","C");
		HeroNode hero4=new HeroNode(7,"DDD","D");
		SingleLinkedList LList=new SingleLinkedList();
		HeroNode hero5 =new HeroNode(3,"XXX","X");
		HeroNode hero6=new HeroNode(4,"YYY","Y");
		HeroNode hero7 =new HeroNode(5,"ZZZ","Z");

		HeroNode hero8=new HeroNode(8,"KKK","K");
		LList.insert(hero1);
		LList.insert(hero4);
		LList.insert(hero3);
		LList.insert(hero2);
		SingleLinkedList LList2=new SingleLinkedList();
		LList2.insert(hero5);
		LList2.insert(hero6);
		LList2.insert(hero7);
		LList2.insert(hero8);
		//LList.show();
		//LList2.show();
		SingleLinkedList List=combine(LList.getHead(),LList2.getHead());
		List.show();
		/*LList.insert(hero1);
		LList.insert(hero4);
		LList.insert(hero3);
		LList.insert(hero2);
		LList.show();
		HeroNode hero5 =new HeroNode(3,"CDC","CD");
		HeroNode hero6=new HeroNode(6,"DDD","D");
		LList.update(hero5);
		LList.update(hero6);
		LList.show();
		LList.delete(2);
		LList.delete(5);
		LList.show();
		LList.ShowByNo(1);
		LList.ShowByNo(5);
		System.out.println(getLength(LList.getHead()));
		System.out.println(findLastIndexNode(LList.getHead(),3).toString());
		reverseList(LList.getHead());
		LList.show();
		reverseprint(LList.getHead());*/
		
		
		
	}
	public static int getLength(HeroNode head) {
		if(head.next==null)
			return 0;
		int length =0;
		HeroNode cur=head.next;
		while(cur!=null) {
			length++;
			cur=cur.next;
		}
		return length;
	}
	
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		if(head.next==null) {
			return null;
		}
		int size=getLength(head);
		if(index<=0|| index>size) {
			return null;
		}
		HeroNode cur=head.next;
		for(int i=0;i<size-index;i++) {
			cur=cur.next;
		}
		return cur;
	}
	
	public static void reverseList(HeroNode head) {
		if(head.next==null||head.next.next==null)
			return;
		HeroNode cur=head.next;
		HeroNode next=null;
		HeroNode reverseHead=new HeroNode(0,"","");
		while(cur!=null) {
			next=cur.next;
			cur.next=reverseHead.next;
			reverseHead.next=cur;
			cur=next;
		}
		head.next=reverseHead.next;
	}
	
	public static void reverseprint(HeroNode head) {
		if(head.next==null)
			return;
		Stack<HeroNode> stack=new Stack<HeroNode>();
		HeroNode cur=head.next;
		while(cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		while(stack.size()>0) {
			System.out.print(stack.pop().toString()+"\n");
		}
	}
	
	
	public static SingleLinkedList combine(HeroNode h1,HeroNode h2) {
		SingleLinkedList LinkedList=new SingleLinkedList();
		if(h1.next==null&&h2.next==null) {	
			return LinkedList;
		}
		HeroNode temp=h1.next;
		while(temp!=null) {
			HeroNode temp1=temp.next;
			LinkedList.insert(temp);
			temp=temp1;
		}
		
		temp=h2.next;
		while(temp!=null) {
			HeroNode temp1=temp.next;
			LinkedList.insert(temp);
			temp=temp1;
		}
		return LinkedList;
	}
	
	
}

class SingleLinkedList{
	private HeroNode head=new HeroNode(0,"","");
	public void insert(HeroNode heroNode) {
		HeroNode temp=head;
		boolean flag=false;
		while(true){
			if(temp.next==null) {
				break;
			}
			if(temp.next.no>heroNode.no) {
				break;
			}else if(temp.next.no==heroNode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag)
			System.out.printf("Insert node %d already exists\n",heroNode.no);
		else {
			heroNode.next=temp.next;
			temp.next=heroNode;
		}
	}
	
	public void update(HeroNode heronode) {
		if(head.next==null) {
			System.out.println("Empty LinkedList");
			return;
		}
		boolean flag=false;
		HeroNode temp=head;
		while(true) {
			if(temp==null)
				break;
			if(temp.no==heronode.no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			temp.name=heronode.name;
			temp.nickname=heronode.nickname;
		}else {
			System.out.printf("Node %d not found\n", heronode.no);
		}
	}
	
	public void delete(int no) {
		if(head.next==null) {
			System.out.println("Empty LinkedList");
			return;
		}
		HeroNode temp=head;
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
	
	public void ShowByNo(int no) {
		if(head.next==null) {
			System.out.println("Empty LinkedList");
			return;
		}
		HeroNode temp=head;
		boolean flag=false;
		while(true) {
			if(temp==null)
				break;
			if(temp.no==no) {
				flag=true;
				break;
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.println(temp.toString());
		}else {
			System.out.printf("Node %d not found\n",no);
		}
	}
	
	public void show() {
		if(head.next==null){
			System.out.println("Empty LinkedList");
			return;	
		}
		HeroNode temp=head.next;
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp.toString());
			temp=temp.next;
		}
	}
	
	public HeroNode getHead() {
		return head;
	}
}

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode(int hNo,String name,String nickname){
		this.no=hNo;
		this.name=name;
		this.nickname=nickname;
		
	}
	@Override
	public String toString() {
		return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
	}
	
	
}