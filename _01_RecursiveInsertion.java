package LinkedLists.LeetCode;

public class _01_RecursiveInsertion {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    public static void main(String[] args) {
        ListNode node=null;
        node=insert(node,0,3);
        node=insert(node,1,5);
        node=insert(node,2,9);
        node=insert(node,3,1);
        display(node);
        node=insert(node,3,7);
        display(node);
    }

    private static void display(ListNode node){
        if(node==null){
            System.out.println("EMPTY LIST!");
            return;
        }
        while(node.next!=null){
            System.out.print(node.val+"->");
            node=node.next;
        }
        System.out.println(node.val+"->null");
    }

    public static ListNode insert(ListNode node,int index,int value){
        if(node==null){
            return new ListNode(value);
        }
        if(index==0){
            ListNode temp=new ListNode(value);
            temp.next=node;
            return temp;
        }
        node.next=insert(node.next,index-1,value);
        return node;
    }

    /*
        Thought process:
        The index in the argument actually means the index in which the new node should be inserted.
        So, we need to reach/traverse to the node which is currently present in that index.
        At every recursive call, we need to(yet to) move index times forward to reach that node.
        At every recursive call we are passing index-1 value and node.next in the argument to achieve our goal.
        We are expecting the new node.next since we are inserting new node.
        When index==0, the new node is created and returned to the previous call which is accepted by the node.next of previous call.
        For every other previous calls, the current node is returned back(except for the base condition where new node is returned)
    */
}
