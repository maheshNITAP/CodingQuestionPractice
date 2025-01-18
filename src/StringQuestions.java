public class StringQuestions {
    //String used functions
    //Integer to String---->String s=Integer.toString(123);
    //print subArray from index i to some length ---->String.valueOf(s,0,ind)
    //String to charArray---> char ch[]=s.toCharArray()
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
        int n=1994;
        System.out.println(sq.integerToRoman(n));
    }

}
