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
        int n=13;
//        System.out.println(bit.checkIfNumberIsPowerOfTwo(n));

        //count number of set bits by normally
//        System.out.println(bit.countNumberOfSetBitInGivenNumber(n));

        //count  number of bit by bit manipulation
//        System.out.println(bit.countNumberOfSetBitInGivenNumberByBit(n));

        //count  number of bit by bit manipulation
//        System.out.println(bit.countNumberOfSetBitInGivenNumberByBitOtherWay(n));

        //Minimum bit flips to convert to Number a to b
        int a=10,b=7;
        System.out.println(bit.minBitFlipsToConvertNumber(a,b));









    }
}
