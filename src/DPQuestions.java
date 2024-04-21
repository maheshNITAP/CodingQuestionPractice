import sun.java2d.pipe.SolidTextRenderer;

import java.util.ArrayList;
import java.util.Arrays;

public class DPQuestions {
    static class DP{

        public int knapSack(int[] wt, int[] val, int W, int n) {
            if(n==0 || W==0)
                return 0;
            if(wt[n-1]<=W)
                return Math.max(val[n-1]+knapSack(wt,val,W-wt[n-1],n-1),knapSack(wt,val,W,n-1));
            else
                return knapSack(wt,val,W,n-1);
        }

        public int knapsackByMemoization(int[] wt, int[] val, int n, int w, int[][] arr) {
            if(n==0 || w==0)
                return 0;
            if(arr[n][w]!=-1)
                return arr[n][w];
            if(wt[n-1]<=w)
                return arr[n][w] = Math.max(val[n-1]+knapsackByMemoization(wt, val, n-1, w-wt[n-1], arr),knapsackByMemoization(wt, val, n-1, w, arr));
            else
                return arr[n][w] = knapsackByMemoization(wt, val, n-1, w, arr);
        }

        public int knapsackWithTopDawn(int[] wt, int[] val, int n, int W) {
            int t[][]= new int[n+1][W+1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<W+1;j++){
                    if(i==0 || j==0){
                        t[i][j]=0;
                    }
                }
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                    if(wt[i-1]<=j){
                        t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                    } else if (wt[i-1]>j) {
                        t[i][j]=t[i-1][j];
                    }
                }
            }
            return t[n][W];
        }

        public boolean subsetSumProblemTopDawn(int[] arr, int sum) {
            int n= arr.length;
            boolean t[][]= new boolean[n+1][sum+1];

            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    if(i==0){
                        t[i][j]=false;
                    }
                    if(j==0)
                        t[i][j]=true;
                }
            }
            for(int i=1;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    if(arr[i-1]<=j){
                        t[i][j]= (t[i-1][j-arr[i-1]] || t[i-1][j]);
                    } else if (arr[i-1]>j) {
                        t[i][j]=t[i-1][j];
                    }
                }
            }
            return t[n][sum];
        }

        public boolean subsetSum(int[] arr, int sum, int n) {
            if(sum==0){
                return true;
            }
            if(n==0){
                return false;
            }
            if(sum>=arr[n-1])
                return (subsetSum(arr,sum-arr[n-1],n-1) || subsetSum(arr,sum,n-1));
            else
                return subsetSum(arr,sum,n-1);
        }

        public int subsetSumByMemoization(int[] arr, int sum, int n ){

            int[][] t = new int[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(t[i], -1);
            }

            if(n==0)
                return 0;
            if(sum==0){
                return 1;
            }
            if(arr[n-1]<=sum)
                return t[n][sum]=(subsetSumByMemoization(arr,sum-arr[n-1],n-1) ==1 || subsetSumByMemoization(arr,sum,n-1)==1) ? 1:0;
            else
                return t[n][sum]= subsetSumByMemoization(arr,sum,n-1);
        }

        private boolean subsetSumForEqualSumPartition(int[] arr, int sum, int n) {
            if(n==0)
                return false;
            if(sum==0)
                return true;
            if(arr[n-1]<=sum)
                return (subsetSumForEqualSumPartition(arr,sum-arr[n-1],n-1) || subsetSumForEqualSumPartition(arr,sum,n-1));
            else
                return subsetSumForEqualSumPartition(arr,sum,n-1);
        }
        public boolean equalSumPartition(int[] arr, int n) {
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=arr[i];
            if(sum%2!= 0)
                return false;
            else if (sum%2==0) {
                return subsetSumForEqualSumPartition(arr,sum/2,n);
            }
            return false;
        }


        public int countOfSubsetSumWithGivenSum(int[] arr, int sum, int n) {
            int t[][]= new int[n+1][sum+1];
            for(int j=0;j<sum+1;j++)
                t[0][j]=0;
            for(int i=0;i<n;i++)
                t[i][0]=1;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(arr[i-1]<=j)
                        t[i][j]= t[i-1][j-arr[i-1]]+t[i-1][j];
                    else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[n][sum];
        }

        public int minimumSubsetSumDiff(int[] arr, int n) {
            int range=0;
            for(int i=0;i<n;i++)
                range+=arr[i];
            boolean[][] t= new boolean[n+1][range+1];
            for(int i=0;i<n+1;i++){
                for(int j=0;j<range+1;j++){
                    if(j==0){
                        t[i][j]=false;
                    }
                    if(i==0){
                        t[i][j]=true;
                    }
                }
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<range+1;j++){
                    if(arr[i-1]<=j){
                        t[i][j]=(t[i-1][j-arr[i-1]] || t[i-1][j]);
                    }else
                        t[i][j]=t[i-1][j];
                }
            }
            ArrayList<Integer> list= new ArrayList<>();
            for(int i=0;i<=range/2;i++){
                if(t[n][i]){
                    list.add(i);
                }
            }
            Integer min= Integer.MAX_VALUE;
            for(int i=0;i<list.size();i++){
                min=Integer.min(min,range-(2* list.get(i)));
            }
            return min;

        }

        private int countOfSubsetSumWithGivenSumForThisMethod(int[] arr, int sum, int n) {
            int t[][]= new int[n+1][sum+1];

            for(int j=0;j<sum+1;j++)
                t[0][j]=0;
            for(int i=0;i<n+1;i++)
                t[i][0]=1;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(arr[i-1]<=j)
                        t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
                    else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[n][sum];
        }
        public int countNumberOfSubsetSumWithGivenDiff(int[] arr, int diff, int n) {
            int arrSum=0;
            for(int i=0;i<n;i++)
                arrSum+=arr[i];

            int sum=(diff+arrSum)/2;
            return countOfSubsetSumWithGivenSumForThisMethod(arr,sum,n);
        }

        public int targetSum(int[] arr, int sum, int n) {
            int diff=sum;
            return countNumberOfSubsetSumWithGivenDiff(arr,diff,n);
        }

        public int unboundedKnapsackRecursive(int[] wt, int[] val, int n, int w) {
            if(n==0 || w==0)
                return 0;
            if(wt[n-1]<=w)
                return Math.max(val[n-1]+unboundedKnapsackRecursive(wt,val,n,w-wt[n-1]),unboundedKnapsackRecursive(wt,val,n-1,w));
            else
                return unboundedKnapsackRecursive(wt,val,n-1,w);

        }

        public int unboundedKnapsackRecursiveWithMemoization(int[] wt, int[] val, int n, int w) {
            int t[][]=new int[n+1][w+1];
            for(int i=0;i<=n;i++)
                Arrays.fill(t[i],-1);
            if(n==0 || w==0)
                return 0;
            if(t[n][w]!=-1)
                return t[n][w];
            if(wt[n-1]<=w)
                return t[n][w]=Math.max(val[n-1]+unboundedKnapsackRecursiveWithMemoization(wt,val,n,w-wt[n-1]),unboundedKnapsackRecursiveWithMemoization(wt,val,n-1,w) );
            else
                return t[n][w]=unboundedKnapsackRecursiveWithMemoization(wt,val,n-1,w);

        }

        public int unboundedKnapsackTopDawn(int[] wt, int[] val, int n, int w) {
            int t[][]= new int[n+1][w+1];
            for(int i=0;i<n+1;i++){
                t[i][0]=0;
            }
            for(int j=0;j<w+1;j++){
                t[0][j]=0;
            }
            for(int i=1;i<n+1;i++){
                for(int j=0;j<w+1;j++){
                    if(wt[i-1]<=j){
                        t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                    }else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[n][w];
        }

        public int rodCuttingProblemByUnboundedTopDawn(int[] length, int[] price, int n, int size) {
            int t[][]= new int[size+1][n+1];
            for(int i=0;i<size+1;i++){
                t[i][0]=0;
            }
            for(int j=0;j<n+1;j++){
                t[0][j]=0;
            }
            for(int i=1;i<size+1;i++){
                for(int j=1;j<n+1;j++){
                    if(length[i-1]<=j)
                        t[i][j]=Math.max(price[i-1]+t[i][j-length[i-1]],t[i-1][j]);
                    else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[size][n];
        }

        public int coinChange1stByTopdown(int[] coin, int sum, int n) {
            int t[][]= new int[n+1][sum+1];
            for(int j=0;j<sum+1;j++)
                t[0][j]=0;
            for(int i=0;i<n+1;i++)
                t[i][0]=1;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(coin[i-1]<=j){
                        t[i][j]=(t[i][j-coin[i-1]]+ t[i-1][j]);
                    }else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[n][sum];
        }

        public int coinChange2ndByTopDown(int[] coins, int sum, int n) {
            int t[][]= new int[n+1][sum+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<sum+1;j++){
                t[0][j]=Integer.MAX_VALUE-1;
            }
            //initialize second row
            for(int j=1;j<sum+1;j++){
                if(j%coins[0]==0)
                    t[1][j]=j/coins[0];
                else
                    t[1][j]=Integer.MAX_VALUE-1;
            }

            for(int i=2;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(coins[i-1]<=j)
                        t[i][j]=Integer.min(t[i][j-coins[i-1]]+1,t[i-1][j]);
                    else
                        t[i][j]=t[i-1][j];
                }
            }
            return t[n][sum];
        }
    }

    static class LCS{//longest Common subsequence
        public int longestCommonSubSequenceRecursive(String x, String y, int n, int m) {
            if(n==0 || m==0)
                return 0;
            if(x.charAt(n-1)==y.charAt(m-1))
                return 1+longestCommonSubSequenceRecursive(x,y,n-1,m-1);
            else
                return Math.max(longestCommonSubSequenceRecursive(x,y,n-1,m),longestCommonSubSequenceRecursive(x,y,n,m-1));
        }

        public int longestCommonSubSequenceRecursiveWithMemoization(String x, String y, int n, int m, int[][] arr) {
            if(n==0|| m==0)
                return 0;

            if(arr[n][m]!=-1)
                return arr[n][m];
            if(x.charAt(n-1)==y.charAt(m-1))
                return 1+longestCommonSubSequenceRecursiveWithMemoization(x,y,n-1,m-1,arr);
            else
                return Math.max(longestCommonSubSequenceRecursiveWithMemoization(x,y,n-1,m,arr),longestCommonSubSequenceRecursiveWithMemoization(x,y,n,m-1,arr));
        }

        public int longestCommonSubSequenceTopDawn(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];

            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
            return t[n][m];
        }

        public int longestCommonSubString(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1) == y.charAt(j-1))
                        t[i][j]=t[i-1][j-1]+1;
                    else
                        t[i][j]=0;
                }
            }
            int len=Integer.MIN_VALUE;
            for(int i=0;i<n+1;i++){
                for(int j=0;j<m+1;j++){
                    len=Math.max(len,t[i][j]);
                }
            }
            return len;
        }

        public StringBuilder printLongestCommonSubsequence(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
            int i=n,j=m;
            StringBuilder s= new StringBuilder();
            while(i>0 && j>0){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    s.append(x.charAt(i-1));
                    --i;
                    --j;
                }else if(x.charAt(i-1) != y.charAt(j-1)){
                    if(t[i-1][j]>t[i][j-1])
                        --i;
                    else
                        --j;
                }
            }
            s.reverse();
            return s;
        }

        private int longestCommonSubsequenceTopDawnUtil(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<n;j++)
                t[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
                }
            }
            return t[n][m];
        }
        public int shortestSuperSequence(String x, String y, int n, int m) {
            return n+m-longestCommonSubsequenceTopDawnUtil(x,y,n,m);
        }

        private int lcsUtilTopDawn(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
            return t[n][m];
        }
        public Result minimumNumberOfInsertionAndDeletionToConvertStringAtoB(String x, String y, int n, int m) {
            int lcs=lcsUtilTopDawn(x,y,n,m);
            int deletion=n-lcs;
            int insertion=m-lcs;
            return new Result(insertion,deletion);
        }


        public int longestPalindromicSubsequence(String x, int n) {
            StringBuilder y= new StringBuilder(x);
            y.reverse();
            return lcsUtilTopDawn(x, y.toString(), n,y.length());

        }

        private int longestCommonSubsequences(String x, String y, int n, int m) {
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][1]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
            return t[n][m];
        }
        public int minimumNumberOfDeletions(String s, int n) {
            StringBuilder t= new StringBuilder(s);
            t.reverse();
            return n-longestCommonSubsequences(s,t.toString(),n,t.length());
        }

        public String printShortestCommonSuperSequence(String x, String y, int n, int m) {
            //implement LCS by topdown
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }

            int i=n,j=m;
            StringBuilder s= new StringBuilder();
            while(i>0 && j>0){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    s.append(x.charAt(i-1));
                    --i;
                    --j;
                }else {
                    if(t[i-1][j]>t[i][j-1]){
                        s.append(x.charAt(i-1));
                        --i;
                    }else{
                        s.append(y.charAt(j-1));
                        --j;
                    }
                }
            }
            return s.reverse().toString();
        }

        public int longestRepeatingSubsequence(String x, int n) {//use the same string as y and don't include the ele where i==j
            String y=x;
            int m=n;
            int t[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                t[i][0]=0;
            for(int j=0;j<m+1;j++)
                t[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1) && i!= j)// i!=j
                        t[i][j]=1+t[i-1][j-1];
                    else
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
            return t[n][m];
        }

        public boolean sequencePatternMatching(String x, String y, int n, int m) {
            if(Math.min(n,m)==lcsUtilTopDawn(x,y,n,m))
                return true;
            return false;
        }

        public int maximumNumberOfInsertionToMakeItPalindrome(String x, int n) {// same as minimum number of insertion
            String y=new StringBuilder(x).reverse().toString();
            return n-lcsUtilTopDawn(x,y,n,y.length());

        }
    }
    static class Result{
        int insertion;
        int deletion;

        Result (int insertion,int deletion){
            this.insertion=insertion;
            this.deletion=deletion;
        }
    }
    static class MCM{

        public int mcmRecursive(int[] arr, int i, int j) {
            if(i>=j)
                return 0;
            int ans=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int temp=mcmRecursive(arr,i,k)+mcmRecursive(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
                ans=Math.min(ans,temp);
            }
            return ans;
        }

        public int mcmRecursiveWithMemoization(int[] arr, int i, int j, int [][]t) {
            if(i>=j)
                return 0;
            if(t[i][j]!=-1)
                return t[i][j];
            int ans=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int temp= mcmRecursiveWithMemoization(arr,i,k,t)+mcmRecursiveWithMemoization(arr,k+1,j,t)+(arr[i-1]*arr[k]*arr[j]);
                ans=Math.min(ans,temp);
            }
            return t[i][j]=ans;
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i<=j){
                if(s.charAt(i)!=s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
        public int palindromePartitioningRecursive(String s, int i, int j) {
            if(i>=j)
                return 0;
            if(isPalindrome(s,i,j))
                return 0;
            int res=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int temp=palindromePartitioningRecursive(s,i,k)+palindromePartitioningRecursive(s,k+1,j)+1;
                res=Math.min(temp,res);
            }
            return res;
        }


        public int palindromePartitioningRecursiveWithMemoization(String s, int i, int j, int[][] t) {
            if(i>j || isPalindrome(s,i,j))
                return 0;
            if(t[i][j]!=-1)
                return t[i][j];
            int mn=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int temp=palindromePartitioningRecursiveWithMemoization(s,i,k,t)+palindromePartitioningRecursiveWithMemoization(s,k+1,j,t)+1;
                mn=Math.min(mn,temp);
            }
            return t[i][j]=mn;
        }

        public int palindromePartitioningRecursiveWithMemoizationOptimized(String s, int i, int j, int[][] t) {
            if(i>j || isPalindrome(s,i,j))
                return 0;
            if(t[i][j] != -1)
                return t[i][j];
            int mn=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                t[i][k]=palindromePartitioningRecursiveWithMemoizationOptimized(s,i,k,t);
                t[k+1][j]=palindromePartitioningRecursiveWithMemoizationOptimized(s,k+1,j,t);
                int temp=t[i][k]+t[k+1][j]+1;
                mn=Math.min(mn,temp);
            }
            return t[i][j]=mn;
        }
    }
    public static void main(String args[]){

        DP dp=new DP();
        //0/1 knapSack
//        int wt[]={1,3,4,5};
//        int val[]={1,4,5,7};
//        int n=4;
//        int W=7;

//        System.out.println(dp.knapSack(wt,val,W,n));

        //0/1 knapsack with memoization
//        int wt[]={1,3,4,5};
//        int val[]={1,4,5,7};
//        int n=4;
//        int W=7;

//        int wt[]={10, 20, 30};
//        int val[]={60, 100, 120};
//        int n=3;
//        int W=50;
//        int arr[][]= new int[n+1][W+1];
//        for(int i=0;i<n+1;i++)
//            Arrays.fill(arr[i],-1);
//        System.out.println(dp.knapsackByMemoization(wt,val,n,W,arr));

        //--0/1 knapsack with top-down approach
//        int wt[]={1,3,4,5};
//        int val[]={1,4,5,7};
//        int n=4;
//        int W=7;

//        int wt[]={10, 20, 30};
//        int val[]={60, 100, 120};
//        int n=3;
//        int W=50;
//        System.out.println(dp.knapsackWithTopDawn(wt,val,n,W));

        //subset sum recursive
//        int arr[]={2,3,7,8,10};
//        int sum=14;
//        System.out.println(dp.subsetSum(arr,sum, arr.length));

        //subset sum by memoization
//        int arr[]={2,3,7,8,10};
//        int sum=10;
//        System.out.println(dp.subsetSumByMemoization(arr,sum,arr.length));


        //subset sum problem top down
//        int arr[]={2,3,7,8,10};
////        int sum=10; //---true
//        int sum=14;  //--false
//        System.out.println(dp.subsetSumProblemTopDawn(arr,sum));

        //Equal sum partition
//        int arr[]={1,5,11,5};//--true
//        int arr[]={1,5,11,6};//--false
//        System.out.println(dp.equalSumPartition(arr,arr.length));


        //count of subset sum with given sum
//        int arr[]={1,2,3,3};
//        int sum=6;
//        System.out.println(dp.countOfSubsetSumWithGivenSum(arr,sum,arr.length));

        //minimum subset sum difference
//        int arr[]={1,6,11,5};
//        System.out.println(dp.minimumSubsetSumDiff(arr,arr.length));

        //count the number of subset with given differnce
//        int arr[]={1,1,2,3};
//        int diff=1;
//        System.out.println(dp.countNumberOfSubsetSumWithGivenDiff(arr,diff,arr.length));

        //target sum
//        int arr[]={1,1,2,3};
//        int sum=1;
//        System.out.println(dp.targetSum(arr,sum,arr.length));




        //Unbounded knapsack


//        int wt[]={1,3,4,5};
//        int val[]={1,4,5,7};
//        int n=4;
//        int W=7;


        //---Unbounded knapsack recursive
//        System.out.println(dp.unboundedKnapsackRecursive(wt,val,n,W));

        //---Unbounded knapsack recursive+memoization
//        System.out.println(dp.unboundedKnapsackRecursiveWithMemoization(wt,val,n,W));

        //--unbounded knapsack top-dawn approach
//        System.out.println(dp.unboundedKnapsackTopDawn(wt,val,n,W));

        //rod cutting problem
//        int length[]={1,2,3,4,5,6,7,8};
//        int price[]={1,5,8,9,10,17,17,20};
//        int N=8;//-rod length
//        int size=length.length;
//        System.out.println(dp.rodCuttingProblemByUnboundedTopDawn(length,price,N,size));

       //coin change 1st//---max number of ways

//       int coin[]={1,2,3};
//       int sum=5;
//       System.out.println(dp.coinChange1stByTopdown(coin,sum,coin.length));

       //coin change 2nd----minimum number of coins
//        int coins[]={25,10,5};
//        int sum=30;    //--ans=2

//        int coins[]={1,2,3};
//        int sum=5;
//        System.out.println(dp.coinChange2ndByTopDown(coins,sum,coins.length));


        //LONGEST COMMON SUBSEQUENCE

        LCS lcs= new LCS();
        //longest common subsequence
//        String x="abcdgh";
//        String y="abedfh";
//        System.out.println(lcs.longestCommonSubSequenceRecursive(x,y,x.length(),y.length()));

//        String x="abcdgh";
//        String y="abedfh";
//        int n=x.length();
//        int m=y.length();
//        int arr[][]= new int[n+1][m+1];
//        for(int i=0;i<n+1;i++)
//            Arrays.fill(arr[i],-1);
//        System.out.println(lcs.longestCommonSubSequenceRecursiveWithMemoization(x,y,n,m,arr));

//        String x="abcdgh";
//        String y="abedfh";
//        int n=x.length();
//        int m=y.length();
//        System.out.println(lcs.longestCommonSubSequenceTopDawn(x,y,n,m));

        //longest common substring

//        String x="abcde";
//        String y="abfce";
//        System.out.println(lcs.longestCommonSubString(x,y,x.length(),y.length()));

        //print longest common subsequence

//        String x="abcdgh";
//        String y="abedfh";
//        System.out.println(lcs.printLongestCommonSubsequence(x,y,x.length(),y.length()));

        //shortest common superSequence
//        String x="AGGTAB";
//        String y="GXTXAYB";
//        System.out.println(lcs.shortestSuperSequence(x,y,x.length(),y.length()));

        //minimum number opf insertion and deletion to convert string a to b
//        String x="heap";
//        String y="pea";
//        Result rs=lcs.minimumNumberOfInsertionAndDeletionToConvertStringAtoB(x,y,x.length(),y.length());
//        System.out.println("number Of insertion :"+rs.insertion+" number of deletion :"+rs.deletion);

        //longest palindromic subsequences
//        String x= "abcba";
//        String x= "bbbab";
//        System.out.println(lcs.longestPalindromicSubsequence(x,x.length()));

        //Minimum number of deletions to make it Palindromic
//        String s="aebcbda";
//        System.out.println(lcs.minimumNumberOfDeletions(s,s.length()));

        //Print shortest common super sequence
//        String x="acbcf";
//        String y="abcdaf";
//        System.out.println(lcs.printShortestCommonSuperSequence(x,y,x.length(),y.length()));

        //longest repeating subsequence
//        String x="AABEBCDD";
//        System.out.println(lcs.longestRepeatingSubsequence(x,x.length()));

        //Sequence pattern matching
//        String x="AXY";
//        String y="ADXCPY";
//        System.out.println(lcs.sequencePatternMatching(x,y,x.length(),y.length()));

        //minimum number of insertion in a string to make it palindrome
//        String x="aebcbda";
//        System.out.println(lcs.maximumNumberOfInsertionToMakeItPalindrome(x,x.length()));


        //Matrix Chain Multiplication

        MCM mcm= new MCM();

        //MCM recursive

//        int arr[]={40,20,30,10,30};
//        int i=1;//i=1 taaki a[i-1] should not be a[-1]
//        int j= arr.length-1;// taki last main emty matrix set na bche
//        System.out.println(mcm.mcmRecursive(arr,i,j));

        //mcm recursive+memoization
//        int n= arr.length;
//        int t[][]= new int[n+1][n+1];
//        for(int k=0;k<n+1;k++)
//            Arrays.fill(t[k],-1);
//        System.out.println(mcm.mcmRecursiveWithMemoization(arr,i,j,t));


        //palindrome Partitioning Recursive(Ex:- nitin,ravi,kriti)
        String s="ravi";
        int i=0;
        int j=s.length()-1;
//        System.out.println(mcm.palindromePartitioningRecursive(s,i,j));

        //palindrome partitioning  Recursive+Memoization
//        int n=s.length();
//        int t[][]= new int[n+1][n+1];
//        for(int k=0;k<n+1;k++)
//            Arrays.fill(t[k],-1);
//        System.out.println(mcm.palindromePartitioningRecursiveWithMemoization(s,i,j,t));

        ////palindrome partitioning  Recursive+Memoization+Optimized

        int n=s.length();
        int t[][]= new int[n+1][n+1];
        for(int k=0;k<n+1;k++)
            Arrays.fill(t[k],-1);
        System.out.println(mcm.palindromePartitioningRecursiveWithMemoizationOptimized(s,i,j,t));























    }
}
