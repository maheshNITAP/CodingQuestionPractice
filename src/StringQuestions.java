public class StringQuestions {
    //String used functions
    //Integer to String---->String s=Integer.toString(123);
    //print subArray from index i to some length ---->String.valueOf(s,0,ind)
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
                    for(int k=0;k<s.length();k++){
                        chars[index++]=s.charAt(k);
                    }
                }
            }
            return index;
        }
    }
    public static void main(String args[]){
        SQ sq= new SQ();

        //String Compression-------leetcode--443
        char[] s={'a','a','a','b','b','c','d','d','d','d'};
        int ind=sq.stringCompression(s);
        System.out.println("size of ans is :"+ind+" ans string is :"+String.valueOf(s,0,ind));
    }

}
