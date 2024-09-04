import java.util.*;

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

        public int[] removeDuplicate(int[] arr) {
            Set<Integer> st= new HashSet<>();
            for(int i=0;i<arr.length;i++)
                st.add(arr[i]);
            Iterator<Integer> it= st.iterator();
            int index=0;
            while(it.hasNext()){
                arr[index++]=it.next();
            }
            return arr;
        }

        public int[] removeDuplicateOptimal(int[] arr) {
            int i=0;
            for(int j=1;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    arr[i+1]=arr[j];
                    i++;
                }
            }
            return arr;
        }

        public void leftRotateArrayByOnePlace(int[] arr) {
            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++)
                arr[i]=arr[i+1];
            arr[arr.length-1]=temp;
        }

        public void leftRotateArrayByDPlaceBruteForce(int[] arr, int d) {
            int n=arr.length;
            d=d%n;
            int temp[]= new int[d];
            for(int i=0;i<d;i++){
                temp[i]=arr[i];
            }
            for(int i=d;i<n;i++){
                arr[i-d]=arr[i];
            }
            for(int i=n-d;i<n;i++){
                arr[i]=temp[i-(n-d)];
            }
        }
        public void reverse(int[] arr, int i,int j){
            while(i<j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }
        }

        public void leftRotateArrayByDPlaceOptimalApproach(int[] arr, int d) {
            reverse(arr,0,d-1);
            reverse(arr,d,arr.length-1);
            reverse(arr,0,arr.length-1);
        }

        public void rightRotateAnArrayByDPlaces(int[] arr, int d) {
            int n=arr.length;
            reverse(arr,0,n-d-1);
            reverse(arr,n-d,n-1);
            reverse(arr,0,n-1);
        }

        public int findMissingNumberBruteForce(int[] arr, int n) {
            for(int i=1;i<=n;i++){
                boolean flag=false;
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==i)
                        flag=true;
                }
                if(flag==false)
                    return i;
            }
            return -1;
        }

        public int findMissingNumberBetter(int[] arr, int n) {
            int maxi=0;
            for(int i=0;i<arr.length;i++)
                maxi=Math.max(arr[i],maxi);
            int hash[]= new int[maxi+1];

            for(int i=0;i<arr.length;i++){
                hash[arr[i]]++;
            }
            for(int i=1;i<n;i++){
                if(hash[i]==0)
                    return i;
            }
            return -1;
        }

        public int findMissingNumberOptimalBySumOfNaturalNumbers(int[] arr, int n) {
            int totalSum=n*(n+1)/2;
            int givenSum=0;
            for(int i=0;i<arr.length;i++)
                givenSum+=arr[i];
            return totalSum-givenSum;
        }

        public int findMissingNumberOptimalByXOR(int[] arr, int n) {
            int XOR1=0,XOR2=0;
            for(int i=0;i<arr.length;i++){
                XOR2=XOR2^arr[i];

                XOR1=XOR1^(i+1);
            }
            XOR1=XOR1^n;

            return XOR1^XOR2;
        }

        public int maximumConsecutiveOnes(int[] arr) {
            int count=0,max=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==1){
                    count++;
                    max=Math.max(max,count);
                }else
                    count=0;
            }
            return max;
        }

        public int findNumberThatAppearsOnlyOnceBruteForce(int[] arr) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                int num=arr[i];
                int count=0;
                for(int j=0;j<n;j++){
                    if(arr[j]==num)
                        count++;
                }
                if(count==1)
                    return num;
            }
            return -1;
        }

        public int findNumberThatAppearsOnlyOnceBetter(int[] arr) {
            int n=arr.length;
            int max=arr[0];
            for(int i=0;i<n;i++)
                max=Math.max(arr[i],max);

            int hash[]= new int[max+1];
            for(int i=0;i<n;i++){
                hash[arr[i]]++;
            }
            for(int i=0;i<=max;i++){
                if(hash[i]==1)
                    return i;
            }
            return -1;
        }

        public int findNumberThatAppearsOnlyOnceOptimal(int[] arr) {
            int XOR=0;
            for(int i=0;i<arr.length;i++)
                XOR=XOR^arr[i];
            return XOR;
        }

        public int longestSubArrayWithSumKBruteForce(int[] arr, int k) {
            int maxLen=0;
            for(int i=0;i<arr.length;i++){
                int sum=0;
                for(int j=i;j<arr.length;j++){
                    sum+=arr[j];
                    if(sum==k)
                        maxLen=Math.max(maxLen,j-i+1);
                    if(sum>k) break;
                }
            }
            return maxLen;
        }

        public int longestSubArrayWithSumKBetter(int[] arr, int k) {
            int maxLen=0;
            int preSum=0;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<arr.length;i++){
                preSum+=arr[i];
                if(preSum==k)
                    maxLen=Math.max(maxLen,i+1);
                int rem=preSum-k;
                if(map.containsKey(rem)){
                    maxLen=Math.max(maxLen,i-map.get(rem));
                }
                if(!map.containsKey(preSum)){//this check when we have continuous zeros that time we should not sort our length
                    map.put(preSum,i);
                }
            }
            return maxLen;
        }

        public int longestSubArrayWithSumKOptimal(int[] arr, int k) {
            int l=0,r=0,maxLen=0;
            int sum=0,n=arr.length;
            while(r<n){
                sum+=arr[r];
                while(sum>k){
                    sum-=arr[l++];
                }
                if(sum==k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
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
//        int arr[]= {1,1,2,2,2,3,3};
        //brute force
//        int res[]=array.removeDuplicate(arr);

        //optimal by two pointer
//        int res[]= array.removeDuplicateOptimal(arr);
//
//        for(int i:res){
//            System.out.print(i+" ");
//        }

        //Left Rotate the Array by 1 place

//        int arr[]={1,2,3,4,5};
//        array.leftRotateArrayByOnePlace(arr);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }

        //left rotate the array by d places
//        int arr[]={1,2,3,4,5,6,7};
//        int d=3;

        //Brute force
//        array.leftRotateArrayByDPlaceBruteForce(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }

        //Optimal
//        array.leftRotateArrayByDPlaceOptimalApproach(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }
//        System.out.println();

        //right rotate the array by d places
//        array.rightRotateAnArrayByDPlaces(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }


        //find the missing number from 1 to n
//        int arr[]={1,2,4,5};
//        int n=5;

        //brute force
//        System.out.println(array.findMissingNumberBruteForce(arr,n));

        //better
//        System.out.println(array.findMissingNumberBetter(arr,n));

        //Optimal--but Integer Overflow can happen
//        System.out.println(array.findMissingNumberOptimalBySumOfNaturalNumbers(arr,n));
        
        //Optimal--by XOR
//        System.out.println(array.findMissingNumberOptimalByXOR(arr,n));

        //Given a binary array nums, return the maximum number of consecutive 1's in the array.

//        int arr[]={11,0,1,1,1,0,1,1};
//        System.out.println(array.maximumConsecutiveOnes(arr));

        //find the number that appears only once and others are appearing twice
//        int arr[]={1,2,3,1,3,6,7,6,2};


        //brute force
//        System.out.println(array.findNumberThatAppearsOnlyOnceBruteForce(arr));

        //better
//        System.out.println(array.findNumberThatAppearsOnlyOnceBetter(arr));

        //Optimal---XOR
//        System.out.println(array.findNumberThatAppearsOnlyOnceOptimal(arr));


        //longest subArray with sum K
//        int arr[]={1,2,3,1,1,1,4,2,3};
//        int k=3;

        int arr[]={1,2,3,1,1,1,1,3,3};
        int k=6;
//        System.out.println(array.longestSubArrayWithSumKBruteForce(arr,k));

        //Better for Only +ve Values and this is Only Optimal for -ve and +ve both valued array
//        System.out.println(array.longestSubArrayWithSumKBetter(arr,k));

        //Optimal Sol
        System.out.println(array.longestSubArrayWithSumKOptimal(arr,k));






    }

}
