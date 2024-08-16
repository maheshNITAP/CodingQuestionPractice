import javafx.util.Pair;

import java.util.*;

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

//        with two pointer
        public int maxConsecutiveOnes(int[] arr, int k) {
            int l=0;
            int r=0;
            int maxLen=0;
            int zeros=0;
            while(r<arr.length){
                if(arr[r]==0)
                    zeros++;
                while(zeros>k){
                    if(arr[l]==0)
                        zeros--;
                    l++;
                }
                if(zeros<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public int maxConsecutiveOnesWithFixedSlidingWindow(int[] arr, int k) {
            int l=0;
            int r=0;
            int maxLen=0;
            int zeros=0;
            while(r<arr.length){
                if(arr[r]==0)
                    zeros++;
                if(zeros>k){
                    if(arr[l]==0)
                        zeros--;
                    l++;
                }
                if(zeros<=k){
                    maxLen=Math.max(maxLen,r-l+1);
                }
                r++;
            }
            return maxLen;
        }


        //brute force
        public int maxLengthOfSubArrayWithAtMostKTypesOfNumbers(int[] arr,int k) {
            int n=arr.length;
            int maxLen=0;
            for(int i=0;i<n;i++){
                HashSet<Integer> st= new HashSet<>();
                for(int j=i;j<n;j++){
                    st.add(arr[j]);
                    if(st.size()<=k)
                        maxLen=Math.max(maxLen,j-i+1);
                    else break;
                }
            }
            return maxLen;
        }


        //two pointer
        public int maxLengthOfSubarrayWithAtmostKTypesOfNumbersTwoPointer(int[] arr, int k) {
            int r=0,l=0, maxLen=0;
            HashMap<Integer,Integer> map= new HashMap<>();
            while(r<arr.length){
                if(map.containsKey(arr[r]))
                    map.put(arr[r],map.get(arr[r])+1);
                else
                    map.put(arr[r],1);
                while(map.size()>k){
                    map.put(arr[l],map.get(arr[l])-1);
                    if(map.get(arr[l])==0)
                        map.remove(arr[l]);
                    l++;
                }
                if(map.size()<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public int maxLengthOfSubarrayWithAtmostKTypesOfNumbersSlidingWindow(int[] arr, int k) {
            int l=0,r=0,maxLen=0;
            HashMap<Integer,Integer> map= new HashMap<>();
            while(r<arr.length){
                if(map.containsKey(arr[r]))
                    map.put(arr[r],map.get(arr[r])+1);
                else
                    map.put(arr[r],1);
                if(map.size()>k){
                    map.put(arr[l],map.get(arr[l])-1);
                    if(map.get(arr[l])==0)
                        map.remove(arr[l]);
                    l++;
                }
                if(map.size()<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        //brute force
        public int longestSubStringWithKDistinctChar(String s, int k) {
            int r=0,l=0,maxLen=0;
            HashSet<Character> st = new HashSet<>();
            for(int i=0;i<s.length();i++){
                st.clear();
                for(int j=i;j<s.length();j++){
                    st.add(s.charAt(j));
                    if(st.size()<=k)
                        maxLen=Math.max(maxLen,j-i+1);
                    else
                        break;
                }
            }
            return maxLen;

        }

        public int longestSubStringWithKDistinctCharTwoPointer(String s, int k) {
            int r=0,l=0,maxLen=0;
            HashMap<Character,Integer> map= new HashMap<>();
            while(r<s.length()){
                if(map.containsKey(s.charAt(r)))
                    map.put(s.charAt(r),map.get(s.charAt(r))+1);
                else
                    map.put(s.charAt(r),1);
                if(map.size()>k){
                    while(map.size()>k){
                        map.put(s.charAt(l),map.get(s.charAt(l))-1);
                        if(map.get(s.charAt(l))==0)
                            map.remove(s.charAt(l));
                        l++;
                    }
                }
                if(map.size()<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public int longestSubStringWithKDistinctCharSlidingWindow(String s, int k) {
            int r=0,l=0,maxLen=0;
            HashMap<Character,Integer> map= new HashMap<>();
            while(r<s.length()){
                if(map.containsKey(s.charAt(r)))
                    map.put(s.charAt(r),map.get(s.charAt(r))+1);
                else
                    map.put(s.charAt(r),1);
                if(map.size()>k){
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    if(map.get(s.charAt(l))==0)
                        map.remove(s.charAt(l));
                    l++;
                }
                if(map.size()<=k){
                    maxLen=Math.max(maxLen,r-l+1);
                }
                r++;
            }
            return maxLen;
        }

        //brute force
        public int NumberOfSubStringContainingAllThreeChar(String s) {
            //brute force
            int count=0;
            for(int i=0;i<s.length();i++){
                int hash[]= new int[3];
                for(int j=i;j<s.length();j++){
                    hash[s.charAt(j)-'a']=1;
                    if(hash[0]+hash[1]+hash[2]==3)
                        count+=1;
                }
            }
            return count;
        }

        //Optimised brute force
        public int NumberOfSubStringContainingAllThreeCharOptimisedBruteForce(String s) {
            int count=0;
            for(int i=0;i<s.length();i++){
                int hash[]= new int[3];
                for(int j=i;j<s.length();j++){
                    hash[s.charAt(j)-'a']=1;
                    if(hash[0]+hash[1]+hash[2]==3){
                        count=count+(s.length()-j);
                        break;
                    }
                }
            }
            return count;
        }

        public int NumberOfSubStringContainingAllThreeCharTwoPointer(String s) {
            int count=0;
            int []lastSeen= new int[3];
            Arrays.fill(lastSeen,-1);
            for(int i=0;i<s.length();i++){
                lastSeen[s.charAt(i)-'a']=i;
                if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                    count+=1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
                }
            }
            return count;
        }

        //brute force
        public int longestRepeatingCharacterReplacement(String s, int k) {
            int maxFrq=0, maxLen=0;
            for(int i=0;i<s.length();i++){
                int hash[]= new int[26];
                for(int j=i;j<s.length();j++){
                    hash[s.charAt(j)-'A']++;
                    maxFrq=Math.max(maxFrq,hash[s.charAt(j)-'A']);

                    int otherVariables=(j-i+1)-maxFrq;
                    if(otherVariables <=k)
                        maxLen=Math.max(maxLen,j-i+1);
                    else break;
                }
            }
            return maxLen;
        }

        public int longestRepeatingCharacterReplacementTwoPointer(String s, int k) {
            int l=0,r=0,maxFrq=0,maxLen=0;
            int hash[] =  new int[26];
            while(r<s.length()){
                hash[s.charAt(r)-'A']++;
                maxFrq= Math.max(maxFrq,hash[s.charAt(r)-'A']);
                while ((r-l+1)-maxFrq>k){
                    hash[s.charAt(l)-'A']--;
//                    for(int i=0;i<26;i++)  we don't need to check max freq because we care about only length maximum than current if we don't use this check also then also it is fine
//                        maxFrq=Math.max(maxFrq,hash[i]);
                    l++;
                }
                if((r-l+1)-maxFrq<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public int longestRepeatingCharacterReplacementSlidingWindow(String s, int k) {
            int l=0,r=0,maxLen=0,maxFreq=0;
            int hash[]= new int[26];
            while(r<s.length()){
                hash[s.charAt(r)-'A']++;
                maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);
                if((r-l+1)-maxFreq >k){
                    hash[s.charAt(l)-'A']--;
                    l++;
                }
                if((r-l+1)-maxFreq<=k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public int subArraySumEqualsK(int[] arr, int k) {
            int count=0;
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum=0;
                for(int j=i;j<arr.length;j++){
                    sum+=arr[j];
                    if(sum==k)
                        count++;
                }
            }
            return count;
        }

        public int subArraySumEqualsKPrefixSum(int[] arr, int k) {
            HashMap<Integer,Integer> map= new HashMap<>();//<number,count>
            map.put(0,1);
            int preFixSum=0;
            int count=0;
            for(int i=0;i<arr.length;i++){
                preFixSum+=arr[i];
                int remove=preFixSum-k;
                if(map.containsKey(remove))
                    count+=map.get(remove);
                if(map.containsKey(preFixSum))
                    map.put(preFixSum,map.get(preFixSum)+1);
                else
                    map.put(preFixSum,1);
            }
            return count;
        }

        public int subArraySumEqualsKByTwoPointer(int[] arr, int k) {
            if(k<0) return 0;
            int l=0,r=0,count=0,sum=0;
            while(r<arr.length){
                sum+=arr[r];
                while(sum>k){
                    sum=sum-arr[l];
                    l++;
                }
                count+=(r-l+1);//added all possible arrays less that k sum
                r++;
            }
            return count;
        }

        public int subArraySumEqualtoKForBinaryNumbers(int[] arr, int k) {
            if(k<0) return 0;
            int l=0,r=0,count=0,sum=0;
            while(r<arr.length){
                sum+=arr[r];
                while(sum>k){
                    sum-=arr[l];
                    l++;
                }
                count+=(r-l+1);
                r++;
            }
            return count;
        }

        public int subArrayWithKDiffIntegers(int[] arr, int k) {
            int count=0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                map.clear();
                for(int j=i;j<arr.length;j++){
                    if(map.containsKey(arr[j]))
                        map.put(arr[j],map.get(arr[j])+1);
                    else
                        map.put(arr[j],1);

                    if(map.size()==k)
                        count++;
                    else if(map.size()>k)
                        break;
                }
            }
            return count;
        }

        public int subArrayWithKDiffIntegersOptimalSolution(int[] arr, int k) {
            int l=0,r=0,count=0;
            HashMap<Integer,Integer> map= new HashMap<>();
            while(r<arr.length){
                if(map.containsKey(arr[r]))
                    map.put(arr[r],map.get(arr[r])+1);
                else
                    map.put(arr[r],1);
                while(map.size()>k){
                    map.put(arr[l],map.get(arr[l])-1);
                    if(map.get(arr[l])==0)
                        map.remove(arr[l]);
                    l++;
                }
                count=count+(r-l+1);//(r-l+1) all possible subArrays with new ele
                r++;
            }
            return count;
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

//        //Longest Substring without repeating characters
//        String s="cadbzabcd";
//        System.out.println(sw.longestSubStringWithoutRepeatingChar(s));

        //Maximum consecutive 1's with at most k zeros  Or if you can flip k zeros
//        int arr[]={1,1,1,0,0,0,1,1,1,1,0};
//        int k=2;//O/P-6

//        int arr[]={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int k=3; //O/P-10

//        with two pointer TC-O(N+N)
//        System.out.println(sw.maxConsecutiveOnes(arr,k));

        //with sliding window
//        System.out.println(sw.maxConsecutiveOnesWithFixedSlidingWindow(arr,k));

        // fruit into basket

//        int arr[]={3,3,3,1,2,1,1,2,3,3,4};
//        int k=2;//number of basket

        //brute force
//        System.out.println(sw.maxLengthOfSubArrayWithAtMostKTypesOfNumbers(arr,k));

        //two pointer
//        System.out.println(sw.maxLengthOfSubarrayWithAtmostKTypesOfNumbersTwoPointer(arr,k));

        //sliding window
//        System.out.println(sw.maxLengthOfSubarrayWithAtmostKTypesOfNumbersSlidingWindow(arr,k));

        //Longest Substring with atmost k characters

//        String s="aaabbccd";
//        int k=2;

        //brute force
//        System.out.println(sw.longestSubStringWithKDistinctChar(s,k));

        //two pointer
//        System.out.println(sw.longestSubStringWithKDistinctCharTwoPointer(s,k));

        //sliding window
//        System.out.println(sw.longestSubStringWithKDistinctCharSlidingWindow(s,k));

        //Number Of SubString Containing All three characters
//        String s= "bbacba";

        //brute force
//        System.out.println(sw.NumberOfSubStringContainingAllThreeChar(s));

        //OptimisedBruteFore
//        System.out.println(sw.NumberOfSubStringContainingAllThreeCharOptimisedBruteForce(s));

        //two pointer
//        System.out.println(sw.NumberOfSubStringContainingAllThreeCharTwoPointer(s));

        //Longest Repeating Character Replacement
//        String s= "AABABBA";
//        int k=2;

        //BruteForce
//        System.out.println(sw.longestRepeatingCharacterReplacement(s,k));

        //two pointer
//        System.out.println(sw.longestRepeatingCharacterReplacementTwoPointer(s,k));

        //sliding window
//        System.out.println(sw.longestRepeatingCharacterReplacementSlidingWindow(s,k));

         //count subArray sum equals K
//        int arr[]={1,2,3,-3,1,1,1,4,2,-3};
//        int k=3;//O/p-8
//        int arr[]={1,0,1,0,1};
//        int k=2;//O/p:-4

        //Brute force//for both working same
//        System.out.println(sw.subArraySumEqualsK(arr,k));


        //this is good
        //Optimal solution with prefix sum
//        System.out.println(sw.subArraySumEqualsKPrefixSum(arr,k));


//        this is very good
        ////Only for Binary subArray with sum k
        //two pointer
//        System.out.println(sw.subArraySumEqualsKByTwoPointer(arr,k)-sw.subArraySumEqualsKByTwoPointer(arr,k-1));

        //count the number of nice subArray
//        int arr[]= {1,2,3,4,1};
//        int k=2;

        //convert all odd into 1 ans all even into 0 than it will be same as  Binary subArray with sum ans k act as sum
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]%2==0)
//                arr[i]=0;
//            else arr[i]=1;
//        }
        // same as subArraySumEqualsKByTwoPointer() but writing for practice
//        System.out.println(sw.subArraySumEqualtoKForBinaryNumbers(arr,k)-sw.subArraySumEqualtoKForBinaryNumbers(arr,k-1));

        //SubArray with k different integers

        int arr[]={2,1,1,1,3,4,3,2};
        int k=3;//O/P-9

        //brute force
//        System.out.println(sw.subArrayWithKDiffIntegers(arr,k));


        //Optimal
        System.out.println(sw.subArrayWithKDiffIntegersOptimalSolution(arr,k)-sw.subArrayWithKDiffIntegersOptimalSolution(arr,k-1));




    }
}
