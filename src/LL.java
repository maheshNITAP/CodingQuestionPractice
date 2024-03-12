public class LL {
    Node head;
    private int size;
    LL(){
        this.size=0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    private void addFirst(String data) {
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    private void addLast(String data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=newNode;
            return;
        }
        Node currentNode =head;
        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }
    private void deleteFirstNode(){
        if(head== null){
            System.out.println("list is empty");
            return;
        }
        size--;
        head=head.next;
    }
    private void deleteLastNode(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode=head.next;
        while (lastNode.next!=null){
            lastNode=lastNode.next;
            secondLastNode=secondLastNode.next;
        }
        secondLastNode.next=null;
    }
    private void printLL(){
        Node currentNode=head;
        while (currentNode != null){
            System.out.print(currentNode.data+"-->");
            currentNode=currentNode.next;
        }
        System.out.println("NULL");
    }
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode= head;
        Node currNode= head.next;
        while (currNode!=null){
            Node nextNode= currNode.next;// fetch next node
            currNode.next=prevNode;// link to previous node

            //
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;// head was pointing to first node if
        head=prevNode;
    }
    public Node recursiveReverseLL(Node head){
        if(head == null || head.next == null){
            return  head;
        }
        Node newHead= recursiveReverseLL(head.next);
        head.next.next=head;
        head.next= null;
        return newHead;
    }
    public Node removeNthNodeFromList(Node head,int n){
        if(head.next==null)
            return null;
        int size=0;
        Node curr=head;
        while (curr!= null){
            curr=curr.next;
            size++;
        }
        if(size== n){
            return head.next;
        }
        int indexToSearch=size-n;
        Node prev=head;
        int i=1;
        while (i<indexToSearch){
            prev= prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;

    }
    public static void main(String args[]){
        LL list = new LL();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addLast("5");
        list.addLast("6");
        list.addLast("7");
        list.addLast("8");

        list.printLL();
//        System.out.println("Size of LL is : "+list.size);
//        list.deleteFirstNode();
//        list.printLL();
//        System.out.println("Size of LL is : "+list.size);
//        list.deleteLastNode();
//        list.printLL();
//        System.out.println("Size of LL is : "+list.size);
//        list.reverseIterate();
//        list.printLL();
//        list.head= list.recursiveReverseLL(list.head);
//        list.printLL();
        list.head= list.removeNthNodeFromList(list.head, 3);
        list.printLL();

    }


}
