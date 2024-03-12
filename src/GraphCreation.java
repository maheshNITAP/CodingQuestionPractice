import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphCreation {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
//        public Edge(int s,int d, int w){
//            this.src=s;
//            this.dest=d;
//            this.weight=w;
//        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    public static void printNeighboursOfGivenVertex(ArrayList<Edge> graph[],int v){
//        System.out.print("neighbours Of "+v+" is :");
        for(int i=0;i<graph[v].size();i++){
            Edge e= graph[v].get(i);
            System.out.println("destination: "+e.dest+" ans edge weight"+ e.weight);
        }
    }

    public static void bfs(ArrayList<Edge> graph[],boolean vis[],int start){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int curr= q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for (int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    if(!vis[e.dest]){
                        q.add(e.dest);
                    }
                }
            }

        }

    }
    public static void dfs(ArrayList<Edge> graph[],int currNode, boolean vis[]){
        System.out.print(currNode+" ");
        vis[currNode]=true;
        for(int i=0;i<graph[currNode].size();i++){
            Edge e= graph[currNode].get(i);
            if(vis[e.dest]==false){
                dfs(graph,e.dest,vis);
            }
        }

    }

    //O(V^V)
    public static void findAllPaths(ArrayList<Edge> graph[],int curr, boolean vis[],String path,int src,int dest){
        if(curr== dest){
            System.out.println(path);
            return;
        }
        for(int i=0;i< graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(vis[curr]==false){
                vis[curr]=true;
                findAllPaths(graph,e.dest,vis,path+e.dest,src,dest);
                vis[curr]=false;
            }
        }
    }
    public static void main(String args[]){
        int V=7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        //print neighbours of vertex v
//        printNeighboursOfGivenVertex(graph,2);

        //BFS
//        boolean vis[]= new boolean[V];
//        for(int i=0;i<V;i++){
//            if(vis[i]==false){// for disconnected graph
//                bfs(graph,vis,i);
//            }
//        }

        //DFS
//        boolean vis[]= new boolean[V];
//        for(int i=0;i<V;i++){
//            if(vis[i]==false){// for disconnected graph
//                dfs(graph,i,vis);
//            }
//        }

        boolean vis[]= new boolean[V];
        findAllPaths(graph,0,vis,"0",0,5);
    }
}
