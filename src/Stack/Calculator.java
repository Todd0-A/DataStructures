package Stack;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression="30+2*6-40";
		ArrayStack2 numberStack=new ArrayStack2(10);
		ArrayStack2 operStack=new ArrayStack2(10);
		
		int index=0;
		int num1,num2=0;
		int oper=0;
		int res=0;
		char ch=' ';
		String keepNum="";
		while(true) {
			ch=expression.substring(index,index+1).charAt(0);
			if(operStack.isOper(ch)) {
				if(operStack.isEmpty()) {
					operStack.push(ch);
					
				}else {
					if(operStack.priority(ch)<=operStack.priority(operStack.peak())) {
						num1=numberStack.pop();
						num2=numberStack.pop();
						oper=operStack.pop();
						res=numberStack.cal(num1, num2, oper);
						numberStack.push(res);
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}
			}else {
				keepNum+=ch;
				if(index==expression.length()-1) {
					numberStack.push(Integer.parseInt(keepNum));
					
				}else {
					if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						numberStack.push(Integer.parseInt(keepNum));
						keepNum="";
					}
				}
			}
			index++;
			if(index>=expression.length()) {
				break;
			}
		}
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1=numberStack.pop();
			num2=numberStack.pop();
			oper=operStack.pop();
			res=numberStack.cal(num1, num2, oper);
			numberStack.push(res);
		}	
		System.out.printf(expression+"=%d",numberStack.pop());
	}

}


//
class ArrayStack2{
	private int maxsize;
	private int[] stack;
	private int top=-1;
	
	public ArrayStack2(int maxsize) {
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
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;
		}
		
	}
	public boolean isOper(char value) {
		return value=='+'||value=='-'||value=='*'||value=='/';
	}
	public int cal(int num1,int num2,int oper) {
		int res=0;
		switch(oper) {
		case '+':
			res=num1+num2;
			break;
		case '-':
			res=num2-num1;
			break;
		case '*':
			res=num2*num1;
			break;
		case '/':
			res=num2/num1;
			break;
		default:
			break;
		}
		return res;
	}
	public int peak() {
		return stack[top];
	}
	
}