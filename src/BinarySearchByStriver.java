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
        int n=4,m=69;

        //by linear search
//        System.out.println(bsoa.findTheNthRootOfAnIntegerLinear(n,m));

        //by binary search
        System.out.println(bsoa.findTheNthRootOfAnIntegerByBinarySearch(n,m));








    }




}
