public class TrieQuestions {
    static class Node {
        Node[] children;
        boolean eow;
        int count;

        public Node() {
            children = new Node[26];
            eow = false;
            eow = false;
            count = 0;
        }
    }

        public static Node root=new Node();
        public void insert(String word){
            Node currNode=root;
            for(int i=0;i<word.length();i++){
                int ind=word.charAt(i)-'a';
                if(currNode.children[ind]==null){
                    currNode.children[ind]=new Node();
                }
                if(i==word.length()-1){
                    currNode.children[ind].eow=true;
                }
                currNode.count++;
                currNode=currNode.children[ind];
            }
        }

        public int searchInTrie(String word){
            Node currNode=root;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if(currNode.children[index]==null){
                    return 0;
                }

                currNode=currNode.children[index];
            }
            return currNode.count;
        }

    public static void main(String args[]){

            //Prefix Search count in givn words
        String[] words={"pay","attention","practice","attend"};
        String prefix = "at";
        TrieQuestions trieQuestions= new TrieQuestions();

        for(int i=0;i<words.length;i++){
            trieQuestions.insert(words[i]);
        }
        System.out.println(trieQuestions.searchInTrie(prefix));



    }
}
