package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {-3,9,-1,10,-2};
		int temp=0;
		boolean flag=false;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					flag=true;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				}
			if(flag==false) {
				break;
			}else {
				flag=false;
			}
		}
		System.out.print(Arrays.toString(arr));
	}

}
