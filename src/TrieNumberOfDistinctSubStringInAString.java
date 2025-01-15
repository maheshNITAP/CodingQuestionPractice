//Number of distinct subString in a String By trie

public class TrieNumberOfDistinctSubStringInAString {
    static class Node{
        Node links[]= new Node[26];

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void put(char ch, Node node){
            links[ch-'a']=node;
        }
    }

    private int countDistinctSubString(String s) {
        Node root= new Node();
        int count=0;
        for(int i=0;i<s.length();i++){
            Node node=root;
            for(int j=i;j<s.length();j++){
                if(!node.containsKey(s.charAt(j))){
                    count++;
                    node.put(s.charAt(j),new Node());
                }
                node=node.get(s.charAt(j));
            }
        }
        return count+1;//------+1 for empty string as well
    }
    public static void main(String args[]){
        String s="abab";
        TrieNumberOfDistinctSubStringInAString trie = new TrieNumberOfDistinctSubStringInAString();
        System.out.println(trie.countDistinctSubString(s));
    }



}
