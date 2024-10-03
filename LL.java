package LinkedLists.BasicConcepts;

public class LL {
    Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size++;
    }

    public void insertLast(int value){
        Node node=new Node(value);
        if(tail==null){
            tail=node;
            head=node;
            size++;
            return;
        }
        tail.next=node;
        tail=node;
        size++;
    }

    public void inserLast2(int value){
        Node node=new Node(value);
        Node temp=head;
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        tail=node;
        size++;
    }

    public void add(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        Node node=new Node(value);
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        size++;
    }

    public void insertUsingRecursion(int value,int index){
        helper(value,index,head);
    }
    public void helper(int value,int index,Node temp){
        if(index==1){
            Node node=new Node(value);
            if(tail==temp)
                tail=node;
            node.next=temp.next;
            temp.next=node;
            size++;
            return;
        }
        if(index==0){
            Node node=new Node(value);
            if(head==null){
                head=node;
                tail=node;
                size++;
                return;
            }
            insertFirst(value);
            return;
        }
        helper(value,index-1,temp.next);
    }
    public void insertUsingRecursion2(int value,int index){
        head=helper2(value,index,head);
    }
    public Node helper2(int value,int index,Node temp){
        if(index==0){
            Node node=new Node(value,temp);
            size++;
            return node;
        }
        temp.next=helper2(value,index-1,temp.next);
        return temp;
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("No elements to delete");
            return;
        }
        size--;
        System.out.println(head.value+" is deleted!");
        head=head.next;
        if(head==null)
            tail=null;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("No elements to delete");
            return;
        }
        if(head.next==null){
            deleteFirst();
            return;
        }
        Node temp=head;
        while((temp.next).next!=null){
            temp=temp.next;
        }
        size--;
        System.out.println((temp.next).value+" is deleted!");
        temp.next=null;
        tail=temp;
    }

    public void deleteAtIndex(int index){
        if(index==0){
            deleteFirst();
            return;
        }
        if(index==size-1){
            deleteLast();
            return;
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        size--;
        System.out.println((temp.next).value+" is deleted!");
        temp.next=(temp.next).next;
    }

    public int get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.value;
    }
    public Node getNode(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public Node findNode(int value){
        Node temp=head;
        while(temp!=null){
            if(temp.value==value){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    public void deleteDuplicates(){
        Node node=head;
        while(node.next!=null){
            if(node.value==node.next.value){
                node.next=node.next.next;
                size--;
            }
            else{
                node=node.next;
            }
        }
    }
    public void mergeSortOfLL(Node head){
        Node start=head,end=head;
        while(end!=null && end.next!=null){
            end=end.next;
        }
        mergeSortLL(start,end);
    }
    public void mergeSortLL(Node start, Node end){
        if(start.next==end){
            return;
        }
        Node mid=getMid(start,end);
        int length=lengthRange(start,end);
        Node temp=getNode(length/2-1);
        mergeSortLL(start,temp);
        mergeSortLL(mid,end);
        merge(start,mid);
    }
    public void merge(Node start,Node mid){
        if(start==null){
            return;
        }
        if(mid==null){
            return;
        }
        Node p1=start,p2=mid;
        Node cur=start;
        if(p2.value<=p1.value){
            cur=mid;
        }
        while(p1!=mid && p2!=null){
            if(p1.value<=p2.value){
                while(p1!=mid && p1.value<= p2.value){
                    cur=p1;
                    p1=p1.next;
                }
                cur.next=p2;
                cur=p2;
            }
            else{
                while(p2!=null && p2.value<p1.value){
                    cur=p2;
                    p2=p2.next;
                }
                cur.next=p1;
                cur=p1;
            }
        }
    }
    public Node getMid(Node start,Node end){
        Node fast=start,slow=start;
        while(fast!=end && fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public int lengthRange(Node start,Node end){
        int count=0;
        while(start!=end){
            count++;
            start=start.next;
        }
        return count;
    }
    public void reverseLLUsingRecursion(){
        reverseLLUsingRecursion(head);
    }

    public void reverseLLUsingRecursion(Node node){
       if(node==tail){
           head=tail;
           return;
       }
       reverseLLUsingRecursion(node.next);
       tail.next=node;
       tail=tail.next;
       tail.next=null;
    }

    public void reverseLL(){
        if(head==null){
            return;
        }
        Node prev=null,cur=head,after=head.next;
        tail=head;
        while(after!=null){
            cur.next=prev;
            prev=cur;
            cur=after;
            after=after.next;
        }
        cur.next=prev;
        head=cur;
    }
    public void reversePartOfLL(){
        Node left=getNode(2);
        Node right=getNode(4);
        head=reversePartOfLL(head,left,right);
    }
    public Node reversePartOfLL(Node head,Node left,Node right){
        if(head==null || head.next==null){
            return head;
        }
        if(left==right){
            return head;
        }
        Node temp=head;
        while(temp!=left && temp.next!=left){
            temp=temp.next;
        }
        if(head!=left){
            temp.next=right;
        }
        Node prev=left;
        Node cur=prev.next;
        Node after=cur.next;
        while(cur!=right){
            cur.next=prev;
            prev=cur;
            cur=after;
            after=after.next;
        }
        cur.next=prev;
        left.next=after;
        if(head==left){
            return cur;
        }
        return head;
    }
    public Node getMidNode(Node head){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void reorderList(Node head) {
        if(head==null || head.next==null){
            return;
        }
        Node cur=head,after=head.next;
        Node mid=getMidNode(head);
        Node midCur=mid,midAfter=mid.next;
        Node node=head;
        while(node.next!=mid){
            node=node.next;
        }
        reversePartAndMerge(mid,node);
        while(after!=mid && midAfter!=null){
            cur.next=midCur;
            midCur.next=after;
            cur=after;
            after=after.next;
            midCur=midAfter;
            midAfter=midAfter.next;
        }
        cur.next=midCur;
    }
    public void reversePartAndMerge(Node head, Node node){
        if(head==null)
            return;
        Node prev=null,cur=head,after=head.next;
        tail=head;
        while(after!=null){
            cur.next=prev;
            prev=cur;
            cur=after;
            after=after.next;
        }
        cur.next=prev;
        node.next=cur;
    }
//    public Node reverseKGroup(Node head, int k) {
//        if(k<=1){
//            return head;
//        }
//        int n=length(head);
//        Node prev=null,cur=head,after=cur.next;
//        for(int i=0;i<(n/k);i+=k){
//            Node last=cur;
//            for(int j=0;j<k;j++){
//                cur.next=prev;
//                prev=cur;
//                cur=after;
//                after=after.next;
//            }
//            last.next=cur;
//        }
//        return head;
//    }
    public int length(Node head){
        Node cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        Node x=head;
        while(x!=null){
            System.out.print(x.value + "->");
            x=x.next;
        }
        System.out.println("END");
    }

    public int getSize(){
        return size;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

}
