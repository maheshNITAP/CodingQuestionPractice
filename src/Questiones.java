import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Questiones {

    //cout number of pairs who's sum is < taregt
    public int countPairs(List<Integer> nums, int target){
        int count=0;
        Collections.sort(nums);
        int i=0;
        int j=nums.size()-1;
        while(i<j){
            if(nums.get(i)+nums.get(j)<target){
                count+=j-i;
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
    class Pair implements Comparable<Pair>{
        int data;
        int index;

        Pair(int data,int ind){
            this.data=data;
            this.index=ind;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.data-this.data;
        }
    }
    public ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        // Your code here
        PriorityQueue<Pair> maxPq= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            maxPq.add(new Pair(arr[i],i));
        }
        ans.add(maxPq.peek().data);
        for(int i=k;i<n;i++){
            maxPq.add(new Pair(arr[i], i));

            while (maxPq.peek().index<=i-k){
                maxPq.remove();
            }
            ans.add(maxPq.peek().data);
        }
        return ans;
    }

    public int minimumSum(int num) {
        ArrayList<Integer> arr=new ArrayList<>();
        int r;
        while(num!=0){
            r=num%10;
            arr.add(r);
            num=num/10;
        }
        Collections.sort(arr);
        int first=(arr.get(0)*10)+(arr.get(2));
        int sec=(arr.get(1)*10)+(arr.get(3));
        return first+sec;
    }



    public static void main(String args[]){
        Questiones q= new Questiones();
        System.out.println(q.minimumSum(2932));

    }
}
