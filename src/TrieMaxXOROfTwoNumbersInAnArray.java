//Max XOR of two numbers in an array
public class TrieMaxXOROfTwoNumbersInAnArray {
    static class Node{
        Node links[]= new Node[2];

        boolean containsKey(int bit){
            return links[bit]!=null;
        }

        Node get(int bit){
            return links[bit];
        }

        void put(int bit,Node node){
            links[bit]=node;
        }
    }

    static class Trie{
        public Node root;
        public Trie(){
            root=new Node();
        }

        public void insert(int num){
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }
        }

        public int getMax(int num){
            Node node=root;
            int maxNum=0;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(node.containsKey(1-bit)){
                    maxNum=maxNum |(1<<i);
                    node=node.get(1-bit);
                }else {
                    node=node.get(bit);
                }
            }
            return maxNum;
        }
    }
    public static void main(String args[]){
        Trie trie= new Trie();
        int arr1[]={3, 10, 5, 25, 2};
        int arr2[]={8, 1, 2, 12, 7};
        for(int x:arr1){
            trie.insert(x);
        }
        int maxXOR=0;
        for(int x:arr2){
            maxXOR=Math.max(maxXOR,trie.getMax(x));
        }
        System.out.println(maxXOR);


    }
}
