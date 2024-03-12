import java.util.ArrayList;

public class BSTTreeBuild {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            //by default, it will assign left and right as null
        }
    }
    public static Node insertToBuildTree(Node root, int val){
        if(root == null){
            return  new Node(val);
        }

        if(root.data>val){
            //left subtree
            root.left=insertToBuildTree(root.left, val);
        }else {
            //right subtree
            root.right= insertToBuildTree(root.right,val);
        }
        return  root;
    }
    public static void InOrderTraversal(Node root){
        if(root ==null){
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data+" ");
        InOrderTraversal(root.right);

    }
    public static boolean searchInBST(Node root,int key){
        if(root== null){
            return false;
        }
        if(root.data== key){
            return true;
        }
        if(root.data>key){
            return searchInBST(root.left,key);
        }else {
            return searchInBST(root.right,key);
        }
    }
    public static Node inOrderSuccessor(Node root){
        while (root.left!= null){
            root=root.left;
        }
        return root;
    }
    public static Node deleteNode(Node root, int val){
        if(root.data>val){
            root.left= deleteNode(root.left,val);
        }else if(root.data<val){
            root.right= deleteNode(root.right,val);
        }else {// if root.data== val
            // 1) case 1: if leaf node
            if(root.left== null && root.right== null){
                return null;
            }
            // 2) case 2: if only one child node
            if(root.left== null){
                return  root.right;
            } else if (root.right==null) {
                return root.left;
            }
            // 3) if tow child nodes are there  -- replace with in Order succesor
//                                                -- delete that succor node
            Node inorderSuccessor= inOrderSuccessor(root.right);// calculate inorderSuccessor
            root.data= inorderSuccessor.data;// replace that IS data with root data
            root.right=deleteNode(root.right,inorderSuccessor.data);// delete that IS node
        }
        return root;
    }
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(x<= root.data && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        }else if(root.data>= y){
            printInRange(root.left,x,y);
        }else {
            printInRange(root.right,x,y);
        }
    }
    public static void printRoot2LeafPath(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left== null && root.right== null){
            System.out.print(path);
            System.out.println();
        }else{
            printRoot2LeafPath(root.left,path);
            printRoot2LeafPath(root.right,path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String args[]){//O(H)
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int x:values){
            root = insertToBuildTree(root,x);
        }
        InOrderTraversal(root);
        System.out.println();
//        if(searchInBST(root,12)){
//            System.out.println("found");
//        }else{
//            System.out.println("Not Found");
////        }
//        deleteNode(root,10);
//        InOrderTraversal(root);
//        printInRange(root,6,10);
        ArrayList<Integer> path= new ArrayList<>();
        printRoot2LeafPath(root,path);

    }
}
