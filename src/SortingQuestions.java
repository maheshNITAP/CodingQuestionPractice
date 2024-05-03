public class SortingQuestions {
    private void bubbleSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
            }
        }
    }
    }
    private void swapValues(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void bubbleSortOptimized(int[] arr) {
        int n=arr.length;
        boolean flag=false;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                swapValues(arr,j,j+1);
                flag=true;
            }
            if(flag==false)
                break;;
        }
    }
    private void insertionSort(int[] arr) {
        int n= arr.length;
        for(int i=1;i<n;i++){
            int j=i;
            int ele=arr[i];
            while(j>0 && ele<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=ele;  
        }
    }



    public static void main(String args[]){

        //bubble sort
        int arr[]={8,5,7,3,2};
        SortingQuestions s= new SortingQuestions();
//        s.bubbleSort(arr);
//        for(int x:arr){
//            System.out.print(x+" ");
//        }

        //bubble sort Optimised
//        s.bubbleSortOptimized(arr);
//        for(int x:arr){
//            System.out.print(x+" ");
//        }

        //insertion sort
         s.insertionSort(arr);
         for(int x:arr){
            System.out.print(x+" ");
        }



    }




}
