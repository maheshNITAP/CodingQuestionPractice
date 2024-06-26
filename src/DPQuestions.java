import sun.java2d.pipe.SolidTextRenderer;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

        public int evaluateExpressionToTrue(String s, int i, int j, boolean isTrue) {
            if(i>j)
                return 0;
            if(i==j){
                if(isTrue)
                    return s.charAt(i)=='T'?1:0;
                else
                    return s.charAt(i)=='F'?1:0;
            }
            int ans=0;
            for(int k=i+1;k<=j-1;k=k+2){
                int leftTrue=evaluateExpressionToTrue(s,i,k-1,true);
                int leftFalse=evaluateExpressionToTrue(s,i,k-1,false);
                int rightTrue=evaluateExpressionToTrue(s,k+1,j,true);
                int rightFalse=evaluateExpressionToTrue(s,k+1,j,false);
                if(s.charAt(k)=='&'){
                    if(isTrue)
                        ans+=leftTrue*rightTrue;
                    else
                        ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                } else if (s.charAt(k)=='|') {
                    if(isTrue)
                        ans+=leftTrue*rightTrue+leftTrue*rightFalse+leftFalse*rightTrue;
                    else
                        ans+=leftFalse*rightFalse;
                } else if (s.charAt(k)=='^') {
                    if(isTrue)
                        ans+=leftTrue*rightFalse+leftFalse*rightTrue;
                    else
                        ans+=leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
            return ans;
        }

        public int evaluateExpressionToTrueWithMemoization(String s, int i, int j, boolean isTrue, HashMap<StringBuilder, Integer> map) {
            if(i>j)
                return 0;
            if(i==j){
                if(isTrue)
                    return s.charAt(i) == 'T'?1:0;
                else
                    return s.charAt(i)=='F'?1:0;
            }
            StringBuilder temp= new StringBuilder(s.charAt(i) + "_" + s.charAt(j) + "_" + isTrue);
            if(map.containsKey(temp))
                return map.get(temp);
            int ans=0;
            for(int k=i+1;k<=j-1;k=k+2){
                int leftTrue=evaluateExpressionToTrueWithMemoization(s,i,k-1,true,map);
                int leftFalse=evaluateExpressionToTrueWithMemoization(s,i,k-1,false,map);
                int rightTrue=evaluateExpressionToTrueWithMemoization(s,k+1,j,true,map);
                int rightFalse=evaluateExpressionToTrueWithMemoization(s,k+1,j,false,map);

                if(s.charAt(k)=='&'){
                    if(isTrue)
                        ans+=leftTrue*rightTrue;
                    else
                        ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                } else if (s.charAt(k)=='|') {
                    if(isTrue)
                        ans+=leftTrue*rightTrue+leftTrue*rightFalse+leftFalse*rightTrue;
                    else
                        ans+=leftFalse*rightFalse;
                } else if (s.charAt(k)=='^') {
                    if(isTrue)
                        ans+=leftTrue*rightFalse+leftFalse*rightTrue;
                    else
                        ans+=leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
            map.put(temp,ans);
            return ans;

        }

        public boolean scrambledStringRecursive(String a, String b) {
            if(a.length()!= b.length())
                return false;
            if(a.equals(b))
                return true;
            if(a.length()<=1)
                return false;
            int n= a.length();
            boolean flag= false;
            for(int i=1;i<=n-1;i++){
                if((scrambledStringRecursive(a.substring(0,i),b.substring(n-i,n)) && scrambledStringRecursive(a.substring(i,n),b.substring(0,i)))
                        || (scrambledStringRecursive(a.substring(0,i),b.substring(0,i)) && scrambledStringRecursive(a.substring(i,n),b.substring(i,n)))){
                    flag=true;
                    break;
                }
            }
            return flag;
        }

        public boolean  scrambledStringRecursiveWithMemoization(String a, String b, HashMap<String, Boolean> map) {
            if(a.length()!= b.length())
                return false;
            if(a.equals(b))
                return true;
            if(a.length()<=1)
                return false;
            int n=a.length();
            boolean flag=false;
            String s=a+"_"+b;
            if(map.containsKey(s))
                return map.get(s);
            for(int i=1;i<=n-1;i++){
                if((scrambledStringRecursiveWithMemoization(a.substring(0,i),b.substring(n-i,n),map) && scrambledStringRecursiveWithMemoization(a.substring(i,n),b.substring(0,i),map)) //swap
                        || (scrambledStringRecursiveWithMemoization(a.substring(0,i),b.substring(0,i),map) && scrambledStringRecursiveWithMemoization(a.substring(n-i,n),b.substring(n-i,n),map))){// not swap
                    flag=true;
                    break;
                }
            }
            map.put(s,flag);
            return flag;
        }

        public int eggDroppingProblemRecursive(int e, int f) {
            if(f==0 || f==1)
                return f;
            if(e==1)
                return f;
            int mn=Integer.MAX_VALUE;
            for(int k=1;k<=f;k++){
                int temp= 1+Math.max(eggDroppingProblemRecursive(e-1,k-1),eggDroppingProblemRecursive(e,f-k));
                mn=Math.min(temp,mn);
            }
            return mn;
        }

        public int eggDroppingProblemRecursiveWithMemoization(int e, int f, int[][] t) {
            if(e==1)
                return f;
            if(f==0 || f==1)
                return f;
            if(t[e][f]!=-1){
                return t[e][f];
            }
            int mn=Integer.MAX_VALUE;
            for(int k=1;k<=f;k++){
                int temp=1+Math.max(eggDroppingProblemRecursiveWithMemoization(e-1,k-1,t),eggDroppingProblemRecursiveWithMemoization(e,f-k,t));
                mn= Math.min(mn,temp);
            }
            t[e][f]=mn;
            return mn;
        }

        public int eggDroppingProblemRecursiveWithMemoizationAndOptimization(int e, int f, int[][] t) {
            if(e==1)
                return f;
            if(f==0 || f==1)
                return f;
            if(t[e][f]!=-1)
                return t[e][f];

            int mn=Integer.MAX_VALUE;
            for(int k=1;k<=f;k++){
                int low,high;
                if(t[e-1][k-1]!=-1)
                   low= t[e-1][k-1];
                else {
                    low=eggDroppingProblemRecursiveWithMemoizationAndOptimization(e-1,k-1,t);
                    t[e-1][k-1]=low;
                }

                if(t[e][f-k]!=-1)
                    high=t[e][f-k];
                else {
                    high=eggDroppingProblemRecursiveWithMemoizationAndOptimization(e,f-k,t);
                    t[e][f-k]=high;
                }
                int tem=1+Math.max(low,high);
                mn=Math.min(mn,tem);
            }
            return t[e][f]=mn;

        }
    }
    static class Random{

        public int perfectSquare(int n) {
            int arr[]=new int[n+1];
            Arrays.fill(arr,Integer.MAX_VALUE);
            arr[0]=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j*j<=i;j++){
                    arr[i]=Math.min(arr[i],1+arr[i-(j*j)]);
                }
            }
            return arr[n];
        }

        public int numberOfWaysToTileAFloor(int n) {
            int dp[]= new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000007;
            }
            return dp[n];
        }

        public int tilingFloor(int n, int m) {
            if(m>n || n==1 || n==0){
                return 1;
            }
            if(n-m>=0){
                return tilingFloor(n-1,m)+tilingFloor(n-m,m);
            }else {
                return tilingFloor(n-1,m);
            }


        }

        public int tilingFloorWithDp(int n, int m) {
            int dp[]= new int[n+1];
            dp[0]=dp[1]=1;
            for(int i=2;i<=n;i++){
                if(i-m>=0){
                    dp[i]=dp[i-1]+dp[i-m];
                }else
                    dp[i]=dp[i-1];
            }
            return dp[n];
        }

        public int integerBreak(int n) {
            if(n==1 || n==0){
                return 1;
            }
            int ans=Integer.MIN_VALUE;
            for(int k=1;k<n;k++){
               int  temp= k*Math.max(integerBreak(n-k),n-k);//ya to devide kre ya whi rhne de
                ans=Math.max(ans,temp);
            }
            return ans;
        }

        public int integerBreakDp(int n) {
            int dp[]= new int[n+1];
            dp[0]=dp[1]=1;
            for(int i=2;i<=n;i++){
                for(int k=1;k<i;k++){
                    dp[i]=Math.max(dp[i],k*dp[i-k]);
                }
            }
            return dp[n];
        }
    }
    static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int x){
            this.val=x;
        }
    }

    static class Solution {


        public boolean isValid(int land[][],boolean vis[][],int x,int y,int n,int m){
            if(x>=0 && x<n && y>=0 && y<m && land[x][y]==1 && !vis[x][y]){
                return true;
            }
            return false;
        }
        public void solve(int land[][],boolean vis[][],int x,int y,int t[],int n,int m){
            vis[x][y]=true;
            int xx[]={1,-1,0,0};
            int yy[]={0,0,1,-1};
            for(int i=0;i<4;i++){
                if(isValid(land,vis,x+xx[i],y+yy[i],n,m)){
                    solve(land,vis,x+xx[i],y+yy[i],t,n,m);
                    t[2] = Math.max(t[2], x + xx[i]);
                    t[3] = Math.max(t[3], y + yy[i]);
                }
            }
        }
        public int[][] findFarmland(int[][] land) {
            int n=land.length;
            int m=land[0].length;
            boolean vis[][]= new boolean[n][m];
            List<int[]> res = new ArrayList<>();
            int l=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(land[i][j]==1 && !vis[i][j]){
                        int t[]= new int[4];
                        t[0]=t[2]=i;
                        t[1]=t[3]=j;
                        solve(land,vis,i,j,t,n,m);
                        res.add(t);
                    }
                }
            }
            return res.toArray(new int[0][]);
        }


        public boolean isValid(int [][]g1, int [][]g2,boolean vis[][],int x,int y,int n,int m){
            if(x>=0 && x<n && y>=0 && y<m && g2[x][y]==1 && vis[x][y]==false){
                return true;
            }
            return false;
        }
        public boolean solve(int [][]g1,int [][]g2, boolean vis[][], int x,int y, int n,int m){
            vis[x][y]=true;
            int xx[]={1,-1,0,0};
            int yy[]={0,0,1,-1};
            for(int i=0;i<4;i++){
                if(isValid(g1,g2,vis,x+xx[i],y+yy[i],n,m)){
                    if(g2[x+xx[i]][y+yy[i]]==1){
                        return solve(g1,g2,vis,x+xx[i],y+yy[i],n,m);
                    }else {
                        return false;
                    }
                }
            }
            return false;

        }
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int res=0;
            int n=grid1.length;
            int m=grid1[0].length;
            boolean vis[][]= new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid1[i][j]==1 && grid2[i][j]==1 && !vis[i][j]){
                        if(solve(grid1,grid2,vis,i,j,n,m)){
                            ++res;
                        }
                    }
                }
            }
            return res;
        }

        public ListNode createList(int[] lis) {
            ListNode head=null;
            ListNode curr=null;
            for(int i=0;i<lis.length;i++){
                ListNode node= new ListNode(lis[i]);
                if(head== null){
                    head=node;
                    curr=node;
                }else {
                    curr.next=node;
                    curr=node;
                }
            }
            return head;
        }

        public ListNode mergeNodes(ListNode head) {
            ListNode p = head;
            while (p != null && p.next != null) {
                if (p.val == 0) {
                    p = p.next;
                } else{
                    while(p!= null && p.next.val!= 0){
                        p.val+=p.next.val;
                        p.next=p.next.next;
                    }
                    p=p.next;
                }
            }
            return head;

        }
        public int bs(int arr[],int ele){
            int start=0;
            int end=arr.length-1;
            int closest=-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]==ele){
                    return mid;
                }else if(arr[mid]>ele){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            if(start == arr.length){
                return end;
            }else if(end<0){
                return start;
            }
            if(closest==-1){
                closest= Math.abs(arr[start]-ele)<=Math.abs(arr[end]-ele)?start:end;
            }
            return closest;
        }
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr2);
            int res=0;
            for(int i=0;i<arr1.length;i++){
                int closest=bs(arr2,arr1[i]);
                if(Math.abs(arr2[closest]-arr1[i])>d){
                    ++res;
                }
            }
            return res;
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
//        String s="ravi";
//        int i=0;
//        int j=s.length()-1;
//        System.out.println(mcm.palindromePartitioningRecursive(s,i,j));

        //palindrome partitioning  Recursive+Memoization
//        int n=s.length();
//        int t[][]= new int[n+1][n+1];
//        for(int k=0;k<n+1;k++)
//            Arrays.fill(t[k],-1);
//        System.out.println(mcm.palindromePartitioningRecursiveWithMemoization(s,i,j,t));

        ////palindrome partitioning  Recursive+Memoization+Optimized

//        int n=s.length();
//        int t[][]= new int[n+1][n+1];
//        for(int k=0;k<n+1;k++)
//            Arrays.fill(t[k],-1);
//        System.out.println(mcm.palindromePartitioningRecursiveWithMemoizationOptimized(s,i,j,t));

         //Evaluate Expression to true/Boolean Parenthesization Problem

//        String s="T|T&F^T";
//        int i=0;
//        int j=s.length()-1;
//        boolean isTrue=true;
//        System.out.println(mcm.evaluateExpressionToTrue(s,i,j,isTrue));

        //evaluate Expression to true with memoization
//        HashMap<StringBuilder,Integer> map= new HashMap<>();
//        System.out.println(mcm.evaluateExpressionToTrueWithMemoization(s,i,j,isTrue,map));

        //Scrambled String Recursive

//        String a= "great";
//        String b="rgeat";
//        System.out.println(mcm.scrambledStringRecursive(a,b));

//        Scrambled String Recursive+Memoization
//        String a= "great";
//        String b="rgeat";
//        HashMap<String,Boolean> map= new HashMap<>();
//        System.out.println(mcm.scrambledStringRecursiveWithMemoization(a,b,map));

        //Egg dropping problem  recursive
//        int e=3;
//        int f=5;
//        System.out.println(mcm.eggDroppingProblemRecursive(e,f));

        //Egg dropping problem recursive+memoization
//        int e=3;
//        int f=5;
//        int t[][]= new int[e+1][f+1];
//        for(int i=0;i<e+1;i++)
//            Arrays.fill(t[i],-1);
//        System.out.println(mcm.eggDroppingProblemRecursiveWithMemoization(e,f,t));

        //Egg dropping problem recursive+memoization with Optimization

//        int e=3;
//        int f=5;
//        int t[][]= new int[e+1][f+1];
//        for(int i=0;i<e+1;i++)
//            Arrays.fill(t[i],-1);
//        System.out.println(mcm.eggDroppingProblemRecursiveWithMemoizationAndOptimization(e,f,t));



        //Random Questions
        Random ran= new Random();


        //perfect squares
//        int n=12;
//        System.out.println(ran.perfectSquare(n));

        //number of ways to tile a floor
//        int n=4;
//        System.out.println(ran.numberOfWaysToTileAFloor(n));

        //tiling n*m floor using 1*m tiles recursive
//        int n=7;
//        int m=4;
//        System.out.println(ran.tilingFloor(n,m));

        //tiling n*m floor using 1*m tiles+dp
//        int n=7;
//        int m=4;
//        System.out.println(ran.tilingFloorWithDp(n,m));

        //Integer break
            //recursive
//        int n=10;
//        System.out.println(ran.integerBreak(n));

        //dp
//        int n=10;
//        System.out.println(ran.integerBreakDp(n));

        Solution s=new Solution();
//        int arr[][]= {{1,0,0},{0,1,1},{0,1,1}};
//        int t[][]=s.findFarmland(arr);
//        System.out.println(t);

//        int grid1[][] = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
//        int grid2[][]={{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
//        System.out.println(s.countSubIslands(grid1,grid2));

//        int lis[]={0,3,1,0,4,5,2,0};
//        ListNode head=s.createList(lis);
//        s.mergeNodes(head);


        int []arr1 = {2,1,100,3};
        int []arr2 = {-5,-2,10,-3,7};
        int d = 6;
        System.out.println(s.findTheDistanceValue(arr1,arr2,d));





























    }
}
