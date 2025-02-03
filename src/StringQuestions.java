import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.util.Pair;

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

    //if both are string builder than also you have to convert to String
//    tt.toString().equals(st.toString());


    //String []arr= s.split(" ");
//    Character.isDigit(s.charAt(i))
//    Character.isAlphabetic(s.charAt(i))
 //Character.toString(s.charAt(i))

//    String []arr= s.split(" ");
//    StringBuilder ans= new StringBuilder();
//        for(int i=0;i<arr.length;i++){
//        StringBuilder temp=new StringBuilder();
//        temp.append(arr[i]).reverse();
//        ans.append(temp+" ");
//    }
//        return ans.toString().trim();


//    num="0101";
    //Binary to Decimal Integer.parseInt(num, 2);

    //Decimal to Binary
//    Integer.toBinaryString(number)


//    Integer or long to String
    //String.valueOf(res);




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
            ch=Character.toLowerCase(ch);
            return  (ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u' );
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

        public String removeDuplicateLettres(String s) {

            boolean taken[]= new boolean[26];
            int lastIndex[]=new int[26];
            int n=s.length();
            for(int i=0;i<n;i++){
                lastIndex[s.charAt(i)-'a']=i;
            }
            StringBuilder res= new StringBuilder();
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                int indx=ch-'a';

                if(taken[indx])
                    continue;
                while(res.length()>0 && res.charAt(res.length()-1)>ch && lastIndex[res.charAt(res.length()-1)-'a']>i){
                    taken[res.charAt(res.length()-1)-'a']=false;
                    res.deleteCharAt(res.length()-1);
                }
                res.append(ch);
                taken[indx]=true;
            }
            return res.toString();
        }

        public String decodeAtIndex(String s, int k) {
            int n=s.length();
            long size=0;
            for(int i=0;i<n;i++){
                if(Character.isDigit(s.charAt(i)))
                    size=size*(s.charAt(i)-'0');
                else
                    size+=1;
            }
            for(int i=n-1;i>=0;i--){
                k= (int) (k%size);
                if(k==0 && Character.isAlphabetic(s.charAt(i)))
                    return Character.toString(s.charAt(i));

                if(Character.isAlphabetic(s.charAt(i))){
                    size-=1;
                }else
                    size=size/(s.charAt(i)-'0');
            }
            return "";

        }

        public String reverseWordsInString(String s) {
            StringTokenizer stringTokenizer= new StringTokenizer(s);
            StringBuilder res= new StringBuilder();
            while (stringTokenizer.hasMoreTokens()){
                String token=stringTokenizer.nextToken();
                StringBuilder reversedToken= new StringBuilder(token).reverse();
                res.append(reversedToken+" ");

            }
            res.trimToSize();
            return res.toString().trim();
        }

        public boolean backSpaceWithExtraQuestionsApproach1(String s, String t) {
            int n=s.length();
            int m=t.length();
            StringBuilder st= new StringBuilder();
            for(int i=0;i<n;i++){
                if(s.charAt(i)!='#')
                    st.append(s.charAt(i));
                else if(st.length()>0)
                    st.deleteCharAt(st.length()-1);

            }
            StringBuilder tt= new StringBuilder();
            for(int i=0;i<m;i++){
                if(t.charAt(i)!='#'){
                    tt.append(t.charAt(i));
                }else if(tt.length()>0)
                    tt.deleteCharAt(tt.length()-1);
            }
            return tt.toString().equals(st.toString());
        }

        public boolean backSpaceWithExtraQuestionsApproach2(String s, String t) {
            int n=s.length(),m=t.length(),t_skip=0,s_skip=0;
            int i=n-1,j=m-1;
            while(i>=0 || j>=0){

                while(i>=0){
                    if(s.charAt(i)=='#'){
                        s_skip++;
                        i--;
                    }else if(s_skip>0){
                        s_skip--;
                        i--;
                    }else
                        break;
                }

                while(j>=0){
                    if(t.charAt(j)=='#'){
                        t_skip++;
                        j--;
                    }else if(t_skip>0){
                        t_skip--;
                        j--;
                    }else break;
                }

                char first=i<0 ?'$':s.charAt(i);
                char sec=j<0 ? '$':t.charAt(j);
                if(first!=sec)
                    return false;
                i--;
                j--;
            }
            return true;
        }

        public int countTheNumberOfHomogenousSubString(String s) {
            int n=s.length();
            int len=0;
            int res=0;
            for(int i=0;i<n;i++){
                if( i>0 && s.charAt(i)==s.charAt(i-1))
                    len+=1;
                else
                    len=1;
                res+=len;
            }
            return res;
        }

        public String sortVowelsInAString(String s) {
            StringBuilder res= new StringBuilder(s);
            StringBuilder temp= new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(isVowel(s.charAt(i)))
                    temp.append(s.charAt(i));
            }
            char []chars=temp.toString().toCharArray();
            Arrays.sort(chars);
            int j=0;
            for(int i=0;i<res.length();i++){
                if(isVowel(res.charAt(i))){
                    res.setCharAt(i,chars[j++]);
                }
            }
            return res.toString();
        }

        public String sortVowelsInAStringApproach2(String s) {
            int n=s.length();
            HashMap<Character,Integer> map= new HashMap<>();
            String temp="AEIOUaeiou";
            int j=0;
            for(int i=0;i<n;i++){
                if(isVowel(s.charAt(i)))
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            StringBuilder res= new StringBuilder(s);
            for(int i=0;i<n;i++){
                if(isVowel(res.charAt(i))){
                    while (!map.containsKey(temp.charAt(j)))
                        j++;
                    res.setCharAt(i,temp.charAt(j));
                    map.put(temp.charAt(j),map.get(temp.charAt(j))-1);
                    if(map.get(temp.charAt(j))==0)
                        map.remove(temp.charAt(j));
                }
            }
            return res.toString();
        }

        public String findUniqueBinaryStrings(String[] nums) {
            int n=nums.length;
            HashSet<Integer> st= new HashSet<>();
            for(String num:nums){
                st.add(Integer.parseInt(num,2));
            }
            String res="";
            for(int number=0;number<=n;number++){
                if(!st.contains(number)){
                    res=Integer.toBinaryString(number);
                    while(res.length()<n){
                        res="0"+res;
                    }
                    return res;
                }
            }
            return "";
        }

        public String findUniqueBinaryStringsApproach2(String[] nums) {
            int n=nums.length;
            StringBuilder res= new StringBuilder();
            for(int i=0;i<n;i++){
                char ch=nums[i].charAt(i);
                res.append(ch=='0'?'1':'0');
            }
            return res.toString();

        }

        public int countBeautifulSubStringsBruteForce(String s, int k) {
            int res=0;
            int n=s.length();
            for(int i=0;i<n;i++){
                int vowel=0;
                int consonents=0;
                for(int j=i;j<n;j++){
                    if(isVowel(s.charAt(j)))
                        vowel++;
                    else
                        consonents++;
                    if(vowel==consonents && (vowel*consonents)%k==0)
                        res+=1;
                }
            }
            return res;
        }

        public int numberOfWaysToDivideLongCorridor(String s) {
            int n=s.length();
            ArrayList<Integer> seatIndexes= new ArrayList<>();
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='S')
                    seatIndexes.add(i);
            }
            if(seatIndexes.size()%2==0)//if odd number off seats are there then we can't divide them in sections of 2
                return 0;
            int prev_end_index=seatIndexes.get(1);
            int res=1;
            for(int i=2;i<seatIndexes.size();i+=2){
                int currSeatIndex=seatIndexes.get(i);
                res=res * (currSeatIndex-prev_end_index);
                prev_end_index=seatIndexes.get(i+1);

            }
            return res;

        }

        public int numberOfLeaserBeamsInBank(int[][] bank) {
            int n=bank.length;
            int prevDeviceCount=0;
            int res=0;
            for(int i=0;i<n;i++){
                int currDeviceCount=0;
                for(int curr:bank[i]){
                    if(curr==1)
                        currDeviceCount++;
                }
                res+=(prevDeviceCount*currDeviceCount);
                if(currDeviceCount!=0)
                    prevDeviceCount=currDeviceCount;

            }
            return res;
        }

        public int minimumNumberOfStepsToMakeAStringAnagram(String s, String t) {
            int n=s.length();
            int m=t.length();
            if(n!=m)
                return 0;
            int[] freqOfs= new int[26],freqOft= new int[26];
            for(int i=0;i<n;i++){
                freqOfs[s.charAt(i)-'a']++;
                freqOft[t.charAt(i)-'a']++;
            }
            int res=0;
            for(int i=0;i<26;i++){
                if(freqOfs[i]>freqOft[i])
                    res+=freqOfs[i]-freqOft[i];
            }
            return res;

        }

        public int minimumNumberOfStepsToMakeAStringAnagramWithOneMap(String s, String t) {//just directly store difference in map
            int n=s.length();
            int m=t.length();
            if(n!=m)
                return 0;
            int map_s[]= new int[26];
            for(int i=0;i<n;i++){
                map_s[s.charAt(i)-'a']++;
                map_s[t.charAt(i)-'a']--;
            }
            int res=0;
            for(int i=0;i<26;i++){
                if(map_s[i]>0)
                    res+=map_s[i];
            }
            return res;
        }


        public int minimumTimeToRevertWordToInitialState(String word, int k) {
            int n=word.length();
            int i=k;
            int count=1;
            while(i<n){
                if(check(word,i,n)){
                    break;
                }
                i+=k;
                count++;
            }
            return count;
    }

    //to check if that suffix is equal to prefix of that string
        private boolean check(String word, int i, int n) {
            return word.substring(0,n-i).equals(word.substring(i));
        }

        public int minimumTimeToRevertWordToInitialStateByKMP(String word, int k) {
            int n=word.length();
            int lps[]= new int[n];
            lps(word,lps,n);
            int length_suffix=lps[n-1];
            while(length_suffix>0 && (n-length_suffix)%k!=0){
                length_suffix=lps[length_suffix-1];
            }
            if((n-length_suffix)%k==0)
                return (n-length_suffix)/k;
            else
                return (int)Math.ceil(n/(double)k);
        }

        private void lps(String word, int[] lps, int n) {
            lps[0]=0;
            int length=0;
            int i=1;
            while(i<n){
                if(word.charAt(i)==word.charAt(length)){
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

        public String customSortString(String order, String s) {
            StringBuilder res= new StringBuilder();
            //using map--use when chars can be lowercase and uppercase
//            HashMap<Character, Integer> map= new HashMap<>();
//            for(char ch:s.toCharArray()){
//                map.put(ch,map.getOrDefault(ch,0)+1);
//            }
//            for(char ch:order.toCharArray()){
//                if(map.containsKey(ch)){
//                    int freq=map.get(ch);
//                    while (freq-->0){
//                        res.append(ch);
//                    }
//                    map.remove(ch);
//                }
//            }
//            for(Map.Entry<Character, Integer> e:map.entrySet()){
//                char ch=e.getKey();
//                int freq=e.getValue();
//                while (freq-->0){
//                    res.append(ch);
//                }
//                map.remove(ch);
//            }


            //if only lowercase letters are there
            int hash[]= new int[26];
            for(char ch:s.toCharArray()){
                hash[ch-'a']++;
            }
            for(char ch:order.toCharArray()){
                while (hash[ch-'a']-->0)
                    res.append(ch);
            }
            for(int i=0;i<26;i++){
                if(hash[i]>0){
                    while (hash[i]-->0)
                        res.append((char) ('a'+i));
                }
            }
            return res.toString();
        }


        public String customSortStringUsingComparator(String order, String s)  {
                Integer []index= new Integer[26];
                Arrays.fill(index,Integer.MAX_VALUE);
                for(int i=0;i<order.length();i++){
                    index[order.charAt(i)-'a']=i;
                }
                Comparator<Character> laqmbda= (ch1,ch2)-> index[ch1-'a'].compareTo(index[ch2-'a']);
                Character[] cha= new Character[s.length()];
                for(int i=0;i<s.length();i++){
                    cha[i]=s.charAt(i);
                }
                Arrays.sort(cha,laqmbda);
                StringBuilder res= new StringBuilder();
                for(Character ch:cha){
                    res.append(ch);
                }
                return res.toString();


        }

        public ArrayList<String> shortestUnCommonSubStringInAnArray(String[] arr) {
            int n= arr.length;
            ArrayList<String> res= new ArrayList<>();
            HashMap<String ,Integer> map= new HashMap<>();
            for(int i=0;i<n;i++){
                HashSet<String> seen= new HashSet<>();
                for(int s=0;s<arr[i].length();s++){
                    for(int e=s+1;e<=arr[i].length();e++){
                        String sub=arr[i].substring(s,e);
                        if(!seen.contains(sub)){
                            map.put(sub,map.getOrDefault(sub,0)+1);
                            seen.add(sub);
                        }
                    }
                }

            }
            for(String s:arr){
                String shortes="";
                for(int i=0;i<s.length();i++){
                    for(int j=i+1;j<=s.length();j++){
                        String substr=s.substring(i,j);
                        if(map.get(substr)==1 && (shortes.equals("") || substr.length()<shortes.length() || (substr.length()==shortes.length() && substr.compareTo(shortes)<0)))
                            shortes=substr;
                    }
                }
                res.add(shortes);
            }
            return res;
        }

        public int countSubStringStartingAndEndingWithGivenChar(String s, char c) {
            int prev_count=0;
            int ans=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==c){
                    ans+=1+prev_count;//1 because that char itself is a subString
                    prev_count++;
                }
            }
            return ans;
        }

        public int countSubStringStartingAndEndingWithGivenCharByMathFormula(String s, char c) {
            int count=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==c)
                    count++;
            }
            return count+(count*(count-1))/2;

        }

        public int compareVersionNumbers(String version1, String version2) {
            ArrayList<String> l1= getTokens(version1);
            ArrayList<String> l2= getTokens(version2);
            int n=l1.size();
            int m=l2.size();
            int i=0;
            while(i<n || i<m){
                int a=i<n ?Integer.parseInt(l1.get(i)):0;
                int b=i<m ?Integer.parseInt(l2.get(i)):0;
                if(a<b)
                    return -1;
                else if(b<1)
                    return  1;
                else
                    i++;
            }
            return 0;//agr koi less or greater nhi nikla to equals h
        }

        private ArrayList<String> getTokens(String version1) {
            ArrayList<String> lis= new ArrayList<>();
            StringTokenizer tokenizer= new StringTokenizer(version1,".");
            while (tokenizer.hasMoreTokens()){
                lis.add(tokenizer.nextToken());
            }
            return lis;
        }

        public int compareVersionNumbersUsingSplit(String version1, String version2) {
            String arr1[]=version1.split("\\.");//we need \\ because . is a special char in regex so to escape from that we need back slases
            String arr2[]=version2.split("\\.");
            int n= arr1.length;
            int m=arr2.length;
            int i=0;
            while(i<n || i<m){
                int a=i<n ? Integer.parseInt(arr1[i]):0;
                int b=i<m ? Integer.parseInt(arr2[i]):0;

                if(a<b)
                    return -1;
                else if(b<b)
                    return 1;
                else
                    i++;
            }
            return 0;
        }

        public int appendCharacterToStringToMakeSubsequence(String s, String t) {
            int n=s.length();
            int m=t.length();
            int i=0,j=0;
            while(i<n && j<m){
                if(s.charAt(i)==t.charAt(j))
                    j++;
                i++;
            }
            if(j==t.length())
                return 0;
            return m-j;
        }

        public ArrayList<Integer> sortJumbledApproach1(int[] mapping, int[] nums) {
            ArrayList<Pair<Integer,Integer>> temp= new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                String num=Integer.toString(nums[i]);
                StringBuilder t= new StringBuilder();
                for(int j=0;j<num.length();j++){
                    t.append(mapping[num.charAt(j)-'0']);
                }
                temp.add(new Pair<>(Integer.parseInt(t.toString()),i));
            }
            Collections.sort(temp, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

                    if (o1.getKey() > o2.getKey()) return 1;  // Move o1 after o2
                    else if (o1.getKey() < o2.getKey()) return -1; // Move o1 before o2
                    else return 0;
                }
            });
            ArrayList<Integer> res= new ArrayList<>();
            temp.stream().forEach(x->res.add(nums[x.getValue()]));
            return res;

        }

        public ArrayList<Integer> sortJumbledApproach2(int[] mapping, int[] nums) {
            ArrayList<Pair<Integer,Integer>> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                int mappedNum=getMappedNum(mapping,nums[i]);
                temp.add(new Pair<>(mappedNum,i));
            }
            Collections.sort(temp,(a,b)->{
                if(a.getKey()>b.getKey())
                    return 1;
                else if(a.getKey()<b.getKey())
                    return -1;
                return 0;
            });
            ArrayList<Integer> res= new ArrayList<>();
            temp.stream().forEach(x->res.add(nums[x.getValue()]));
            return res;

        }

        private int getMappedNum(int[] mapping, int num) {
            if(num<10)
                return mapping[num];

            int mappedNum=0;
            int placeValue=1;
            while(num>0){
                int lastDigit=num%10;
                int mappedDigit=mapping[lastDigit];
                mappedNum+=(mappedDigit*placeValue);

                placeValue*=10;
                num/=10;
            }
            return mappedNum;

        }

        public String fractionAdditionAndSubtraction(String expr) {
            int nume=0;
            int deno=1;
            int i=0;
            int n=expr.length();
            while(i<n){
                int currNum=0;
                int currDeno=0;

                boolean isNeg=expr.charAt(i)=='-';
                if(expr.charAt(i)=='+' || expr.charAt(i)=='-')
                    i++;

                //build the curr Numerator
                while(i<n && Character.isDigit(expr.charAt(i))){
                    int val=expr.charAt(i)-'0';
                    currNum=(currNum*10)+val;
                    i++;
                }

                i++; // skipping the divisor character  numerator/denominator

                if(isNeg==true)
                    currNum*=-1;

                //building the curr denominator
                while(i<n && Character.isDigit(expr.charAt(i))){
                    int val=expr.charAt(i)-'0';
                    currDeno=(currDeno*10)+val;
                    i++;
                }

                nume=nume*currDeno +currNum*deno;
                deno=deno*currDeno;
            }

            int gcd=gcd(Math.abs(nume),deno);
            nume/=gcd;
            deno/=gcd;

            return Integer.toString(nume)+"/"+Integer.toString(deno);

        }

        private int gcd(int a, int b) {
            if(b==0)
                return a;
            return gcd(a,b%a);
        }

        public String findTheClosestPalindrome(String n) {
            int len=n.length();
            int mid= len/2;

            int firstHalfLength= len%2==0? mid:mid+1;

            long firstHalf =Long.parseLong(n.substring(0,firstHalfLength));

            List<Long> possibleResult= new ArrayList<>();

            //calculate all possible res
            possibleResult.add(halfToPalindrome(firstHalf,len%2==0));
            possibleResult.add(halfToPalindrome(firstHalf+1,len%2==0));
            possibleResult.add(halfToPalindrome(firstHalf-1,len%2==0));
            possibleResult.add((long)Math.pow(10,len-1)-1);
            possibleResult.add((long)Math.pow(10,len)+1);

            //find the closest palindrome

            long diff=Long.MAX_VALUE;

            long res=0;
            Long origionalNum=Long.parseLong(n);

            for(long num:possibleResult){
                if(num==origionalNum)
                    continue;
                if(Math.abs(num-origionalNum)<diff){
                    diff=Math.abs(num-origionalNum);
                    res=num;
                }else if(Math.abs(num-origionalNum)==diff){
                    res=Math.min(res,num);
                }
            }

            return String.valueOf(res);
        }

        private Long halfToPalindrome(long firstHalf, boolean isEven) {
            long resNum=firstHalf;
            if(isEven==false)
                firstHalf/=10;

            while(firstHalf>0){
                long digit=firstHalf%10;
                resNum=(resNum*10)+digit;

                firstHalf/=10;
            }
            return resNum;
        }

        public String shortestPalindrome(String s) {
            String rev=new StringBuilder(s).reverse().toString();
            for(int i=0;i<s.length();i++){
                if(s.substring(0,s.length()-i).equals(rev.substring(i)))
                    return rev.substring(0,i)+s;
            }
            return rev+s;
        }

        public String shortestPalindromeByKMP(String s) {
            String rev=new StringBuilder(s).reverse().toString();
            String temp= s+"-"+rev;
            int N=temp.length();
            int lps[]= new int[N];
            computeLPS(temp,lps,N);

            int longestLPSLength=lps[N-1];
            return rev.substring(0,s.length()-longestLPSLength)+s;

        }

        private void computeLPS(String pattern, int[] lps, int n) {
            lps[0]=0;
            int i=1;
            int len=0;
            while(i<n){
                if(pattern.charAt(i)==pattern.charAt(len)){
                    len++;
                    lps[i]=len;
                    i++;
                }else{
                    if(len!=0){
                        len=lps[len-1];
                    }else{
                        lps[i]=0;
                        i++;
                    }
                }
            }
        }

        //Using two pointer
        public boolean sentenceSimilarity3(String s1, String s2) {
            if(s1.length()<s2.length()){
                String t=s1;
                s1=s2;
                s2=t;
            }
            String arr1[]= s1.split(" ");
            String arr2[]=s2.split(" ");

            int i=0, j=arr1.length-1;
            int k=0,l=arr2.length-1;

            while(i<arr1.length && k<arr2.length && arr1[i].equals(arr2[k])){
                k++;
                i++;
            }

            while(l>=k && arr1[j].equals(arr2[l])){
                j--;
                l--;
            }
            if(l<k)
                return true;
            return false;


        }

        public boolean sentenceSimilarity3UsingDequeue(String s1, String s2) {
            if(s1.length()<s2.length()){
                String t=s1;
                s1=s2;
                s2=t;
            }
            Deque<String> deq1= new LinkedList<>(), deq2= new LinkedList<>();
            StringTokenizer stringTokenizer= new StringTokenizer(s1, " ");
            while (stringTokenizer.hasMoreTokens()){
                deq1.add(stringTokenizer.nextToken());
            }

            StringTokenizer stringTokenizer2= new StringTokenizer(s2, " ");
            while (stringTokenizer2.hasMoreTokens()){
                deq2.add(stringTokenizer2.nextToken());
            }

            while(!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekFirst().equals(deq2.peekFirst())){
                deq1.pollFirst();
                deq2.pollFirst();
            }

            while (!deq1.isEmpty() && !deq2.isEmpty() && deq1.peekLast().equals(deq2.peekLast())){
                deq1.pollLast();
                deq2.pollLast();
            }

            if(deq2.isEmpty())
                return true;
            return false;



        }

        public int separateWhiteAndBlackBalls(String s) {
            int n=s.length();

            int swaps=0;
            int black=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    swaps+=black;
                }else
                    black++;
            }
            return swaps;
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
//        String s="ace";
//        String t="abcde";
//        System.out.println(sq.isSubSequence(s,t));

        //what if there is so many s like s1,s2,s3,s4,........ than this abouve method will be expensive
//        System.out.println(sq.isSubSequence2(s,t));


        //remove duplicate lettres and return lexicographical smallest string
        //TO DO:-- leetcode--1081
//        String s="bcabc";
//        System.out.println(sq.removeDuplicateLettres(s));


        ////Decode String At Index
//        String s = "leet2code3";
//        int k = 10;
//        System.out.println(sq.decodeAtIndex(s,k));

        //Reverse words in a string using tokenizer
//        String s = "Let's take LeetCode contest";
//        System.out.println(sq.reverseWordsInString(s));

        //Back Space String compare
//        String s="ab#c";
//        String t="ad#c";

        //with extra space Approach1
//        System.out.println(sq.backSpaceWithExtraQuestionsApproach1(s,t));

        //without extra space by traversing from reverse
//        System.out.println(sq.backSpaceWithExtraQuestionsApproach2(s,t));


        //count the number of homogenous subString
//        String s= "abbcccaa";
//        System.out.println(sq.countTheNumberOfHomogenousSubString(s));


        //sort vowels in a String'
//        String s="lEetcOde";

        //Approach with extra space and new sorting
//        System.out.println(sq.sortVowelsInAString(s));


//        System.out.println(sq.sortVowelsInAStringApproach2(s));



        //Both Approaches  are good
        //find Unique Binary Strings

//        String nums[]={"111","011","001"};
//        System.out.println(sq.findUniqueBinaryStrings(nums));

        //***** very nice approach
//        System.out.println(sq.findUniqueBinaryStringsApproach2(nums));


        //count Beautiful Substrings-1

//        String s="baeyh";
//        int k=2;

        //using Brute force
//        System.out.println(sq.countBeautifulSubStringsBruteForce(s,k));


        //Number Of ways to divide a long corridor
//        String s="SPSPPSPPSPPSS";
//        System.out.println(sq.numberOfWaysToDivideLongCorridor(s));

        //Number of Leaser Beams In a Bank

//        int bank[][]={{0,1,1,0,0,1},{0,0,0,0,0,0}, {0,1,0,1,0,0}, {0,0,1,0,0,0}};
//        System.out.println(sq.numberOfLeaserBeamsInBank(bank));

        //Minimum Number Of Steps To make two Strings Anagram
//        String s = "leetcode", t = "practice";
//        System.out.println(sq.minimumNumberOfStepsToMakeAStringAnagram(s,t));

        //with only one map array
//        System.out.println(sq.minimumNumberOfStepsToMakeAStringAnagramWithOneMap(s,t));


            //Part 1 and 2 are same only constraint change so part to wil do By KMP
        //Minimum Time To Revert Word to initial State part-1

//        String word ="abacaba";
//        int k=3;
//            int k=2;
//        System.out.println(sq.minimumTimeToRevertWordToInitialState(word,k));//O-n^2


            //Part-2 by KMP LPS
//            System.out.println(sq.minimumTimeToRevertWordToInitialStateByKMP(word,k));//O-n

            //custom sort String
//            String order="cba";
//            String s="abcd";

            //approach 1 using map and hash
//            System.out.println(sq.customSortString(order,s));

//            ..approach 2 using comparator
//            System.out.println(sq.customSortStringUsingComparator(order,s));

            //Shortest Uncommon SubString in an array

//            String arr[]={"cab","ad","bad","c"};
//            System.out.println(sq.shortestUnCommonSubStringInAnArray(arr));

            //count subString Starting and ending with given char
//            String s="abada";
//            char c='a';

//            String s="zzz";
//            char c='z';

            //approach1
//            System.out.println(sq.countSubStringStartingAndEndingWithGivenChar(s,c));

            //approach 2 using math formula
//            System.out.println(sq.countSubStringStartingAndEndingWithGivenCharByMathFormula(s,c));

            //compare version numbers
//            String version1 = "1.2", version2 = "1.10";
//            String version1 = "1.01", version2 = "1.001";

            //using tokenizer
//            System.out.println(sq.compareVersionNumbers(version1,version2));

            //Using Split
//            System.out.println(sq.compareVersionNumbersUsingSplit(version1,version2));

            //Append Characters to String to make subsequence
//            String s = "coaching", t = "coding";

//            System.out.println(sq.appendCharacterToStringToMakeSubsequence(s,t));

            //sort Jumbled
//            int []mapping = {8,9,4,0,2,1,3,5,7,6};
//            int nums[] = {991,338,38};
//            System.out.println(sq.sortJumbledApproach1(mapping,nums));

//            System.out.println(sq.sortJumbledApproach2(mapping,nums));

            //fraction addition and subtraction

//            String expr = "-1/2+1/2+1/3";

//            System.out.println(sq.fractionAdditionAndSubtraction(expr));


            //find the closest palindrome
//            String n = "123";
//            System.out.println(sq.findTheClosestPalindrome(n));

            //Shortest palindrome

//            String s="aacecaaa";
//            String s="abcd";

            //Brute force
//            System.out.println(sq.shortestPalindrome(s));


//            System.out.println(sq.shortestPalindromeByKMP(s));

            //sentence similarity-3
//            String sentence1 = "My name is Haley", sentence2 = "My Haley";
//            String sentence1 = "of", sentence2 = "A lot of words";

            //using pointer
//            System.out.println(sq.sentenceSimilarity3(sentence1,sentence2));

//            using dequeue

//            System.out.println(sq.sentenceSimilarity3UsingDequeue(sentence1,sentence2));

            //Separate white and black balls

            String s="11010";

            //left to right
            System.out.println(sq.separateWhiteAndBlackBalls(s));

    }




}
