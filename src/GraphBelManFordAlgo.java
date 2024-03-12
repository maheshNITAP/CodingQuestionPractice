import java.util.ArrayList;

public class GraphBelManFordAlgo {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.weight=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-10));// change -1 to -10 for -ve weight cycle
    }
    public static void bellmanFordAlgorithm(ArrayList<Edge> graph[],int src,int V){
        int dis[]= new int[V];
        for(int i=0;i<V;i++){
            if(i != src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        for (int k=0;k<V-1;k++){

            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e= graph[i].get(j);
                    int u= e.src;
                    int v= e.dest;
                    int wt=e.weight;
                    if(u!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e= graph[i].get(j);
                int u= e.src;
                int v= e.dest;
                int wt=e.weight;
                if(u!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                    System.out.println("negative weight cycle cycle detected");
                }
            }
        }

        //print src to all nodes distance
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
    }

    public static void main(String args[]){
        int V= 5;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        bellmanFordAlgorithm(graph,0,V);

    }
}
