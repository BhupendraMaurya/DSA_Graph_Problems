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
    public ListNode findKthNode(ListNode node, int k){
        ListNode temp = node;
        int cnt = 0;
        while(temp != null && cnt < k){
            cnt++;

            if(cnt < k){
                temp = temp.next;
            }
            else{
                break;
            }   
        }
        return temp;
    }
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
    /*
    Approach: Try to solve the problem in k steps. Means first reverse k nodes, and then next k nodes and
    in the last if remaining elements are less than k elements, then just leave them as it is. 

    1. First finding the first kth node, and then change its next and prev node. 
    2. Now reverse the grp (from start to kthNode).
    3. and in the last, just change the nodes accordingly.
    4. Please handle the edge cases.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null){
                prevNode.next = temp;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            if(temp == head){
                head = newHead;
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}