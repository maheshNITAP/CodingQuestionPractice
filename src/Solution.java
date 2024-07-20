import java.io.*;
import java.util.*;

public class Solution {

    public static void solve(int n, int m, List<String> suffics, List<String> logs){
        String suff[]= new String[m];
        int count[]= new int[m];
        for(int i=0;i<m;i++)
            suff[i]=suffics.get(i);
        for(int i=0;i<n;i++){
            String temp=logs.get(i);
            for(int j=0;j<m;j++){
                if(temp.contains(suff[j])){
                    count[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            System.out.println(count[i]);
        }



    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //web server log
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        sc.nextLine();
        List<String> list= new LinkedList();
        for(int i=0;i<m;i++)
            list.add(sc.nextLine().trim());
        List<String> logs= new LinkedList();
        for(int i=0;i<n;i++)
            logs.add(sc.nextLine().trim());

        solve(n,m,list,logs);
    }
}