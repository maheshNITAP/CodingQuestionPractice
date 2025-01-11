import java.util.ArrayList;
import java.util.List;

public class DisJointSet {
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);//for every node rank will be zero
            parent.add(i);//for every node he on;ly will be his parent in starting
            size.add(1);//for every node size will also be 1 only as it is single node
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

    public void unionBySize(int u,int v){
        int ultP_u=findParent(u);
        int ultP_v=findParent(v);
        if(ultP_u==ultP_v) return;

        if(size.get(ultP_u)<size.get(ultP_v)){
            parent.set(ultP_u,ultP_v);
            size.set(ultP_v,size.get(ultP_u)+size.get(ultP_v));
        }else {
            parent.set(ultP_v,ultP_u);
            size.set(ultP_v,size.get(ultP_u)+size.get(ultP_v));
        }
    }
    public static void main(String args[]){

        //By Union By rank
        DisJointSet dj= new DisJointSet(7);

//        dj.unionByRank(1,2);
//        dj.unionByRank(2,3);
//        dj.unionByRank(4,5);
//        dj.unionByRank(6,7);
//        dj.unionByRank(5,6);
//        if(dj.findParent(3)== dj.findParent(7)){
//            System.out.println("Same Parent");
//        }else {
//            System.out.println("Not Same Parent");
//        }
//        dj.unionByRank(3,7);
//        if(dj.findParent(3)== dj.findParent(7)){
//            System.out.println("Same Parent");
//        }else {
//            System.out.println("Not Same Parent");
//        }

        //DisJoint Set Union By Size
        dj.unionBySize(1,2);
        dj.unionBySize(2,3);
        dj.unionBySize(4,5);
        dj.unionBySize(6,7);
        dj.unionBySize(5,6);
        if(dj.findParent(3)== dj.findParent(7)){
            System.out.println("Same Parent");
        }else {
            System.out.println("Not Same Parent");
        }
        dj.unionBySize(3,7);
        if(dj.findParent(3)== dj.findParent(7)){
            System.out.println("Same Parent");
        }else {
            System.out.println("Not Same Parent");
        }










    }
}
