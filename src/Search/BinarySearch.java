package Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public  static  void main(String[] args){
        int arr[]={-20,-10,-4,0,1,5,8,10,10,10,10,14,16,16,16,16,23,44,54,100,100,100};
        int index=binarySearch(arr,0,arr.length-1,10);
        System.out.println(index);
        List indexList=binarySearch2(arr,0,arr.length-1,10);
        System.out.println(indexList);
    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(left>right||findVal<arr[0]||findVal>arr[arr.length-1])
            return -1;
        if(findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }

    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal){
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(left>right)
            return new ArrayList<Integer>();
        if(findVal>midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else{
            ArrayList<Integer> IndexList= new ArrayList<Integer>();
            int temp=mid-1;
            while (true){
                if(temp<left||arr[temp]!=findVal){
                    break;
                }
                IndexList.add(temp);
                temp--;
            }
            IndexList.add(mid);
            temp=mid+1;
            while (true){
                if(temp>right||arr[temp]!=findVal){
                    break;
                }
                IndexList.add(temp);
                temp++;
            }
            return IndexList;
        }
    }

}
