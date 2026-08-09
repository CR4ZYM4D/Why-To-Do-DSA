/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;

        while(even.next != null && even.next.next != null){

            if(even.next != null){
                odd.next = even.next;
                odd = odd.next;
            }

            if(even.next.next != null){
                even.next = even.next.next;
                even = even.next;
            }

        }

        if(even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = null;
        }

        odd.next = evenHead;

        return head;

    }
}