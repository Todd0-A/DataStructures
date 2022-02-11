package Stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack =new ArrayStack(4);
		String key="";
		boolean loop=true;
		Scanner scanner=new Scanner(System.in);
		while(loop) {
			System.out.println("show");
			System.out.println("exit");
			System.out.println("push");
			System.out.println("pop");
			System.out.println("input your choice");
			key=scanner.next();
			switch(key) {
				case "show":
					stack.show();
					break;
				case "push":
					System.out.println("input a number");
					int value=scanner.nextInt();
					stack.push(value);
					break;
				case "pop":
					try {
						int res=stack.pop();
						System.out.printf("The pop number of stack:%d\n",res);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case "exit":
					scanner.close();
					loop=false;
					break;
				default:
					break;
					
			}	
		}
		System.out.println("System exited");
	}

}

class ArrayStack{
	private int maxsize;
	private int[] stack;
	private int top=-1;
	
	public ArrayStack(int maxsize) {
		this.maxsize=maxsize;
		stack=new int[maxsize];
	}
	
	public boolean isFull() {
		return top==maxsize-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	public void push(int value) {
		if(isFull()) {
			System.out.println("Full stack!");
			return;
		}
		top++;
		stack[top]=value;
	}
	
	public int pop() {
		if(isEmpty()) {
			new RuntimeException("Empty stack!");
		}
		int value=stack[top];
		top--;
		return value;
		
	}
	
	public void show() {
		if(isEmpty()) {
			System.out.println("Empty stack!");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("Stack[%d]=%d\n", i,stack[i]);
		}
	}
	
}