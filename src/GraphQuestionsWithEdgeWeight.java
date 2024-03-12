import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphQuestionsWithEdgeWeight {

    public static int max =999;
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n,int d){
            this.node=n;
            this.cost=d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;// ascending order sorting
        }
        //p2.dist=this.dist---->for disending order
    }
    public static void createGraphForDijkstraAlgo(ArrayList<Edge> graph[]){
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

    public static void createGraphForBellmanFordAlgo(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));
//        graph[1].add(new Edge(1,4,-1));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }

    public static void createGraphForPrimsAlgo(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,4));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,4));
        graph[1].add(new Edge(1,2,2));
        graph[1].add(new Edge(1,4,4));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,1,2));
        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,2,2));
        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,4));
        graph[4].add(new Edge(4,3,4));

    }

    public static void createGraphForTravelingSalesmanProblem(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,20));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,10));

        graph[1].add(new Edge(1,0,20));
        graph[1].add(new Edge(1,2,25));
        graph[1].add(new Edge(1,3,20));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,1,25));
        graph[2].add(new Edge(2,3,15));

        graph[3].add(new Edge(3,2,15));
        graph[3].add(new Edge(3,1,20));
        graph[3].add(new Edge(3,0,10));

    }



    public static void dijkstraAlgo(ArrayList<Edge> graph[],int src,int V){
        boolean vis[]= new boolean[V];
        int dist[]= new int[V];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src,0));
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        while (!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!vis[curr.node]){
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u= e.src;
                    int v= e.dest;
                    if(dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                        pq.add(new Pair(v,dist[v]));
                    }

                }
            }
        }

        //print shortest distance
        for(int x:dist){
            System.out.println(x);
        }
    }

    public static void bellmanFordAlgo(ArrayList<Edge> graph[],int src,int V){
        int dis[]= new int[V];
        for(int i=0;i< dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        for(int k=0;k<V-1;k++){//v-1 times every node pr relaxation perform krna h
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e= graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.weight;
                    if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt < dis[v]){
                        dis[v]=dis[u]+wt;
                    }

                }
            }
        }
        for(int x:dis){
            System.out.println(x);
        }
    }

    public static void floydWarshallAlgo(int graph[][],int v){
        int i,j,k;
        for(k=0;k<v;k++){
            for(i=0;i<v;i++){
                for(j=0;j<v;j++){
                    if(graph[i][k]!= max && graph[k][j]!= max){
                        if(graph[i][k]+graph[k][j]<graph[i][j]){
                            graph[i][j]=graph[i][k]+graph[k][j];
                        }
                    }
                }
            }
        }
        //output
        for(i=0;i<v;i++){
            for(j=0;j<v;j++){
                if(graph[i][j]==max){
                    System.out.print("max"+" ");
                }else {
                    System.out.print(graph[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
    public static void primsAlgo(ArrayList<Edge> graph[],int v,int src){
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        boolean vis[]= new boolean[v];
        pq.add(new Pair(src,0));
        int mnCost=0;
        while (!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                mnCost+= curr.cost;//dist--->cost
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e= graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }
            }

        }
        System.out.println("min cost of mst "+mnCost);

    }

    private static int travelingSalesmanProblem(ArrayList<Edge>[] graph, int curr, int minCost, int currCost, boolean[] vis, int v, int count) {
        vis[curr]= true;
        count++;
        if(count==v){
            if(currCost+graph[curr].get(0).weight<minCost ){
                minCost=currCost+graph[curr].get(0).weight;
            }
            vis[curr]=false;
            count--;
            return minCost;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                 minCost= travelingSalesmanProblem(graph, e.dest, minCost, currCost+e.weight, vis, v, count);
            }
        }
        vis[curr]=false;
        count--;
        return minCost;
    }

    public static void main(String args[]){
        //dijkstra algo
//        int v=6;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForDijkstraAlgo(graph);
//        dijkstraAlgo(graph,0,v);

        //BellmanFord Algo
//        int v=5;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForBellmanFordAlgo(graph);
//        bellmanFordAlgo(graph,0,v);

        //floyd Warshall
//        int v=4;
//        int graph[][] = { { 0, 5, max, 10 },
//            { max, 0, 3, max },
//            { max, max, 0, 1 },
//            { max, max, max, 0 } };
//        floydWarshallAlgo(graph,v);


        //prims algo
//        int v=5;
//        ArrayList<Edge> graph[]= new ArrayList[v];
//        createGraphForPrimsAlgo(graph);
//        primsAlgo(graph,v,0);

        //Travelling salesman Problem
        int v=4;
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraphForTravelingSalesmanProblem(graph);
        boolean vis[]= new boolean[v];
        int minCost=Integer.MAX_VALUE;
        int currCost=0;
        int count=0;
        minCost=travelingSalesmanProblem(graph,0,minCost,currCost,vis,v,count);
        System.out.println("min cost for traveling salesman Problem :"+ minCost);;

    }


}
