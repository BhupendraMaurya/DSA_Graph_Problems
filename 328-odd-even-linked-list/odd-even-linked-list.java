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
        if(head == null){
            return null;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode ans1 = even;
        ListNode ans2 = odd;
        ListNode temp = head;
        int i = 0;
        while(temp != null){
            ListNode newNode = new ListNode(temp.val);
            if(i % 2 == 0){
                even.next = newNode;
                even = even.next;
            }
            else{
                odd.next = newNode;
                odd = odd.next;
            }
            temp = temp.next;
            i++;
        }
        ans1 = ans1.next;
        ans2 = ans2.next;
        even.next = ans2;
        return ans1;


    }
}