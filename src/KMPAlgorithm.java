import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

    private ArrayList<Integer> searchPatterByKMPAlgorithm(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        int lps[]= new int[m];
        lpsForPattern(pattern,m,lps);

        ArrayList<Integer> res=new ArrayList<>();

        int i=0, j=0;
        while (i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                res.add(i-j);//do +1 if they ask 1 based indexing (i-j+1)
                j=lps[j-1];
            } else if (pattern.charAt(j)!=text.charAt(i)) {
                if(j!=0){
                    j=lps[j-1];
                }else
                    i++;
            }
        }
        return res;


    }

    private void lpsForPattern(String pattern, int m, int[] lps) {
        int length=0;
        int i=1;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }else{
                if(length!=0){
                    length=lps[length-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
    }

    public static void main(String args[]){
        KMPAlgorithm kmpAlgorithm= new KMPAlgorithm();
        String txt = "aabaacaadaabaaba", pat = "aaba";
        System.out.println(kmpAlgorithm.searchPatterByKMPAlgorithm(txt,pat));
    }


}
