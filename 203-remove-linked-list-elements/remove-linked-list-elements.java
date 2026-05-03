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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;
        ListNode temp = head;

        while(temp != null){
            if(temp.val != val){
                ListNode node = new ListNode(temp.val);
                curr.next = node;
                curr = curr.next;
            }
            temp = temp.next;
        }
        return newHead.next;
    }
}