import java.util.*;

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

    //Character.isUpperCase(s.charAt(0))

    //for comparing stringBuilder to string first convert stringBuilder to String than compare
//    if(newStr.toString().equals(s))





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

        public boolean detectCapitalApproach1(String s) {
            if(allCapital(s) || allSmall(s) || allSmall(s.substring(1)) )
                    return true;
            return false;
        }

        private boolean allSmall(String s) {
            for(char ch:s.toCharArray()){
                if(ch<'a' || ch >'z')
                    return false;
            }
            return true;
        }

        private boolean allCapital(String s) {
            for(char ch:s.toCharArray()){
                if(ch<'A' || ch>'Z')
                    return false;
            }
            return true;
        }

        public boolean detectCapitalUseApproach2(String s) {
            int capitalCount=0;
            for(char ch:s.toCharArray()){
                if(ch>='A' && ch<='Z')
                    capitalCount++;
            }
            if(capitalCount==0 || capitalCount==s.length())
                return true;
            if(capitalCount==1 && Character.isUpperCase(s.charAt(0)))
                return true;
            return false;
        }

        public int deleteColumnToMakeSorted(String[] strs) {
            int n= strs.length;
            int m=strs[0].length();
            int count=0;
            for(int j=0;j<m;j++){
                for(int i=1;i<n;i++){
                    if(strs[i].charAt(j)<strs[i-1].charAt(j)){
                        count++;
                        break;
                    }
                }
            }
            return count;
        }

        public ArrayList<String> restoreIpAddresses(String s) {
            int ind=0,parts=0;
            String curr="";
            int n=s.length();
            ArrayList<String> ans= new ArrayList<>();
            if(s.length()>12) return ans;
            solve(s,ind,parts,curr,n, ans);
            return ans;
        }

        private void solve(String s, int ind, int parts, String curr, int n, ArrayList<String> ans) {
            if(ind==n && parts==4){
                ans.add(curr.substring(0,curr.length()-1));
                return;
            }
            if(ind+1<=n)
                solve(s,ind+1,parts+1,curr+s.substring(ind,ind+1)+".",n ,ans);

            if(ind+2<= n && isValid(s.substring(ind,ind+2)))
                solve(s,ind+2,parts+1,curr+s.substring(ind,ind+2)+".",n,ans);

            if(ind+3<= n && isValid(s.substring(ind,ind+3)))
                solve(s,ind+3,parts+1,curr+s.substring(ind,ind+3)+".",n,ans);

        }

        private boolean isValid(String s) {
            if(s.charAt(0)=='0')
                return false;
            if(Integer.parseInt(s)<=255)
                return true;
            return false;
        }

        public ArrayList<String> findAllConcatenatedWordsInADict(String[] words) {
            Set<String> st= new HashSet<>();
            Collections.addAll(st,words);
            ArrayList<String> ans= new ArrayList<>();
            for(int i=0;i< words.length;i++){
                if(isConcatenated(words[i],st))
                    ans.add(words[i]);

            }
            return ans;
        }

        private boolean isConcatenated( String word, Set<String> st) {
            int n=word.length();
            for(int i=0;i<n;i++){
                String prefix=word.substring(0,i+1);
                String suffix=word.substring(i+1);
//                if((st.contains(prefix) && st.contains(suffix)) || (st.contains(prefix) && isConcatenated(suffix,st)))
                if(st.contains(prefix) && (st.contains(suffix) || isConcatenated(suffix,st)))
                    return true;
            }
            return false;
        }

        public int findTheIndexOfTheFirstOccurrenceInString(String haystack, String needle) {
            int m=haystack.length();
            int n=needle.length();
            for(int i=0;i<=m-n;i++){
                for(int j=0;j<m;j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j))
                        break;
                    if(j==n-1)
                        return i;
                }
            }
            return -1;
        }

        public boolean buddyStrings(String s, String goal) {
            if(s.length()!=goal.length())
                return false;
            if(s.equals(goal)){
                return checkFreq(s);
            }
            ArrayList<Integer> index= new ArrayList<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=goal.charAt(i))
                    index.add(i);
            }
            if(index.size()!=2)
                return false;
            s=swap(s,index.get(0),index.get(1));
            return s.equals(goal);
        }

        private String swap(String s, Integer i, Integer j) {
            char temp=s.charAt(i);
            StringBuilder res= new StringBuilder(s);
            res.setCharAt(i,s.charAt(j));
            res.setCharAt(j,temp);
            return res.toString();
        }

        private boolean checkFreq(String s) {
            int hash[]= new int[26];
            for(char ch:s.toCharArray()){
                hash[ch-'a']++;
                if(hash[ch-'a']>1)
                    return true;
            }
            return false;
        }

        private void swap(String s, char c, char c1) {

        }

        public int findSubStringLengthWithLargestLength(String s) {
            int res=0;
            int hash[]= new int[26];
            for(char ch:s.toCharArray())
                hash[ch-'a']++;
            for(int first ='a';first<='z';first++){
                for(int second='a'; second<='z';second++){
                    if(hash[first-'a']==0 || hash[second-'a']==0)
                        continue;
                    int firstCount=0;//F1
                    int secCount=0;//F2
                    boolean pastSecond=false;
                    for(char ch:s.toCharArray()){
                        if(ch==first) firstCount++;
                        if(ch==second) secCount++;

                        if(secCount>0){
                            res=Math.max(res,firstCount-secCount);
                        }else{
                            if(pastSecond)
                                res=Math.max(res,firstCount-1);
                        }
                        if(secCount>firstCount){
                            firstCount=0;
                            secCount=0;
                            pastSecond=true;
                        }
                    }
                }
            }
            return res;
        }

        public boolean repeatedSubStringPatters(String s) {
            int n=s.length();
            for(int l=1;l<=n/2;l++){
                if(n%l==0){
                    int times=n/l;
                    StringBuilder newStr= new StringBuilder();
                    while(times>0){
                        newStr.append(s.substring(0,l));
                        times--;
                    }
                    if(newStr.toString().equals(s))
                        return true;
                }
            }
            return false;
        }

        public ArrayList textJustification(String[] words, int maxWidth) {
            ArrayList<String> res= new ArrayList<>();
            int i=0;
            int n= words.length;
            while(i<n){
                int lettersCount=words[0].length();
                int j=i+1;
                int gaddhe=0;
                while(j<n && words[j].length()+1+gaddhe+lettersCount<=maxWidth){
                    lettersCount+=words[j].length();
                    gaddhe+=1;
                    j++;
                }
                int remaningGaddhe=maxWidth-lettersCount;

                int eachGaddheSpace= gaddhe==0 ?0:remaningGaddhe/gaddhe;
                int extraSpaceGaddhe=gaddhe==0?0 :remaningGaddhe%gaddhe;

                if(j==n){//last line left justified
                    eachGaddheSpace=1;
                    extraSpaceGaddhe=0;
                }
                res.add(findLine(i,j,eachGaddheSpace,extraSpaceGaddhe,words,maxWidth));
                i=j;
            }
            return res;
        }

        private String findLine(int i, int j, int eachGaddheSpace, int extraSpaceGaddhe, String[] words, int maxWidth) {
            StringBuilder line= new StringBuilder();
            for(int k=i;k<j;k++){
                line.append(words[k]);
                if(k==j-1)
                    continue;
                for(int z=1;z<=eachGaddheSpace;z++){
                    line.append(" ");
                }
                if(extraSpaceGaddhe>0){
                    line.append(" ");
                    extraSpaceGaddhe--;
                }
            }
            while(line.length()<maxWidth)
                line.append(" ");
            return line.toString();
        }

        public boolean isSubSequence(String s, String t) {
            int i=0;
            int j=0;
            while(i<s.length() && j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                }
                j++;
            }
            if(i==s.length())
                return true;
            return false;
        }

        private int upperBound(ArrayList<Integer> arr, int x) {
            int n=arr.size();
            int low=0,high=n-1;
            int ans=n;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr.get(mid)>x){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;

        }

        public boolean isSubSequence2(String s, String t) {
            int m=s.length();
            int n=t.length();
            HashMap<Character,ArrayList<Integer>> map= new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(t.charAt(i))){
                    map.get(t.charAt(i)).add(i);
                }else{
                    map.put(t.charAt(i),new ArrayList<>());
                    map.get(t.charAt(i)).add(i);
                }
            }

            int prev=-1;
            for(int i=0;i<m;i++){
                char ch=s.charAt(i);
                if(!map.containsKey(ch))
                    return false;
                ArrayList<Integer> indices=map.get(ch);
                int it=upperBound(indices,prev);
                if(it==indices.size())
                    return false;
                prev=it;

            }
            return true;

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
//        String word1="cabbba", word2="abbccc";
//        System.out.println(sq.checkIfTwoStringsAreClose(word1,word2));

        //Detect Capital -(GOOGLE) :

//        String s="USA";
//        String s="Leetcode";
//        System.out.println(sq.detectCapitalApproach1(s));

//        System.out.println(sq.detectCapitalUseApproach2(s));

        //Delete Column to make sorted
//        String []strs = {"cba","daf","ghi"}; // O/P-1
//        String []strs = {"zyx","wvu","tsr"};//-----O/P-3
//        System.out.println(sq.deleteColumnToMakeSorted(strs));

        //Restore Ip Addresses
//        String s = "25525511135";
//        System.out.println(sq.restoreIpAddresses(s));

        //Concatenated Words
//        String words[]={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
//        System.out.println(sq.findAllConcatenatedWordsInADict(words));

        //find the index of the first occurrence in String
//        String haystack = "sadbutsad", needle = "sad";
//        System.out.println(sq.findTheIndexOfTheFirstOccurrenceInString(haystack,needle));

        //Buddy Strings
//        String s = "ab", goal = "ba";
//        System.out.println(sq.buddyStrings(s,goal));

        //subString with the largest Variance
//        String s = "aababbb";
//
//        System.out.println(sq.findSubStringLengthWithLargestLength(s));

        //Repeated SubString Pattern
//        String s = "abcabcabcabc";
//        System.out.println(sq.repeatedSubStringPatters(s));


        //Text Justification
//        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
//        int maxWidth=16;
//        System.out.println(sq.textJustification(words,maxWidth));


        //IsSubSequence--for only 1 s input
        String s="ace";
        String t="abcde";
//        System.out.println(sq.isSubSequence(s,t));

        //what if there is so many s like s1,s2,s3,s4,........ than this abouve method will be expensive
        System.out.println(sq.isSubSequence2(s,t));





    }

}
