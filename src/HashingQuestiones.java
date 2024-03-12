import java.util.HashMap;
import java.util.HashSet;

public class HashingQuestiones {
    public static int union(int arr1[],int arr2[]){
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int j=0;j< arr2.length;j++){
            set.add(arr2[j]);
        }
        return set.size();
    }
    public static int interSection(int nums1[],int nums2[]){
        HashSet<Integer> set= new HashSet<>();
        int count=0;
        for (int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j< nums2.length;j++){
            if(set.contains(nums2[j])){
                count++;
                set.remove(nums2[j]);
            }
        }
        return count;
    }
    public static void majorityElement(int nums[]){
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1 );
            }else {
                map.put(nums[i],1 );
            }
        }
        for (int key:map.keySet()){
            if(map.get(key)> nums.length/3){
                System.out.println(key);
            }
        }
    }

    private static String getStart(HashMap<String, String> tickets) {
        HashMap<String,String> revMap= new HashMap<>();
        for (String key: tickets.keySet()){// key will become value and value will become key for reverse
            revMap.put(tickets.get(key),key);
        }
        for(String key: tickets.keySet()){// agr ticket ka start exist nhi krta h destination main to vhi start h
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void printItinerary(HashMap<String, String> tickets,String start){
        while (tickets.containsKey(start)){
            System.out.println(start);
            start= tickets.get(start);
        }
        System.out.println(start);
    }
    public static int subArraySum(int nums[], int k){
//                sum, Freq
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);//empty subarray
        int ans=0;
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);// if that sum already exist then update freq
            }else {
                map.put(sum,1);// adding new freq for that value
            }
        }
        return ans;

    }

    public static void main(String []args){
//        int nums[]={1,3,2,5,1,3,1,3,5,1,3};
//        majorityElement(nums);

        int num1[]={7,3,9};
        int num2[]={6,3,9,2,9,4};
//        System.out.println(union(num1,num2));
//        System.out.println(interSection(num1,num2));

//        HashMap<String,String> tickets= new HashMap<>();
//        tickets.put("Chennai", "Bengaluru");
//        tickets.put("Mumbai","Delhi");
//        tickets.put("Goa","Chennai");
//        tickets.put("Delhi","Goa");
//        String start= getStart(tickets);// to get origin
//        printItinerary(tickets,start);// to print path


        int arr[]={10,2,-2,-20,10};
        int k=-10;
        System.out.println(subArraySum(arr,10));


    }


}
