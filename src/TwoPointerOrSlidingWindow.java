import java.util.HashMap;
import java.util.Map;

public class TwoPointerOrSlidingWindow {
    static class SW {

        public int constantWindowQuestion(int[] arr, int k) {
            int n=arr.length;
            int l=0;
            int r=k-1;
            int sum=0;
            for(int i=0;i<=r;i++)
                sum+=arr[i];
            int maxSum=sum;
            while(r<n-1){
                sum=sum-arr[l];
                l++;
                r++;
                sum+=arr[r];
                maxSum=Math.max(sum,maxSum);
            }
            return maxSum;
        }

        public int longestSubArray(int[] arr, int k) {
            int n=arr.length;
            int l=0;
            int r=0;
            int sum=0;
            int maxLen=0;
            while(r<n){
                sum+=arr[r];
                if(sum>k){
                    sum=sum-arr[l];
                    l++;
                }
                if(sum<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r=r+1;
            }
            return maxLen;
        }

        public int maxPointsFromCards(int[] arr, int k) {
            int n=arr.length;
            int lIndex=k-1;
            int rIndex=n-1;
            int leftSum=0;
            int rightSum=0;
            int maxSum=0;
            for(int i=0;i<k;i++)
                leftSum+=arr[i];
            maxSum=Math.max(leftSum,maxSum);
            for(int i=lIndex;i>=0;i--){
                leftSum-=arr[i];
                rightSum+=arr[rIndex];
                rIndex--;
                maxSum=Math.max(maxSum,leftSum+rightSum);
            }
               return maxSum;
        }

        public int longestSubStringWithoutRepeatingChar(String s) {
            Map<Character,Integer> map= new HashMap<>();//char index
            int l=0;
            int r=0;
            int maxLen=0;
            int n=s.length();
            while (r<n){
                if(map.containsKey(s.charAt(r)))
                    l= Math.max(map.get(s.charAt(r))+1, l);

                map.put(s.charAt(r),r);
                maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }
    }
    public static void main(String args[]){
        SW sw= new SW();


        //return the maximum sum of consecutive elements
//        int arr[]={-1,2,3,3,4,5,-1};
//        int k=4;
//        System.out.println(sw.constantWindowQuestion(arr,k));

        //longest subArray or substring with sum <=k
//        int arr[]={2,5,1,7,10};
//        int k=14;
//        System.out.println(sw.longestSubArray(arr,k));

        //Maximum Points You can obtain from cards
//        int arr[]={6,2,3,4,7,2,1,7,1};
//        int k=4;
//        System.out.println(sw.maxPointsFromCards(arr,k));

        //Longest Substring without repeating characters
        String s="cadbzabcd";
        System.out.println(sw.longestSubStringWithoutRepeatingChar(s));

    }
}
