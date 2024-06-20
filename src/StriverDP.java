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
        int k=3;
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

        int grid[][]={{1},{2, 3},{15, 6, 7},{8,9,6,10}};
        int n=4;
//        System.out.println(d.minPathSumOfTriangularArraylist(grid,n));

        //minimum pathSum of Triangular Arraylist tabulation
        System.out.println(d.minPathSumOfTriangularArraylistWithTabulation(grid,n));

















    }


}
