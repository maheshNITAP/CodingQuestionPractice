import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplCode {
                //HashMap<K,V> here we are using HashMap DS jb bhi hum object bnayenge hum hashmap class ka object bnayenge
                    //K-> key , V-> value
    // hash map ,ain key/value kis type(Int, String, long...) ki hogi hme nhi pta isliye humne generics ka use kiya h
    static class HashMap<K,V> { // generics
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n;// n --> nodes
        private int N; //N --> buckets
        //int arr[]= new int[];
        private LinkedList<Node> buckets[];// N- buckets.length
        public HashMap(){// constructor
            this.N= 4;// total number of buckets
            this.buckets= new LinkedList[4];// bucket array ki initialize ke diya h
            for(int i=0;i<4;i++){
                buckets[i]= new LinkedList<>();// he ak aary index pr jakr empty LL ko create krenge kyuki phle hr index pr by default  null stored hoga or jb khali LL exist kregi tbhi hum us LL main element ko store kr payenge
            }
        }
        public int hashFunction(K key){
            int bi= key.hashCode();// it will return any +v or -v vale
            return Math.abs(bi)%N;// Math.abs is usesd to convert all values in +ve
            // and %N is used to convert values betwwen 0 to N-1 kyuki hme bucket value array size ke ander hi chiye
        }
        public int searchInLL(K key, int bi){
            LinkedList<Node> ll= buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(key== ll.get(i).key){
                    return i;// nothing but di when key is matched
                }
            }
            return -1;// nothing is matched
        }

        private void rehash(){
            LinkedList<Node> oldBucket[]= buckets;// purane data ko oldBucket main store krwa liya
            buckets= new LinkedList[N*2];// bucket ke ander nyi or khali bucket bna ki h N*2 size ki
            for(int i=0;i<N*2;i++){
                buckets[i]= new LinkedList<>();// her bucket ko new LL se initialize kr de
            }

            for(int i=0;i<oldBucket.length;i++){//ab apni purani bucket pr loop chlana h
                LinkedList<Node> ll= oldBucket[i];//hr bucket pr ek LL stored hogi us pr loop chla kr use hashmap main store kr le
                for(int j=0;j<ll.size();j++){
                    Node node= ll.get(j);
                    put(node.key, node.value);//hr node ko vaps hashMap main store kr lo
                }

            }
        }
        public void put(K key, V value){
            int bi= hashFunction(key);// it will return bucketIndex
            int di= searchInLL(key,bi); // it will return data index if exist(means key index in LL or index of key in LL)
            //agr data index ka value valid (0+) hua to key exist if (-1) doesn't exist
            if(di==-1){// key doesn't exist then add new node at that bucketIndex
                buckets[bi].add(new Node(key, value));
                n++; // n++ becouse new node is added
            }else{// if already exist then update value of exist node
                Node node= buckets[bi].get(di);
                node.value= value;
            }

            double lambda= (double) n/N;
            if(lambda> 2.0){
                rehash();
            }
        }

        public boolean containsKay(K key){
            int bi= hashFunction(key);// it will return bucketIndex
            int di= searchInLL(key,bi); // it will return data index if exist(means key index in LL or index of key in LL)
            //agr data index ka value valid (0+) hua to key exist if (-1) doesn't exist
            if(di==-1){// key doesn't exist then add new node at that bucketIndex
                return false;
            }else{// if already exist then update value of exist node
                return true;
            }
        }
        public V remove(K key){
            int bi= hashFunction(key);// it will return bucketIndex
            int di= searchInLL(key,bi); // it will return data index if exist(means key index in LL or index of key in LL)
            //agr data index ka value valid (0+) hua to key exist if (-1) doesn't exist
            if(di==-1){// key doesn't exist then add new node at that bucketIndex
                return null;
            }else{// if exist then remove from LL of that bucket
                Node node= buckets[bi].remove(di);//
                n--;// becouse node is removed so number of node also should be decreased
                return node.value;
            }
        }
        public V get(K key){
            int bi= hashFunction(key);// it will return bucketIndex
            int di= searchInLL(key,bi); // it will return data index if exist(means key index in LL or index of key in LL)
            //agr data index ka value valid (0+) hua to key exist if (-1) doesn't exist
            if(di==-1){// key doesn't exist then add new node at that bucketIndex
                return null;
            }else{// if already exist then get that bucket ll node value
                Node node= buckets[bi].get(di);
                return node.value;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys= new ArrayList<>();
            for(int i=0;i< buckets.length;i++){//Bi--> bucketIndex
                LinkedList<Node> ll= buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node=ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0; // n is number of nodes
        }

    }
    public static void main(String args[]){
        HashMap<String,Integer> map= new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("US", 50);
        //System.out.println(map.get("China"));
//        System.out.println(map.containsKay("US"));
//        System.out.println(map.containsKay("South"));
//        System.out.println(map.keySet());
//        System.out.println(map.isEmpty());
//        System.out.println(map.remove("India"));
//        System.out.println(map.keySet());
//        System.out.println(map.isEmpty());
        ArrayList<String> keys= map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+ " -> "+ map.get(keys.get(i)));
        }


    }
}
