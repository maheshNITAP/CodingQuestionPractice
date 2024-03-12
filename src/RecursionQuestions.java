import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RecursionQuestions {
    //sort an array using recursion
    public static void sortArray(ArrayList<Integer> arr){
        if(arr.size()==1){
            return;
        }
        int val=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        sortArray(arr);
        insertInArray(arr,val);
    }
    public static void insertInArray(ArrayList<Integer> arr, int val){
        if(arr.size()==0 || arr.get(arr.size()-1)<=val){
            arr.add(val);
            return;
        }
        int temp=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        insertInArray(arr,val);
        arr.add(temp);
        return;
    }

    //sort stack in desc Order
    public static void sortStackInDescOrder(Stack<Integer> st){
        if(st.size() ==1){
            return;
        }
        int val= st.peek();
        st.pop();
        sortStackInDescOrder(st);
        insertInStackInDescOrder(st,val);

    }
    public static void insertInStackInDescOrder(Stack<Integer> st, int val){
        if(st.size()==0 || st.peek()<= val){
            st.push(val);
            return;
        }
        int temp= st.pop();
        insertInStackInDescOrder(st,val);
        st.push(temp);
    }

    //sort stack in Asc Order
    public static void sortStackInAscOrder(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int val=st.pop();
        sortStackInAscOrder(st);
        insertInStackInAscOrder(st,val);
    }
    public static void insertInStackInAscOrder(Stack<Integer> st,int val){
        if(st.size()==0 || st.peek()>=val){
            st.push(val);
            return;
        }
        int temp=st.pop();
        insertInStackInAscOrder(st,val);
        st.push(temp);
    }

//Delete Middle Element Of stack
    public static void deleteMiddleElementOfStack(Stack<Integer> st){
        if(st.size()==0){
            return;
        }
        int k=st.size()/2;
        solveDeleteMiddleOfStack(st,k);
    }
    public static void solveDeleteMiddleOfStack(Stack<Integer> st, int k){
        if(k==0){
            st.pop();
            return;
        }
        int temp=st.pop();
        solveDeleteMiddleOfStack(st,--k);
        st.push(temp);
    }

    public static void insertInStack(Stack<Integer> st,int val){
        if(st.size()==0){
            st.push(val);
            return;
        }
        int currEle= st.pop();
        insertInStack(st,val);
        st.push(currEle);

    }

    //reverse a stack
    public static void  reverseStack(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int temp = st.pop();
        reverseStack(st);
        insertInStack(st,temp);
    }
    public static void stringSubSet(String s,String ans, int i){
        if(i== s.length()-1){
            System.out.println(ans);
            return;
        }
        stringSubSet(s,ans+s.charAt(i),i+1);
        stringSubSet(s,ans,i+1);
    }
    public static void subSetOfString(String s){
        if(s.length()==0){
            return;
        }
        stringSubSet(s,"",0);
    }

    //tower of hanoi
    public static void towerOfHanoi(int n,int source,int helper,int destination){
        if(n==1){
            System.out.println("transfer disk from "+source+ " to "+ destination);
            return;
        }
        towerOfHanoi(n-1,source,destination,helper);
        System.out.println("transfer disk from "+ source+ " to"+ destination);
        towerOfHanoi(n-1,helper,source,destination);
    }

    //Kth symbol in grammar
    public static int kthSymbolInGrammer(int N,int K){
        if(N==1 || K==1){
            return 0;
        }
        int mid= (int) (Math.pow(2,N-1)/2);
        if(K<=mid){
            return kthSymbolInGrammer(N-1,K);
        } else {
            return kthSymbolInGrammer(N-1,K-mid)==0 ? 1:0;
        }
    }

    //Permutation with spaces
    public static void permutationWithSpaces(String s, String ans ,int i){
        if(i==s.length()){
            System.out.println(ans);
            return;
        }
        permutationWithSpaces(s,ans+"_"+s.charAt(i),i+1);
        permutationWithSpaces(s,ans+s.charAt(i),i+1);
    }

    public static void  uniqueSubsets(String s,String ans, int i, HashSet<String > set){
        if(i== s.length()){
            set.add(ans);
            return;
        }
        uniqueSubsets(s,ans+s.charAt(i),i+1,set);
        uniqueSubsets(s,ans,i+1,set);
    }
    public static void printUniqueSubset(String s){
        HashSet<String> set= new HashSet<>();
        uniqueSubsets(s,"",0,set);
        System.out.println(set);;
    }
    
    //permutation with case change
    public static  void permutationWithCaseChange(String s, String ans, int i){
        if(i== s.length()){
            System.out.println(ans);
            return;
        }
        permutationWithCaseChange(s,ans+Character.toUpperCase(s.charAt(i)),i+1);
        permutationWithCaseChange(s,ans+Character.toLowerCase(s.charAt(i)),i+1);
        
    }

    //Letter Case Permutation

    public static void letterCasePermutation(String s, String ans ,int i){
        if(i==s.length()){
            System.out.println(ans);
            return;
        }
        if(Character.isDigit(s.charAt(i))){
            letterCasePermutation(s,ans+s.charAt(i),i+1);
        }else {
            letterCasePermutation(s,ans+Character.toUpperCase(s.charAt(i)),i+1);
            letterCasePermutation(s,ans+Character.toLowerCase(s.charAt(i)),i+1);
        }
    }
    public static void balancedParentheses(int open,int close,String ans){
        if(open==0 && close==0){
            System.out.println(ans);
            return;
        }
        if(open!=0){
            balancedParentheses(open-1,close,ans+"(");
        }
        if(close>open){//it means open phle se jyada use ho rkha h to closed use kr skte h
            balancedParentheses(open,close-1,ans+")");
        }
    }

    //generate All Balanced Parentheses
    public static void generateAllBalancedParentheses(int n){
        int open,close;
        open=close=n;
        ArrayList<String> res = new ArrayList<>();
        balancedParentheses(open,close,"");
    }
    public static void binaryNumbers(int n,int one,int zero,String ans){
        if(n==0){
            System.out.println(ans);
            return;
        }
        binaryNumbers(n-1,one+1,zero,ans+"1");
        if(one>zero){
            binaryNumbers(n-1,one,zero+1,ans+"0");
        }
    }
    //print N bit binary numbers where  # Of digit 1's>= # of digit 0's
    public static void printNBitBinaryNumbers(int n){
        int one=0;
        int zero=0;
        binaryNumbers(n,one,zero,"");
    }

    public static void josephusProblemRecursive(ArrayList<Integer> arr,int index,int K){
        if(arr.size()==1){
            System.out.println(arr.get(0));
            return;
        }
        index= (index+(K-1))%arr.size();
        arr.remove(index);
        josephusProblemRecursive(arr,index,K);
    }
    public static void josephusProblem(ArrayList<Integer> arr,int K){
        int index=0;
        josephusProblemRecursive(arr,index,K);
    }
    public static void main(String args[]){
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(5);
//        arr.add(3);
//        arr.add(7);
//        arr.add(2);
//        arr.add(9);
//        arr.add(1);
//        sortArray(arr);
//        for(int i=0;i< arr.size();i++){
//            System.out.print(arr.get(i)+" ");
//        }
        Stack<Integer> st= new Stack<>();
        st.push(5);
        st.push(3);
        st.push(7);
        st.push(2);
        st.push(9);
        st.push(4);
        st.push(8);
//        sortStackInDescOrder(st);
//        while (!st.isEmpty()){
//            System.out.print(st.pop()+" ");
//        }

//        sortStackInAscOrder(st);
//        while (!st.isEmpty()){
//            System.out.print(st.pop()+" ");
//        }

//        deleteMiddleElementOfStack(st);
//        while (!st.isEmpty()){
//            System.out.print(st.pop()+" ");
//        }
//        reverseStack(st);
//        while (!st.isEmpty()){
//            System.out.print(st.pop()+" ");
//        }


//        Scanner sc= new Scanner(System.in);
//        String s= sc.nextLine();
//        subSetOfString(s);

//        Scanner sc= new Scanner(System.in);
//        int n= sc.nextInt();
//        towerOfHanoi(n,1,2,3);

//        System.out.println(kthSymbolInGrammer(3,8));

//        Scanner sc= new Scanner(System.in);
//        String s= sc.nextLine();
//        permutationWithSpaces(s,s.substring(0,1),1);

//        Scanner sc= new Scanner(System.in);
//        String s= sc.nextLine();
//        printUniqueSubset(s);

//         Scanner sc = new Scanner(System.in);
//         String s= sc.nextLine();
//         permutationWithCaseChange(s,"",0);

//        Scanner sc= new Scanner(System.in);
//        String s= sc.nextLine();
//        letterCasePermutation(s,"",0);

//        generateAllBalancedParentheses(3);

//        printNBitBinaryNumbers(5);

        ArrayList<Integer> arr= new ArrayList<>(40);
        for (int i=1;i<=5;i++){
            arr.add(i);
        }
        josephusProblem(arr,2);


    }
}
