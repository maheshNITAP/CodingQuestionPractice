public class TrieInsertCountWordEqualsToCountWordStartsWithEraseWord {
    static class Node{
        Node links[]= new Node[26];
        int countEndsWith=0;
        int countPrefix=0;

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch, Node node){
            links[ch-'a']=node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void increaseEnd(){
            countEndsWith++;
        }
        void  increasePrefix(){
            countPrefix++;
        }

        void deleteEnd(){
            countEndsWith--;
        }

        void reducePrefix(){
            countPrefix--;
        }
    }
    Node root= new Node();

    private void insert(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new Node());
            node=node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    private int countWordEqualsTo(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                return 0;
            node= node.get(word.charAt(i));
        }
        return node.countEndsWith;
    }

    private int countWordStartsWith(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                return 0;
            node=node.get(word.charAt(i));
        }
        return node.countPrefix;
    }

    private void eraseWord(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i)))
                return;
            node=node.get(word.charAt(i));
            node.reducePrefix();
        }
        node.deleteEnd();
    }
    public static void main(String args[]){
        TrieInsertCountWordEqualsToCountWordStartsWithEraseWord trie = new TrieInsertCountWordEqualsToCountWordStartsWithEraseWord();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apple");

        System.out.println("Count of words equal to apple is :"+trie.countWordEqualsTo("apple"));
        System.out.println("Count of words starts with app is :"+trie.countWordStartsWith("app"));
        System.out.println("Count of words starts with appl is :"+trie.countWordStartsWith("appl"));
        System.out.println("Erasing word apple from trie");
        trie.eraseWord("apple");
        System.out.println("Count of words equal to apple is :"+trie.countWordEqualsTo("apple"));
        System.out.println("Count of words starts with app is :"+trie.countWordStartsWith("app"));
        System.out.println("Erasing word app from trie");
        trie.eraseWord("app");
        System.out.println("Count of words starts with app is :"+trie.countWordStartsWith("app"));
        System.out.println("Count of words equal to apple is :"+trie.countWordEqualsTo("app"));

    }
}
