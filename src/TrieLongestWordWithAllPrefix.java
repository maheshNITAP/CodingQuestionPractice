//longest word with all prefix and if multiple are there with same length then return lexicographically smaller one

class Node{
    Node links[]= new Node[26];
    boolean flag=false;

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    boolean isEnd(){
        return flag;
    }
    void setEnd(){
        flag=true;
    }
}
public class TrieLongestWordWithAllPrefix {
    private  Node root=new Node();

    public  void insert(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean  checkIfPrefixExists(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
                if(node.isEnd()==false)
                    return false;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){

        TrieLongestWordWithAllPrefix trie= new TrieLongestWordWithAllPrefix();
//        String arr[]={"n", "ni", "nin", "ninj", "ninja","ninga"};//O/P:----ninja
        String arr[]={"ab", "bc"};//-----O/P--None
        String longest="";
        int n=arr.length;
        for(int i=0;i<n;i++){
            trie.insert(arr[i]);
        }
        for(int i=0;i<n;i++){
            if(trie.checkIfPrefixExists(arr[i])){
                if(arr[i].length()>longest.length())
                    longest=arr[i];
                else if(arr[i].length()==longest.length() && arr[i].compareTo(longest)<0)
                    longest=arr[i];
            }
        }
        longest= longest==""?"None":longest;
        System.out.println("longest word with all Prefix : "+ longest);
    }

}
