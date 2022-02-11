package com.sparseArray;

public class SparseArray {
	//Two-dimensional arrays converted to sparse arrays and then restored to two-dimensional arrays
	public static void main(String[] args) {
		//Define a two-dimensional arrays
		//0 means no chess piece, 1 means a black chess piece, 2 means a white chess piece
		int chessArr1[][]=new int [11][11];
		chessArr1[1][2]=1;
		chessArr1[3][4]=2;
		System.out.println("Raw two-dimensional arrays");
		for(int[] row:chessArr1) {
			for(int data:row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		//Iterate to get non-zero numbers
		int sum=0;
		for(int i =0;i<11;i++) {
			for(int j=0;j<11;j++) {
				if(chessArr1[i][j]!=0)
					sum++;
			}
		}
		//Create a sparse array
		int sparseArr[][]=new int [sum+1][3];
		sparseArr[0][0]=11;
		sparseArr[0][1]=11;
		sparseArr[0][2]=sum;
		//Iterate over the original array, passing non-zero values into the sparse array
		int count=0;
		for(int i =0;i<11;i++) {
			for(int j=0;j<11;j++) {
				if(chessArr1[i][j]!=0) {
					count++;
					sparseArr[count][0]=i;
					sparseArr[count][1]=j;
					sparseArr[count][2]=chessArr1[i][j];
					
				}
					
			}
		}
		//Output sparse array
		System.out.println();
		for(int i=0;i<sparseArr.length;i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		//Restore to a two-dimensional array
		int chessArr2[][]=new int [sparseArr[0][0]][sparseArr[0][1]];
		for(int i =1;i<sparseArr.length;i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
		}
		for(int[] row:chessArr2) {
			for(int data:row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
	}
	

}
