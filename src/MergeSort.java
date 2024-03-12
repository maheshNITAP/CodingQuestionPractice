public class MergeSort {
    public static void devide(int[] arr, int startIndx, int endIndx){
        if(startIndx>= endIndx){
            return;
        }
        int mid= startIndx+(endIndx-startIndx)/2;
        devide(arr,startIndx,mid);
        devide(arr,mid+1,endIndx);
        conqure(arr,startIndx,mid, endIndx);
    }

    private static void conqure(int[] arr, int startIndx, int mid, int endIndx) {
        int[] newArr= new int[endIndx-startIndx+1];
        int i=startIndx;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=endIndx){
            if(arr[i]<=arr[j]){
                newArr[k++]=arr[i++];
            }else{
                newArr[k++]=arr[j++];
            }
        }
        while(i<=mid){
            newArr[k++]=arr[i++];
        }
        while (j<=endIndx){
            newArr[k++]=arr[j++];
        }
        for(i=0, j=startIndx;i<newArr.length;i++,j++){
            arr[j]=newArr[i];
        }
    }

    public static  void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        int n=arr.length;
        devide(arr,0,n-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
