import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Recursion1 {
    private static void printNumbers(int n) {
        if(n==0){
            return;
        }
        System.out.println(n);
        printNumbers(n-1);

    }
    public static void printSum(int i, int n, int sum){
        if(i==n){
            sum+=i;
            System.out.println(sum);
            return;
        }
        sum+=i;
        printSum(i+1,n,sum);
    }
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int calcPower(int x,int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(n%2==0){
            return calcPower(x,n/2)*calcPower(x,n/2);
        }else{
            return calcPower(x,n/2)* calcPower(x,n/2)*x;
        }
    }
    public static void towerOfHanoi(int n, String source, String helper, String destination){

        if(n==1){
            System.out.println("transfer disk frome "+ source+" to "+ destination);
            return;
        }
        towerOfHanoi(n-1,source,destination,helper);
        System.out.println("transfer disk frome "+ source+" to "+ destination);
        towerOfHanoi(n-1,helper,source,destination);
    }
    public static void reverseString(String s, int i){
        if(i== s.length()){
            return;
        }
        reverseString(s,i+1);
        System.out.println(s.charAt(i));
    }
    public static int first= -1;
    public static int last= -1;

    public static void firstAndLastOccurance(String str, int i,char element){
        if(i==str.length()){
            System.out.println("first occurance of a is at : "+first);
            System.out.println("last occurance of a is at : "+ last);
            return;
        }
        if(element == str.charAt(i)){
            if(first==-1){
                first=i;
            }
            last=i;
        }
        firstAndLastOccurance(str,i+1,element);
    }

    public static boolean isSorted(int[] arr, int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]<arr[i+1]){
            return isSorted(arr,i+1);
        }else {
            return false;
        }
    }
    public static StringBuilder s= new StringBuilder("");
    public static int count =0;
    public  static void movingxToEndOfString(String str,int i){
        if(i==str.length()){
            while (count>0){
                s.append("x");
                count--;
            }
            System.out.println(s);
            return;
        }
        if(str.charAt(i) != 'x'){
            s.append(str.charAt(i));
            count++;
        }
        movingxToEndOfString(str,i+1);
    }
    public static boolean[] arr = new boolean[26];
    public static StringBuilder strng = new StringBuilder("");
    public static void removeDuplicate(String str,int idx){
        if(idx== str.length()){
            System.out.println("String is "+ strng);
            return;
        }
        if(!arr[str.charAt(idx)-'a']){
            strng.append(str.charAt(idx));
            arr[str.charAt(idx)-'a']=true;
        }
        removeDuplicate(str,idx+1);
    }
     public static void subSequences(String str,int indx, String newString){
        if(indx == str.length()){
            System.out.println(newString);
            return;
        }
        subSequences(str,indx+1,newString+str.charAt(indx));
        subSequences(str,indx+1,newString);
     }
     public static void uniqueSubSequences(String str, int indx, String newString, HashSet<String> set){
        if(indx == str.length()){
            if(set.contains(newString)){
                return;
            }else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
         uniqueSubSequences(str,indx+1,newString+str.charAt(indx),set);
        uniqueSubSequences(str,indx+1,newString,set);
     }

     public static String[] keypad= {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKeyboardCombination(String str,int indx,String combination){

        if(indx == str.length()){
            System.out.println(combination);
            return;
        }
        String mapping = keypad[str.charAt(indx)-'0'];
        for(int i=0;i<mapping.length();i++){
            printKeyboardCombination(str,indx+1,combination+mapping.charAt(i));
        }
    }
    public static  void permutationesOfString(String str,String permutation){
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }
        for(int i=0;i<str.length();i++){
            String newString= str.substring(0,i)+str.substring(i+1);
            permutationesOfString(newString, permutation+str.charAt(i));
        }
    }
    public static int countPathInMaze(int i,int j,int n,int m){
            if(i==n || j==m){
                return 0;
            }
            if(i==n-1 && j==m-1){
                return 1;
            }
            int dawnPaths =countPathInMaze(i+1,j,n,m);
            int rightPaths= countPathInMaze(i,j+1,n,m);
            return dawnPaths+rightPaths;
    }
    public static int placeTiles(int n,int m){
        if(n==m) return 2;
        if(n<m) return 1;
        //vertical placement of tiles
        int verticalPlacements= placeTiles(n-m,m);
        //horizontal placement of tiles
        int horizontalPlacements= placeTiles(n-1,m);
        return verticalPlacements+horizontalPlacements;
    }

    public static int calWaysToCallGuest(int n){
        if(n<=1) return 1;
        //single
        int inviteOnly1= calWaysToCallGuest(n-1);
        //pair
        int invitePairOfguest= (n-1)* calWaysToCallGuest(n-2);
        return inviteOnly1+invitePairOfguest;
    }

    public static void printSubset(ArrayList<Integer> subSet){
        for (int i=0;i<subSet.size();i++){
            System.out.print(subSet.get(i)+" ");
        }
        System.out.println();
    }

    //find subset Of string
    public static void findSubsets(int n, ArrayList<Integer> subset){
        if(n==0){
           printSubset(subset) ;
           return;
        }
        subset.add(n);
        findSubsets(n-1,subset);
        subset.remove(subset.size()-1);
        findSubsets(n-1,subset);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
//        int n= sc.nextInt();
//        String str= sc.nextLine();

//        printNumbers(n);
//        printSum(0,n,0);
//        System.out.println(factorial(n));
//        System.out.println(calcPower(2,5));
//        towerOfHanoi(n,"s","h","d");
//        reverseString(s,0);
//        firstAndLastOccurance(str,0,'a');
//        int[] arr= {1,2,7,4,5};
//        System.out.println(isSorted(arr,0));
//        movingxToEndOfString(str,0);
//          removeDuplicate(str, 0);
//        subSequences(str, 0, "");
//        HashSet<String> set = new HashSet<>();
//        uniqueSubSequences(str,0,"",set);
//        printKeyboardCombination(str,0,"");
//        permutationesOfString(str,"");
//        System.out.println(countPathInMaze(0,0,3,3));
//        System.out.println(placeTiles(4,2));
//        System.out.println(calWaysToCallGuest(4));
        ArrayList<Integer> subSet= new ArrayList<>();
        findSubsets(4,subSet);

    }


}
