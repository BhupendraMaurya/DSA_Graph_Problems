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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = new ListNode(-1);
        ListNode newHead = temp;

        int carry = 0;
        while(temp1 != null && temp2 != null){
            int data = temp1.val + temp2.val + carry;
            ListNode newNode = new ListNode(data % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = data / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null){
            int data = temp1.val + carry;
            ListNode newNode = new ListNode(data % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = data / 10;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            int data = temp2.val + carry;
            ListNode newNode = new ListNode(data % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = data / 10;
            temp2 = temp2.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(1);
            temp.next = newNode;
            temp = temp.next;
            return newHead.next;
        }
        return newHead.next;
    }
}