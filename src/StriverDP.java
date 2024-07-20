import java.util.ArrayList;
import java.util.Arrays;

public class StriverDP {
    static class DP{

        public int frogJump(int[] height, int ind) {
            if(ind==0)
                return 0;
            int last=frogJump(height,ind-1)+Math.abs(height[ind]-height[ind-1]);
            int secLast=Integer.MAX_VALUE;
            if(ind>1){
                secLast=frogJump(height,ind-2)+Math.abs(height[ind]-height[ind-2]);
            }
            return Math.min(last,secLast);
        }

        public int frogJumpByMemoization(int[] height, int ind, int[] dp) {
            if(ind==0)
                return 0;
            if(dp[ind]!=-1)
                return dp[ind];
            int last=frogJumpByMemoization(height,ind-1,dp)+Math.abs(height[ind]-height[ind-1]);
            int secLast=Integer.MAX_VALUE;
            if(ind>1)
                secLast=frogJumpByMemoization(height, ind-2, dp)+Math.abs(height[ind]-height[ind-2]);
            return dp[ind]=Math.min(last,secLast);

        }

        public int frogJumpByTabulation(int[] height, int ind) {
            int dp[]= new int[ind+1];
            dp[0]=0;
            for(int i=1;i<=ind;i++){
                int last=dp[i-1]+Math.abs(height[i]-height[i-1]);
                int secLast=Integer.MAX_VALUE;
                if(i>1){
                    secLast=dp[i-2]+Math.abs(height[i]-height[i-2]);
                }
                dp[i]=Math.min(last,secLast);
            }
            return dp[ind];
        }

        public int frogJumpWithKDistance(int[] height, int ind, int k) {
            if(ind==0)
                return 0;
            int minSteps=Integer.MAX_VALUE;
            int jump=0;
            for(int j=1;j<=k;j++){
                if(ind-j>=0){
                    jump=frogJumpWithKDistance(height,ind-j,k)+Math.abs(height[ind]-height[ind-j]);
                    minSteps=Math.min(minSteps,jump);
                }
            }
            return minSteps;
        }

        public int frogJumpWithKDistanceByMemoization(int[] height, int ind, int k, int[] dp) {
            if(ind==0)
                return 0;
            if(dp[ind]!= -1)
                return dp[ind];
            int minSteps=Integer.MAX_VALUE;
            int jump=0;
            for(int i=1;i<=k && ind-i>=0 ; i++){
                jump=frogJumpWithKDistanceByMemoization(height, ind-i, k, dp)+Math.abs(height[ind]-height[ind-i]);
                minSteps=Math.min(minSteps,jump);
            }
            return dp[ind]=minSteps;
        }

        public int frogJumpWithKDistanceByTabulation(int[] height, int n, int k) {
            int dp[]= new int[n+1];
            dp[0]=0;
            int jump=0;
            int minSteps=Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=k;j++){
                    if(i-j>=0){
                        jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
                        minSteps=Math.min(minSteps,jump);
                    }
                }
                dp[i]=minSteps;
            }
            return dp[n];
        }

        public int houseRobber(int[] arr, int ind) {
            if(ind==0)
                return arr[0];
            if(ind<0)
                return 0;
            int pick=arr[ind]+houseRobber(arr,ind-2);
            int notPick=houseRobber(arr,ind-1);
            return Math.max(pick,notPick);
        }

        public int houseRobberWithMemoization(int[] arr, int ind, int[] dp) {
            if(ind==0)
                return arr[0];
            if(ind<0)
                return 0;
            if(dp[ind]!=-1)
                return dp[ind];
            int pick=arr[ind]+houseRobberWithMemoization(arr, ind-2, dp);
            int notPick=houseRobberWithMemoization(arr,ind-1,dp);
            return dp[ind]=Math.max(pick,notPick);
        }

        public int houseRobberWithTabulation(int[] arr, int n) {
            int dp[]= new int [n];
            dp[0]=arr[0];
            for(int i=1;i<n;i++){
                int pick=arr[i]; if(i>1) pick+=dp[i-2];
                int notPick=dp[i-1];

                dp[i]=Math.max(pick,notPick);
            }
            return dp[n-1];
        }

        public int houseRobberWithTabulationAndSpaceOptimization(int[] arr, int n) {
            int prev=arr[0];
            int prev2=0;
            int curr=0;
            for(int i=1;i<n;i++){
                int pick=arr[i]; if(i>1) pick+=prev2;
                int notPick=prev;
                curr=Math.max(pick,notPick);
                prev2=prev;
                prev=curr;
            }
            return prev;
        }

        public int ninjasTraining(int[][] task, int day, int last) {
            int maxi=Integer.MIN_VALUE;
            if(day==0){
                for(int i=0;i<3;i++){
                    if(i!=last){
                        maxi=Math.max(maxi,task[day][i]);
                    }
                }
                return maxi;
            }
            int temp=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    temp=task[day][i]+ninjasTraining(task,day-1,i);
                    maxi=Math.max(maxi,temp);
                }
            }
            return maxi;
        }

        public int ninjasTrainingWithMemoization(int[][] task, int day, int last, int[][] dp) {
            int maxi=Integer.MIN_VALUE;
            if(day==0){
                for(int i=0;i<3;i++){
                    if(i!= last)
                        maxi=Math.max(maxi,task[day][i]);
                }
                return maxi;
            }
            if(dp[day][last]!= -1)
                return dp[day][last];
            int temp=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    temp=task[day][i]+ninjasTrainingWithMemoization(task, day-1, i, dp);
                    maxi=Math.max(maxi,temp);
                }
            }
            return dp[day][last]=maxi;
        }
        public int ninjasTrainingWithTabulation(int[][] points, int n) {
            int dp[][]= new int[n][4];//4--3 types of training
            dp[0][0]=Math.max(points[0][1],points[0][2]);
            dp[0][1]=Math.max(points[0][0],points[0][2]);
            dp[0][2]=Math.max(points[0][0],points[0][1]);
            dp[0][3]=Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

            for(int day=1;day<n;day++){
                for(int last=0;last<4;last++){
                    dp[day][last]=0;
                    int maxi=0;
                    for(int task=0;task<3;task++){
                        if(task!=last){
                            int point=points[day][task]+dp[day-1][task];
                            maxi=Math.max(maxi,point);
                        }
                    }
                    dp[day][last]=maxi;
                }
            }
            return dp[n-1][3];
        }

        public int countVowelStrings(int n) {
            StringBuilder s= new StringBuilder("");
           return solve(n,s);
        }

        private int solve(int n, StringBuilder s) {
            int ans=0;
            if(n==0){
                if(s.length()>0){
                    return 1;
                }
                return 0;
            }
            for(int i=0;i<5;i++){
                if(s.length()==0){
                    s.append(Character.toChars(i));
                    ans+=solve(n-1,s);
                    s.deleteCharAt(s.length()-1);
                }else {
                    char[] chars = Character.toChars(i);
                    if(chars[0]>=s.charAt(s.length()-1)){
                        s.append(Character.toChars(i));
                        ans+=solve(n-1,s);
                        s.deleteCharAt(s.length()-1);
                    }
                }

            }
            return ans;
        }


        public int totalUniquePaths(int n, int m) {
            int dp[][]=new int[n][m];
            int up=0;
            int left=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 && j==0)
                        dp[i][j]=1;
                    else{
                        up=0;
                        left=0;
                        if(i>0)
                            up=dp[i-1][j];
                        if(j>0)
                            left=dp[i][j-1];
                        dp[i][j]=up+left;
                    }
                }
            }
            return dp[n-1][m-1];
        }

        public int totalUniquePathsWithObstacles(int[][] path, int n, int m) {
            if(n>=0 && m>=0 && path[n][m]==-1)
                return 0;
            if(n==0 && m==0)
                return 1;
            if(n<0 || m<0)
                return 0;
            return totalUniquePathsWithObstacles(path,n-1,m)+totalUniquePathsWithObstacles(path,n,m-1);
        }

        public int minPathSumRecursive(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            return minPathSumRec(n-1,m-1,grid);
        }

        private int minPathSumRec(int i, int j, int[][] grid) {
            if(i<0 || j<0)
                return Integer.MAX_VALUE-9;
            if(i==0 && j==0)
                return grid[i][j];
            int up=grid[i][j]+minPathSumRec(i-1,j,grid);
            int left=grid[i][j]+minPathSumRec(i,j-1,grid);
            return Math.min(up,left);
        }

        public int minPathSumRecursiveWithMemoization(int[][] grid) {
            int n= grid.length;
            int m=grid[0].length;
            int t[][]= new int[n][m];
            for(int i=0;i<n;i++){
                Arrays.fill(t[i],-1);
            }
            return minPathSumRecWithMemo(n-1,m-1,grid,t);

        }

        private int minPathSumRecWithMemo(int i, int j, int[][] grid, int[][] t) {
            if(i==0 && j==0)
                return grid[i][j];
            if(i<0 || j<0)
                return Integer.MAX_VALUE/2;//we divided by 2 so it should not be integer Overflow
            if(t[i][j]!=-1)
                return t[i][j];
            return t[i][j]=grid[i][j]+Math.min(minPathSumRecWithMemo(i-1,j,grid,t),minPathSumRecWithMemo(i,j-1,grid,t));
        }

        public int minPathSumTabulation(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int dp[][]= new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 && j==0){
                        dp[i][j]=grid[i][j];
                    }else {
                        int up,left;
                        if(i>0)
                            up=grid[i][j]+dp[i-1][j];
                        else
                            up=Integer.MAX_VALUE;
                        if(j>0)
                            left=grid[i][j]+dp[i][j-1];
                        else
                            left=Integer.MAX_VALUE;
                        dp[i][j]=Math.min(up,left);
                    }
                }
            }
            return dp[n-1][m-1];
        }

        public int minPathSumOfTriangularArraylist(int[][] grid, int n) {

            //min Path sum of Triangular Array list recursive solution
//            return minPathSumOfTriangularArraylistRec(0,0,grid,n);

            //min Path sum of Triangular Array list recursive with memoization
            int dp[][]= new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return minPathSumOfTriangularArraylistRecWithMemoization(0,0,n,grid,dp);

        }

        private int minPathSumOfTriangularArraylistRecWithMemoization(int i, int j, int n, int[][] grid, int[][] dp) {
            if(i==n-1)
                return grid[i][j];
            if(dp[i][j]!= -1)
                return dp[i][j];
            return dp[i][j]=grid[i][j]+Math.min(minPathSumOfTriangularArraylistRecWithMemoization(i+1,j,n,grid,dp),minPathSumOfTriangularArraylistRecWithMemoization(i+1,j+1,n,grid,dp));
        }

        private int minPathSumOfTriangularArraylistRec(int i, int j, int[][] grid, int n) {
            if(i==n-1)
                return grid[n-1][j];
            return grid[i][j]+Math.min(minPathSumOfTriangularArraylistRec(i+1,j,grid,n),minPathSumOfTriangularArraylistRec(i+1,j+1,grid,n));
        }

        public int minPathSumOfTriangularArraylistWithTabulation(int[][] grid, int n) {
            int dp[][]= new int[n][n];
            for(int j=0;j<n;j++)
                dp[n-1][j]=grid[n-1][j];
            for(int i=n-2;i>=0;--i){
                for(int j=i;j>=0;--j){
                    dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
            }
            return dp[0][0];
        }

        public int maxPathSumInMatrix(int[][] grid, int n, int m) {
            int max=Integer.MIN_VALUE;
            //By recursion
//            for (int j=0;j<m;j++){
//                max=Math.max(max,maxPathSumInMatrixByRecursion(grid,n,m,n-1,j));
//            }
            //by recursion+memoization
            int[][] t = new int[n][m];
            for(int i=0;i<n;i++)
                Arrays.fill(t[i],-1);

            for(int j=0;j<m;j++)
                max=Math.max(max,maxPathSumInMatrixByRecursionWithMemoization(grid,n,m,n-1,j,t));

            return max;
        }

        private int maxPathSumInMatrixByRecursionWithMemoization(int[][] grid, int n, int m, int i, int j, int[][] t) {
            if(j<0 || j>=m)
                return Integer.MIN_VALUE;
            if(i==0)
                return grid[i][j];
            if(t[i][j]!=-1)
                return t[i][j];
            int up=grid[i][j]+maxPathSumInMatrixByRecursionWithMemoization(grid, n, m, i-1, j, t);
            int leftDigonal=grid[i][j]+maxPathSumInMatrixByRecursionWithMemoization(grid, n, m, i-1, j-1, t);
            int rightDigonal=grid[i][j]+maxPathSumInMatrixByRecursionWithMemoization(grid, n, m, i-1, j+1, t);
            return t[i][j]= Math.max(up,Math.max(leftDigonal,rightDigonal));
        }

        private int maxPathSumInMatrixByRecursion(int[][] grid, int n, int m, int i, int j) {
            if(j<0 || j>=m){
                return Integer.MIN_VALUE;
            }
            if(i==0){
                return grid[i][j];
            }
            int up=grid[i][j]+maxPathSumInMatrixByRecursion(grid, n, m, i-1, j);
            int leftDiagonal=grid[i][j]+maxPathSumInMatrixByRecursion(grid, n, m, i-1, j-1);
            int rightDiagonal=grid[i][j]+maxPathSumInMatrixByRecursion(grid, n, m, i-1, j+1);
            return Math.max(up,Math.max(leftDiagonal,rightDiagonal));
        }

        public int maxPathSumInMatrixWithTabulation(int[][] grid, int n, int m) {
            int dp[][]= new int[n][m];
            for(int j=0;j<m;j++)
                dp[0][j]=grid[0][j];
            for(int i=1;i<n;i++){
                for(int j=0;j<m;j++){
                    int up=grid[i][j]+dp[i-1][j];
                    int ld=grid[i][j];
                    if(j-1>=0) ld+=dp[i-1][j-1];else ld+=Integer.MIN_VALUE;
                    int rd=grid[i][j];
                    if(j+1<m) rd+=dp[i-1][j+1]; else rd+=Integer.MIN_VALUE;

                    dp[i][j]=Math.max(up,Math.max(ld,rd));
                }
            }
            int max=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                max=Math.max(max,dp[n-1][j]);
            }
            return max;
        }

        public int maxChocolatesCollectedByAliceAndBob(int[][] grid, int n, int m) {
            //initially bob at(0,0) and Alice at (0,m-1)
//            so i=0 and j1=0,j2=m-1;

            //recursive
//            return maxChocolatesCollectedByAliceAndBobRecursive(grid,n,m,0,0,m-1);//i,j1,j2

            //recursive+memoization
            int dp[][][] = new int[n][m][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    Arrays.fill(dp[i][j],-1);
                }
            }
            return maxChocolatesCollectedByAliceAndBobRecursiveWithMemoization(grid,n,m,dp,0,0,m-1);
        }

        private int maxChocolatesCollectedByAliceAndBobRecursiveWithMemoization(int[][] grid, int n, int m, int[][][] dp, int i, int j1, int j2) {
            if(j1<0 ||j1>= m || j2<0 || j2>=m)
                return Integer.MIN_VALUE;
            if(i==n-1){
                if(j1==j2)
                    return grid[i][j1];
                else return grid[i][j1]+grid[i][j2];
            }
            if(dp[i][j1][j2]!=-1)
                return dp[i][j1][j2];
            int max=Integer.MIN_VALUE;
            for(int dj1=-1;dj1<=1;dj1++){
                for(int dj2=-1;dj2<=1;dj2++){
                    int val=0;
                    if(j1==j2) val=grid[i][j2];
                    else val=grid[i][j1]+grid[i][j2];
                    max=Math.max(max,val+maxChocolatesCollectedByAliceAndBobRecursiveWithMemoization(grid,n,m,dp,i+1,j1+dj1,j2+dj2));
                }
            }
            return dp[i][j1][j2]=max;
        }

        private int maxChocolatesCollectedByAliceAndBobRecursive(int[][] grid, int n, int m, int i, int j1, int j2) {
            if(j1<0 || j1>=m || j2<0 || j2>=m)
                return Integer.MIN_VALUE;
            if(i==n-1){
                if(j1==j2)//if both are on sa,e cell
                    return grid[i][j1];
                else return grid[i][j1]+grid[i][j2];
            }
            int max=Integer.MIN_VALUE;
            for(int dj1=-1; dj1<=1;dj1++){
                for(int dj2=-1;dj2<=1;dj2++){
                    int value=0;
                    if(j1==j2)
                        value=grid[i][j1];
                    else value=grid[i][j1]+grid[i][j2];
                    value+=maxChocolatesCollectedByAliceAndBobRecursive(grid,n,m,i+1,j1+dj1,j2+dj2);
                    max=Math.max(max,value);
                }
            }
            return max;
        }

        public boolean subsetSum(int[] arr, int ind, int sum) {
            if(sum==0) return true;
            if(ind ==0) return false;
            boolean notTake = subsetSum(arr,ind-1,sum);
            boolean take= false;
            if(arr[ind-1]<=sum)
                take= subsetSum(arr,ind-1,sum-arr[ind-1]);
            return take || notTake;
        }

        public boolean subsetSumWithMemoization(int[] arr, int sum, int[][] dp, int ind) {
            if(sum==0) return true;
            if(ind==0)return false;
            if(dp[sum][ind]!=-1)
                return dp[sum][ind]==1 ? true:false;
            boolean notTake= subsetSumWithMemoization(arr,sum,dp,ind-1);
            boolean take = false;
            if(arr[ind-1]<=sum)
                take =subsetSumWithMemoization(arr,sum-arr[ind-1],dp,ind-1);

            dp[sum][ind]=notTake ||take ?1:0;
            return notTake||take;
        }

        public boolean subsetSumWithTabulation(int[] arr, int sum, int n) {
            boolean dp[][]= new boolean[n+1][sum+1];
            for(int j=0;j<sum+1;j++)
                dp[0][j]=false;
            for(int i=0;i<n;i++)
                dp[i][0]=true;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(arr[i-1]<=j)
                        dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    else
                        dp[i][j]= dp[i-1][j];
                }
            }
                return dp[n][sum];
        }

        public boolean partitionEqualSubsetSum(int[] arr, int n) {
            int sum =0;
            for(int i=0;i<n;i++)
                sum+=arr[i];
            if(sum%2==0)
                return subsetSumWithTabulation(arr,sum/2,n);
            else
                return false;
        }

        public int minimumSubSetSumDiff(int[] arr, int n) {
            int maxSum=0;
            for(int i=0;i<n;i++)
                maxSum+=arr[i];
            boolean dp[][]= new boolean[n+1][maxSum+1];
            for(int j=0;j<maxSum+1;j++)
                dp[0][j]=false;
            for(int i=0;i<n+1;i++)
                dp[i][0]=true;
            for(int i=1;i<n+1;i++){
                for(int j=0;j<maxSum+1;j++){
                    if(arr[i-1]<=j)
                        dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            ArrayList<Integer> list= new ArrayList<>();
            int min=Integer.MAX_VALUE;
            for(int j=0;j<maxSum+1/2;j++){
                if(dp[n-1][j])
                    list.add(j);
            }
            for(int x:list){
                int s2=maxSum-x;
                min=Math.min(min,Math.abs(x-s2));
            }
            return min;
        }

        public int countSubsetsWithSumk(int[] arr, int sum, int n) {
            if(sum==0)
                return 1;
            if(n==0)
                return 0;
            if(arr[n-1]<=sum)
                return countSubsetsWithSumk(arr,sum-arr[n-1],n-1) + countSubsetsWithSumk(arr,sum,n-1);
            else
                return countSubsetsWithSumk(arr,sum,n-1);
        }

        public int countSubsetsWithSumKTabulation(int[] arr, int sum, int n) {
            int dp[][]= new int[n+1][sum+1];
            for(int j=0;j<sum+1;j++)
                dp[0][j]=0;
            for(int i=0;i<n+1;i++)
                dp[i][0]=1;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(arr[i-1]<=j)
                        dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            return dp[n][sum];

        }

        public int countSubsetsWithGivenDiff(int[] arr, int diff, int n) {
            int totalSum=0;
            for(int i=0;i<n;i++)
                totalSum+=arr[i];
            int sum=(totalSum+diff)/2;
            //by recursion
//            return countSubsetsWithSumk(arr,sum,n);
            //by tabulation
            return countSubsetsWithSumKTabulation(arr,sum,n);

        }

        public int knapsackRecursive(int[] wt, int[] val, int ind, int W) {
            if(ind==0){
                if(wt[ind]<=W)return val[ind];
                return 0;
            }
            int notTake=0+knapsackRecursive(wt,val,ind-1,W);
            int take=Integer.MIN_VALUE;
            if(wt[ind]<=W)
                take=val[ind]+knapsackRecursive(wt,val,ind-1,W-wt[ind]);
            return Math.max(notTake,take);
        }


        //Passing n as n-1, so we
        public int knapsackRecursiveWithMemoization(int[] wt, int[] val, int ind, int W, int[][] dp) {
            if(ind==0){
                if(wt[ind]<=W) return val[ind];
                return 0;
            }
            if(dp[ind][W]!=-1)
                return dp[ind][W];
            int notTake=knapsackRecursiveWithMemoization(wt,val,ind-1,W,dp);
            int take=Integer.MIN_VALUE;
            if(wt[ind]<=W)
                take=val[ind]+knapsackRecursiveWithMemoization(wt, val, ind-1, W-wt[ind], dp);
            return dp[ind][W]=Math.max(take,notTake);

        }

        public int knapsackTabulation(int[] wt, int[] val, int maxWeight, int n) {
            int dp[][]= new int[n][maxWeight+1];
            for(int i=wt[0];i<=maxWeight;i++)
                dp[0][i]=val[0];

            for(int ind=1;ind<n;ind++){
                for(int W=0;W<=maxWeight;W++){
                    int notTake=dp[ind-1][W];
                    int take=Integer.MIN_VALUE;
                    if(wt[ind]<=W)
                        take=val[ind]+dp[ind-1][W-wt[ind]];
                    dp[ind][W]=Math.max(take,notTake);
                }
            }
            return dp[n-1][maxWeight];
        }

        public int minimumCoinsRecursive(int[] coins, int ind, int target) {
            if(ind==0){
                if(target%coins[ind]==0) return target/coins[ind];
                else return (int) 1e9;
            }
            int notTake= 0+minimumCoinsRecursive(coins,ind-1,target);//0 coins included
            int take= (int) 1e9;
            if(coins[ind]<=target)
                take=1+minimumCoinsRecursive(coins,ind,target-coins[ind]);
            return Math.min(take,notTake);
        }

        public int minimumCoinsRecursiveWithMemoization(int[] coins, int ind, int target, int[][] dp) {
            if(ind==0){
                if(target%coins[ind]==0) return target/coins[ind];
                else return (int) 1e9;
            }
            if(dp[ind][target]!=-1)
                return dp[ind][target];
            int notTake= minimumCoinsRecursiveWithMemoization(coins,ind-1,target,dp);
            int take= (int) 1e9;
            if(coins[ind]<=target)
                take=1+minimumCoinsRecursiveWithMemoization(coins,ind,target-coins[ind],dp);

            return dp[ind][target]=Math.min(take,notTake);
        }

        public int minimumCoinsTabulation(int[] coins, int n, int target) {
            int dp[][]= new int[n][target+1];
            for(int T=0;T<=target;T++){
                if(T%coins[0]==0)
                    dp[0][T]=T/coins[0];
                else
                    dp[0][T]= (int) 1e9;
            }
            for(int ind=1;ind<n;ind++){
                for(int T=0;T<=target;T++){
                    int notTake=dp[ind-1][T];
                    int take= (int) 1e9;
                    if(coins[ind]<=T)
                        take=1+dp[ind][T-coins[ind]];

                    dp[ind][T]=Math.min(take,notTake);
                }
            }
            return dp[n-1][target];
        }

        public int targetSum(int[] arr, int sum, int n) {
            int diff=sum;
            return countNumberOfSubsetSumWithGivenDiff(arr,diff,n);
        }

        private int countNumberOfSubsetSumWithGivenDiff(int[] arr, int diff, int n) {
            int sum=0;
            for(int i=0;i<=n;i++)
                sum+=arr[i];

            sum=(diff+sum)/2;
           return  countOfSubsetSumWithGivenSumForThisMethod(arr,sum,n);
        }

        private int countOfSubsetSumWithGivenSumForThisMethod(int[] arr, int target, int ind) {
            if(target==0)
                return 1;
            if(ind==0){
                if(arr[ind]==target) return 1;
                else return 0;
            }
            int notTake=countOfSubsetSumWithGivenSumForThisMethod(arr,target,ind-1);
            int take=0;
            if(arr[ind]<=target)
                take=countOfSubsetSumWithGivenSumForThisMethod(arr,target-arr[ind],ind-1);
            return take+notTake;
        }

        public int numberOfWaysToTakeCoin(int[] arr, int ind, int target) {
            if(ind==0)
                return target%arr[ind]==0 ? 1:0;
            int notTake=numberOfWaysToTakeCoin(arr,ind-1,target);
            int take=0;
            if(arr[ind]<=target)
                take=numberOfWaysToTakeCoin(arr,ind,target-arr[ind]);
            return take+notTake;

        }

        public int numberOfWaysToTakeCoinWithMemoization(int[] arr, int ind, int T, int[][] dp) {
            if(ind==0)
                return T%arr[0]==0? 1:0;
            if(dp[ind][T]!=-1)
                return dp[ind][T];
            int notTake=numberOfWaysToTakeCoinWithMemoization(arr,ind-1,T,dp);
            int take=0;
            if(arr[ind]<=T)
                take=numberOfWaysToTakeCoinWithMemoization(arr,ind,T-arr[ind],dp);
            return dp[ind][T]=take+notTake;
        }

        public int numberOfWaysToTakeCoinWithTabulation(int[] arr, int n, int target) {
            int dp[][]= new int[n][target+1];
            for(int T=0;T<=target;T++)
                dp[0][T]= (T%arr[0]==0)?1:0;

            for(int ind=1;ind<n;ind++){
                for(int T=0;T<=target;T++){
                    int notTake=dp[ind-1][T];
                    int take=0;
                    if(arr[ind]<=T)
                        take=dp[ind][T-arr[ind]];
                    dp[ind][T]= take + notTake;
                }
            }
            return dp[n-1][target];
        }

        public int unboundedKnapsack( int ind, int W,int[] wt, int[] val) {
            if(ind==0)
                return (W/wt[0])*val[0];
            int notTake=0+unboundedKnapsack(ind-1,W,wt,val);
            int take=Integer.MIN_VALUE;
            if(wt[ind]<=W)
                take=val[ind]+unboundedKnapsack(ind,W-wt[ind],wt,val);
            return Math.max(take,notTake);

        }

        public int unboundedKnapsackWithMemoization(int ind, int W, int[] wt, int[] val, int[][] dp) {
            if(ind==0)
                return (W/wt[0])*val[0];
            if(dp[ind][W]!=-1)
                return dp[ind][W];
            int notTake= 0+unboundedKnapsackWithMemoization(ind-1,W,wt,val,dp);
            int take=Integer.MIN_VALUE;
            if(wt[ind]<=W)
                take=val[ind]+unboundedKnapsackWithMemoization(ind,W-wt[ind],wt,val,dp);

            return dp[ind][W]=Math.max(take,notTake);

        }

        public int unboundedKnapsackTabulation(int n, int weight, int[] wt, int[] val) {
            int dp[][]= new int[n][weight+1];
            for(int W=0;W<=weight;W++)
                dp[0][W]=((int) (W/wt[0]))*val[0]; // for index 0 base case

            for(int ind=1;ind<n;ind++){
                for(int W=0;W<=weight;W++){
                    int notTake=dp[ind-1][W];
                    int take=Integer.MIN_VALUE;
                    if(wt[ind]<=W)
                        take=val[ind]+dp[ind][W-wt[ind]];

                    dp[ind][W]=Math.max(take,notTake);
                }
            }
            return dp[n-1][weight];

        }

        public int rodCuttingProblemRecursive(int ind, int N, int[] price) {  //n=current size, N=total size required
            if(ind==0){//we have 0 based indexing sp at o we have lenght 1
                return N*price[0]; // index ==0 but we want size of 1
            }
            int notTake=0+rodCuttingProblemRecursive(ind-1,N,price);
            int take=Integer.MIN_VALUE;
            int rodLength=ind+1;
            if(rodLength<=N)
                take=price[ind]+rodCuttingProblemRecursive(ind,N-rodLength,price);
            return Math.max(take,notTake);


        }

        public int rodCuttingProblemMemoization(int ind, int N, int[] price, int[][] dp) {
            if(ind==0){
                return N*price[0];
            }
            if(dp[ind][N]!=-1)
                return dp[ind][N];
            int notTake=0+rodCuttingProblemMemoization(ind-1,N,price,dp);
            int take=Integer.MIN_VALUE;
            int rodLength=ind+1;
            if(rodLength<=N)
                take=price[ind]+rodCuttingProblemMemoization(ind,N-rodLength,price,dp);

            return dp[ind][N]=Math.max(take,notTake);

        }

        public int rodCuttingProblemTabulation(int n, int totalLength, int[] price) {
            int dp[][]= new int[n][totalLength+1];
            for(int N=0;N<=totalLength;N++)
                dp[0][N]=N*price[0];

            for(int ind=1;ind<n;ind++){
                for(int N=0;N<=totalLength;N++){
                    int notTake=0+dp[ind-1][N];
                    int take=Integer.MIN_VALUE;
                    int rodlength=ind+1;
                    if(rodlength<=N)
                        take=price[ind]+dp[ind][N-rodlength];
                    dp[ind][N]=Math.max(take,notTake);
                }
            }
            return dp[n-1][totalLength];
        }

        public int lcsRecursive(int ind1, int ind2, String x, String y) {
            if(ind1<0 || ind2<0)
                return 0;
            if(x.charAt(ind1)==y.charAt(ind2))
                return 1+lcsRecursive(ind1-1,ind2-1,x,y);
            return Math.max(lcsRecursive(ind1-1,ind2,x,y),lcsRecursive(ind1,ind2-1,x,y));
        }

        public int lcsRecursiveMemoization(int ind1, int ind2, String x, String y, int[][] dp) {
            if(ind1<0 || ind2<0)
                return 0;
            if(dp[ind1][ind2]!=-1)
                return dp[ind1][ind2];
            if(x.charAt(ind1)==y.charAt(ind2))
                return dp[ind1][ind2]= 1+lcsRecursiveMemoization(ind1-1,ind2-1,x,y,dp);
            return dp[ind1][ind2]=Math.max(lcsRecursiveMemoization(ind1-1,ind2,x,y,dp),lcsRecursiveMemoization(ind1,ind2-1,x,y,dp));

        }

        public int lcsTabulation(int n, int m, String x, String y) {
            int dp[][]= new int[n+1][m+1];// +1 because we are using 1 based indexing
            for(int ind1=0;ind1<n+1;ind1++)
                dp[ind1][0]=0;
            for(int ind2=0;ind2<m+1;ind2++)
                dp[0][ind2]=0;
            for(int ind1=1;ind1<n+1;ind1++){
                for(int ind2=1;ind2<m+1;ind2++){
                    if(x.charAt(ind1-1)==y.charAt(ind2-1))
                        dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                    else
                        dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
            return dp[n][m];
        }

        public String printLCS(int n, int m, String x, String y) {
            int dp[][]= new int[n+1][m+1];
            for(int i=0;i<n+1;i++)
                dp[i][0]=0;
            for(int j=0;j<m+1;j++)
                dp[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        dp[i][j]=1+dp[i-1][j-1];
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            StringBuilder ans= new StringBuilder();
            int i=n;
            int j=m;
            while (i>0 && j>0){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    ans.append(x.charAt(i-1));
                    i--;j--;
                }else if(x.charAt(i-1)!= y.charAt(j-1)){
                    if(dp[i][j-1]>dp[i-1][j]){
                        j--;
                    }else {
                        i--;
                    }
                }
            }
            return ans.reverse().toString();
        }

        public int longestCommonSubstringLength(int n, int m, String x, String y) {
            int dp[][]= new int[n+1][m+1];
            int maxLength=0;
            for(int i=0;i<n+1;i++)
                dp[i][0]=0;
            for(int j=0;j<m+1;j++)
                dp[0][j]=0;
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                        maxLength=Math.max(maxLength,dp[i][j]);
                    }else
                        dp[i][j]=0;  // it's not continuous here so we are making it 0
                }
            }
            return maxLength;
        }

        public int longestPalindromicSubsequence(String x, String y, int n) {
            int dp[][]= new int[n+1][n+1];
            for(int i=0;i<n+1;i++){
                dp[i][0]=0;
                dp[0][i]=0;//both row and column size are same so we can use
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        dp[i][j]=1+dp[i-1][j-1];
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            return dp[n][n];
        }

        public int minNumberOfInsertionToMakeAStringPalindrome(String x) {
            StringBuilder y= new StringBuilder(x).reverse();
            int n=x.length();
            return n-lcsTabulation(n,n,x,y.toString());
        }

        public void minNumberOfInsertionAndDelectionToConvertS1ToS2(String x, String y, int n, int m) {
            int lcs=lcsTabulation(n,m,x,y);
            int deletion=n-lcs;
            int insertion=m-lcs;
            System.out.println("number of deletion : "+ deletion);
            System.out.println("number of Insertion : "+ insertion);

        }
    }
    public static void main(String args[]){

        //frog jump
        DP d= new DP();
        int height[]={10,20,30,10};
//        int n= height.length-1;
//        System.out.println(d.frogJump(height,n));
        //frog jump by tabulation
//        int dp[]= new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println(d.frogJumpByMemoization(height,n,dp));
        //frog jump by tabulation

//        System.out.println(d.frogJumpByTabulation(height,n));

        //frog jump with K distance
//        int k=3;
//        System.out.println(d.frogJumpWithKDistance(height,n,k));
//        int dp[]= new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println(d.frogJumpWithKDistanceByMemoization(height,n,k,dp));

//        System.out.println(d.frogJumpWithKDistanceByTabulation(height,n,k));


        //maximum sum of non-adjacent element-->house robber
//        int arr[]={2,1,4,9};
//        int ind=arr.length-1;
//        System.out.println(d.houseRobber(arr,ind));
//        int dp[]= new int[n+1];
//        Arrays.fill(dp,-1);


        //house robber with memoization
//        System.out.println(d.houseRobberWithMemoization(arr,ind,dp));

        //house robber with tabulation
//        System.out.println(d.houseRobberWithTabulation(arr,arr.length));

        //house robber with tabulation+Space Optimization
//        System.out.println(d.houseRobberWithTabulationAndSpaceOptimization(arr,arr.length));

        //ninja's Training
        int task[][]={{1,2,3},{3,1,1},{3,3,5}};
        int day=task.length;
        int last=3;
////        System.out.println(d.ninjasTraining(task,day-1,last));
//
//        //ninja's training
//        int dp[][]=new int[n][4];
//        for(int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        System.out.println(d.ninjasTrainingWithMemoization(task,day-1,last,dp));

//        System.out.println(d.ninjasTrainingWithTabulation(task,day));
//       int n=2;
//        System.out.println(d.countVowelStrings(n));

        //total Unique Paths--tabulation
//        int n=3;
//        int m=7;
//        System.out.println(d.totalUniquePaths(n,m));

        //total Unique Paths with Obstacles

//        int path[][]={{0,0,0,0,-1,0,0},{0,0,0,0,0,-1,0},{-1,0,0,-1,0,0,0}};
//        System.out.println(d.totalUniquePathsWithObstacles(path,n-1,m-1));

        //Min Path sum recursive
//        int grid[][]={{1,2,3},{4,5,4},{7,5,9}};
//        System.out.println(d.minPathSumRecursive(grid));

        //Min Path sum memoization
//        System.out.println(d.minPathSumRecursiveWithMemoization(grid));

        //Min Path sum tabulation
//        System.out.println(d.minPathSumTabulation(grid));

        //minimum pathSum of Triangular Arraylist( recursive and memoization)

//        int grid[][]={{1},{2, 3},{15, 6, 7},{8,9,6,10}};
//        int n=4;
//        System.out.println(d.minPathSumOfTriangularArraylist(grid,n));

        //minimum pathSum of Triangular Arraylist tabulation
//        System.out.println(d.minPathSumOfTriangularArraylistWithTabulation(grid,n));


        //maximum path sum in the matrix where path can start from any cell of first row and end at any cell of last row
//        int grid[][]={{1, 2, 10, 4},{100, 3, 2, 1},{1, 1, 20, 2},{1, 2, 2, 1}};
//        int n=4;
//        int m=4;
//        System.out.println(d.maxPathSumInMatrix(grid,n,m)); // recursion and memoization
//        System.out.println(d.maxPathSumInMatrixWithTabulation(grid,n,m));


        //Question -13--Ninja And His friends
//        int grid[][]={{2,3,1,2},{3,4,2,2},{5,6,3,5}};
//        int n=3;
//        int m=4;
//        System.out.println(d.maxChocolatesCollectedByAliceAndBob(grid,n,m));


        //Subsequences/Subset

        //Subset Sum Equals to Target
//        int arr[]={1,2,3,4};
//        int k=6;

        //recursive
//        System.out.println(d.subsetSum(arr,arr.length,k));

        //recursive+Memoization
//        int [][]dp = new int[k+1][arr.length+1];
//        for(int i=0;i<k+1;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.subsetSumWithMemoization(arr,k,dp,arr.length));

        //Subset Sum Equals to Target+tabulation
//        System.out.println(d.subsetSumWithTabulation(arr,k,arr.length));


        //Partition Equal Subset Sum
//        int arr[]={2,3,3,3,4,5};
//        System.out.println(d.partitionEqualSubsetSum(arr,arr.length));

        //Partition a set into two subset such that the difference of subsetSums is minimum
//        int arr[]={2,2,5,4};
//        System.out.println(d.minimumSubSetSumDiff(arr,arr.length));

        //count subsets with sum k
//         int arr[]= {1,2,2,3};
//         int sum=3;
//        System.out.println(d.countSubsetsWithSumk(arr,sum,arr.length));
//        System.out.println(d.countSubsetsWithSumKTabulation(arr,sum,arr.length));

        //count Partitions/subsets with given diff

//        int arr[]={5,2,6,4};
//        int diff=3;  //OP-1
//        int arr[]={1, 1, 1, 1};
//        int diff=0;
//        System.out.println(d.countSubsetsWithGivenDiff(arr,diff,arr.length));


        //  0/1 knapsack
//        int wt[]={3,2,5};
//        int val[]={30,40,60};
//        int W=6;

//        System.out.println(d.knapsackRecursive(wt,val,wt.length-1,W));

        //0/1 Knapsack Memoization
//        int n=wt.length;
//        int dp[][]= new int[n+1][W+1];
//        for(int i=0;i<n+1;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.knapsackRecursiveWithMemoization(wt,val,n-1,W,dp));

        //Knapsack tabulation
//        System.out.println(d.knapsackTabulation(wt,val,W,n));

        //Minimum Coins--Infinite supply problem
//        int coins[]={1,2,3};
//        int n=coins.length;
//        int target=7;
        //recursive
//        System.out.println(d.minimumCoinsRecursive(coins,n-1,target));

        //recursive+Memoization
//        int dp[][]= new int[n][target+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.minimumCoinsRecursiveWithMemoization(coins,n-1,target,dp));

        //tabulation
//        System.out.println(d.minimumCoinsTabulation(coins,n,target));

        // target sum
//        int arr[]={1,1,2,3};
//        int sum=1;
//        int n=arr.length;
//        System.out.println(d.targetSum(arr,sum,n-1));


        //coin change 2----Infinite supply problem
//        int arr[]={1,2,3};
//        int target=4;
//        int n=arr.length;
//        System.out.println(d.numberOfWaysToTakeCoin(arr,n-1,target));
//        int dp[][]= new int[n][target+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.numberOfWaysToTakeCoinWithMemoization(arr,n-1,target,dp));

//        System.out.println(d.numberOfWaysToTakeCoinWithTabulation(arr,n,target));


        //Unbounded Knapsack------Infinite supply

//        int wt[]={2,4,6};
//        int val[]={5,11,13};
//        int W=10;
//        int n=wt.length;

        //recursive
//        System.out.println(d.unboundedKnapsack(n-1,W,wt,val));

        //recursive+memoization
//        int dp[][]= new int[n][W+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.unboundedKnapsackWithMemoization(n-1,W,wt,val,dp));

//        System.out.println(d.unboundedKnapsackTabulation(n,W,wt,val));

        //rod cutting problem
//        int price[]={2,5,7,8,10};
//        int N=5;
//        int n=price.length;

//        int price[]={3, 5, 8, 9, 10, 17, 17, 20};
//        int N=8;
//        int n=price.length;
//        System.out.println(d.rodCuttingProblemRecursive(n-1,N,price));

//        int dp[][]= new int[n][N+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.rodCuttingProblemMemoization(n-1,N,price,dp));

//        System.out.println(d.rodCuttingProblemTabulation(n,N,price));


        //Longest Common Subsequence

//        String x="abcdeaf";
//        String y="acbcf";
//        int n=x.length();
//        int m=y.length();
//        System.out.println(d.lcsRecursive(n-1,m-1,x,y));

//        int dp[][]=new int[n][m];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.lcsRecursiveMemoization(n-1,m-1,x,y,dp));

//        System.out.println(d.lcsTabulation(n,m,x,y));

        //print longest common subsequence
//        System.out.println(d.printLCS(n,m,x,y));

        //length of longest common substring
//        System.out.println(d.longestCommonSubstringLength(n,m,x,y));

        //longest Palindromic subsequence
//        String x="bbbab";
//        StringBuilder y= new StringBuilder(x).reverse();
//        int n=x.length();
//        System.out.println(d.longestPalindromicSubsequence(x,y.toString(),n));

        // Min number of insertion to make a string palindrome == Min number od deletion to make a string palindrome
        //both problem are same

//        String x="aebcbda";
//
//        System.out.println(d.minNumberOfInsertionToMakeAStringPalindrome(x));


        //min number of insertion and deletion to convert string s1 to s2

        String x="heap";
        String y="pea";

       d.minNumberOfInsertionAndDelectionToConvertS1ToS2(x,y,x.length(),y.length());



































    }


}
