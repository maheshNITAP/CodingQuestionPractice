import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackAndQueueQuestions {
    static class StackAndQueue{

        public List<Integer> nextGreaterElementToRight(int[] arr) {
            int n=arr.length;
            Stack<Integer> st= new Stack<>();
            List<Integer> ans = new ArrayList<>();
            for(int i=n-1;i>=0;i--){
                while(st.size()>0 && st.peek()<=arr[i])
                    st.pop();
                if(st.size()==0)
                    ans.add(-1);
                else
                    ans.add(st.peek());

                st.push(arr[i]);
            }
            Collections.reverse(ans);
            return ans;

        }

        public List<Integer> nextGreaterElementToRight1BetterSoln(int[] arr) {
            int n=arr.length;
            List<Integer> ans= new ArrayList<>();
            for(int i=0;i<n;i++){
                boolean found=false;
                for(int j=i+1;j<=i+n-1;j++){
                    int ind=j%n;
                    if(arr[ind]>arr[i]){
                        ans.add(arr[ind]);
                        found = true;
                        break;
                    }
                }
                if(!found)
                    ans.add(-1);
            }
            return ans;
        }

        public ArrayList<Integer> nextGreaterElementToRight1OptimalSoln(int[] arr) {
            int n=arr.length;
            ArrayList<Integer> ans = new ArrayList<>();
            Stack<Integer> st= new Stack<>();
            for(int i=2*n-1;i>=0;i--){
                while(!st.isEmpty() && st.peek()<=arr[i%n])
                    st.pop();
                if(i<n)
                    ans.add(st.isEmpty()?-1:st.peek());
                st.push(arr[i%n]);
            }
            Collections.reverse(ans);
            return ans;
        }

        public ArrayList previousSmallerElement(int[] arr) {
            int n=arr.length;
            ArrayList<Integer> ans= new ArrayList<>();
            for(int i=0;i<n;i++){
                boolean found=false;
                for(int j=i-1;j>=0;j--){
                    if(arr[i]>arr[j]){
                        ans.add(arr[j]);
                        found=true;
                        break;
                    }
                }
                if(!found)
                    ans.add(-1);
            }
            return ans;
        }

        public List previousSmallerElementNSL(int[] arr) {
            int n=arr.length;
            Stack<Integer> st= new Stack<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && st.peek()>=arr[i])
                    st.pop();
               ans.add(st.isEmpty()?-1:st.peek());
               st.push(arr[i]);
            }
            return ans;
        }

        public int sumOfSubArrayMinmimumBruteForce(int[] arr) {
            int sum=0;
            int mod=(int)(1e9+7);
            for(int i=0;i<arr.length;i++){
                int mini=arr[i];
                for(int j=i;j<arr.length;j++){
                    mini =Math.min(arr[j],mini);
                    sum=(sum+mini)%mod;
                }
            }
            return sum;
        }

        public int sumOfSubArrayMinimumOptimal(int[] arr) {
            int sum=0;
            int n=arr.length;
            int nse[]=findNSE(arr,n);// we are looking for next smaller because the moment we find smaller than, that element won't be anymore smaller in that subArray
            int mod=(int)1e9+7;
            int psse[]=findPSEE(arr,n);//previous smaller element and equals--added for edge case
            for(int i=0;i<n;i++){
                int left=i-psse[i];
                int right=nse[i]-i;
                sum=(sum+(right*left*arr[i])%mod)%mod;
            }
            return sum;
        }

        private int[] findPSEE(int[] arr, int n) {
            int psee[]= new int[n];
            Stack<Integer> st= new Stack<>();
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    st.pop();
                }
                psee[i]=st.isEmpty()?-1:st.peek();
                st.push(i);
            }
            return psee;
        }

        private int[] findNSE(int[] arr,int n) {
            int nse[]= new int[n];
            Stack<Integer> st= new Stack<>();//will store Only Index
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                    st.pop();
                nse[i]=st.isEmpty()?n:st.peek();
                st.push(i);
            }
            return nse;
        }

        public int sumOfSubArrayRangesBruteForce(int[] arr) {
            int n=arr.length;
            int sum=0;
            for(int i=0;i<n;i++){
                int smallest=arr[i],largest=arr[i];
                for(int j=i+1;j<n;j++){
                    smallest=Math.min(smallest,arr[j]);
                    largest=Math.max(largest,arr[j]);
                    sum+=(largest-smallest);
                }
            }
            return sum;
        }

        public int sumOfSubArrayRangesOptimal(int[] arr) {
            return sumOfSubArrayMaximum(arr)-sumOfSubArrayMinimum(arr);
        }

        private int sumOfSubArrayMaximum(int[] arr) {
            int n=arr.length;
            int nge[]=findNextGreaterElement(arr,n);
            int pgee[]=previousGreaterOrEqualElement(arr,n);
            int sum=0;
            for(int i=0;i<n;i++){
                int left=i-pgee[i];
                int right=nge[i]-i;
                sum+=(left*right*arr[i]);
            }
            return sum;

        }
        private int[] previousGreaterOrEqualElement(int[] arr, int n) {
            int pgee[]= new int[n];
            Stack<Integer> st= new Stack<>();
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && arr[st.peek()]<arr[i])
                    st.pop();
                pgee[i]=st.isEmpty()?-1:st.peek();
                st.push(i);
            }
            return pgee;
        }

        private int[] findNextGreaterElement(int[] arr, int n) {
            int nge[]= new int[n];
            Stack<Integer> st= new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && arr[st.peek()]<=arr[i])
                    st.pop();

                nge[i]=st.isEmpty()? n:st.peek();
                st.push(i);
            }
            return nge;
        }

        private int sumOfSubArrayMinimum(int[] arr) {
            int n=arr.length;
            int nse[]=findNextSmallElement(arr,n);
            int psee[]= findPreviousSmallOrEquivalentElement(arr,n);
            int sum=0;
            for(int i=0;i<n;i++){
                int left=i-psee[i];
                int right=nse[i]-i;
                sum+=(left*right*arr[i]);
            }
            return sum;
        }

        private int[] findPreviousSmallOrEquivalentElement(int[] arr, int n) {
            int psee[]=new int[n];
            Stack<Integer> st= new Stack<>();
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && arr[st.peek()]>arr[i])
                    st.pop();
                psee[i]=st.isEmpty()?-1:st.peek();
                st.push(i);
            }
            return psee;
        }



        private int[] findNextSmallElement(int[] arr, int n) {
            int nse[]= new int[n];
            Stack<Integer> st= new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                    st.pop();
                nse[i]=st.isEmpty()?n:st.peek();
                st.push(i);
            }
            return nse;
        }


        public List<Integer> asteroidCollisionsUsingStack(int[] arr) {
            int n=arr.length;
            Stack<Integer> st = new Stack<>();
            for(int i=0;i<n;i++){
                if(arr[i]>0){
                    st.push(arr[i]);
                }else {
                    while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i]))
                        st.pop();
                    if(!st.isEmpty() && st.peek()>0 && st.peek()==Math.abs(arr[i]))
                        st.pop();
                    else if(st.isEmpty() || st.peek()<0)// specially for -ve values
                        st.push(arr[i]);
                }
            }
            List<Integer> ls= new ArrayList<>();
            while(!st.isEmpty()){
                ls.add(st.pop());
            }
            Collections.reverse(ls);
            return ls;
        }

        public List<Integer> asteroidCollisionsUsingList(int[] arr) {
            int n=arr.length;
            List<Integer> lis= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(arr[i]>0){
                    lis.add(arr[i]);
                }else{
                    while(!lis.isEmpty() && lis.get(lis.size()-1)>0 && lis.get(lis.size()-1)<Math.abs(arr[i]))
                        lis.remove(lis.size()-1);
                    if(!lis.isEmpty() && lis.get(lis.size()-1)>0 && lis.get(lis.size()-1)==Math.abs(arr[i]))
                        lis.remove(lis.size()-1);
                    else if(lis.isEmpty() || lis.get(lis.size()-1)<0) //specially for -ve ele
                        lis.add(arr[i]);
                }
            }
            return lis;
        }

        public int maxAreaOfHistogram(int[] arr) {
            int n=arr.length;
            Stack<Integer> st= new Stack<>();//storing Index
            int maxArea=0;
            for(int i=0;i<n;i++){
                while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                    int currTouchingEle=st.pop();   //current touching or  (building for which we are calculating area) is current kicked iut element
                    int nse=i;  //nse is where we found smaller than this which is ih location
                    int pse=st.isEmpty()?-1:arr[st.peek()]; ////pse is top os stack after kicked ele
                    maxArea=Math.max(maxArea, arr[currTouchingEle]*(nse-pse-1));
                }
                st.push(i);
            }
            while (!st.isEmpty()){
                int nse=n;
                int currTouchingEle=st.pop();
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(maxArea,arr[currTouchingEle]*(nse-pse-1));

            }
            return  maxArea;
        }
    }
    public static void main(String args[]){
        StackAndQueue sq= new StackAndQueue();


        //next greater Element
//        int arr[]={4,12,5,3,1,2,5,3,1,2,4,6};
//        System.out.println(sq.nextGreaterElementToRight(arr));

        //next Greater Element-2
        //--given a circular array i.e.:- the next greater element of arr[arr.length-1] is arr[0]

//        int arr[]={2,10,12,1,11};

        //Better
//        System.out.println(sq.nextGreaterElementToRight1BetterSoln(arr));

        //Optimal by stack
//        System.out.println(sq.nextGreaterElementToRight1OptimalSoln(arr));

        //Next Smaller Element
//        int arr[]={4,5,2,10,8};

        //bruteforce
//        System.out.println(sq.previousSmallerElement(arr));

        //Using stack NSL
//        System.out.println(sq.previousSmallerElementNSL(arr));

        //sum Of SubArray Minimum
        //brute force

//        int arr[]={3,1,2,4};
//        System.out.println(sq.sumOfSubArrayMinmimumBruteForce(arr));

//        System.out.println(sq.sumOfSubArrayMinimumOptimal(arr));

        //Sum Of subArray Ranges
//        int arr[]={1,4,3,2};

        //brute force
//        System.out.println(sq.sumOfSubArrayRangesBruteForce(arr));

        //Optimal--using sum Of subArray Min techniquye
//        System.out.println(sq.sumOfSubArrayRangesOptimal(arr));


        //Asteroid Collisions

//        int arr[]={4,7,1,1,2,-3,-7,17,15,-16};
//        int arr[]={4,7,1,1,2,-3,-7,17,15,-16,-18,-19};

        //using Sack
//        System.out.println(sq.asteroidCollisionsUsingStack(arr));

        //Using List without stack
//        System.out.println(sq.asteroidCollisionsUsingList(arr));


        //maximum area Of rectangle using single traversal

        int arr[]={3,2,10,11,5,10,6,3};

        System.out.println(sq.maxAreaOfHistogram(arr));



    }
}
