import java.util.Arrays;

public class GreedyQuestions {
    private static class Greed{

        public int assignCookies(int[] greed, int[] s) {
            int n=greed.length;
            int m=s.length;
            int l=0,r=0;
            Arrays.sort(greed);
            Arrays.sort(s);
            while(l<m){
                if(s[l]>=greed[r])
                    r+=1;
                l++;
            }
            return r;//we can return count as well
        }

        public boolean lemonadeChange(int[] bills) {
            int five=0, ten=0;
            for(int cash:bills){
                if(cash==5)
                    five++;
                else if(cash==10){
                    if(five>0){
                        five--;
                        ten++;
                    }
                    else
                        return false;
                }else {
                    if(ten>0 && five>0){
                        ten--;
                        five--;
                    }else if(five>=3){
                        five-=3;
                    }else
                        return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {

        Greed g= new Greed();
        //assign cookies

//        int greed[] = {1,5,3,3,4};
//        int s[]={4,2,1,2,1,3};
//        System.out.println(g.assignCookies(greed,s));

        //lemonade change
//        int bills[]={5,5,5,10,20};
        int bills[]={5,5,10,10,20};
        System.out.println(g.lemonadeChange(bills));


    }
}
