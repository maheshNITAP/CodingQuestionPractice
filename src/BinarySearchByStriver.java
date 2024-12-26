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
        int arr[]={4,5,6,7,0,1,2};
        System.out.println(bs.searchMinimumElementInRotatedSortedArray(arr));


    }




}
