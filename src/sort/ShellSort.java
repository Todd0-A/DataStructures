package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,9,-1,10,-2,11,20,19,23,15,44,32,30,0};
		shellSort2(arr);
	}
	public static void shellSort(int[] arr) {
		int temp=0;
		for(int gap=arr.length/2;gap>0;gap/=2) {
			for(int i=gap;i<arr.length;i++) {
				for(int j=i-gap;j>=0;j-=gap) {
					if(arr[j]>arr[j+gap]) {
						temp=arr[j];
						arr[j]=arr[j+gap];
						arr[j+gap]=temp;
					}
				}
			}
		}
		System.out.print(Arrays.toString(arr));
		
	}
	public static void shellSort2(int[] arr) {
		
		for(int gap=arr.length/2;gap>0;gap/=2) {
			for(int i=gap;i<arr.length;i++) {
				int j=i;
				int temp=arr[j];
				while(j-gap>=0&&temp<arr[j-gap]) {
					arr[j]=arr[j-gap];
					j-=gap;
				}
				arr[j]=temp;	
			}
		}
		System.out.print(Arrays.toString(arr));
	}
	
	
}
