import javafx.util.Pair;

import java.util.Stack;

public class StockSpanner {
    Stack<Pair<Integer,Integer>> st= new Stack<>();//we are using pair as we don't have aray of integer so we need to
    // maintain array element also and their index also <<value,Index>>
    int ind=-1;
    public StockSpanner(){
        ind=-1;
        st.clear();
    }
    public int next(int val){
        ind=ind+1;
        int ans=-1;
        while(!st.isEmpty() && st.peek().getKey()<=val)
            st.pop();
        ans=ind -(st.isEmpty()?-1:st.peek().getValue());
        st.push(new Pair<>(val,ind));
        return ans;

    }

    public static void main(String args[]){
        StockSpanner st= new StockSpanner();
        System.out.println(st.next(7));
        System.out.println(st.next(2));
        System.out.println(st.next(1));
        System.out.println(st.next(3));
        System.out.println(st.next(3));
        System.out.println(st.next(1));
        System.out.println(st.next(8));


    }
}
