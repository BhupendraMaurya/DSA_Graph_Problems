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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode findKthNode(ListNode node, int k){

        int count =0;
        ListNode temp = node;
        while(temp != null){
            count++;
            if(count < k){
                temp = temp.next;
            }
            else{
                break;
            }
        }
        return temp;
    }
    // Approach: Reverse whole list, then reverse the first k nodes and then reverse remaining nodes, and then
    // append them and return new head. 
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0){
            return head;
        }
        // first reverse whole linked list.
        ListNode newHead = reverse(head);
        //finding the kth node
        ListNode kthNode = findKthNode(newHead, k);
        ListNode prevNode = null;
        // Storing the next node bcz we want to make the next of kthnode as null, 
        // so that we can reverse the remaining nodes as well. 
        ListNode nextNode = kthNode.next;
        kthNode.next = null;
        // reversing the first k nodes
        ListNode newHead2 = reverse(newHead);
        // storing the prev node so that we can point the next of this list as the next reversed list.
        prevNode = newHead;
        // reversing the remaining nodes.
        ListNode nextHead = reverse(nextNode);
        // appending the both list after reversing. 
        prevNode.next = nextHead;
        return newHead2;

    }
}