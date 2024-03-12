public class QuickSort {
    public static int partitionWhenFirstElementIsPivot(int arr[],int low, int high){
        int pivot=arr[low];
        int i=low;
        int j=high;
        do{
            do{i++;}while (arr[i]<=pivot);
            do{j--;}while (arr[j]>pivot);
            if(i<j){
                swapele(arr,i,j);
            }
        }while (i<j);
        swapele(arr,low,j);// j location is suitable for pivot
        return j;// need to return location of pivot
    }

    private static void swapele(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public static void quickSortWhenFirstElementIsPivot(int arr[],int low,int high){
        int j;
        if(low<high){
            j= partitionWhenFirstElementIsPivot(arr,low,high);
            quickSortWhenFirstElementIsPivot(arr,low,j);
            quickSortWhenFirstElementIsPivot(arr,j+1,high);
        }
    }

    public static int partitionWhenLastElementIsPivot(int arr[],int low,int high){
        int pivot=arr[high];
        int i=low;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                swapele(arr,i,j);
                i++;
            }
        }
        swapele(arr,i,high);
        return i;
    }
    public static void quickSortWhenLastElementIsPivot(int[] arr,int low,int high){
        int j;
        if(low<high){
            j= partitionWhenLastElementIsPivot(arr,low,high);
            quickSortWhenLastElementIsPivot(arr,low,j-1);
            quickSortWhenLastElementIsPivot(arr,j+1,high);
        }
    }
    public static void main(String[] args){
//        int[] arr = {6,3,9,5,2,8, MAX_VALUE}; // we are using MAX value so i wont go out of index
//        int arr[] ={50,70,60,90,40,80,10,20,30,MAX_VALUE};
//        int n=arr.length;
//        quickSortWhenFirstElementIsPivot(arr,0,n-1);
//        int arr[]= {6,3,9,5,2,8};
        int arr[] ={50,70,60,90,40,80,10,20,30};
        int n=arr.length;
        quickSortWhenLastElementIsPivot(arr,0,n-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
