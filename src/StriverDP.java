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
    }
    public static void main(String args[]){

        //frog jump
        DP d= new DP();
        int height[]={10,20,30,10};
        int n= height.length-1;
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
        int arr[]={2,1,4,9};
        int ind=arr.length-1;
//        System.out.println(d.houseRobber(arr,ind));
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);


        //house robber with memoization
//        System.out.println(d.houseRobberWithMemoization(arr,ind,dp));

        //house robber with tabulation
//        System.out.println(d.houseRobberWithTabulation(arr,arr.length));

        //house robber with tabulation+Space Optimization
        System.out.println(d.houseRobberWithTabulationAndSpaceOptimization(arr,arr.length));


    }


}
