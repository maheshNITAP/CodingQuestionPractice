import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BinarySearchTreeQuestions {
    static class Node{
        int data;
        Node left= null;
        Node right=null;

        Node(int data){
            this.data=data;
        }
    }
    static class BinarySearchTree{

        static int index=-1;

        public Node buildBinarySearchTree(int[] nodes) {
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node root = new Node(nodes[index]);
            root.left=buildBinarySearchTree(nodes);
            root.right=buildBinarySearchTree(nodes);
            return root;
        }

        public void printTreeInOrder(Node root) {
            if(root==null){
                return;
            }
            printTreeInOrder(root.left);
            System.out.print(root.data+" ");
            printTreeInOrder(root.right);
        }

        public boolean searchInBST(Node root, int ele) {
            if(root==null){
                return false;
            }
            if(root.data==ele){
                return true;
            }
            if(ele<root.data){
                return searchInBST(root.left,ele);
            }else {
                return searchInBST(root.right,ele);
            }
        }

        public int minElementInBST(Node root) {
            if(root== null){
                return -1;
            }
            while (root.left != null){
                root=root.left;
            }
            return root.data;
        }

        public int maxElementInBST(Node root) {
            if(root== null){
                return -1;
            }
            while (root.right!= null){
                root=root.right;
            }
            return root.data;
        }

        public Node insertElementInBST(Node root, int ele) {
            if(root== null){
                  return root= new Node(ele);
            }
            if(root.data==ele){
                return root;
            }
            if(ele>root.data){
                root.right=insertElementInBST(root.right,ele);
            } else if (ele< root.data) {
                root.left=insertElementInBST(root.left,ele);
            }
            return root;
        }
        private Node selectLeftMostOfRightNode(Node root) {
            while (root.left!= null){
                root=root.left;
            }
            return root;
        }
        public Node deletionInBST(Node root, int ele) {
            if(root== null){
                return null;
            }
            if(root.data==ele){
                if(root.left ==null && root.right== null){//- 0 child
                    return null;
                }
                if(root.left != null && root.right!= null){//-2 child condition
                    Node temp = selectLeftMostOfRightNode(root.right);
                    root.data= temp.data;
                    root.right=deletionInBST(root.right,temp.data);
                    return root;
                }
                //-- only one child
                if(root.left != null){//ya to left child ho
                    return root.left;
                }
                if(root.right!= null){//ya right child ho
                    return root.right;
                }
            }else {
                if(ele< root.data){
                    root.left=deletionInBST(root.left,ele);
                }else {
                    root.right=deletionInBST(root.right,ele);
                }
            }
            return root;
        }


        public void retrieve(Node root, ArrayList<Integer> arr) {
            if(root== null){
                return;
            }
            retrieve(root.left,arr);
            arr.add(root.data);
            retrieve(root.right,arr);
        }

        public void conversionToBSTree(Node root2, ArrayList<Integer> arr) {
            if(root2== null){
                return;
            }
            conversionToBSTree(root2.left,arr);
            root2.data=arr.get(0);
            arr.remove(0);
            conversionToBSTree(root2.right,arr);
        }

        public int countNodesInBST(Node root, int l, int h) {
            int count=0;
            if(root == null) return 0;
            if(root.data>= l && root.data<=h ){
                count++;
            }
            count+=countNodesInBST(root.left, l, h);
            count+=countNodesInBST(root.right, l, h);
            return count;
        }

        public Node createArrayToBST(int[] arr, int l, int h) {
            if(l>h){
                return null;
            }
            int mid=l+(h-l)/2;
            Node root=new Node(arr[mid]);
            root.left=createArrayToBST(arr,l,mid-1);
            root.right=createArrayToBST(arr,mid+1,h);
            return root;
        }

        public void bstTreeWithSumOfSmallerKeys(Node root, int[] sum) {
            if(root== null){
                return ;
            }
            bstTreeWithSumOfSmallerKeys(root.left,sum);
            sum[0]+=root.data;
            root.data=sum[0];
            bstTreeWithSumOfSmallerKeys(root.right,sum);

        }

        public void kthSmallestElementInBST(Node root, int[] k, int[] res) {
            if(root==null){
                return;
            }
            kthSmallestElementInBST(root.left,k, res);
            k[0]--;
            if(k[0]==0){
                res[0]=root.data;
            }
            kthSmallestElementInBST(root.right,k, res);
        }

        public void kthGreaterElementInBST(Node root, int[] k, int[] res) {
            if(root== null){
                return;
            }
            kthGreaterElementInBST(root.right,k,res);
            k[0]--;
            if(k[0]==0){
                res[0]=root.data;
            }
            kthGreaterElementInBST(root.left,k,res);
        }

        public Node lowestCommonAncestorOfBST(Node root, int a, int b) {
            if(root== null){
                return null;
            }
            if(a> root.data && b> root.data){
                return lowestCommonAncestorOfBST(root.right,a,b);
            } else if (a< root.data && b<root.data) {
                return lowestCommonAncestorOfBST(root.left,a,b);
            }
            return root;
        }

        public void checkIfBinaryTreeIsBSt(Node root, int l, int r, boolean[] flag) {
            if(root== null){
                return;
            }
            if(l>r){
                flag[0]=false;
                return;
            }
            if(root.data<l || root.data>r){
                flag[0]=false;
                return;
            }
            checkIfBinaryTreeIsBSt(root.left,l, root.data-1, flag);
            checkIfBinaryTreeIsBSt(root.right,root.data+1,r,flag);
        }

        public void checkForDeadEndInBST(Node root, int l, int r, boolean[] flag) {
            if(root== null){
                return;
            }
            if(flag[0]){
                return;
            }
            if(root.left == null && root.right== null){
                if(l==r){
                    flag[0]=true;
                }
                return;
            }else {
                checkForDeadEndInBST(root.left,l, root.data-1,flag);
                checkForDeadEndInBST(root.right, root.data+1,r,flag);
            }
        }
        private void pushAllRightMostElements(Node root, Stack<Node> s2) {
            while (root!= null){
                s2.push(root);
                root=root.right;
            }
        }

        private void pushAllLeftMostElements(Node root, Stack<Node> s1) {
            while (root != null) {
                s1.push(root);
                root=root.left;
            }
        }
        public boolean findPairWithGivenTarget(Node root, int target) {
            if(root== null){
                return false;
            }
            Stack<Node> s1 = new Stack<>(),s2= new Stack<>();
            pushAllLeftMostElements(root,s1);
            pushAllRightMostElements(root,s2);
            while (!s1.isEmpty() && !s2.isEmpty()){
                int x=s1.peek().data;
                int y=s2.peek().data;
                if(x+y==target){
                    return true;
                } else if (x+y<target) {
                    Node temp=s1.pop();
                    pushAllLeftMostElements(temp.right,s1);
                }else {
                    Node temp=s2.pop();
                    pushAllRightMostElements(temp.left,s2);
                }
            }
            return false;
        }


        public int closestElementDistance(Node root, int target) {
            if(root == null){
                return Integer.MAX_VALUE;
            }
            if(root.data==target){return 0;}
            if(target> root.data){
                return Math.min(Math.abs(root.data)-target,closestElementDistance(root.right,target));
            }else {
                return Math.min(Math.abs(root.data-target),closestElementDistance(root.left,target));
            }
        }

        public boolean checkForPreOrderTraversalOfBST(int[] arr) {
            int parent=Integer.MIN_VALUE;
            Stack<Integer> st= new Stack<>();
            for(int i=0;i<arr.length;i++){
                if(arr[i]<parent){
                    return false;
                }
                while (!st.isEmpty() && st.peek()<arr[i]){
                    parent=st.pop();
                }
                st.push(arr[i]);
            }
            return true;
        }

        public void greaterSumTree(Node root, int[] sum) {
            if(root== null){
                return;
            }
            greaterSumTree(root.left,sum);
            sum[0]+= root.data;
            root.data=sum[0];
            greaterSumTree(root.right,sum);
        }

        public void inorder(Node root, ArrayList<Integer> arr) {
            if(root== null){
                return;
            }
            inorder(root.left,arr);
            arr.add(root.data);
            inorder(root.right,arr);
        }

        public void fillInPreOrder(Node root, ArrayList<Integer> arr) {
            if(root==null)return;
            root.data=arr.remove(0);
            fillInPreOrder(root.left,arr);
            fillInPreOrder(root.right,arr);
        }

        public void preOrderToPostOrder(int[] preOrder, int l, int r, ArrayList<Integer> post) {
            if(l>r) return;
            int g= findNextGreaterElement(preOrder,l,r);
            preOrderToPostOrder(preOrder,l+1,g-1,post);
            preOrderToPostOrder(preOrder,g,r,post);
            post.add(preOrder[l]);
        }

        private int findNextGreaterElement(int[] preOrder, int l, int r) {
            int i;
            for(i=l+1;i<=r;i++){
                if(preOrder[i]>preOrder[l]){
                    return i;
                }
            }
            return i;
        }

        public void postOrderToPreOrder(int[] postOrder, int l, int r, ArrayList<Integer> preOrder) {
            if(l>r) return;;
            int s= findNextSmaller(postOrder,l,r);
            preOrder.add(postOrder[r]);
            postOrderToPreOrder(postOrder,l,s,preOrder);
            postOrderToPreOrder(postOrder,s+1,r-1,preOrder);
        }

        private int findNextSmaller(int[] postOrder, int l, int r) {
            int i=r;
            for(;i>=l;i--){
                if(postOrder[i]<postOrder[r]){
                    return i;
                }
            }
            return i;
        }

        public Node constructTreeFromPreOrderTraversal(int[] preOrder, int[] index, int l, int r, int size) {
            if(index[0]>size){
                return null;
            }
            if(l>r) return null;
            if(preOrder[index[0]]< l || preOrder[index[0]]>r){
                return null;
            }
            int X= preOrder[index[0]];
            Node root= new Node(X);
            index[0]++;
            root.left=constructTreeFromPreOrderTraversal(preOrder,index,l,X-1,size);
            root.right=constructTreeFromPreOrderTraversal(preOrder,index,X+1,r,size);
            return root;
        }

        public Node constructTreeFromPostOrderTraversal(int[] postOrder, int[] index, int l, int r) {
            if(index[0]<0) return null;
            if(l>r) return null;
            if(postOrder[index[0]]<l || postOrder[index[0]]>r){
                return null;
            }
            int x=postOrder[index[0]];
            index[0]--;
            Node root= new Node(x);
            root.right=constructTreeFromPostOrderTraversal(postOrder,index,x+1,r);
            root.left=constructTreeFromPostOrderTraversal(postOrder,index,l,x-1);
            return root;

        }

        public Node constructBSTFromLevelOrder(ArrayList<Integer> levelOrder) {
            if(levelOrder.size()==0){
                return null;
            }
            Node root= new Node(levelOrder.get(0));
            ArrayList<Integer> l= new ArrayList<>();
            ArrayList<Integer> r= new ArrayList<>();
            for(int i=1;i<levelOrder.size();i++){
                if(levelOrder.get(i)<levelOrder.get(0)){
                    l.add(levelOrder.get(i));
                }else {
                    r.add(levelOrder.get(i));
                }
            }
            root.left=constructBSTFromLevelOrder(l);
            root.right=constructBSTFromLevelOrder(r);
            return root;
        }

        static class Bst{
            boolean isBst;
            int size;
            int minInRight;
            int maxInLeft;

            Bst(boolean isBst,int size,int minInRight,int maxInLeft){
                this.isBst=isBst;
                this.size=size;
                this.minInRight=minInRight;
                this.maxInLeft=maxInLeft;
            }
        }
        public Bst largestBSTInBinaryTree(Node root) {
            if(root== null){
                return new Bst(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            Bst left=largestBSTInBinaryTree(root.left);
            Bst right=largestBSTInBinaryTree(root.right);
            if(left.isBst && right.isBst && left.maxInLeft< root.data && right.minInRight> root.data){
                return new Bst(true,left.size+right.size+1,Math.min(root.data, right.minInRight),Math.max(root.data, left.maxInLeft));
            }
            return new Bst(false,Math.max(left.size,right.size),-1,-1);
        }
    }
    public static void main(String args[]){
       int nodes[]={70,60,55,-1,-1,65,-1,-1,80,75,-1,-1,85,-1,-1};//-- data to create BST
//        int nodes[]={25,30,17,-1,-1,22,-1,-1,32,-1,28,-1,-1};//-- for non-BST tree
//        int nodes[]={25,18,17,-1,-1,20,19,-1,-1,-1,30,-1,35,-1,-1};//--BST for dead End
       BinarySearchTree tree= new BinarySearchTree();
       Node root=tree.buildBinarySearchTree(nodes);//--build in preOrder
//       tree.printTreeInOrder(root);//--preOrder always give sorted order

        //Search in BST
//        int ele=75;
//        System.out.println(tree.searchInBST(root,ele));

        //Min element in BST
//        System.out.println(tree.minElementInBST(root));

        //Max element in BST
//        System.out.println(tree.maxElementInBST(root));

        //Insert element in BST
//        int ele=64;
//        tree.insertElementInBST(root,ele);
//        tree.printTreeInOrder(root);

        //Delete element in BST
//        int ele=55;
//        tree.printTreeInOrder(root);
//        root= tree.deletionInBST(root,ele);
//        System.out.println();
//        tree.printTreeInOrder(root);

        //convert binary tree to BST
//        int nodes2[]={25,30,17,-1,-1,22,-1,-1,32,-1,28,-1,-1};//--data to create tree in preOrder
//        BinarySearchTree tree2= new BinarySearchTree();
//        BinarySearchTree.index=-1;
//        Node root2=tree2.buildBinarySearchTree(nodes2);//--build in preOrder
//        tree2.printTreeInOrder(root2);
//        System.out.println();
//        ArrayList<Integer> arr= new ArrayList<>();
//        tree.retrieve(root2,arr);
//        Collections.sort(arr);
//        tree2.conversionToBSTree(root2,arr);
//        tree2.printTreeInOrder(root2);

        //count nodes in given range in BST
//        int l=45,h=70;
//        tree.printTreeInOrder(root);
//        System.out.println();
//        System.out.println(tree.countNodesInBST(root,l,h));

        // sorted array data to balanced BST
//        int arr[]={10,12,15,20,24,28};
//        Node root2=tree.createArrayToBST(arr,0,arr.length-1);
//        tree.printTreeInOrder(root2);

        //BST tree we\ith sum of smaller keys
//        int sum[]= new int[1];
//        tree.bstTreeWithSumOfSmallerKeys(root,sum);
//        tree.printTreeInOrder(root);

        //Kth smallest element in BST--we need inOrder in LNR(left,node,Right) manner
//        int k[]= new int[1];
//        k[0]=3;
//        int res[]= new int[1];
//        tree.kthSmallestElementInBST(root,k,res);
//        System.out.println(res[0]);

        //Kth greater element in BST--we need inOrder in RNL( Right,node,left) manner to get kth greater
//        int k[]= new int[1];
//        k[0]=3;
//        int res[]= new int[1];
//        tree.kthGreaterElementInBST(root,k,res);
//        System.out.println(res[0]);


//        lowest common Ancestor in BST
//        int a=60,b=75;
//        Node res=tree.lowestCommonAncestorOfBST(root,a,b);
//        System.out.println(res.data);

//        //check if binary tree is BST
//        int l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
//        boolean flag[]= new boolean[1];
//        flag[0]=true;//mana ki vo BSt h
//        tree.checkIfBinaryTreeIsBSt(root,l,r,flag);
//        System.out.println(flag[0]);

        //check for dead end in BST
//        int l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
//        boolean flag[]= new boolean[1];
//         tree.checkForDeadEndInBST(root,l,r,flag);
//        System.out.println(flag[0]);

        //pair with given target in BST--in this bst we have to find two element who's sum is equal to target element
//        int target=150;
//        System.out.println(tree.findPairWithGivenTarget(root,target));

        //closest element in BST
//        int target=54;
//        System.out.println(tree.closestElementDistance(root,target));

        //   check for preOrder traversal of BST
//        int arr[]={40,30,35,80,100};//--for true
//        int arr[]={40,30,35,20,80,100};//--for false
//        System.out.println(tree.checkForPreOrderTraversalOfBST(arr));

        //largest BST in binary tree
//        BinarySearchTree.Bst bst=tree.largestBSTInBinaryTree(root);
//        System.out.println(bst.size);


        // BST to greater sum tree
//        int sum[]= new int[1];
//        tree.greaterSumTree(root,sum);
//        tree.printTreeInOrder(root);

        //Convert BST to min heap-- if we traverse in Inorder then we gain fill that same data in PreOrder then we will get min heap
//        ArrayList<Integer> arr= new ArrayList<>();
//        tree.inorder(root,arr);
//        tree.fillInPreOrder(root,arr);
//        tree.printTreeInOrder(root);

        //preOrder to PostOrder in BST-----------
//        int preOrder[]={40,30,35,80,100};
//        int l=0;
//        int r= preOrder.length-1;
//        ArrayList<Integer> post= new ArrayList<>();
//        tree.preOrderToPostOrder(preOrder,l,r,post);
//        System.out.println(post);

        //PostOrder to preOrder
//         int postOrder[]={35,30,100,80,40};
//         int l=0;
//         int r= postOrder.length-1;
//         ArrayList<Integer> preOrder= new ArrayList<>();
//         tree.postOrderToPreOrder(postOrder,l,r,preOrder);
//        System.out.println(preOrder);

//        //BST construction from PreOrderTraversal
//        int preOrder[]={40,30,22,34,50,60,62,65};
//        int size= preOrder.length-1;
//        int index[]= new int[1];
//        int l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
//        Node root2=tree.constructTreeFromPreOrderTraversal(preOrder,index,l,r,size);
//        tree.printTreeInOrder(root2);

        //BST construction from postOrder Traversal

//        int postOrder[]={6,10,35,47,44,40,30};
//        int index[] = new int[1];
//        index[0]=postOrder.length-1;
//        int l=Integer.MIN_VALUE,r= Integer.MAX_VALUE;
//        Node root2= tree.constructTreeFromPostOrderTraversal(postOrder,index,l,r);
//        tree.printTreeInOrder(root2);

        //BST construction form levelOrder Traversal
        Integer levelOrd[]={50,45,57,42,55,56};
        ArrayList<Integer> levelOrder= new ArrayList<>();
        levelOrder.addAll(Arrays.asList(levelOrd));
        Node root2= tree.constructBSTFromLevelOrder(levelOrder);
        tree.printTreeInOrder(root2);









    }


}
