import javafx.util.Pair;

import java.util.*;


public class Arrayss {
    static class ArrayQuestions{

        public int secondLargestElementInArray(int[] arr) {
            int n=arr.length;
            Arrays.sort(arr);
            int largest=arr[n-1];
            for(int i=n-2;i>=0;i--){
                if(arr[i]!=largest){
                    return arr[i];
                }
            }
            return Integer.MIN_VALUE;
        }

        public int secondLargestElementInArrayBetterApproach(int[] arr) {
            int n=arr.length;
            int largest=arr[0];
            int secLargest=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                largest=Math.max(arr[i],largest);
            }
            for(int i=0;i<n;i++){
                if(arr[i]!=largest && arr[i]>secLargest)
                    secLargest=arr[i];
            }
            return secLargest;
        }

        public int secondLargestElementInArrayOptimalApproach(int[] arr) {
            int n=arr.length;
            int largest=arr[0];
            int secLargest=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(arr[i]>largest){
                    secLargest=largest;
                    largest=arr[i];
                }else if(arr[i]>secLargest && arr[i]<largest){
                    secLargest=arr[i];
                }
            }
            return secLargest;
        }

        public int[] removeDuplicate(int[] arr) {
            Set<Integer> st= new HashSet<>();
            for(int i=0;i<arr.length;i++)
                st.add(arr[i]);
            Iterator<Integer> it= st.iterator();
            int index=0;
            while(it.hasNext()){
                arr[index++]=it.next();
            }
            return arr;
        }

        public int[] removeDuplicateOptimal(int[] arr) {
            int i=0;
            for(int j=1;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    arr[i+1]=arr[j];
                    i++;
                }
            }
            return arr;
        }

        public void leftRotateArrayByOnePlace(int[] arr) {
            int temp=arr[0];
            for(int i=0;i<arr.length-1;i++)
                arr[i]=arr[i+1];
            arr[arr.length-1]=temp;
        }

        public void leftRotateArrayByDPlaceBruteForce(int[] arr, int d) {
            int n=arr.length;
            d=d%n;
            int temp[]= new int[d];
            for(int i=0;i<d;i++){
                temp[i]=arr[i];
            }
            for(int i=d;i<n;i++){
                arr[i-d]=arr[i];
            }
            for(int i=n-d;i<n;i++){
                arr[i]=temp[i-(n-d)];
            }
        }
        public void reverse(int[] arr, int i,int j){
            while(i<j){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }
        }

        public void leftRotateArrayByDPlaceOptimalApproach(int[] arr, int d) {
            reverse(arr,0,d-1);
            reverse(arr,d,arr.length-1);
            reverse(arr,0,arr.length-1);
        }

        public void rightRotateAnArrayByDPlaces(int[] arr, int d) {
            int n=arr.length;
            reverse(arr,0,n-d-1);
            reverse(arr,n-d,n-1);
            reverse(arr,0,n-1);
        }

        public int findMissingNumberBruteForce(int[] arr, int n) {
            for(int i=1;i<=n;i++){
                boolean flag=false;
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==i)
                        flag=true;
                }
                if(flag==false)
                    return i;
            }
            return -1;
        }

        public int findMissingNumberBetter(int[] arr, int n) {
            int maxi=0;
            for(int i=0;i<arr.length;i++)
                maxi=Math.max(arr[i],maxi);
            int hash[]= new int[maxi+1];

            for(int i=0;i<arr.length;i++){
                hash[arr[i]]++;
            }
            for(int i=1;i<n;i++){
                if(hash[i]==0)
                    return i;
            }
            return -1;
        }

        public int findMissingNumberOptimalBySumOfNaturalNumbers(int[] arr, int n) {
            int totalSum=n*(n+1)/2;
            int givenSum=0;
            for(int i=0;i<arr.length;i++)
                givenSum+=arr[i];
            return totalSum-givenSum;
        }

        public int findMissingNumberOptimalByXOR(int[] arr, int n) {
            int XOR1=0,XOR2=0;
            for(int i=0;i<arr.length;i++){
                XOR2=XOR2^arr[i];

                XOR1=XOR1^(i+1);
            }
            XOR1=XOR1^n;

            return XOR1^XOR2;
        }

        public int maximumConsecutiveOnes(int[] arr) {
            int count=0,max=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==1){
                    count++;
                    max=Math.max(max,count);
                }else
                    count=0;
            }
            return max;
        }

        public int findNumberThatAppearsOnlyOnceBruteForce(int[] arr) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                int num=arr[i];
                int count=0;
                for(int j=0;j<n;j++){
                    if(arr[j]==num)
                        count++;
                }
                if(count==1)
                    return num;
            }
            return -1;
        }

        public int findNumberThatAppearsOnlyOnceBetter(int[] arr) {
            int n=arr.length;
            int max=arr[0];
            for(int i=0;i<n;i++)
                max=Math.max(arr[i],max);

            int hash[]= new int[max+1];
            for(int i=0;i<n;i++){
                hash[arr[i]]++;
            }
            for(int i=0;i<=max;i++){
                if(hash[i]==1)
                    return i;
            }
            return -1;
        }

        public int findNumberThatAppearsOnlyOnceOptimal(int[] arr) {
            int XOR=0;
            for(int i=0;i<arr.length;i++)
                XOR=XOR^arr[i];
            return XOR;
        }

        public int longestSubArrayWithSumKBruteForce(int[] arr, int k) {
            int maxLen=0;
            for(int i=0;i<arr.length;i++){
                int sum=0;
                for(int j=i;j<arr.length;j++){
                    sum+=arr[j];
                    if(sum==k)
                        maxLen=Math.max(maxLen,j-i+1);
                    if(sum>k) break;
                }
            }
            return maxLen;
        }

        public int longestSubArrayWithSumKBetter(int[] arr, int k) {
            int maxLen=0;
            int preSum=0;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<arr.length;i++){
                preSum+=arr[i];
                if(preSum==k)
                    maxLen=Math.max(maxLen,i+1);
                int rem=preSum-k;
                if(map.containsKey(rem)){
                    maxLen=Math.max(maxLen,i-map.get(rem));
                }
                if(!map.containsKey(preSum)){//this check when we have continuous zeros that time we should not sort our length
                    map.put(preSum,i);
                }
            }
            return maxLen;
        }

        public int longestSubArrayWithSumKOptimal(int[] arr, int k) {
            int l=0,r=0,maxLen=0;
            int sum=0,n=arr.length;
            while(r<n){
                sum+=arr[r];
                while(sum>k){
                    sum-=arr[l++];
                }
                if(sum==k)
                    maxLen=Math.max(maxLen,r-l+1);
                r++;
            }
            return maxLen;
        }

        public String twoSumBruteForce(int[] arr, int target) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=j && arr[i]+arr[j]==target)
                        return "YES";
                }
            }
            return "NO";
        }

        public String twoSumBruteForceOptimal(int[] arr, int target) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]+arr[j]==target)
                        return "YES";
                }
            }
            return "NO";
        }

        public String twoSumBetterSolution(int[] arr, int target) {
            int n=arr.length;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<n;i++){
                int currEle=arr[i];
                int reqEle=target-currEle;
                if(map.containsKey(reqEle)){
                    return "YES";
                }
                map.put(arr[i],i);
            }
            return "NO";
        }

        public String twoSumOptimal(int[] arr, int target) {
            int n=arr.length;
            Arrays.sort(arr);
            int i=0,j=n-1;
            while(i<j){
                int sum=arr[i]+arr[j];
                if(sum==target){
                    return "YES";
                }else if(sum<target)
                    i++;
                else
                    j--;
            }
            return "NO";
        }

        public Pair<Integer, Integer> twoSumBruteForce1(int[] arr, int target) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i!=j && arr[i]+arr[j]==target)
                        return new Pair<>(i,j);
                }
            }
            return new Pair<>(-1,-1);

        }

        public Pair<Integer,Integer> twoSumBruteForceOptimal1(int[] arr, int target) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]+arr[j]==target)
                        return new Pair<>(i,j);
                }
            }
            return new Pair<>(-1,-1);
        }

        public Pair<Integer,Integer> twoSumOptimal1(int[] arr, int target) {
            int n=arr.length;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<n;i++){
                int currEle=arr[i];
                int reqEle=target-currEle;
                if(map.containsKey(reqEle)){
                    return new Pair<>(map.get(reqEle),i);
                }
                map.put(arr[i],i);
            }
            return new Pair<>(-1,-1);
        }

        //brute force
        public void sortAnArrayOf1sBruteForce(int[] arr) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=0;j<n-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        swap(arr,j,j+1);
                    }
                }
            }


        }

        private void swap(int[] arr, int i, int j) {
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }

        public void sortAnArrayOf1sBetterSol(int[] arr) {
            int  n=arr.length;
            int count0=0,count1=0,count2=0;
            for(int i=0;i<n;i++){
                if(arr[i]==0) count0++;
                else if(arr[i]==1) count1++;
                else count2++;
            }
            for(int i=0;i<count0;i++)
                arr[i]=0;
            for(int i=count0;i<count0+count1;i++)
                arr[i]=1;
            for(int i=count0+count1;i<n;i++)
                arr[i]=2;
        }

        public void sortAnArrayOf1sOptimalSolution(int[] arr) {
            int n=arr.length;
            int low=0,mid=0,high=n-1;
            while(mid<=high){
                if(arr[mid]==0){
                    swap(arr,low,mid);
                    low++;
                    mid++;
                }else if(arr[mid]==1)
                    mid++;
                else{
                    swap(arr,mid,high);
                    high--;
                }
            }
        }

        public int majorityElement(int[] arr) {
            int n=arr.length;
            for(int i=0;i<n;i++){
                int count=0;
                for(int j=0;j<n;j++){
                    if(arr[j]==arr[i])
                        count++;
                }
                if(count>n/2)
                    return arr[i];
            }
            return -1;
        }

        public int majorityElementBetterSol(int[] arr) {
            int n=arr.length;
            HashMap<Integer,Integer> map= new HashMap<>();
            Arrays.stream(arr).forEach(e->map.put(e,map.getOrDefault(e,0)+1));
//            map.entrySet().stream().filter(e->e.getValue()>n/2).forEach(e-> System.out.println(e.getKey()));
            for(Map.Entry<Integer,Integer>e: map.entrySet()){
                if(e.getValue()>n/2)
                    return e.getKey();
            }
            return -1;
        }

        public int majorityElementOptimalSol(int[] arr) {
            int n=arr.length;
            int count=0;
            int ele=0;
            for(int i=0;i<n;i++){
                if(count==0){
                    ele=arr[i];
                    count=1;
                }else if(arr[i]==ele)
                    count++;
                else
                    count--;
            }
            //this check is only needed if is didn't say that there is definitely one element occurs more than n/2 time
            int counter=0;
            for(int i=0;i<n;i++){
                if(ele==arr[i])
                    counter++;
            }
            if(counter>n/2)
                return ele;
            return -1;
        }

        public int maximumSubArraySumBruteForce(int[] arr) {
            int n=arr.length;
            int maxi=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=i;j<n;j++){
                    sum+=arr[j];
                    maxi=Math.max(maxi,sum);
                }
            }
            return maxi;
        }

        public int maximumSubArraySumUsingKadansAlgo(int[] arr) {
            int maxi=Integer.MIN_VALUE;
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
                if(sum>maxi)
                    maxi=sum;
                if(sum<0)
                    sum=0;
            }
            return maxi;
        }

        public Pair<Integer, Integer> printMaximumSumSubArrayUsingKadane(int[] arr) {
            int start=0;
            int ansStart = 0,ansEnd = 0;
            int sum=0,maxi= Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                if(sum==0)
                    start=i;
                sum+=arr[i];
                if(sum>maxi){
                    maxi=sum;
                    ansStart=start;
                    ansEnd=i;
                }
                if(sum<0)
                    sum=0;
            }
            return new Pair<>(ansStart,ansEnd);
        }

        public int[] reArrangeArrayElementBruteForce(int[] arr) {
            int n=arr.length;
            ArrayList<Integer> pos= new ArrayList<>();
            ArrayList<Integer> neg=new ArrayList<>();
//            for(int i=0;i<arr.length;i++){
//                if(arr[i]>0)
//                    pos.add(arr[i]);
//                else
//                    neg.add(arr[i]);
//            }
            Arrays.stream(arr).forEach(e->(e>0?pos:neg).add(e));
            for(int i=0;i<n/2;i++){
                arr[2*i]=pos.get(i);
                arr[(2*i)+1]=neg.get(i);
            }
            return arr;
        }

        public int[] reArrangeArrayElementOptima(int[] arr) {
            int n=arr.length;
            int ans[]= new int[n];
            int posInd=0,negIndex=1;
            for(int i=0;i<n;i++){
                if(arr[i]>0){
                    ans[posInd]=arr[i];
                    posInd+=2;
                }else{
                    ans[negIndex]=arr[i];
                    negIndex+=2;
                }
            }
            return ans;
        }

        public int [] reArrangeArrayElementVariant2(int[] arr) {
            int n=arr.length;
            ArrayList<Integer> pos= new ArrayList<>(),neg= new ArrayList<>();
            Arrays.stream(arr).forEach(e->(e>0?pos:neg).add(e));
            if(pos.size()>neg.size()){
                for(int i=0;i<neg.size();i++){
                    arr[2*i]=pos.get(i);
                    arr[(2*i)+1]=neg.get(i);
                }
                int index=neg.size()*2;
                for(int i=neg.size();i<pos.size();i++){
                    arr[index++]=pos.get(i);
                }
            }else{
                for(int i=0;i<pos.size();i++){
                    arr[2*i]=pos.get(i);
                    arr[(2*i)+1]=neg.get(i);
                }
                int index=pos.size()*2;
                for(int i=pos.size();i<neg.size();i++){
                    arr[index++]=neg.get(i);
                }
            }
            return arr;
        }

        public void nextPermutationOptimal(int[] arr) {
            int n=arr.length;
            int index=-1;
            for(int i=n-2;i>=0;i--){
                if(arr[i]<arr[i+1]){
                    index=i;
                    break;
                }
            }
            if(index==-1){
                reverse(arr,0,n-1);//my Own function
            }
            for(int i=n-1;i>=0;i--){
                if(arr[i]>arr[index]){
                    swap(arr,i,index);
                    break;
                }
            }
            reverse(arr,index+1,n-1);

        }

        public ArrayList<Integer> leadersInArrayBruteForce(int[] arr) {
            ArrayList<Integer> ans= new ArrayList<>();
            int n=arr.length;
            for(int i=0;i<n;i++){
                boolean isLeader=true;
                for(int j=i+1;j<n;j++){
                    if(arr[i]<arr[j]){
                        isLeader=false;
                        break;
                    }
                }
                if(isLeader)
                    ans.add(arr[i]);

            }
            return ans;
        }

        public ArrayList leadersInArrayOptimal(int[] arr) {
            ArrayList<Integer> ans= new ArrayList<>();
            int maxi=Integer.MIN_VALUE;
            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]>maxi){
                    ans.add(arr[i]);
                    maxi=arr[i];
                }
            }
            Collections.reverse(ans);//returning in array order only
            return ans;
        }

        public int longestConsecutiveSequenceBruteForce(int[] arr) {
            int n=arr.length;
            int longest=1;
            for(int i=0;i<n;i++){
                int x=arr[i];
                int count=1;
                while(linearSearch(arr,n,x+1)==true){
                    count++;
                    x=x+1;
                }
                longest = Math.max(longest,count);
            }
            return longest;
        }

        private boolean linearSearch(int[] arr, int n, int num) {
            for(int i=0;i<n;i++){
                if(num==arr[i])
                    return true;
            }
            return false;
        }

        public int longestConsecutiveSequenceBetterSol(int[] arr) {
            int n=arr.length;
            Arrays.sort(arr);
            int lastSmaller=Integer.MIN_VALUE;
            int currCount=0;
            int largest=0;
            for(int i=0;i<n;i++){
                if(lastSmaller+1==arr[i]){
                    currCount+=1;
                    lastSmaller=arr[i];
                }else if(lastSmaller+1 != arr[i]){
                    currCount=1;
                    lastSmaller=arr[i];
                }
                largest=Math.max(largest,currCount);
            }
            return largest;
        }

        public int longestConsecutiveSequenceOptimalSol(int[] arr) {
            int n=arr.length;
            if(n==0) return 0;
            int largest=1;
            HashSet<Integer> st= new HashSet<>();
            for(int i=0;i<n;i++)
                st.add(arr[i]);

            for(Integer it:st){
                if(!st.contains(it-1)){
                    int count=1;
                    int x=it;
                    while(st.contains(x+1)){
                        count+=1;
                        x=x+1;
                    }
                    largest=Math.max(largest,count);
                }
            }
            return largest;

        }

        public void setMatrixZeros(int[][] arr) {
            int n=arr.length;
            int m=arr[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==0){
                        makeRowZero(arr,i,m);
                        makeColZero(arr,j,n);
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==-1)
                        arr[i][j]=0;
                }
            }
        }

        private void makeColZero(int[][] arr, int j, int n) {
            for(int i=0;i<n;i++){
                if(arr[i][j]!=-0){
                    arr[i][j]=-1;
                }
            }
        }

        private void makeRowZero(int[][] arr, int i, int m) {
            for(int j=0;j<m;j++){
                if(arr[i][j]!=0)
                    arr[i][j]=-1;
            }
        }

        public void setMatrixZerosBetterSol(int[][] arr) {
            int n=arr.length;
            int m=arr[0].length;
            int col[]= new int[m],row[]= new int[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j]==0){
                        row[i]=1;
                        col[j]=1;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(row[i]==1 || col[j]==1)
                        arr[i][j]=0;
                }
            }
        }

        public int[][] rotateMatrixBy90DegreesBruteForce(int[][] arr) {
            int n=arr.length,m=arr[0].length;
            int ans[][]= new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    ans[j][n-1-i]=arr[i][j];
                }
            }
            return ans;
        }

        public void rotateMatrixBy90DegreesOptimal(int[][] arr) {
            int n=arr.length,m=arr[0].length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<m;j++)
                    swapIn2DMatrix(arr,i,j);
            }
            for(int i=0;i<n;i++){
                reverse(arr[i],0,m-1);
            }
        }

        private void swapIn2DMatrix(int[][] arr, int i, int j) {
            int t=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=t;
        }

        public void spiralTraversalOfMatrix(int[][] arr) {
            int n=arr.length;
            int m=arr[0].length;

            int top=0,left=0,right=m-1,bottom=n-1;
            while(top<=bottom && left<=right){

                //right-->
                for(int i=left;i<=right;i++)
                    System.out.print(arr[top][i]+" ");
                top++;
                //bottom--(top to bottom)
                for(int i=top;i<=bottom;i++)
                    System.out.print(arr[i][right]+" ");
                right--;

                //left---- <--
                if(top<=bottom){// in case of only one row is there
                    for(int i=right;i>=left;i--)
                        System.out.print(arr[bottom][i]+" ");
                    bottom--;
                }

                //top
                if(bottom<=right){// in case of only one column is there
                    for(int i=bottom;i>=top;i--)
                        System.out.print(arr[i][left]+" ");
                    left++;
                }
            }
        }

        public int elementAtGivenLocation(int row, int col) {
            //using nCr
            int res=1;
            for(int i=0;i<col;i++){
                res=res*(row-i);
                res=res/(i+1);
            }
            return res;
        }

        public List<Integer> printNthRowOfPascalTriangle(int n) {
            List<Integer> lis= new ArrayList<>();
            int ans=1;
            lis.add(ans);
            for(int col=1;col<n;col++){
                ans=ans*(n-col);
                ans=ans/(col);
                lis.add(ans);
            }
            return lis;
        }

        public List<List<Integer>> printWholePascalTriangle(int n) {
            List<List<Integer>> ans= new ArrayList<>();
            for(int row=1;row<=n;row++){
                List<Integer> temp= new ArrayList<>();
                for(int col=1;col<=row;col++){
                    temp.add(elementAtGivenLocation(row-1,col-1));
                }
                ans.add(temp);
            }
            return ans;
        }

        public List<List<Integer>> printWholePascalTriangleOptimal(int n) {
            List<List<Integer>> list= new ArrayList<>();
            for(int row=1;row<=n;row++){
                list.add(printNthRowOfPascalTriangle(row));
            }
            return list;
        }

        public List<Integer> majorityElement2BruteForce(int[] arr) {
            int n=arr.length;
            int floor=(int)(n/3)+1;
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(list.size()==0 || list.get(0)!=arr[i]){
                    int count=0;
                    for(int j=0;j<n;j++){
                        if(arr[j]==arr[i])
                            count++;
                    }
                    if(count>=floor)
                        list.add(arr[i]);
                }
               if(list.size()==2)break;//in every list only 2 elements possible of size >n/3  means minimum (n/3)+1
            }
            return list;
        }

        public List majorityElement2BetterSol(int[] arr) {
            List<Integer> list= new ArrayList<>();
            int n=arr.length;
            int minFreq=(int)(n/3)+1;
            Map<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if(map.get(arr[i])>=minFreq)
                    list.add(arr[i]);
                if(list.size()==2) break;
            }
            return list;
        }

        public List majorityElement2OptimalSol(int[] arr) {
            int n=arr.length;
            int count1=0,count2=0;
            int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(count1==0 && arr[i]!=ele2){
                    count1++;ele1=arr[i];
                }else if(count2==0 && arr[i]!=ele1){
                    count2++;ele2=arr[i];
                }else if(arr[i]==ele1)
                    count1++;
                else if(arr[i]==ele2)
                    count2++;
                else{
                    count1--;
                    count2--;
                }
            }
            //doing manual check if both ele1 and ele2 are correct ans
            count1=0;
            count2=0;
            for(int i=0;i<n;i++){
                if(arr[i]==ele1) count1++;
                if(arr[i]==ele2) count2++;
            }
            int minFreqReq=(int)(n/3)+1;
            List<Integer> list= new ArrayList<>();
            if(count1>=minFreqReq) list.add(ele1);
            if(count2>=minFreqReq) list.add(ele2);

            return list;
        }

        public List<List<Integer>> threeSumByBruteForce(int[] arr) {
            Set<ArrayList<Integer>> st= new HashSet<>();
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        if(arr[i]+arr[j]+arr[k]==0){
                            ArrayList<Integer> temp=new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k]));
                            Collections.sort(temp);
                            st.add(temp);
                        }
                    }
                }
            }
            List<List<Integer>> ans= new ArrayList<>();
            Iterator<ArrayList<Integer>> it=st.iterator();
            while(it.hasNext()){
                ans.add(it.next());
            }
            return ans;

        }

        public Set threeSumByBetterSoln(int[] arr) {
            int n=arr.length;
            Set<List<Integer>> st= new HashSet<>();
            for(int i=0;i<n;i++){
                HashSet<Integer> temp= new HashSet<>();
                for(int j=i+1;j<n;j++){
                    int third=-(arr[i]+arr[j]);
                    if(temp.contains(third)){
                        ArrayList<Integer> ans=new ArrayList<>(Arrays.asList(arr[i],arr[j],third));
                        Collections.sort(ans);
                        st.add(ans);
                    }
                    temp.add(arr[j]);
                }
            }
            return st;

        }

        public List<List<Integer>> threeSumByOptimalSol(int[] arr) {
            List<List<Integer>> ans= new ArrayList<>();
            Set<Integer> st= new HashSet<>();
            int n= arr.length;
            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                if(i>0 && arr[i]==arr[i-1]) continue;
                int j=i+1;
                int k=n-1;
                while(j<k){
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum<0)
                        j++;
                    else if(sum>0)
                        k--;
                    else{
                        ArrayList<Integer> temp= new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k]));
                        ans.add(temp);
                        j++;
                        k--;
                        //if continuous elements are same like ,1,1,

                        while(j<k && arr[j]==arr[j-1]) j++;
                        while(j<k && arr[k]==arr[k+1])k--;
                    }
                }
            }
            return ans;

        }

        public Set<List<Integer>> fourSumByBruteForce(int[] arr, int target) {
            Set<List<Integer>> ans= new HashSet<>();
            int n =arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        for(int l=k+1;l<n;l++){
                             long sum=arr[i]+arr[j]+arr[k]+arr[l];
                            if(sum==target){
                                ArrayList<Integer> tem= new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                                Collections.sort(tem);
                                ans.add(tem);
                            }
                        }
                    }
                }
            }
            return ans;
        }

        public Set<List<Integer>> fourSumByBetterApproach(int[] arr, int target) {
            int n=arr.length;

            Set<List<Integer>> ans= new HashSet<>();
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    HashSet<Integer> hashSet= new HashSet<>();
                    for(int k=j+1;k<n;k++){
                        int fourth=target-(arr[i]+arr[j]+arr[k]);
                        if(hashSet.contains(fourth)){
                            List<Integer> temp= new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],fourth));
                            Collections.sort(temp);
                            ans.add(temp);
                        }
                        hashSet.add(arr[k]);
                    }
                }
            }
            return ans;
        }

        public Set<List<Integer>> fourSumByOptimalApproach(int[] arr, int target) {
            int n=arr.length;
            Set<List<Integer>> ans= new HashSet<>();

            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                if(i>0 && arr[i]==arr[i-1]) continue;
                for(int j=i+1;j<n;j++){
                    if(j>i+1 && arr[j]== arr[j-1]) continue;
                    int k=j+1;
                    int l=n-1;
                    while(k<l){
                        long sum=arr[i]+arr[j]+arr[k]+arr[l];
                        if(sum<target)
                            k++;
                        else if(sum>target)
                            l--;
                        else{
                            List<Integer> tem= new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));// already in sorted order
                            ans.add(tem);
                            k++;
                            l--;
                            while(k<l && arr[k]==arr[k-1]) k++;
                            while(k<l && arr[l]==arr[l+1])l--;
                        }
                    }
                }
            }
            return ans;
        }

        public int numberOfSubArraysWithXOR_K_BruteForce(int[] arr, int k) {
            int count=0;

            for(int i=0;i<arr.length;i++){
                int XR=0;
                for(int j=i;j<arr.length;j++){
                    XR=XR^arr[j];
                    if(XR==k)
                        count++;
                }
            }
            return count;
        }

        public int numberOfSubArraysWithXOR_K_Optimal(int[] arr, int k) {
            int count=0;
            int XR=0;
            HashMap<Integer,Integer> map = new HashMap<>();

            map.put(0,1);//ele, freq-----0 can be considered as empty array also so we are putting one entry
            for(int i=0;i<arr.length;i++){
                XR=XR^arr[i];
                int x=XR^k;
                count+=map.getOrDefault(x,0);
                map.put(XR,map.getOrDefault(XR,0)+1);
            }
            return count;
        }

        public ArrayList<ArrayList<Integer>> mergeOverLappingIntervalsBruteForce(int[][] arr) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            int n=arr.length;
            Arrays.sort(arr,new Comparator<int []>(){
                @Override
                public int compare(int a[],int b[]){
                    if(a[0]==b[0])
                        return a[1]-b[1];
                    else
                        return a[0]-b[0];
                }
            });
            for(int i=0;i<n;i++){
                int start=arr[i][0];
                int end=arr[i][1];
                if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1))
                    continue;
                for(int j=i+1;j<n;j++){
                    if(arr[j][0]<=end)
                        end=Math.max(arr[j][1],end);
                    else
                        break;
                }
                ans.add(new ArrayList<>(Arrays.asList(start,end)));
            }
            return ans;
        }

        public List<List<Integer>> mergeOverLappingIntervalsByOptimal(int[][] arr) {
            int n=arr.length;

            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(arr,new Comparator<int[]>(){
                public int compare(int a[],int b[]){
                    if(a[0]==b[0])
                        return a[1]-b[1];
                    else
                        return a[0]-b[0];
                }
            });
            for(int i=0;i<n;i++){
                if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1).get(1))
                    ans.add(Arrays.asList(arr[i][0],arr[i][1]));
                else
                    ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),arr[i][1]));
            }
            return ans;

        }

        public void mergeTwoSortedArrayWithExtraSpace(int[] arr1, int[] arr2, int n, int m) {
            int arr[]= new int[n+m];
            int left=0,right=0;
            int indx=0;
            while(left<n && right<m){
                if(arr1[left]<=arr2[right])
                    arr[indx++]=arr1[left++];
                else
                    arr[indx++]=arr2[right++];
            }
            while(left<n)
                arr[indx++]=arr1[left++];
            while(right<m)
                arr[indx++]=arr2[right++];
            for(int i=0;i<n+m;i++){
                if(i<n)
                    arr1[i]=arr[i];
                else
                    arr2[i-n]=arr[i];
            }

        }
        public void swap(int arr1[],int arr2[],int left,int right){
            int tem=arr1[left];
            arr1[left]=arr2[right];
            arr2[right]=tem;
        }

        public void mergeTwoSortedArrayWithOptimal1(int[] arr1, int[] arr2, int n, int m) {
            int left=n-1,right=0;
            while(left>=0 && right<m){
                if(arr1[left]>arr2[right]){
                    swap(arr1,arr2,left,right);
                    left--;
                    right++;
                } else
                    break;
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);
        }

        public void mergeTwoSortedArrayWithOptimal2(int[] arr1, int[] arr2, int n, int m) {
            int len=n+m;
            int gap=(len/2)+(len%2);
            while(gap>0){
                int left=0;
                int right=left+gap;
                while(right<len){

                    //on arr1 and arr2 element
                    if(left <n && right>=n)
                        swapIfGreater(arr1,arr2,left,right-n);
                    else if(left>=n)//on arr2 and arr2 ele
                        swapIfGreater(arr2,arr2,left-n,right-n);
                    else //if both ele on arr1 only-->on arr1 and arr1
                        swapIfGreater(arr1,arr1,left,right);
                    left++;
                    right++;
                }
                if(gap==1) break;
                gap=(gap/2)+(gap%2);
            }
        }

        private void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
            if(arr1[ind1]>arr2[ind2])
                swap(arr1,arr2,ind1,ind2);
        }

        public Pair<Integer,Integer> findMissingNumberAndRepeatingNumberBruteForce(int[] arr, int n) {
            int missing=-1,repeating=-1;
            for(int i=1;i<=n;i++){
                int count=0;
                for(int j=0;j<n;j++){
                    if(i==arr[j])
                        count++;
                }
                if(count==0)
                    missing=i;
                else if(count==2)
                    repeating=i;
                if(repeating!=-1 && missing!=-1)
                    break;
            }
            return new Pair<>(missing,repeating);
        }

        public Pair<Integer,Integer> findMissingNumberAndRepeatingNumberBetterSoln(int[] arr, int n) {
            int hash[]=new int[n+1];
            for(int i=0;i<n;i++)
                hash[arr[i]]++;
            int repeating=-1,missing=-1;
            for(int i=1;i<=n;i++){
                if(hash[i]==2)
                    repeating=i;
                else if(hash[i]==0)
                    missing=i;

                if(missing!=-1 && repeating!=-1)
                    break;
            }
            return new Pair<>(missing,repeating);
        }

        public Pair<Integer,Integer> findMissingNumberAndRepeatingNumberOptimalSoln1(int[] arr, int n) {
            int SN=(n*(n+1))/2;
            int S2N=(n*(n+1)*(2*(n+1)))/6;
            int s=0,s2=0;
            for(int i=0;i<n;i++){
                s+=arr[i];
                s2+=(arr[i]*arr[i]);
            }

            int val1=s-SN;
            int val2=s2-S2N;
            val2=val2/val1;

            int repeating =(val1+val2)/2;
            int missing=repeating-val1;
            return new Pair<>(missing,repeating);
        }

        public Pair<Integer,Integer> findMissingNumberAndRepeatingNumberOptimalSoln2(int[] arr, int n) {
            int xr=0;
            for(int i=0;i<n;i++){
                xr=xr^arr[i];
                xr=xr^(i+1);
            }
            int bitNo=0;
            while(true){
                if((xr &(1<<bitNo))!=0){
                    break;
                }
                bitNo++;
            }
            int zero=0,one=0;
            for(int i=0;i<n;i++){//for array
                if((arr[i] &(1<<bitNo))!=0)
                    one=one^arr[i];
                else
                    zero=zero^arr[i];
            }

            for(int i=0;i<=n;i++){
                if((i &(1<<bitNo))!=0)
                    one =one^i;
                else
                    zero=zero^i;
            }
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]==zero)
                    count++;
            }
            if(count==2)
                return new Pair<>(one,zero);//missing, repeating
            return new Pair<>(zero,one);



        }

        public int countInversionInArrayBruteForce(int[] arr) {
            int count=0;
            int n=arr.length;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]>arr[j])
                        count++;
                }
            }
            return count;
        }

        public int countInversionInArrayOptimalSoln(int[] arr) {

            int n=arr.length;
            return mergeSortMethod(arr,0,n-1);
        }

        private int mergeSortMethod(int[] arr, int low, int high) {
            int count=0;
            if(low>=high) return 0;
            int mid=low+(high-low)/2;
            count+=mergeSortMethod(arr,low,mid);
            count+=mergeSortMethod(arr,mid+1,high);
            count+=mergeMethod(arr,low,mid,high);
            return count;

        }

        private int mergeMethod(int[] arr, int low, int mid, int high) {
            int count=0;
            int left=low;
            int right=mid+1;
            Vector<Integer> v= new Vector<>();

            while(left<= mid && right<=high){
                if(arr[left]<=arr[right])
                    v.add(arr[left++]);
                else {//if left is greater than right
                    v.add(arr[right++]);
                    count+=(mid-left)+1;
                }
            }

            while(left<=mid)
                v.add(arr[left++]);
            while(right<=high)
                v.add(arr[right++]);

            for(int i=low;i<=high;i++){
                arr[i]=v.get(i-low);//because v is new array so take from 0 but arr may be some middle part of array
            }
            return count;
        }

        public int numberOfReversePairsBruteForce(int[] arr) {
            int n=arr.length;
            int count=0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]>2*arr[j])
                        count++;
                }
            }
            return count;
        }

        public int numberOfReversePairsOptimalSoln(int[] arr) {
            int n=arr.length;
            int count= mergeSortMethod1(arr,0,n-1);
           return count;
        }

        private int mergeSortMethod1(int[] arr, int low, int high) {
            int count=0;
            if(low>=high) return 0;
            int mid=low+(high-low)/2;
            count+=mergeSortMethod1(arr,low,mid);
            count+=mergeSortMethod1(arr,mid+1,high);
            count+=countPairs(arr,low,mid,high);
            mergeMethod1(arr,low,mid,high);
            return count;
        }

        private void mergeMethod1(int[] arr, int low, int mid, int high) {
            int left=low,right=mid+1;
            Vector<Integer> v= new Vector<>();
            while(left<=mid && right<=high){
                if(arr[left]<=arr[right])
                    v.add(arr[left++]);
                else
                    v.add(arr[right++]);
            }
            while(left<=mid)
                v.add(arr[left++]);
            while(right<=high)
                v.add(arr[right++]);

            for(int i=low;i<=high;i++){
                arr[i]=v.get(i-low);
            }

        }

        private int countPairs(int[] arr, int low, int mid, int high) {
            int count=0;
            int right=mid+1;
            for(int i=low;i<=mid;i++){
                while(right<=high && arr[i]>2*arr[right]){
                    right++;
                }
                count+=(right-(mid+1));
            }
            return count;
        }
    }
    public static void main(String args[]){
        ArrayQuestions array= new ArrayQuestions();




//        int arr[]= {1,2,4,7,7,5};
        //Second largest element
        //bruteForce
//        System.out.println(array.secondLargestElementInArray(arr));

        //better
//        System.out.println(array.secondLargestElementInArrayBetterApproach(arr));

        //Optimal
//        System.out.println(array.secondLargestElementInArrayOptimalApproach(arr));

        //remove duplicate in-place in sorted Array
//        int arr[]= {1,1,2,2,2,3,3};
        //brute force
//        int res[]=array.removeDuplicate(arr);

        //optimal by two pointer
//        int res[]= array.removeDuplicateOptimal(arr);
//
//        for(int i:res){
//            System.out.print(i+" ");
//        }

        //Left Rotate the Array by 1 place

//        int arr[]={1,2,3,4,5};
//        array.leftRotateArrayByOnePlace(arr);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }

        //left rotate the array by d places
//        int arr[]={1,2,3,4,5,6,7};
//        int d=3;

        //Brute force
//        array.leftRotateArrayByDPlaceBruteForce(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }

        //Optimal
//        array.leftRotateArrayByDPlaceOptimalApproach(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }
//        System.out.println();

        //right rotate the array by d places
//        array.rightRotateAnArrayByDPlaces(arr,d);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }


        //find the missing number from 1 to n
//        int arr[]={1,2,4,5};
//        int n=5;

        //brute force
//        System.out.println(array.findMissingNumberBruteForce(arr,n));

        //better
//        System.out.println(array.findMissingNumberBetter(arr,n));

        //Optimal--but Integer Overflow can happen
//        System.out.println(array.findMissingNumberOptimalBySumOfNaturalNumbers(arr,n));
        
        //Optimal--by XOR
//        System.out.println(array.findMissingNumberOptimalByXOR(arr,n));

        //Given a binary array nums, return the maximum number of consecutive 1's in the array.

//        int arr[]={11,0,1,1,1,0,1,1};
//        System.out.println(array.maximumConsecutiveOnes(arr));

        //find the number that appears only once and others are appearing twice
//        int arr[]={1,2,3,1,3,6,7,6,2};


        //brute force
//        System.out.println(array.findNumberThatAppearsOnlyOnceBruteForce(arr));

        //better
//        System.out.println(array.findNumberThatAppearsOnlyOnceBetter(arr));

        //Optimal---XOR
//        System.out.println(array.findNumberThatAppearsOnlyOnceOptimal(arr));


        //longest subArray with sum K
//        int arr[]={1,2,3,1,1,1,4,2,3};
//        int k=3;

//        int arr[]={1,2,3,1,1,1,1,3,3};
//        int k=6;
//        System.out.println(array.longestSubArrayWithSumKBruteForce(arr,k));

        //Better for Only +ve Values and this is Only Optimal for -ve and +ve both valued array
//        System.out.println(array.longestSubArrayWithSumKBetter(arr,k));

//        //Optimal Sol
//        System.out.println(array.longestSubArrayWithSumKOptimal(arr,k));


        //two sum return YES Or no if available or not--variant-1
//        int arr[]={2,6,5,8,11};
//        int target=14;

        //bruteForce
//        System.out.println(array.twoSumBruteForce(arr,target));

        //bruteForce Optimal
//        System.out.println(array.twoSumBruteForceOptimal(arr,target));

        //Better Solution using hashing
//        System.out.println(array.twoSumBetterSolution(arr,target));

        //Optimal Solution
//        System.out.println(array.twoSumOptimal(arr,target));



//        //two sum return index where both ele persent --variant-2
        //brute force
//        System.out.println(array.twoSumBruteForce1(arr,target));

        //brute force Optimal
//        System.out.println(array.twoSumBruteForceOptimal1(arr,target));

        //Optimal
//        System.out.println(array.twoSumOptimal1(arr,target));


        //Sort An Array of 0's, 1's and 2's
//        int arr[]={0,1,2,0,1,2,1,2,0,0,0,1};

        //using any sorting algo
//       array.sortAnArrayOf1sBruteForce(arr);
//        for(int i:arr)
//            System.out.print(i+" ");

        //Better Solution
//        array.sortAnArrayOf1sBetterSol(arr);
//        for(int i:arr)
//            System.out.print(i+" ");

        //Optimal solution--using Dutch national flag Algorithm
//        array.sortAnArrayOf1sOptimalSolution(arr);
//        for(int i:arr)
//            System.out.print(i+" ");

        //majority Element---majority element is the element which occurs more then n/2 time

//        int arr[]={7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};

        //brute force
//        System.out.println(array.majorityElement(arr));

        //Better Solution--using hashing
//        System.out.println(array.majorityElementBetterSol(arr));

        //Optimal Soln--using moose voting Algrithm
//        System.out.println(array.majorityElementOptimalSol(arr));

        //Maximum Subarray Sum---Kadane Algo
//        int arr[]={-2,-3,4,-1,-2,1,5,-3};

        //brute force
//        System.out.println(array.maximumSubArraySumBruteForce(arr));

        //Optimal-using Kadan's algorithm
//        System.out.println(array.maximumSubArraySumUsingKadansAlgo(arr));
        
        
        //Follow Up Question On-Maximum SubArray Sum
        //--Print Maximum SubArray Sum
//        Pair<Integer,Integer>p=array.printMaximumSumSubArrayUsingKadane(arr);
//        for(int i=p.getKey();i<=p.getValue();i++){
//            System.out.print(arr[i]+" ");
//        }


        //ReArrange Array element By Sign +ve/_ve
        //variation 1st--where equal # of +ve and -ve are there
//        int arr[]={3,1,-2,-5,2,-4};

        //brute force
//        array.reArrangeArrayElementBruteForce(arr);
//        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));

        //Optimal
//        int ans[]=array.reArrangeArrayElementOptima(arr);
//        Arrays.stream(ans).forEach(e-> System.out.print(e+" "));

        //variant-2--# of +ve and negative are not equal

//        int arr[]={1,2,-4,-5,3,6};
//
//        array.reArrangeArrayElementVariant2(arr);
//        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));

        //next Permutation--Optimal
//        int arr[]={2,1,5,4,3,0,0};
//        array.nextPermutationOptimal(arr);
//        Arrays.stream(arr).forEach(e-> System.out.print(e+" "));

        //leaders in Array--everything on the right should be smaller

//        int arr[]={10,22,12,3,0,6};

        //brute force
//        System.out.println(array.leadersInArrayBruteForce(arr));

//        Optimal
//        System.out.println(array.leadersInArrayOptimal(arr));


        //Longest Consecutive Sequence

//        int arr[]={102,4,100,1,101,3,2,1,1,103,104};

        //brute force
//        System.out.println(array.longestConsecutiveSequenceBruteForce(arr));

        //better Solution--using sorting---N logN+N
//        System.out.println(array.longestConsecutiveSequenceBetterSol(arr));

        //Optimal Solution
//        System.out.println(array.longestConsecutiveSequenceOptimalSol(arr));

        //set matrix zeros--set all rows and column to zeros which consist 0 in it

//        int arr[][]={{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};

        //brute force
//        array.setMatrixZeros(arr);
//
//        Arrays.stream(arr).forEach(e-> {
//            Arrays.stream(e).forEach(System.out::print);
//            System.out.println(" ");
//        });

        //Better Solution
//        array.setMatrixZerosBetterSol(arr);
//        Arrays.stream(arr).forEach(e-> {
//            Arrays.stream(e).forEach(System.out::print);
//            System.out.println(" ");
//        });

        //Optimal---it's there you can check notes


        //rotate matrix/Image by 90 degrees
//        int arr[][]={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        //brute force with extra space
//        int[][] ans = array.rotateMatrixBy90DegreesBruteForce(arr);
//
//        Arrays.stream(ans).forEach(e-> {
//            Arrays.stream(e).forEach(System.out::print);
//            System.out.println(" ");
//        });

        //Optimal using transpose matrix
//        array.rotateMatrixBy90DegreesOptimal(arr);
//                Arrays.stream(arr).forEach(e-> {
//            Arrays.stream(e).forEach(System.out::print);
//            System.out.println(" ");
//        });


        //Spiral traversal of a matrix
//        int arr[][]={
//                {1,2,3,4,5,6},
//                {20,21,22,23,24,7},
//                {19,32,33,34,25,8},
//                {18,31,36,35,26,9},
//                {17,30,29,28,27,10},
//                {16,15,14,13,12,11}};
//
//        array.spiralTraversalOfMatrix(arr);

        //pascal triangle

//        type-1

//        you are given row and column ,print the element persent at palce row and col

        int row=5,col=3;

//        System.out.println(array.elementAtGivenLocation(row-1,col-1));//1 based indexing so row-1,col-1


        //print nth row of pascal triangle
//        int n=6;

//        System.out.println(array.printNthRowOfPascalTriangle(n));

        //print whole pascal triangle

        //brute force
//        List<List<Integer>> ans= array.printWholePascalTriangle(n);
//
//        for(List<Integer> e:ans){
//            System.out.println(e);
//        }

        //Optimal

//        List<List<Integer>> ans= array.printWholePascalTriangleOptimal(n);
//        for (List<Integer> e:ans)
//            System.out.println(e);



        //Majority Element-2---return all numbers which present >n/3 times

//        int arr[]={1,1,1,3,3,2,2,2};

        //brute force
//        System.out.println(array.majorityElement2BruteForce(arr));


        // Better Solution--using remember technique
//        System.out.println(array.majorityElement2BetterSol(arr));

//        int arr[]={2,1,1,3,1,4,5,6};

        //Optimal--using using moose voting Algorithm with modification
//        System.out.println(array.majorityElement2OptimalSol(arr));


        //3 SUM---find out the triplets where sum is zero

//        int arr[]={-1,0,1,2,-1,-4};

        //brute force
//        List<List<Integer>> ans=array.threeSumByBruteForce(arr);
//        for(List<Integer> lis:ans){
//            System.out.println(lis);
//        }


        //Better Soln--usingHashTable

//        Set ans= array.threeSumByBetterSoln(arr);//we can directly return set also
//        System.out.println(ans);

        //Optimal Soln
        //first sort then use two pointer
//        List<List<Integer>> ans = array.threeSumByOptimalSol(arr);
//        System.out.println(ans);


        //4 Sum---find four elements whose sum is equals to target

//        int arr[]={1,0,-1,0,-2,2};
//        int target=0;

        //brute force
//        Set<List<Integer>> ans= array.fourSumByBruteForce(arr, target);
//        System.out.println(ans);

        //Better Soln
//        Set<List<Integer>> ans= array.fourSumByBetterApproach(arr,target);
//        System.out.println(ans);

        //Optimal Soln
//        1) sort array
//        2) use pointer approach

//        int arr[]={1,3,1,2,4,2,3,1,3,4,2,4,5,5};
//        int target=8;
//        System.out.println(array.fourSumByOptimalApproach(arr,target));

        //number Of SubArrays with XOR K
//        int arr[]={4,2,2,6,4};
//        int k=6;

//        System.out.println(array.numberOfSubArraysWithXOR_K_BruteForce(arr,k));

      //Optimal
//        System.out.println(array.numberOfSubArraysWithXOR_K_Optimal(arr,k));

        //Merge OverLapping Intervals
//        int arr[][]={{1,3},{2,6},{8,9},{9,11},{8,11},{2,3},{15,18},{16,17}};

        //brute force
//        System.out.println(array.mergeOverLappingIntervalsBruteForce(arr));

        //Optimal Soln
//        System.out.println(array.mergeOverLappingIntervalsByOptimal(arr));


        //Merge Two Sorted arrays without Extra Space
//        int arr1[]={1,3,5,7}; int arr2[]={0,2,6,8,9};
//        int n=arr1.length,m=arr2.length;

        //with Extra Space--kind of Brute Force
//        array.mergeTwoSortedArrayWithExtraSpace(arr1,arr2,n,m);

        //Optimal-1
//        array.mergeTwoSortedArrayWithOptimal1(arr1,arr2,n,m);

        //Optimal--Approach 2
//        array.mergeTwoSortedArrayWithOptimal2(arr1,arr2,n,m);
//        Arrays.stream(arr1).forEach(System.out::print);
//        System.out.println();
//        Arrays.stream(arr2).forEach(System.out::print);


        //find Repeating and missing Number

//        int arr[]={4,3,6,2,1,1};
//        int n=arr.length;

        //brute force------p.key==missing,p.val--repeating
//        System.out.println(array.findMissingNumberAndRepeatingNumberBruteForce(arr,n));

        //Better Soln--using hashtable
//        System.out.println(array.findMissingNumberAndRepeatingNumberBetterSoln(arr,n));

        //Optimal Soln-1---using Math formula
//        System.out.println(array.findMissingNumberAndRepeatingNumberOptimalSoln1(arr,n));

        //Optimal Soln-2--By Approach 2
//        System.out.println(array.findMissingNumberAndRepeatingNumberOptimalSoln2(arr,n));


        //count inversions in an array

//        int arr[]={5,3,2,4,1};

        //Brute Force
//        System.out.println(array.countInversionInArrayBruteForce(arr));

        //Optimal Soln
//        System.out.println(array.countInversionInArrayOptimalSoln(arr));


        //Reverse Pairs--return the number of reverse Pairs in the array
        int arr[]={40,25,19,12,9,6,2};

//        System.out.println(array.numberOfReversePairsBruteForce(arr));

        System.out.println(array.numberOfReversePairsOptimalSoln(arr));

















    }

}
