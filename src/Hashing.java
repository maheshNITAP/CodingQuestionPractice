import java.util.HashSet;
import java.util.Iterator;
public class Hashing {
    public static void main(String args[]){
        //create a set
        HashSet<Integer> set= new HashSet<>();
        //insert in set
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5);
        set.add(6);
        set.add(7);

        //print all element of set
        System.out.println(set);
        //Size of set
        System.out.println("Size of set is :"+ set.size());
        // search in set
        if(set.contains(1)){
            System.out.println("Set Contains 1");
        }
        if(!set.contains(6)){
            System.out.println("does not contain 6");
        }
        //Delete in set
        set.remove(2);
        if(!set.contains(2)){
            System.out.println("2 is deleted from set");
        }
        //Size of set
        System.out.println("Size of set is :"+ set.size());

        //Iterator
        Iterator it= set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


    }
}
