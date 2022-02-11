package Search;

public class InsertValueSearch {
    public  static  void main(String[] args) {
        int arr[] = {-50,-20,-20,-10, -4, 0, 1, 5, 8, 10, 10, 10, 10, 14, 16, 16, 16, 16, 23, 44, 54, 100, 100, 100};
        int index=insertValueSearch(arr,0,arr.length-1,100);
        System.out.println(index);
    }

    public static int insertValueSearch(int[]arr,int left,int right,int findVal){
        if(left>right||findVal<arr[0]||findVal>arr[arr.length-1]) {
            return -1;
        }
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){
            return  insertValueSearch(arr,mid+1,right,findVal);
        }else  if(findVal<midVal){
            return  insertValueSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }

    }
}
