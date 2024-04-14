import java.util.*;

public class HeapQuestions {


    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i< arr.length;i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k)
                maxHeap.remove();
        }
        return maxHeap.peek();
    }

    private static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
    private static void kthSortedArray(int[] arr, int k) {
        int j=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minHeap.add(arr[i]);
            if(minHeap.size()>k){
                arr[j]= minHeap.peek();
                j++;
                minHeap.remove();
            }
        }
        while (!minHeap.isEmpty()){
            arr[j]=minHeap.remove();
            j++;
        }
    }

    static class Heap{

        public int connectRopesAtMinCost(int[] arr) {
            PriorityQueue<Integer> minHeap= new PriorityQueue<>();
            int cost=0;
            for(int i=0;i<arr.length;i++){
                minHeap.add(arr[i]);
            }
            while (minHeap.size()>=2){
                int first=minHeap.remove();
                int second= minHeap.remove();
                cost+=first+second;
                minHeap.add(first+second);
            }
            return cost;
        }

        public int sumOfElementBetweenK1thAndK2th(int[] arr, int k1, int k2) {
            int sum=0;
            int k1th=kthSmallestElement(arr,k1);
            int k2th=kthSmallestElement(arr,k2);
            for(int i=0;i<arr.length;i++){
                if(arr[i]>k1 && arr[i]<k2){
                    sum+=arr[i];
                }
            }
            return sum;
        }

        class Pair implements Comparable<Pair> {
            int number;
            int difference;

            Pair(int number,int difference){
                this.number=number;
                this.difference=difference;
            }
            @Override
            public int compareTo(Pair p2){
                return p2.difference-this.difference;//descending order for max heap
            }
        }

        private ArrayList<Integer> kClosestNumber(int[] arr, int k, int x) {
            PriorityQueue<Pair> maxHeap=new PriorityQueue<>();
            ArrayList<Integer> res= new ArrayList<>();
            for(int i=0;i<arr.length-1;i++){
                maxHeap.add(new Pair(arr[i],Math.abs(arr[i]-x)));
                if(maxHeap.size()>k){
                    maxHeap.remove();
                }
            }
            while (!maxHeap.isEmpty()){
                res.add(maxHeap.peek().number);
                maxHeap.remove();
            }
            return res;
        }

        class PairForMinHeap implements Comparable<PairForMinHeap>{
            int number;
            int freq;

            PairForMinHeap(int number,int freq){
                this.number=number;
                this.freq=freq;
            }

            @Override
            public int compareTo(PairForMinHeap p2){
                return this.freq- p2.freq;
            }
        }
        public ArrayList<Integer> topKFrequentNumbers(int[] arr, int k) {
            PriorityQueue<PairForMinHeap> minHeap=new PriorityQueue<>();
            ArrayList<Integer> res= new ArrayList<>();
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int i=0;i<arr.length;i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i])+1);
                }else{
                    map.put(arr[i],1);
                }
            }
            Set<Integer> keySet=map.keySet();
            for(int key:keySet){
                minHeap.add(new PairForMinHeap(key,map.get(key)));
                if(minHeap.size()>k){
                    minHeap.remove();
                }
            }
            while (!minHeap.isEmpty()){
                res.add(minHeap.peek().number);
                minHeap.remove();
            }
            return res;
        }
        static class PairForKClosest implements Comparable<PairForKClosest>{
            int dist;
            int x;
            int y;
            PairForKClosest(int dist,int x,int y){
                this.dist=dist;
                this.x=x;
                this.y=y;
            }

            @Override
            public int compareTo(PairForKClosest p2){
                return p2.dist-this.dist;//ascending order for maxHeap
            }
        }

        public int[][] kClosestPointToOrigin(int[][] arr, int k) {
            PriorityQueue<PairForKClosest> maxHeap=new PriorityQueue<>();
            int n=arr.length;
            int res[][]= new int[k][2];
            for(int i=0;i<n;i++){
                maxHeap.add(new PairForKClosest((arr[i][0]*arr[i][0])+(arr[i][1]*arr[i][1]),arr[i][0],arr[i][1]));
                if(maxHeap.size()>k){
                    maxHeap.remove();
                }
            }
            int i=0;
            while (!maxHeap.isEmpty()){
                PairForKClosest p= maxHeap.remove();
                res[i][0]=p.x;
                res[i][1]=p.y;
                i++;
            }
            return res;
        }

    }
    public static void main(String args[]){
        //Kth smallest element in given array
//        int arr[]={7,10,4,3,20,15,2};
//        int k=3;
//        System.out.println(kthSmallestElement(arr,k));

        //Kth largest element in given array
//        int arr[]={7,10,4,3,20,15};
//        int k=3;
//        System.out.println(kthLargestElement(arr,k));


        //sort a k sorted array

//        int arr[]={6,5,3,2,8,10,9};
//        int k=3;
//        kthSortedArray(arr,k);
//        for (int x:arr){
//            System.out.print(x+ " ");
//        }

        // find the K closest number

//        int arr[]={5,6,7,8,9,10};
//        int k=3;
//        int x=7;
        Heap hp= new Heap();
//        ArrayList<Integer> res= hp.kClosestNumber(arr,k,x);
//        System.out.println(res);

        //top K frequent numbers
//        int arr[]={1,1,1,3,3,2,2,2,2,2,2,4,4,4,4};
//        int k=2;
//        ArrayList<Integer> res= hp.topKFrequentNumbers(arr,k);
//        System.out.println(res);

        //K-closest point to origin
//        int arr[][]={{1,3},{-2,2},{5,8},{0,1}};
//        int k=2;
//        int res[][]= hp.kClosestPointToOrigin(arr,k);
//        for(int i=0;i<res.length;i++){
//            System.out.println("closest point is x : "+res[i][0]+" y :"+res[i][1]);
//        }

        //Connect ropes to the minimum cost
//        int[] arr= {1,2,3,4,5};
//        System.out.println(hp.connectRopesAtMinCost(arr));

        //sum of elements between K1th smallest and k2th smallest
        int arr[]={1,3,12,5,15,11};
        int k1=1;
        int k2=6;
        System.out.println(hp.sumOfElementBetweenK1thAndK2th(arr,k1,k2));




    }



}
