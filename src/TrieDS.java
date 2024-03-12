public class TrieDS {
    static class Node{
        Node[] children;
        boolean eow;//end of row
        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    static Node root= new Node();
    public static void insert(String word){
        Node currNode= root;
        for(int i=0;i<word.length();i++){
            int indx= word.charAt(i)-'a';// index inkal liya
            if(currNode.children[indx]== null){// agr vo latter exit nhi krta
                //add new node
                currNode.children[indx]= new Node();
            }
            if(i==word.length()-1){// agr last letter ho to eow=true
                currNode.children[indx].eow=true;
            }
            currNode= currNode.children[indx];//update level
        }
    }
    public static boolean searchInTrie(String key){//O(L)--> L= length of key
        Node currNode= root;
        for(int i=0;i<key.length();i++){
            int indx= key.charAt(i)-'a';
            if(currNode.children[indx]== null){
                return false;
            }
            if(i== key.length()-1 && currNode.children[indx].eow==false){
                return false;
            }
            currNode= currNode.children[indx];
        }
        return true;// agr loop pura ho gya to true return kr do -->means word mil gya
    }
    public static boolean wordBreak(String key){
        if(key.length()==0){// if key is empty string then it will exist in trie
            return true;
        }
        for(int i=1;i<=key.length();i++){// loop started from 1 bcz there will be no first substring for key.substring(0,i)  where i==0 bcz last index will be excluded
            String firstPart= key.substring(0,i);
            String secondPart= key.substring(i);
            if(searchInTrie(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String prefix){
        Node currNode= root;
        for(int i=0;i<prefix.length();i++){
            int indx= prefix.charAt(i)-'a';
            if(currNode.children[indx]==null)
                return false;
            currNode=currNode.children[indx];
        }
        return true;
    }

    public static int countNodes(Node root){// number of nodes==count of unique prefix==no of unique substring
        if(root== null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+= countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static String ans= "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null)
            return;
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow== true){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length())
                    ans=temp.toString();
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] agrs){
//        String words[]={"the", "a", "there", "their", "any"};
//        for(int i=0;i< words.length;i++){
//            insert(words[i]);
//        }
//        System.out.println(searchInTrie("their"));
//        System.out.println(searchInTrie("thor"));
//        System.out.println(searchInTrie("an"));

//        String words[]={"i","like","sam","samsung","ice", "mobile"};
//        String key = "ilikesamsungmobile";
//        for(int i=0;i< words.length;i++){
//            insert(words[i]);
//        }
//        System.out.println(wordBreak(key));

        //starts with problem
//        String words[]={"apple", "app", "mango", "man","woman"};
//        String prefix="app";
//        for (int i=0;i<words.length;i++){
//            insert(words[i]);
//        }
//        System.out.println(startsWith(prefix));
//        System.out.println(startsWith("moon"));
//        System.out.println(startsWith("woma"));

        //Count Unique Substrings
//        String str="apple";//  str="ababa "
//        for(int i=0;i<str.length();i++){//finding all suffix of string
//            String suffix= str.substring(i);
//            insert(suffix);// inserting all suffix in trie
//        }
//        System.out.println(countNodes(root));

        //Longest Word with all prefixes
        String words[]={"a","banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);



    }
}
