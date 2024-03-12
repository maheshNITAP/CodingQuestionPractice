import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    public static void main(String args[]){
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        //get ele
        System.out.println(list.get(1));
        list.add(1,0);
        System.out.println(list);
        list.set(1,5);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        Collections.sort(list);
        System.out.println(list);
    }
}
