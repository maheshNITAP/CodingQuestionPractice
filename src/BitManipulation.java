import javafx.util.Pair;

import java.util.*;

public class BitManipulation {
    static class BitQuestions{

        public String convertDecimalToBinary(int n) {
            StringBuilder ans= new StringBuilder();
            while(n!=1){
                if((n&1)!=0)
                    ans.append('1');
                else
                    ans.append('0');
                n=n>>1;
            }
            if(n==1)
                ans.append('1');
            return ans.reverse().toString();
        }

        public int convertBinaryToDecimal(String n) {
            int ans=0;
            int p=1;
            for(int i=n.length()-1;i>=0;i--){
                if(n.charAt(i)=='1')
                    ans+=p;
                p=p*2;
            }
            return ans;

        }

        public void swapTwoNumbers(int a, int b) {
            System.out.println("before swap:-a is :"+a+" b is :"+b);
            a=a^b;
            b=a^b;//equals a// a i already as a^b
            a=a^b;
            System.out.println("after swap:-a is :"+a+" b is :"+b);
        }

        public int ithBitIsSetOrNot(int n, int i) {

            //using left shift
//                int res=n&(1<<i);
            //using right shift
            int res = (n>>2)&1;

                if(res!=0){
                    return 1;
                }else return 0;

        }

        public int settingTheIthBit(int n, int i) {
            return n|(1<<i);
        }

        public int settingThIthBitToZero(int n, int i) {
            return (n&(~(1<<i)));
        }

        public int toggleTheIthBit(int n, int i) {
            return n^(1<<i);
        }

        public int removeTheLastSetBit(int n) {
            return n&(n-1);
        }

        public boolean checkIfNumberIsPowerOfTwo(int n) {
            if((n&n-1)==0)
                return true;
            return false;
        }

        public int countNumberOfSetBitInGivenNumber(int n) {
            int count=0;
            while(n>1){
                if(n%2==1)
                    count++;
                n=n/2;
            }
            if(n==1)
                count++;
            return count;
        }

        public int countNumberOfSetBitInGivenNumberByBit(int n) {
            int count=0;
            while(n>1){
                if((n&1)>0)
                    count++;
                n=n>>1;
            }
            if(n==1) count++;
            return count;
        }

        public int countNumberOfSetBitInGivenNumberByBitOtherWay(int n) {
            int count=0;
            while (n!=0){
                n=n&(n-1);
                count++;
            }
            return count;
        }

        public int minBitFlipsToConvertNumber(int a, int b) {
            int count=0;
            int ans=a^b;
            while(ans!=0){
                if((ans&1)!=0)
                    count++;
                ans=ans>>1;
            }
            return count;
        }

        public List<List<Integer>> powerSet(int[] arr) {
            List<List<Integer>> ans = new ArrayList<>();
            int n=arr.length;
            int subSets=1<<n;
            for(int num=0;num<=subSets-1;num++){
                List<Integer> list= new ArrayList<>();
                for(int i=0;i<=n-1;i++){
                    if((num &(1<<i))!=0)
                        list.add(arr[i]);
                }
                ans.add(list);
            }
            return ans;
        }

        public int singleNumber1(int[] arr) {
            int XOR=0;
            for(int i=0;i<arr.length;i++)
                XOR=XOR^arr[i];
            return XOR;
        }

        public int singleNumber2BruteForce(int[] arr) {
            int ans=0;
            for(int bitIndex=0;bitIndex<32;bitIndex++){
                int count=0;
                for(int i=0;i<arr.length;i++){
                    if((arr[i] & (1<<bitIndex))!=0){
                        count++;
                    }
                }
                if(count%3==1){
                    ans= ans | (1<<bitIndex);
                }
            }
            return ans;
        }

        public int singleNumber2(int[] arr) {
            Arrays.sort(arr);
            for(int i=1;i<arr.length;i=i+3){
                if(arr[i]!=arr[i-1])
                    return arr[i-1];
            }
            return arr[arr.length-1];
        }

        public int singleNumber2BucketConcept(int[] arr) {
            int once=0,twos=0;
            for(int i=0;i<arr.length;i++){
                once=(once^arr[i]) &(~twos);
                twos=(twos^arr[i])&(~once);
            }
            return once;
        }

        public List<Integer> singleNumber3BruteForce(int[] arr) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i< arr.length;i++){
                if(map.containsKey(arr[i]))
                    map.put(arr[i],map.get(arr[i])+1);
                else
                    map.put(arr[i],1);
            }
            List<Integer> lis=new ArrayList<>();
            for(Map.Entry<Integer,Integer> m: map.entrySet()){
                if(m.getValue()==1)
                    lis.add(m.getKey());
            }
            return lis;
        }

        public Pair SingleNumber3(int[] arr) {
            long XORR=0;
            for(int i=0;i<arr.length;i++)
                XORR=XORR^arr[i];
            long rightMostSetBit=(XORR^(XORR-1))&XORR;
            int b1=0,b2=0;
            for(int i=0;i<arr.length;i++){
                if((arr[i]&rightMostSetBit)>0)
                    b1=b1^arr[i];
                else
                    b2=b2^arr[i];
            }
            return new Pair<>(b1,b2);
        }

        //brute force
        public int XOROfGivenRangeBruteForce(int n) {
            int ans=0;
            for(int i=1;i<=n;i++)
                ans=ans^i;
            return ans;
        }

        public int XOROfGivenRange(int n) {
            if(n%4==1) return 1;
            else if(n%4==2) return n+1;
            else if(n%4==3) return 0;
            return n;
        }

        public int XOROfGivenRangeBetweenLAndR(int l, int r) {
            return XOROfGivenRange(l-1)-XOROfGivenRange(r);
        }
    }
    public static void main(String args[]){
        BitQuestions bit = new BitQuestions();

        //convert decimal to binary
//        int n=7;
//        System.out.println(bit.convertDecimalToBinary(n));

        //convert binary to decimal
//        String n="1101";
//        System.out.println(bit.convertBinaryToDecimal(n));

        //swap two numbers
//        int a=5,b=7;
//        bit.swapTwoNumbers(a,b);

        //Check if I^th bit is set or not
//        int n=13;
//        int i=2;
//        System.out.println(bit.ithBitIsSetOrNot(n,i));

        //setting the ith bit as 1
//        int n=9; int i=2;
//        System.out.println(bit.settingTheIthBit(n,i));

        //setting that ith bit as 0
//        int n=13;int i=2;
//        System.out.println(bit.settingThIthBitToZero(n,i));

        //toggle the ith bit
//        System.out.println(bit.toggleTheIthBit(n,i));

        //remove the last set bit
//        System.out.println(bit.removeTheLastSetBit(n));

        //check if the number is power of 2 or not
//        int n=13;
//        System.out.println(bit.checkIfNumberIsPowerOfTwo(n));

        //count number of set bits by normally
//        System.out.println(bit.countNumberOfSetBitInGivenNumber(n));

        //count  number of bit by bit manipulation
//        System.out.println(bit.countNumberOfSetBitInGivenNumberByBit(n));

        //count  number of bit by bit manipulation
//        System.out.println(bit.countNumberOfSetBitInGivenNumberByBitOtherWay(n));

        //Minimum bit flips to convert to Number a to b
//        int a=10,b=7;
//        System.out.println(bit.minBitFlipsToConvertNumber(a,b));

        //Power Set by bit manipulation
//        int arr[]={1,2,3};
//        System.out.println(bit.powerSet(arr));


        //single number
//        int arr[]={4,1,2,1,2};
//        System.out.println(bit.singleNumber1(arr));

        //single number 2
//        int arr[]={2,2,1,2,1,1,4,3,4,4};

        //Brute force
//        System.out.println(bit.singleNumber2BruteForce(arr));

        //Optimal
//        System.out.println(bit.singleNumber2(arr));

        //With bucket concept
//        System.out.println(bit.singleNumber2BucketConcept(arr));


        //Single Number-3
//        int arr[]={2,4,2,14,3,7,7,3};

        //brute force with map DS
//        System.out.println(bit.singleNumber3BruteForce(arr));
//        Pair<Integer,Integer> ans= bit.SingleNumber3(arr);
//        System.out.println(ans.getKey()+" "+ans.getValue());

 // XOR of given range from 1 to N
        int n=5;

//        System.out.println(bit.XOROfGivenRangeBruteForce(n));
//        System.out.println(bit.XOROfGivenRange(n));

        int l=4,r=7;
        System.out.println(bit.XOROfGivenRangeBetweenLAndR(l,r));











    }
}
