import java.util.Arrays;

public class Arrayss {
    static class ArrayQuestions{

        public int secondLargestElementInArray(int[] arr) {
            int n=arr.length;
            Arrays.sort(arr);
            int largest=arr[n-1];
            for(int i=n-2;i>=0;i--){
                if(arr[i]!=largest){
                    return arr[i];
                }
            }
            return Integer.MIN_VALUE;
        }

        public int secondLargestElementInArrayBetterApproach(int[] arr) {
            int n=arr.length;
            int largest=arr[0];
            int secLargest=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                largest=Math.max(arr[i],largest);
            }
            for(int i=0;i<n;i++){
                if(arr[i]!=largest && arr[i]>secLargest)
                    secLargest=arr[i];
            }
            return secLargest;
        }

        public int secondLargestElementInArrayOptimalApproach(int[] arr) {
            int n=arr.length;
            int largest=arr[0];
            int secLargest=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]>largest){
                    secLargest=largest;
                    largest=arr[i];
                }else if(arr[i]>secLargest && arr[i]<largest){
                    secLargest=arr[i];
                }
            }
            return secLargest;
        }
    }
    public static void main(String args[]){
        ArrayQuestions array= new ArrayQuestions();
//        int arr[]= {1,2,4,7,7,5};
        //Second largest element
        //bruteForce
//        System.out.println(array.secondLargestElementInArray(arr));

        //better
//        System.out.println(array.secondLargestElementInArrayBetterApproach(arr));

        //Optimal
//        System.out.println(array.secondLargestElementInArrayOptimalApproach(arr));

        //remove duplicate in-place in sorted Array



    }

}
