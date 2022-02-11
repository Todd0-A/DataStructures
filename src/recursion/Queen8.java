package recursion;

public class Queen8 {

	int queens=8;
	int [] array=new int [queens];
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 queen8=new Queen8();
		queen8.check(0);
		System.out.println(count);
	}
	
	private void check(int n) {
		if(n==queens) {
			print();
			count++;
			return;
		}
		for(int i=0;i<queens;i++) {
			array[n]=i;
			if(judge(n)) {
				check(n+1);
			}
		}
	}
	
	
	
	private boolean judge(int n) {
		for(int i=0;i<n;i++) {
			if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])) {
				return false;
			}
		}
		return true;
	}
	
	
	private void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	
}
