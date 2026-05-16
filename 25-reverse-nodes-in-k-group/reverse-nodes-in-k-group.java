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
        int count = 0;
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

    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode nextNode = null;

        while(temp != null){
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // take the starting node.
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while(temp != null){
            // find the kth node from current temp node.
            ListNode kthNode = findKthNode(temp, k);

            // if kth node is null, then no need to reverse the next nodes, because total nodes are < k, so
            // so just make the next node as next of prev.
            if(kthNode == null){
                prevNode.next = temp;
                break;
            }
            // make the next pointer of kth node.
            nextNode = kthNode.next;
            // make the next of kth node as null, so that we can reverse the list from temp to kth node.
            kthNode.next = null;
            ListNode newHead = reverse(temp);
            // if it is first grp reversal, then just update the head as newHEad.
            if(temp == head){
                head = newHead;
            }
            // if new head is already updated, then just update the newhead as next of prev node. 
            else{
                prevNode.next = newHead;
            }
            //now make the prev node as temp and temp as nextnode for next reversal.
            prevNode = temp;
            temp = nextNode;
        }
        return head; 
    }
}