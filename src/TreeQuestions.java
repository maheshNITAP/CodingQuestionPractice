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
                System.out.print("-1 ");
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
        private void pathUtil(Node root, ArrayList<ArrayList<Integer>> path, ArrayList<Integer> currPath) {
            if(root==null){
                return;
            }
            currPath.add(root.data);
            if(root.left==null && root.right==null){
                path.add(new ArrayList<>(currPath));
            }
            pathUtil(root.left, path, currPath);
            pathUtil(root.right, path, currPath);
            currPath.remove(currPath.size()-1);
        }
        public void findAllRootToLeafPath(Node root) {
            if(root== null)
                return;
            ArrayList<ArrayList<Integer>> path= new ArrayList<>();
            ArrayList<Integer> currPath=new ArrayList<>();
            pathUtil(root,path,currPath);
            for (int i=0;i<path.size();i++){
                for(int ele:path.get(i)){
                    System.out.print(ele+" ");
                }
                System.out.println();
            }
        }

        private boolean sumUtil(Node root, int sum, int tempSum) {
            if(root==null)
                return false;
            tempSum+=root.data;
            if(tempSum==sum){
                return true;
            }
            boolean left = sumUtil(root.left, sum, tempSum);
            boolean right =sumUtil(root.right, sum, tempSum);
            tempSum-=root.data;
            return left || right;
        }
        public boolean rootToLeafPathSum(Node root, int sum) {
            int tempSum=0;
            return sumUtil(root,sum,tempSum);

        }
        private int maxPathSum(Node root, int currSum, int maxSum) {
            if(root==null){
                return maxSum;
            }
            currSum+=root.data;
            if(root.left==null && root.right==null && currSum>maxSum){
                maxSum=currSum;
            }
             int leftMax=maxPathSum(root.left,currSum,maxSum);
            int rightMax=maxPathSum(root.right,currSum,maxSum);
            return Math.max(leftMax,rightMax);
        }
        public void rootToLeafMaxPathSum(Node root) {
            int currSum=0;
            int maxSum=Integer.MIN_VALUE;
             maxSum=maxPathSum(root,currSum,maxSum);
            System.out.println(maxSum);
        }

        public void kThDistanceNodeFormRoot(Node root, int k, ArrayList<Integer> list) {
            if(root==null){
                return;
            }
            if(k==0){
                list.add(root.data);
            }
            kThDistanceNodeFormRoot(root.left,k-1,list);
            kThDistanceNodeFormRoot(root.right,k-1,list);
        }

        private void nodeParentMapping(Node root, HashMap<Node, Node> map, Node parent) {
            if(root==null){
                return;
            }
            map.put(root,parent);
            nodeParentMapping(root.left,map,root);
            nodeParentMapping(root.right,map,root);
        }
        public List<Integer> distanceK(Node root, Node target, int k) {// working solution in leetcode also
            List<Integer> list= new ArrayList<>();
            HashMap<Node,Node> map= new HashMap<>();//<Node,parent>
            nodeParentMapping(root,map,null);
            Queue<Node> queue= new LinkedList<>();
            Set<Node> set= new HashSet<>();
            queue.add(target);
            while(k>0){
                int count= queue.size();
                while (count>0){
                    Node currNode=queue.remove();
                    set.add(currNode);
                    if(currNode.left!= null && !set.contains(currNode.left)){
                        queue.add(currNode.left);
                    }
                    if(currNode.right != null && !set.contains(currNode.right)){
                        queue.add(currNode.right);
                    }
                    if( map.containsKey(currNode) && !set.contains(map.get(currNode)) && map.get(currNode) != null){
                        queue.add(map.get(currNode));
                    }
                }
                k=k-1;
            }
            while(!queue.isEmpty()){
                Node temp=queue.remove();
                list.add(temp.data);
            }
            return list;
        }
        private static boolean isIdentical(Node root, Node root2) {
            if(root== null && root2==null){
                return true;
            }
            if(root== null || root2 == null){
                return false;
            }
            return isIdentical(root.left,root2.left) && isIdentical(root.right,root2.right);
        }
        private static boolean checkForSubTree(Node root, Node root2) {
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node currNode=queue.remove();
                if(currNode.data==root2.data){
                    if(isIdentical(currNode,root2)){
                        return true;
                    }
                }
                if(currNode.left!= null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            return false;
        }

        private static boolean isItMirror(Node root, Node root2) {
            if(root== null &&  root2==null){
                return true;
            }
            if(root==null || root2==null){
                return false;
            }
            if(root.data != root2.data){
                return false;
            }
            return isItMirror(root.left,root2.right) && isItMirror(root.right,root2.left);
        }

        public boolean isSymmetric(Node root) {
            if(root== null) return true;
            return isItMirror(root.left,root.right);
        }

        private void invertTree(Node root) {
            if(root== null) return;

            Node temp= root.left;
            root.left=root.right;
            root.right=temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        public Node invertBinaryTree(Node root) {
            if(root == null) return null;
            invertTree(root);
            return root;
        }

        public int isSumTree(Node root, boolean[] isSumTree) {
            if(root== null) return 0;
            if(root.left==null && root.right==null){
                return root.data;


            }
            int leftSum=isSumTree(root.left,isSumTree);
            int rightSum=isSumTree(root.right,isSumTree);
            if(leftSum+rightSum !=  root.data){
                isSumTree[0]=false;
            }
            return leftSum+rightSum+root.data;
        }

        public void treeSumCheck(Node root) {
            boolean isSumTree[]=new boolean[1];
            isSumTree[0]=true;
            if(root==null){
                System.out.println("");
            }
            int leftSum=isSumTree(root.left,isSumTree);
            int rightSum=isSumTree(root.right,isSumTree);

            if(leftSum+rightSum==root.data && isSumTree[0]){
                System.out.println("this tree is a sum tree");
            }else {
                System.out.println("This tree is not a sum tree");
            }
        }

        public int transformToSumTree(Node root) {
            if(root ==null)return 0;
            int leftSum=transformToSumTree(root.left);
            int rightSum=transformToSumTree(root.right);
            int val=leftSum+rightSum+root.data;
            root.data=leftSum+rightSum;
            return val;
        }

        public Node lowestCommonAncestor(Node root, int a, int b) {
            if (root == null) {
                return null;
            }
            if(root.data==a || root.data==b){
                return root;
            }
            Node left=lowestCommonAncestor(root.left,a,b);
            Node right=lowestCommonAncestor(root.right,a,b);
            if(left != null && right != null){
                return root;
            }
            if(left!= null){
                return left;
            }
            if(right!=null){
                return right;
            }
            return null;
        }
        private int distanceOfNode(Node root, int a, int dis) {
            if(root==null){
                return Integer.MAX_VALUE;
            }
            if(root.data==a){
                return dis;
            }
            int leftDistance=distanceOfNode(root.left,a,dis+1);
            int rightDistance=distanceOfNode(root.right,a,dis+1);
            return Math.min(leftDistance,rightDistance);
        }

        public int distanceBetweenTwoNodes(Node root, int a, int b) {
            Node lca= lowestCommonAncestor(root,a,b);
            int d1=distanceOfNode(lca,a,0);
            int d2=distanceOfNode(lca,b,0);
            return d1+d2;
        }

        public Node checkIfTwoNodesAreInSamePathByLCA(Node root, int a, int b, boolean[] flag) {
            if(root== null){
                return null;
            }
            if(root.data==a || root.data==b){
                return root;
            }
            Node left= checkIfTwoNodesAreInSamePathByLCA(root.left,a,b,flag);
            Node right= checkIfTwoNodesAreInSamePathByLCA(root.right,a,b,flag);
            if(left!= null && right!=null){
                flag[0]=false;//agar left or right dono side pr element h to dono same path pr nhi h
                return  root;
            }
            if(left!=null){
                return left;
            }
            if(right!= null){
                return right;
            }
            return null;
        }
        static Node head;
        static Node tail;

        public void binaryTreeToDoublyLL(Node root) {
            if(root==null) return;
            binaryTreeToDoublyLL(root.left);
            if(head== null){
                head=root;
            }else {
                root.left=tail;
                tail.right=root;
            }
            tail=root;//--needed in both cases
            binaryTreeToDoublyLL(root.right);
        }

        public Node binaryTreeToLeafDoublyLL(Node root) {
            if(root==null) return null;
            if(root.left == null && root.right==null){
                if(head==null){
                    head=root;
                }else {
                    root.left=tail;
                    tail.right=root;
                }
                tail=root;
                return null;//--to remove that node from tree we need to return null,bcz we added that node in LL
            }
            root.left=binaryTreeToLeafDoublyLL(root.left);
            root.right=binaryTreeToLeafDoublyLL(root.right);
            return root;
        }

        public Node constructCompleteBinaryTreeFromLL(int[] arr) {
            ArrayList<Node> arrList= new ArrayList<>();
            for(int i=0;i< arr.length;i++){
                arrList.add(new Node(arr[i]));
            }
            int n= arrList.size();
            for(int i=0;i<n;i++){
                if((2*i)+1<n){
                    arrList.get(i).left=arrList.get((2*i)+1);
                }
                if((2*i)+2<n){
                    arrList.get(i).right=arrList.get((2*i)+2);
                }
            }
            return arrList.get(0);

        }

        private int searchElePosition(int[] in, int ins, int ine, int ele) {
            for(int i=ins;i<=ine;i++){
                if(ele==in[i]){
                    return i;
                }
            }
            return -1;
        }
        public Node buildTreeByInorderAndPreOrderTraversal(int[] pre, int[] in, int[] start, int ins, int ine) {
            if(ins>ine){
                return null;
            }
            Node root=new Node(pre[start[0]]);
            int mid=searchElePosition(in,ins,ine,pre[start[0]]);
            start[0]++;
            root.left=buildTreeByInorderAndPreOrderTraversal(pre,in,start,ins,mid-1);
            root.right=buildTreeByInorderAndPreOrderTraversal(pre,in,start,mid+1,ine);
            return root;
        }

        public Node buildTreeByPostOrderAndInOrderTraversal(int[] post, int[] in, int[] start, int ins, int ine) {
            if(ins>ine){
                return null;
            }
            Node root= new Node(post[start[0]]);
            int mid = searchElePosition(in,ins,ine,post[start[0]]);
            start[0]--;
            root.right=buildTreeByPostOrderAndInOrderTraversal(post,in,start,mid+1,ine);
            root.left=buildTreeByPostOrderAndInOrderTraversal(post,in,start,ins,mid-1);
            return root;
        }

        private ArrayList<Integer> createNewInOrder(ArrayList<Integer> in, int start, int end) {
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=start;i<=end;i++){
                arr.add(in.get(i));
            }
            return arr;
        }

        private int searchElePosition(ArrayList<Integer> in, int ele) {
            for(int i=0;i<in.size();i++){
                if(in.get(i).equals(ele)){
                    return i;
                }
            }
            return -1;
        }
        private ArrayList<Integer> findEleInLevel(ArrayList<Integer> in, ArrayList<Integer> level, int start, int end) {
            ArrayList<Integer> res= new ArrayList<>();
            for (int i=0;i<level.size();i++){
                for(int j=start;j<=end;j++){
                    if(level.get(i).equals(in.get(j))){
                        res.add(level.get(i));
                    }
                }
            }
            return res;
        }
        public Node buildTreeByLevelOrderAndInOrderTraversal(ArrayList<Integer> level, ArrayList<Integer> in) {
            if(in.size()==0)return null;
            Node root= new Node(level.get(0));
            int mid=searchElePosition(in,level.get(0));
            ArrayList<Integer> v1=createNewInOrder(in,0,mid-1);
            ArrayList<Integer> v2=createNewInOrder(in,mid+1,in.size()-1);

            ArrayList<Integer> left=findEleInLevel(in,level,0,mid-1);
            ArrayList<Integer> right=findEleInLevel(in,level,mid+1,in.size()-1);
            root.left=buildTreeByLevelOrderAndInOrderTraversal(v1,left);
            root.right=buildTreeByLevelOrderAndInOrderTraversal(v2,right);
            return root;
        }

        public Node2 expressionTreeBuildByPrefix(String s, int[] curr) {
            if(s.length()==curr[0]){
                return null;
            }
            Node2 root= new Node2(Character.toString(s.charAt(curr[0])));
            curr[0]++;
            if(Character.isDigit(root.data.charAt(0))){
                return root;
            }else {
                root.left=expressionTreeBuildByPrefix(s,curr);
                root.right=expressionTreeBuildByPrefix(s,curr);
            }
            return root;
        }

        public void printTreeInPreOrderForStringNode(Node2 root) {
            if(root==null){
                System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            printTreeInPreOrderForStringNode(root.left);
            printTreeInPreOrderForStringNode(root.right);
        }

        public Node2 expressionTreeBuildByPostFixNotation(String s, int[] curr) {
            if(curr[0]<0){
                return null;
            }
            Node2 root= new Node2(Character.toString(s.charAt(curr[0])));
            curr[0]--;
            if(Character.isAlphabetic(root.data.charAt(0))){
                return root;
            }else {
                root.right=expressionTreeBuildByPostFixNotation(s,curr);
                root.left=expressionTreeBuildByPostFixNotation(s,curr);
            }
            return root;
        }

        public void serializationOfTree(Node root, ArrayList<Integer> arr) {
            if(root==null){
                arr.add(-1);
                return;
            }
            arr.add(root.data);
            serializationOfTree(root.left,arr);
            serializationOfTree(root.right,arr);
        }

        public Node deSerialization(ArrayList<Integer> arr) {
            if(arr.size()==0){
                return null;
            }
            if(arr.get(0)==-1){
                arr.remove(0);
                return null;
            }
            Node root= new Node(arr.get(0));
            arr.remove(0);
            root.left=deSerialization(arr);
            root.right=deSerialization(arr);
            return root;
        }

        static class Node2{
            String data;
            Node2 left=null;
            Node2 right=null;
            Node2(String  data){
                this.data=data;
            }
        }

        public int treeExpressionEvaluation(Node2 root) {
            if(root==null){
                return 0;
            }
            if(root.left!= null && root.right!= null){
                return Integer.parseInt(root.data);
            }
            int l=treeExpressionEvaluation(root.left);
            int r=treeExpressionEvaluation(root.right);
            if(root.data.equals("*")){
                return l*r;
            } else if (root.data.equals("+")) {
                return l+r;
            } else if (root.data.equals("-")) {
                return l-r;
            }else {
                return l/r;
            }

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
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};//--balanced tree, aSymmetric
//        int nodes[]={1,2,3,-1,-1,4,5,-1,-1,-1,2,4,-1,5,-1,-1,3,-1,-1};--symmatric
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
//        tree.boundaryTraversal(root);
//        tree.findAllRootToLeafPath(root);
//        int sum=10;//---root tol leaf path sum is equal to given sum or not
//        System.out.println(tree.rootToLeafPathSum(root,sum));
//        tree.rootToLeafMaxPathSum(root);
//        int k=1;
//        ArrayList<Integer> list= new ArrayList<>();
//        tree.kThDistanceNodeFormRoot(root,k,list);
//        System.out.println(list);

        //k distance from target node
        //distanceK()

        //check if tow binary tree's are identical
////        int nodes2[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
//        int nodes2[] = {1, 2, 4, 5, 3, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};
//        BinaryTree.index=-1;//we need to start again from 0 bcz it is static--for outOfArrayIndex
//        BinaryTree tree2= new BinaryTree();
//        Node root2= tree2.buildBinaryTree(nodes2);
//        System.out.println(tree2.isIdentical(root,root2));

//        //Check if given subTree is present in main tree of not
//        BinaryTree.index=-1;
////        int nodes2[]={2,4,-1,-1,5,-1,-1};//---for true
//        int nodes2[] = {1, 2, 4, 5, 3, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};//-- for false
//        BinaryTree tree2= new BinaryTree();
//        Node root2=tree2.buildBinaryTree(nodes2);
//        System.out.println(tree2.checkForSubTree(root,root2));

        //check for mirror trees
//        BinaryTree.index=-1;
////        int nodes2[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};//-----for mirror tree false
//          int nodes2[]={1,3,7,-1,-1,6,-1,-1,2,5,-1,-1,4,-1,-1};//--for mirror tree true
//        BinaryTree tree2= new BinaryTree();
//        Node root2=tree2.buildBinaryTree(nodes2);
//        System.out.println(tree2.isItMirror(root,root2));

        //Check if tree is Symmetric------int nodes[]={1,2,3,-1,-1,4,5,-1,-1,-1,2,4,-1,5,-1,-1,3,-1,-1};--symmatric
//        System.out.println(tree.isSymmetric(root));

        //Invert Binary Tree
//        tree.printTreeInPreOrder(root);
//        System.out.println();
//        Node invertedTree=tree.invertBinaryTree(root);
//        tree.printTreeInPreOrder(invertedTree);

        //check Binary tree for sum tree
//        int nodes1[]={22,6,4,-1,-1,2,-1,-1,5,1,-1,-1,4,-1,-1};//for sum tree
//        BinaryTree tree1= new BinaryTree();
//        BinaryTree.index=-1;
//        Node root1=tree1.buildBinaryTree(nodes1);
//        tree1.treeSumCheck(root1);

        //transform to sum tree
//        System.out.println(tree.transformToSumTree(root));
//        tree.printTreeInPreOrder(root);

        //lowest common ancestor in Tree(lca)
//        int a=2;int b=3;//----ans=1
//        int a=4;int b=5;//---ans=2;
//        Node lca=tree.lowestCommonAncestor(root,a,b);
//        System.out.println(lca.data);

        //Distance between two nodes in binary tree
//        int a=4,b=7;
//        int a=2,b=3;
//        int a=2,b=10;
//        System.out.println(tree.distanceBetweenTwoNodes(root,a,b));

        //check if two nodes are on same path
//        int a=4,b=7;//--NOt in same path
//        int a=1,b=4;
//        boolean flag[] = new boolean[1];
//        flag[0]=true;
//        tree.checkIfTwoNodesAreInSamePathByLCA(root,a,b,flag);
//        if(flag[0]){
//            System.out.println("Both nodes are in same path");
//        }else {
//            System.out.println("Both nodes are NOT in same path");
//        }

        //convertBinaryTreeToDoublyLL
//        tree.binaryTreeToDoublyLL(root);
//        while(BinaryTree.head!= null){
//            System.out.print(BinaryTree.head.data+" ");
//            BinaryTree.head=BinaryTree.head.right;
//        }

        //convertBinaryTreeToLeafDoublyLL
//        tree.binaryTreeToLeafDoublyLL(root);
//        while(BinaryTree.head!= null){
//            System.out.print(BinaryTree.head.data+" ");
//            BinaryTree.head=BinaryTree.head.right;
//        }
//        System.out.println();
//        tree.printTreeInPreOrder(root);

        //constructCompleteBinaryTreeFromLL
//        int arr[]={1,2,3,4,5,6,7};//-- mana ki yeh LL h
//        Node root1=tree.constructCompleteBinaryTreeFromLL(arr);
//        tree.printTreeInPreOrder(root1);

        //construct a tree from PreOrder and Inorder traversal
//        int pre[]={1,2,4,5,3,7};
//        int in[]={4,2,5,1,3,7};
//        int start[]=new int[1];
//        int ins=0;//--InorderStart
//        int ine=in.length-1;
//        Node root1=tree.buildTreeByInorderAndPreOrderTraversal(pre,in,start,ins,ine);
//        tree.printTreeInPreOrder(root1);

        //construct a tree from postOrder and Inorder traversal
//        int post[]={6,2,4,5,3,1};
//        int in[]={6,2,1,4,3,5};
//        int start[]=new int[1];
//        start[0]=post.length-1;
//        int ins=0;
//        int ine=in.length-1;
//        Node root1=tree.buildTreeByPostOrderAndInOrderTraversal(post,in,start,ins,ine);
//        tree.printTreeInPreOrder(root1);

        //construct a binary tree from levelOrder and InOrder
//        Integer level[]={1,2,3,4,5,6};
//        ArrayList<Integer> levelArrayList = new ArrayList<>(Arrays.asList(level));
//        Integer in[]={4,2,5,1,3,6};
//        ArrayList<Integer> inOrderArrayList = new ArrayList<>(Arrays.asList(in));
//        Node root1= tree.buildTreeByLevelOrderAndInOrderTraversal(levelArrayList,inOrderArrayList);
//        tree.printTreeInPreOrder(root1);

        //Expression Tree---we don't have input data here
//        BinaryTree.Node2 root2=null;
//        tree.treeExpressionEvaluation(root2);

        //Construct Expression tree from prefix notation
//        String s="*+34/76";// prefix--->preOrder
//        int curr[]= new int[1];
//        BinaryTree.Node2 root2= tree.expressionTreeBuildByPrefix(s,curr);
//        tree.printTreeInPreOrderForStringNode(root2);

        //construct Expression tree from postFix Notation
//        String s= "ab-c+de/*";
//        int curr[]=new int[1];
//        curr[0]=s.length()-1;
//        BinaryTree.Node2 root2= tree.expressionTreeBuildByPostFixNotation(s,curr);
//        tree.printTreeInPreOrderForStringNode(root2);

        //Serialization Of a tree
        ArrayList<Integer> arr= new ArrayList<>();
        tree.serializationOfTree(root,arr);
        System.out.println(arr);

        //deSerialization
        Node root2=tree.deSerialization(arr);
        tree.printTreeInPreOrder(root2);



    }




}
