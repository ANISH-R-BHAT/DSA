package LinkedLists.LeetCode;

public class _02_RemoveDuplicates {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }

    }

    /*
    Method 1:
     If value of current node equals next node, connect current node to next of next node
    Otherwise, move pointer to next node
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

    /*
    Method 2:
    Store value and node in some variables.
    Iterate till you get node with non-equal value.
    Connect the stored node with the non-equal node.
    Repeat the iteration.
    */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur=head;
        while(cur!=null){
            int value=cur.val;
            ListNode node=cur;
            while(cur!=null && cur.val==value){
                cur=cur.next;
            }
            node.next=cur;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
