import java.util.*;

public class GraphQuestions {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraphForDFS_BFS(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,5));

        graph[2].add(new Edge(2,6));

        graph[3].add(new Edge(3,6));

        graph[4].add(new Edge(4,5));
    }
    
    public static void createGraphForCycleDetection(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,1));
    }
    public static void createGraphForCycleDetectionInDirectedGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,3));
//        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[5].add(new Edge(5,4));
    }

    public static void createGraphForTopologicalSorting(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }


        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,5));
    }

    public static void createGraphForKosaRajuAlgo(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,7));

        graph[6].add(new Edge(6,9));

        graph[7].add(new Edge(7,8));

        graph[8].add(new Edge(8,5));

    }


    public static void createGraphForTarjanAlgo(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));

    }
    public static void createGraphForMotherVertex(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,3));
        graph[4].add(new Edge(4,5));


        //for no mother vertex
//        graph[0].add(new Edge(0,1));
//
//        graph[1].add(new Edge(1,2));
//        graph[3].add(new Edge(3,0));
    }

    public static void createGraphForCountSourceToDestinationPath(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,4));
    }

    public static void createGraphForBipartiteGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,5));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,4));

    }


    public static void createGraphForHamiltonionPath(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,5));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
    }

    public static void createGraphForGraphColoringProblem(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,5));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,4));
    }



    public static void graphBFS(ArrayList<Edge> graph[],int start,boolean vis[]){
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int curr= queue.remove();
            if(!vis[curr]){
                vis[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    if(!vis[e.dest]){
                        queue.add(e.dest);
                    }
                }
            }
        }
    }

    public static void graphDFS(ArrayList<Edge> graph[],int curr,boolean vis[]){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                graphDFS(graph,e.dest,vis);
            }
        }
    }
    
    public static boolean detectCycleInUnDirectedGraph(ArrayList<Edge> graph[],int curr,int parent,boolean vis[]){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(vis[e.dest] && e.dest!=parent){
                return true;
            }
            if (!vis[e.dest]) {
                if(detectCycleInUnDirectedGraph(graph,e.dest,curr,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleInDirectedGraph(ArrayList<Edge> graph[], int curr,boolean vis[],boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(vis[e.dest] && rec[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(detectCycleInDirectedGraph(graph,e.dest,vis,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }

    public static void topologicalSorting(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> st){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSorting(graph,e.dest,vis,st);
            }
        }
        st.push(curr);
    }

    public static void kosaRajuAlgo(ArrayList<Edge> graph[],int V){
        //step-1 topological sort
        Stack<Integer> st= new Stack<>();
        boolean vis[]= new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topologicalSorting(graph,i,vis,st);
            }
        }

        //step-2--->transpose graph
        ArrayList<Edge> transpose[]= new ArrayList[V];
        for(int i=0;i<V;i++){// initialize array
            vis[i]=false;
            transpose[i]= new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e= graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        //dfs on transposed in topologicalSorted order
        while (!st.isEmpty()){
            int curr= st.pop();
            if(!vis[curr]){
                graphDFS(transpose,curr,vis);
                System.out.println();
            }
        }

    }
    public static void tarjanAlgoForFindBridge(ArrayList<Edge> graph[],int curr,int parent,int time, boolean vis[],int dist[],int low[]){
        dist[curr]=low[curr]=++time;
        vis[curr]=true;
        for(int i=0;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dest==parent){
                continue;
            } else if (!vis[e.dest]) {
                tarjanAlgoForFindBridge(graph,e.dest,curr,time,vis,dist,low);
                low[curr]= Math.min(low[curr],low[e.dest]);
                if(dist[curr]< low[e.dest]){
                    System.out.println("Bridge is "+curr+" ---> "+e.dest);
                }
            }else if(vis[e.dest]){
                low[curr]=Math.min(low[curr],dist[e.dest]);
            }

        }


    }
    public static void getBridgeInGraph(ArrayList<Edge> graph[],int v){
        boolean vis[]= new boolean[v];
        int low[]= new int[v];
        int dist[]= new int[v];
        int time=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                tarjanAlgoForFindBridge(graph,i,-1,0,vis,dist,low);
            }
        }

    }


    public static boolean isValid(int graph[][],boolean vis[][],int x, int y,int v){
        if(x>=0 && x<v && y>=0 && y<v && !vis[x][y] && graph[x][y]==1){
            return true;
        }
        return false;
    }

    private static void dfsToFindNumberOfIslandsForAllDirection(int[][] graph, boolean[][] vis, int x, int y, int v) {
        vis[x][y]=true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==j && i==0){
                    continue;
                }
                if(isValid(graph,vis,x+i,y+j,v)){
                    dfsToFindNumberOfIslandsForAllDirection(graph,vis,x+i,y+j,v);
                }
            }
        }
    }
    private static void dfsToFindNumberOfIslandsForConnectingAdjacentLandsHorizontallyOrVertically(int[][] graph, boolean[][] vis, int i, int j, int v) {
        vis[i][j]=true;
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            if(isValid(graph, vis, i+x[k], j+y[k], v)){
                dfsToFindNumberOfIslandsForConnectingAdjacentLandsHorizontallyOrVertically(graph, vis, i+x[k], j+y[k], v);
            }
        }
    }

    public static int motherVertexInGraph(ArrayList<Edge> graph[],int v){
        boolean vis[]= new boolean[v];
        int lastDfsNode=-1;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                graphDFS(graph,i,vis);
                lastDfsNode=i;
            }
        }
        for(int i=0;i<v;i++){
            vis[i]=false;
        }
        graphDFS(graph,lastDfsNode,vis);
        for(int i=0;i<v;i++){
            if(!vis[i]){
                return -1;
            }
        }
        return lastDfsNode;

    }


    public static boolean isValidLocation(int graph[][],int x,int y,int row,int col,int newColor,int oldColor){
        if(x>=0 && x<row && y>=0 && y<col && graph[x][y]==oldColor){
            return true;
        }
        return false;
    }
    public static void floodFillAlgo(int graph[][],int i,int j,int oldColor, int newColor,int row,int col){
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            if(isValidLocation(graph,i+x[k],j+y[k],row,col,newColor,oldColor)){
                graph[i+x[k]][j+y[k]]=newColor;
                floodFillAlgo(graph,i+x[k],j+y[k],oldColor,newColor,row,col);
            }
        }
    }

    public static void countSourceToDestinationPaths(ArrayList<Edge> graph[],int start,int destination,boolean vis[],int[] count){
        if(start==destination){
            count[0]++;
            return;
        }
        vis[start]=true;
        for(int i=0;i<graph[start].size();i++){
            Edge e= graph[start].get(i);
            if(!vis[e.dest]){
                countSourceToDestinationPaths(graph, e.dest, destination, vis, count);
            }
        }
        vis[start]=false;
    }
    public static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Pair p2){
            return this.x- p2.x;

        }


    }
    private static void pushNeighbours(Pair p, Queue<Pair> queue, int[][] matrix, int row, int col) {
        int x= p.x;
        int y= p.y;

        int xx[]={-1,1,0,0};
        int yy[]={0,0,-1,1};
        for(int i=0;i<4;i++){
            if(x+xx[i]>=0 && x+xx[i]<row && y+yy[i]>=0 && y+yy[i]<col && matrix[x+xx[i]][y+yy[i]]==1){
                queue.add(new Pair(x+xx[i],y+yy[i]));
                matrix[x+xx[i]][y+yy[i]]=2;
            }
        }
    }

    private static int orangesRotting(int[][] matrix, int row, int col) {
        Queue<Pair> queue= new PriorityQueue<>();
        int time=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==2){
                    queue.add(new Pair(i,j));
                }
            }
        }
        int count= queue.size();
        while (count>0){
            for(int i=0;i<count;i++){
                Pair p = queue.remove();
                pushNeighbours(p,queue,matrix,row,col);
            }
            count= queue.size();
            if(count>0){
                time++;
            }
        }

        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }

    public static class chessIndexPair implements Comparable<chessIndexPair>{
        int x;
        int y;

        public chessIndexPair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(chessIndexPair p2){
            return 0;
        }
    }

    private static boolean exploreKnightNeighbours(int x, int y, int d1, int d2, boolean[][] vis, boolean found, int n, Queue<chessIndexPair> queue) {
        int xx[]={-1,-1,1,1,2,2,-2,-2};
        int yy[]={-2,2,2,-2,1,-1,1,-1};

        for(int i=0;i<8;i++){
            if(x+xx[i]>=0 && x+xx[i]<n && y+yy[i]>=0 && y+yy[i]<n && vis[x+xx[i]][y+yy[i]]!=true){
                if(x+xx[i]==d1 && y+yy[i]==d2){
                    found=true;
                    return true;
                }
                queue.add(new chessIndexPair(x+xx[i],y+yy[i]));
                vis[x+xx[i]][y+yy[i]]=true;

            }
        }
        return false;
    }
    private static int minStepToReachTarget(chessIndexPair knightPos, chessIndexPair targetPos, int n) {
        int s1= knightPos.x-1;
        int s2= knightPos.y-1;
        int d1= targetPos.x-1;
        int d2= targetPos.y-1;

        if(s1==d1 && s2==d2)
            return 0;

        boolean vis[][]= new boolean[n][n];
        Queue<chessIndexPair> queue= new LinkedList<>();
        queue.add(new chessIndexPair(s1,s2));
        vis[s1][s2]=true;
        int count= queue.size();
        int step=0;
        boolean found = false;
        while (count>0){
            step++;
            for(int i=0;i<count;i++){
                chessIndexPair p= queue.remove();
                if(exploreKnightNeighbours(p.x,p.y,d1,d2,vis,found,n,queue)){
                    return step;
                }

            }
            count= queue.size();
        }
        return step;
    }

    private static boolean isBipartiteDFS(ArrayList<Edge>[] graph, int[] col, int curr, int parent, int color) {
        col[curr]=color;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(col[e.dest]==-1){
                if(!isBipartiteDFS(graph, col, e.dest, curr, 1-color)){
                    return false;
                }
            } else if (col[e.dest]==col[curr]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hamiltonPathDFS(ArrayList<Edge>[] graph, int curr, boolean[] vis, int count, int v) {
        vis[curr]=true;
        count++;
        if(count==v)
            return true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                if(hamiltonPathDFS(graph, e.dest, vis, count, v))
                    return true;
            }
        }
        vis[curr]=false;
        count--;
        return false;
    }
    private static boolean hamiltonPath(ArrayList<Edge>[] graph, int v) {
        boolean vis[]= new boolean[v];
        boolean flag =false;
        for(int i=0;i<v;i++){
            Arrays.fill(vis,false);
            if(hamiltonPathDFS(graph,i,vis,0,v)){
                return true;
            }
        }
        return false;
    }
    private static boolean isSafe(int curr, int i, ArrayList<Edge>[] graph, int[] color, int v) {
        for(int j=0;j<graph[curr].size();j++){
            Edge e= graph[curr].get(j);
            if(color[e.dest]==i){
                return false;
            }
        }
        return true;
    }
    private static boolean   mColoringProblem(ArrayList<Edge>[] graph, int curr, int v, int[] color, int m) {
        if(curr==v-1){
            return true;
        }
        for(int i=0;i<m;i++){
            if(isSafe(curr,i,graph,color,v)){
                color[curr]=i;
                if(mColoringProblem(graph, curr+1, v, color, m)){
                    return true;
                }
            }
        }
        color[curr]=-1;
        return false;
    }




    public static void main(String args[]){
//        int n=7;
//        ArrayList<Edge> graph[] = new ArrayList[n];
//        boolean vis[]= new boolean[n];
//        createGraphForDFS_BFS(graph);
//        for(int i=0;i< vis.length;i++){
//            if(!vis[i]){
////                graphBFS(graph,i,vis);
//                graphDFS(graph,i,vis);
//            }
//        }

        //detectCycleInUnDirectedGraph
//        int n=5;
//        ArrayList<Edge> graph[]= new ArrayList[n];
//        boolean vis[]= new boolean[n];
//        createGraphForCycleDetection(graph);
//        for (int i=0;i< vis.length;i++){
//            if(!vis[i]){
//                System.out.println(detectCycleInUnDirectedGraph(graph,i,-1,vis));
//            }
//        }

        //detectCycleInDirectedGraph----> in this we need to store parental in array bcz if any node is visited that's not mean that is parent of current node
//        int n=6;
//        ArrayList<Edge> graph[] = new ArrayList[n];
//        boolean vis[]= new boolean[n];
//        boolean rec[]= new boolean[n];
//        createGraphForCycleDetectionInDirectedGraph(graph);
//        for(int i=0;i<vis.length;i++){
//            if(!vis[i]){
//                System.out.println(detectCycleInDirectedGraph(graph,i,vis,rec));
//            }
//        }

        //topological sorting
//        int n=6;
//        ArrayList<Edge> graph[] = new ArrayList[n];
//        boolean vis[]= new boolean[n];
//        Stack<Integer> st= new Stack<>();
//        createGraphForTopologicalSorting(graph);
//        for(int i=0;i< vis.length;i++){
//            if(!vis[i]){
//                topologicalSorting(graph,i,vis,st);
//            }
//        }
//        while (!st.isEmpty()){
//            System.out.println(st.pop());
//        }


        //kosaRaju Algorithm----> SSC
//        int v=10;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForKosaRajuAlgo(graph);
//        kosaRajuAlgo(graph,v);


        //getBridgeInGraph
//        int v=6;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForTarjanAlgo(graph);
//        getBridgeInGraph(graph,v);


        //number of islands in all 8 directions
//        int v=5;
//        int graph[][]= {{1,1,0,0,0}, {1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1},{0,0,0,0,0}};
//        boolean vis[][]= new boolean[v][v];
//        int count=0;
//        for(int i=0;i<v;i++){
//            for(int j=0;j<v;j++){
//                if( graph[i][j]==1 && !vis[i][j]){
//                    count++;
//                    dfsToFindNumberOfIslandsForAllDirection(graph,vis,i,j,v);
//                }
//            }
//        }
//        System.out.println("number of Islands ---> "+ count);


//        int v=5;
//        int graph[][]= {{1,1,0,0,0}, {1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1},{0,0,0,0,0}};
//        boolean vis[][]= new boolean[v][v];
//        int count=0;
//        for(int i=0;i<v;i++){
//            for(int j=0;j<v;j++){
//                if(graph[i][j]==1 && !vis[i][j]){
//                    count++;
//                    dfsToFindNumberOfIslandsForConnectingAdjacentLandsHorizontallyOrVertically(graph,vis,i,j,v);
//                }
//            }
//        }
//        System.out.println("number of Islands ---> "+ count);

        //Mother vertex
//        int v=6;
//        ArrayList<Edge> graph[]= new ArrayList[6];
//        createGraphForMotherVertex(graph);
//        int motherVertex= motherVertexInGraph(graph,v);
//        System.out.println();
//        if(motherVertex==-1){
//            System.out.println("there is no mother vertex");
//        }else {
//            System.out.println("mother vertex is :"+ motherVertex);
//        }

        //Flood fill algo
//        int[][] screen ={
//                {1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 0, 0},
//                {1, 0, 0, 1, 1, 0, 1, 1},
//                {1, 2, 2, 2, 2, 0, 1, 0},
//                {1, 1, 1, 2, 2, 0, 1, 0},
//                {1, 1, 1, 2, 2, 2, 2, 0},
//                {1, 1, 1, 1, 1, 2, 1, 1},
//                {1, 1, 1, 1, 1, 2, 2, 1}};
//        int x=4;
//        int y=4;
//        int newColor=3;
//        int oldColor=screen[x][y];
//        int row= screen.length;
//        int col= screen[0].length;
//        floodFillAlgo(screen,x,y,oldColor,newColor,row,col);
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++){
//                System.out.print(screen[i][j]+ " ");
//            }
//            System.out.println();
//        }

        //count source to destination paths
//        int v=5;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        boolean vis[] = new boolean[v];
//        createGraphForCountSourceToDestinationPath(graph);
//        int[] count = {0};
//        int start=0;
//        int dest=4;
//        countSourceToDestinationPaths(graph,0,4,vis,count);
//        System.out.println("number of Possible Paths : "+count[0]);

        //rotten oranges
            //---0 is empty cell/wall
            //--1 is fresh orange
            //--2 is rotten orange
//        int[][] matrix = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int row= matrix.length;
//        int col= matrix[0].length;
//        System.out.println("number of time to rotten all orange :"+ orangesRotting(matrix,row,col));

        //Steps by Knight
//        int n=6;
//        Scanner sc= new Scanner(System.in);
//        int startPosX = sc.nextInt();
//        int startPosY= sc.nextInt();
//
//        int destPosX= sc.nextInt();
//        int destPosY=sc.nextInt();
//        chessIndexPair knightPos = new chessIndexPair(4,5);
//        chessIndexPair targetPos= new chessIndexPair(1,1);
//        System.out.println(minStepToReachTarget(knightPos,targetPos,n));


        //Bipartite Graph
//        int v=6;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForBipartiteGraph(graph);
//        int color=0;//color of node
//        int col[]= new int[v];
//        Arrays.fill(col, -1);
//        boolean isBipartite= isBipartiteDFS(graph,col,0,-1,color);
//        System.out.println( "is this graph Bipartite :"+ isBipartite);

//        //Hamiltonian path
//        int v=6;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForHamiltonionPath(graph);
//        System.out.println("Is this graph have Hamilton path:"+ hamiltonPath(graph,v));


// graph coloring problem
        int v=6;
        int m=2;
        ArrayList<Edge> graph[]= new ArrayList[v];
        int color[]= new int[v];
        Arrays.fill(color,-1);
         createGraphForGraphColoringProblem(graph);
        System.out.println("Is this can be colored as m coloring case: "+mColoringProblem(graph,0,v,color,m));











    }




}
