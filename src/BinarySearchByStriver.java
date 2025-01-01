import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BinarySearchByStriver {
    public int searchElementInRotatedSortedArray(int []arr, int target){
        int n=arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[low]<=arr[mid]){//if left side sorted
                if(arr[low]<=target && target<=arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                if(arr[mid]<=target && target<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;

    }
    private boolean searchElementInRotatedSortedArrayWithDuplicateElement(int[] arr, int target) {
        int n=arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return true;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                if(arr[mid]<=target && target<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return false;
    }

    private int searchMinimumElementInRotatedSortedArray(int[] arr) {
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;

            //for Optimization
            if(arr[low]<=arr[high]){//if full array itself is sorted then no need to do BS again and again we will get min in first time itself--
                ans=Math.min(ans,arr[low]);
                break;
            }
            if(arr[low]<=arr[mid]){
                ans=Math.min(ans,arr[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

    //same as min element in rotated array
    private int findHowManyTimesAnArrayIsRotated(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]){
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<ans){
                    ans=arr[low];
                    index=low;
                }
                low=mid+1;
            }else{
                if(arr[mid]<ans){
                    ans=arr[mid];
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }

    private int findSingleElementInSortedArrayByLinearSearch(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i==0){
                if(arr[i]!=arr[i+1])
                    return arr[i];
            }
            else if(i==n-1){
                if(arr[i]!=arr[i-1])
                    return arr[i-1];
            }
            else if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) return arr[i];
        }
        return -1;
    }

    private int findSingleElementInSortedArrayByBinarySearch(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[n-1]!=arr[n-1]) return arr[n-1];

        int low=1,high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
                return arr[mid];
            if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2==0 && arr[mid]==arr[mid+1]))
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    private int findPeakElementByBruteForce(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if((i==0 || arr[i-1]<arr[i]) && (i==n-1 || arr[i]>arr[i+1]))
                return i;
        }
        return -1;
    }

    private int findPeakElementByBinarySearch(int[] arr) {
        int n=arr.length;
        if(n==1) return 0;
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-1]) return n-1;
        int low=1,high=n-2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]>arr[mid-1])
                low=mid+1;
//            else if(arr[mid]>arr[mid+1])//--if we use this the it will only work for single peak
//                high=mid-1;
            else //instead of else if if we use only else then it will work for multiple peak as well
                high=mid-1;
        }
        return -1;
    }

    private static int kthMissingPositiveIntegerLinearSearch(int[] arr, int k) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)
                k++;
            else break;
        }
        return k;

    }

    private static int kthMissingPositiveIntegerByBinarySearch(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
           int mid=low+(high-low)/2;
           int missing=arr[mid]-(mid+1);
           if(missing<k)
               low=mid+1;
           else
               high=mid-1;
        }
        return low+k;
    }
    static class BinarySearchOnAnswers{

        public int findSqrtOnNumberUsingBS(int n) {
            int low=1,high=n,ans=1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if((mid*mid)<=n){
                    ans=mid;
                    low=mid+1;
                }else
                    high=mid-1;
            }
            return high;
//            return ans;
        }

        public int findTheNthRootOfAnIntegerLinear(int n, int m) {
            int ans=1;
            for(int i=1;i<=m;i++){
                if(nthRootOfI(i,n,m)==1)
                    return i;
                else if(nthRootOfI(i,n,m)==2)
                    break;
            }
            return -1;
        }

        private int nthRootOfI(int ele, int n, int m) {
            long ans=1;
            for(int i=1;i<=n;i++){
                ans*=ele;
                if(ans>m) return 2;
            }
            if(ans==m) return 1;
            return 0;
        }

        public int findTheNthRootOfAnIntegerByBinarySearch(int n, int m) {
            int low=1,high=m;
            while(low<=high){
                int mid=low+(high-low)/2;
                int nthRootOfMid= nthRootOfI(mid,n,m);
                if(nthRootOfMid==1)
                    return mid;
                else if(nthRootOfMid==0)
                    low=mid+1;
                else
                    high=mid-1;
            }
            return -1;
        }

        public int kokoEatingBananasByLinearSearch(int[] piles, int h) {
            int n= piles.length;
            int max= findMax(piles,n);
            for(int i=1;i<=max;i++){
                int requiredTime= totalTimeToEatBananas(piles,i,n);
                if(requiredTime<=h)
                    return i;//-------minimum number of bananas need to eat to finish in h hours
            }
            return -1;
        }

        private int totalTimeToEatBananas(int[] piles, int hourly, int n) {
            int time=0;
            for(int i=0;i<n;i++){
                time+=Math.ceil((double)piles[i]/hourly);
            }
            return time;
        }

        private int findMax(int[] piles, int n) {
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max=Math.max(max,piles[i]);
            }
            return max;
        }

        private int findMini(int[] bloomingDay, int n) {
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                min=Math.min(min,bloomingDay[i]);
            }
            return min;
        }

        private int finSumOfArray(int[] weights, int n) {
            int sum=0;
            for(int x:weights)
                sum+=x;
            return sum;
        }

        public int kokoEatingBananasByBinarySearch(int[] piles, int h) {
            int n= piles.length;
            int low=1,high=findMax(piles, n);
            int ans=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                int reqTime=totalTimeToEatBananas(piles,mid,n);
                if(reqTime<=h){
                    ans=mid;
                    high=mid-1;
                }
                else
                    low=mid+1;
            }
            return ans;//or we can return low also
        }

        public int minNumberOfDaysToMakeMBouquetsByLinearSearch(int[] bloomingDay, int m, int k) {
            int n=bloomingDay.length;
            if(n<(m*k)) return -1;
            int mini=findMini(bloomingDay,n);
            int maxi=findMax(bloomingDay,n);
            for(int i=mini;i<=maxi;i++){
                if(isPossibleToMakeBouquets(bloomingDay,n,m,k,i))
                    return i;
            }
            return -1;
        }

        private boolean isPossibleToMakeBouquets(int[] bloomingDay, int n, int m, int k, int day) {
            int noOfBouquets=0;
            int count=0;
            for(int i=0;i<n;i++){
                if(bloomingDay[i]<=day)
                    count++;
                else{
                    noOfBouquets+=(count/k);
                    count=0;
                }
            }
            noOfBouquets+=(count/k);

            if(noOfBouquets>=m)
                return true;
            return false;

        }


        public int minNumberOfDaysToMakeMBouquetsByBinarySearch(int[] bloomingDay, int m, int k) {
            int n=bloomingDay.length;
            if(n<(m*k)) return -1;
            int low=findMini(bloomingDay,n);
            int high=findMax(bloomingDay,n);
            int ans=-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(isPossibleToMakeBouquets(bloomingDay,n,m,k,mid)){
                    ans=mid;
                    high=mid-1;
                }else
                    low=mid+1;
            }
            return low;
        }

        public int findASmallestDivisorForGivenThresholdByLinearSearch(int[] arr, int threshold) {
            int n=arr.length;
            int max=findMax(arr,n);
            for(int d=1;d<=max;d++){
                int sum=0;
                for(int i=0;i<n;i++){
                    sum+=Math.ceil((double)arr[i]/d);
                }
                if(sum<=threshold)
                    return d;
            }
            return -1;
        }

        public int findASmallestDivisorForGivenThresholdByBinarySearch(int[] arr, int threshold) {
            int n=arr.length;
            int low=1;
            int high=findMax(arr,n);
            int ans=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(isPossibleDivisor(arr,mid,n,threshold)){
                    ans=mid;
                    //either we can store mid as ans or low is also is accepted arean in last
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;//low
        }

        private boolean isPossibleDivisor(int[] arr, int mid, int n, int threshold) {//mid---->divisor
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=Math.ceil((double) arr[i]/mid);
            }
            if(sum<=threshold)
                return true;
            return false;
        }

        public int findCapacityToShipPackagesWithingDDaysByLinearSearch(int[] weights, int days) {
            int n=weights.length;
            int maxArr=findMax(weights,n);
            int arrSum=finSumOfArray(weights,n);
            for(int cap=maxArr;cap<=arrSum;cap++){
                int daysReq=reqDaysToShip(weights,cap,n);
                if(daysReq<=days)
                    return cap;
            }
            return -1;
        }

        private int reqDaysToShip(int[] weights, int cap, int n) {
            int day=1,load=0;
            for(int i=0;i<n;i++){
                if(load+weights[i]>cap){
                    day++;
                    load=weights[i];
                }else{
                    load+=weights[i];
                }

            }
            return day;
        }


        public int findCapacityToShipPackagesWithingDDaysByBinarySearch(int[] weights, int days) {
            int n=weights.length;
            int low=findMax(weights,n);
            int high=finSumOfArray(weights,n);
            while(low<=high){
                int mid=low+(high-low)/2;
                if(reqDaysToShip(weights,mid,n)<=days)//we can store this mid in ans as well
                    high=mid-1;
                else
                    low=mid+1;
            }
            return low;
        }

        public int aggressiveCowsLinearSearch(int[] stalls, int cows) {
            int n=stalls.length;
            Arrays.sort(stalls);
            for(int dist=1;dist<stalls[n-1]-stalls[0];dist++){
                if(isPossibleToPlaceCow(stalls,dist,cows))
                    continue;
                else
                    return dist-1;//if this is not possible then previous was out answer
            }
            return -1;
        }

        private boolean isPossibleToPlaceCow(int[] stalls, int dist, int cows) {
            int placedCow=1; int lastPosOfCow=stalls[0];
            for(int i=1;i<stalls.length;i++){
                if(stalls[i]-lastPosOfCow>=dist){
                    placedCow++;
                    lastPosOfCow=stalls[i];
                }
                if(placedCow>=cows)
                    return true;
            }
            return false;
        }

        public int aggressiveCowsBinarySearch(int[] stalls, int cows) {
            int n=stalls.length;
            Arrays.sort(stalls);
            int low=1;//it can be min of all consecutive distances difference
            int high=stalls[n-1]-stalls[0];//max distance we can place between two cows
            while(low<=high){
                int mid=low+(high-low)/2;
                if(isPossibleToPlaceCow(stalls,mid,cows))
                    low=mid+1;
                else
                    high=mid-1;
            }
            return high;

        }

        public int allocateBooksByLinearSearch(int[] arr, int m) {
            int n=arr.length;
            int low=findMax(arr,n);
            int high=finSumOfArray(arr,n);

            for(int pages=low;pages<=high;pages++){
                if(m==numberOfStudents(arr,pages))
                    return pages;
            }
            return -1;
        }

        private int numberOfStudents(int[] arr, int pages) {
            int student=1; int allocatedPages=0;
            for(int i=0;i<arr.length;i++){
                if(allocatedPages+arr[i]<=pages)
                    allocatedPages+=arr[i];
                else {
                    allocatedPages=arr[i];
                    student++;
                }
            }
            return student;
        }

        public int allocateBooksByBinarySearch(int[] arr, int m) {
            int n=arr.length;
            int low=findMax(arr,n);
            int high=finSumOfArray(arr,n);
            while(low<=high){
                int mid=low+(high-low)/2;
                int students=numberOfStudents(arr,mid);
                if(students>m)
                    low=mid+1;
                else
                    high=mid-1;
            }
            return low;
        }

        public double minimiseMaximumDistanceBetweenGasStationsBruteForce(int[] arr, int k) {
            int n=arr.length;
            int howMany[]= new int[n-1];
            for(int gasStation =1;gasStation<=k;gasStation++){
                double maxSection=-1;
                int maxSecIndex=-1;
                for(int i=0;i<n-1;i++){
                    double diff=arr[i+1]-arr[i];
                    double sectionLength=diff/(double) (howMany[i]+1);
                    if(sectionLength>maxSection){
                        maxSection=sectionLength;
                        maxSecIndex=i;
                    }
                }
                howMany[maxSecIndex]++;
            }
            double maxAns=-1;
            for(int i=0;i<n-1;i++){
                double diff=arr[i+1]-arr[i];
                double sectionLength= diff/(double)(howMany[i]+1);
                maxAns=Math.max(maxAns,sectionLength);
            }
            return maxAns;
        }

        public double minimiseMaximumDistanceBetweenGasStationsOptimalByHeap(int[] arr, int k) {
            int n=arr.length;
            int howMany[] = new int[n-1];
            PriorityQueue<Pair<Double,Integer>> pq= new PriorityQueue<>((a,b)->Double.compare(b.getKey(),a.getKey()));

            for(int i=0;i<n-1;i++){
                pq.add(new Pair<>((double)arr[i+1]-arr[i],i));
            }
            for(int gasStation=1;gasStation<=k;gasStation++){
                Pair<Double,Integer> top= pq.poll();
                int sectionIndex=top.getValue();
                howMany[sectionIndex]++;

                double diff=arr[sectionIndex+1]-arr[sectionIndex];
                double newSection=diff/(double) (howMany[sectionIndex]+1);
                pq.add(new Pair<>(newSection,sectionIndex));
            }
            return pq.peek().getKey();

        }

        public int medianOfTwoSortedArraysOfDifferentSizesBruteForceWithExtraSpace(int[] arr1, int[] arr2) {
            int n1= arr1.length;
            int n2=arr2.length;

            int n=n1+n2;
            ArrayList<Integer> arr= new ArrayList<>();
            int i=0,j=0;
            while(i<n1 && j<n2){
                if(arr1[i]<arr2[j])
                    arr.add(arr1[i++]);
                else
                    arr.add(arr2[j++]);
            }
            while(i<n1)
                arr.add(arr1[i++]);
            while(j<n2)
                arr.add(arr2[j++]);

            if(n%2==1)
                return arr.get(n/2);
            return (arr.get(n/2)+arr.get((n/2)-1))/2;
        }

        public int medianOfTwoSortedArraysOfDifferentSizesBruteForceWithOutExtraSpace(int[] arr1, int[] arr2) {
            int n1=arr1.length;
            int n2=arr2.length;
            int n=n1+n2;
            int ind2=n/2;
            int ind1= ind2-1;
            int count=0;
            int ind1ele=-1,ind2ele=-1;
            int i=0,j=0;
            while(i<n1 && j<n2){
                if(arr1[i]<arr2[j]){
                    if(count==ind1) ind1ele=arr1[i];
                    if(count==ind2) ind2ele=arr1[i];
                    count++;
                    i++;
                }else{
                    if(count==ind1)ind1ele=arr2[j];
                    if(count==ind2)ind2ele=arr2[j];
                    count++;
                    j++;
                }
            }
            while(i<n1){
                if(count==ind1)ind1ele=arr1[i];
                if(count==ind2)ind2ele=arr1[i];
                count++;
                i++;
                count++;
            }
            while(j<n2){
                if(count==ind1) ind1ele=arr2[j];
                if(count==ind2) ind2ele=arr2[j];
                j++;
                count++;
            }
            if(n%2==1)
                return ind2ele;
            return (ind1ele+ind2ele)/2;
        }

        public double medianOfTwoSortedArraysOfDifferentSizesByBinarySearch(int[] arr1, int[] arr2) {
            int n1=arr1.length;
            int n2=arr2.length;
            if(n1>n2) return medianOfTwoSortedArraysOfDifferentSizesByBinarySearch(arr2,arr1);//just calling again this fun if arr1 is larger than arr2
            int low=0,high=n1;
            int left=(n1+n2+1)/2;
            int n=n1+n2;
            while(low<=high){
                int mid1=(low+high)>>1;
                int mid2=left-mid1;
                int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
                if(mid1<n1) r1=arr1[mid1];
                if(mid2<n2) r2=arr2[mid2];

                if(mid1-1>=0) l1=arr1[mid1-1];
                if(mid2-1>=0) l2=arr2[mid2-1];

                if(l1<=r2 && l2<=r1){
                    if(n%2==1)
                        return Math.max(l1,l2);
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else if(l1<l2)
                    high=mid1-1;
                else
                    low=mid1+1;
            }
            return -1;
        }

        public int kthElementOfTwoSortedArrayByBinarySearch(int[] arr1, int[] arr2, int k) {
            int n1= arr1.length;
            int n2=arr2.length;
            int n=n1+n2;
            int left=k;
            int low=Math.max(k-n2,0), high=Math.min(k,n1);
            while(low<=high){
                int mid1=(low+high)/2;
                int mid2=left-mid1;
                int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
                if(mid1<n1) r1=arr1[mid1];
                if(mid2<n2) r2=arr2[mid2];

                if(mid1-1>=0) l1=arr1[mid1-1];
                if(mid2-1>=0) l2=arr2[mid2-1];
                if(l1<=r2 && l2<=r1)
                    return Math.max(l1,l2);
                else if(l1>r2)
                    high=mid1-1;
                else
                    low=mid1+1;

            }
            return 0;

        }
    }

    static class BinarySearchOn2D{

        public int findTheRowWithMaximum1sWithBruteForce(int[][] mat) {
            int n=mat.length;
            int maxCount=-1;
            int maxIndex=-1;
            for(int i=0;i<mat.length;i++){
                int count=0;
                for(int j=0;j<mat[i].length;j++){
                    count+=mat[i][j];
                }
                if(count>maxCount){
                    maxCount=count;
                    maxIndex=i;
                }
            }
            return maxIndex;
        }

        public int findTheRowWithMaximum1sByBinarySearch(int[][] mat) {
            int n=mat.length;
            int m=mat[0].length;
            int maxCount=-1;
            int maxIndex=-1;
            for(int i=0;i<n;i++){
                int countOnes=m-lowerBound(mat[i],m,1);
                if(countOnes>maxCount){
                    maxCount=countOnes;
                    maxIndex=i;
                }
            }
            return maxIndex;
        }

        private int lowerBound(int[] arr, int n, int x) {
            int low=0, high=n-1;
            int ans=n;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]>=x){
                    ans=mid;
                    high=mid-1;
                }else
                    low=mid+1;
            }
            return ans;
        }

        public boolean searchIn2DMatrixBruteForce(int[][] mat, int target) {
            int n=mat.length;
            int m=mat[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(mat[i][j]==target)
                        return true;
                }
            }
            return false;
        }

        public boolean searchIn2DMatrixOptimal(int[][] mat, int target) {
            int n=mat.length;
            int m=mat[0].length;
            for(int i=0;i<n;i++){
                if(mat[i][0]<=target && target<=mat[i][m-1]){
                    int ind=bs(mat[i],target);
                    if(ind!=-1)
                        return true;
                }
            }
            return false;
        }

        private int bs(int[] arr, int target) {
            int high=arr.length-1;
            int low=0;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]==target)
                    return mid;
                else if(target<mid)
                    high=mid-1;
                else
                    low=mid+1;
            }
            return -1;
        }

        public boolean searchIn2DMatrixByProperBinarySearch(int[][] mat, int target) {
            int n=mat.length;
            int m=mat[0].length;
            int low=0;
            int high=(n*m)-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                int row=mid/m;
                int col=mid%m;
                if(mat[row][col]==target)
                    return true;
                else if(mat[row][col]<target)
                    low=mid+1;
                else
                    high=mid-1;
            }
            return false;
        }

        public Pair<Integer,Integer> searchIn2DMatrix2ndBetter(int[][] mat, int target) {
            int n=mat.length;
            for(int i=0;i<n;i++){
                int index=bs(mat[i],target);
                if(index!=-1)
                    return new Pair<>(i,index);
            }
            return new Pair<>(-1,-1);
        }

        public Pair<Integer,Integer> searchIn2DMatrix2ndOptimalByPointer(int[][] mat, int target) {
            int n=mat.length;
            int m=mat[0].length;
            int row=0;
            int col=m-1;
            while(row<n && col>=0){
                if(mat[row][col]==target)
                    return new Pair<>(row,col);
                else if(mat[row][col]<target)
                    row++;
                else
                    col--;
            }
            return new Pair<>(-1,-1);
        }
    }

    public static void main(String args[]){
        BinarySearchByStriver bs=new BinarySearchByStriver();

        //search element in rotated sorted Array
//        int arr[]={7,8,9,1,2,3,4,5,6};
//        int target=7;
//        System.out.println(bs.searchElementInRotatedSortedArray(arr,target));

        //search element in rotated sorted Array with duplicate elements-- if present return true or false
//        int arr[]={3,1,2,3,3,3,3};
//        int target =1;
//        System.out.println(bs.searchElementInRotatedSortedArrayWithDuplicateElement(arr,target));

        ///search minimum element in rotated sorted array
//        int arr[]={4,5,6,7,0,1,2};
//        System.out.println(bs.searchMinimumElementInRotatedSortedArray(arr));

        //find out how many times an array has rotated--same as min element in rotated array
//        int arr[]={3,4,5,1,2};
//        System.out.println(bs.findHowManyTimesAnArrayIsRotated(arr));

        //find single element in Sorted array
        //int arr[]={1,1,2,2,3,3,4,5,5,6,6};

        //by linear search
        //System.out.println(bs.findSingleElementInSortedArrayByLinearSearch(arr));

        //By binary search
        //System.out.println(bs.findSingleElementInSortedArrayByBinarySearch(arr));


        //find any Peak Element--multiple peak and single peak both
//        int arr[]={1,2,3,4,5,6,7,8,5,1};//--8 at 7th index so output is 7
        //int arr[]={1,5,1,2,1};
        //brute force
//        System.out.println(bs.findPeakElementByBruteForce(arr));

       // System.out.println(bs.findPeakElementByBinarySearch(arr));


        //BINARY SEARCH ON ANSWERS

        //find sqrt of numbers using binary search
        BinarySearchOnAnswers bsoa= new BinarySearchOnAnswers();

//        int n=28;
//        System.out.println(bsoa.findSqrtOnNumberUsingBS(n));


        //Find the Nth root of an Integer
//        int n=3,m=27;
        //int n=4,m=69;

        //by linear search
//        System.out.println(bsoa.findTheNthRootOfAnIntegerLinear(n,m));

        //by binary search
        //System.out.println(bsoa.findTheNthRootOfAnIntegerByBinarySearch(n,m));


        //Koko eating bananas
//        int piles[]={3,6,7,11};
//        int h=8;

//        System.out.println(bsoa.kokoEatingBananasByLinearSearch(piles,h));


//        System.out.println(bsoa.kokoEatingBananasByBinarySearch(piles,h));


//        Minimum number of days to make m bouquets
//        int bloomingDay[]={7,7,7,7,13,11,12,7};
//        int m=2,k=3;

        //by linear search
//        System.out.println(bsoa.minNumberOfDaysToMakeMBouquetsByLinearSearch(bloomingDay,m,k));

//        System.out.println(bsoa.minNumberOfDaysToMakeMBouquetsByBinarySearch(bloomingDay,m,k));


        //find a smallest divisor given a threshold
//        int arr[]={1,2,5,9};
//        int threshold=6;

        //linear search
//        System.out.println(bsoa.findASmallestDivisorForGivenThresholdByLinearSearch(arr,threshold));

//        System.out.println(bsoa.findASmallestDivisorForGivenThresholdByBinarySearch(arr,threshold));



        //Capacity to ship packages within D days

//        int weights[]={1,2,3,4,5,6,7,8,9,10};
//        int days=5;

//        System.out.println(bsoa.findCapacityToShipPackagesWithingDDaysByLinearSearch(weights,days));

//        System.out.println(bsoa.findCapacityToShipPackagesWithingDDaysByBinarySearch(weights,days));


        //Kth missing positive number

//        int arr[]={2,3,4,7,11};
//        int k=5;

        //System.out.println(kthMissingPositiveIntegerLinearSearch(arr,k));

//        System.out.println(kthMissingPositiveIntegerByBinarySearch(arr,k));

        //from here we will do Question on (min)Of max OR (max)of min
        //Aggressive Cows

//        int stalls[]={0,3,4,7,10,9};
//        int cows=4;

//        System.out.println(bsoa.aggressiveCowsLinearSearch(stalls,cows));

//        System.out.println(bsoa.aggressiveCowsBinarySearch(stalls,cows));


        //Allocate Books

//        int arr[]= {25,46,28,49,24};// n books means length of array which contains pages arr[i]
//        int m=4;// number to students whom we need to allocate

//        System.out.println(bsoa.allocateBooksByLinearSearch(arr,m));

//        System.out.println(bsoa.allocateBooksByBinarySearch(arr,m));


        //Minimise Maximum Distance Between Gas Station
//        int arr[]={1,13,17,23};
//        int k=5;//----O/P--3

//        System.out.println(bsoa.minimiseMaximumDistanceBetweenGasStationsBruteForce(arr,k));

        //System.out.println(bsoa.minimiseMaximumDistanceBetweenGasStationsOptimalByHeap(arr,k));


        //Median of two sorted arrays of Different Sizes

//        int arr1[]={1,3,4,7,10,12};
//        int arr2[]={2,3,6,15};

        //Brute force with Extra space
//        System.out.println(bsoa.medianOfTwoSortedArraysOfDifferentSizesBruteForceWithExtraSpace(arr1,arr2));

        //Brute force without Extra spce
//        System.out.println(bsoa.medianOfTwoSortedArraysOfDifferentSizesBruteForceWithOutExtraSpace(arr1,arr2));


        //NEED TO REVISIT
        //with Binary search
//        System.out.println(bsoa.medianOfTwoSortedArraysOfDifferentSizesByBinarySearch(arr1,arr2));

        //Kth Element of two sorted Arrays
        //--same concept as Median of two sorted arrays of Different Sizes only instead of median we need to find kth element

//        int arr1[]={2,3,6,7,9};
//        int arr2[]={1,4,8,10};
//
//        int k=4;
//        System.out.println(bsoa.kthElementOfTwoSortedArrayByBinarySearch(arr1,arr2,k));


        BinarySearchOn2D BSon2D= new BinarySearchOn2D();

        //find the row with maximum ones

//        int mat[][]={{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,0},{0,1,1,1,1}};

        //Brute force
//        System.out.println(BSon2D.findTheRowWithMaximum1sWithBruteForce(mat));

        //Binary Search
//        System.out.println(BSon2D.findTheRowWithMaximum1sByBinarySearch(mat));

        //Search in 2d Matrix

//        int mat[][]={{3,4,7,9},{12,13,16,18},{20,21,23,29}};
//        int target=23;

        //Brute force
//        System.out.println(BSon2D.searchIn2DMatrixBruteForce(mat,target));


        //bs on respected row
//        System.out.println(BSon2D.searchIn2DMatrixOptimal(mat,target));

//        Bs on range of indexes
//        System.out.println(BSon2D.searchIn2DMatrixByProperBinarySearch(mat,target));


        //search in 2d matrix-||

        int mat[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target=14;

        //BS on every row
//        System.out.println(BSon2D.searchIn2DMatrix2ndBetter(mat,target));

        //Optimal Solution
        System.out.println(BSon2D.searchIn2DMatrix2ndOptimalByPointer(mat,target));







    }


}
