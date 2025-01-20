import java.util.ArrayList;
import java.util.Arrays;

public class StringQuestions {
    //String used functions
    //Integer to String---->String s=Integer.toString(123);
    //print subArray from index i to some length ---->String.valueOf(s,0,ind)
    //String to charArray---> char ch[]=s.toCharArray()
//    In Java, the equals() method for StringBuilder does not compare the content of the strings; instead, it checks for reference equality. This means that even if two StringBuilder instances contain the same sequence of characters, equals() will return false unless they are the same object.
//    String temp=s.substring(i)+s.substring(0,i);
//    s.substring(i)--string starting for i to end of string
    //s.substring(0,i)--starting from 0 to i-1, ith will will not be included

    //compare string
//    String s= "baaca";
//    String res=s;
//    String temp=s.substring(i)+s.substring(0,i);
//     if(temp.compareTo(res)<0){
//        res=temp;
//    }

    //ans.deleteCharAt(ans.length()-1)

    //Compare Arrays values
//    Arrays.equals(freq1,freq2);





    static class SQ{

        public int stringCompression(char[] chars) {
            int n=chars.length;
            int index=0;
            int i=0;

            while(i<n){
                char currChar=chars[i];
                int currCount=0;

                while(i<n && currChar==chars[i]){
                    currCount++;
                    i++;
                }
                chars[index++]=currChar;
                if(currCount>1){
                    String s=Integer.toString(currCount);
//                    for(int k=0;k<s.length();k++){
//                        chars[index++]=s.charAt(k);
//                    }
                    for(char c:s.toCharArray())
                        chars[index++]=c;
                }
            }
            return index;
        }

        public boolean checkIfTheSentenceIsPangram(String s) {
            int hash[]= new int[26];
            int count=0;
            for(int i=0;i<s.length();i++){
                hash[s.charAt(i)-'a']++;
                if(hash[s.charAt(i)-'a']==1){
                    count++;
                    if(count==26)
                        return true;
                }
            }
            return false;
        }

        public String countAndSay(int n) {
            if(n==1) return  "1";
            String say=countAndSay(n-1);

            int i= 0;
            int len=say.length();
            StringBuilder ans= new StringBuilder();
            while(i<len){
                int count=0;
                char curr_ch= say.charAt(i);
                while(i<len && curr_ch== say.charAt(i)){
                    count++;
                    i++;
                }
                ans.append(Integer.toString(count));
                ans.append(curr_ch);
            }
            return ans.toString();
        }

        public String integerToRoman(int n) {
            int nums[]={ 1000,900, 500,400, 100,90,50,40,10,9,5,4,1};
            String val[]={"M", "CM", "D","CD", "C", "XC", "L", "XL", "X", "IX","V", "IV", "I"};
            StringBuilder ans= new StringBuilder();
            for(int i=0;i< nums.length;i++){
                if(n==0) break;
                if(n>=nums[i]){
                    int times=n/nums[i];
                    n=n%nums[i];
                    while(times-->0){
                        ans.append(val[i]);
                    }
                }
            }
            return ans.toString();
        }

        public boolean checkIfTwoArraysAreEquivalent(String[] word1, String[] word2) {
            StringBuilder w1=new StringBuilder();
            StringBuilder w2=new StringBuilder();
            for(int i=0;i< word1.length;i++){
                w1.append(word1[i]);
            }
            for(int i=0;i< word2.length;i++){
                w2.append(word2[i]);
            }
            return w1.toString().equals(w2.toString());
        }

        public boolean checkIfTwoArraysAreEquivalentApproach2(String[] word1, String[] word2) {
            int n= word1.length;
            int m= word2.length;
            int w1i=0,w2i=0;
            int i=0,j=0;
            while(w1i<n && w2i<m){
                if(word1[w1i].charAt(i)!=word2[w2i].charAt(j))
                    return false;
                i++;
                j++;
                if(i==word1[w1i].length()){
                    w1i++;
                    i=0;
                }
                if(j==word2[w2i].length()){
                    w2i++;
                    j=0;
                }
            }
            if(w1i==n && w2i==m)
                return true;
            return false;
        }

        public String orderlyQueue(String s, int k) {
            if(k>1){
                char chars[]= s.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }
            String res=s;
            int n=s.length();
            for(int i=1;i<n;i++){
                String temp=s.substring(i)+s.substring(0,i);
                if(temp.compareTo(res)<0){
                    res=temp;
                }
            }
            return res;
        }

        public String makeTheStringGreat(String s) {
            int n=s.length();
            if(n<=1)
                return s;

            StringBuilder ans= new StringBuilder();
            ans.append(s.charAt(0));
            for(int i=1;i<n;i++){
                if(ans.length()>0 && (s.charAt(i)+32 ==ans.charAt(ans.length()-1) || s.charAt(i)-32==ans.charAt(ans.length()-1))){
                    ans.deleteCharAt(ans.length()-1);
                }else {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();

        }

        public boolean checkIfStringHalvesAreAlike(String s) {
            int i=0,j=s.length()-1,leftCount=0,rightCount=0;
            while(i<j){
                if(isVowel(s.charAt(i)))
                    leftCount++;
                if(isVowel(s.charAt(j)))
                    rightCount++;
                i++;
                j--;
            }
            return leftCount==rightCount;
        }

        private boolean isVowel(char ch) {
            if(ch =='a' || ch =='e' || ch =='i' || ch =='i' || ch =='u' || ch =='A' || ch =='E' || ch =='I' || ch =='O' || ch =='U')
                return true;
            return false;

        }

        public boolean checkIfTwoStringsAreClose(String word1, String word2) {
            int freq1[]= new int[26];
            int freq2[]=new int[26];
            int n=word1.length();
            int m=word2.length();
            if(n!=m) return false;
            for(int i=0;i<n;i++){
                freq1[word1.charAt(i)-'a']++;
                freq2[word2.charAt(i)-'a']++;
            }
            //1st point--jo char word 1 main h vo word 2 main bhi hona chiye
            for(int i=0;i<26;i++){
                if(freq1[i]!=0 && freq2[i]!=0) continue;
                if(freq1[i]==0 && freq2[i]==0) continue;
                return false;
            }

            //2nd point--frequency should match---mtlb kis character ki h vo nhi dekhnapa pr number should match
            Arrays.sort(freq1);
            Arrays.sort(freq2);
            return  Arrays.equals(freq1,freq2);
        }
    }
    public static void main(String args[]){
        SQ sq= new SQ();

        //String Compression-------leetcode--443
//        char[] s={'a','a','a','b','b','c','d','d','d','d'};
//        int ind=sq.stringCompression(s);
//        System.out.println("size of ans is :"+ind+" ans string is :"+String.valueOf(s,0,ind));

//        Check if the Sentence Is Pangram

//        String s="thequickbrownfoxjumpsoverthelazydog"
//        String s="leetcode";
//        System.out.println(sq.checkIfTheSentenceIsPangram(s));

        //Count and Say

//        int n=5;
//        System.out.println(sq.countAndSay(n));

        //Integer to Roman
//        int n=1994;
//        System.out.println(sq.integerToRoman(n));

        //Check if two Arrays Are Equivalent

//        String word1[]= {"a", "bc"};
//        String word2[]={"ab", "c"};

        //Approach1 with string concatenation
//        System.out.println(sq.checkIfTwoArraysAreEquivalent(word1,word2));

//        System.out.println(sq.checkIfTwoArraysAreEquivalentApproach2(word1,word2));

        //Orderly Queue

//        String s= "ceabd";
//        int k=1;
//        String s= "cba";
//        int k=1;

//        String s= "baaca";
//        int k=3;
//        System.out.println(sq.orderlyQueue(s,k));

        //Make the string great
//        String s="leEeetcode";
        //String s="abBACc";
//        System.out.println(sq.makeTheStringGreat(s));

        //Determine if String Halves are alike
//        String s="book";
//        String s= "textbook";
//        System.out.println(sq.checkIfStringHalvesAreAlike(s));

        //Determine If two Strings are close
        String word1="cabbba", word2="abbccc";
        System.out.println(sq.checkIfTwoStringsAreClose(word1,word2));



    }

}
