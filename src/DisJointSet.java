import java.util.ArrayList;
import java.util.List;

public class DisJointSet {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(parent.get(node)==node)
            return node;
        int ultP=findParent(parent.get(node));
        parent.set(node,ultP);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ultP_u=findParent(u);
        int ultP_v=findParent(v);
        if(ultP_v==ultP_u) return;
        if(rank.get(ultP_u)<rank.get(ultP_v)){
            parent.set(ultP_u,ultP_v);
        } else if (rank.get(ultP_v)< rank.get(ultP_u)) {
            parent.set(ultP_v,ultP_u);
        }else{
            parent.set(ultP_v,ultP_u);//index,value
            int rankU=rank.get(ultP_u);
            rank.set(ultP_u,rankU+1);
        }
    }
    public static void main(String args[]){

        //By Union By rank
        DisJointSet dj= new DisJointSet(7);

        dj.unionByRank(1,2);
        dj.unionByRank(2,3);
        dj.unionByRank(4,5);
        dj.unionByRank(6,7);
        dj.unionByRank(5,6);
        if(dj.findParent(3)== dj.findParent(7)){
            System.out.println("Same Parent");
        }else {
            System.out.println("Not Same Parent");
        }
        dj.unionByRank(3,7);
        if(dj.findParent(3)== dj.findParent(7)){
            System.out.println("Same Parent");
        }else {
            System.out.println("Not Same Parent");
        }






    }
}
