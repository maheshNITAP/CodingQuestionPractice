public class BinarySearchQuestions {

    //Binary search
    public static int binarySearch(int arr[],int start,int end,int target){
        int res=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==arr[mid]){
                res=mid;
                break;
            } else if (target<arr[mid]) {
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return res;
    }
    //find first occurrence of an element
    public static int bstFirstOccur(int arr[],int target){
        int ans=-1;
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid= i+(j-i)/2;
            if(arr[mid] ==  target){
                ans=mid;
                j=mid-1;
            } else if (arr[mid]<target) {
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return ans;
    }

    public static int bstFirstOccurWithStartAndEnd(int arr[],int target, int i, int j){
        int ans=-1;
//        int i=0;
//        int j=arr.length-1;
        while(i<=j){
            int mid= i+(j-i)/2;
            if(arr[mid] ==  target){
                ans=mid;
                j=mid-1;
            } else if (arr[mid]<target) {
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return ans;
    }

    //find last occurrence of an element
    public static int bsfLastOccur(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid= start+(end-start);
            if(target== arr[mid]){
                ans=mid;
                start=mid+1;
            } else if (target> arr[mid]) {
                start= mid+1;
            }else {
                end=mid-1;
            }
        }
        return ans;
    }

    //count an element in a sorted array
    public static int countOfElementInSortedArray(int arr[], int target){
        //first Occurrence of that ele
        int firstIndx= bstFirstOccur(arr,target);

        //last occurrence of that ele
        int lastIndx= bsfLastOccur(arr, target);
        //count of element
        return lastIndx-firstIndx+1;
    }

    //Number of times a Sorted array is rotated
    public static int numberOfTimesRotated(int arr[]){// # of times rotated = index of min element
        int n=arr.length;
        int ans=0;
        int start=0;
        int end=arr.length-1;

        while(start<= end){
            if(arr[start]<=arr[end]){// very Important
                return start;
            }
            int mid=start+(end-start)/2;
            int next= (mid+1)%n;
            int prev=(mid+n-1)%n;
            if(arr[prev]<arr[mid] && arr[mid]<arr[next]){
                return mid;
            } else if (arr[start]<arr[mid]) {// if left side is sorted then move right side, bcz we will find and in unsorted side
                start= mid+1;
            } else if (arr[mid]< arr[end]) {// if left side is sorted then move left side
                end=mid-1;
            }
        }
        return 0;
    }
    //find an element in a rotated sorted array
    public static int findElementInRotatedSortedArray(int arr[],int target){
        int res=-1;
        int start=0;
        int end=arr.length-1;
        int minElementIndex= numberOfTimesRotated(arr);
        if(target>=arr[start] && target<=arr[minElementIndex-1]){
            return binarySearch(arr,start,minElementIndex-1,target);
        }else {
            return binarySearch(arr,minElementIndex,end,target);
        }

    }
    //Searching element In nearly sorted Array---- element can be at (i-1)th, (i)th or (i+1)th index
    public static int findElementInNearlySortedArray(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(arr[mid]==target){
                return  mid;
            } else if (mid-1>start && arr[mid-1]==target) {
                return mid-1;
            } else if (mid+1<end && arr[mid+1]==target) {
                return mid+1;
            } else if (target<arr[mid]) {
                end=mid-2;
            }else {
                start=mid+2;
            }
        }
        return -1;//if not find
    }

    //find floor of an element---> greatest Element but smaller or equal to that element
    public static int floorOfElement(int arr[],int target){
        int start=0;
        int end=arr.length;
        int res=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                res= arr[mid];
                break;
            } else if (arr[mid]<target) {
                start=mid+1;
                res=arr[mid];
            }else {
                end=mid-1;
            }
        }
        return res;
    }

    //find ceil of en element--> smaller elment which is greater than target
    public static int findCeilOfElement(int arr[],int target){
        int res=-1;
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                res=arr[mid];
                break;
            } else if (arr[mid]<target) {
                start=mid+1;
            }else {
                res=arr[mid];
                end=mid-1;
            }
        }
        return res;
    }

    //next letter Problem --> we have to find next letter of the key
    public static char nextLetterProblem(char arr[], char key){
        int start=0;
        int end=arr.length-1;
        char res='#';
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==key){//age key hi mil gyi tho start ko mid+1 kr denge kyukhum next key dhund rhe h, same key nhi
                start=mid+1;
            } else if (arr[mid]<key) {
                start=mid+1;
            }else {
                res=arr[mid];
                end=mid-1;
            }
        }
        return res;
    }

    //find position of element in infinite sorted array
    public static int indexOfElementInInfiniteSoretedArray(int arr[],int target){
        int low=0;
        int high=1;
        while(target>arr[high]){
            low=high;
            high=high*2;
        }
        return binarySearch(arr,low,high,target);
    }

    //find first index of elemet 1 in infinite sorted array
    public static int firstIndexOfOneInInfiniteArray(int arr[]){
        int low=0;
        int high=1;
        while(1>arr[high]){
            low=high;
            high=high*2;
        }
        return bstFirstOccurWithStartAndEnd(arr,1,low,high);

    }

    //Minimum difference element in sorted array
    public static int minDifferenceElement(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        int res=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                res=arr[mid];
                break;
            } else if (arr[mid]<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        if(res==-1){
            res=Math.abs(arr[start]-target)<Math.abs(arr[end]-target) ? arr[start] : arr[end];
        }
        return res;
    }

    //Peak element in unsorted array-- we will apply BFS based on Answer
    public static int peakElement(int arr[]){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid> 0 && mid<arr.length-1){
                if(arr[mid-1]<arr[mid] && arr[mid]> arr[mid+1]){
                    return mid;
                }else if(arr[mid-1]>arr[mid]){//we will move to that side where we have possibility to find ans
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            } else if (mid==0) {
                if(arr[mid]> arr[1]){
                    return mid;
                }else {
                    return 1;
                }
            } else if (arr[mid]==arr.length-1) {
                if(arr[mid]>arr[arr.length-2]){
                    return mid;
                }else {
                    return arr.length-2;
                }
            }
        }
        return -1;
    }

    public static int descBinarySearch(int arr[],int start,int end,int key){
        int res=-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(arr[mid]==key){
                return mid;
            } else if (arr[mid]<key) {
                end=mid-1;
            }else if(arr[mid]>key){
                start=mid+1;
            }
        }
        return res;
    }
    public static int asecBinarySearch(int arr[],int start,int end,int key){
        int res=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==key){
                return mid;
            } else if (arr[mid]<key) {
                start=mid+1;
            } else if (arr[mid]>key) {
                end=mid-1;
            }
        }
        return res;
    }

    //search element in bitonic array
    public static int findElementInBitonicArray(int arr[],int key){
        int indexOfPeakEle= peakElement(arr);
        int x=-1;
        int y=-1;

        if(arr[0]>= arr[indexOfPeakEle-1]){
            x=descBinarySearch(arr,0,indexOfPeakEle-1,key);
        } else if (arr[0]<=arr[indexOfPeakEle-1]) {
            x=asecBinarySearch(arr,0,indexOfPeakEle-1,key);
        }

        if(arr[indexOfPeakEle]>=arr[arr.length-1]){
            y=descBinarySearch(arr,indexOfPeakEle,arr.length-1,key);
        } else if (arr[indexOfPeakEle]<=arr[arr.length-1]) {
            y=asecBinarySearch(arr,indexOfPeakEle,arr.length-1,key);
        }
        if(x == -1){
            return y;
        }else {
            return x;
        }

    }
    public static class Pair{
        int rowIndex;
        int colIndex;
        public Pair(int r,int c){
            this.rowIndex=r;
            this.colIndex=c;
        }
    }

    public static Pair findElementInRowAndColumnWiseSortedMatrix(int arr[][],int key){
        int row=0;
        int col=arr[0].length-1;
        int rowLength=arr.length;
        int colLength=arr[0].length;

        while (row>=0 && row<rowLength && col>=0 && col<colLength){
            if(arr[row][col]==key){
                return new Pair(row,col);
            }else if(arr[row][col]<key){
                row++;
            } else if (arr[row][col]>key) {
                col--;
            }
        }
        return new Pair(-1,-1);

    }

    public static boolean isValid(int arr[],int k,int maxNumberOfPages){
        int students=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(arr[i]>maxNumberOfPages){
                return false;
            }
            if(sum>maxNumberOfPages){
                students++;
                sum=arr[i];
            }
            if(students>k){
                return false;
            }
        }
        return true;
    }
    public static int allocateMaxNumberOfPages(int arr[],int k){
        int start=0;
        int end=0;
        int res=-1;
        for(int x:arr){
            end+=x;
//            if(start<x){
//                x=start;
//            }
        }
        while (start<=end){
            int mid= start+(end-start)/2;
            if(isValid(arr,k,mid)){
                res=mid;
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return res;

    }


    public static void main(String args[]){
//        int[] arr= {2,4,10,10,10,18,20};
//        int target=10;
//        System.out.println(bstFirstOccur(arr,target));  //----index of first occurrence
//        System.out.println(bsfLastOccur(arr,target));    //----index of last occurrence
//        System.out.println(countOfElementInSortedArray(arr,target));-- returns number of elements

//        int arr[]= {11,12,15,18,2,5,6,8};
//        System.out.println(numberOfTimesRotated(arr));   //--returns #of rotations

//        int arr[]= {11,12,15,18,2,5,6,8};
//        System.out.println(findElementInRotatedSortedArray(arr,12));    //--returns index of ele

//        int arr[]={5,10,30,20,40};
//        System.out.println(findElementInNearlySortedArray(arr,40));   //-- returns index of that element

//        int arr[]={1,2,3,4,8,10,10,12,19};
//        System.out.println(floorOfElement(arr,10));

//        int arr[]={1,2,3,4,8,10,10,12,19};
//        System.out.println(findCeilOfElement(arr,11));

//        char arr[]={'a', 'b', 'c', 'f','h'};
//        System.out.println(nextLetterProblem(arr,'b'));

//        int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        System.out.println(indexOfElementInInfiniteSoretedArray(arr,6));

//        int arr[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        System.out.println(firstIndexOfOneInInfiniteArray(arr));

//        int arr[]={4,6,10};
//        int arr[]={1,3,8,10,15};
//        System.out.println(minDifferenceElement(arr,6));

//        int arr[]={5,10,20,15};
//        System.out.println("//index of peak element : " +peakElement(arr));

//        int arr[]={1,3,8,12,4,2};
//        System.out.println(findElementInBitonicArray(arr,3));

//        int arr[][]= {{10,20,30,40},{15,25,35,45},{27,29,37,48},{23,33,49,50}};
//        Pair p =findElementInRowAndColumnWiseSortedMatrix(arr,49);
//        System.out.println("row is : "+ p.rowIndex+ " column index is : "+p.colIndex);

        int arr[]={12, 34, 67, 90};
        System.out.println(allocateMaxNumberOfPages(arr,2));

    }
}
