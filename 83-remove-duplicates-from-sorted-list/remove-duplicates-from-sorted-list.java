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
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        ListNode curr = head;
        while(temp.next != null){
            ListNode nextNode = temp.next;
            if(curr.val == temp.val){
                curr.next = temp.next;
                temp.next = null;
                temp = nextNode;
            }
            else{
                temp = nextNode;
                curr = curr.next;
            }
        }
        if(temp.val == curr.val){
            curr.next = null;
            temp.next = null;
            temp = temp.next;
        }
        return head;
    }
}