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
    
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to always get the node with the smallest value among all lists
        var pq = new PriorityQueue<ListNode>(
            (a, b) -> a.val - b.val
        );

        // Add the head node of each non-empty list to the priority queue
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        // Dummy node simplifies result list construction
        ListNode dummyNode = new ListNode(-1, null);
        ListNode curr = dummyNode;

        // Continuously extract the smallest node and build the merged list
        while (!pq.isEmpty()) {
            curr.next = pq.poll(); // attach smallest node
            curr = curr.next;      // move pointer forward

            // Add next node from the same list to the heap (if present)
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        // Return the merged list (excluding dummy)
        return dummyNode.next;
    }
}