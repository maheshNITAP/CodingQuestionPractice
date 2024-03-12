import java.util.*;

public class TreeQuestions {
    static class Node{
        int data;
        Node left=null;
        Node right=null;

        Node(int data){
            this.data=data;
        }
    }
    static class BinaryTree{
        static int index=-1;

        public Node buildBinaryTree(int[] nodes) {
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node root= new Node(nodes[index]);
            root.left=buildBinaryTree(nodes);
            root.right=buildBinaryTree(nodes);
            return root;
        }

        public void printTreeInPreOrder(Node root) {
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            printTreeInPreOrder(root.left);
            printTreeInPreOrder(root.right);
        }

        public void printTreeInOrder(Node root) {
            if(root==null){
                return;
            }
            printTreeInOrder(root.left);
            System.out.print(root.data+" ");
            printTreeInOrder(root.right);
        }

        public void printTreeInPostOrder(Node root) {
            if(root==null){
                return;
            }
            printTreeInPostOrder(root.left);
            printTreeInPostOrder(root.right);
            System.out.print(root.data+" ");
        }

        public void levelOrderTraversal(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node curr=queue.remove();
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }

        public void levelOrderTraversalRightToLeft(Node root) {
            Queue<Node> queue= new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node currNode =queue.remove();
                System.out.print(currNode.data+ " ");
                if(currNode.right!= null){
                    queue.add(currNode.right);
                }
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
            }
        }

        public int countOfNodesInTree(Node root) {
            if(root== null){
                return 0;
            }
            int left= countOfNodesInTree(root.left);
            int right= countOfNodesInTree(root.right);
            return left+right+1;
        }

        public int sumOfNodesInTree(Node root) {
            if(root== null){
                return 0;
            }
            int leftCount=sumOfNodesInTree(root.left);
            int rightCount=sumOfNodesInTree(root.right);
            return  leftCount+rightCount+ root.data;
        }

        public int heightOfTree(Node root) {
            if(root==null){
                return 0;
            }
            int leftHeight= heightOfTree(root.left);
            int rightHeight= heightOfTree(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }

        public int diameterOfTree(Node root) {
            if(root==null){
                return 0;
            }
            int diameterOfLeftSubtree=diameterOfTree(root.left);
            int diameterOfRightSubtree= diameterOfTree(root.right);
            int diameterFormRootNode = heightOfTree(root.left)+heightOfTree(root.right)+1;
            return Math.max(diameterFormRootNode,Math.max(diameterOfLeftSubtree,diameterOfRightSubtree));
        }

        public TreeInfo diameterOfTreeApproach2(Node root) {
            if(root==null){
                return new TreeInfo(0,0);
            }

            TreeInfo left= diameterOfTreeApproach2(root.left);
            TreeInfo right= diameterOfTreeApproach2(root.right);
            int myHeight= Math.max(left.height,right.height)+1;

            int diameter1= left.diameter;
            int diameter2= right.diameter;
            int diameter3= left.height+ right.height+1;
            int myDiameter= Math.max(diameter3, Math.max(diameter1,diameter2));
            return new TreeInfo(myDiameter,myHeight);
        }

        public void zigZagTraversal(Node root) {
            Stack<Node> s1= new Stack<>();
            Stack<Node> s2 = new Stack<>();
            if(root== null)
                return;
            s1.add(root);
            while (!s1.isEmpty() || !s2.isEmpty()){
                while (!s1.isEmpty()){
                    Node currNode=s1.pop();
                    System.out.print( currNode.data+ " ");
                    if(currNode.right != null)
                        s2.add(currNode.right);
                    if(currNode.left != null)
                        s2.add(currNode.left);
                }
                System.out.println();
                while (!s2.isEmpty()){
                    Node currNode=s2.pop();
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null)
                        s1.add(currNode.left);
                    if(currNode.right != null)
                        s1.add(currNode.right);
                }
                System.out.println();
            }
        }

        public void verticalOrderTraversal(Node root) {
            Queue<Pair<Node, Integer>> queue= new LinkedList<>();
            Map<Integer,ArrayList<Integer>> map= new HashMap<>();
            queue.add(new Pair(root,0));
            while (!queue.isEmpty()){
                Pair<Node, Integer> p= queue.remove();
                if(!map.containsKey(p.index)){
                    map.put(p.index,new ArrayList<>());
                }
                map.get(p.index).add(p.node.data);
                if(p.node.left != null){
                    queue.add(new Pair(p.node.left,p.index-1));
                }
                if(p.node.right != null){
                    queue.add(new Pair(p.node.right,p.index+1));
                }
            }
            Set<Integer> keys=map.keySet();
            for(int key:keys){
                System.out.print("for index "+key+" :");
                for(int i:map.get(key)){
                    System.out.print(i+ " ");
                }
                System.out.println();
            }

        }

        private void preOrderToTravers(Node root, int d, Map<Integer, LinkedList<Integer>> map) {
            if(root==null){
                return;
            }
            if(!map.containsKey(d)){
                map.put(d,new LinkedList<>());
            }
            map.get(d).add(root.data);
            if(root.left != null)
                preOrderToTravers(root.left,d+1,map);
            if(root.right != null)
                preOrderToTravers(root.right,d,map);
        }
        public void diagonalTraversal(Node root) {
            Map<Integer, LinkedList<Integer>> map =new HashMap<>();
            int d=0;
            preOrderToTravers(root,d,map);
            Set<Integer> keys= map.keySet();
            int k=0;
            for(int key:keys){
                System.out.print("for diagonal "+k+ " nodes are : ");
                k++;
                for(int i=0;i<map.get(key).size();i++){
                    System.out.print(map.get(key).get(i)+" ");
                }
                System.out.println();
            }
        }

        public int checkIfTreeIsHeightBalancedOrNot(Node root, boolean[] isBalanced) {
            if(root== null){
                return 0;
            }
            int leftHeight=checkIfTreeIsHeightBalancedOrNot(root.left,isBalanced);
            int rightHeight= checkIfTreeIsHeightBalancedOrNot(root.right,isBalanced);

            if(Math.abs(rightHeight-leftHeight)>1){
                isBalanced[0]=false;
            }
            return leftHeight+rightHeight+1;
        }

        public void leftViewOFTree(Node root) {
            Queue<Node> queue= new LinkedList<>();
            if(root ==null){
                return;
            }
            boolean isFirst=true;
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()){
                Node currNode = queue.remove();
                if(currNode==null){
                    if(queue.size()==0){
                        return;
                    }else {
                        queue.add(null);
                        isFirst=true;
                    }
                }else {
                    if(isFirst){
                        System.out.print(currNode.data+" ");
                        isFirst=false;
                    }
                    if(currNode.left != null)
                        queue.add(currNode.left);
                    if(currNode.right != null)
                        queue.add(currNode.right);
                }
            }
        }

        public void rightViewOFTree(Node root) {
            Queue<Node> queue= new LinkedList<>();
            boolean isFirst=true;
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()){
                Node currNode=queue.remove();
                if(currNode==null){
                    if(queue.size()==0)
                        return;
                    else {
                        queue.add(null);
                        isFirst=true;
                    }
                }else {
                    if(isFirst){
                        System.out.print(currNode.data+" ");
                        isFirst=false;
                    }
                    if(currNode.right != null)
                        queue.add(currNode.right);
                    if(currNode.left != null)
                        queue.add(currNode.left);
                }
            }

        }

        public void topViewOfBinaryTree(Node root) {
            Queue<Pair<Node,Integer>> queue= new LinkedList<>();
            Map<Integer,ArrayList<Integer>> map= new HashMap<>();
            queue.add(new Pair<>(root,0));//--0 is horizontal distance from root
            while (!queue.isEmpty()){
                Pair<Node,Integer> p= queue.remove();
                if(!map.containsKey(p.index)){
                    map.put(p.index,new ArrayList<>());
                    map.get(p.index).add(p.node.data);
                }

                if(p.node.left != null)
                    queue.add(new Pair<>(p.node.left,p.index-1));
                if(p.node.right != null)
                    queue.add(new Pair<>(p.node.right,p.index+1));
            }
            for (Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
                System.out.print("for horizontal distance  from root "+ entry.getKey()+" top view ele is ");
                System.out.print(entry.getValue().get(0)+" ");
                System.out.println();
            }

        }

        public void bottomViewOfBinaryTree(Node root) {
            Queue<Pair<Node,Integer>> queue= new LinkedList<>();
            Map<Integer,ArrayList<Integer>> map= new HashMap<>();
            queue.add(new Pair<>(root,0));
            while (!queue.isEmpty()){
                Pair<Node,Integer> currNode=queue.remove();
                if(!map.containsKey(currNode.index)){
                    map.put(currNode.index,new ArrayList<>());
                }
                map.get(currNode.index).add(currNode.node.data);
                if(currNode.node.left!=null)
                    queue.add(new Pair<>(currNode.node.left, currNode.index-1));
                if(currNode.node.right!= null)
                    queue.add(new Pair<>(currNode.node.right, currNode.index+1));
            }
            for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()){
                System.out.print("for horizontal distance from root is "+ entry.getKey()+" and bottom view value of this is :");
                System.out.print(entry.getValue().get(entry.getValue().size()-1));
                System.out.println();
            }

        }
        private void leftBoundary(Node root, ArrayList<Integer> res) {
            if(root==null)
                return;
            if(root.left!= null){
                leftBoundary(root.left,res);
            } else if (root.right!= null) {
                leftBoundary(root.right,null);
            }
            if(root.left != null || root.right!= null){//---doing it at bottom because we need it bottom to up
                res.add(root.data);
            }
        }
        private void leafNode(Node root, ArrayList<Integer> res) {//-- using inorder traversal because it will give leaf node in same as boundary manner
            if(root ==null)
                return;
            leafNode(root.left,res);
            if(root.left ==null && root.right==null)
                res.add(root.data);
            leafNode(root.right,res);
        }

        private void rightBoundary(Node root, ArrayList<Integer> res) {
            if(root==null)
                return;
            if(root.right != null)
                rightBoundary(root.right, res);
            else if (root.left != null)
                rightBoundary(root.left, res);

            if(root.right != null || root.left != null)
                res.add(root.data);
        }

        public void boundaryTraversal(Node root) {
            ArrayList<Integer> res= new ArrayList<>();
            if(root!= null)
                res.add(root.data);
            if(root.left==null && root.right==null){
                System.out.println(root.data);
                return;
            }
            leftBoundary(root.left,res);
            leafNode(root,res);
            rightBoundary(root.right,res);
            System.out.println(res);

        }




        static class Pair<Node,Integer> implements Comparable<Pair<Node, java.lang.Integer>>{
            Node node;
            int index;
            Pair(Node node,int index){
                this.node=node;
                this.index=index;
            }
            @Override
            public int compareTo(Pair<Node, java.lang.Integer> p2){
                return 0;
            }
        }
        static class TreeInfo{
            int height;
            int diameter;

            TreeInfo(int diameter,int height){
                this.height=height;
                this.diameter=diameter;
            }
        }
    }


    public static void main(String rgs[]){
//        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};//--balanced tree
//        int nodes[] = {1, 2, 4, 5, 3, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};//-- for imbalanced height--left  skewed
        BinaryTree tree= new BinaryTree();
        Node root=tree.buildBinaryTree(nodes);
//        tree.printTreeInPreOrder(root);
//        tree.printTreeInOrder(root);
//        tree.printTreeInPostOrder(root);
//        tree.levelOrderTraversal(root);
//        tree.levelOrderTraversalRightToLeft(root);

//        System.out.println(tree.countOfNodesInTree(root));
//        System.out.println(tree.sumOfNodesInTree(root));
//        System.out.println(tree.heightOfTree(root));
//        System.out.println(tree.diameterOfTree(root));
//        BinaryTree.TreeInfo node= tree.diameterOfTreeApproach2(root);
//        System.out.println("diameter is : "+node.diameter);

//        tree.zigZagTraversal(root);
//        tree.verticalOrderTraversal(root);
//        tree.diagonalTraversal(root);
//        boolean[] isBalanced = {true};
//        tree.checkIfTreeIsHeightBalancedOrNot(root,isBalanced);
//        System.out.println(isBalanced[0]);
//        tree.leftViewOFTree(root);
//        tree.rightViewOFTree(root);
//        tree.topViewOfBinaryTree(root);
//        tree.bottomViewOfBinaryTree(root);
        tree.boundaryTraversal(root);

    }


}
