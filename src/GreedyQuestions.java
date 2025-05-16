import javafx.util.Pair;

import java.util.*;

public class GreedyQuestions {
    static class Data{
        private int id;
        private int profit;
        private int deadline;
        public  Data(int id, int profit, int deadline){
            this.id=id;
            this.profit=profit;
            this.deadline=deadline;

        }

    }
    public static class ProfitComparator implements Comparator<Data>{
        @Override
        public int compare(Data d1, Data d2){
            return d2.profit-d1.profit;
        }
    }
    private static class Greed{

        public int assignCookies(int[] greed, int[] s) {
            int n=greed.length;
            int m=s.length;
            int l=0,r=0;
            Arrays.sort(greed);
            Arrays.sort(s);
            while(l<m){
                if(s[l]>=greed[r])
                    r+=1;
                l++;
            }
            return r;//we can return count as well
        }

        public boolean lemonadeChange(int[] bills) {
            int five=0, ten=0;
            for(int cash:bills){
                if(cash==5)
                    five++;
                else if(cash==10){
                    if(five>0){
                        five--;
                        ten++;
                    }
                    else
                        return false;
                }else {
                    if(ten>0 && five>0){
                        ten--;
                        five--;
                    }else if(five>=3){
                        five-=3;
                    }else
                        return false;
                }
            }
            return true;
        }

        public int shortestJobFirst(int[] arr) {
            int t=0,waitingTime=0;
            Arrays.sort(arr);
            for(int x:arr){
                waitingTime+=t;
                t+=x;
            }
            return waitingTime/arr.length;
        }

        public boolean jumpGame1(int[] arr) {
            int n=arr.length;
            int maxInd=0;
            for(int i=0;i<n;i++){
                if(i>maxInd)
                    return false;
                maxInd=Math.max(maxInd,i+arr[i]);
            }
            return true;
        }

        public int jumpGame2Recursive(int[] arr) {
            int n=arr.length;
//            return recursive(arr,0,0,n);

            int dp[][]= new int[n][n];
            for(int i=0;i<n;i++)
                Arrays.fill(dp[i],-1);
            return recursiveMemo(arr,0,0,n,dp);
        }

        private int recursiveMemo(int[] arr, int ind, int jumps, int n, int[][] dp) {
            if(ind>=n-1)
                return jumps;
            if(dp[ind][jumps]!=-1)
                return dp[ind][jumps];
            int mini=Integer.MAX_VALUE;
            for(int i=1;i<=arr[ind];i++){
                mini=Math.min(mini,recursiveMemo(arr,ind+i,jumps+1,n,dp));
            }
            return dp[ind][jumps]=mini;

        }

        private int recursive(int[] arr, int ind, int jumps, int n) {
            if(ind>=n-1)
                return jumps;
            int min=Integer.MAX_VALUE;
            for(int i=1;i<=arr[ind];i++){
                min=Math.min(min,recursive(arr, ind+i, jumps+1, n));
            }
            return min;
        }

        public int jumpGame2Optimal(int[] arr) {
            int n=arr.length;
            int l=0,r=0;
            int jumps=0;
            while(r<n-1){
                int farthest=0;
                for(int ind=l;r<n && ind<=r;ind++){
                    farthest=Math.max(farthest,ind+arr[ind]);
                }
                l=r+1;
                r=farthest;
                jumps++;
            }
            return jumps;
        }



        public Pair<Integer, Integer> jobSequencingProblem(int[] deadline, int[] profit) {
            int n=deadline.length;
            ArrayList<Data> arr= new ArrayList<>();
            int maxDeadline=-1;
            for(int i=0;i<n;i++){
                arr.add(new Data(i,profit[i],deadline[i]));
                maxDeadline=Math.max(maxDeadline,deadline[i]);
            }
            Collections.sort(arr, new ProfitComparator() );
            int totalProfit=0,count=0;
            int hash[]= new int[maxDeadline+1];
            Arrays.fill(hash,-1);

            for(int i=0;i<n;i++){
                for(int j=arr.get(i).deadline;j>=1;j--){
                    if(hash[j]==-1){
                        count++;
                        hash[j]=arr.get(i).id;
                        totalProfit+=arr.get(i).profit;
                        break;
                    }
                }
            }
            return new Pair<Integer,Integer>(count,totalProfit);

        }
    }
    public static void main(String[] args) {

        Greed g= new Greed();
        //assign cookies

//        int greed[] = {1,5,3,3,4};
//        int s[]={4,2,1,2,1,3};
//        System.out.println(g.assignCookies(greed,s));

        //lemonade change
//        int bills[]={5,5,5,10,20};
//        int bills[]={5,5,10,10,20};
//        System.out.println(g.lemonadeChange(bills));

        //Shortest Job First(SJF)
//        int arr[]={4,3,7,1,2};
//        System.out.println(g.shortestJobFirst(arr));

        //Jump Game-1
//        int arr[]={1,2,4,1,1,0,2,5};//--true
//        int arr[]={1,2,3,1,1,0,2,5};//--false
//        System.out.println(g.jumpGame1(arr));

        //jump Game 2
        int arr[]={2,3,1,4,1,1,1,2};

//        System.out.println(g.jumpGame2Recursive(arr));
        //Optimal
//        System.out.println(g.jumpGame2Optimal(arr));

        //Job Sequencing Problem
        int deadline[] = {4, 1, 1, 1};
        int profit[] = {20, 10, 40, 30};

        System.out.println(g.jobSequencingProblem(deadline,profit));

    }
}
