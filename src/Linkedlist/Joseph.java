package Linkedlist;

public class Joseph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList list=new CircleSingleLinkedList();
		list.addBoy(25);
		list.show();
		list.count(1, 2, 25);
	}

}

class CircleSingleLinkedList{
	private Boy first=new Boy(-1);
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("Error Number");
			return;
		}
		Boy curBoy=null;
		for(int i=1;i<=nums;i++) {
			Boy boy=new Boy(i);
			if(i==1) {
				first=boy;
				first.setNext(first);		
				curBoy=first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
			
		}
		
	}
	
	public void show() {
		if(first==null) {
			System.out.println("Empty");
			return;
		}
		Boy curBoy=first;
		while(true){
			System.out.printf("No of boy %d\n",curBoy.getNo());
			if(curBoy.getNext()==first) {
				break;
			}
			curBoy=curBoy.getNext();
		}
	}
	public void count(int startNo,int count,int nums) {
		if(first==null||startNo<1||count<1||startNo>nums) {
			System.out.println("Error input");
			return;
		}
		for(int i=1;i<startNo;i++) {
			first=first.getNext();
		}
		Boy helper=first;
		while(true) {
			if(helper.getNext()==first) {
				break;
			}
			helper=helper.getNext();
		}
		while(true) {
			if(helper==first) {
				break;
			}
			for(int i=1;i<count;i++) {
				helper=helper.getNext();
				first=first.getNext();
			}
			System.out.printf("The boy %d out\n",first.getNo());
			first=first.getNext();
			helper.setNext(first);
		}
		System.out.printf("The least boy is No %d\n",first.getNo());
	}
	
}


class Boy{
	private int no;
	private Boy next;
	
	public Boy(int no) {
		this.no=no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
	
}