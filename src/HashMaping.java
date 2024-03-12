import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMaping {
    public static void main(String args[]){
        //creation of map
        //map of country ans population
        HashMap<String,Integer> map= new HashMap<>();
        map.put("China", 180);
        map.put("India", 120);
        map.put("Japan", 70);
        map.put("US", 100);
        //print map
        System.out.println(map);
        //search in map
        if(map.containsKey("Indonesia")){
            System.out.println("Key is persent");
        }else {
            System.out.println("Key is not persent");
        }
        //Search or get value
        System.out.println(map.get("China"));
        System.out.println(map.get("US"));

        //Iteration In Map with entrySet
        for( Map.Entry<String,Integer> e : map.entrySet() ){
            System.out.print(e.getKey()+"->");
            System.out.println(e.getValue());
        }
        System.out.println("//");
        //Iteration with only keySet but we can get values of keys with the help of map.get()
        Set<String> keys= map.keySet();
        for (String key: keys){
            System.out.println(key+" -> "+ map.get(key));
        }
        // remove from map
        map.remove("Japan");
        System.out.println("After removing Japan");
        Set<String> keys1= map.keySet();
        for (String key: keys1){
            System.out.println(key+" -> "+ map.get(key));
        }



    }
}
