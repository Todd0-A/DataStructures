package sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {-3,9,-1,10,-2};
		selectSort(arr);
	}
	public static void selectSort(int [] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			int index=i;
			int min=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(min>arr[j]) {
					min=arr[j];
					index=j;
				}
			}
			if(index!=i) {
				arr[index]=arr[i];
				arr[i]=min;
			}
		}
		System.out.print(Arrays.toString(arr));
	}
}
