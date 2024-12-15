import java.util.HashMap;


//LRU Cache Implementation
public class LRUCache {
    public static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int val){
            this.key=key;
            this.value=val;
        }
    }

    int capacity;
    HashMap<Integer,Node> map= new HashMap<>();
    Node head= new Node(-1,-1);
    Node tail= new Node(-1,-1);
    public LRUCache(int capacity){
        this.capacity=capacity;
        map.clear();
        head.next=tail;
        tail.prev=head;

    }
    public int get(int key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            deleteTheNode(node);
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key,int val){
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=val;
            deleteTheNode(node);
            insertAfterHead(node);
        }else{
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                deleteTheNode(node);
            }
            Node node= new Node(key,val);
            map.put(key,node);
            insertAfterHead(node);
        }
    }

    public void deleteTheNode(Node node){
        Node previousNode=node.prev;
        Node afetrNode=node.next;

        previousNode.next=afetrNode;
        afetrNode.prev=previousNode;
    }

    public void insertAfterHead(Node node){
        Node currentAfterHead=head.next;
        head.next=node;
        node.next=currentAfterHead;
        node.prev=head;
        currentAfterHead.prev=node;
    }
    public static void main(String args[]){
        LRUCache lru= new LRUCache(4);
        System.out.println(lru.get(1));
        lru.put(2,6);
        lru.put(4,7);
        lru.put(8,11);
        lru.put(7,10);

        //to see the demo for LRU
        Node hd=lru.head.next;
        while(hd.next!=null){
            System.out.println(hd.key+" "+hd.value);
            hd=hd.next;
        }

        System.out.println(lru.get(2));
        Node hd1=lru.head;
        while(hd1.next!=null){
            System.out.println(hd1.key+" "+hd1.value);
            hd1=hd1.next;
        }

        lru.put(5,6);
        lru.get(7);
        lru.put(5,7);

        Node hd2=lru.head;
        while(hd2.next!=null){
            System.out.println(hd2.key+" "+hd2.value);
            hd2=hd2.next;
        }



    }
}
