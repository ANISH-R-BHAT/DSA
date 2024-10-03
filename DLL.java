package LinkedLists.BasicConcepts;

public class DLL {
    private Node head;
    private Node tail;
    private int size;
    public DLL(){
        this.size=0;
    }
    public void insertFirst(int value){
        Node node=new Node(value);
        node.prev=null;
        if(head==null){
            node.next=null;
            head=node;
            tail=node;
            size++;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
        size++;
    }

    public void insertLast(int value){
        Node node=new Node(value);
        node.next=null;
        if(head==null){
            insertFirst(value);
            return;
        }
        tail.next=node;
        node.prev=tail;
        tail=node;
        size++;
    }

    public void insertLast2(int value){
        Node node=new Node(value);
        node.next=null;
        if(head==null){
            insertFirst(value);
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        tail=node;
        size++;
    }

    public void insertUsingIndex(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node node=new Node(value);
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        (temp.next).prev=node;
        temp.next=node;
        node.prev=temp;
        size++;

    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void display2(){
        displayUsingRecursion(head);
    }
    public void reverseDisplay(){
        displayUsingRecursion2(head);
    }
    public void displayUsingRecursion(Node temp){
        if(temp==null){
            System.out.println("END");
            return;
        }
        System.out.print(temp.value+" -> ");
        displayUsingRecursion(temp.next);
    }
    public void displayUsingRecursion2(Node temp){
        if(temp==null){
            return;
        }
        displayUsingRecursion2(temp.next);
        System.out.print(temp.value+" ");
    }
    private class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }

    }
}
