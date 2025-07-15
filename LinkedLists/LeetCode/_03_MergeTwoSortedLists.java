package LinkedLists.LeetCode;

public class _03_MergeTwoSortedLists {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode (){

        }
        ListNode(int x){
            val=x;
            next=null;
        }

    }

    /*
    Method 1:
        This method uses same concept as of merge part of merge sort in-place.
        We store the smallest starting of the two lists in the head.
        Current node will be initialised automatically in the inner loops with the smallest of the starting nodes of the two lists.
        The inner loops check for smallest of the two nodes and assign the current node with the same.
        When condition fails, cur.next is connected to the node of the other list.
        This process repeats till any of the list ends first with null values.
        The code is written in such a way that even when we encounter null value,
        the cur.next is connected automatically to the node of the other list.
        We can stop the iteration since the remaining list is already sorted and at the end, we return the head.
        All kinds of possible edge cases are handled in the initial part of the code.
    */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    /*
    Method2:
        We take initialise the tail variable with the empty node.
        The while loop runs until any of the list becomes null.
        The tail.next is initialised with the smallest node of the two lists automatically in the first iteration itself.
        The iteration repeats by connecting tail.next with the smallest possible node until that stage along with updating tail.
        When one of the list terminates, the tail.next is connected to the node of the other list which is handled by the last lines.
        The empty lists and the other possible edge cases are automatically handled in the code.
    */

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummyHead=new ListNode();
        ListNode tail=dummyHead;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next=list1;
                tail=tail.next;
                list1=list1.next;
            }else{
                tail.next=list2;
                tail=tail.next;
                list2=list2.next;
            }
        }
        tail.next=list1!=null?list1:list2;
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
