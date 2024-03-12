public class QueueUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class Queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail== null;
        }
        public static void add(int data){
            Node newNode= new Node(data);
            if(tail==null){// if queue is empty
                tail=head=newNode;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front= head.data;
            if(tail==head){// agr single element hua to tail bhi null krna hoga
                tail=null;
            }
            head=head.next;// single ele hoga to bhi head yha automatcally null ho jayega
            return front;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]){
        Queue q= new Queue();
//        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }



    }
}
