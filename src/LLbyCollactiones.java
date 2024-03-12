import java.util.LinkedList;

public class LLbyCollactiones {

    public static void main(String args[]){
        LinkedList<String > list = new LinkedList<>();
        list.addFirst("M");
        list.addFirst("A");
        System.out.println(list);
        list.addLast("E");
        System.out.println(list);
        list.add("MEE");
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+ "->");
        }
        System.out.println("NULL");
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
