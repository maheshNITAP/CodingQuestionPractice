import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphDijkstraAlgo {

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
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    public static class Pair implements Comparable<Pair>{// Pair ke pass koi tarika nhi tha ki dist ke basis pr kese sort kre to sort krne ke liye comparable interface  ko implement kr liya taki ab pare compare ho paye
                                                        //  ab pair ko compare krne ke liye hum compareTo fn ko hum override krte h or define krte h ki kis field ke liye sort krna h
        int node;
        int dist;
        public Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }
        @Override
        public int compareTo(Pair p2){// agr koi new Pair aata h to iss instance ke distance se compare krte h
            return this.dist- p2.dist;// for ascending order sorting return
//            return p2.dist-this.dist;// for descending order
        }
    }
//    O(E+log v)
    public static void dijkstraAlgo(ArrayList<Edge> graph[],int src,int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dis[]= new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[V];
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!vis[curr.node]){
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e= graph[curr.node].get(i);
                    int u= e.src;
                    int v= e.dest;
                    if(dis[u]+e.weight< dis[v]){//relaxation isi ki vjh se sare nodes ki distance update hoti h
                        dis[v]=dis[u]+e.weight;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
        }

        //print shortest distance
        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }

    }

    public static void main(String args[]){
        int V= 6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        dijkstraAlgo(graph,0,V);

    }
}
