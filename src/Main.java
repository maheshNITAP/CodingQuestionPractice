import java.util.Scanner;

import static java.lang.Math.min;


public class Main {
    public static void calculateSum(int a, int b){
        System.out.println(a+b);
    }
    public static  int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return fact(n-1)*n;
    }
    public  static int GCD(int a, int b){
        int result = min(a,b);
        while (result >0){
            if(a% result ==0 && b%result==0){
                break;
            }
            result--;
        }
        return result;
    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void array1d(){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] marks= new int[n];
//        marks[0]=sc.nextInt();
//        marks[1]=sc.nextInt();
//        marks[2]=sc.nextInt();
//        for(int i=0;i<3;i++){
//            System.out.println(marks[i]);
//        }
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println(marks[i]);
        }
    }
    public static void array2D(){
        Scanner sc =new Scanner(System.in);
        int r,c;
        r=sc.nextInt();
        c=sc.nextInt();
        int[][] arr= new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void stringsCompare(){
        Scanner sc= new Scanner(System.in);
        String a = sc.nextLine();
        String b= sc.nextLine();
        if(a.compareTo(b)==0){
            System.out.println(a +" and "+ b + " are equal");
        }else {
            System.out.println("Both are not equal");
        }
    }
     public static  void stringCharAt(){
        Scanner sc= new Scanner(System.in);
        String a= sc.nextLine();
        for(int i=0;i<a.length();i++){
            System.out.print(a.charAt(i)+ " ");
        }
     }
     public static void subString(){
        Scanner sc= new Scanner(System.in);
        String a=sc.nextLine();
        String s=a.substring(9,a.length());
         System.out.println(a);
         System.out.println(s);
     }
     public static void stringBuilder(){
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder(sc.nextLine());
         System.out.println(sb);
         System.out.println(sb.charAt(2));
         sb.setCharAt(2,'p');
         System.out.println(sb);
         sb.delete(3,5);
         System.out.println(sb);
         sb.append("kkk");
         System.out.println(sb);
     }

     public static void reverseString(){
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
         System.out.println(sb);
         int i=0;
         int j=sb.length()-1;
         while (i<=j){
             char t= sb.charAt(i);
             sb.setCharAt(i,sb.charAt(j));
             sb.setCharAt(j,t);
             i++;
             j--;
         }
         System.out.println(sb);
     }
     public static void getBit(){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        // if we need to get 3rd bit then position will be 2
        int position=sc.nextInt();
        int bitMask= 1<<position;
        if((bitMask & n) ==0){
            System.out.println("Bit was 0");
        }else {
            System.out.println("Bit was 1");
        }
     }
     public static void setBit(){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
         // if we need to get 3rd bit then position will be 2
        int postion=sc.nextInt();
        int bitMask= 1<<postion;
        int newNumber= n | bitMask;
         System.out.println("the new number is "+newNumber);
     }
     public static void clearBit(){
        Scanner sc= new Scanner(System.in);
         int n= sc.nextInt();
         // if we need to get 3rd bit then position will be 2
         int postion=sc.nextInt();
         int bitMask=1 << postion;
         int notBitMask= ~(bitMask);
         int newNumber= notBitMask & n;
         System.out.println(newNumber);
     }
      public static void printArray(int [] arr){
          for(int i=0;i<arr.length;i++){
              System.out.print(arr[i]+ " ");
          }
      }
      public static void bubbleSort(){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int x: arr){
            System.out.print(x+ " ");
        }
          System.out.println();
          System.out.print("sorted array is ");
          //Bubble Sort
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swapArrayelement(arr,j,j+1);
                }
            }
        }
        printArray(arr);

      }

    private static void swapArrayelement(int[] arr, int j, int i) {
        int x= arr[j];
        arr[j]=arr[i];
        arr[i]=x;
    }
    public static  void SelectionSort(){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        printArray(arr);
        //Selection Sort
        for(int i=0;i<n-1;i++){
            int k=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[k]){
                    k=j;
                }
            }
            swapArrayelement(arr,i,k);
        }
        System.out.print("Sorted Array is ");
        printArray(arr);
    }
    public static void InsertionSort(){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        printArray(arr);
        //InsertionSort

         for(int i=1;i<arr.length;i++){
             int j=i-1;
             int x=arr[i];
             while(j > -1 &&x < arr[j]){
                 arr[j+1]= arr[j];
                 j--;
             }
             arr[j+1]=x;
         }
        System.out.println("Sorted Array is ");
         printArray(arr);
    }

    public static void main(String[] args) {
        InsertionSort();

    }
}