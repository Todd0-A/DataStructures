package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,9,-1,10,-2,11,20,19,23,5,-20,-15,10,11,15,44,32,30,0};
		int []temp=new int[arr.length];
		mergeSort(arr,0,arr.length-1,temp);
		System.out.print(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[]arr,int left,int right,int[]temp) {
		if(left<right) {
			int mid=(left+right)/2;
			mergeSort(arr,left,mid,temp);
			mergeSort(arr,mid+1,right,temp);
			merge(arr,left,mid,right,temp);
		}
	}
	
	
	public static void merge(int[] arr,int left,int mid,int right,int temp[]) {
		int l=left;
		int m=mid+1;
		int t=0;
		while(l<=mid&&m<=right) {
			if(arr[l]<=arr[m]) {
				temp[t]=arr[l];
				t+=1;
				l+=1;
			}else{
				temp[t]=arr[m];
				t+=1;
				m+=1;
			}
		}
		while(l<=mid) {
			temp[t]=arr[l];
			t+=1;
			l+=1;
		}
		while(m<=right) {
			temp[t]=arr[m];
			t+=1;
			m+=1;
		}
		t=0;
		int tempL=left;
		while(tempL<=right) {
			arr[tempL]=temp[t];
			t+=1;
			tempL+=1;
		}
	}
	
}
