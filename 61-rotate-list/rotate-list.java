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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int size = 0;
        ListNode tail = head;
        while(tail.next != null){
            size++;
            tail = tail.next;
        }
        // adding +1 more in the size as there is one more node in the end.
        size++;
        System.out.println(size);

        k = k % size;
        if(k == 0){
            return head;
        }

        // making the next of tail as head. Now our list has become the circular.
        tail.next = head;

        // Now simply go to the kth position and make the newHead as its next node and then make the next node
        // of tail as null. To break the circular list.
        ListNode newHead = null;
        ListNode newTail = head; // starting from head and going till kth positon.
        for(int i = 1; i < size-k; i++){
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;


    }
}