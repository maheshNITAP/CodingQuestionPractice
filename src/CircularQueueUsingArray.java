public class CircularQueueUsingArray {
    static class Queue{
        public static int arr[];
        public static int size;
        public static int rear =-1;
        public static int front =-1;
        Queue(int size){
            arr= new int[size];
            this.size= size;
        }
        public static boolean isEmpty(){
            return rear==-1 && front ==-1;
        }
        public static boolean isFull(){
            return (rear+1)% size == front;
        }
        //Enqueue
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            // 1st element add
            if(front==-1){
                front=0;
            }
            rear= (rear+1)%size;
            arr[rear]= data;
        }
        //dequeue
        public static  int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int result= arr[front];
            //if singelelemnt
            if(rear == front){
                rear=front=-1;
            }else {
                front=(front+1)%size;// jese rear ko increase kiya tha vese front ko bhi increase kr denge
            }
            return  result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }
    public static void main(String args[]){
        Queue q= new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q.remove());
        System.out.println(q.remove());
        q.add(7);
        System.out.println(q.remove());
        q.add(8);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
