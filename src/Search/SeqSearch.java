package Search;

public class SeqSearch {
    public  static  void main(String[] args){
        int arr[]= {3,9,-1,10,-2,11,20,19,23,15,44,32,30,0};
        int index=seqSearch(arr,44);
        if(index==-1){
            System.out.println("Not found");
        }else{
            System.out.println("The index is "+index);
        }
    }
    public static int seqSearch(int [] arr,int value){
        for (int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
