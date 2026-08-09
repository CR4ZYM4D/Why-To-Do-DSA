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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode next = head.next;

        while(prev != null && next != null){

            if(prev.val != next.val){
                prev = next;
                next = next.next;
                continue;
            }

            while(next != null && next.val == prev.val){
                next = next.next;
            }
            prev.next = next;
            prev = next;
            if(next!=null)
            next = next.next;
        }
        if(next!=null)
        prev.next = next;

        return head;


    }
}