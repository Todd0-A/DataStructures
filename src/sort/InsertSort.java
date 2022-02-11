package sort;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,9,-1,10,-2};
		insertSort(arr);
	}
	public static void insertSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int insertVal=arr[i];
			int index=i-1;
			while(index>=0&&insertVal<arr[index]) {
				arr[index+1]=arr[index];
				index--;
			}
			arr[index+1]=insertVal;
		}
		System.out.print(Arrays.toString(arr));
	}
}
