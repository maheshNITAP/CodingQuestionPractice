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
        int arr[]={4,5,2,10,8};

        //bruteforce
        System.out.println(sq.previousSmallerElement(arr));

        //Using stack NSL
        System.out.println(sq.previousSmallerElementNSL(arr));


    }
}
