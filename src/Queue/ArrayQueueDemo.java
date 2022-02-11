package Queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建队列
		ArrayQueue arrayQueue=new ArrayQueue(3);
		char key=' ';
		Scanner scanner=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("s(show)");
			System.out.println("e(exit)");
			System.out.println("a(add)");
			System.out.println("g(get)");
			System.out.println("h(head)");
			key=scanner.next().charAt(0);
			switch(key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("Add a number");
				int value=scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res=arrayQueue.getQueue();
					System.out.printf("%d\n", res);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res=arrayQueue.headQueue();
					System.out.printf("%d\n", res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop=false;
			default:
				break;
			}
		}
		System.out.println("Exited");
	}

}
class ArrayQueue{
	
	private int maxSize;
	private int front;
	private int rear;
	private int arr[];
	
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize=arrMaxSize;
		arr=new int[maxSize];
		front=0;//	指向队列前一个位置
		rear=0;//指向队列尾部数据
	}
	//判断队列是否满
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	
	public boolean isEmpty() {
		return rear==front;
	}
	//入队列
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("Full queue,can not add");
			return;
		}
		arr[rear]=n;
		rear=(rear+1)%maxSize;
	}
	//出队列
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Empty queue,can not get");
		}
		int value=arr[front];
		front=(front+1)%maxSize;
		return value;
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("Empty queue");
			return;
		}
		for(int i=front;i<size()+front;i++) {
			System.out.printf("arr[%d]=%d\n", i%maxSize,arr[i%maxSize]);
		}
	}
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Empty queue");
		}
		return arr[front];
	}
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
}
