package LinkedLists.Questions;

import LinkedLists.BasicConcepts.LL;

import java.util.LinkedList;

public class LLists {
    private ListNode head;
    private ListNode tail;
    private int size=0;
    public void inserLast2(int value){
        ListNode node=new ListNode(value);
        ListNode temp=head;
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
    public void display(){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void deleteDuplicates() {
        ListNode cur=head;
        while(cur!=null){
            int value=cur.val;
            ListNode node=cur;
            while(cur!=null && cur.val==value){
                cur=cur.next;
            }
            node.next=cur;
            if(node.next==null){
                tail=node;
            }
        }
    }
    public void deleteDuplicates2(){
        ListNode node=head;
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next=node.next.next;
                size--;
            }
            else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode p1=list1,p2=list2;
        ListNode cur=p2,head=p2;
        if(p1.val<=p2.val){
            cur=p1;
            head=p1;
        }
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                while(p1!=null && p1.val<=p2.val){
                    cur=p1;
                    p1=p1.next;
                }
                cur.next=p2;
                cur=p2;
            }
            else{
                while(p2!=null && p2.val<=p1.val){
                    cur=p2;
                    p2=p2.next;
                }
                cur.next=p1;
                cur=p1;
            }
        }
        return head;
    }
    public void getHeadTail(){
        System.out.println(head.val+" ->->-> "+tail.val);
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) {
        LLists list1=new LLists();
        list1.inserLast2(1);
        list1.inserLast2(2);
        list1.inserLast2(2);
        list1.inserLast2(2);
        list1.inserLast2(3);
        list1.inserLast2(3);
        list1.inserLast2(4);
        list1.inserLast2(5);
        list1.display();
        list1.deleteDuplicates();
        list1.display();
        list1.getHeadTail();
    }


}
