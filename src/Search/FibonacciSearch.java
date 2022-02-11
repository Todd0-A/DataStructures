package Search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize=40;
    public  static  void main(String[] args) {
        int arr[] = {-50, -20, -20, -10, -4, 0, 1, 5, 8, 10, 10, 10, 10, 14, 16, 16, 16, 16, 23, 44, 54, 100, 100, 100};
        int index=fibonacciSearch(arr,-50);
        System.out.println(index);
    }

    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    public static int fibonacciSearch(int[]arr,int key){
        int low=0;
        int high=arr.length-1;
        int k=0;
        int mid=0;
        int[] f=fib();
        while(high>f[k]-1){
            k++;
        }
        int [] temp= Arrays.copyOf(arr,f[k]);
        for(int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){
                high=mid-1;
                k--;
            }else if(key>temp[mid]){
                low=mid+1;
                k-=2;
            }else{
                if(mid<=high){
                    return mid;
                }
                else{
                    return high;
                }
            }
        }
        return -1;
    }



}
