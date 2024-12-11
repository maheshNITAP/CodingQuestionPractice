import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphFindShortestPath {

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer> graph[]= new ArrayList[n];
        int res[]= new int[queries.length];
        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
            if(i!=n-1)
                graph[i].add(i+1);
        }
        for(int i=0;i<queries.length;i++){
            graph[queries[i][0]].add(queries[i][1]);
            int count[]= new int[1];
            boolean vis[]= new boolean[n];
            res[i]=Integer.MAX_VALUE;
            dfsForShortestPath(0,graph,vis,count,res,i,n);
        }
        return res;
    }

    private static void dfsForShortestPath(int curr, ArrayList<Integer>[] graph, boolean[] vis, int[] count, int[] res, int resIndex, int n) {
        if(curr==n-1){
            res[resIndex]=Math.min(res[resIndex],count[0]);
            return;
        }
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int dest=graph[curr].get(i);
            if(vis[dest]!=true){
                count[0]++;
                dfsForShortestPath(dest, graph, vis, count, res, resIndex, n);
                count[0]--;
            }
        }
        vis[curr]=false;
    }

    public static void main(String args[]){

        int n = 5; // Number of elements

        int[][] queries = {
                {2, 4},
                {0, 2},
                {0, 4}
        };
//        int []res= shortestDistanceAfterQueries( n,queries);
        int []res= shortestDistanceAfterQueries1( n,queries);

        for(int ans:res){
            System.out.print(ans+" ");
        }
    }

    private static int[] shortestDistanceAfterQueries1(int n, int[][] queries) {
        int t=queries.length;
        ArrayList<Integer> graph[]= new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
            if(i!=n-1)
                graph[i].add(i+1);
        }
        int res[]= new int[t];

        for(int i=0;i<queries.length;i++){
            graph[queries[i][0]].add(queries[i][1]);
            res[i]=bfsForShortestPath(graph,n);
        }
        return res;
    }

    private static int bfsForShortestPath(ArrayList<Integer>[] graph, int n) {
        Queue<Integer> queue= new LinkedList<>();
        boolean vis[]= new boolean[n];
        int count=Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int curr=queue.remove();
            if(curr==n-1){
                return count;
            }
            for(int i=0;i<graph[curr].size();i++){
                    int des=graph[curr].get(i);

            }
        }
        return 1;
    }
}
