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

        int arr[]={2,3,4,7,11};
        int k=5;

        //System.out.println(kthMissingPositiveIntegerLinearSearch(arr,k));

        System.out.println(kthMissingPositiveIntegerByBinarySearch(arr,k));




    }




}
