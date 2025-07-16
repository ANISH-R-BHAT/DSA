package LinkedLists.LeetCode;

public class _04_LinkedListCycle {
    /*
    Thought Process:
        We use two-pointer method(rabbit-tortoise method).
        Take a fast and a slow pointer, move slow one step ahead, fast 2 steps ahead.
        If cycle is present, loop condition never fails and slow and fast will meet at certain point.
        If cycle is not present, loop condition fails and returns false.
    */
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int x){
            val=x;
            next=null;
        }

    }

    public static void main(String[] args) {

    }
}
