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

    static class MeetingData{
        private int start;
        private int end;
        private int ind;

        public MeetingData(int start, int end, int ind){
            this.start=start;
            this.end=end;
            this.ind=ind;
        }
    }

    public static class EndComparator implements Comparator<MeetingData>{

        @Override
        public int compare(MeetingData d1, MeetingData d2){
            return d1.end-d2.end;//ascending order
        }
    }
    public static class ProfitComparator implements Comparator<Data>{
        @Override
        public int compare(Data d1, Data d2){
            return d2.profit-d1.profit; //descending Order
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

        public int nMeetingRoomProblem(int[] start, int[] end) {
            int n=start.length;
            MeetingData[] arr=  new MeetingData[n];
            for(int i=0;i<n;i++){
                arr[i]= new MeetingData(start[i],end[i],i+1);

            }
            Arrays.sort(arr, new EndComparator());
            int count=1, freeTime=arr[0].end;
            ArrayList<Integer> ansList= new ArrayList<>();
            for(int i=1;i<n;i++){
                if(arr[i].end>freeTime){
                    count++;
                    freeTime=arr[i].end;
                    ansList.add(arr[i].ind);
                }
            }
            return count;//we can return index of all used interval by ansList

        }

        public int nonOverLappingProblems(int[][] arr) {
            int n = arr.length;
            Arrays.sort(arr, (a, b) -> a[1] - b[1]);
            int count = 1;
            int freeTime = arr[0][1];
            for (int i = 0; i < n; i++) {
                if (arr[i][0] >= freeTime) {
                    freeTime = arr[i][1];
                    count++;
                }
            }
            return n - count;//number of intervals to be removed=total # of intervals-# of non-overlapping intervals
        }

        public ArrayList<int[]> insetInterval(int[][] arr, int[] newInterval) {
            ArrayList<int[]> res= new ArrayList<>();
            int n=arr.length;
            int i=0;
            //left part of intervals before overlapping
            while(i<n && arr[i][1]<newInterval[0]){
                res.add(arr[i]);
                i++;
            }

            //OvreLapping Part of intervals
            while(i<n && arr[i][0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],arr[i][0]);
                newInterval[1]=Math.max(newInterval[1],arr[i][1]);
                i++;
            }
            res.add(newInterval);
            //right part after interval
            while(i<n){
                res.add(arr[i]);
                i++;
            }
            return res;
        }

        public int minNumberOfPlatformsRequiredInRailwayStation(int[] arr, int[] dep) {
            Arrays.sort(arr);
            Arrays.sort(dep);
            int i=0,j=0;
            int maxCount=0;
            int count=0;
            int n=arr.length;
            while(i<n){
                if(arr[i]<=dep[j]){
                    count++;
                    i++;
                }else {
                    count--;
                    j++;
                }
                maxCount=Math.max(count,maxCount);
            }
            return maxCount;
        }

        public boolean validParenthesisRecursive(String s) {
            int count = 0;
            int ind = 0;
            return validParenthesisSolve(s, ind, count);
        }

        private boolean validParenthesisSolve(String s, int ind, int count) {
            if (count < 0)
                return false;
            if (ind == s.length())
                return count == 0;
            if (s.charAt(ind) == '(')
                return validParenthesisSolve(s, ind + 1, count + 1);
            if (s.charAt(ind) == ')')
                return validParenthesisSolve(s, ind + 1, count - 1);
            return (validParenthesisSolve(s, ind + 1, count + 1) || validParenthesisSolve(s, ind + 1, count - 1) || validParenthesisSolve(s, ind + 1, count));
        }

        public boolean validParenthesisRecursiveMemo(String s) {
            int n = s.length();
            int dp[][] = new int[n][n];
            int ind = 0, count = 0;
            for (int i = 0; i < n; i++)
                Arrays.fill(dp[i], -1);
            return validParenthesisSolveMemo(s, ind, count, dp);
        }

        private boolean validParenthesisSolveMemo(String s, int ind, int count, int[][] dp) {
            if (count < 0)
                return false;
            if (ind == s.length())
                return count == 0;
            if (dp[ind][count] != -1) {
                return dp[ind][count] == 1 ? true : false;
            }
            if (s.charAt(ind) == '(') {
                boolean res1 = validParenthesisSolveMemo(s, ind + 1, count + 1, dp);
                dp[ind][count] = res1 == true ? 1 : 0;
                return res1;
            }
            if (s.charAt(ind) == ')') {
                boolean res2 = validParenthesisSolveMemo(s, ind + 1, count - 1, dp);
                dp[ind][count] = res2 == true ? 1 : 0;
                return res2;
            }
            boolean res3 = (validParenthesisSolveMemo(s, ind + 1, count + 1, dp) ||
                    validParenthesisSolveMemo(s, ind + 1, count - 1, dp) ||
                    validParenthesisSolveMemo(s, ind + 1, count, dp));
            dp[ind][count] = res3 == true ? 1 : 0;
            return res3;
        }

        public boolean validParenthesisOptimal(String s) {
            int n = s.length();
            int min = 0, max = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    min += 1;
                    max += 1;
                } else if (s.charAt(i) == ')') {
                    min = min - 1;
                    max = max - 1;
                } else {
                    min = min - 1;
                    max = max + 1;
                }
                if (min < 0) min = 0;
                if (max < 0) return false;
            }
            return min == 0;
        }

        public int candy(int[] ratings) {
            int n = ratings.length;
            int left[] = new int[n];
            int right[] = new int[n];
            left[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    left[i] = left[i - 1] + 1;
                else
                    left[i] = 1;
            }
            right[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1])
                    right[i] = right[i + 1] + 1;
                else
                    right[i] = 1;

            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.max(left[i], right[i]);
            }
            return sum;
        }

        public int candySpaceAndTimeReduced(int[] ratings) {
            int n = ratings.length;
            int left[] = new int[n];
            left[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    left[i] = left[i - 1] + 1;
                else
                    left[i] = 1;
            }
            int right = 1;
            int sum = Math.max(right, left[n - 1]);
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right = right + 1;
                } else
                    right = 1;
                sum = sum + Math.max(left[i], right);
            }
            return sum;
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
//        int arr[]={2,3,1,4,1,1,1,2};

//        System.out.println(g.jumpGame2Recursive(arr));
        //Optimal
//        System.out.println(g.jumpGame2Optimal(arr));

        //Job Sequencing Problem
//        int deadline[] = {4, 1, 1, 1};
//        int profit[] = {20, 10, 40, 30};
//
//        System.out.println(g.jobSequencingProblem(deadline,profit));

        //N meeting room in one room
//        int start[]={0,3,1,5,5,8};
//        int end[]={5,4,2,9,7,9};
//
//        System.out.println(g.nMeetingRoomProblem(start,end));

        //Non-Overlapping Problems
//        int arr[][]={{0,5},{3,4},{1,2},{5,9},{5,7},{7,9}};
//        System.out.println(g.nonOverLappingProblems(arr));


        //Insert Intervals
//        int arr[][]={{1,2},{3,4},{5,7},{8,10},{12,16}};
//        int newInterval[]={6,8};
//
//        ArrayList<int[]> res= g.insetInterval(arr, newInterval);
//        for(int[] x:res){
//            for(int y:x){
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }

        //minimum number of platforms required in a railway station
//        int arr[]={900, 940, 950, 1100, 1500, 1800};
//        int dep[]={910,1200, 1120, 1130,1900, 2000};
//
//        System.out.println(g.minNumberOfPlatformsRequiredInRailwayStation(arr,dep));

        //Valid Parenthesis String

//        String s="(*()";

//        String s="(**(";
        //recursive
//        System.out.println(g.validParenthesisRecursive(s));

        //memoization
//        System.out.println(g.validParenthesisRecursiveMemo(s));

        //Optimal Using range concept
//        System.out.println(g.validParenthesisOptimal(s));


        //Candy--each child must have 1 candy
//             --children with higher rating get more candies tha their neighbors
//        int ratings[]={0,2,4,3,2,1,1,3,5,6,4,0,0};//OP:-27
//        int ratings[]={1,0,2};//O/P:-5
        int ratings[]={1,2,2};//OP:-4


        //TC=O(3N) SC=O(2N)
//        System.out.println(g.candy(ratings));

        System.out.println(g.candySpaceAndTimeReduced(ratings));




    }
}
