import java.util.*;

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

        public void minNumberOfInsertionAndDeletionToConvertS1ToS2(String x, String y, int n, int m) {
            int lcs=lcsTabulation(n,m,x,y);
            int deletion=n-lcs;
            int insertion=m-lcs;
            System.out.println("number of deletion : "+ deletion);
            System.out.println("number of Insertion : "+ insertion);

        }

        public int shortestCommonSuperSequence(String x, String y) {
            int n=x.length();
            int m=y.length();
            int lcs=lcsTabulationForThisMethod(x,y,n,m);
            return n+m-lcs;
        }

        private int lcsTabulationForThisMethod(String x, String y, int n, int m) {
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
            return dp[n][m];
        }
        public String printShortestCommonSuperSequence(String x, String y, int n, int m) {
            int dp[][]= new int[n+1][m+1];

            //tabulation for lcs
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
            StringBuilder s= new StringBuilder();
            int i=n;
            int j=m;
            while(i>0 && j>0){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    s.append(x.charAt(i-1));
                    --i;
                    --j;
                } else if (dp[i][j-1]>dp[i-1][j]) {
                    s.append(y.charAt(j-1));
                    --j;
                }else {
                    s.append(x.charAt(i-1));
                    --i;
                }
            }
            while(i>0){
                s.append(x.charAt(i-1));
                --i;
            }
            while (j>0){
                s.append(y.charAt(j-1));
                --j;
            }
            s.reverse();
            return s.toString();
        }

        public int distinctSubsequences(String x, String y, int i, int j) {//i---n & j==m  here j is substring
            if(j<0)
                return 1;
            if(i<0)
                return 0;
            if(x.charAt(i)==y.charAt(j))
                return distinctSubsequences(x,y,i-1,j-1)+distinctSubsequences(x,y,i-1,j);
            else
                return distinctSubsequences(x,y,i-1,j);
        }

        public int distinctSubsequencesWithMemoization(String x, String y, int i, int j, int[][] dp) {
            if(j<0)
                return 1;
            if(i<0)
                return 0;
            if(dp[i][j]!=-1)
                return dp[i][j];
            if(x.charAt(i)==y.charAt(j))
                return dp[i][j] = distinctSubsequencesWithMemoization(x,y,i-1,j-1,dp)+distinctSubsequencesWithMemoization(x,y,i-1,j,dp);
            else
                return dp[i][j] = distinctSubsequencesWithMemoization(x,y,i-1,j,dp);
        }

        public int distinctSubsequencesTabulation(String x, String y, int n, int m) {
            int dp[][]= new int[n+1][m+1];

            for(int j=0;j<m+1;j++)
                dp[0][j]=0;
            for(int i=0;i<n+1;i++)
                dp[i][0]=1;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            return dp[n][m];

        }

        public int editDistanceRecursive(int i, int j, String x, String y) {
            if(i<0)
                return j+1;
            if(j<0)
                return i+1;
            if(x.charAt(i)==y.charAt(j))
                return 0+ editDistanceRecursive(i-1,j-1,x,y);
            else {
                return Math.min(
                        1+editDistanceRecursive(i,j-1,x,y),
                        Math.min
                                (1+editDistanceRecursive(i-1,j,x,y),
                                        1+editDistanceRecursive(i-1,j-1,x,y)));
            }
        }

        public int editDistanceMemoization(int i, int j, String x, String y, int[][] dp) {
            if(i<0)
                return j+1;
            if(j<0)
                return i+1;
            if(dp[i][j]!=-1)
                return dp[i][j];
            if(x.charAt(i)==y.charAt(j))
                return dp[i][j]=editDistanceMemoization(i-1,j-1,x,y,dp);
            return dp[i][j]=Math.min(1+editDistanceMemoization(i,j-1,x,y,dp),Math.min(1+editDistanceMemoization(i-1,j,x,y,dp),1+editDistanceMemoization(i-1,j-1,x,y,dp)));
        }

        public int editDistanceTabulation(String x, String y, int n, int m) {
            int dp[][]= new int[n+1][m+1];

            for(int i=0;i<n+1;i++)
                dp[i][0]=i;
            for(int j=0;j<m+1;j++)
                dp[0][j]=j;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1))
                        dp[i][j]=0+dp[i-1][j-1];
                    else
                        dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
            return dp[n][m];
        }

        public boolean wildCardMatching(int i, int j, String x, String y) {
            if(i<0 && j<0) return true;
            if(i<0 && j>=0) return false;
            if(j<0 && i>=0){
                for(int t=0;t<=i;t++){
                    if(x.charAt(t)!='*')
                        return false;
                }
                return true;
            }
            if(x.charAt(i)==y.charAt(j) || x.charAt(i)=='?')
                return wildCardMatching(i-1,j-1,x,y);
            if(x.charAt(i)=='*')
                return wildCardMatching(i-1,j,x,y) || wildCardMatching(i,j-1,x,y);

            return false;// if both characters are not matcing
        }

        public boolean wildCardMatchingMemoization(int i, int j, String x, String y, boolean[][] dp) {
            if(i<0 && j<0) return true;
            if(i<0 && j>=0 ) return  false;
            if(j<0 && i>=0){
                for(int t=0;t<=i;t++){
                    if(x.charAt(t)!='*')
                        return false;
                }
                return true;
            }
            if(dp[i][j])
                return true;
            if(x.charAt(i)==y.charAt(j) || x.charAt(i)=='?')
                 return dp[i][j]=wildCardMatchingMemoization(i-1,j-1,x,y,dp);
            if(x.charAt(i)=='*')
                return dp[i][j]=(wildCardMatchingMemoization(i-1,j,x,y,dp) || wildCardMatchingMemoization(i,j-1,x,y,dp));
            return dp[i][j]=false;
        }

        public boolean wildCardMatchingTabulation(String x, String y, int n, int m) {
            boolean dp[][]= new boolean[n+1][m+1];
            dp[0][0]=true;
            for(int j=1;j<=m;j++)
                dp[0][j]=false;
            for(int i=1;i<=n;i++){
                boolean flag=true;
                for(int ii=1;ii<=i;ii++){
                    if(x.charAt(i-1)!='*'){
                        flag=false;
                        break;
                    }
                    dp[i][0]=flag;
                }
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(x.charAt(i-1)==y.charAt(j-1) || x.charAt(i-1)=='?')
                        dp[i][j]=dp[i-1][j-1];
                    else if(x.charAt(i-1)=='*')
                        dp[i][j]=(dp[i-1][j] || dp[i][j-1]);
                    else
                        dp[i][j]=false;
                }
            }
            return dp[n][m];
        }

        public int bestTimeToBuyAndSellStock(int[] arr) {
            int mini=arr[0];
            int profit=0;
            int cost=0;//if we sell and buy at same day than cost will be zero;
            for(int i=1;i<arr.length;i++){
                cost = arr[i]-mini;
                profit=Math.max(profit,cost);
                mini=Math.min(mini,arr[i]);
            }
            return profit;
        }



        public int maximumProfitByBuyingAndSellingStocks(int ind, int buy, int[] price) {
            if(ind==price.length)
                return 0;
            if(buy==1){
                return Math.max(-price[ind]+maximumProfitByBuyingAndSellingStocks(ind+1,0,price),
                        0+maximumProfitByBuyingAndSellingStocks(ind+1,1,price));
            }else {
                return Math.max(price[ind]+maximumProfitByBuyingAndSellingStocks(ind+1,1,price),
                        0+maximumProfitByBuyingAndSellingStocks(ind+1,0,price));
            }
        }

        public int maximumProfitByBSByMemoization(int ind, int buy, int[] price, int n, int[][] dp) {
            if(ind==n)
                return 0;
            if(dp[ind][buy]!=-1)
                return dp[ind][buy];
            if(buy==1){
                return dp[ind][buy]=Math.max(-price[ind]+maximumProfitByBSByMemoization(ind+1,0,price, n, dp),
                        0+maximumProfitByBSByMemoization(ind+1,1,price, n, dp));
            }else
                return dp[ind][buy]=Math.max(price[ind]+maximumProfitByBSByMemoization(ind+1,1,price, n, dp),
                        maximumProfitByBSByMemoization(ind+1,0,price, n, dp));
        }

        public int maximumProfitByBSByTabulation(int[] price, int n) {
            int dp[][]= new int[n+1][2];

            dp[n][0]=dp[n][1]=0;
            for(int ind=n-1;ind>=0;ind--){
                for(int buy=0;buy<=1;buy++){
                    if(buy==1)
                        dp[ind][buy]=Math.max(-price[ind]+dp[ind+1][0],0+dp[ind+1][1]);
                    else
                        dp[ind][buy]=Math.max(+price[ind]+dp[ind+1][1],dp[ind+1][0]);
                }
            }
            return dp[0][1];
        }

        public int maxProfitInTwoTransections(int ind, int buy, int cap, int[] price, int n) {
            if(cap==0) return 0;//already completed all transaction
            if(ind==n) return 0;
            if(buy==1){
                return Math.max(-price[ind]+maxProfitInTwoTransections(ind+1,0,cap,price, n),
                        0+maxProfitInTwoTransections(ind+1,1,cap,price, n));
            }else {
                return Math.max(price[ind]+maxProfitInTwoTransections(ind+1,1,cap-1,price, n),
                        maxProfitInTwoTransections(ind+1,0,cap,price, n));
            }
        }

        public int maxProfitInTwoTransactionsMemoiz(int ind, int buy, int cap, int n, int[] price, int[][][] dp) {
            if(cap==0)
                return 0;
            if(ind==n)
                return 0;
            if(dp[ind][buy][cap]!=-1)
                return dp[ind][buy][cap];
            if(buy==1){
                return dp[ind][buy][cap]=Math.max(-price[ind]+maxProfitInTwoTransactionsMemoiz(ind+1,0,cap,n,price,dp),
                        maxProfitInTwoTransactionsMemoiz(ind+1,1,cap,n,price,dp));
            }else {
                return dp[ind][buy][cap]=Math.max(price[ind]+maxProfitInTwoTransactionsMemoiz(ind+1,1,cap-1,n,price,dp),
                        maxProfitInTwoTransactionsMemoiz(ind+1,0,cap,n,price,dp));

            }
        }

        public int maxProfitInTwoTransactionsTabulation(int cap, int n, int[] price) {
            int dp[][][]= new int[n+1][2][cap+1];

            // no need to write base case it's already assigned as 0 by default
//            for(int ind=0;ind<n+1;ind++){
//                for(int buy=0;buy<2;buy++ ){
//                    dp[ind][buy][0]=0;
//                }
//            }
//            for(int buy=0;buy<2;buy++){
//                for(cap=0;cap<3;cap++){
//                    dp[n][buy][cap]=0;
//                }
//            }
            for(int ind=n-1;ind>=0;--ind){
                for(int buy=0;buy<2;buy++){
                    for(cap=1;cap<=2;cap++){//we can directly start computing from 0, kyuki we for cap ==0 we have ans as 0 only
                        if(buy==1){
                            dp[ind][buy][cap]=Math.max(-price[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                        }else {
                            dp[ind][buy][cap]=Math.max(price[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                        }
                    }
                }
            }
            return dp[0][1][2];
        }

        public int maxProfitByKTransaction(int ind, int transNum, int k, int n, int[] price) {
            if(ind==n || transNum==2*k)
                return 0;
            if(transNum%2==0){
                return Math.max(-price[ind]+maxProfitByKTransaction(ind+1,transNum+1,k,n,price),
                        maxProfitByKTransaction(ind+1,transNum,k,n,price));
            }else {
                return Math.max(price[ind]+maxProfitByKTransaction(ind+1,transNum+1,k,n,price),
                        maxProfitByKTransaction(ind+1,transNum,k,n,price));
            }
        }

        public int maxProfitByKTransactionMemoiz(int ind, int transNum, int k, int n, int[] price, int[][] dp) {
            if(ind==n || transNum==2*k)
                return 0;
            if(dp[ind][transNum]!=-1)
                return dp[ind][transNum];
            if(transNum%2==0){
                return dp[ind][transNum]=Math.max(-price[ind]+maxProfitByKTransactionMemoiz(ind+1,transNum+1,k,n,price,dp),
                        maxProfitByKTransactionMemoiz(ind+1,transNum,k,n,price,dp));
            }else {
                return  dp[ind][transNum]=Math.max(price[ind]+maxProfitByKTransactionMemoiz(ind+1,transNum+1,k,n,price,dp),
                        maxProfitByKTransactionMemoiz(ind+1,transNum,k,n,price,dp));
            }
        }

        public int maxProfitByKTransactionTabulation(int[] price, int k, int n) {
            int dp[][]= new int[n+1][2*k+1];

            //Base case-- no need to write base case because we will initialize by 0 where ind==n or transNo==2k

            for(int ind=n-1;ind>=0;ind--){
                for(int transNo=(2*k)-1;transNo>=0;transNo--){
                    if(transNo%2==0){
                        dp[ind][transNo]=Math.max(-price[ind]+dp[ind+1][transNo+1],dp[ind+1][transNo]);
                    }else {
                        dp[ind][transNo]=Math.max(price[ind]+dp[ind+1][transNo+1],dp[ind+1][transNo]);
                    }
                }
            }
            return dp[0][0];
        }

        public int maxProfitByCoolDown(int ind, int buy, int n, int[] price) {
            if(ind>=n) return 0;
            if(buy==1){
                return Math.max(-price[ind]+maxProfitByCoolDown(ind+1,0,n,price),
                        maxProfitByCoolDown(ind+1,1,n,price));
            }else
                return Math.max(price[ind]+maxProfitByCoolDown(ind+2,1,n,price),
                        maxProfitByCoolDown(ind+1,0,n,price));
        }

        public int maxProfitByCoolDownMemoiz(int ind, int buy, int n, int[] price, int[][] dp) {
            if(ind>=n) return 0;
            if(dp[ind][buy]!=-1)
                return dp[ind][buy];
            if(buy==1){
                return dp[ind][buy]=Math.max(-price[ind]+maxProfitByCoolDownMemoiz(ind+1,0,n,price,dp),
                        maxProfitByCoolDownMemoiz(ind+1,1,n,price,dp));
            }else
                return dp[ind][buy]=Math.max(price[ind]+maxProfitByCoolDownMemoiz(ind+2,1,n,price,dp),
                        maxProfitByCoolDownMemoiz(ind+1,0,n,price,dp));
        }

        public int maxProfitByCoolDownTabulation(int[] price, int n) {
            int dp[][]= new int[n+2][2];
            //BASE CASE:- no need to write base case because everything already initialized with 0 in grid
            for(int ind=n-1;ind>=0;ind--){
                for(int buy=0;buy<=1;buy++){
                    if(buy==1){
                        dp[ind][buy]=Math.max(-price[ind]+dp[ind+1][0],dp[ind+1][1]);
                    }else
                        dp[ind][buy]=Math.max(price[ind]+dp[ind+2][1],dp[ind+1][0]);
                }
            }
            return dp[0][1];

        }

        public int maxProfitByBuyAndSellWithTransactionFee(int ind, int buy, int n, int fee, int[] price) {
            if(ind==n)return 0;
            if(buy==1){
                return Math.max(-price[ind]+maxProfitByBuyAndSellWithTransactionFee(ind+1,0,n,fee,price),
                        maxProfitByBuyAndSellWithTransactionFee(ind+1,1,n,fee,price));
            }else {
                return Math.max(price[ind]-fee+maxProfitByBuyAndSellWithTransactionFee(ind+1,1,n,fee,price),
                        maxProfitByBuyAndSellWithTransactionFee(ind+1,0,n,fee,price));
            }
        }

        public int maxProfitByBuyAndSellWithTransactionFeeMemoization(int ind, int buy, int n, int fee, int[] price, int[][] dp) {
            if(ind==n) return 0;
            if(dp[ind][buy]!=-1)
                return dp[ind][buy];
            if(buy==1){
                return dp[ind][buy]=Math.max(-price[ind]+maxProfitByBuyAndSellWithTransactionFeeMemoization(ind+1,0,n,fee,price,dp),
                        maxProfitByBuyAndSellWithTransactionFeeMemoization(ind+1,1,n,fee,price,dp));
            }else {
                return dp[ind][buy]=Math.max(price[ind]-fee+maxProfitByBuyAndSellWithTransactionFeeMemoization(ind+1,1,n,fee,price,dp),
                        maxProfitByBuyAndSellWithTransactionFeeMemoization(ind+1,0,n,fee,price,dp));
            }
        }

        public int maxProfitByBuyAndSellWithTransactionFeeTabulation(int[] price, int n, int fee) {
            int dp[][]= new int[n+1][2];
            dp[n][0]=dp[n][1]=0;
            for(int ind=n-1;ind>=0;ind--){
                for(int buy=0;buy<=1;buy++){
                    if(buy==1){
                        dp[ind][buy]=Math.max(-price[ind]+dp[ind+1][0],dp[ind+1][1]);
                    }else {
                        dp[ind][buy]=Math.max(price[ind]-fee+dp[ind+1][1],dp[ind+1][0]);
                    }
                }
            }
            return dp[0][1];
        }

        public int longestIncreasingSubsequence(int ind, int prevInd, int n, int[] arr) {
            if(ind==n)
                return 0;
            int notTakeLen=0+longestIncreasingSubsequence(ind+1,prevInd,n,arr);
            int takeLength=0;
            if(prevInd==-1 || arr[ind]>arr[prevInd]){
                takeLength=1+longestIncreasingSubsequence(ind+1,ind,n,arr);
            }
            return Math.max(notTakeLen,takeLength);
        }

        public int longestIncreasingSubsequenceMemoiz(int ind, int prevInd, int n, int[] arr, int[][] dp) {
            if(ind==n) return 0;
            if(dp[ind][prevInd+1]!=-1)
                return dp[ind][prevInd+1];
            int len= 0+longestIncreasingSubsequenceMemoiz(ind+1,prevInd,n,arr,dp);
            if(prevInd==-1 || arr[ind]>arr[prevInd]){
                len=Math.max(len,1+longestIncreasingSubsequenceMemoiz(ind+1,ind,n,arr,dp));
            }
            return dp[ind][prevInd+1]=len;
        }

        public int longestIncreasingSubsequenceTabulation(int[] arr, int n) {
            int dp[][]= new int[n+1][n+1];

            for(int ind=n-1;ind>=0;ind--){
                for(int prevInd=ind-1;prevInd>=-1;prevInd--){
                    int len=dp[ind+1][prevInd+1];
                    if(prevInd==-1 || arr[ind]>arr[prevInd]){
                        len=Math.max(len,1+dp[ind+1][ind+1]);
                    }
                    dp[ind][prevInd+1]=len;
                }
            }
            return dp[0][-1+1];
        }

        public int LISubsequence(int[] arr, int n) {
            int maxi=1;
            int dp[]= new int[n];
            Arrays.fill(dp,1);
            for(int curr=0;curr<n;curr++){
                for(int prev=0;prev<curr;prev++){
                    if(arr[curr]<arr[prev]){
                        dp[curr]=Math.max(dp[curr],dp[prev]+1);
                    }
                }
                maxi=Math.max(maxi,dp[curr]);
            }
            return maxi;
        }

        public List<Integer> printLISequence(int[] arr, int n) {
            int dp[]= new int[n];
            Arrays.fill(dp,1);
            int hash[]= new int[n];
            int maxi=1;
            int lastIndex=-0;
            for(int i=0;i<n;i++){
                hash[i]=i;
                for(int prev=0;prev<i;prev++){
                    if(arr[i]>arr[prev] && dp[prev]+1>dp[i]){
                        dp[i]=dp[prev]+1;
                        hash[i]=prev;
                    }
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                    lastIndex=i;
                }
            }
            List<Integer> lis= new ArrayList<>();
            lis.add(arr[lastIndex]);
            while (lastIndex!=hash[lastIndex]){
                lastIndex=hash[lastIndex];
                lis.add(arr[lastIndex]);
            }
            Collections.reverse(lis);
            return lis;
        }

        public int LISUsingBinarySearch(int[] arr, int n) {
            ArrayList<Integer> temp= new ArrayList<>();
            temp.add(arr[0]);
            int len=1;
            for(int i=1;i<n;i++){
                if(arr[i]>temp.get(temp.size()-1)){
                    temp.add(arr[i]);
                    len++;
                }else {
                    int ind= Collections.binarySearch(temp,arr[i]);
                    if(ind<0){
                        ind=-ind-1;
                    }
                    temp.set(ind,arr[i]);
                }
            }
            return len;
        }

        public ArrayList<Integer> longestDivisibleSubset(int[] arr, int n) {
            Arrays.sort(arr);
            int dp[]= new int[n];
            int hash[]= new int[n];
            int maxi=1;
            int lastIndex=0;

            for(int curr=0;curr<n;curr++){
                hash[curr]=curr;
                for(int prev=0;prev<curr;prev++){
                    if(arr[curr]%arr[prev]==0 && dp[prev]+1>dp[curr]){
                        dp[curr]=dp[prev]+1;
                        hash[curr]=prev;
                    }
                }
                if(dp[curr]>maxi){
                    maxi=dp[curr];
                    lastIndex=curr;
                }
            }
            ArrayList<Integer> res= new ArrayList<>();
            res.add(arr[lastIndex]);
            while (lastIndex!= hash[lastIndex]){
                lastIndex=hash[lastIndex];
                res.add(arr[lastIndex]);
            }
            Collections.reverse(res);
            return res;
        }

        public int longestStringChain(String[] arr, int n) {
            int dp[]= new int[n];
            Arrays.fill(dp,1);
            int maxi=1;
            Arrays.sort(arr,(s1,s2)->Integer.compare(s1.length(),s2.length()));

            for(int curr=0;curr<n;curr++){
                for(int prev=0;prev<curr;prev++){
                    if(compareCurrAndPreviousString(arr[curr],arr[prev]) && dp[curr]<dp[prev]+1){
                        dp[curr]=dp[prev]+1;
                    }
                }
                if(maxi<dp[curr]){
                    maxi=dp[curr];
                }
            }
            return maxi;
        }

        private boolean compareCurrAndPreviousString(String s1, String s2) {
            if(s1.length() != s2.length()+1) return false;
            int first=0;
            int second=0;
            while(first<s1.length()){
                if(second<s2.length() && s1.charAt(first)==s2.charAt(second)){
                    first++;
                    second++;
                }else {
                    first++;
                }
            }
            return first==s1.length() && second==s2.length();
        }

        public int longestBitonicSubsequence(int[] arr, int n) {
            int dp1[]= new int[n];
            int dp2[]= new int[n];
            //LIS from starting on array
            for(int curr=0;curr<n;curr++){
                dp1[curr]=1;
                for(int prev=0;prev<curr;prev++){
                    if(arr[curr]>arr[prev] && dp1[curr]<dp1[prev]+1){
                        dp1[curr]= dp1[prev]+1;
                    }
                }
            }

            //LIS from end of array
            for(int curr=n-1;curr>=0;curr--){
                dp2[curr]=1;
                for(int prev=n-1;prev>curr;prev--){
                    if(arr[curr]>arr[prev] && dp2[curr]<dp2[prev]+1){
                        dp2[curr]=dp2[prev]+1;
                    }
                }
            }
            int maxi=1;
            //calculate Max bitonic array length
            for(int i=0;i<n;i++){
                maxi=Math.max(maxi,(dp1[i]+dp2[i])-1);
            }
            return maxi;


        }

        public int numberOfLIS(int[] arr, int n) {
            int dp[]= new int[n];
            int count[]= new int[n];
            int maxi=1;
            for(int curr=0;curr<n;curr++){
                dp[curr]=1;
                count[curr]=1;
                for(int prev=0;prev<curr;prev++){
                    if(arr[curr]>arr[prev] && dp[curr]<1+dp[prev]){
                        dp[curr]=1+dp[prev];
                        count[curr]=count[prev];
                    } else if (arr[curr]>arr[prev] && dp[curr] == 1+dp[prev]) {
                        count[curr]+=count[prev];
                    }
                }
                if(dp[curr]>maxi)
                    maxi=dp[curr];
            }
            int numberOfLIS=0;
            for(int i=0;i<n;i++){
                if(dp[i]==maxi)
                    numberOfLIS+=count[i];
            }
            return numberOfLIS;

        }

        public int matrixChainMultiplication(int[] arr, int n) {
            int i=1;
            int j=n-1;

            //recursive
//            return mcmRecursive(i,j,arr);


            //Memoization
            int dp[][]= new int[n][n];
            for(int l=0;l<n;l++)
                Arrays.fill(dp[l],-1);

            return mcmMemoization(i,j,arr,dp);
        }

        private int mcmMemoization(int i, int j, int[] arr, int[][] dp) {
            if(i==j) return 0;
            if(dp[i][j] !=-1)
                return dp[i][j];
            int minSteps=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int steps=arr[i-1]*arr[k]*arr[j]+mcmMemoization(i,k,arr,dp)+mcmMemoization(k+1,j,arr,dp);
                minSteps=Math.min(minSteps,steps);
            }
            return dp[i][j]=minSteps;
        }

        private int mcmRecursive(int i, int j, int[] arr) {
            if(i==j) return 0;
            int minSteps=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int steps=arr[i-1]*arr[k]*arr[j]+mcmRecursive(i,k,arr)+mcmRecursive(k+1,j,arr);
                minSteps=Math.min(minSteps,steps);
            }
            return minSteps;
        }

        public int mcmTabulation(int[] arr, int n) {
            int dp[][]= new int[n][n];

            //no need of base case because it's already initialize with 0;
            for(int i=n-1;i>=1;i--){
                for(int j=i+1;j<n;j++){
                    int mini= (int) 1e9;
                    for(int k=i;k<=j-1;k++){
                        int steps=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                        mini=Math.min(mini,steps);
                    }
                    dp[i][j]=mini;
                }
            }
            return dp[1][n-1];
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

//        String x="heap";
//        String y="pea";
//
//       d.minNumberOfInsertionAndDeletionToConvertS1ToS2(x,y,x.length(),y.length());


        //shortest Common super-sequence length
//        String x="brute";
//        String y="groot";
//        int n=x.length();
//        int m=y.length();

//        System.out.println(d.shortestCommonSuperSequence(x,y));


        //print shortest Common super-sequence

//        System.out.println(d.printShortestCommonSuperSequence(x,y,n,m));


        //Distinct Subsequences ---Pattern Matching

//        String x="brootgroot";
//        String y="brt";
//        int n=x.length();
//        int m=y.length();

        //0 based indexing
//        System.out.println(d.distinctSubsequences(x,y,n-1,m-1));

        //Memoization
//        int dp[][]= new int[n][m];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.distinctSubsequencesWithMemoization(x,y,n-1,m-1,dp));


        //tabulation---1 based indexing
//        System.out.println(d.distinctSubsequencesTabulation(x,y,n,m));



        //Edit Distance
//        String x="horse";
//        String y="ros";
//        int n=x.length();
//        int m=y.length();

        //0 based indexing
//        System.out.println(d.editDistanceRecursive(n-1,m-1,x,y));

//        int dp[][]= new int[n+1][m+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);

//        System.out.println(d.editDistanceMemoization(n-1,m-1,x,y,dp));


        //1 bases indexing
//        System.out.println(d.editDistanceTabulation(x,y,n,m));


        //WildCard Matcing
//        String x="ab*cd";
//        String y= "abdefcd";// true
//        String x="ab?d";
//        String y= "abce";//false
//
//        int n=x.length();
//        int m=y.length();

        //0 based indexing
//        System.out.println(d.wildCardMatching(n-1,m-1,x,y));

//        boolean dp[][]= new boolean[n][m];
//        System.out.println(d.wildCardMatchingMemoization(n-1,m-1,x,y,dp));

        //starting from i
//        System.out.println(d.wildCardMatchingTabulation(x,y,n,m));



        //DP ON STOCKS
        //Best time to buy and sell stocks---Only one transaction

//        int arr[]={7,1,5,3,6,4};
//        System.out.println(d.bestTimeToBuyAndSellStock(arr));


        //Best time to buy and sell stocks -2---many transaction but you can hold only one at a time
        //--find maximum profit by buying and selling stocks
//        maximumProfitByBuyingAndSellingStocks
//        int price[]={7,1,5,3,6,4};
//        int n= price.length;;
//        System.out.println(d.maximumProfitByBuyingAndSellingStocks(0,1,price));//--initially we provide buy as 1 so we can buy


//          int dp[][]= new int[n][2];
//          for(int i=0;i<n;i++)
//              Arrays.fill(dp[i],-1);

//        maximum profit by buying and selling stocks
//        System.out.println(d.maximumProfitByBSByMemoization(0,1,price,n,dp));

//        System.out.println(d.maximumProfitByBSByTabulation(price,n));


        //Best time to buy and sell stocks -3
        //maximum profit in two transections
//        int price[]={3,3,5,0,3,1,4};
//        int cap=2;//number of transactions we can do
//        int n= price.length;
//        int buy=1;
//        int ind=0;

//        recursive---only 3 changing parameter--ind,buy,cap
//        System.out.println(d.maxProfitInTwoTransections(ind,buy,cap,price,n));

//        int dp[][][]= new int[n][2][3];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<2;j++)
//                Arrays.fill(dp[i][j],-1);
//        }

//        System.out.println(d.maxProfitInTwoTransactionsMemoiz(ind,buy,cap,n,price,dp));

//        System.out.println(d.maxProfitInTwoTransactionsTabulation(cap,n,price));

        //buy and sell stock-4th-//at most k transaction you can do---Solved by approach 2
//        int price[]={8,5,1,3,10};
//        int k=2;//cap === k
//        int transNum=0;//if we are using transNum then no need to use buy
//        int ind=0;
//        int n=price.length;
//        System.out.println(d.maxProfitByKTransaction(ind,transNum,k,n,price));//O/p=9

//        int dp[][]= new int[n][2*k];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.maxProfitByKTransactionMemoiz(ind,transNum,k,n,price,dp));

//        System.out.println(d.maxProfitByKTransactionTabulation(price,k,n));


        //buy and sell stocks with cool-down----we can buy multiple stocks
//        int price[]={4, 9, 0, 4, 10};
//        int n=price.length;
//        int buy=1;
//        int ind=0; //O/P:-11
//        System.out.println(d.maxProfitByCoolDown(ind,buy,n,price));

//        int dp[][]= new int[n][2];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);
//        System.out.println(d.maxProfitByCoolDownMemoiz(ind,buy,n,price,dp));

//        System.out.println(d.maxProfitByCoolDownTabulation(price,n));

        //buy and sell stocks with transaction fee---you can buy unlimited time

//        int price[]={1,3,2,8,4,9};
//        int n=price.length;
//        int fee=2;
//        int ind=0;
//        int buy=1;
//        System.out.println(d.maxProfitByBuyAndSellWithTransactionFee(ind,buy,n,fee,price));
//        int dp[][]= new int[n][2];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);

//        System.out.println(d.maxProfitByBuyAndSellWithTransactionFeeMemoization(ind,buy,n,fee,price,dp));

//        System.out.println(d.maxProfitByBuyAndSellWithTransactionFeeTabulation(price,n,fee));


        //longest Increasing Subsequence
//        int arr[] = {10,9,2,5,3,7,101,18};
//        int n=arr.length;
//        int ind=0;
//        int prevInd=-1;
//        System.out.println(d.longestIncreasingSubsequence(ind,prevInd,n,arr));

//        int dp[][]= new int[n][n+1];
//        for(int i=0;i<n;i++)
//            Arrays.fill(dp[i],-1);

//        System.out.println(d.longestIncreasingSubsequenceMemoiz(ind,prevInd,n,arr,dp));

//        System.out.println(d.longestIncreasingSubsequenceTabulation(arr,n));

        //longest Increasing Subsequence--Approach-2

//        int arr[]={5,4,11,1,16,8};
//        int n= arr.length;
//        System.out.println(d.LISubsequence(arr,n));

        //print longest increasing sequence

//        System.out.println(d.printLISequence(arr,n));

        //LIS using Binary Search

//        int arr[]={1,7,8,4,5,6,-1,9};
//        int n= arr.length;
//        System.out.println(d.LISUsingBinarySearch(arr,n));

        //Longest Divisible Subset

//        int arr[]={1,16,7,8,4};
//        int n=arr.length;
//        System.out.println(d.longestDivisibleSubset(arr,n));


//      longest String chain---
//        String [] arr= {"a", "b", "ba", "bca", "bda", "bdca"};
//        String arr[]= {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
//        int n=arr.length;
//        System.out.println(d.longestStringChain(arr,n));


        //longest Bitonic Subsequence

//        int arr[]={1,11,2,10,4,5,2,1};
//        int n=arr.length;
//        System.out.println(d.longestBitonicSubsequence(arr,n));


        //number Of Longest Increasing Subsequence

//        int arr[]={1,3,5,4,7};
//        int n=arr.length;
//        System.out.println(d.numberOfLIS(arr,n));


        //Matrix chain multiplication
//        int arr[]= {10, 15, 20, 25};//----O/P-8000
        int arr[]= {10, 30, 5, 60};//---O/P-4500
        int n= arr.length;

//        System.out.println(d.matrixChainMultiplication(arr,n));

        System.out.println(d.mcmTabulation(arr,n));



























































    }


}
