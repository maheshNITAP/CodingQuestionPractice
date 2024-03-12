import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuild {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static class BinaryTree{
        static int indx=-1;
        public static Node buildBinaryTree(int nodes[]){
            indx++;
            if(nodes[indx]==-1){
                return null;
            }
            Node root=new Node(nodes[indx]);
            root.left=buildBinaryTree(nodes);
            root.right=buildBinaryTree(nodes);
            return root;
        }
        public static void printTreeInPreOrder(Node root){
            if(root== null){
                return;
            }
            System.out.print(root.data+" ");
            printTreeInPreOrder(root.left);
            printTreeInPreOrder(root.right);
        }
        public static void printTreeInInOrder(Node root){
            if(root== null){
                return;
            }
            printTreeInInOrder(root.left);
            System.out.print(root.data+" ");
            printTreeInInOrder(root.right);
        }
        public static void printTreeInPostOrder(Node root){
            if(root==null){
                return;
            }
            printTreeInPostOrder(root.left);
            printTreeInPostOrder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrderTraversal(Node root){
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node currNode= q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        return;
                    }else {
                        q.add(null);
                    }
                }else {
                    System.out.print(currNode.data);
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int countOfNodesInTree(Node root){
            if(root==null){
                return 0;
            }
            int leftCount= countOfNodesInTree(root.left);
            int rightCount= countOfNodesInTree(root.right);
            return leftCount+rightCount+1;
        }
        public static int sumOfNodesInTree(Node root){
            if(root==null){
                return 0;
            }
            int leftSum=sumOfNodesInTree(root.left);
            int rightSum=sumOfNodesInTree(root.right);
            return leftSum+rightSum+ root.data;
        }
        public static int heightOfTree(Node root){
            if(root== null){
                return 0;
            }
            int leftHight= heightOfTree(root.left);
            int rightHight= heightOfTree(root.right);
//            if(leftHight>rightHight){
//                return leftHight+1;
//            }else {
//                return rightHight+1;
//            }
            return Math.max(leftHight,rightHight)+1;
        }
        public static int diameterOfTree(Node root){
            if(root==null){
                return 0;
            }
            int diameter1= diameterOfTree(root.left);
            int diameter2= diameterOfTree(root.right);
            int diameter3= heightOfTree(root.left)+heightOfTree(root.right)+1;
            return Math.max(diameter1,Math.max(diameter2,diameter3));
        }

        static class TreeInfo{
            int height;
            int diameter;
            TreeInfo(int height,int diameter){
                this.height=height;
                this.diameter=diameter;
            }
        }
        public static TreeInfo diameterOfTreeApproach2(Node root){
            if(root==null){
                return new TreeInfo(0,0);
            }
            TreeInfo left= diameterOfTreeApproach2(root.left);
            TreeInfo right= diameterOfTreeApproach2(root.right);
            int myHeight=Math.max(left.height, right.height)+1;

            int diam1= left.diameter;
            int diam2= right.diameter;
            int diam3= left.height+ right.height+1;
            int myDiam= Math.max(diam1,Math.max(diam2,diam3));
            TreeInfo myInfo= new TreeInfo(myHeight,myDiam);
            return myInfo;
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root =  tree.buildBinaryTree(nodes);
        tree.printTreeInPreOrder(root);
        System.out.println();
        tree.printTreeInInOrder(root);
        System.out.println();
        tree.printTreeInPostOrder(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println();
        int count=tree.countOfNodesInTree(root);
        System.out.println(count);
        int sum=tree.sumOfNodesInTree(root);
        System.out.println(sum);
        int hight= tree.heightOfTree(root);
        System.out.println(hight);
        int diameter= tree.diameterOfTree(root);
        System.out.println(diameter);
        BinaryTree.TreeInfo info = tree.diameterOfTreeApproach2(root);
        System.out.println(info.diameter);

    }
}
