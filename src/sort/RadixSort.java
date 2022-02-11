package sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,-9,5,-6,-200,-13,-20,8,22,31,11,0,21,11,1001,-2000,19,21};
		radixSort(arr);
		System.out.print(Arrays.toString(arr));
		
	}
	
	public static void radixSort(int[] arr) {
		
		int[][] bucket=new int [19][arr.length];
		int [] temp=new int[19];
		int max=Math.abs(arr[0]);
		for(int i=1;i<arr.length;i++) {
			if(Math.abs(arr[i])>max) {
				max=Math.abs(arr[i]);
			}
		}
		int maxlength=(max+"").length();
		for(int i=0;i<maxlength;i++) {
			for(int j=0;j<arr.length;j++) {
				int digitOfElement=(int)(arr[j]/Math.pow(10, i)%10);
				bucket[digitOfElement+9][temp[digitOfElement+9]]=arr[j];
				temp[digitOfElement+9]++;
			}
			int index=0;
			for(int k=0;k<temp.length;k++) {
				if(temp[k]!=0) {
					for(int l=0;l<temp[k];l++) {
						arr[index]=bucket[k][l];
						index++;
					}
				}
				temp[k]=0;
			}
		}
	}
}
