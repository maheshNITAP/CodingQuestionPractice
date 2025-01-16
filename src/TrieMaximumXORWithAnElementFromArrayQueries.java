//Maximum XOR with An Element  from Array Queries
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TrieMaximumXORWithAnElementFromArrayQueries {
    static class Node{
        Node links[]= new Node[2];

        boolean containsKey(int bit){
            return links[bit]!=null;
        }

        Node get(int bit){
            return links[bit];
        }

        Node put(int bit,Node node){
            return links[bit]=node;
        }
    }
    static class Trie{
        private Node root;
        public Trie(){
            root=new Node();
        }

        void  insert(int num){
            Node node=root;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }
        }

        int getMax(int num){
            Node node=root;
            int maxXOR=0;
            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                if(node.containsKey(1-bit)){
                    maxXOR=maxXOR | (1<<i);
                    node=node.get(1-bit);
                }else {
                    node=node.get(bit);
                }
            }
            return maxXOR;
        }
    }
    public static void main(String args[]){
        int arr[]={1,3,2,5,4};
        int queries[][]={{3,4},{5,2},{2,5},{3,1}};
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries= new ArrayList<>();
        int m=queries.length;
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp= new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind=0;
        int n=arr.length;
        Trie trie= new Trie();
        ArrayList<Integer> ans= new ArrayList<>(m);
        for(int i=0;i<m;i++){
            ans.add(-1);
        }
        for(int i=0;i<m;i++){
            while(ind<n && arr[ind]<=offlineQueries.get(i).get(0)){
                trie.insert(arr[ind]);
                ind++;
            }
            int queryInd=offlineQueries.get(i).get(2);
            if(ind!=0){
                ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
            }else
                ans.set(queryInd,-1);
        }
        System.out.println(ans);
    }
}
