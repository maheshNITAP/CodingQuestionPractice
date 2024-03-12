import java.util.Collections;
import java.util.List;
public class Questiones {

    //cout number of pairs who's sum is < taregt
    public int countPairs(List<Integer> nums, int target){
        int count=0;
        Collections.sort(nums);
        int i=0;
        int j=nums.size()-1;
        while(i<j){
            if(nums.get(i)+nums.get(j)<target){
                count+=j-i;
                i++;
            }else{
                j--;
            }
        }
        return count;
    }




    public static void main(String args[]){


    }
}
