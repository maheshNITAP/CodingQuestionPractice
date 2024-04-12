import java.util.ArrayList;
import java.util.Stack;

public class StackQuestions {
    private static ArrayList<Integer> nextGreaterToRight(int[] arr) {
        Stack<Integer> st= new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(st.size()==0){
                res.add(0,-1);// instead of reversing it we are adding it starting itself
            }
            if(st.size()>0 && st.peek()>arr[i]){
                res.add(0, st.peek());
            } else if (st.size()>0 && st.peek()<=arr[i]) {
                while ( st.size()>0 && st.peek()<=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res.add(0,-1);
                }else {
                    res.add(0,st.peek());
                }
            }
            st.push(arr[i]);
        }
        return res;
    }

    private static ArrayList<Integer> nextGreaterToLeft(int[] arr) {
        Stack<Integer> st= new Stack<>();
        ArrayList<Integer> res= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                res.add(-1);
            }
            if(st.size()>0 && st.peek()>arr[i]){
                res.add(st.peek());
            } else if (st.size()> 0 && st.peek()<=arr[i]) {
                while (st.size()>0 && st.peek()<= arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res.add(-1);
                }else {
                    res.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return res;
    }
    private static ArrayList<Integer> nextSmallerToLeft(int[] arr) {
        ArrayList<Integer> res= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                res.add(-1);
            }
            if(st.size()>0 && st.peek()<arr[i]){
                res.add(st.peek());
            } else if (st.size()>0 && st.peek()>=arr[i]) {
                while (st.size()>0 && st.peek()>= arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res.add(-1);
                }else {
                    res.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return res;
    }
    private static ArrayList<Integer> nextSmallerToRight(int[] arr) {
        ArrayList<Integer> res= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(st.size()==0){
                res.add(0,-1);
            }
            if(st.size()>0 && st.peek()<arr[i]){
                res.add(0,st.peek());
            } else if (st.size()>0 && st.peek()>= arr[i]) {
                while (st.size()>0 && st.peek()>= arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res.add(0,-1);
                }else {
                    res.add(0,st.peek());
                }
            }
            st.push(arr[i]);
        }
        return res;
    }

    static class Pair{
        int val;
        int index;
        Pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }

    public static int[] stockSpanProblem(int[] arr) {
        int[] res= new int[arr.length];
        Stack<Pair> st= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.size()==0){
                res[i]=-1;
            }
            if(st.size()>0 && st.peek().val>arr[i]){
                res[i]=st.peek().index;
            } else if (st.size()>0 && st.peek().val<=arr[i]) {
                while (st.size()>0 && st.peek().val<=arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=-1;
                }else {
                    res[i]=st.peek().index;
                }
            }
            st.push(new Pair(arr[i],i));
        }
        for(int i=0;i<res.length;i++){
            res[i]=i-res[i];
        }
        return res;

    }

    private static int maximumAreaOfHistogram(int[] arr) {
        int n= arr.length;
        int[] nsl=new int[n];//--next smaller to left
        int[] nsr=new int[n];//--next smaller to right
        int[] area= new int[n];
        //NSL
        Stack<Pair> st1= new Stack<>();//Pair--<val,index>
        for(int i=0;i<n;i++){
            if(st1.size()==0){
                nsl[i]=-1;
            }
            if(st1.size()>0 && st1.peek().val<arr[i]){
                nsl[i]=st1.peek().index;
            } else if (st1.size()>0 && st1.peek().val>= arr[i]) {
                while (st1.size()>0 && st1.peek().val>= arr[i]){
                    st1.pop();
                }
                if(st1.size()==0){
                    nsl[i]=-1;
                }else {
                    nsl[i]=st1.peek().index;
                }
            }
            st1.push(new Pair(arr[i],i));
        }

        //NSR
        st1.clear();
        for(int i=n-1;i>=0;i--){
            if(st1.size()==0)
                nsr[i]=n;
            if(st1.size()>0 && st1.peek().val<arr[i])
                nsr[i]=st1.peek().index;
            else if (st1.size()>0 && st1.peek().val>=arr[i]) {
                while (st1.size()>0 && st1.peek().val>= arr[i])
                    st1.pop();
                if(st1.size()==0)
                    nsr[i]=n;
                else
                    nsr[i]=st1.peek().index;
            }
            st1.push(new Pair(arr[i],i));
        }
        int mxArea= Integer.MIN_VALUE;
        //area
        for(int i=0;i<n;i++){
            area[i]=((nsr[i]-nsl[i])-1)*arr[i];
            mxArea=Math.max(mxArea,area[i]);
        }
        return mxArea;

    }

    private static int maximumAreaOfRectAngle(int[][] arr, int n, int m) {
        int max=Integer.MIN_VALUE;
        int [] temp= new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[0][i];
        }
        max=maximumAreaOfHistogram(temp);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    temp[j]=0;
                }else {
                    temp[j]+=arr[i][j];
                }
            }
            max=Math.max(max,maximumAreaOfHistogram(temp));
        }
        return max;
    }

    private static int rainWaterTrapping(int[] arr) {
        int n=arr.length;
        int maxInLeft[]= new int[n];
        int maxInRight[]=new int[n];
        int waterOnIth[]= new int[n];
        int sum=0;

        maxInLeft[0]=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>maxInLeft[i-1])
                maxInLeft[i]=arr[i];
            else
                maxInLeft[i]=maxInLeft[i-1];
        }

        maxInRight[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxInRight[i+1])
                maxInRight[i]=arr[i];
            else
                maxInRight[i]=maxInRight[i+1];
        }
        for(int i=0;i<n;i++){
            waterOnIth[i]=Integer.min(maxInRight[i],maxInLeft[i])-arr[i];
            sum+=waterOnIth[i];
        }
        return sum;
    }
    static class StackClass{

        static Stack<Integer> s= new Stack<>();
        static Stack<Integer> ss= new Stack<>();

        public void  push(int a){
            s.push(a);
            if(ss.size()==0 || ss.peek()>=a){
                ss.push(a);
            }
        }

        public int pop(){
            if(s.size()==0){
                return -1;
            }
            int res=s.peek();
            s.pop();
            if(res==ss.peek()){
                ss.pop();
            }
            return res;
        }

        public int getMin(){
            if(ss.size()==0){
                return -1;
            }
            return ss.peek();
        }

    }

    static class MinStackImpl{
        int minEle=-1;
         static Stack<Integer> s=  new Stack<>();

        public void push(int a){
            if(s.size()==0){
                s.push(a);
                minEle=a;
            } else {
                if(a>=minEle){
                    s.push(a);
                }else if(a<minEle) {
                    s.push((2*a)-minEle);
                    minEle=a;
                }
            }
        }

        public int pop(){
            if(s.size()==0){
                return -1;
            }
            if(s.peek()>=minEle){
                return s.pop();
            } else if (s.peek()<minEle) {
                int ans=minEle;
                minEle=(2*minEle)-s.peek();
                s.pop();
                return  ans;
            }
            return -1;
        }

        public int top(){
            if(s.size()==0){
                return -1;
            } else if (s.peek()>= minEle) {
                return s.peek();
            } else if (s.peek()<minEle) {
                return  minEle;
            }
            return -1;
        }

        public int getMinEle(){
            if(s.size()==0){
                return -1;
            }
            return minEle;
        }
    }
    
    public static void main(String args[]){

        //next largest/Greater element to right
//        int arr[]={1,3,2,4};
//        ArrayList<Integer> res=nextGreaterToRight(arr);
//        System.out.println(res);

        //next largest/greater to left
//        int arr[]={1,3,2,4};
//        ArrayList<Integer> res= nextGreaterToLeft(arr);
//        System.out.println(res);

        //next smaller to left
//        int arr[]={4,5,2,10,8};
//        ArrayList<Integer> res= nextSmallerToLeft(arr);
//        System.out.println(res);

        //next smaller to right
//        int arr[]={4,5,10,2,8};
//        ArrayList<Integer> res= nextSmallerToRight(arr);
//        System.out.println(res);

        //stock span problem---for each day find the consecutive smaller or equal to before that day//--- smaller to the left
//        int arr[]={100,80,60,70,60,75,85};
//       int [] res= stockSpanProblem(arr);
//        for(int x :res){
//            System.out.print(x+" ");
//        }


        //Maximum area Of Histogram
//        int arr[]={6,2,5,4,5,1,6};
//        System.out.println(maximumAreaOfHistogram(arr));

        //Maximum area Of rectangle
//        int [][] arr={{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
//        int n= arr.length;
//        int m=arr[0].length;
//        System.out.println(maximumAreaOfRectAngle(arr,n,m));

        //Rain water trapping
//        int arr[]={3,0,0,2,0,4};
//        System.out.println(rainWaterTrapping(arr));

        //Implementing min stack with extra space
//        StackClass st= new StackClass();
//        st.push(18);
//        st.push(19);
//        System.out.println(st.getMin());
//        st.push(29);
//        st.push(15);
//        System.out.println(st.getMin());
//        System.out.println(st.pop());
//        System.out.println(st.getMin());
//        st.push(16);
//        System.out.println(st.getMin());
//        System.out.println(st.pop());
//        System.out.println(st.getMin());

        //Implementing min stack without extra space
        MinStackImpl minSt= new MinStackImpl();
        minSt.push(5);
        System.out.println(minSt.minEle);
        minSt.push(7);
        System.out.println(minSt.top());
        minSt.push(3);
        System.out.println(minSt.getMinEle());
        minSt.pop();
        System.out.println(minSt.getMinEle());



    }




}
