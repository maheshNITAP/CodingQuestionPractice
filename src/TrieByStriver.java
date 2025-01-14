public class TrieByStriver {
    static class Node{
        Node links[]= new Node[26];
        boolean flag=false;

        boolean containsKey(char ch){
            return links[ch-'a']!= null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void put(char ch, Node node){
            links[ch-'a']=node;
        }
        void setEmd(){
            flag=true;
        }

        boolean isEnd(){
            return flag;
        }
    }
    Node root= new Node();
    public void insert(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node= node.get(word.charAt(i));
        }
        node.setEmd();

    }
    public boolean search(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        return node.isEnd();//if it have true means full or full word is not thare so already false
    }

    public boolean startsWith(String prefix){
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            node=node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String args[]){
        TrieByStriver trie= new TrieByStriver();
        String[] words={"pay","attention","practice","attend"};
        String prefix = "pract";
        for(String x:words){
            trie.insert(x);
        }

        //starts with
        System.out.println(trie.startsWith(prefix));

//        System.out.println(trie.search("attend"));


    }
}
